
package controllers;


import com.sun.media.sound.ModelOscillator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import views.ViewCompras;
import models.ModelCompras;



public class ControllerCompras {
    
    ViewCompras viewCompras;
    ModelCompras modelCompras;
    
    Calendar fecha = new GregorianCalendar();

    public ControllerCompras(ViewCompras viewCompras, ModelCompras modelCompras) {
        
        this.viewCompras = viewCompras;
        this.modelCompras = modelCompras;
        setActionListener();
        initDB();
        setKeyListener();
        initComponents();
    }
    
      public void initDB() {
        modelCompras.actualizarProvedores();
      
    }
    public void initComponents(){
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
     viewCompras.jl_fecha.setText(dia+"-"+mes+"-"+ano);
     
        tablaProveedorActionPerformed();
    }
    
    public void setActionListener(){
           }
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewCompras.jb_buscar_proveedor){
             
            }
        }
    };
    
    public void setKeyListener(){
        viewCompras.jtf_buscar_proveedor.addKeyListener(keyListener);
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
             modelCompras.buscarProveedor(viewCompras.jtf_buscar_proveedor.getText());
             modelCompras.tablaProveedor();
        }
    };
    
    public void tablaProveedorActionPerformed(){
        //modelEmpleados.actualizarEmpleados();
        
        modelCompras.añadirColumnasTabla();

         modelCompras.tablaProveedor();
         viewCompras.jtb_proveedor.setModel(modelCompras.getModelo_p());
         
        
    }
    
  
  
    
}
