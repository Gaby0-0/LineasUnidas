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
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "taquillero")
public class Taquillero extends Usuario {

    @Column(name = "id_empleado", nullable = false, unique = true)
    private int idEmpleado;

    private String cargo;

    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private HorarioTrabajo horario;

    @ManyToMany
    @JoinTable(
        name = "taquillero_boleto", 
        joinColumns = @JoinColumn(name = "id_taquillero"),
        inverseJoinColumns = @JoinColumn(name = "id_boleto")
    )
    private Set<Boleto> boletos = new HashSet<>();

    public Taquillero() {}

    public Taquillero(int idUsuario, String nombre, String apellidoP, String apellidoM, String telefono,
                      int idEmpleado, String cargo, HorarioTrabajo horario) {
        super(idUsuario, nombre, apellidoP, apellidoM, telefono);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.horario = horario;
    }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public HorarioTrabajo getHorario() { return horario; }
    public void setHorario(HorarioTrabajo horario) { this.horario = horario; }

    public Set<Boleto> getBoletos() { return boletos; }
    public void setBoletos(Set<Boleto> boletos) { this.boletos = boletos; }

    @Override
    public void registrar() {
        System.out.println("Taquillero registrado: " + nombre);
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Historial del taquillero: " + idEmpleado);
    }
}
