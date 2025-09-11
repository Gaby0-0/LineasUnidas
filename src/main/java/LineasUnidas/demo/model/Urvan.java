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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "urvan")
public class Urvan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUrban;

    private String placa;
    private int capacidad;

    @ManyToMany(mappedBy = "urbans")
    private List<Viaje> viajes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conductor")  
    private Conductor conductor;

    public Urvan() {}

    public Urvan(int idUrban, String placa, int capacidad, Conductor conductor) {
        this.idUrban = idUrban;
        this.placa = placa;
        this.capacidad = capacidad;
        this.conductor = conductor;
    }

    
    public int getIdUrban() { return idUrban; }
    public void setIdUrban(int idUrban) { this.idUrban = idUrban; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public List<Viaje> getViajes() { return viajes; }
    public void setViajes(List<Viaje> viajes) { this.viajes = viajes; }

    public Conductor getConductor() { return conductor; }
    public void setConductor(Conductor conductor) { this.conductor = conductor; }
}
