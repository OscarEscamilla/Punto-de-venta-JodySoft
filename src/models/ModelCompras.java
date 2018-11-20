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



public class ModelCompras extends Conexion{
    
    private ResultSet rs;
    private PreparedStatement ps;
 
    private Connection conexion;
    
    private String nombre_proveedor;
    private String id_proveedor;
    private String telefono;
    private String empresa;
    private DefaultTableModel modelo_p = new DefaultTableModel();
    
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
    
    public void buscarProveedor(String busqueda){
        try {
                conexion = null; 
                
                conexion = getConexion();
                
                ps = conexion.prepareStatement("SELECT id_proveedor, nombre, empresa, telefono FROM proveedores WHERE id_proveedor"
                + " LIKE '%"+ busqueda +"%';");
             
                rs = ps.executeQuery();
               
                if(rs.next() == false){
                    JOptionPane.showMessageDialog(null,"No se encontraron coincidencias en su busqueda");
                }else{
                    
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
     
      public void tablaProveedor() {
        try {

//            rs.first();
            String[] datos_p = new String[5];
         
            do {
                datos_p[0] = rs.getString(1);
                datos_p[1] = rs.getString(2);
                datos_p[2] = rs.getString(3);
                datos_p[3] = rs.getString(4);
              
               

                modelo_p.addRow(datos_p);
                
                System.out.println(datos_p[0]);
        
            } while (rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error tabla " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error tabla " + ex.getMessage());
        }
    }
      
    
    public void añadirColumnasProveedor() {

        modelo_p.addColumn("ID");
        modelo_p.addColumn("Nombre");
        modelo_p.addColumn("Telefono");
        modelo_p.addColumn("Empresa");
       
    }
    
    
//    public void buscarProducto(String bus){
//        conexion = null;
//        conexion = getConexion();
//        ps = conexion.prepareStatement("SELECT nombre, ");
//    }
}
