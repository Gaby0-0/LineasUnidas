package LineasUnidas.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import LineasUnidas.demo.model.Checador;
import LineasUnidas.demo.model.Conductor;
import LineasUnidas.demo.model.Gerente;
import LineasUnidas.demo.model.HorarioTrabajo;
import LineasUnidas.demo.model.Taquillero;
import LineasUnidas.demo.services.ChecadorService;
import LineasUnidas.demo.services.ConductorService;
import LineasUnidas.demo.services.GerenteService;
import LineasUnidas.demo.services.HorarioTrabajoService;
import LineasUnidas.demo.services.TaquilleroService;
@Controller
public class EmpleadoController {
private final TaquilleroService taquilleroService;
private final HorarioTrabajoService horarioTrabajoService;
private final ConductorService conductorService;
private final GerenteService gerenteService;
private final  ChecadorService checadorService;
    public EmpleadoController(TaquilleroService taquilleroService, 
    HorarioTrabajoService horarioTrabajoService,
    ConductorService conductorService,
    GerenteService gerenteService,
    ChecadorService checadorService) {
        this.taquilleroService = taquilleroService;
        this.horarioTrabajoService = horarioTrabajoService;
        this.conductorService = conductorService;
        this.gerenteService = gerenteService;
        this.checadorService = checadorService;
    }

    @GetMapping("/empleados")
    public String empleados
        (Model model) {
    model.addAttribute("empleado", new Taquillero());
        return "empleados"; 
    }


@PostMapping("/empleados")
public String registrarEmpleado(
        @RequestParam String nombre,
        @RequestParam String apellidoP,
        @RequestParam String apellidoM,
        @RequestParam String telefono,
        @RequestParam String correo,
        @RequestParam String rol,
        @RequestParam(required = false) String permiso,
        @RequestParam(required = false) String contrasenia,
        @RequestParam String horaEntrada,
        @RequestParam String horaSalida,
        @RequestParam List<String> dias
) {
    List<String> horas = new ArrayList();
    horas.add(horaEntrada);
    horas.add(horaSalida);
    
    HorarioTrabajo horarioTrabajo = new HorarioTrabajo(dias,horas);
    horarioTrabajoService.crearHorario(horarioTrabajo);

    if(rol.equalsIgnoreCase("taquillero")){
        Taquillero taqui = new Taquillero(nombre, apellidoP, apellidoM, telefono, correo, rol,horarioTrabajo, contrasenia);
        taquilleroService.crearTaquillero(taqui);
         System.out.println("mensajeRegistro exitoso!");
    }else if(rol.equalsIgnoreCase("conductor")){
        Conductor conductor = new Conductor(nombre, apellidoP, apellidoM, telefono, correo,horarioTrabajo, permiso);
        conductorService.crearConductor(conductor);
         System.out.println("Registro exitoso!");    return "redirect:/empleados";
}else  if (rol.equalsIgnoreCase("gerente")){
    Gerente gerente = new Gerente(nombre, apellidoP, apellidoM, telefono, correo, horarioTrabajo, contrasenia);
        gerenteService.crearGerente(gerente);
         System.out.println("Registro exitoso!");    return "redirect:/empleados";
} else  if (rol.equalsIgnoreCase("checador")){
    Checador checador = new Checador(nombre, apellidoP, apellidoM, telefono, correo, horarioTrabajo, contrasenia);
        checadorService.crearChecador(checador);
         System.out.println("Registro exitoso!");    return "redirect:/empleados";
} 
     return "redirect:/empleados";
}
}