/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

/**
 *
 * @author magal
 */

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "checador")
public class Checador extends Usuario {


    @ManyToOne
    @JoinColumn(name = "id_horario")
    private HorarioTrabajo horario;

    public Checador() {}

    public Checador( String nombre, String apellidoP, String apellidoM,
                    String telefono, String correo, HorarioTrabajo horario) {
        super( nombre, apellidoP, apellidoM, telefono, correo, "Checador");
        
        this.horario = horario;
    }


    public HorarioTrabajo getHorario() {
        return horario;
    }

    public void setHorario(HorarioTrabajo horario) {
        this.horario = horario;
    }

    
    @Override
    public void registrar() {
        System.out.println("Registrando checador: " + getNombre());
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Consultando historial del checador: " + getNombre());
    }

    public void actualizarEstadoViaje(int idViaje, String disponibilidad, String estado) {
        System.out.println("Viaje " + idViaje + " actualizado con disponibilidad=" + disponibilidad + " y estado=" + estado);
    }
}
