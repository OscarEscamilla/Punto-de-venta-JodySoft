/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class ModelSucursales extends Conexion {

    private ResultSet rs;
    private PreparedStatement ps;
    private Connection conexion;

    private String id_sucursal;
    private String nombre;
    private String telefono;
    private String numero_ex;
    private String calle;
    private String colonia;
    private String codigo_p;
    private DefaultTableModel modelo = new DefaultTableModel();

    public String getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(String id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_ex() {
        return numero_ex;
    }

    public void setNumero_ex(String numero_ex) {
        this.numero_ex = numero_ex;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigo_p() {
        return codigo_p;
    }

    public void setCodigo_p(String codigo_p) {
        this.codigo_p = codigo_p;
    }

    public void actualizarSucursales() {
        try {
            String sql = "SELECT * FROM sucursal;";
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
            id_sucursal = rs.getString("id_sucursal");
            nombre = rs.getString("nombre");
            calle = rs.getString("calle");
            colonia = rs.getString("colonia");
            telefono = rs.getString("telefono");
            numero_ex = rs.getString("numero_exterior");
            codigo_p = rs.getString("codigo_p");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + e.getMessage());

        }
    }

    public void guardarRegistro(String nombre, String calle, String colonia, String telefono, String numero_exterior, String codigo_p) {
        try {
            conexion = null;
            conexion = getConexion();
            ps = conexion.prepareStatement("INSERT INTO sucursal (nombre, calle, colonia, telefono, numero_exterior, codigo_p) VALUES (?,?,?,?,?,?);");
            
            ps.setString(1, nombre);
            ps.setString(2, calle);
            ps.setString(3, colonia);
            ps.setString(4, telefono);
            ps.setString(5, numero_exterior);
            ps.setString(6, codigo_p);
            
            int devuelto;
            devuelto = ps.executeUpdate();
            
            if (devuelto > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados...");

                actualizarSucursales();

            } else {
                JOptionPane.showMessageDialog(null, "Datos NO registrados");
            }

        } catch (SQLException e) {
            Logger.getLogger(ModelProveedores.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    
     public void editarRegistro(String nombre, String calle, String colonia, String telefono, String numero_exterior, String codigo_p,String id_sucurdal) {
        try {
            conexion = null;
            conexion = getConexion();
            ps = conexion.prepareStatement("UPDATE sucursal SET nombre=?, calle=?, colonia=? , telefono=? , numero_exterior=?, codigo_p=? WHERE id_sucursal=?");
            ps.setString(1, nombre);
            ps.setString(2, calle);
            ps.setString(3, colonia);
            ps.setString(4, telefono);
            ps.setString(5, numero_exterior);
            ps.setString(6, codigo_p);
            ps.setString(7, id_sucursal);
      
            int resultado = ps.executeUpdate();
            
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos de Actualizados");
                actualizarSucursales();
            } else {
                JOptionPane.showMessageDialog(null, "Error 001-guardar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
        public void eliminarRegistro(String id_sucursal) {
        int des = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar este contacto?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (des != JOptionPane.YES_NO_OPTION) {
        } else {
            try {
                ps = conexion.prepareStatement("DELETE FROM sucursales WHERE id_sucursal = ?");
                ps.setString(1, id_sucursal);

                int res = ps.executeUpdate();
                limpiaTabla();
                actualizarSucursales();
                tablaSucursal();
                JOptionPane.showMessageDialog(null, "Eliminado...");
            } catch (SQLException ex) {
                Logger.getLogger(ModelEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
     
     
     
     public void añadirColumnasTabla() {

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Calle");
        modelo.addColumn("Colonia");
        modelo.addColumn("Numero Exterior");
        modelo.addColumn("Telefono");
        modelo.addColumn("Codigo Postal");
       

    }
    
    public void tablaSucursal() {
        try {

//            rs.first();
            String[] datos = new String[7];
            System.out.println("comenzando while");
            do {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                

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

            ps = conexion.prepareStatement("SELECT * FROM sucursal WHERE nombre LIKE '%" + nombre + "%' OR id_sucursal LIKE '%"+ nombre +"%';");
            rs = ps.executeQuery();
            if(rs.next() == false){
                JOptionPane.showMessageDialog(null,"No se encontraron coincidencias en su busqueda");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error- buscar" + e.getMessage());
        }

    }
}
