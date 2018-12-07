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
import models.ModelSucursales;
import views.ViewSucursales;

public class ControllerSucursales {

    ModelSucursales modelSucursales;
    ViewSucursales viewSucursales;
    String des = null;

    public ControllerSucursales(ModelSucursales modelSucursales, ViewSucursales viewSucursales) {
        this.modelSucursales = modelSucursales;
        this.viewSucursales = viewSucursales;
        setActionlistener();
        setMouseListener();
        setKeyListener();
        initDB();
        initComponents();
    }

    public void initComponents() {

        viewSucursales.jtf_id.setVisible(false);
        viewSucursales.jtf_nombre.setEditable(false);
        viewSucursales.jtf_telefono.setEditable(false);
        viewSucursales.jtf_calle.setEditable(false);
        viewSucursales.jtf_colonia.setEditable(false);
        viewSucursales.jtf_codigo_p.setEditable(false);
        viewSucursales.jtf_numero.setEditable(false);

        tablaSucursalActionPerformed();

    }

    public void initDB() {
        modelSucursales.actualizarSucursales();
        getValues();
    }

    public void setActionlistener() {
        viewSucursales.jb_actualizar.addActionListener(actionListener);
        viewSucursales.jb_eliminar.addActionListener(actionListener);
        viewSucursales.jb_nuevo.addActionListener(actionListener);
        viewSucursales.jb_guardar.addActionListener(actionListener);
        viewSucursales.jb_cancelar.addActionListener(actionListener);
        viewSucursales.jb_reporte.addActionListener(actionListener);
//        viewSucursales.jb_buscar.addActionListener(actionListener);
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewSucursales.jb_guardar) {

                guardarActionPerformed();

            } else if (e.getSource() == viewSucursales.jb_cancelar) {

                cancelarActionPerformed();

            } else if (e.getSource() == viewSucursales.jb_actualizar) {

                actualizarActionPerformed();

            } else if (e.getSource() == viewSucursales.jb_eliminar) {

                eliminarActionPerformed();

            } else if (e.getSource() == viewSucursales.jb_nuevo) {

                nuevoActionPerformed();

            }
        }
    };
    
    public void setMouseListener(){
        viewSucursales.jtb_sucursales.addMouseListener(mouseListener);
    }
    
    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = viewSucursales.jtb_sucursales.getSelectedRow();
            
            viewSucursales.jtf_id.setText((String) viewSucursales.jtb_sucursales.getValueAt(fila, 0));
            viewSucursales.jtf_nombre.setText((String) viewSucursales.jtb_sucursales.getValueAt(fila, 1));
            viewSucursales.jtf_calle.setText((String) viewSucursales.jtb_sucursales.getValueAt(fila, 2));
            viewSucursales.jtf_colonia.setText((String) viewSucursales.jtb_sucursales.getValueAt(fila, 3));
            viewSucursales.jtf_numero.setText((String) viewSucursales.jtb_sucursales.getValueAt(fila, 4));
            viewSucursales.jtf_telefono.setText((String) viewSucursales.jtb_sucursales.getValueAt(fila, 5));
            viewSucursales.jtf_codigo_p.setText((String) viewSucursales.jtb_sucursales.getValueAt(fila, 6));
            
             
        
        }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) { }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) { }
    };
    
    public void setKeyListener() {
        viewSucursales.jtf_buscar.addKeyListener(keyListener);
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
            modelSucursales.limpiaTabla();
            modelSucursales.buscarRegistro(viewSucursales.jtf_buscar.getText());
            modelSucursales.tablaSucursal();
        }
    };

    public void cancelarActionPerformed() {
        deshabilitarCampos();
        getValues();
        viewSucursales.jb_actualizar.setEnabled(true);
        viewSucursales.jb_eliminar.setEnabled(true);
        viewSucursales.jb_reporte.setEnabled(true);
        viewSucursales.jb_nuevo.setEnabled(true);
        viewSucursales.jb_cancelar.setEnabled(false);
        viewSucursales.jb_guardar.setEnabled(false);
    }

    public void guardarActionPerformed() {
        // enviarDatos();
        
        if ("nuevo".equals(des)) {
            modelSucursales.guardarRegistro(
                viewSucursales.jtf_nombre.getText(),
                viewSucursales.jtf_calle.getText(),
                viewSucursales.jtf_colonia.getText(),
                viewSucursales.jtf_telefono.getText(),
                viewSucursales.jtf_numero.getText(),
                viewSucursales.jtf_codigo_p.getText());

        } else if ("actualizar".equals(des)) {
            modelSucursales.editarRegistro(
                viewSucursales.jtf_nombre.getText(),
                viewSucursales.jtf_calle.getText(),
                viewSucursales.jtf_colonia.getText(), 
                viewSucursales.jtf_telefono.getText(),
                viewSucursales.jtf_numero.getText(),
                viewSucursales.jtf_codigo_p.getText(),
                viewSucursales.jtf_id.getText());
        }
        getValues();
        deshabilitarCampos();
        viewSucursales.jb_actualizar.setEnabled(true);
        viewSucursales.jb_eliminar.setEnabled(true);
        viewSucursales.jb_reporte.setEnabled(true);
        viewSucursales.jb_nuevo.setEnabled(true);
        viewSucursales.jb_cancelar.setEnabled(false);
        viewSucursales.jb_guardar.setEnabled(false);

        modelSucursales.limpiaTabla();
        modelSucursales.actualizarSucursales();
        modelSucursales.tablaSucursal();

    }

    public void nuevoActionPerformed() {
        des = "nuevo";
        habilitarCampos();
        limpiarCampos();
        viewSucursales.jb_actualizar.setEnabled(false);
        viewSucursales.jb_eliminar.setEnabled(false);
        viewSucursales.jb_reporte.setEnabled(false);
        viewSucursales.jb_nuevo.setEnabled(false);
        viewSucursales.jb_cancelar.setEnabled(true);
        viewSucursales.jb_guardar.setEnabled(true);

    }

    public void tablaSucursalActionPerformed() {
        //modelEmpleados.actualizarEmpleados();

        modelSucursales.añadirColumnasTabla();

        modelSucursales.tablaSucursal();

        viewSucursales.jtb_sucursales.setModel(modelSucursales.getModelo());

    }

    public void eliminarActionPerformed() {
        //enviarDatos();
        modelSucursales.eliminarRegistro(viewSucursales.jtf_id.getText());
        modelSucursales.actualizarSucursales();
        getValues();

    }

    public void actualizarActionPerformed() {
        des = "actualizar";
        habilitarCampos();
        viewSucursales.jb_actualizar.setEnabled(false);
        viewSucursales.jb_eliminar.setEnabled(false);
        viewSucursales.jb_reporte.setEnabled(false);
        viewSucursales.jb_nuevo.setEnabled(false);
        viewSucursales.jb_cancelar.setEnabled(true);
        viewSucursales.jb_guardar.setEnabled(true);
    }

    private void getValues() {
        viewSucursales.jtf_id.setText(modelSucursales.getId_sucursal());
        viewSucursales.jtf_nombre.setText(modelSucursales.getNombre());
        viewSucursales.jtf_telefono.setText(modelSucursales.getTelefono());
        viewSucursales.jtf_numero.setText(modelSucursales.getNumero_ex());
        viewSucursales.jtf_calle.setText(modelSucursales.getCalle());
        viewSucursales.jtf_colonia.setText(modelSucursales.getColonia());
        viewSucursales.jtf_codigo_p.setText(modelSucursales.getCodigo_p());
//        viewClientes.jcb_tipo.setText(modelEmpleados.getRFC());
    }

    private void limpiarCampos() {
        viewSucursales.jtf_nombre.setText("");
        viewSucursales.jtf_telefono.setText("");
        viewSucursales.jtf_numero.setText("");
        viewSucursales.jtf_calle.setText("");
        viewSucursales.jtf_colonia.setText("");
        viewSucursales.jtf_codigo_p.setText("");

    }

    public void habilitarCampos() {
        viewSucursales.jtf_nombre.setEditable(true);
        viewSucursales.jtf_telefono.setEditable(true);
        viewSucursales.jtf_numero.setEditable(true);
        viewSucursales.jtf_calle.setEditable(true);
        viewSucursales.jtf_colonia.setEditable(true);
        viewSucursales.jtf_codigo_p.setEditable(true);

    }

    public void deshabilitarCampos() {
        viewSucursales.jtf_nombre.setEditable(false);
        viewSucursales.jtf_telefono.setEditable(false);
        viewSucursales.jtf_numero.setEditable(false);
        viewSucursales.jtf_calle.setEditable(false);
        viewSucursales.jtf_colonia.setEditable(false);
        viewSucursales.jtf_codigo_p.setEditable(false);

    }

    public void reporteActionPerformed() {

    }

}
