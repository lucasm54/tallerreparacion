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
    
    public double costoTotalAparato(int idAparato){
        double total=0;
        try{
            String sql = "SELECT id_servicio FROM reparacion WHERE id_aparato = ?;";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idAparato);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ServicioData sd = new ServicioData(conexion);
                Servicio s = sd.buscarServicio(rs.getInt("id_servicio"));
                total+=s.getCosto();
            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("no se encuentra el aparato");
        }
        return total;
    }
    
    public List<Aparato> listarReparados(){
        List<Aparato> aparatos = new ArrayList<Aparato>();
        try{
        String sql = "SELECT id_aparato FROM reparacion WHERE estado=?;";
        
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, "resuelto");
        
        ResultSet rs = ps.executeQuery();
        Aparato aparato;
        while(rs.next()){
            AparatoData ad = new AparatoData(conexion);
            aparato = ad.buscarAparato(rs.getInt("id_aparato"));
            aparatos.add(aparato);
        }
        ps.close();
        }catch(SQLException ex){
            
        }
        return aparatos;
    }
    
    public List<Aparato> listarPendientes(){
        List<Aparato> aparatos = new ArrayList<Aparato>();
        try{
        String sql = "SELECT id_aparato FROM reparacion WHERE estado=?;";
        
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, "pendiente");
        
        ResultSet rs = ps.executeQuery();
        Aparato aparato;
        while(rs.next()){
            AparatoData ad = new AparatoData(conexion);
            aparato = ad.buscarAparato(rs.getInt("id_aparato"));
            aparatos.add(aparato);
        }
        ps.close();
        }catch(SQLException ex){
            
        }
        return aparatos;
    }
    
    public void GuardarReparacion(Reparacion re)
    {
      String sql = "INSERT INTO Reparacion(id_reparacion,id_aparato,id_servicio,fechReparacion,estado) VALUES(? ,? ,? ,?);";  
      
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,re.getId_Reparacion());
            ps.setInt(2,re.getAparato().getId_aparato());
            ps.setInt(3,re.getServicio().getId_servicio());
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
         String sql = "UPDATE Reparacion SET id_Reparacion =?, id_aparato =? + id_servicio=? "
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
           System.out.println("ERROR AL INSERTAR ID"+ex.getMessage());              
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
            System.out.println("ERROR AL INSERTAR ID"+ex.getMessage());
        }
    }
    
}
