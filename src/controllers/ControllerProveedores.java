/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author oscar
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.ModelProveedores;
import views.ViewProveedores;

public class ControllerProveedores {

    ModelProveedores modelProveedores;
    ViewProveedores viewProveedores;
    String des = null;

    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        setActionlistener();
        setMouseListener();
        initComponents();
        setKeyListener();
        initDB();
    }

    public void initComponents() {

        viewProveedores.jtf_id_proveedor.setEditable(false);
        viewProveedores.jtf_app_proveedor.setEditable(false);
        viewProveedores.jtf_apm_proveedor.setEditable(false);
        viewProveedores.jtf_nombre.setEditable(false);
        viewProveedores.jtf_calle.setEditable(false);
        viewProveedores.jtf_colonia.setEditable(false);
        viewProveedores.jtf_numero.setEditable(false);
        viewProveedores.jtf_empresa.setEditable(false);
        viewProveedores.jtf_telefono.setEditable(false);
        viewProveedores.jb_cancelar.setEnabled(false);
        viewProveedores.jb_guardar.setEnabled(false);
        viewProveedores.jtf_id_proveedor.setVisible(false);

            tablaProveedoresActionPerformed();

    }

    public void initDB() {
        modelProveedores.actualizarProveedores();
        getValues();
    }

    public void setActionlistener() {
        viewProveedores.jb_actualizar.addActionListener(actionListener);
        viewProveedores.jb_eliminar.addActionListener(actionListener);
        viewProveedores.jb_nuevo.addActionListener(actionListener);
        viewProveedores.jb_guardar.addActionListener(actionListener);
        viewProveedores.jb_cancelar.addActionListener(actionListener);
        viewProveedores.jb_reporte.addActionListener(actionListener);
        viewProveedores.jb_buscar.addActionListener(actionListener);

    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProveedores.jb_guardar) {

                guardarActionPerformed();

            } else if (e.getSource() == viewProveedores.jb_cancelar) {

                cancelarActionPerformed();

            } else if (e.getSource() == viewProveedores.jb_actualizar) {

                actualizarActionPerformed();

            } else if (e.getSource() == viewProveedores.jb_eliminar) {

                eliminarActionPerformed();

            } else if (e.getSource() == viewProveedores.jb_nuevo) {

                nuevoActionPerformed();

            } else if (e.getSource() == viewProveedores.jb_reporte) {

                reporteActionPerformed();
                
            } else if (e.getSource() == viewProveedores.jb_buscar) {
                modelProveedores.limpiaTabla();
                modelProveedores.buscarRegistro(viewProveedores.jtf_buscar_empleado.getText());
                modelProveedores.tablaProveedor();
            }
        }
    };
    
    public void setMouseListener(){
        viewProveedores.jtb_proveedores.addMouseListener(mouseListener);
    }
    
    MouseListener mouseListener = new MouseListener() {
        
        
        public void mouseClicked(MouseEvent e) {
           int fila = viewProveedores.jtb_proveedores.getSelectedRow();
           viewProveedores.jtf_id_proveedor.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 0));
           viewProveedores.jtf_nombre.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 1));
           viewProveedores.jtf_app_proveedor.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 2));
           viewProveedores.jtf_apm_proveedor.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 3));
           viewProveedores.jtf_empresa.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 4));
           viewProveedores.jtf_calle.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 5));
           viewProveedores.jtf_colonia.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 6));
           viewProveedores.jtf_numero.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 7));
           viewProveedores.jtf_telefono.setText((String) viewProveedores.jtb_proveedores.getValueAt(fila, 8));
        }

        @Override
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    };
    
      public void setKeyListener(){
        viewProveedores.jtf_buscar_empleado.addKeyListener(keyListener);
    }
    
    
    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
          
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
                modelProveedores.limpiaTabla();
                modelProveedores.buscarRegistro(viewProveedores.jtf_buscar_empleado.getText());
                modelProveedores.tablaProveedor();
        }
    };
    
    
    public void cancelarActionPerformed() {
        deshabilitarCampos();
        getValues();
        viewProveedores.jb_actualizar.setEnabled(true);
        viewProveedores.jb_eliminar.setEnabled(true);
        viewProveedores.jb_reporte.setEnabled(true);
        viewProveedores.jb_nuevo.setEnabled(true);
        viewProveedores.jb_cancelar.setEnabled(false);
        viewProveedores.jb_guardar.setEnabled(false);
    }

    public void guardarActionPerformed() {
        //enviarDatos();
        if ("nuevo".equals(des)) {
            modelProveedores.guardarRegistro(viewProveedores.jtf_nombre.getText(), viewProveedores.jtf_app_proveedor.getText(),
                    viewProveedores.jtf_apm_proveedor.getText(), viewProveedores.jtf_calle.getText(),
                    viewProveedores.jtf_numero.getText(), viewProveedores.jtf_colonia.getText(), viewProveedores.jtf_telefono.getText(),
                     viewProveedores.jtf_empresa.getText());

        } else if ("actualizar".equals(des)) {
            modelProveedores.editarRegistro(viewProveedores.jtf_nombre.getText(), viewProveedores.jtf_app_proveedor.getText(),
                    viewProveedores.jtf_apm_proveedor.getText(), viewProveedores.jtf_calle.getText(),
                    viewProveedores.jtf_numero.getText(), viewProveedores.jtf_colonia.getText(), viewProveedores.jtf_telefono.getText(),
                     viewProveedores.jtf_empresa.getText(), viewProveedores.jtf_id_proveedor.getText());
        }
        getValues();
        deshabilitarCampos();
        viewProveedores.jb_actualizar.setEnabled(true);
        viewProveedores.jb_eliminar.setEnabled(true);
        viewProveedores.jb_reporte.setEnabled(true);
        viewProveedores.jb_nuevo.setEnabled(true);
        viewProveedores.jb_cancelar.setEnabled(false);
        viewProveedores.jb_guardar.setEnabled(false);

        modelProveedores.limpiaTabla();
        modelProveedores.actualizarProveedores();
        modelProveedores.tablaProveedor();

    }

    public void nuevoActionPerformed() {
        des = "nuevo";
        habilitarCampos();
        limpiarCampos();
        viewProveedores.jb_actualizar.setEnabled(false);
        viewProveedores.jb_eliminar.setEnabled(false);
        viewProveedores.jb_reporte.setEnabled(false);
        viewProveedores.jb_nuevo.setEnabled(false);
        viewProveedores.jb_cancelar.setEnabled(true);
        viewProveedores.jb_guardar.setEnabled(true);

    }
    
    public void eliminarActionPerformed() {
        //enviarDatos();
        modelProveedores.eliminarRegistro(viewProveedores.jtf_id_proveedor.getText());
        modelProveedores.actualizarProveedores();
        getValues();
        

    }
    
     public void actualizarActionPerformed() {
        des = "actualizar";
        habilitarCampos();
         viewProveedores.jb_actualizar.setEnabled(false);
        viewProveedores.jb_eliminar.setEnabled(false);
        viewProveedores.jb_reporte.setEnabled(false);
        viewProveedores.jb_nuevo.setEnabled(false);
        viewProveedores.jb_cancelar.setEnabled(true);
        viewProveedores.jb_guardar.setEnabled(true);
    }
     
    public void reporteActionPerformed() {

    }

    private void getValues() {

        viewProveedores.jtf_id_proveedor.setText(modelProveedores.getId_proveedor());
        viewProveedores.jtf_nombre.setText(modelProveedores.getNombre());
        viewProveedores.jtf_app_proveedor.setText(modelProveedores.getApe_paterno());
        viewProveedores.jtf_apm_proveedor.setText(modelProveedores.getApe_materno());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_numero.setText(modelProveedores.getNumero());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono());
        viewProveedores.jtf_empresa.setText(modelProveedores.getEmpresa());

    }

    private void limpiarCampos() {
        viewProveedores.jtf_apm_proveedor.setText("");
        viewProveedores.jtf_app_proveedor.setText("");
        viewProveedores.jtf_calle.setText("");
        viewProveedores.jtf_numero.setText("");
        viewProveedores.jtf_colonia.setText("");
        viewProveedores.jtf_nombre.setText("");
        viewProveedores.jtf_telefono.setText("");
        viewProveedores.jtf_empresa.setText("");
    }

    public void habilitarCampos() {
        viewProveedores.jtf_apm_proveedor.setEditable(true);
        viewProveedores.jtf_app_proveedor.setEditable(true);
        viewProveedores.jtf_calle.setEditable(true);
        viewProveedores.jtf_numero.setEditable(true);
        viewProveedores.jtf_colonia.setEditable(true);
        viewProveedores.jtf_nombre.setEditable(true);
        viewProveedores.jtf_telefono.setEditable(true);
        viewProveedores.jtf_empresa.setEditable(true);
    }

    public void deshabilitarCampos() {
        viewProveedores.jtf_apm_proveedor.setEditable(false);
        viewProveedores.jtf_app_proveedor.setEditable(false);
        viewProveedores.jtf_calle.setEditable(false);
        viewProveedores.jtf_numero.setEditable(false);
        viewProveedores.jtf_colonia.setEditable(false);
        viewProveedores.jtf_nombre.setEditable(false);
        viewProveedores.jtf_telefono.setEditable(false);
        viewProveedores.jtf_empresa.setEditable(false);
    }

    public void tablaProveedoresActionPerformed() {
        modelProveedores.actualizarProveedores();

        modelProveedores.añadirColumnasTabla();

        modelProveedores.tablaProveedor();
        viewProveedores.jtb_proveedores.setModel(modelProveedores.getModelo());
        
    }

}
