/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gerente")
public class Gerente extends Usuario {

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;
    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private HorarioTrabajo horario;
    public Gerente() {}

    public Gerente( String nombre, String apellidoP, String apellidoM, String telefono, String correo, HorarioTrabajo horarioTrabajo, String contrasenia) {
        super( nombre, apellidoP, apellidoM, telefono, correo, "Gerente");
        this.contrasenia =  contrasenia;
        this.horario= horarioTrabajo;
    }


    public String getContrasenia() {
        return contrasenia;
    }


    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public void registrar() {
        System.out.println("Registrando gerente: " + getNombre());
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Consultando historial del gerente: " + getNombre());
    }

    public String habilitarEmpleado(int idUsuario) {
        return "Empleado " + idUsuario + " habilitado.";
    }

    public String deshabilitarEmpleado(int idUsuario) {
        return "Empleado " + idUsuario + " deshabilitado.";
    }

    public String habilitarUrvan(int idUrván) {
        return "Urván " + idUrván + " habilitada.";
    }

    public String deshabilitarUrvan(int idUrván) {
        return "Urván " + idUrván + " deshabilitada.";
    }

    public HorarioTrabajo getHorario() {
    return horario;
}

public void setHorario(HorarioTrabajo horario) {
    this.horario = horario;
}
}
