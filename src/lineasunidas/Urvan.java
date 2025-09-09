/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author magal
 */
public class Urvan {
    private int idUrban;
    private String matricula;
    private int capacidad;
    private Conductor conductor;

    public Urvan(int idUrban, String matricula, int capacidad, Conductor conductor) {
        this.idUrban = idUrban;
        this.matricula = matricula;
        this.capacidad = capacidad;
        this.conductor=conductor;
    }

    public int getIdUrban() {
        return idUrban;
    }

    public void setIdUrban(int idUrban) {
        this.idUrban = idUrban;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}