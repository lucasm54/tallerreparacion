/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerreparacion;

import Clases.Cliente;
import Clases.ClienteData;
import Clases.Conexion;
import Clases.Historial;
import Clases.HistorialData;
import Clases.Servicio;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Tallerreparacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            /*Conexion con = new Conexion();
            Cliente cl;
            
            ClienteData cd =new ClienteData(con);
            
            cl = cd.buscarCliente(5);*/
            
            //a) ESTABLECER LA CONEXION---------
            Conexion con = new Conexion();
            
            //b)Instanciar historial
            Historial h1 = new Historial (2,"respaldo de datos", "Nino Romero",60);
           
            
            //c) Guardar en la bd el historial
            
            HistorialData hd = new HistorialData(con);
           hd.guardarHistorial(h1);
            
           //listar
           
           List<Historial> lista = hd.obtenerHistorial();
           
        //for ( Historial h:obtenerHistorial)       { 
        
                   
                
        
           
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error :"+ex.getMessage());
        }
    
    }
}