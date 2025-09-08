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
    
    public Usuario(int idUsuario, String nombre, String apellidoP, String apellidoM, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
    }
    public abstract void registrar();
    public abstract void consultarHistorial();
    
    
}
