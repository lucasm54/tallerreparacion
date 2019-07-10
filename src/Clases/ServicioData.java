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
 * @author Emiliano
 */
public class ServicioData {
    
    private Connection conexion;
    private Conexion con;
    public ServicioData(Conexion con)
    {
        try
        {
            conexion = con.getConnection();
            
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR AL CONECTAR"+ex.getMessage());
        }
    }
    public List<Servicio> listarServicios(){
        List<Servicio> lista = new ArrayList<Servicio>();
        try{
            String sql = "SELECT * FROM servicio;";
            
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ResultSet result = ps.executeQuery();
            
            Cliente cliente;
            
            while(result.next()){
                Servicio s = new Servicio();
                s.setId_servicio(result.getInt("id_servicio"));
                s.setCodigo(result.getString("codigo"));
                s.setDescripcion(result.getString("descripcion"));
                s.setCosto(result.getDouble("costo"));
                lista.add(s);
                
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al querer mostrar Servicios " + ex.getMessage());
        }
        
        return lista; 
    }
    public void guardarServicio(Servicio se)
    {
        
        try {
            String sql = "INSERT INTO Servicio (codigo,descripcion,costo) VALUES ( ? , ? , ? );";

            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,se.getCodigo());
            ps.setString(2,se.getDescripcion());
            ps.setDouble(3,se.getCosto());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                se.setId_servicio(rs.getInt(1));
            }
            else {
                
              System.out.println("No se obtuvo codigo alguno");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar Servicio " + ex.getMessage());
        }
    }
    public void actualizarServicio(Servicio servicio)
    {
        try
        {
            String sql = "UPDATE servicio SET codigo = ? , descripcion = ? , costo = ? WHERE id_servicio = ?";
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
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
    public void borrarServicio(int id) throws SQLException
    {
        try
        {
            String sql = "DELETE FROM servicio WHERE id_servicio = ?";
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex)
        {
            System.out.print("ERROR AL borrar"+ex.getMessage());
        }
    }
    public Servicio buscarServicio(int id){
            Servicio s  = new Servicio();
            try{
                String sql = "SELECT * FROM servicio WHERE id_servicio = ?;";
                PreparedStatement ps;
                ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, id);
                
                ResultSet rs = ps.executeQuery();
                
                
                while(rs.next()){
                    
                    s.setId_servicio(rs.getInt(rs.getInt("id_servicio")));
                    s.setCodigo(rs.getString("codigo"));
                    s.setDescripcion(rs.getString("descripcion"));
                    s.setCosto(rs.getDouble("costo"));
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al buscar el servicio");
            }
            return s;
        }   

    }
    

