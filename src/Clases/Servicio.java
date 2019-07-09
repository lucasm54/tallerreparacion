/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Emiliano
 */
class Servicio {
    
    private int id_servicio;
    private String codigo;
    private String descripcion;
    private double costo;

    public Servicio(int id_servicio, String codigo, String descripcion, double costo) {
        this.id_servicio = id_servicio;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Servicio(String codigo, String descripcion, double costo) {
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
 
    public String getCodigo()
    {
        return codigo;
    }
    public void setCodigo(String cod)
    {
        this.codigo = cod;

    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String des)
    {
        this.descripcion = des;
    }
    public double  getCosto()
    {
        return costo;
    }
    public void setCosto(double cost)
    {
        this.costo = cost;
    }

}

