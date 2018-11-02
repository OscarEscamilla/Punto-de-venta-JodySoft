
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
        jToolBar2 = new javax.swing.JToolBar();
        jp_contenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmi_administrar = new javax.swing.JMenu();
        jm_empleados = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(181, 50, 31));
        setUndecorated(true);

        jToolBar2.setRollover(true);

        jp_contenedor.setBackground(new java.awt.Color(254, 254, 254));
        jp_contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuBar1.setBackground(new java.awt.Color(46, 125, 50));
        jMenuBar1.setForeground(new java.awt.Color(3, 82, 200));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ellipsis.png"))); // NOI18N

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
        jMenu1.add(jMenuItem3);

        jMenuItem4.setBackground(new java.awt.Color(46, 125, 50));
        jMenuItem4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(254, 254, 254));
        jMenuItem4.setText("Salir");
        jMenuItem4.setContentAreaFilled(false);
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jmi_administrar.setBackground(new java.awt.Color(254, 254, 254));
        jmi_administrar.setForeground(new java.awt.Color(254, 254, 254));
        jmi_administrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clipboard-with-pencil-.png"))); // NOI18N
        jmi_administrar.setText("Administrar");
        jmi_administrar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jm_empleados.setBackground(new java.awt.Color(46, 125, 50));
        jm_empleados.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_empleados.setForeground(new java.awt.Color(254, 254, 254));
        jm_empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group.png"))); // NOI18N
        jm_empleados.setText("Empleados");
        jmi_administrar.add(jm_empleados);

        jMenuBar1.add(jmi_administrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JToolBar jToolBar2;
    public javax.swing.JMenuItem jm_empleados;
    public javax.swing.JMenu jmi_administrar;
    public javax.swing.JPanel jp_contenedor;
    // End of variables declaration//GEN-END:variables
}

