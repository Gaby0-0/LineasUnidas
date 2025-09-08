/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author magal
 */
public class Viaje {
    private int idViaje;
    private float precio;
    private String disponibilidad;
    private HorarioViaje horario;
    private Urvan urban;
    private Ruta ruta;

    public Viaje(int idViaje, float precio, String disponibilidad, HorarioViaje horario, Urvan urban, Ruta ruta) {
        this.idViaje = idViaje;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.horario = horario;
        this.urban = urban;
        this.ruta = ruta;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public HorarioViaje getHorario() {
        return horario;
    }

    public void setHorario(HorarioViaje horario) {
        this.horario = horario;
    }

    public Urvan getUrvan() {
        return urban;
    }

    public void setUrban(Urvan urvan) {
        this.urban = urban;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}