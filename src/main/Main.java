/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.ModelMain;
import views.ViewMain;
import controllers.ControllerMain;

import models.ModelEmpleados;
import controllers.ControllerEmpleados;
import views.ViewEmpleados;
/**
 *
 * @author Salvador Hernández Mendoza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        ModelEmpleados modelVentas = new ModelEmpleados();
        ViewEmpleados viewVentas = new ViewEmpleados();
        ControllerEmpleados controllerVentas = new ControllerEmpleados(modelVentas, viewVentas);
        
        
        
        
        
        Object[] controllers = new Object[1];
        controllers[0] = controllerVentas;
        
        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain, controllers);
        
    }
    
}
