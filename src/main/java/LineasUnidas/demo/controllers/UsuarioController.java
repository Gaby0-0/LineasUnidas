package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UsuarioController {
 @GetMapping("/usuario")
    public String checador() {
        return "usuario"; 
    }
}
