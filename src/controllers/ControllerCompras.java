
package controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import views.ViewCompras;
import models.ModelCompras;



public class ControllerCompras {
    
    ViewCompras viewCompras;
    ModelCompras modelCompras;

    public ControllerCompras(ViewCompras viewCompras, ModelCompras modelCompras) {
        
        this.viewCompras = viewCompras;
        this.modelCompras = modelCompras;
        initComponents();
        setActionListener();
        setKeyListener();
    }
    
    public void initComponents(){
        viewCompras.jtf_subtotal.setText("0.0");
        viewCompras.jtf_total.setText("0.0");
        
          modelCompras.añadirColumnasProveedor();
    }
    
    public void setActionListener(){
        viewCompras.jb_buscar.addActionListener(actionListener);
    }
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewCompras.jb_buscar){
             
            }
        }
    };
    
    public void setKeyListener(){
        viewCompras.jtf_buscar.addKeyListener(keyListener);
    }
    
    
    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
          
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
                modelCompras.limpiaTablaProveedor();
                modelCompras.buscarProveedor(viewCompras.jtf_buscar.getText());
                modelCompras.tablaProveedor();
                viewCompras.jtb_proveedor.setModel(modelCompras.getModelo_p());
        }
    };
    
    
    
    public void actionPerformedProveedor(){    
        
        modelCompras.buscarProveedor(viewCompras.jtf_buscar.getText());
        modelCompras.tablaProveedor();
        viewCompras.jtb_proveedor.setModel(modelCompras.getModelo_p());
    }
    
  
    
}
