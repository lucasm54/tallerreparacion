/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerreparacion;

/**
 *
 * @author Emiliano
 */
class Servicio {
 private int idServicio; 
 private String codigo;
 private String descripcion;
 private double costo;
 
 
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
 public void setDescription(String des)
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

public Servicio(String cod,String des,double cos)
{
    this.codigo = cod;
    this.descripcion = des;
    this.costo = cos;
}
}

