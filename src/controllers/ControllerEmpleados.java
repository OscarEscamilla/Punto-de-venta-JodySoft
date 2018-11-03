
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelEmpleados;
import views.ViewEmpleados;

/**
 *
 * @author oscar
 */
public class ControllerEmpleados {

    ModelEmpleados modelEmpleados;
    ViewEmpleados viewEmpleados;
    String des = null;

    public ControllerEmpleados(ModelEmpleados modelEmpleados, ViewEmpleados viewEmpleados) {
        this.modelEmpleados = modelEmpleados;
        this.viewEmpleados = viewEmpleados;
        setActionlistener();
        initDB();
        initComponents();

    }

    public void initComponents() {

        viewEmpleados.jtf_id_empleado.setEditable(false);
        viewEmpleados.jtf_app_empleado.setEditable(false);
        viewEmpleados.jtf_apm_empleado.setEditable(false);
        viewEmpleados.jtf_nombre_empleado.setEditable(false);
        viewEmpleados.jtf_calle_empleado.setEditable(false);
        viewEmpleados.jtf_colonia_empleado.setEditable(false);
        viewEmpleados.jtf_numero_empleado.setEditable(false);
        viewEmpleados.jtf_rfc_empleado.setEditable(false);
        viewEmpleados.jtf_telefono_empleado.setEditable(false);
        viewEmpleados.jb_cancelar.setEnabled(false);
        viewEmpleados.jb_guardar.setEnabled(false);

    }

    public void initDB() {
        modelEmpleados.ConectarBD();
        getValues();
    }

    public void setActionlistener() {
        viewEmpleados.jb_actualizar.addActionListener(actionListener);
        viewEmpleados.jb_eliminar.addActionListener(actionListener);
        viewEmpleados.jb_nuevo.addActionListener(actionListener);
        viewEmpleados.jb_guardar.addActionListener(actionListener);
        viewEmpleados.jb_cancelar.addActionListener(actionListener);
        viewEmpleados.jb_reporte.addActionListener(actionListener);
       viewEmpleados.jb_anterior.addActionListener(actionListener);
       viewEmpleados.jb_primero.addActionListener(actionListener);
       viewEmpleados.jb_ultimo.addActionListener(actionListener);
       viewEmpleados.jb_siguiente.addActionListener(actionListener);
    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewEmpleados.jb_guardar) {

                guardarActionPerformed();

            } else if (e.getSource() == viewEmpleados.jb_cancelar) {

                cancelarActionPerformed();

            } else if (e.getSource() == viewEmpleados.jb_actualizar) {

                actualizarActionPerformed();

            } else if (e.getSource() == viewEmpleados.jb_eliminar) {

                eliminarActionPerformed();

            } else if (e.getSource() == viewEmpleados.jb_nuevo) {

                nuevoActionPerformed();

            } else if (e.getSource() == viewEmpleados.jb_reporte) {

                reporteActionPerformed();
            } else if (e.getSource() == viewEmpleados.jb_primero){
                modelEmpleados.moverPrimerRegistro();
                getValues();
                
            } else if (e.getSource() == viewEmpleados.jb_anterior){
                modelEmpleados.moverAnteriorRegistro();
                getValues();
            } else if (e.getSource() == viewEmpleados.jb_siguiente){
                modelEmpleados.moverSiguienteRegistro();
                getValues();
            } else if (e.getSource() == viewEmpleados.jb_ultimo){
                modelEmpleados.moverUltimoRegistro();
                getValues();
            }
        }
    };

    //metodos action performend de cada acccion en cada boton
    public void cancelarActionPerformed() {
        deshabilitarCampos();
        getValues();
        viewEmpleados.jb_actualizar.setEnabled(true);
        viewEmpleados.jb_eliminar.setEnabled(true);
        viewEmpleados.jb_reporte.setEnabled(true);
        viewEmpleados.jb_nuevo.setEnabled(true);
        viewEmpleados.jb_cancelar.setEnabled(false);
        viewEmpleados.jb_guardar.setEnabled(false);
    }

    public void guardarActionPerformed() {
        enviarDatos();
        if ("nuevo".equals(des)) {
            modelEmpleados.guardarRegistro(viewEmpleados.jtf_nombre_empleado.getText(),viewEmpleados.jtf_app_empleado.getText(),
                    viewEmpleados.jtf_apm_empleado.getText(), viewEmpleados.jtf_calle_empleado.getText(),
                    viewEmpleados.jtf_numero_empleado.getText(), viewEmpleados.jtf_colonia_empleado.getText(), viewEmpleados.jtf_telefono_empleado.getText()
                    ,viewEmpleados.jtf_rfc_empleado.getText());

        } else if ("actualizar".equals(des)) {
            modelEmpleados.editarRegistro(viewEmpleados.jtf_nombre_empleado.getText(),viewEmpleados.jtf_app_empleado.getText(),
                    viewEmpleados.jtf_apm_empleado.getText(), viewEmpleados.jtf_calle_empleado.getText(),
                    viewEmpleados.jtf_numero_empleado.getText(), viewEmpleados.jtf_colonia_empleado.getText(), viewEmpleados.jtf_telefono_empleado.getText()
                    ,viewEmpleados.jtf_rfc_empleado.getText(),viewEmpleados.jtf_id_empleado.getText());
        }
        getValues();
        deshabilitarCampos();
        viewEmpleados.jb_actualizar.setEnabled(true);
        viewEmpleados.jb_eliminar.setEnabled(true);
        viewEmpleados.jb_reporte.setEnabled(true);
        viewEmpleados.jb_nuevo.setEnabled(true);
        viewEmpleados.jb_cancelar.setEnabled(false);
        viewEmpleados.jb_guardar.setEnabled(false);

    }

    public void nuevoActionPerformed() {
        des = "nuevo";
        habilitarCampos();
        limpiarCampos();
        viewEmpleados.jb_actualizar.setEnabled(false);
        viewEmpleados.jb_eliminar.setEnabled(false);
        viewEmpleados.jb_reporte.setEnabled(false);
        viewEmpleados.jb_nuevo.setEnabled(false);
        viewEmpleados.jb_cancelar.setEnabled(true);
        viewEmpleados.jb_guardar.setEnabled(true);
    }

    public void eliminarActionPerformed() {
        enviarDatos();
        modelEmpleados.eliminarRegistro(viewEmpleados.jtf_id_empleado.getText());
        modelEmpleados.actualizarEmpleados();
        getValues();
    }

    public void actualizarActionPerformed() {
        des = "actualizar";
        habilitarCampos();
        viewEmpleados.jb_actualizar.setEnabled(false);
        viewEmpleados.jb_eliminar.setEnabled(false);
        viewEmpleados.jb_reporte.setEnabled(false);
        viewEmpleados.jb_nuevo.setEnabled(false);
        viewEmpleados.jb_cancelar.setEnabled(true);
        viewEmpleados.jb_guardar.setEnabled(true);

    }

    public void reporteActionPerformed() {

    }

    private void enviarDatos() {
        modelEmpleados.setNombre(viewEmpleados.jtf_nombre_empleado.getText());
        modelEmpleados.setApe_paterno(viewEmpleados.jtf_app_empleado.getText());
        modelEmpleados.setApe_materno(viewEmpleados.jtf_apm_empleado.getText());
        modelEmpleados.setCalle(viewEmpleados.jtf_calle_empleado.getText());
        modelEmpleados.setNumero(viewEmpleados.jtf_numero_empleado.getText());
        modelEmpleados.setColonia(viewEmpleados.jtf_colonia_empleado.getText());
        modelEmpleados.setTelefono(viewEmpleados.jtf_telefono_empleado.getText());
        modelEmpleados.setRFC(viewEmpleados.jtf_rfc_empleado.getText());
        modelEmpleados.setId_empleado(viewEmpleados.jtf_id_empleado.getText());
    }

    private void getValues() {

        viewEmpleados.jtf_id_empleado.setText(modelEmpleados.getId_empleado());
        viewEmpleados.jtf_nombre_empleado.setText(modelEmpleados.getNombre());
        viewEmpleados.jtf_app_empleado.setText(modelEmpleados.getApe_paterno());
        viewEmpleados.jtf_apm_empleado.setText(modelEmpleados.getApe_materno());
        viewEmpleados.jtf_calle_empleado.setText(modelEmpleados.getCalle());
        viewEmpleados.jtf_colonia_empleado.setText(modelEmpleados.getColonia());
        viewEmpleados.jtf_numero_empleado.setText(modelEmpleados.getNumero());
        viewEmpleados.jtf_telefono_empleado.setText(modelEmpleados.getTelefono());
        viewEmpleados.jtf_rfc_empleado.setText(modelEmpleados.getRFC());

    }

    private void limpiarCampos() {
        viewEmpleados.jtf_apm_empleado.setText("");
        viewEmpleados.jtf_app_empleado.setText("");
        viewEmpleados.jtf_nombre_empleado.setText("");
        viewEmpleados.jtf_numero_empleado.setText("");
        viewEmpleados.jtf_id_empleado.setText("");
        viewEmpleados.jtf_calle_empleado.setText("");
        viewEmpleados.jtf_colonia_empleado.setText("");
        viewEmpleados.jtf_telefono_empleado.setText("");
        viewEmpleados.jtf_rfc_empleado.setText("");
    }

    public void habilitarCampos() {
        viewEmpleados.jtf_apm_empleado.setEditable(true);
        viewEmpleados.jtf_app_empleado.setEditable(true);
        viewEmpleados.jtf_calle_empleado.setEditable(true);
        viewEmpleados.jtf_numero_empleado.setEditable(true);
        viewEmpleados.jtf_colonia_empleado.setEditable(true);
        viewEmpleados.jtf_nombre_empleado.setEditable(true);
        viewEmpleados.jtf_telefono_empleado.setEditable(true);
        viewEmpleados.jtf_rfc_empleado.setEditable(true);
    }

    public void deshabilitarCampos() {
        viewEmpleados.jtf_apm_empleado.setEditable(false);
        viewEmpleados.jtf_app_empleado.setEditable(false);
        viewEmpleados.jtf_calle_empleado.setEditable(false);
        viewEmpleados.jtf_numero_empleado.setEditable(false);
        viewEmpleados.jtf_colonia_empleado.setEditable(false);
        viewEmpleados.jtf_nombre_empleado.setEditable(false);
        viewEmpleados.jtf_telefono_empleado.setEditable(false);
        viewEmpleados.jtf_rfc_empleado.setEditable(false);
    }

}
