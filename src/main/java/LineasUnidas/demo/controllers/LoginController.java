package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import LineasUnidas.demo.model.Cliente;
import LineasUnidas.demo.services.ClienteService;

@Controller
public class LoginController {
    private final ClienteService clienteService;

    public LoginController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping("/login")
    public String login() {
        return "login"; 
    }

     @PostMapping("/login")
public String loginCliente(
        @RequestParam("correo") String correo,
        @RequestParam("contrasena") String contrasena,
        Model model,
        RedirectAttributes redirectAttrs) {

    // Buscar el usuario por correo
    Cliente cliente = clienteService.obtenerClientePorCorreo(correo);

    if (cliente == null) {
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }

    // Validar contraseña (texto plano, sin encriptación)
    if (!cliente.getContrasenia().equals(contrasena)) {
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }

    // Login correcto
    model.addAttribute("cliente", cliente);

    // Redirigir según el tipo de usuario
    if ("Gerente".equalsIgnoreCase(cliente.getRol())) {
        return "redirect:/inicio-gerente";
    } else if ("Cliente".equalsIgnoreCase(cliente.getRol())) {
        return "redirect:/inicio-gerente";
    } else {
        redirectAttrs.addFlashAttribute("error", "Tipo de usuario no reconocido");
        return "redirect:/login";
    }
}
}
