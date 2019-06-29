/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.time.LocalDate;

/**
 *
 * @author Franco
 */
public class Reparacion {
    private int id_reparacion;
    private Aparato aparato;
    private Servicio servicio;
    private LocalDate fechReparada;
    private String estado;

    public Reparacion(int id_reparacion, Aparato aparato, Servicio servicio, LocalDate fechReparada, String estado) {
        this.id_reparacion = id_reparacion;
        this.aparato = aparato;
        this.servicio = servicio;
        this.fechReparada = fechReparada;
        this.estado = estado;
    }

    public Reparacion() {
    }

    public Reparacion(Aparato aparato, Servicio servicio, LocalDate fechReparada, String estado) {
        this.aparato = aparato;
        this.servicio = servicio;
        this.fechReparada = fechReparada;
        this.estado = estado;
    }


    public Aparato getAparato() {
        return aparato;
    }

    public int getId_reparacion() {
        return id_reparacion;
    }

    public void setId_reparacion(int id_reparacion) {
        this.id_reparacion = id_reparacion;
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

    public LocalDate getFechReparada() {
        return fechReparada;
    }

    public void setFechReparada(LocalDate fechReparada) {
        this.fechReparada = fechReparada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
