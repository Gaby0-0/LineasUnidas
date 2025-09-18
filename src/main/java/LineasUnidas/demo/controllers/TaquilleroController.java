package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TaquilleroController {


    @GetMapping("/taquillero")
    public String taquillero() {
        return "taquillero"; 
    }

}