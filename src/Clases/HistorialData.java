/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author programador
 */
public class HistorialData {
    private Connection conexion;
    private Conexion con;
    public HistorialData(Conexion con){
    try{
            this.con = con;
            conexion = con.getConnection();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se encuentra la conexion");
        }
    }
 

            
    public void guardarHistorial(Historial historial) {

       try {
            String sql = "INSERT INTO historial( descripcion , autor , minutos) VALUES(? ,? ,? );";


         PreparedStatement ps;
         ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

           
            ps.setString(1, historial.getDescripcion());
            ps.setString(2, historial.getAutor());
            ps.setInt(3, historial.getMinutos());
          
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                historial.setIdHistorial(rs.getInt(1));
            }
            else{
                JOptionPane.showMessageDialog(null, "Nose puedo obtener el id");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede guardar historial");
        }
       
       
    }
    


 
    public List<Historial> obtenerHistorial(){
        List<Historial> historiales = new ArrayList<Historial>() ;
      
           try {
            String sql = "SELECT * FROM historial;";
        
            PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery();
                Historial historial;
                while(resultSet.next()){
                    historial = new Historial();
                    historial.setIdHistorial(resultSet.getInt("idHistorial"));
                    historial.setDescripcion(resultSet.getString("descripcion"));
                    historial.setAutor(resultSet.getString("autor"));
                    historial.setMinutos(resultSet.getInt("minutos"));
                    
                    historiales.add(historial);
                    
                }
            }
         catch (SQLException ex) {
            System.out.println("Error al obtener historial: " + ex.getMessage());
        }
    
    
    return historiales;
}
}




       
    



 
  
         
  