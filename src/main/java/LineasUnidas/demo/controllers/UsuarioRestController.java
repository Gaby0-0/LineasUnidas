package LineasUnidas.demo.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LineasUnidas.demo.model.Usuario;
import LineasUnidas.demo.services.UsuarioService;
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/usuarios/no-clientes")
    public List<Usuario> getUsuariosNoClientes() {
        return usuarioService.listarUsuarios().stream()
                .filter(u -> !"Cliente".equalsIgnoreCase(u.getRol()))
                .toList(); // Java 16+, si es versión anterior usa collect(Collectors.toList())
    }

    // También podrías usar parámetro query: /api/usuarios?exclude=Cliente
    @GetMapping("/filter")
    public List<Usuario> getUsuariosFiltrados(@RequestParam String exclude) {
        return usuarioService.listarUsuarios().stream()
                .filter(u -> !exclude.equalsIgnoreCase(u.getRol()))
                .toList();
    }
}