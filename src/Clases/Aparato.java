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
public class Aparato {
    private int id_aparato;
    private String nro_serie;
    private String tipo;
    private Cliente dueño;
    private LocalDate fechIngreso;
    private LocalDate fechEgreso;

    public Aparato() {
    }

    public Aparato(String nro_serie, String tipo, Cliente dueño, LocalDate fechIngreso, LocalDate fechEgreso) {
        this.nro_serie = nro_serie;
        this.tipo = tipo;
        this.dueño = dueño;
        this.fechIngreso = fechIngreso;
        this.fechEgreso = fechEgreso;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public Aparato(int id_aparato, String nro_serie, String tipo, Cliente dueño, LocalDate fechIngreso, LocalDate fechEgreso) {
        this.id_aparato = id_aparato;
        this.nro_serie = nro_serie;
        this.tipo = tipo;
        this.dueño = dueño;
        this.fechIngreso = fechIngreso;
        this.fechEgreso = fechEgreso;
    }

    public int getId_aparato() {
        return id_aparato;
    }

    public void setId_aparato(int id_aparato) {
        this.id_aparato = id_aparato;
    }

    public String getNro_serie() {
        return nro_serie;
    }

    public void setNro_serie(String nro_serie) {
        this.nro_serie = nro_serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public LocalDate getFechIngreso() {
        return fechIngreso;
    }

    public void setFechIngreso(LocalDate fechIngreso) {
        this.fechIngreso = fechIngreso;
    }

    public LocalDate getFechEgreso() {
        return fechEgreso;
    }

    public void setFechEgreso(LocalDate fechEgreso) {
        this.fechEgreso = fechEgreso;
    }
    
}
