/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        initDB();
        initComponents();
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
        if ("nuevo".equals(des)) {
            modelClientes.guardarRegistro(viewClientes.jtf_nombre.getText(), viewClientes.jtf_ape_paterno.getText(),
                    viewClientes.jtf_ape_materno.getText(), viewClientes.jtf_calle.getText(),
                    viewClientes.jtf_numero.getText(), viewClientes.jtf_colonia.getText(), viewClientes.jtf_telefono.getText(),
                    (String) viewClientes.jcb_tipo.getSelectedItem());

        } else if ("actualizar".equals(des)) {
            modelClientes.editarRegistro(viewClientes.jtf_nombre.getText(), viewClientes.jtf_ape_paterno.getText(), viewClientes.jtf_ape_materno.getText(),
                    viewClientes.jtf_calle.getText(), viewClientes.jtf_numero.getText(), viewClientes.jtf_colonia.getText(), viewClientes.jtf_telefono.getText(),
                    (String) viewClientes.jcb_tipo.getSelectedItem(), viewClientes.jtf_id_cliente.getText());
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

    }

    public void deshabilitarCampos() {
        viewClientes.jtf_ape_materno.setEditable(false);
        viewClientes.jtf_ape_paterno.setEditable(false);
        viewClientes.jtf_calle.setEditable(false);
        viewClientes.jtf_numero.setEditable(false);
        viewClientes.jtf_colonia.setEditable(false);
        viewClientes.jtf_nombre.setEditable(false);
        viewClientes.jtf_telefono.setEditable(false);
    }

}
