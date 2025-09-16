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
@Table(name = "cliente")
public class Cliente extends Usuario {

    @Column(name = "id_cliente", nullable = false, unique = true)
    private int idCliente;

    @Column(name = "metodo_compra")
    private String metodoCompra;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boleto> boletos = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(int idUsuario, String nombre, String apellidoP, String apellidoM, String telefono, String correo, String metodoCompra) {
        super(idUsuario, nombre, apellidoP, apellidoM, telefono, correo, "Cliente");
        this.idCliente = idUsuario;
        this.metodoCompra = metodoCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getMetodoCompra() {
        return metodoCompra;
    }

    public void setMetodoCompra(String metodoCompra) {
        this.metodoCompra = metodoCompra;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public String comprarBoleto(Boleto boleto) {
        boletos.add(boleto);
        boleto.setCliente(this);
        return "Compra de boleto realizada";
    }

    public String cancelarBoleto(Boleto boleto) {
        boletos.remove(boleto);
        boleto.setCliente(null);
        return "Cancelación de boleto realizada";
    }

    @Override
    public void registrar() {
        System.out.println("Cliente registrado: " + nombre);
    }

    @Override
    public void consultarHistorial() {
        System.out.println("Historial de boletos para el cliente: " + nombre);
        boletos.forEach(b -> System.out.println("Boleto ID: " + b.getIdBoleto()));
    }
}
