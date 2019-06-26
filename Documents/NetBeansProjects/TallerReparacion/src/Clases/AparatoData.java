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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class AparatoData {
    private Connection conexion;

    public AparatoData(Conexion con) {
        try{
            conexion = con.getConnection();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se encuentra la conexion");
        }
    }
    
    public void guardarAparato(Aparato aparato){
        try {
            String sql = "INSERT INTO aparato(nro_serie , tipo , dueño , fechIngreso , fechEgreso) VALUES(? ,? ,? ,? ,?);";
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, aparato.getNro_serie());
            ps.setString(2, aparato.getTipo());
            ps.setInt(3, aparato.getDueño().getId_cliente());
            ps.setDate(4, Date.valueOf(aparato.getFechIngreso()));
            ps.setDate(5, Date.valueOf(aparato.getFechEgreso()));
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                aparato.setId_aparato(rs.getInt(1));
            }
            else{
                JOptionPane.showMessageDialog(null, "Nose puedo obtener el id");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose puede insertar un aparato");
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
            ps.setInt(3,aparato.getDueño().getId_cliente());
            ps.setDate(4,Date.valueOf(aparato.getFechIngreso()));
            ps.setDate(5,Date.valueOf(aparato.getFechEgreso()));
            
            
            ps.executeUpdate();
            
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("Error al actualizar aparato" + ex.getMessage());
        }
    }
        
    }
    
    

