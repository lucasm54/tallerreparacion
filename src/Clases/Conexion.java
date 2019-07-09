/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author programador
 */
public class Conexion {
    private String url = "jdbc:mysql://localhost/tallerreparacion";
    private String usuario = "root";
    private String pass = "";
    
    private Connection conexion;

    public Conexion() throws ClassNotFoundException{
            Class.forName("org.mariadb.jdbc.Driver");
    }
    public Conexion(String url, String usuario,String pass) throws ClassNotFoundException {
        this.url = url;
        this.usuario=usuario;
        this.pass=pass;
        
        Class.forName("org.mariadb.jdbc.Driver");
    }
    public Connection getConnection()throws SQLException{
        
        if(conexion == null){
                    // Setup the connection with the DB
            conexion = DriverManager
                .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + pass);
        }
        return conexion;
    }
}
