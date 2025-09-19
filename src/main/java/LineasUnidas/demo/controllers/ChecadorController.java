package LineasUnidas.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import LineasUnidas.demo.model.Checador;
import LineasUnidas.demo.services.ChecadorService;
@Controller
public class ChecadorController {
    @Autowired
    private ChecadorService checadorService; 

    @GetMapping("/checador/{id}")
    public String verPerfil(@PathVariable int id, Model model) {
        Checador checador = checadorService.obtenerChecadorPorId(id);
        model.addAttribute("checador", checador);
        return "checador";
    }

    @PostMapping("/editar/checador{id}")
    public String editarPerfil(@PathVariable int id, @ModelAttribute Checador checador) {
        checador.setIdUsuario(id);
        checadorService.actualizarChecador(checador);
        return "redirect:/checador/" + id;
    }

}