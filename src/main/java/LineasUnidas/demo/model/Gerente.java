/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

import jakarta.persistence.Column;

/**
 *
 * @author magal
 */


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gerente")
public class Gerente extends Usuario {

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;
    
    public Gerente() {}
    public Gerente( String nombre, String apellidoP, String apellidoM, String telefono, String correo) {
        super( nombre, apellidoP, apellidoM, telefono, correo, "Gerente");
       
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
}
