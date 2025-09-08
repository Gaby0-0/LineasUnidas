/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author magal
 */
// hereda de Usuario
public class Cliente extends Usuario {
    private int idCliente;
    private String metodoCompra;

    public Cliente(String metodoCompra) {
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

    public String comprarBoleto(Boleto boleto) {
        
        return "Compra de boleto";
    }

    public String cancelarBoleto(Boleto boleto) {
        // Lógica de cancelación
        return "Cancelacion de boleto";
    }

    @Override
    public void registrar() {
        
    }

    @Override
    public void consultarHistorial() {
        
    }
}
