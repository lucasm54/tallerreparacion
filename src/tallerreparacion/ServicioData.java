/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerreparacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Emiliano
 */
public class ServicioData {
    
    private Connection con;
    
    public ServicioData(Conexion conexion)
    {
        try
        {
            con = conexion.getConnection();
        
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR AL CONECTAR"+ex.getMessage());
        }
    }
    
    public void guardarServicio(Servicio se)
    {
        
        try {
            String sql = "INSERT INTO Servicio (codigo,descripcion,costo) VALUES ( ? , ? , ? );";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,se.getCodigo());
            ps.setString(2,se.getDescripcion());
            ps.setDouble(3,se.getCosto());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                se.setCodigo(rs.getNString(1));
            }
            else {
                
              System.out.println("No se obtuvo codigo alguno");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar Cursada " + ex.getMessage());
        }
    }
    public void actualizarServicio(Servicio servicio)
    {
        try
        {
            String sql = "UPDATE servicio SET descripcion=?,costo=? WHERE codigo=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,servicio.getCodigo());
            ps.setString(2,servicio.getDescripcion());
            ps.setDouble(3,servicio.getCosto());
            ps.executeUpdate();
            
            ps.close();
        }catch(SQLException ex)
        {
            System.out.println("ERROR NO SE PUDO INGRESAR");
        }
    }
    public void borrarServicio(String codigo) throws SQLException
    {
        try
        {
            String sql = "DELETE FROM servicio WHERE codigo=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,codigo);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex)
        {
            System.out.print("ERROR AL INSERTAR CODIGO"+ex.getMessage());
        }
    }
    

    }
    

