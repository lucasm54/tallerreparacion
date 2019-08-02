/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author programador
 */
public class Historial {
    private int idHistorial;
    private String descripcion;
    private String autor;
    private int minutos;

    public Historial(int idHistorial, String descripcion, String autor, int minutos) {
        this.idHistorial = idHistorial;
        this.descripcion = descripcion;
        this.autor = autor;
        this.minutos = minutos;
    }

    public Historial(String descripcion, String autor, int minutos) {
        this.descripcion = descripcion;
        this.autor = autor;
        this.minutos = minutos;
    }

    public Historial() {
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    
}
