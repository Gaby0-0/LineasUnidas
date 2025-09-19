package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViajeController {

 @GetMapping("/viaje")
    public String viaje() {
        return "viaje"; 
    }
}
