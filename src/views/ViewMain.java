
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_puntos = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmi_salir = new javax.swing.JMenuItem();
        jmi_administrar1 = new javax.swing.JMenu();
        jm_historial_compras = new javax.swing.JMenuItem();
        jm_registrar_compra = new javax.swing.JMenuItem();
        jmi_administrar2 = new javax.swing.JMenu();
        jm_historial_ventas = new javax.swing.JMenuItem();
        jm_caja = new javax.swing.JMenuItem();
        jmi_administrar3 = new javax.swing.JMenu();
        jm_empleados1 = new javax.swing.JMenuItem();
        jmi_administrar4 = new javax.swing.JMenu();
        jm_empleados2 = new javax.swing.JMenuItem();
        jmi_administrar = new javax.swing.JMenu();
        jm_empleados = new javax.swing.JMenuItem();
        jm_proveedores = new javax.swing.JMenuItem();
        jm_proveedores1 = new javax.swing.JMenuItem();
        jm_clientes = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(181, 50, 31));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(76, 175, 80));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/JODYSo (4).png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(440, 90, 500, 500);

        jMenuBar1.setBackground(new java.awt.Color(48, 48, 48));
        jMenuBar1.setForeground(new java.awt.Color(3, 82, 200));

        jm_puntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ellipsis.png"))); // NOI18N

        jMenuItem3.setBackground(new java.awt.Color(48, 48, 48));
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

        jmi_salir.setBackground(new java.awt.Color(48, 48, 48));
        jmi_salir.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jmi_salir.setForeground(new java.awt.Color(254, 254, 254));
        jmi_salir.setText("Salir");
        jmi_salir.setContentAreaFilled(false);
        jm_puntos.add(jmi_salir);

        jMenuBar1.add(jm_puntos);

        jmi_administrar1.setBackground(new java.awt.Color(48, 48, 48));
        jmi_administrar1.setForeground(new java.awt.Color(254, 254, 254));
        jmi_administrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bolsa-de-dinero.png"))); // NOI18N
        jmi_administrar1.setText("Compras");
        jmi_administrar1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jm_historial_compras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jm_historial_compras.setBackground(new java.awt.Color(48, 48, 48));
        jm_historial_compras.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_historial_compras.setForeground(new java.awt.Color(254, 254, 254));
        jm_historial_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/prueba.png"))); // NOI18N
        jm_historial_compras.setText("Hisorial");
        jmi_administrar1.add(jm_historial_compras);

        jm_registrar_compra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jm_registrar_compra.setBackground(new java.awt.Color(48, 48, 48));
        jm_registrar_compra.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_registrar_compra.setForeground(new java.awt.Color(254, 254, 254));
        jm_registrar_compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dinero.png"))); // NOI18N
        jm_registrar_compra.setText("Registrar");
        jmi_administrar1.add(jm_registrar_compra);

        jMenuBar1.add(jmi_administrar1);

        jmi_administrar2.setBackground(new java.awt.Color(48, 48, 48));
        jmi_administrar2.setForeground(new java.awt.Color(254, 254, 254));
        jmi_administrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/monedas.png"))); // NOI18N
        jmi_administrar2.setText("Ventas");
        jmi_administrar2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jm_historial_ventas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jm_historial_ventas.setBackground(new java.awt.Color(48, 48, 48));
        jm_historial_ventas.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_historial_ventas.setForeground(new java.awt.Color(254, 254, 254));
        jm_historial_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/prueba.png"))); // NOI18N
        jm_historial_ventas.setText("Historial");
        jmi_administrar2.add(jm_historial_ventas);

        jm_caja.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jm_caja.setBackground(new java.awt.Color(48, 48, 48));
        jm_caja.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_caja.setForeground(new java.awt.Color(254, 254, 254));
        jm_caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cash-register.png"))); // NOI18N
        jm_caja.setText("Caja");
        jmi_administrar2.add(jm_caja);

        jMenuBar1.add(jmi_administrar2);

        jmi_administrar3.setBackground(new java.awt.Color(48, 48, 48));
        jmi_administrar3.setForeground(new java.awt.Color(254, 254, 254));
        jmi_administrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/embalaje.png"))); // NOI18N
        jmi_administrar3.setText("Almacen");
        jmi_administrar3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jm_empleados1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jm_empleados1.setBackground(new java.awt.Color(48, 48, 48));
        jm_empleados1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_empleados1.setForeground(new java.awt.Color(254, 254, 254));
        jm_empleados1.setText("Ver almacen");
        jmi_administrar3.add(jm_empleados1);

        jMenuBar1.add(jmi_administrar3);

        jmi_administrar4.setBackground(new java.awt.Color(48, 48, 48));
        jmi_administrar4.setForeground(new java.awt.Color(254, 254, 254));
        jmi_administrar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf1.png"))); // NOI18N
        jmi_administrar4.setText("Reportes");
        jmi_administrar4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jm_empleados2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jm_empleados2.setBackground(new java.awt.Color(48, 48, 48));
        jm_empleados2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_empleados2.setForeground(new java.awt.Color(254, 254, 254));
        jm_empleados2.setText("Generar");
        jmi_administrar4.add(jm_empleados2);

        jMenuBar1.add(jmi_administrar4);

        jmi_administrar.setBackground(new java.awt.Color(48, 48, 48));
        jmi_administrar.setForeground(new java.awt.Color(254, 254, 254));
        jmi_administrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/diseno.png"))); // NOI18N
        jmi_administrar.setText("Control");
        jmi_administrar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jm_empleados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jm_empleados.setBackground(new java.awt.Color(48, 48, 48));
        jm_empleados.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_empleados.setForeground(new java.awt.Color(254, 254, 254));
        jm_empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/jefe.png"))); // NOI18N
        jm_empleados.setText("Empleados");
        jmi_administrar.add(jm_empleados);

        jm_proveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jm_proveedores.setBackground(new java.awt.Color(48, 48, 48));
        jm_proveedores.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_proveedores.setForeground(new java.awt.Color(254, 254, 254));
        jm_proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/camion-de-reparto.png"))); // NOI18N
        jm_proveedores.setText("Proveedores");
        jmi_administrar.add(jm_proveedores);

        jm_proveedores1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jm_proveedores1.setBackground(new java.awt.Color(48, 48, 48));
        jm_proveedores1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_proveedores1.setForeground(new java.awt.Color(254, 254, 254));
        jm_proveedores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paquete.png"))); // NOI18N
        jm_proveedores1.setText("Productos");
        jmi_administrar.add(jm_proveedores1);

        jm_clientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jm_clientes.setBackground(new java.awt.Color(48, 48, 48));
        jm_clientes.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jm_clientes.setForeground(new java.awt.Color(254, 254, 254));
        jm_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/red.png"))); // NOI18N
        jm_clientes.setText("Clientes");
        jmi_administrar.add(jm_clientes);

        jMenuBar1.add(jmi_administrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JMenuItem jm_caja;
    public javax.swing.JMenuItem jm_clientes;
    public javax.swing.JMenuItem jm_empleados;
    public javax.swing.JMenuItem jm_empleados1;
    public javax.swing.JMenuItem jm_empleados2;
    public javax.swing.JMenuItem jm_historial_compras;
    public javax.swing.JMenuItem jm_historial_ventas;
    public javax.swing.JMenuItem jm_proveedores;
    public javax.swing.JMenuItem jm_proveedores1;
    public javax.swing.JMenu jm_puntos;
    public javax.swing.JMenuItem jm_registrar_compra;
    public javax.swing.JMenu jmi_administrar;
    public javax.swing.JMenu jmi_administrar1;
    public javax.swing.JMenu jmi_administrar2;
    public javax.swing.JMenu jmi_administrar3;
    public javax.swing.JMenu jmi_administrar4;
    public javax.swing.JMenuItem jmi_salir;
    // End of variables declaration//GEN-END:variables
}

