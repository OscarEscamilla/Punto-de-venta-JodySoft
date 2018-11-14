
package controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                actionPerformedProveedor();
            }
        }
    };
    
    
    public void actionPerformedProveedor(){
        modelCompras.limpiaTablaProveedor();
  
        modelCompras.buscarProveedor(viewCompras.jtf_buscar.getText());
        modelCompras.tablaProveedor();
        viewCompras.jtb_proveedor.setModel(modelCompras.getModelo_p());
    }
    
}
