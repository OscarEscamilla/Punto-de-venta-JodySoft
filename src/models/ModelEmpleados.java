/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class ModelEmpleados {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private String id_empleado;
    private String nombre;
    private String ape_paterno;
    private String ape_materno;
    private String calle;
    private String numero;
    private String colonia;
    private String RFC;
    private String telefono;
    
    
    public String getId_empleado(){
        return id_empleado;
    }
    
    public void setId_empleado(String id_empleado){
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //COMIENZA EL CODIGO A BASE DE DATOS Y TERMINAN SETTERS Y GETTERS 
    
    public Connection ConectarBD() { //metodo para conexion a la base de datos 
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jodysoft", "root", "");
            actualizarEmpleados();
            setValues();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en conexion" + e.getMessage());
        }
        return conexion;
    }

    public void actualizarEmpleados() {
        try {
            String sql = "SELECT * FROM empleados;";
            ps = conexion.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery(sql);
            rs.next();
            setValues();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error_Actualizar_tabla" + e.getMessage());
        }
    }

    public void setValues() {
        try {
            id_empleado = rs.getString("id_empleado");
            nombre = rs.getString("nombre");
            ape_paterno = rs.getString("ape_paterno");
            ape_materno = rs.getString("ape_materno");
            calle = rs.getString("calle");
            numero = rs.getString("numero");
            colonia = rs.getString("colonia");
            telefono = rs.getString("telefono");
            RFC = rs.getString("rfc");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + e.getMessage());

        }
    }

}
