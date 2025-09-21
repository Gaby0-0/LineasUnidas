/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private BigDecimal precio;

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

    public Boleto(String estado, String tipo, BigDecimal precio, Viaje viaje, Cliente cliente) {
        this.estado = estado;
        this.tipo = tipo;
        this.precio = precio;
        this.viaje = viaje;
        this.cliente = cliente;
    }

    // Getters y setters
    public int getIdBoleto() { return idBoleto; }
    public void setIdBoleto(int idBoleto) { this.idBoleto = idBoleto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Viaje getViaje() { return viaje; }
    public void setViaje(Viaje viaje) { this.viaje = viaje; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Set<Taquillero> getTaquilleros() { return taquilleros; }
    public void setTaquilleros(Set<Taquillero> taquilleros) { this.taquilleros = taquilleros; }

    // Método adicional
    public String generarCodigo() {
        if (viaje == null || tipo == null) return null;
        return "BOL-" + viaje.getIdViaje() + "-" + tipo.toUpperCase();
    }

    public int getIdViaje() {
        return viaje != null ? viaje.getIdViaje() : 0;
    }

    public void setIdViaje(int idViaje) {
        if (viaje == null) viaje = new Viaje();
        viaje.setIdViaje(idViaje);
    }
}
