/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import models.ModelLogin;
import views.ViewLogin;

/**
 *
 * @author oscar
 */
public class ControllerLogin {
    
    public ModelLogin modelLogin;
    public ViewLogin viewLogin;

    ActionListener actionListener = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(e.getSource() == viewLogin.jb_entrar ){
                  System.out.println("hola");
                  loguearDatos();
              }
          }
      };
    
    public ControllerLogin(ModelLogin modelLogin, ViewLogin viewLogin) {
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        initComponents();
        setActionListener();
    }
    
    
    public void setActionListener() {
        viewLogin.jb_entrar.addActionListener(actionListener);
    }

    private void loguearDatos() {
            modelLogin.loguear(viewLogin.jtf_usuario.getText(), viewLogin.jtf_password.getText());
    }

    private void initComponents() {
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setVisible(true);

    }
}
