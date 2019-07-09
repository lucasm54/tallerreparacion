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

import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class AparatoData {
    private Connection conexion;
    private Conexion con;
    public AparatoData(Conexion con) {
        try{
            this.con = con;
            conexion = con.getConnection();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se encuentra la conexion");
        }
    }
    
    public void guardarAparato(Aparato aparato){
        try {
            String sql = "INSERT INTO aparato(nro_serie , tipo , id_cliente , fechIngreso , fechEgreso) VALUES(? ,? ,? ,? ,?);";
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, aparato.getNro_serie());
            ps.setString(2, aparato.getTipo());
            ps.setInt(3, aparato.getDueño().getIdCliente());
            ps.setDate(4, Date.valueOf(aparato.getFechIngreso()));
            ps.setDate(5, Date.valueOf(aparato.getFechEgreso()));
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                aparato.setId_aparato(rs.getInt(1));
            }
            else{
                System.out.println( "Nose puedo obtener el id");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede insertar un aparato");
        }
    }
    
    public void borrarAparato(int idAparato){
            try{
                //CONSULTA DE SQL
                String sql = "DELETE FROM aparato WHERE id_aparato=?";
                //RETORNA EL ID AUTOINCREMENTAL
                PreparedStatement ps;
                ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                //SETEO EL ID
                ps.setInt(1, idAparato);
                //ELIMINO CON EL METODO EXECUTEuPDATE
                ps.executeUpdate();


                ps.close();
            }
            catch(SQLException ex){
                System.out.println("Error al eliminar aparato" + ex.getMessage());
            }
    }
    
    public void actualizarAparato(Aparato aparato){
        try{
            String sql = "UPDATE aparato SET nro_serie = ?, tipo= ? , id_cliente = ? ,fechIngreso = ?, fechEgreso = ? WHERE id_aparato = ?;";
            
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1,aparato.getNro_serie());
            ps.setString(2,aparato.getTipo());
            ps.setInt(3,aparato.getDueño().getIdCliente());
            ps.setDate(4,Date.valueOf(aparato.getFechIngreso()));
            ps.setDate(5,Date.valueOf(aparato.getFechEgreso()));
            ps.setInt(6, aparato.getId_aparato());
            
            ps.executeUpdate();
            
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("Error al actualizar aparato" + ex.getMessage());
        }
    }
    public Aparato buscarAparato(int id){
        Aparato a = new Aparato();
        try{
            String sql = "SELECT * FROM aparato WHERE id_aparato = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                a.setId_aparato(rs.getInt("id_aparato"));
                a.setNro_serie(rs.getString("nro_serie"));
                a.setTipo(rs.getString("tipo"));
                ClienteData cd = new ClienteData(con);
                Cliente c = cd.buscarCliente(rs.getInt("id_cliente")); 
                a.setDueño(c);
                a.setFechIngreso(rs.getDate("fechIngreso").toLocalDate());
                a.setFechEgreso(rs.getDate("fechEgreso").toLocalDate());
                
            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("Buscar aparato no anda");
        }
        return a;
    }
    
    public Aparato buscarAparatoXFecha(String fecha){
        Aparato a = null;
        try{
            String sql = "SELECT * FROM aparato WHERE fechIngreso = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1,Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                a = new Aparato();
                a.setId_aparato(rs.getInt("id_aparato"));
                a.setNro_serie(rs.getString("nro_serie"));
                a.setTipo(rs.getString("tipo"));
                ClienteData cd = new ClienteData();
                Cliente c = cd.buscarCliente(rs.getInt("id_cliente")); 
                a.setDueño(c);
                a.setFechIngreso(rs.getDate("fechIngreso").toLocalDate());
                a.setFechEgreso(rs.getDate("fechEgreso").toLocalDate());
                
            }
            ps.close();
        }catch(SQLException ex){
            
        }
        return a;
    }
    public List<Aparato> mostrarAparatosXduenio(int idDuenio){
        
        List<Aparato> aparatos = new ArrayList<Aparato>();
        
        try{
            String sql = "SELECT * FROM aparato WHERE id_cliente = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,idDuenio);
            
            ResultSet rs = ps.executeQuery();
            Aparato aparato;
            
            while(rs.next()){
                aparato = new Aparato();
                aparato.setId_aparato(rs.getInt("id_aparato"));
                aparato.setNro_serie(rs.getString("nro_serie"));
                aparato.setTipo(rs.getString("tipo"));
                aparato.setFechIngreso(rs.getDate("fechIngreso").toLocalDate());
                aparato.setFechEgreso(rs.getDate("fechEgreso").toLocalDate());
                ClienteData cd = new ClienteData(con);
                Cliente c = cd.buscarCliente(rs.getInt("id_cliente"));
                
                aparato.setDueño(c);
                
                aparatos.add(aparato);
            }
            
        }catch(SQLException ex){
            System.out.println("No se puede encontrar aparatos de este duenio");
        }
        return aparatos;
    }
}
    
    
    
