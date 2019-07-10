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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class ClienteData {
    
    private Connection conexion;
    private Conexion con;
    public ClienteData(Conexion con) {
        try{
            this.con = con;
            conexion = con.getConnection();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se encuentra la conexion");
        }
    }

    public ClienteData() {
    }
    
    public void guardarCliente (Cliente cliente){
        try {
            String sql = "INSERT INTO cliente(nombre_cliente , dni , domicilio , celular) VALUES(? ,? ,? ,?);";
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
                String sql = "DELETE FROM cliente WHERE id_cliente=?";
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
    public List<Cliente> listarClientes(){
        List<Cliente> lista = new ArrayList<Cliente>();
        try{
            String sql = "SELECT * FROM cliente;";
            
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ResultSet result = ps.executeQuery();
            
            Cliente cliente;
            
            while(result.next()){
                cliente = new Cliente();
                cliente.setIdCliente(result.getInt("id_cliente"));
                cliente.setNombreCliente(result.getString("nombre_cliente"));
                cliente.setDni(result.getString("dni"));
                cliente.setDomicilio(result.getString("domicilio"));
                cliente.setCelular(result.getString("celular"));
                lista.add(cliente);
                
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al querer mostrar clientes " + ex.getMessage());
        }
        
        return lista; 
    }
    public void actualizarCliente(Cliente cliente){
        try{
            String sql = "UPDATE cliente SET nombre_cliente = ?, dni= ? , domicilio = ? ,celular = ? WHERE id_cliente = ?;";
            
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1,cliente.getNombre_Cliente());
            ps.setString(2,cliente.getDni());
            ps.setString(3,cliente.getDomicilio());
            ps.setString(4,cliente.getCelular());
            ps.setInt(5,cliente.getIdCliente());
            
                 
            
            
            
            ps.executeUpdate();
            
            ps.close();
        }
        catch(SQLException ex){
            System.out.println("Error al actualizar cliente" + ex.getMessage());
        }
    }
     public Cliente buscarCliente(int idcliente){
            Cliente c = new Cliente();
            try{
                String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";
                PreparedStatement ps;
                ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, idcliente);
                
                ResultSet rs = ps.executeQuery();
                
                
                while(rs.next()){
                    c.setIdCliente(rs.getInt(rs.getInt("id_cliente")));
                    c.setNombreCliente(rs.getString("nombre_cliente"));
                    c.setDni(rs.getString(rs.getString("dni")));
                    c.setDomicilio(rs.getString(rs.getString("domicilio")));
                    c.setCelular(rs.getString(rs.getString("celular")));
                }
                ps.close();
            }catch(SQLException ex){
                System.out.println("Error al buscar un cliente");
            }
            return c;
        }   
     
     public Cliente contarClientes(int edad) {
         
       String sql = "select * FROM edad= ?;";
       
       
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, edad);
            
            
            ResultSet result = ps.executeQuery();
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     
         
         
     }
     
     
     
}

