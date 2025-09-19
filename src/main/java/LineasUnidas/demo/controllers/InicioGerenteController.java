package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioGerenteController {

 @GetMapping("/inicio-gerente")
    public String gerente() {
        return "inicio-gerente"; 
    }




    
}
