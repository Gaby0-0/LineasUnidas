/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

/**
 *
 * @author magal
 */
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "taquillero")
public class Taquillero extends Usuario {

    @Column(name = "id_empleado", nullable = false, unique = true)
    private int idEmpleado;


    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private HorarioTrabajo horario;
    private String contrasenia;
    @ManyToMany
    @JoinTable(
        name = "taquillero_boleto", 
        joinColumns = @JoinColumn(name = "id_taquillero"),
        inverseJoinColumns = @JoinColumn(name = "id_boleto")
    )
    private Set<Boleto> boletos = new HashSet<>();
    
    public Taquillero() {}

    public Taquillero(int idUsuario, String nombre, String apellidoP, String apellidoM, String telefono,
                      String correo, String cargo, HorarioTrabajo horario) {
        super(idUsuario, nombre, apellidoP, apellidoM, telefono, correo, "Taquillero");
        this.idEmpleado = idUsuario;
        this.horario = horario;
    }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }


    public HorarioTrabajo getHorario() { return horario; }
    public void setHorario(HorarioTrabajo horario) { this.horario = horario; }

    public Set<Boleto> getBoletos() { return boletos; }
    public void setBoletos(Set<Boleto> boletos) { this.boletos = boletos; }

    public String getContrasenia() {return contrasenia;}
    public void setContrasenia(String contrasenia) {this.contrasenia = contrasenia;}



    @Override
    public void registrar() {
        System.out.println("Taquillero registrado: " + nombre);
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Historial del taquillero: " + idEmpleado);
    }
}
