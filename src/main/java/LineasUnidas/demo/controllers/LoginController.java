package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import LineasUnidas.demo.model.Checador;
import LineasUnidas.demo.model.Cliente;
import LineasUnidas.demo.model.Gerente;
import LineasUnidas.demo.model.Taquillero;
import LineasUnidas.demo.services.ChecadorService;
import LineasUnidas.demo.services.ClienteService;
import LineasUnidas.demo.services.GerenteService;
import LineasUnidas.demo.services.TaquilleroService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final ClienteService clienteService;
    private final GerenteService gerenteService;
    private final  ChecadorService checadorService;
    private final TaquilleroService taquilleroService;

    public LoginController(ClienteService clienteService, 
    GerenteService gerenteService,
    ChecadorService checadorService, 
    TaquilleroService taquilleroService) {
        this.clienteService = clienteService;
        this.checadorService = checadorService;
        this.taquilleroService =taquilleroService;
        this.gerenteService = gerenteService;
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
        RedirectAttributes redirectAttrs,HttpSession session) {

    // Buscar el usuario por correo
    Cliente cliente = clienteService.obtenerClientePorCorreo(correo);
    Gerente gerente = gerenteService.buscarPorCorreo(correo);
    Taquillero taquillero = taquilleroService.buscarPorCorreo(correo);
    Checador checador = checadorService.buscarPorCorreo(correo);

    if (cliente == null && taquillero == null 
    && gerente == null && checador == null) {
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }
 




        if (cliente != null) {
    if (!cliente.getContrasenia().equals(contrasena)) {
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }

    // Guardar el ID del cliente en sesión
    session.setAttribute("clienteId", cliente.getIdUsuario());

    model.addAttribute("cliente", cliente);
    if ("Cliente".equalsIgnoreCase(cliente.getRol())) {
        return "redirect:/usuario";
    } 


           
        } else if (taquillero != null) {
            
            if (!taquillero.getContrasenia().equals(contrasena)) {
                model.addAttribute("error", "Usuario o contraseña incorrectos");
                return "login";
            }

            model.addAttribute("taquillero", taquillero);
            if ("Taquillero".equalsIgnoreCase(taquillero.getRol())) {
                return "redirect:/taquillero";
             } 
        } else if (gerente != null) {
            if (!gerente.getContrasenia().equals(contrasena)) {
                model.addAttribute("error", "Usuario o contraseña incorrectos");
                return "login";
            }
            model.addAttribute("gerente", gerente);
             if ("Gerente".equalsIgnoreCase(gerente.getRol())) {
             return "redirect:/inicio-gerente";}

        } else if (checador != null) {
           
            if (!checador.getContrasenia().equals(contrasena)) {
                model.addAttribute("error", "Usuario o contraseña incorrectos");
                return "login";
            }

            
             model.addAttribute("checador", checador);

             if ("checador".equalsIgnoreCase(checador.getRol())) {
             return "redirect:/checador";}

             
        }
        redirectAttrs.addFlashAttribute("error", "Tipo de usuario no reconocido");
        return "redirect:/login";
}
}
