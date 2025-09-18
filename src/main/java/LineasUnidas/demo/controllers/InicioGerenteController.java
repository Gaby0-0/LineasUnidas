package LineasUnidas.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class InicioGerenteController {

 @GetMapping("/gerente")
    public String gerente() {
        return "inicio-gerente"; 
    }
}
