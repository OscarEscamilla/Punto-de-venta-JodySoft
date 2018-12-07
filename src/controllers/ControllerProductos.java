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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.ModelProductos;

import views.ViewProductos;

public class ControllerProductos {

    ModelProductos modelProductos;
    ViewProductos viewProductos;

    String des = null;

    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
        setActionlistener();
        setMouseListener();
        initDB();
        setKeyListener();
        initComponents();
    }

    public void initComponents() {

        viewProductos.jtf_id.setEditable(false);
        viewProductos.jtf_pcompra.setEditable(false);
        viewProductos.jtf_pventa.setEditable(false);
        viewProductos.jtf_nombre.setEditable(false);
        viewProductos.jtf_descripcion.setEditable(false);
        viewProductos.jcb_categoria.setEditable(false);
        viewProductos.jb_cancelar.setEnabled(false);
        viewProductos.jb_guardar.setEnabled(false);
        viewProductos.jtf_id.setVisible(false);

        tablaProductosActionPerformed();

    }

    public void initDB() {
        modelProductos.actualizarProductos();
        getValues();
    }

    public void setActionlistener() {
        viewProductos.jb_actualizar.addActionListener(actionListener);
        viewProductos.jb_eliminar.addActionListener(actionListener);
        viewProductos.jb_nuevo.addActionListener(actionListener);
        viewProductos.jb_guardar.addActionListener(actionListener);
        viewProductos.jb_cancelar.addActionListener(actionListener);
        viewProductos.jb_reporte.addActionListener(actionListener);
        viewProductos.jb_buscar.addActionListener(actionListener);

    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProductos.jb_guardar) {

                guardarActionPerformed();

            } else if (e.getSource() == viewProductos.jb_cancelar) {

                cancelarActionPerformed();

            } else if (e.getSource() == viewProductos.jb_actualizar) {

                actualizarActionPerformed();

            } else if (e.getSource() == viewProductos.jb_eliminar) {

                eliminarActionPerformed();

            } else if (e.getSource() == viewProductos.jb_nuevo) {

                nuevoActionPerformed();

            } else if (e.getSource() == viewProductos.jb_reporte) {

//                reporteActionPerformed();
            } else if (e.getSource() == viewProductos.jb_buscar) {

                modelProductos.limpiaTabla();
                modelProductos.buscarProducto(viewProductos.jtf_buscar.getText());
                modelProductos.tablaProducto();
            }
        }
    };

    public void setMouseListener() {
        viewProductos.jtb_productos.addMouseListener(mouseListener);
    }

    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int index = 0;
            int filaseleccionada = viewProductos.jtb_productos.getSelectedRow();
            String cat = (String) viewProductos.jtb_productos.getValueAt(filaseleccionada, 5);
            switch (cat) {
                case "Herramienta":
                    index = 1;
                    break;
                case "General":
                    index = 0;
                    break;
                case "Maquinaria":
                    index = 2;
                    break;
            }
            viewProductos.jtf_id.setText((String) viewProductos.jtb_productos.getValueAt(filaseleccionada, 0));
            viewProductos.jtf_nombre.setText((String) viewProductos.jtb_productos.getValueAt(filaseleccionada, 1));
            viewProductos.jtf_pcompra.setText((String) viewProductos.jtb_productos.getValueAt(filaseleccionada, 2));
            viewProductos.jtf_pventa.setText((String) viewProductos.jtb_productos.getValueAt(filaseleccionada, 3));
            viewProductos.jtf_descripcion.setText((String) viewProductos.jtb_productos.getValueAt(filaseleccionada, 4));
            viewProductos.jcb_categoria.setSelectedIndex(index);

        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    };

    public void setKeyListener() {
        viewProductos.jtf_buscar.addKeyListener(keyListener);
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
            modelProductos.limpiaTabla();
            modelProductos.buscarProducto(viewProductos.jtf_buscar.getText());
            modelProductos.tablaProducto();
        }
    };

    public void cancelarActionPerformed() {
        deshabilitarCampos();
        getValues();
        viewProductos.jb_actualizar.setEnabled(true);
        viewProductos.jb_eliminar.setEnabled(true);
        viewProductos.jb_reporte.setEnabled(true);
        viewProductos.jb_nuevo.setEnabled(true);
        viewProductos.jb_cancelar.setEnabled(false);
        viewProductos.jb_guardar.setEnabled(false);
    }

    public void guardarActionPerformed() {
//        enviarDatos();
        String item = viewProductos.jcb_categoria.getSelectedItem().toString();
        if ("nuevo".equals(des)) {
            modelProductos.guardarRegistro(
                    viewProductos.jtf_nombre.getText(),
                    viewProductos.jtf_pcompra.getText(),
                    viewProductos.jtf_pventa.getText(),
                    viewProductos.jtf_descripcion.getText(),
                    item
            );

        } else if ("actualizar".equals(des)) {

            modelProductos.editarRegistro(
                    viewProductos.jtf_nombre.getText(),
                    viewProductos.jtf_pcompra.getText(),
                    viewProductos.jtf_pventa.getText(),
                    viewProductos.jtf_descripcion.getText(),
                    item,
                    viewProductos.jtf_id.getText());
        }
        getValues();
        deshabilitarCampos();

        viewProductos.jb_actualizar.setEnabled(true);
        viewProductos.jb_eliminar.setEnabled(true);
        viewProductos.jb_reporte.setEnabled(true);
        viewProductos.jb_nuevo.setEnabled(true);
        viewProductos.jb_cancelar.setEnabled(false);
        viewProductos.jb_guardar.setEnabled(false);

        modelProductos.limpiaTabla();
        modelProductos.actualizarProductos();
        modelProductos.tablaProducto();

    }

    public void nuevoActionPerformed() {
        des = "nuevo";
        habilitarCampos();
        limpiarCampos();

        viewProductos.jb_actualizar.setEnabled(false);
        viewProductos.jb_eliminar.setEnabled(false);
        viewProductos.jb_reporte.setEnabled(false);
        viewProductos.jb_nuevo.setEnabled(false);
        viewProductos.jb_cancelar.setEnabled(true);
        viewProductos.jb_guardar.setEnabled(true);

    }

    public void eliminarActionPerformed() {
        //enviarDatos();
        modelProductos.eliminarRegistro(viewProductos.jtf_id.getText());
        modelProductos.actualizarProductos();
        getValues();

    }

    public void tablaProductosActionPerformed() {
        //modelEmpleados.actualizarEmpleados();

        modelProductos.añadirColumnasTabla();

        modelProductos.tablaProducto();
        viewProductos.jtb_productos.setModel(modelProductos.getModelo());

    }

    public void actualizarActionPerformed() {
        des = "actualizar";
        habilitarCampos();
        viewProductos.jb_actualizar.setEnabled(false);
        viewProductos.jb_eliminar.setEnabled(false);
        viewProductos.jb_reporte.setEnabled(false);
        viewProductos.jb_nuevo.setEnabled(false);
        viewProductos.jb_cancelar.setEnabled(true);
        viewProductos.jb_guardar.setEnabled(true);
    }

//    private void enviarDatos() {
//        modelProductos.setNombre(viewProductos.jtf_nombre.getText());
//        modelProductos.setId_producto(viewProductos.jtf_id.getText());
//        modelProductos.setPrecio_compra(viewProductos.jtf_pcompra.getText());
//        modelProductos.setPrecio_venta(viewProductos.jtf_pventa.getText());
//        modelProductos.setDescripcion(viewProductos.jtf_descripcion.getText());
//        modelProductos.setCategoria(des);
//    }
    private void getValues() {
        
       int index = 0;
        
        String cat = modelProductos.getCategoria();
                
                switch (cat) {
                case "Herramienta":
                    index = 1;
                    break;
                case "General":
                    index = 0;
                    break;
                case "Maquinaria":
                    index = 2;
                    break;
            }
        viewProductos.jtf_id.setText(modelProductos.getId_producto());
        viewProductos.jtf_nombre.setText(modelProductos.getNombre());
        viewProductos.jtf_pcompra.setText(modelProductos.getPrecio_compra());
        viewProductos.jtf_pventa.setText(modelProductos.getPrecio_venta());
        viewProductos.jtf_descripcion.setText(modelProductos.getDescripcion());
        viewProductos.jcb_categoria.setSelectedIndex(index);
    }
    
    private void limpiarCampos() {
        viewProductos.jtf_nombre.setText("");
        viewProductos.jtf_pcompra.setText("");
        viewProductos.jtf_pventa.setText("");
        viewProductos.jtf_descripcion.setText("");
        viewProductos.jtf_id.setText("");
    }
    
     public void habilitarCampos() {
        viewProductos.jtf_nombre.setEditable(true);
        viewProductos.jtf_pcompra.setEditable(true);
        viewProductos.jtf_pventa.setEditable(true);
        viewProductos.jtf_descripcion.setEditable(true);
        viewProductos.jcb_categoria.setEditable(true);

    }
     
     public void deshabilitarCampos() {
        viewProductos.jtf_nombre.setEditable(false);
        viewProductos.jtf_pcompra.setEditable(false);
        viewProductos.jtf_pventa.setEditable(false);
        viewProductos.jtf_descripcion.setEditable(false);
        viewProductos.jcb_categoria.setEditable(false);

    }
}
