
package views;




public class ViewMain extends javax.swing.JFrame {

 
    public ViewMain() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_puntos = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmi_salir = new javax.swing.JMenuItem();
        jmi_administrar = new javax.swing.JMenu();
        jm_empleados = new javax.swing.JMenuItem();
        jm_proveedores = new javax.swing.JMenuItem();
        jm_proveedores1 = new javax.swing.JMenuItem();
        jm_proveedores2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(181, 50, 31));
        setUndecorated(true);

        jMenuBar1.setBackground(new java.awt.Color(46, 125, 50));
        jMenuBar1.setForeground(new java.awt.Color(3, 82, 200));

        jm_puntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ellipsis.png"))); // NOI18N

        jMenuItem3.setBackground(new java.awt.Color(46, 125, 50));
        jMenuItem3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(254, 254, 254));
        jMenuItem3.setText("Cerrar Sesion");
        jMenuItem3.setContentAreaFilled(false);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jm_puntos.add(jMenuItem3);

        jmi_salir.setBackground(new java.awt.Color(46, 125, 50));
        jmi_salir.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jmi_salir.setForeground(new java.awt.Color(254, 254, 254));
        jmi_salir.setText("Salir");
        jmi_salir.setContentAreaFilled(false);
        jm_puntos.add(jmi_salir);

        jMenuBar1.add(jm_puntos);

        jmi_administrar.setBackground(new java.awt.Color(254, 254, 254));
        jmi_administrar.setForeground(new java.awt.Color(254, 254, 254));
        jmi_administrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clipboard-with-pencil-.png"))); // NOI18N
        jmi_administrar.setText("Administrar");
        jmi_administrar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jm_empleados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jm_empleados.setBackground(new java.awt.Color(46, 125, 50));
        jm_empleados.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_empleados.setForeground(new java.awt.Color(254, 254, 254));
        jm_empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group.png"))); // NOI18N
        jm_empleados.setText("Empleados");
        jmi_administrar.add(jm_empleados);

        jm_proveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jm_proveedores.setBackground(new java.awt.Color(46, 125, 50));
        jm_proveedores.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_proveedores.setForeground(new java.awt.Color(254, 254, 254));
        jm_proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group.png"))); // NOI18N
        jm_proveedores.setText("Proveedores");
        jmi_administrar.add(jm_proveedores);

        jm_proveedores1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jm_proveedores1.setBackground(new java.awt.Color(46, 125, 50));
        jm_proveedores1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_proveedores1.setForeground(new java.awt.Color(254, 254, 254));
        jm_proveedores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delivery-package-opened.png"))); // NOI18N
        jm_proveedores1.setText("Productos");
        jmi_administrar.add(jm_proveedores1);

        jm_proveedores2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jm_proveedores2.setBackground(new java.awt.Color(46, 125, 50));
        jm_proveedores2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_proveedores2.setForeground(new java.awt.Color(254, 254, 254));
        jm_proveedores2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer.png"))); // NOI18N
        jm_proveedores2.setText("Clientes");
        jmi_administrar.add(jm_proveedores2);

        jMenuBar1.add(jmi_administrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1142, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JMenuItem jm_empleados;
    public javax.swing.JMenuItem jm_proveedores;
    public javax.swing.JMenuItem jm_proveedores1;
    public javax.swing.JMenuItem jm_proveedores2;
    public javax.swing.JMenu jm_puntos;
    public javax.swing.JMenu jmi_administrar;
    public javax.swing.JMenuItem jmi_salir;
    // End of variables declaration//GEN-END:variables
}

