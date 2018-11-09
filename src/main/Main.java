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

import models.ModelProveedores;
import controllers.ControllerProveedores;
import views.ViewProveedores;

import models.ModelClientes;
import controllers.ControllerClientes;
import views.ViewClientes;



public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        ModelEmpleados modelEmpleados = new ModelEmpleados();
        ViewEmpleados viewEmpleados = new ViewEmpleados();
        ControllerEmpleados controllerEmpleados = new ControllerEmpleados(modelEmpleados, viewEmpleados);
        
        
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);
        
        
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(modelClientes, viewClientes);
        
        
        
        
        
        
        
        
        Object[] controllers = new Object[3];
        controllers[0] = controllerEmpleados;
        controllers[1] = controllerProveedores;
        controllers[2] = controllerClientes;
        
        
        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain, controllers);
        
    }
    
}
