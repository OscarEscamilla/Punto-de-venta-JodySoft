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

import models.ModelVentas;
import views.ViewVentas;

public class ControllerVentas {
    
    ModelVentas modelVentas;
    ViewVentas viewVentas;

    public ControllerVentas(ModelVentas modelVentas, ViewVentas viewVentas) {
        this.modelVentas = modelVentas;
        this.viewVentas = viewVentas;
    }
    
    
}
