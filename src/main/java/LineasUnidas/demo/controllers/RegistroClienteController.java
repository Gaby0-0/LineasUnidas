package LineasUnidas.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import LineasUnidas.demo.model.Cliente;
import LineasUnidas.demo.services.ClienteService;
@Controller
public class RegistroClienteController {
    private final ClienteService clienteService;

    public RegistroClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }



    // Mostrar formulario de registro
    @GetMapping("/registro-cliente")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente()); // importante para th:object
        return "registro-cliente";
    }

    @PostMapping("/registro-cliente")
    public String registrarCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttrs) {
        clienteService.registrarCliente(cliente); 
        redirectAttrs.addFlashAttribute("mensaje", "Registro exitoso!");
        return "redirect:/login"; 
    }


        @PostMapping("/login")
    public String loginCliente(
            @RequestParam("correo") String correo,
            @RequestParam("contrasena") String contrasena,
            Model model) {

        // Buscar el cliente por correo (o nombre de usuario)
        Cliente cliente = clienteService.obtenerClientePorCorreo(correo);

        if (cliente != null && cliente.getContrasenia().equals(contrasena)) {
            // Login correcto
            model.addAttribute("cliente", cliente);
            return "redirect:/inicio-gerente"; // Página de bienvenida
        } else {
            // Login fallido
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login"; // Retorna a la página de login
        }
    }
}
