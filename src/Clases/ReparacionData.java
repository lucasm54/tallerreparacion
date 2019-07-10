/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Emiliano
 */
public class ReparacionData {
    
    private Connection con;
    private Conexion conexion;
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
    
    public double costoTotalAparato(int idAparato) throws ClassNotFoundException{
        double total=0;
        
        try{
            String sql = "SELECT id_servicio FROM reparacion WHERE id_aparato = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idAparato);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Servicio s = buscarServicio(rs.getInt("id_servicio"));
                total=total + s.getCosto();
            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("no se encuentra el aparato");
        }
        return total;
    }
    public Servicio buscarServicio(int id) throws ClassNotFoundException{
            ServicioData sd = new ServicioData(conexion);
            return sd.buscarServicio(id);
    }
    public List<Aparato> listarReparados() throws ClassNotFoundException{
        List<Aparato> aparatos = new ArrayList<Aparato>();
        try{
        String sql = "SELECT id_aparato FROM reparacion WHERE estado=?;";
        
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, "resuelto");
        
        ResultSet rs = ps.executeQuery();
        Aparato aparato;
        while(rs.next()){
            
            aparato = buscarAparato(rs.getInt("id_aparato"));
            aparatos.add(aparato);
        }
        ps.close();
        }catch(SQLException ex){
            
        }
        return aparatos;
    }
    
    public List<Aparato> listarPendientes() throws ClassNotFoundException{
        List<Aparato> aparatos = new ArrayList<Aparato>();
        try{
        String sql = "SELECT id_aparato FROM reparacion WHERE estado=?;";
        
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, "pendiente");
        
        ResultSet rs = ps.executeQuery();
        Aparato aparato;
        while(rs.next()){
            aparato = buscarAparato(rs.getInt("id_aparato"));
            aparatos.add(aparato);
        }
        ps.close();
        }catch(SQLException ex){
            
        }
        return aparatos;
    }
    public Aparato buscarAparato(int id) throws ClassNotFoundException{
        AparatoData md=null;
        md = new AparatoData(conexion);
        return md.buscarAparato(id);
    }
    public void GuardarReparacion(Reparacion re)
    {
      String sql = "INSERT INTO reparacion(id_aparato,id_servicio,fechReparacion,estado) VALUES(?,?,?,?);";  
      
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,re.getAparato().getId_aparato());
            ps.setInt(2,re.getServicio().getId_servicio());
            ps.setDate(3,Date.valueOf(re.getFechReparacion()));
            ps.setString(4,re.getEstado());
            
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
         String sql = "UPDATE Reparacion SET id_reparacion =?, id_aparato =? + id_servicio=? "
                 + "fechReparacion=?,estado=?;";
         PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1,re.getId_Reparacion());
         ps.setInt(2,re.getAparato().getId_aparato());
         ps.setInt(3,re.getServicio().getId_servicio());
         ps.setDate(4,Date.valueOf(re.getFechReparacion()));
         ps.setString(5,re.getEstado());
         
         ps.executeUpdate();
         ps.close();
        }
        catch(SQLException ex)
         {
           System.out.println("ERROR AL actualizar "+ex.getMessage());              
         }
        
        }
    
    public void borrarReparacion(int id_Reparacion)
    {
        try{
        String sql = "DELETE FROM Reparacion WHERE id_reparacion=?;";
        PreparedStatement ps = con.prepareStatement(sql,Statement.NO_GENERATED_KEYS);
        ps.setInt(1,id_Reparacion);
        ps.executeUpdate();
        
        ps.close();
        }catch(SQLException ex)
        {
            System.out.println("ERROR AL Eliminar ID"+ex.getMessage());
        }
    }
    
}
