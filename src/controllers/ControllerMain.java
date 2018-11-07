/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
        viewMain.jmi_salir.addActionListener(actionListener);
    
    } 
    
    
    private void initComponents(){
        viewMain.setVisible(true);
    }
    
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewMain.jm_empleados){
                    empleados_Action_Performed();
            }else if (e.getSource() == viewMain.jmi_salir){
                salirActionPerformend();
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
    
    public void salirActionPerformend(){
        
        int des = JOptionPane.showConfirmDialog(null, "Realmente desea cerrar el sistema", "Cerrar Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (des != JOptionPane.YES_NO_OPTION ) {
        } else {
            try {
                
              System.exit(0);
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"El sistema no se cerro correctamente" + e.getMessage());
            }
        }
    }
}
