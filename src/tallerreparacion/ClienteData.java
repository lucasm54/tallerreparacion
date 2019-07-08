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
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ClienteData {
    
    private Connection conexion;

    public ClienteData(Conexion con) {
        try{
            conexion = con.getConnection();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se encuentra la conexion");
        }
    }
    
    public void guardarAparato(Cliente cliente){
        try {
            String sql = "INSERT INTO aparato(nombre_cliente , dni , domicilio , celular) VALUES(? ,? ,? ,?);";
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, cliente.getNombre_Cliente());
            ps.setString(2, cliente.getDni());
            ps.setString(3, cliente.getDomicilio());
            ps.setString(4, cliente.getCelular());
            
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                cliente.setIdCliente(rs.getInt(1));
            }
            else{
                JOptionPane.showMessageDialog(null, "Nose puedo obtener el id");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede guardar cliente");
        }
    }
    
    public void borrarCliente(int idCliente){
            try{
                //CONSULTA DE SQL
                String sql = "DELETE FROM aparato WHERE id_cliente=?";
                //RETORNA EL ID AUTOINCREMENTAL
                PreparedStatement ps;
                ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                //SETEO EL ID
                ps.setInt(1, idCliente);
                //ELIMINO CON EL METODO EXECUTEuPDATE
                ps.executeUpdate();


                ps.close();
            }
            catch(SQLException ex){
                System.out.println("Error al eliminar cliente" + ex.getMessage());
            }
    }
    
    public void actualizarCliente(Cliente cliente){
        try{
            String sql = "UPDATE aparato SET nombre_cliente = ?, dni= ? , domicilio = ? ,celular = ? WHERE id_cliente = ?;";
            
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1,cliente.getNombre_Cliente());
            ps.setString(2,cliente.getDni());
            ps.setString(3,cliente.getDomicilio());
            ps.setString(4,cliente.getCelular());
            
            
            
            ps.executeUpdate();
            
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("Error al actualizar cliente" + ex.getMessage());
        }
    }
        
}

