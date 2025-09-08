/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author gabri
 */
public class Boleto {
    private int idBoleto;
    private String estado;
    private String tipo;
    private int idViaje;

    public Boleto(String estado, String tipo, int idViaje) {
        this.estado = estado;
        this.tipo = tipo;
        this.idViaje = idViaje;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public String generarCodigo() {
        return "BOL-" + idViaje + "-" + tipo.toUpperCase();
    }
}
