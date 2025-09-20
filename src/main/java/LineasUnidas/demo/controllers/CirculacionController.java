package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CirculacionController {
     @GetMapping("/circulacion")
    public String circulacion() {
        return "circulacion"; 
    }
}
