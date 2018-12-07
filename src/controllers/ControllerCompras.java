package controllers;

import com.sun.media.sound.ModelOscillator;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import views.ViewCompras;
import models.ModelCompras;

public class ControllerCompras {

    ViewCompras viewCompras;
    ModelCompras modelCompras;

    Calendar fecha = new GregorianCalendar();

    DefaultTableModel modelo = new DefaultTableModel();

    DefaultTableModel modelo_de = new DefaultTableModel();

    float total = 0.0f;
    float subtotal = 0.0f;
    public ControllerCompras(ViewCompras viewCompras, ModelCompras modelCompras) {

        this.viewCompras = viewCompras;
        this.modelCompras = modelCompras;
        setActionListener();
//        initDB();
        setKeyListener();
        initComponents();
        setMouseListener();
        añadirColumnasTablaDetalle();

    }

//      public void initDB() {
//        modelCompras.actualizarProvedores();
//        
//      
//    }
    public void añadirColumnasTablaDetalle() {
        modelo_de.addColumn("ID");
        modelo_de.addColumn("Nombre");
        modelo_de.addColumn("Precio Compra");
        modelo_de.addColumn("Cantidad");

    }

    public void initComponents() {
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        viewCompras.jl_fecha.setText(dia + "-" + mes + "-" + ano);

        tablaProveedorActionPerformed();
        tablaProductoActionPerformed();
    }

    //####################### COMIENZA ACTION LISTENER ##########################3
    public void setActionListener() {
        viewCompras.agregar_producto.addActionListener(actionListener);
        viewCompras.jb_eliminar.addActionListener(actionListener);
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCompras.agregar_producto) {
                System.err.println("accion de agregar ");
                modelCompras.añadirColumnasTablaDetalle();
                
                
                int filaseleccionada = viewCompras.jtb_producto.getSelectedRow();
                
            

                String[] datos = new String[4];

                datos[0] = (String) viewCompras.jtb_producto.getValueAt(filaseleccionada, 0);
                datos[1] = (String) viewCompras.jtb_producto.getValueAt(filaseleccionada, 1);
                datos[2] = (String) viewCompras.jtb_producto.getValueAt(filaseleccionada, 2);
                datos[3] = Integer.toString((int) viewCompras.js_cantidad.getValue());

//                System.err.println(Arrays.toString(datos));
                
                    
//                String cantidad = (String) viewCompras.jtb_producto.getValueAt(filaseleccionada, 2);
//                String precio =  Integer.toString((int) viewCompras.js_cantidad.getValue());
//                
//                Float.parseFloat(precio);
//                 Float.parseFloat(cantidad);
//                
//                
//                subtotal = precio * cantidad;
                
//                total = total + subtotal;
                
                viewCompras.jl_total.setText(String.valueOf(total));

                modelo_de.addRow(datos);

                viewCompras.jtb_detalle.setModel(modelo_de);
            } else if (e.getSource() == viewCompras.jb_eliminar) {
                
                viewCompras.jtb_detalle.getModel();
                
                
                int a = viewCompras.jtb_detalle.getSelectedRow();
                
                if (a < 0) {

                    JOptionPane.showMessageDialog(null,
                            "Debe seleccionar una fila de la tabla");

                } else {
                    
                    int confirmar = JOptionPane.showConfirmDialog(null,
                            "¿Desea eliminar este producto de la venta?");
                    
                    if (JOptionPane.OK_OPTION == confirmar) {
                        
                        modelo_de.removeRow(a);
                        JOptionPane.showMessageDialog(null, "Producto Eliminado");

                    }

                }
            }
        }
    };

    //####################### COMIENZa MOUSE LISTENER ##########################3
    public void setMouseListener() {
        viewCompras.jtb_proveedor.addMouseListener(mouseListener);
        viewCompras.jtb_producto.addMouseListener(mouseListener);
    }

    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewCompras.jtb_proveedor) {
                int filaseleccionada = viewCompras.jtb_proveedor.getSelectedRow();
                viewCompras.jtf_id_proveedor.setText((String) viewCompras.jtb_proveedor.getValueAt(filaseleccionada, 0));
                viewCompras.jtf_nombre_proveedor.setText((String) viewCompras.jtb_proveedor.getValueAt(filaseleccionada, 1));
                viewCompras.jtf_telefono.setText((String) viewCompras.jtb_proveedor.getValueAt(filaseleccionada, 2));
                viewCompras.jtf_empresa.setText((String) viewCompras.jtb_proveedor.getValueAt(filaseleccionada, 3));
            } else if (e.getSource() == viewCompras.jtb_producto) {

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    //####################### COMIENZA KEY LISTENER ##########################3
    public void setKeyListener() {
        viewCompras.jtf_buscar_proveedor.addKeyListener(keyListener);
        viewCompras.jtf_buscar_producto.addKeyListener(keyListener);
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
            if (e.getSource() == viewCompras.jtf_buscar_proveedor) {
                modelCompras.limpiaTablaProveedor();
                modelCompras.buscarProveedor(viewCompras.jtf_buscar_proveedor.getText());
                modelCompras.tablaProveedor();
            } else if (e.getSource() == viewCompras.jtf_buscar_producto) {
                modelCompras.limpiaTablaProducto();
                modelCompras.buscarProducto(viewCompras.jtf_buscar_producto.getText());
                modelCompras.tablaProducto();
            }

        }
    };

    //####################### INICIALIZAN LAS TABLAS DE PRODUCTO Y CLIENTES ##########################
    public void tablaProveedorActionPerformed() {
        modelCompras.actualizarProvedores();

        modelCompras.añadirColumnasTablaProveedor();

        modelCompras.tablaProveedor();
        viewCompras.jtb_proveedor.setModel(modelCompras.getModelo_p());
    }

    public void tablaProductoActionPerformed() {
        modelCompras.actualizarProducto();

        modelCompras.añadirColumnasTablaProducto();

        modelCompras.tablaProducto();
        viewCompras.jtb_producto.setModel(modelCompras.getModelo_pro());
    }

}
