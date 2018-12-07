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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author oscar
 */
public class ModelProveedores extends Conexion{
     private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    private String id_proveedor;
    private String nombre;
    private String ape_paterno;
    private String ape_materno;
    private String calle;
    private String numero;
    private String colonia;
    private String empresa;
    private String telefono;
    private DefaultTableModel modelo = new DefaultTableModel();

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //COMIENZA EL CODIGO A BASE DE DATOS Y TERMINAN SETTERS Y GETTERS 

//    public Connection ConectarBD() { //metodo para conexion a la base de datos 
//        try {
//            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jodysoft", "root", "");
//            actualizarProveedores();
//            setValues();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error en conexion" + e.getMessage());
//        }
//        return conexion;
//    }

    public void actualizarProveedores() {
        try {
              String sql = "SELECT * FROM proveedor;";
              conexion = getConexion();
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
            id_proveedor = rs.getString("id_proveedor");
            nombre = rs.getString("nombre");
            ape_paterno = rs.getString("ape_paterno");
            ape_materno = rs.getString("ape_materno");
            calle = rs.getString("calle");
            numero = rs.getString("numero");
            colonia = rs.getString("colonia");
            telefono = rs.getString("telefono");
            empresa = rs.getString("empresa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + e.getMessage());

        }
    }

    public void guardarRegistro(String nombre, String ape_paterno, String ape_materno, String calle, String numero, String colonia, String telefono, String empresa) {
        try {
            conexion = null;
            conexion = getConexion();
            ps = conexion.prepareStatement("INSERT INTO proveedor (nombre, ape_paterno, ape_materno, calle, numero, colonia, telefono, empresa) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, ape_paterno);
            ps.setString(3, ape_materno);
            ps.setString(4, calle);
            ps.setString(5, numero);
            ps.setString(6, colonia);
            ps.setString(7, telefono);
            ps.setString(8, empresa);
            int devuelto = ps.executeUpdate();
            if (devuelto > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados...");

                actualizarProveedores();

            } else {
                JOptionPane.showMessageDialog(null, "Datos NO registrados");
            }

        } catch (SQLException e) {
            Logger.getLogger(ModelProveedores.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void eliminarRegistro(String id) {
        int des = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar este contacto?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (des != JOptionPane.YES_NO_OPTION) {
        } else {
            try {
                ps = conexion.prepareStatement("DELETE FROM proveedores WHERE id_proveedor = ?");
                ps.setString(1, id_proveedor);

                int res = ps.executeUpdate();
                limpiaTabla();
                actualizarProveedores();
                tablaProveedor();
                JOptionPane.showMessageDialog(null, "Eliminado...");
            } catch (SQLException ex) {
                Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void editarRegistro(String nombre, String ape_paterno, String ape_materno, String calle, String numero, String colonia, String telefono, String empresa, String id_proveedor) {
        try {
            conexion = null;
            conexion = getConexion();
            ps = conexion.prepareStatement("UPDATE proveedor  SET nombre=?, ape_paterno=?, ape_materno=? , calle=? , numero=?, colonia=? , telefono= ?, empresa=? WHERE id_proveedor=?");
            ps.setString(1, nombre);
            ps.setString(2, ape_paterno);
            ps.setString(3, ape_materno);
            ps.setString(4, calle);
            ps.setString(5, numero);
            ps.setString(6, colonia);
            ps.setString(7, telefono);
            ps.setString(8, empresa);
            ps.setString(9, id_proveedor);
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos de Actualizados");
                actualizarProveedores();
            } else {
                JOptionPane.showMessageDialog(null, "Error 001-guardar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void añadirColumnasTabla() {

        modelo.addColumn("Id_proveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Empresa");
        modelo.addColumn("Calle");
        modelo.addColumn("Colonia");
        modelo.addColumn("Numero");
        modelo.addColumn("Telefono");

    }

    public void tablaProveedor() {
        try {

//            rs.first();
            String[] datos = new String[10];
            System.out.println("comenzando while");
            do {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
               

                modelo.addRow(datos);

                System.out.print(datos[0]);
            } while (rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error tabla " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error tabla " + ex.getMessage());
        }
    }

    public void limpiaTabla() {
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }

    public void buscarRegistro(String nombre) {
        try {
            conexion = null;
            conexion = getConexion();

            ps = conexion.prepareStatement("SELECT * FROM proveedores WHERE nombre LIKE '%" + nombre + "%' OR id_proveedor LIKE '%"+ nombre +"%';");
            rs = ps.executeQuery();
            if(rs.next() == false){
                JOptionPane.showMessageDialog(null,"No se encontraron coincidencias en su busqueda");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error- buscar" + e.getMessage());
        }

    }
}
