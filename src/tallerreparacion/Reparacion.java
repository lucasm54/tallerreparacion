/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerreparacion;

import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class Reparacion {
    private int id_Reparacion;
    private Aparato aparato;
    private Servicio servicio;
    private LocalDate fechReparacion;
    private String estado;
    
    ///constructor

    public Reparacion(int id_Reparacion, Aparato aparato, Servicio servicio, LocalDate fechReparacion, String estado) {
        this.id_Reparacion = id_Reparacion;
        this.aparato = aparato;
        this.servicio = servicio;
        this.fechReparacion = fechReparacion;
        this.estado = estado;
    }

    public Reparacion(Aparato aparato, Servicio servicio, LocalDate fechReparacion, String estado) {
        this.aparato = aparato;
        this.servicio = servicio;
        this.fechReparacion = fechReparacion;
        this.estado = estado;
    }

    public Reparacion() {
    }

    public int getId_Reparacion() {
        return id_Reparacion;
    }

    public void setId_Reparacion(int idReparacion) {
        this.id_Reparacion = idReparacion;
    }

    public Aparato getAparato() {
        return aparato;
    }

    public void setAparato(Aparato aparato) {
        this.aparato = aparato;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public LocalDate getFechReparacion() {
        return fechReparacion;
    }

    public void setFechReparacion(LocalDate fechReparacion) {
        this.fechReparacion = fechReparacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
   }