/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.sun.java.accessibility.util.SwingEventMonitor;
import com.sun.org.apache.bcel.internal.generic.D2F;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModelCompras extends Conexion {

    private ResultSet rs;
    private PreparedStatement ps;

    private Connection conexion;

    private String nombre_proveedor; // datos de el proveedor
    private String id_proveedor;
    private String telefono;
    private String empresa;
    private DefaultTableModel modelo_p = new DefaultTableModel();

    private String id_producto;
    private String nombre_producto;
    private String p_venta;
    private String descripcion;
    private DefaultTableModel modelo_pro = new DefaultTableModel();
    
    private DefaultTableModel modelo_de = new DefaultTableModel();

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public DefaultTableModel getModelo_p() {
        return modelo_p;
    }

    public void setModelo_p(DefaultTableModel modelo_p) {
        this.modelo_p = modelo_p;
    }

    // variables que almacenan datos de el producto
    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getP_venta() {
        return p_venta;
    }

    public void setP_venta(String p_venta) {
        this.p_venta = p_venta;
    }

    public DefaultTableModel getModelo_pro() {
        return modelo_pro;
    }

    public void setModelo_pro(DefaultTableModel modelo_pro) {
        this.modelo_pro = modelo_pro;
    }

    public DefaultTableModel getModelo_de() {
        return modelo_de;
    }

    public void setModelo_de(DefaultTableModel modelo_de) {
        this.modelo_de = modelo_de;
    }

    //####################### CODIGO DELA BUSQUEDA DEL PROUCTO Y METODOS PARA ENVIAR A LA TABLA ##########################3
    public void actualizarProducto() {
        try {

            String sql = "SELECT  id_producto, nombre, precio_compra, descripcion FROM productos ;";
            conexion = getConexion();
            ps = conexion.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery(sql);
            rs.next();
            setValuesProducto();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error_Actualizar_tabla" + e.getMessage());
        }

    }

    public void setValuesProducto() {
        try {

            id_proveedor = rs.getString("id_producto");
            nombre_proveedor = rs.getString("nombre");
            empresa = rs.getString("precio_compra");
            telefono = rs.getString("Descripcion");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error model 103: " + e.getMessage());

        }
    }

    public void buscarProducto(String nombre) {
        try {
            conexion = null;

            conexion = getConexion();

            ps = conexion.prepareStatement("SELECT  id_producto, nombre, precio_compra, descripcion  FROM productos WHERE nombre LIKE '%" + nombre + "%' OR id_producto LIKE '%" + nombre + "%';");

            rs = ps.executeQuery();

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias en su busqueda");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error- buscar" + e.getMessage());
        }
    }

    public void limpiaTablaProducto() {
        int filas = modelo_pro.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo_pro.removeRow(0);
        }
    }

    public void añadirColumnasTablaProducto() {
        modelo_pro.addColumn("ID");
        modelo_pro.addColumn("Nombre");
        modelo_pro.addColumn("Precio Compra");
        modelo_pro.addColumn("Descripcion");

    }
    
    
    public void añadirColumnasTablaDetalle() {
        modelo_de.addColumn("ID");
        modelo_de.addColumn("Nombre");
        modelo_de.addColumn("Precio Compra");
        modelo_de.addColumn("Cantidad");

    }
    
    public void tablaProducto() {
        try {

//            rs.first();
            String[] datos_pro = new String[4];
            System.out.println("comenzando while");
            do {
                datos_pro[0] = rs.getString(1);
                datos_pro[1] = rs.getString(2);
                datos_pro[2] = rs.getString(3);
                datos_pro[3] = rs.getString(4);
           

                modelo_pro.addRow(datos_pro);

                System.out.print(datos_pro[0]);
            } while (rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error tabla " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error tabla " + ex.getMessage());
        }
    }

    //####################### CODIGO DELA BUSQUEDA DEL PROVEEDOR Y METODOS PARA ENVIAR A LA TABLA ##########################3
    public void actualizarProvedores() {
        try {

            String sql = "SELECT  id_proveedor, nombre, empresa, telefono FROM proveedor;";
            conexion = getConexion();
            ps = conexion.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery(sql);
            rs.next();
            setValuesProveedor();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error_Actualizar_tabla" + e.getMessage());
        }

    }

    public void setValuesProveedor() {
        try {
            id_proveedor = rs.getString("id_proveedor");
            nombre_proveedor = rs.getString("nombre");
            empresa = rs.getString("empresa");
            telefono = rs.getString("telefono");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + e.getMessage());

        }
    }

    public void buscarProveedor(String nombre) {
        try {
            conexion = null;

            conexion = getConexion();

            ps = conexion.prepareStatement("SELECT id_proveedor, nombre, empresa, telefono FROM proveedor WHERE nombre LIKE '%" + nombre + "%' OR id_proveedor LIKE '%" + nombre + "%';");

            rs = ps.executeQuery();

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias en su busqueda");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error- buscar" + e.getMessage());
        }
    }

    public void limpiaTablaProveedor() {
        int filas = modelo_p.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo_p.removeRow(0);
        }
    }

    public void añadirColumnasTablaProveedor() {
        modelo_p.addColumn("ID");
        modelo_p.addColumn("Nombre");
        modelo_p.addColumn("Empresa");
        modelo_p.addColumn("Telefono");

    }

    public void tablaProveedor() {
        try {

//            rs.first();
            String[] datos_p = new String[4];
            System.out.println("comenzando while");
            do {
                datos_p[0] = rs.getString(1);
                datos_p[1] = rs.getString(2);
                datos_p[2] = rs.getString(3);
                datos_p[3] = rs.getString(4);

                modelo_p.addRow(datos_p);

                System.out.print(datos_p[0]);
            } while (rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error tabla " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error tabla " + ex.getMessage());
        }
    }
    
    //############COMIENZAN METODOS DE TABBLA PRODUCTOS ###########################
    

}
