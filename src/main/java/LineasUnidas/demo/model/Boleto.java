/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author gabri
 */


@Entity
@Table(name = "boleto")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private int idBoleto;

    private String estado;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_viaje", nullable = false)
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "taquillero_boleto", 
        joinColumns = @JoinColumn(name = "id_boleto"), 
        inverseJoinColumns = @JoinColumn(name = "id_taquillero")
    )
    private Set<Taquillero> taquilleros = new HashSet<>();


    public Boleto() {}

    public Boleto(String estado, String tipo, Viaje viaje, Cliente cliente) {
        this.estado = estado;
        this.tipo = tipo;
        this.viaje = viaje;
        this.cliente = cliente;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Taquillero> getTaquilleros() {
        return taquilleros;
    }

    public void setTaquilleros(Set<Taquillero> taquilleros) {
        this.taquilleros = taquilleros;
    }

    // ======== Método adicional ========
    public String generarCodigo() {
        return "BOL-" + viaje.getIdViaje() + "-" + tipo.toUpperCase();
    }
}
