/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author magal
 */
public class HorarioTrabajo {
    private int idHorario;
    private String[] dias;
    private String[] horas;

    public HorarioTrabajo(String[] dias, String[] horas) {
        this.dias = dias;
        this.horas = horas;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setDias(String[] dias) {
        this.dias = dias;
    }

    public String[] getDias() {
        return dias;
    }

    public void setHoras(String[] horas) {
        this.horas = horas;
    }

    public String[] getHoras() {
        return horas;
    }
}
