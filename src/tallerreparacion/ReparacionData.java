/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerreparacion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Emiliano
 */
public class ReparacionData {
    
    private Connection con;
    
    public ReparacionData(Conexion conexion)
    {
        try
        {
            con = conexion.getConnection();
        }
        catch(SQLException ex)
        {
            System.out.println("No se pudo conectar"+ex.getMessage());
        }
    }
    
    public void GuaradarReparacion(Reparacion re)
    {
      String sql = "INSERT INTO Reparacion(id_Reparacion,aparato,servicio,fechReparacion,estado) VALUES(? ,? ,? ,?);";  
      
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,re.getId_Reparacion());
            ps.setString(2,re.getAparato().toString());
            ps.setString(3,re.getServicio().toString());
            ps.setDate(4,Date.valueOf(re.getFechReparacion()));
            ps.setString(5,re.getEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next())
            {
                re.setId_Reparacion(rs.getInt(1));
            }else
            {
                System.out.println("No se pudo obtener el id de la reparacion o no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            
            System.out.println("ERROR al insertar id"+ex.getMessage());
        }
    
    }
    
    public void actualizarReparacion(Reparacion re)
    {
        try
        {
         String sql = "UPDATE Reparacion SET id_Reparacion =?, aparato =? + servicio=? "
                 + "fechReparacion=?,estado=?;";
         PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1,re.getId_Reparacion());
         ps.setString(2,re.getAparato().toString());
         ps.setString(3,re.getServicio().toString());
         ps.setDate(4,Date.valueOf(re.getFechReparacion()));
         ps.setString(5,re.getEstado());
         
         ps.executeUpdate();
         ps.close();
        }
        catch(SQLException ex)
         {
           System.out.println("ERROR AL INSERTAR ID"+ex.getMessage());              
         }
        
        }
    
    public void borrarReparacion(int id_Reparacion)
    {
        try{
        String sql = "DELETE FROM Reparacion WHERE id_Reparacion=?;";
        PreparedStatement ps = con.prepareStatement(sql,Statement.NO_GENERATED_KEYS);
        ps.setInt(1,id_Reparacion);
        ps.executeUpdate();
        
        ps.close();
        }catch(SQLException ex)
        {
            System.out.println("ERROR AL INSERTAR ID"+ex.getMessage());
        }
    }
    
}
