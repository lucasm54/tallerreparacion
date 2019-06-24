/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerreparacion;

/**
 *
 * @author Lucas
 */
public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String dni;
    private String domicilio;
    private String celular;
    
    
    ///contructor

    public Cliente(int idCliente, String nombreCliente, String dni, String domicilio, String celular) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
    }

    public Cliente(String nombreCliente, String dni, String domicilio, String celular) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
    }

    public Cliente() {
    }
    
    ///metodos

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
         
            
    
    
    
    
}
