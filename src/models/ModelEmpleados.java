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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
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

    public void guardarRegistro(String nombre, String ape_paterno, String ape_materno, String calle, String numero, String colonia, String telefono, String RFC) {
        try {
            conexion = null;
            conexion = ConectarBD();
            ps = conexion.prepareStatement("INSERT INTO empleados (nombre, ape_paterno, ape_materno, calle, numero, colonia, telefono, rfc) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, ape_paterno);
            ps.setString(3, ape_materno);
            ps.setString(4, calle);
            ps.setString(5, numero);
            ps.setString(6, colonia);
            ps.setString(7, telefono);
            ps.setString(8, RFC);
            int devuelto = ps.executeUpdate();
            if (devuelto > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados...");

                actualizarEmpleados();

            } else {
                JOptionPane.showMessageDialog(null, "Datos NO registrados");
            }

        } catch (SQLException e) {
            Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void eliminarRegistro(String id) {
        int des = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar este contacto?", "Eliminar contacto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (des != JOptionPane.YES_NO_OPTION) {
        } else {
            try {
                conexion = null;
                conexion = ConectarBD();
                ps = conexion.prepareStatement("DELETE FROM empleados WHERE id_empleado = ?");
                ps.setString(1, id_empleado);
                int res = ps.executeUpdate();
                actualizarEmpleados();
                JOptionPane.showMessageDialog(null, "Contacto eliminado");
            } catch (SQLException ex) {
                Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void editarRegistro(String nombre, String ape_paterno, String ape_materno, String calle, String numero, String colonia, String telefono, String RFC, String id_empleado) {
        try {
            conexion = null;
            conexion = ConectarBD();
            ps = conexion.prepareStatement("UPDATE empleados SET nombre=?, ape_paterno=?, ape_materno=? , calle=? , numero=?, colonia=? , telefono= ?, rfc=? WHERE id_empleado=?");
            ps.setString(1, nombre);
            ps.setString(2, ape_paterno);
            ps.setString(3, ape_materno);
            ps.setString(4, calle);
            ps.setString(5, numero);
            ps.setString(6, colonia);
            ps.setString(7, telefono);
            ps.setString(8, RFC);
            ps.setString(9, id_empleado);
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos de Actualizados");
                actualizarEmpleados();
            } else {
                JOptionPane.showMessageDialog(null, "Error 001-guardar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void moverPrimerRegistro() {
        System.out.println("moverPrimerRegistro");
        try {
            if (rs.isFirst() == false) {
                rs.first();
                setValues();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error_S" + e.getMessage());
        }
    }

    public void moverSiguienteRegistro() {
        System.out.println("moverSiguienteRegistro");
        try {
            if (rs.isLast() == false) {
                rs.next();
                setValues();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error_S" + e.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al anterior
     * registro 2.- obtener el valor del nombre de rs y guardarlo en la variable
     * nombre 3.- obtener el valor del email de rs y guardarlo en la variable
     * email
     */
    public void moverAnteriorRegistro() {
        System.out.println("moverAnteriorRegistro");
        try {
            if (rs.isFirst() == false) {
                rs.previous();
                setValues();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error_S" + e.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al ultimo registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la ariable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverUltimoRegistro() {
        System.out.println("moverUltimoRegistro");
        try {
            if (rs.isLast() == false) {
                rs.last();
                setValues();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error_S" + e.getMessage());
        }
    }

}
