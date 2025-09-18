package LineasUnidas.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RegistroClienteController {

    @GetMapping("/registro-cliente")
    public String registroCliente() {
        return "registro-cliente"; 
    }
  
}
