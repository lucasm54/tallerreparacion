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
public class Servicio {
    private int id_servicio;
    private String codigo;
    private String descripcion;
    private double costo;

    public Servicio(String codigo, String descripcion, double costo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Servicio(int id_servicio, String codigo, String descripcion, double costo) {
        this.id_servicio = id_servicio;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Servicio() {
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
