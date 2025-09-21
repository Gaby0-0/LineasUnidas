package LineasUnidas.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import LineasUnidas.demo.model.Boleto;
import LineasUnidas.demo.model.Cliente;
import LineasUnidas.demo.model.Ruta;
import LineasUnidas.demo.model.Viaje;
import LineasUnidas.demo.repositories.RutaRepository;
import LineasUnidas.demo.services.BoletoService;
import LineasUnidas.demo.services.ClienteService;
import LineasUnidas.demo.services.ViajeService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteController {

    private final ClienteService clienteService;
    private final RutaRepository rutaRepository;
    private final ViajeService viajeService;
    private final BoletoService boletoService;

    public ClienteController(ClienteService clienteService, 
                             RutaRepository rutaRepository,
                             ViajeService viajeService,
                             BoletoService boletoService) {
        this.clienteService = clienteService;
        this.rutaRepository = rutaRepository;
        this.viajeService = viajeService;
        this.boletoService = boletoService;
    }

    // 📌 Vista principal de usuario
    @GetMapping("/usuario")
    public String mostrarFormulario(Model model, HttpSession session) {
        Integer clienteId = (Integer) session.getAttribute("clienteId");

        if (clienteId == null) {
            model.addAttribute("mensajeError", "Cliente no encontrado en sesión");
            return "usuario";
        }

        Cliente cliente = clienteService.obtenerClientePorId(clienteId);
        if (cliente == null) {
            model.addAttribute("mensajeError", "Cliente no encontrado");
            return "usuario";
        }

        List<Ruta> rutas = rutaRepository.findAll();
        List<Viaje> viajes = viajeService.findAllWithRutasAndHorario();
        List<Boleto> boletos = boletoService.findByClienteIdWithViajeInfo(cliente.getIdUsuario());

        model.addAttribute("cliente", cliente);
        model.addAttribute("rutas", rutas);
        model.addAttribute("viajes", viajes);
        model.addAttribute("boletos", boletos);

        // Inicializar un boleto vacío para el form
        Boleto boleto = new Boleto();
        boleto.setCliente(cliente);
        model.addAttribute("boleto", boleto);

        return "usuario";
    }

    // 📌 Actualizar datos del cliente
    @PostMapping("/usuario")
    public String actualizarCliente(@ModelAttribute("cliente") Cliente clienteForm,
                                    HttpSession session,
                                    Model model) {
        Integer clienteId = (Integer) session.getAttribute("clienteId");

        if (clienteId == null) {
            model.addAttribute("mensajeError", "Cliente no encontrado en sesión");
            return "usuario";
        }

        Cliente clienteExistente = clienteService.obtenerClientePorId(clienteId);

        if (clienteExistente != null) {
            clienteExistente.setNombre(clienteForm.getNombre());
            clienteExistente.setApellidoP(clienteForm.getApellidoP());
            clienteExistente.setApellidoM(clienteForm.getApellidoM());
            clienteExistente.setTelefono(clienteForm.getTelefono());
            clienteExistente.setCorreo(clienteForm.getCorreo());

            clienteService.registrarCliente(clienteExistente);

            model.addAttribute("cliente", clienteExistente);
            model.addAttribute("mensajeExito", "Datos actualizados correctamente");
        } else {
            model.addAttribute("mensajeError", "Cliente no encontrado");
        }

        model.addAttribute("rutas", rutaRepository.findAll());
        model.addAttribute("viajes", viajeService.findAllWithRutasAndHorario());
        model.addAttribute("boletos", boletoService.findByClienteIdWithViajeInfo(clienteId));

        Boleto boleto = new Boleto();
        boleto.setCliente(clienteExistente);
        model.addAttribute("boleto", boleto);

        return "usuario";
    }

    // 📌 Reservar boleto
    @PostMapping("/reservar")
    public String reservarBoleto(@RequestParam("id_viaje") Integer idViaje,
                                 @RequestParam("tipo") String tipo,
                                 @RequestParam("id_cliente") Integer idCliente,
                                 RedirectAttributes redirectAttributes) {
        
        try {
            Viaje viaje = viajeService.findById(idViaje);
            Cliente cliente = clienteService.obtenerClientePorId(idCliente);

            if (viaje == null || cliente == null) {
                redirectAttributes.addFlashAttribute("mensajeError", "Viaje o cliente no encontrado");
                return "redirect:/usuario";
            }

            Boleto boleto = new Boleto();
            boleto.setEstado("Reservado");
            boleto.setTipo(tipo);
            boleto.setViaje(viaje);
            boleto.setCliente(cliente);

            boletoService.guardarBoleto(boleto);

            redirectAttributes.addFlashAttribute("mensajeExito", "¡Boleto reservado exitosamente!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensajeError", "Error al reservar: " + e.getMessage());
        }

        return "redirect:/usuario";
    }
}
