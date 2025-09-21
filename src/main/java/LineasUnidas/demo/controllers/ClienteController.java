package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import LineasUnidas.demo.model.Cliente;
import LineasUnidas.demo.services.ClienteService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Mostrar formulario del cliente
    @GetMapping("/usuario")
    public String mostrarFormulario(Model model, HttpSession session) {
        Integer clienteId = (Integer) session.getAttribute("clienteId");

        if (clienteId == null) {
            model.addAttribute("mensajeError", "Cliente no encontrado en sesión");
            return "usuario"; // tu vista
        }

        Cliente cliente = clienteService.obtenerClientePorId(clienteId);
        if (cliente == null) {
            model.addAttribute("mensajeError", "Cliente no encontrado");
            return "usuario";
        }

        model.addAttribute("cliente", cliente);
        return "usuario";
    }

    // Actualizar información del cliente
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
            // Actualizar solo los campos del formulario
            clienteExistente.setNombre(clienteForm.getNombre());
            clienteExistente.setApellidoP(clienteForm.getApellidoP());
            clienteExistente.setApellidoM(clienteForm.getApellidoM());
            clienteExistente.setTelefono(clienteForm.getTelefono());
            clienteExistente.setCorreo(clienteForm.getCorreo());
            

            clienteService.registrarCliente(clienteExistente); // guardar cambios
            model.addAttribute("cliente", clienteExistente);
            model.addAttribute("mensajeExito", "Datos actualizados correctamente");
        } else {
            model.addAttribute("mensajeError", "Cliente no encontrado");
        }

        return "usuario";
    }
}
