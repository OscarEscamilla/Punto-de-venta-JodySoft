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

import models.ModelCompras;
import controllers.ControllerCompras;
import views.ViewCompras;

import models.ModelVentas;
import  controllers.ControllerVentas;
import views.ViewVentas;

import models.ModelProductos;
import controllers.ControllerProductos;
import views.ViewProductos;

import models.ModelSucursales;
import controllers.ControllerSucursales;
import views.ViewSucursales;

import models.ModelReportes;
import controllers.ControllerReportes;
import views.ViewReportes;






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
        
        ModelCompras modelCompras = new ModelCompras();
        ViewCompras viewCompras = new ViewCompras();
        ControllerCompras controllerCompras = new ControllerCompras(viewCompras, modelCompras);
        
        
        
        ModelSucursales modelSucursales = new ModelSucursales();
        ViewSucursales viewSucursales = new  ViewSucursales();
        ControllerSucursales controllerSucursales = new ControllerSucursales(modelSucursales, viewSucursales);
        
        ModelVentas modelVentas = new ModelVentas();
        ViewVentas viewVentas = new ViewVentas();
        ControllerVentas controllerVentas = new ControllerVentas(modelVentas, viewVentas);
        
        
        ModelReportes modelReportes = new ModelReportes();
        ViewReportes viewReportes = new ViewReportes();
        ControllerReportes controllerReportes = new ControllerReportes(viewReportes, modelReportes);
        
        ModelProductos modelProductos = new ModelProductos();
        ViewProductos viewProductos = new ViewProductos();
        ControllerProductos controllerProductos = new ControllerProductos(modelProductos, viewProductos);
        
        
        
        
        
        
        
        
        
        
        
        
        
        Object[] controllers = new Object[8];
        controllers[0] = controllerEmpleados;
        controllers[1] = controllerProveedores;
        controllers[2] = controllerClientes;
        controllers[3] = controllerCompras;
        controllers[4] = controllerVentas;
        controllers[5] = controllerSucursales;
        controllers[6] = controllerProductos;
        controllers[7] = controllerReportes;
        
        
        
        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain, controllers);
        
    }
    
}
