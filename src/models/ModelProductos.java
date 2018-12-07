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
public class ModelProductos extends Conexion {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    private String id_producto;
    private String nombre;
    private String precio_compra;
    private String precio_venta;
    private String descripcion;
    private String categoria;
    private DefaultTableModel modelo = new DefaultTableModel();

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(String precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public void actualizarProductos() { // metodo para recargar los datos de la tabla de mysql 
        try {

            String sql = "SELECT * FROM productos;";
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

    public void setValues() { // enviar los datos del resultset a las variables
        try {
            id_producto = rs.getString("id_producto");
            nombre = rs.getString("nombre");
            precio_compra = rs.getString("precio_compra");
            precio_venta = rs.getString("precio_venta");
            descripcion = rs.getString("descripcion");
            categoria = rs.getString("categoria");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error model productos 102: " + e.getMessage());

        }
    }

    public void guardarRegistro(String nombre, String p_compra, String p_venta, String descripcion, String categoria) {
        try {
            conexion = null;
            conexion = getConexion();
            ps = conexion.prepareStatement("INSERT INTO productos (nombre, precio_compra, precio_venta, descripcion , categoria) VALUES (?,?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, p_compra);
            ps.setString(3, p_venta);
            ps.setString(4, descripcion);
            ps.setString(5, categoria);

            int devuelto = ps.executeUpdate();
            if (devuelto > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados...");

                actualizarProductos();

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
                ps = conexion.prepareStatement("DELETE FROM productos WHERE id_producto = ?");
                ps.setString(1, id);

                int res = ps.executeUpdate();
                limpiaTabla();
                actualizarProductos();
                tablaProducto();
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            } catch (SQLException ex) {
                Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void editarRegistro(String nombre, String p_compra, String p_venta, String descripcion, String categoria, String id_producto) {
        try {
            conexion = null;
            conexion = getConexion();
            ps = conexion.prepareStatement("UPDATE productos SET nombre=?, precio_compra=?, precio_venta=? , descripcion=? , categoria=? WHERE id_producto=?");
            ps.setString(1, nombre);
            ps.setString(2, p_compra);
            ps.setString(3, p_venta);
            ps.setString(4, descripcion);
            ps.setString(5, categoria);
            ps.setString(6, id_producto);
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos de Actualizados");
                actualizarProductos();
            } else {
                JOptionPane.showMessageDialog(null, "Error 001-guardar producto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void añadirColumnasTabla() {

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Categoria");

    }
    
    
    public void tablaProducto() {
        try {

//            rs.first();
            String[] datos = new String[6];
           
            do {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
               

                modelo.addRow(datos);

       
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
    
    
    public void buscarProducto(String nombre) {
        try {
            conexion = null;
            conexion = getConexion();

            ps = conexion.prepareStatement("SELECT * FROM productos WHERE nombre LIKE '%" + nombre + "%' OR id_producto LIKE '%"+ nombre +"%';");
            rs = ps.executeQuery();
            if(rs.next() == false){
                JOptionPane.showMessageDialog(null,"No se encontraron coincidencias en su busqueda");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error- buscar" + e.getMessage());
        }

    }
    
    
    
}
