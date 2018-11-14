/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelMain;
import views.ViewMain;




public class ControllerMain {

    private ViewMain viewMain;
    private final ModelMain modelMain;

    private final Object controllers[];

    private ControllerEmpleados controllerEmpleados;
    //private ViewEmpleados viewEmpleados;

    private ControllerProveedores controllerProveedores;
    //private ViewProveedores viewProveedores;

    private ControllerClientes controllerClientes;

    private ControllerCompras controllerCompras;
    
    public ControllerMain(ModelMain modelMain, ViewMain viewMain, Object[] controllers) {
        this.modelMain = modelMain;
        this.viewMain = viewMain;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponents();
    }

    private void setControllers() {
        controllerEmpleados = (ControllerEmpleados) controllers[0];
        controllerProveedores = (ControllerProveedores) controllers[1];
        controllerClientes = (ControllerClientes) controllers[2];
        controllerCompras = (ControllerCompras) controllers[3];

    }

    private void setActionListener() {
        viewMain.jm_empleados.addActionListener(actionListener);
        viewMain.jmi_salir.addActionListener(actionListener);
        viewMain.jm_proveedores.addActionListener(actionListener);
        viewMain.jm_clientes.addActionListener(actionListener);
        viewMain.jm_registrar_compra.addActionListener(actionListener);

    }

    private void initComponents() {
        viewMain.setVisible(true);
    }

    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMain.jm_empleados) {
                empleados_Action_Performed();
            } else if (e.getSource() == viewMain.jm_proveedores) {
                proveedoresActionPerformed();
            } else if (e.getSource() == viewMain.jmi_salir) {
                salirActionPerformend();
            } else if (e.getSource() == viewMain.jm_clientes) {
                clientesActionPerformed();
            } else if (e.getSource() == viewMain.jm_registrar_compra){
                comprasRegistrar();
            }
        }
    };

    public void empleados_Action_Performed() {
        viewMain.setContentPane(controllerEmpleados.viewEmpleados);
        viewMain.revalidate();
        viewMain.repaint();
    }

    public void proveedoresActionPerformed() {
        viewMain.setContentPane(controllerProveedores.viewProveedores);
        viewMain.revalidate();
        viewMain.repaint();
    }

    public void clientesActionPerformed() {
        viewMain.setContentPane(controllerClientes.viewClientes);
        viewMain.revalidate();
        viewMain.repaint();
    }
    
    public void comprasRegistrar(){
        viewMain.setContentPane(controllerCompras.viewCompras);
        viewMain.revalidate();
        viewMain.repaint();
        
        
    }

    public void salirActionPerformend() {

        int des = JOptionPane.showConfirmDialog(null, "Realmente desea cerrar el sistema", "Cerrar Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (des != JOptionPane.YES_NO_OPTION) {
        } else {
            try {

                System.exit(0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El sistema no se cerro correctamente" + e.getMessage());
            }
        }
    }

}
