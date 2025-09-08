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
    private int idEmpleado;
    private String cargo;
    private HorarioTrabajo horario;

    public Taquillero(int idUsuario, String nombre, String apellidoP, String apellidoM, String telefono,
                      int idEmpleado, String cargo, HorarioTrabajo horario) {
        super(idUsuario, nombre, apellidoP, apellidoM, telefono);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.horario = horario;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
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
        System.out.println("Historial del taquillero: " + idEmpleado);
    }
}
