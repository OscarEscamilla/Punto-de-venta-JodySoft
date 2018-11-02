/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelMain;
import views.ViewMain;
import views.ViewEmpleados;



public class ControllerMain {
    
    
    
    
    private ViewMain viewMain;
    private ModelMain modelMain;
    
    
    private Object controllers[];
    
    private ControllerEmpleados controllerEmpleados;
    private ViewEmpleados viewEmpleados;

    public ControllerMain(ModelMain modelMain, ViewMain viewMain, Object[] controllers) {
        this.modelMain= modelMain;
        this.viewMain = viewMain;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponents();
    }
    
     private void setControllers() {
        controllerEmpleados = (ControllerEmpleados) controllers[0];
    }
    
    
    
    
    
    private void setActionListener(){
        viewMain.jm_empleados.addActionListener(actionListener);
    
    } 
    
    
    private void initComponents(){
        viewMain.setVisible(true);
    }
    
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewMain.jm_empleados){
                    empleados_Action_Performed();
             }
        }
    };
    
    
    public void empleados_Action_Performed(){
        viewMain.setContentPane(controllerEmpleados.viewEmpleados);
        viewMain.revalidate();
        viewMain.repaint();
         
        /*viewMain.jp_contenedor.removeAll();
        viewMain.jp_contenedor.repaint();
        viewMain.jp_contenedor.revalidate();

        Component add = viewMain.jp_contenedor.add(viewEmpleados);
        viewMain.jp_contenedor.repaint();
        viewMain.jp_contenedor.revalidate();*/
    }
}
