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

import models.ModelReportes;
import views.ViewReportes;

public class ControllerReportes {
    
    ViewReportes viewReportes;
    ModelReportes modelReportes;

    public ControllerReportes(ViewReportes viewReportes, ModelReportes modelReportes) {
        this.viewReportes = viewReportes;
        this.modelReportes = modelReportes;
        
        
    }
    
    
}
