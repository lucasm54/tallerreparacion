/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerreparacion;

import Clases.Cliente;
import Clases.ClienteData;
import Clases.Conexion;
import java.sql.SQLException;
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
            try {
                con.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Tallerreparacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //b)Instanciar dos clientes, de 30 y 40 años
            
            Cliente c1 = new Cliente(6, "julian", "23234324", "barrio policial", "682429", 30);
            Cliente c2 = new Cliente(7, "mauricio", "32435454","barrio ate","453535", 40);
            
            //c) Guardar en la bd los clientes creados
            
            ClienteData cd = new ClienteData(con);
            cd.guardarCliente(c1);
            cd.guardarCliente(c2);
            
            //informar cantiad cliente con 30 años
            int cant = 0;
            cant = cd.contarClientes(30);
            System.out.println("cantidad clientes 30 años: " + cant);
            
            
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error :"+ex.getMessage());
        }
    }
    
}
