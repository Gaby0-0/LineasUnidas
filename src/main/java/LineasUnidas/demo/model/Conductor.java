/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

/**
 *
 * @author magal
 */
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "conductor")
public class Conductor extends Usuario {



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

    public Conductor( String nombre, String apellidoP, String apellidoM, String telefono,
                     String correo,HorarioTrabajo horario, String permiso) {
        super( nombre, apellidoP, apellidoM, telefono, correo, "Conductor");
        this.horario = horario;
        this.permiso = permiso;
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
