/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author magal
 */
//hereda de Usuario
public class Empleado extends Usuario {
    private int idEmpleado;
    private String cargo;
    private Horario horario;

    public Empleado(String cargo, Horario horario) {
        this.cargo = cargo;
        this.horario = horario;
    }

    public int getIdEmpleado() { 
        return idEmpleado; 
    }

    public String getCargo() { 
        return cargo; 
    }
    public void setCargo(String cargo) { 
        this.cargo = cargo; 
    }

    public Horario getHorario() { 
        return horario; 
    }
    public void setHorario(Horario horario) {
        this.horario = horario; 
    }

    public String validarCancelacion(Boleto boleto) {
        
        return "Validacion de cancelacion";
    }

    @Override
    public void registrar() {
        
    }

    @Override
    public void consultarHistorial() {
       
    }
}
