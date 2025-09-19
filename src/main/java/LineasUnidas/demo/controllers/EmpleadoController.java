package LineasUnidas.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import LineasUnidas.demo.services.ChecadorService;
import LineasUnidas.demo.services.ConductorService;
import LineasUnidas.demo.services.TaquilleroService;

@Controller
public class EmpleadoController {

    private final TaquilleroService taquilleroService;
    private final ConductorService conductorService;
    private final ChecadorService checadorService;

    public EmpleadoController(TaquilleroService taquilleroService, ConductorService conductorService, ChecadorService checadorService) {
        this.taquilleroService = taquilleroService;
        this.conductorService = conductorService;
        this.checadorService = checadorService;
    }

    @GetMapping("/empleados")
    public String empleados() {
        return "empleados"; 
    }
/* 
    @PostMapping("/empleados")
public String registrarEmpleado(@RequestParam String permiso, @ModelAttribute Usuario empleado) {
    Usuario nuevoEmpleado;

    switch (empleado.getRol().toUpperCase()) {
        case "CONDUCTOR":
            nuevoEmpleado = new Conductor();          
            
            nuevoEmpleado.setNombre(empleado.getNombre());
            nuevoEmpleado.setCorreo(empleado.getCorreo());
            nuevoEmpleado.setTelefono(empleado.getTelefono());
            nuevoEmpleado.setApellidoM(empleado.getApellidoM());
            nuevoEmpleado.setApellidoP(empleado.getApellidoP());
            nuevoEmpleado.setNombre(empleado.getNombre());
            ((Conductor) nuevoEmpleado).setPermiso(permiso);
            
            conductorService.crearConductor((Conductor)nuevoEmpleado);
            break;
        case "TAQUILLERO":
            nuevoEmpleado = new Taquillero();
            ((Taquillero) nuevoEmpleado).setCajaAsignada(empleado.getCajaAsignada());
            taquilleroService.crearTaquillero((Taquillero)nuevoEmpleado);
            break;
        default:
            nuevoEmpleado = empleado;
    }
    return "redirect:/empleados/lista";
}

public void datosComunes(Usuario nuevoEmpleado){

    nuevoEmpleado.setNombre(empleado.getNombre());
    nuevoEmpleado.setCorreo(empleado.getCorreo());
    nuevoEmpleado.setTelefono(empleado.getTelefono());
}*/

}
