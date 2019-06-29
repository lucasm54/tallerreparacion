/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Franco
 */
public class Cliente {
    private int id_cliente;
    private String nombre_cliente;
    private String dni;
    private String domicilio;
    private String celular;

    public Cliente(int id_cliente, String nombre_cliente, String dni, String domicilio, String celular) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
    }

    public Cliente(String nombre_cliente, String dni, String domicilio, String celular) {
        this.nombre_cliente = nombre_cliente;
        this.dni = dni;
        this.domicilio = domicilio;
        this.celular = celular;
    }

    public Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
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
