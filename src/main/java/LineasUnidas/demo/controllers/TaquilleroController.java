package LineasUnidas.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import LineasUnidas.demo.model.Taquillero;
import LineasUnidas.demo.services.TaquilleroService;
import org.springframework.ui.Model;

@Controller
public class TaquilleroController {
    @Autowired
    private TaquilleroService taquilleroService; 

    @GetMapping("/taquillero/{id}")
public String verPerfil(@PathVariable int id, Model model) {
    Taquillero taquillero = taquilleroService.obtenerTaquilleroPorId(id);
    if (taquillero == null) {
        return "redirect:/error"; // o mostrar mensaje de error
    }
    model.addAttribute("taquillero", taquillero);
    return "taquillero";
}


    @PostMapping("/editar{id}")
    public String editarPerfil(@PathVariable int id, @ModelAttribute Taquillero taquillero) {
        taquillero.setIdUsuario(id);
        taquilleroService.actualizarTaquillero(taquillero);
        return "redirect:/taquillero/" + id;
    }

}