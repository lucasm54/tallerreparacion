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
    private int idReparacion;
    private Aparato aparato;
    private Servicio servicio;
    private LocalDate fechReparacion;
    private String estado;
    
    ///constructor

    public Reparacion(int idReparacion, Aparato aparato, Servicio servicio, LocalDate fechReparacion, String estado) {
        this.idReparacion = idReparacion;
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

    public int getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
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