/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Lucas
 */
public class Cliente {
    private int idCliente;
    private String nombre_Cliente;
    private String dni;
    private String domicilio;
    private String celular;

    public String toString() {
        return idCliente + " " + nombre_Cliente; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    ///contructor

    public Cliente(int idCliente, String nombreCliente, String dni, String domicilio, String celular) {
        this.idCliente = idCliente;
        this.nombre_Cliente = nombreCliente;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
    }

    public Cliente(String nombreCliente, String dni, String domicilio, String celular) {
        this.nombre_Cliente = nombreCliente;
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

    public String getNombre_Cliente() {
        return nombre_Cliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombre_Cliente = nombreCliente;
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
