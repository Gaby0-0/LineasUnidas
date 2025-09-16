/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

/**
 *
 * @author magal
 */
import jakarta.persistence.*;

@Entity
@Table(name = "conductor")
public class Conductor extends Usuario {
    @Column(name = "id_conductor", nullable = false, unique = true)
    private int idConductor;


    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private HorarioTrabajo horario;

    @Column(name = "permiso", nullable = false)
    private String permiso;

    @OneToOne(mappedBy = "conductor", cascade = CascadeType.ALL)
    private Urvan urvan;

    public Conductor() {
        super();
    }

    public Conductor(int idUsuario, String nombre, String apellidoP, String apellidoM, String telefono,
                     String correo,HorarioTrabajo horario, String permiso) {
        super(idUsuario, nombre, apellidoP, apellidoM, telefono, correo, "Conductor");
        this.idConductor=idUsuario;
        this.horario = horario;
        this.permiso = permiso;
    }
     public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public HorarioTrabajo getHorario() {
        return horario;
    }

    public void setHorario(HorarioTrabajo horario) {
        this.horario = horario;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public Urvan getUrvan() {
        return urvan;
    }

    public void setUrvan(Urvan urvan) {
        this.urvan = urvan;
    }

    @Override
    public void registrar() {
        System.out.println("Conductor registrado: " + nombre);
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Historial del conductor: " + getIdUsuario());
    }
}
