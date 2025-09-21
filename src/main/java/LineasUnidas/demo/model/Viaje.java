/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author magal
 */


@Entity
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViaje;

    private float precio;
    private String disponibilidad;
    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_horario")
    private HorarioViaje horario;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "viaje_urvan",
        joinColumns = @JoinColumn(name = "id_viaje"),
        inverseJoinColumns = @JoinColumn(name = "id_urban")
    )
    private List<Urvan> urbans = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "viaje_ruta",
        joinColumns = @JoinColumn(name = "id_viaje"),
        inverseJoinColumns = @JoinColumn(name = "id_ruta")
    )
    private List<Ruta> rutas = new ArrayList<>();

    @OneToMany(mappedBy = "viaje", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boleto> boletos = new ArrayList<>();

    public Viaje() {}

    public Viaje(int idViaje, float precio, String disponibilidad,String estado, HorarioViaje horario) {
        this.idViaje = idViaje;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.horario = horario;
    }

    public int getIdViaje() { return idViaje; }
    public void setIdViaje(int idViaje) { this.idViaje = idViaje; }

    public float getPrecio() { return precio; }
    public void setPrecio(float precio) { this.precio = precio; }

    public String getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(String disponibilidad) { this.disponibilidad = disponibilidad; }

    public String getEstado(){return estado;}
    public void setEstado(String estado){this.estado=estado;}
    
    public HorarioViaje getHorario() { return horario; }
    public void setHorario(HorarioViaje horario) { this.horario = horario; }

    public List<Urvan> getUrbans() { return urbans; }
    public void setUrbans(List<Urvan> urbans) { this.urbans = urbans; }

    public List<Ruta> getRutas() { return rutas; }
    public void setRutas(List<Ruta> rutas) { this.rutas = rutas; }

    public List<Boleto> getBoletos() { return boletos; }
    public void setBoletos(List<Boleto> boletos) { this.boletos = boletos; }
    
}
