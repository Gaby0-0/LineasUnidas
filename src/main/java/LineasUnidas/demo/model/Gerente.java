/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

/**
 *
 * @author magal
 */


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gerente")
public class Gerente extends Usuario {

    @Column(name = "id_gerente", nullable = false, unique = true)
    private int idGerente;
    
    public Gerente() {}

    public Gerente(int idUsuario, String nombre, String apellidoP, String apellidoM, String telefono, String correo) {
        super(idUsuario, nombre, apellidoP, apellidoM, telefono, correo, "Gerente");
        this.idGerente = idUsuario;
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
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
