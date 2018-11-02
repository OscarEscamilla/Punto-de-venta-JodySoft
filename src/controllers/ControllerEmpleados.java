/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
 import models.ModelEmpleados;
import views.ViewEmpleados;
/**
 *
 * @author oscar
 */
public class ControllerEmpleados {
    
    ModelEmpleados modelEmpleados;
   ViewEmpleados viewEmpleados;

    public ControllerEmpleados(ModelEmpleados modelEmpleados, ViewEmpleados viewEmpleados) {
        this.modelEmpleados = modelEmpleados;
        this.viewEmpleados = viewEmpleados;
        setActionlistener();
        initDB();
        initComponents();
    }
    
    public void initComponents(){
        
        viewEmpleados.jtf_id_empleado.setEditable(false);
        viewEmpleados.jtf_app_empleado.setEditable(false);
        viewEmpleados.jtf_apm_empleado.setEditable(false);
        viewEmpleados.jtf_nombre_empleado.setEditable(false);
        viewEmpleados.jtf_calle_empleado.setEditable(false);
        viewEmpleados.jtf_colonia_empleado.setEditable(false);
        viewEmpleados.jtf_numero_empleado.setEditable(false);
        viewEmpleados.jtf_rfc_empleado.setEditable(false);
        viewEmpleados.jtf_telefono_empleado.setEditable(false);
        

    }
    
    public void initDB(){
        modelEmpleados.ConectarBD();
        setValues();
    }
    
   
    
    
    public void setActionlistener(){
        viewEmpleados.jb_actualizar.addActionListener(actionListener);
        viewEmpleados.jb_eliminar.addActionListener(actionListener);
        viewEmpleados.jb_nuevo.addActionListener(actionListener);
        viewEmpleados.jb_guardar.addActionListener(actionListener);
        viewEmpleados.jb_cancelar.addActionListener(actionListener);
        viewEmpleados.jb_reporte.addActionListener(actionListener);
    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewEmpleados.jb_guardar){
                
                guardarActionPerformed();
                
            }else if (e.getSource() == viewEmpleados.jb_cancelar){
                
                cancelarActionPerformed();
                JOptionPane.showMessageDialog(null, "probando accion");
                
            }else if (e.getSource() == viewEmpleados.jb_actualizar){
                JOptionPane.showMessageDialog(null, "probando accion");
                actualizarActionPerformed();
                
            }else if (e.getSource() == viewEmpleados.jb_eliminar){
                
                eliminarActionPerformed();
               
                
            }else if (e.getSource() == viewEmpleados.jb_nuevo){
                
                nuevoActionPerformed();
                
            }else if (e.getSource() == viewEmpleados.jb_reporte){
                
                reporteActionPerformed();
            }
        }
    };
    
    //metodos action performend de cada acccion en cada boton
    
    public void cancelarActionPerformed(){
        habilitarCampos();
        limpiarCampos();
    }
    
    
    public void guardarActionPerformed(){
        
    }
     
     
    public void nuevoActionPerformed(){
        
    }
    
    
    public void eliminarActionPerformed(){
        
    }
    
    public void actualizarActionPerformed() {

    }

    public void reporteActionPerformed() {

    }
    
    
    private void setValues() {
        
        viewEmpleados.jtf_id_empleado.setText(modelEmpleados.getId_empleado());
        viewEmpleados.jtf_nombre_empleado.setText(modelEmpleados.getNombre());
        viewEmpleados.jtf_app_empleado.setText(modelEmpleados.getApe_paterno());
        viewEmpleados.jtf_apm_empleado.setText(modelEmpleados.getApe_materno());
        viewEmpleados.jtf_calle_empleado.setText(modelEmpleados.getCalle());
        viewEmpleados.jtf_colonia_empleado.setText(modelEmpleados.getColonia());
        viewEmpleados.jtf_numero_empleado.setText(modelEmpleados.getNumero());
        viewEmpleados.jtf_telefono_empleado.setText(modelEmpleados.getTelefono());
        viewEmpleados.jtf_rfc_empleado.setText(modelEmpleados.getRFC());
        
      
    }
    
    private void limpiarCampos(){
        viewEmpleados.jtf_apm_empleado.setText("");
        viewEmpleados.jtf_app_empleado.setText("");
        viewEmpleados.jtf_nombre_empleado.setText("");
        viewEmpleados.jtf_numero_empleado.setText("");
        viewEmpleados.jtf_id_empleado.setText("");
        viewEmpleados.jtf_calle_empleado.setText("");
        viewEmpleados.jtf_colonia_empleado.setText("");
        viewEmpleados.jtf_telefono_empleado.setText("");
        viewEmpleados.jtf_rfc_empleado.setText("");
    }
    
    public void habilitarCampos(){
        viewEmpleados.jtf_apm_empleado.setEditable(true);
        viewEmpleados.jtf_app_empleado.setEditable(true);
        viewEmpleados.jtf_calle_empleado.setEditable(true);
        viewEmpleados.jtf_numero_empleado.setEditable(true);
        viewEmpleados.jtf_colonia_empleado.setEditable(true);
        viewEmpleados.jtf_nombre_empleado.setEditable(true);
        viewEmpleados.jtf_telefono_empleado.setEditable(true);
        viewEmpleados.jtf_rfc_empleado.setEditable(true);
    }

    
    
    
    
    
    
   
    
}
