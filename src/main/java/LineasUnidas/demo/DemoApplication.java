package LineasUnidas.demo;

import LineasUnidas.demo.services.HorarioTrabajoService;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
          ApplicationContext context = SpringApplication.run(DemoApplication.class);
       
          /*HorarioTrabajoService servicio = context.getBean(HorarioTrabajoService.class);
         servicio.crearHorario(
        List.of("Lunes", "Martes","Miércoles"), 
           List.of("11:00-18:00")
               );

        System.out.println("Horario insertado!");*/
        }
}
