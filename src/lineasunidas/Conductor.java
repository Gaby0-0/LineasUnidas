/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author magal
 */
public class Conductor extends Usuario {
    private int idConductor;
    private HorarioTrabajo horario;
    private String permiso;

    public Conductor(int idUsuario, String nombre, String apellidoP, String apellidoM, String telefono,
                     int idConductor, HorarioTrabajo horario, String permiso) {
        super(idUsuario, nombre, apellidoP, apellidoM, telefono);
        this.idConductor = idConductor;
        this.horario = horario;
        this.permiso = permiso;
    }

    public int getIdConductor() {
        return idConductor;
    }
    public void setIdConductor(int idConductor) {
        this.idConductor=idConductor;
    }

    public void setHorario(HorarioTrabajo horario) {
        this.horario = horario;
    }

    public HorarioTrabajo getHorario() {
        return horario;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getPermiso() {
        return permiso;
    }

    @Override
    public void registrar() {
        System.out.println("Conductor registrado: " + nombre);
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Historial del conductor: " + idConductor);
    }
}
