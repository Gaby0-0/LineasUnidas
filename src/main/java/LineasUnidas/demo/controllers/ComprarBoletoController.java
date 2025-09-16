package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ComprarBoletoController {


    @GetMapping("/boleto")
    public String boleto() {
        return "boleto"; 
    }

}
