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

import models.ModelProductos;
import views.ViewProductos;

public class ControllerProductos {
    ModelProductos modelProductos;
    ViewProductos viewProductos;

    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
    }
    
}
