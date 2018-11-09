/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */




public class Conexion {
    
    private final String  BD = "jodysoft";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + BD;
    private Connection conexion;
    
    public Connection getConexion(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch (ClassNotFoundException e) {
            
            JOptionPane.showMessageDialog(null,"error en clase driver conexion" + e.getMessage());
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    
}
