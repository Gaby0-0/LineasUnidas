package LineasUnidas.demo.model;

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

    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private HorarioTrabajo horario;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @ManyToMany
    @JoinTable(
        name = "taquillero_boleto",
        joinColumns = @JoinColumn(name = "id_taquillero"),
        inverseJoinColumns = @JoinColumn(name = "id_boleto")
    )
    private Set<Boleto> boletos = new HashSet<>();

    public Taquillero() {}

    public Taquillero(String nombre, String apellidoP, String apellidoM, String telefono,
                      String correo, String cargo, HorarioTrabajo horario, String contrasenia) {
        super(nombre, apellidoP, apellidoM, telefono, correo, cargo);
        this.horario = horario;
        this.contrasenia = contrasenia;
    }

    // Getters y setters
    public HorarioTrabajo getHorario() {
        return horario;
    }

    public void setHorario(HorarioTrabajo horario) {
        this.horario = horario;
    }

    public Set<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(Set<Boleto> boletos) {
        this.boletos = boletos;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // Métodos abstractos de Usuario
    @Override
    public void registrar() {
        System.out.println("Taquillero registrado: " + getNombre());
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Historial del taquillero: " + getIdUsuario());
    }
}
