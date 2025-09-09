/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author magal
 */
//hereda de Usuario
public class Taquillero extends Usuario {
    private int idTaquillero;
    private HorarioTrabajo horario;

    public Taquillero(int idTaquillero, String nombre, String apellidoP, String apellidoM, String telefono, HorarioTrabajo horario) {
        super(idTaquillero, nombre, apellidoP, apellidoM, telefono);
        this.idTaquillero = idTaquillero;
        this.horario = horario;
    }
    public void setIdTaquillero(int idTaquillero) {
        this.idTaquillero = idTaquillero;
    }

    public int getIdTaquillero() {
        return idTaquillero;
    }

   

    public void setHorario(HorarioTrabajo horario) {
        this.horario = horario;
    }

    public HorarioTrabajo getHorario() {
        return horario;
    }

    @Override
    public void registrar() {
        System.out.println("Taquillero registrado: " + nombre);
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Historial del taquillero: " + idTaquillero);
    }
}
