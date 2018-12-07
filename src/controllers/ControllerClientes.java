/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.ModelClientes;
import views.ViewClientes;

public class ControllerClientes {

    ModelClientes modelClientes;
    ViewClientes viewClientes;

    String des = null;

    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        setActionlistener();
        setKeyListener();
        initDB();
        initComponents();
        setMouseListener();
    }

    public void initComponents() {

        viewClientes.jtf_id_cliente.setEditable(false);
        viewClientes.jtf_ape_paterno.setEditable(false);
        viewClientes.jtf_ape_materno.setEditable(false);
        viewClientes.jtf_nombre.setEditable(false);
        viewClientes.jtf_calle.setEditable(false);
        viewClientes.jtf_colonia.setEditable(false);
        viewClientes.jtf_numero.setEditable(false);
        viewClientes.jtf_telefono.setEditable(false);
        viewClientes.jcb_tipo.setEditable(false);
        viewClientes.jb_cancelar.setEnabled(false);
        viewClientes.jb_guardar.setEnabled(false);
        viewClientes.jtf_id_cliente.setVisible(false);
        viewClientes.jcb_tipo.setEditable(false);
        tablaClientesActionPerformed();

    }

    public void initDB() {
        modelClientes.actualizarClientes();
        getValues();
    }

    public void setActionlistener() {

        viewClientes.jb_actualizar.addActionListener(actionListener);
        viewClientes.jb_eliminar.addActionListener(actionListener);
        viewClientes.jb_nuevo.addActionListener(actionListener);
        viewClientes.jb_guardar.addActionListener(actionListener);
        viewClientes.jb_cancelar.addActionListener(actionListener);
        viewClientes.jb_reporte.addActionListener(actionListener);
        viewClientes.jb_buscar.addActionListener(actionListener);
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewClientes.jb_guardar) {

                guardarActionPerformed();

            } else if (e.getSource() == viewClientes.jb_cancelar) {

                cancelarActionPerformed();

            } else if (e.getSource() == viewClientes.jb_actualizar) {

                actualizarActionPerformed();

            } else if (e.getSource() == viewClientes.jb_eliminar) {

                eliminarActionPerformed();

            } else if (e.getSource() == viewClientes.jb_nuevo) {

                nuevoActionPerformed();

            } else if (e.getSource() == viewClientes.jb_reporte) {

                reporteActionPerformed();
            } else if (e.getSource() == viewClientes.jb_buscar) {
                modelClientes.limpiaTabla();
                modelClientes.buscarRegistro(viewClientes.jtf_buscar.getText());
                modelClientes.tablaCliente();
            }
        }
    };
    
    
    public void setMouseListener(){
        viewClientes.jtb_clientes.addMouseListener(mouseListener);
    }
    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
           int fila = viewClientes.jtb_clientes.getSelectedRow();
           
           String tipo = (String) viewClientes.jtb_clientes.getValueAt(fila, 7);
           int index = 0;
           if("General".equals(tipo)){
               index = 0;
           }else if("Factura".equals(tipo)){
               index= 1;
           }
           viewClientes.jtf_id_cliente.setText((String) viewClientes.jtb_clientes.getValueAt(fila, 0));
           viewClientes.jtf_nombre.setText((String) viewClientes.jtb_clientes.getValueAt(fila, 1));
           viewClientes.jtf_ape_paterno.setText((String) viewClientes.jtb_clientes.getValueAt(fila, 2));
           viewClientes.jtf_ape_materno.setText((String) viewClientes.jtb_clientes.getValueAt(fila, 3));
           viewClientes.jtf_calle.setText((String) viewClientes.jtb_clientes.getValueAt(fila, 4));
           viewClientes.jtf_colonia.setText((String) viewClientes.jtb_clientes.getValueAt(fila, 5));
           viewClientes.jtf_numero.setText((String) viewClientes.jtb_clientes.getValueAt(fila, 6));
           viewClientes.jcb_tipo.setSelectedIndex(index);
           viewClientes.jtf_telefono.setText((String) viewClientes.jtb_clientes.getValueAt(fila, 8));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
          
        }
    };
    
       public void setKeyListener(){
        viewClientes.jtf_buscar.addKeyListener(keyListener);
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
            modelClientes.limpiaTabla();
            modelClientes.buscarRegistro(viewClientes.jtf_buscar.getText());
            modelClientes.tablaCliente();
        }
    };

    public void cancelarActionPerformed() {
        deshabilitarCampos();
        getValues();
        viewClientes.jb_actualizar.setEnabled(true);
        viewClientes.jb_eliminar.setEnabled(true);
        viewClientes.jb_reporte.setEnabled(true);
        viewClientes.jb_nuevo.setEnabled(true);
        viewClientes.jb_cancelar.setEnabled(false);
        viewClientes.jb_guardar.setEnabled(false);
    }

    public void guardarActionPerformed() {
        // enviarDatos();
        String item = viewClientes.jcb_tipo.getSelectedItem().toString();
        System.err.println(item);
        if ("nuevo".equals(des)) {
            modelClientes.guardarRegistro(
                    viewClientes.jtf_nombre.getText(),
                    viewClientes.jtf_ape_paterno.getText(),
                    viewClientes.jtf_ape_materno.getText(), 
                    viewClientes.jtf_calle.getText(),
                    viewClientes.jtf_numero.getText(),
                    viewClientes.jtf_colonia.getText(),
                    viewClientes.jtf_telefono.getText(),
                    item);

        } else if ("actualizar".equals(des)) {
            modelClientes.editarRegistro(
                    viewClientes.jtf_nombre.getText(), 
                    viewClientes.jtf_ape_paterno.getText(), 
                    viewClientes.jtf_ape_materno.getText(),
                    viewClientes.jtf_calle.getText(), 
                    viewClientes.jtf_colonia.getText(), 
                    viewClientes.jtf_numero.getText(),
                    viewClientes.jtf_telefono.getText(),
                    item,
                    viewClientes.jtf_id_cliente.getText());
        }
        getValues();
        deshabilitarCampos();
        viewClientes.jb_actualizar.setEnabled(true);
        viewClientes.jb_eliminar.setEnabled(true);
        viewClientes.jb_reporte.setEnabled(true);
        viewClientes.jb_nuevo.setEnabled(true);
        viewClientes.jb_cancelar.setEnabled(false);
        viewClientes.jb_guardar.setEnabled(false);

        modelClientes.limpiaTabla();
        modelClientes.actualizarClientes();
        modelClientes.tablaCliente();

    }

    public void nuevoActionPerformed() {
        des = "nuevo";
        habilitarCampos();
        limpiarCampos();
        viewClientes.jb_actualizar.setEnabled(false);
        viewClientes.jb_eliminar.setEnabled(false);
        viewClientes.jb_reporte.setEnabled(false);
        viewClientes.jb_nuevo.setEnabled(false);
        viewClientes.jb_cancelar.setEnabled(true);
        viewClientes.jb_guardar.setEnabled(true);

    }

    public void eliminarActionPerformed() {
        //enviarDatos();
        modelClientes.eliminarRegistro(viewClientes.jtf_id_cliente.getText());
        modelClientes.actualizarClientes();
        getValues();

    }

    public void tablaClientesActionPerformed() {
        //modelEmpleados.actualizarEmpleados();

        modelClientes.añadirColumnasTabla();

        modelClientes.tablaCliente();
        viewClientes.jtb_clientes.setModel(modelClientes.getModelo());

    }

    public void actualizarActionPerformed() {
        des = "actualizar";
        habilitarCampos();
        viewClientes.jb_actualizar.setEnabled(false);
        viewClientes.jb_eliminar.setEnabled(false);
        viewClientes.jb_reporte.setEnabled(false);
        viewClientes.jb_nuevo.setEnabled(false);
        viewClientes.jb_cancelar.setEnabled(true);
        viewClientes.jb_guardar.setEnabled(true);
    }

    public void reporteActionPerformed() {

    }

    private void getValues() {
        

        viewClientes.jtf_id_cliente.setText(modelClientes.getId_cliente());
        viewClientes.jtf_nombre.setText(modelClientes.getNombre());
        viewClientes.jtf_ape_paterno.setText(modelClientes.getApe_paterno());
        viewClientes.jtf_ape_materno.setText(modelClientes.getApe_materno());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_numero.setText(modelClientes.getNumero());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());

//        viewClientes.jcb_tipo.setText(modelEmpleados.getRFC());
    }

    private void limpiarCampos() {
        viewClientes.jtf_ape_materno.setText("");
        viewClientes.jtf_ape_paterno.setText("");
        viewClientes.jtf_nombre.setText("");
        viewClientes.jtf_numero.setText("");
        viewClientes.jtf_id_cliente.setText("");
        viewClientes.jtf_calle.setText("");
        viewClientes.jtf_colonia.setText("");
        viewClientes.jtf_telefono.setText("");

    }

    public void habilitarCampos() {
        viewClientes.jtf_ape_materno.setEditable(true);
        viewClientes.jtf_ape_paterno.setEditable(true);
        viewClientes.jtf_calle.setEditable(true);
        viewClientes.jtf_numero.setEditable(true);
        viewClientes.jtf_colonia.setEditable(true);
        viewClientes.jtf_nombre.setEditable(true);
        viewClientes.jtf_telefono.setEditable(true);
        viewClientes.jcb_tipo.setEditable(true);

    }

    public void deshabilitarCampos() {
        viewClientes.jtf_ape_materno.setEditable(false);
        viewClientes.jtf_ape_paterno.setEditable(false);
        viewClientes.jtf_calle.setEditable(false);
        viewClientes.jtf_numero.setEditable(false);
        viewClientes.jtf_colonia.setEditable(false);
        viewClientes.jtf_nombre.setEditable(false);
        viewClientes.jtf_telefono.setEditable(false);
        viewClientes.jcb_tipo.setEditable(false);
    }

}
