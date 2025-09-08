/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineasunidas;

/**
 *
 * @author magal
 */
public abstract class Usuario {
    protected int idUsuario;
    protected String nombre;
    protected String apellidoP;
    protected String apellidoM;
    protected String telefono;
    
    public abstract void registrar();
    public abstract void consultarHistorial();
    
    
}
