/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Conexion {
    Connection con;
    private String url="jdbc:mysql://localhost:3306/bd_ventas";
    private String user="root";
    private String pss="";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(url, user, pss);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar la base de datos: "+ex.getMessage());;
        }
        return con;
    }
    
}
