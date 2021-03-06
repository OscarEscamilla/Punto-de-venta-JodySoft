/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author oscar
 */
public class ViewSucursales extends javax.swing.JPanel {

    /**
     * Creates new form ViewSucursales
     */
    public ViewSucursales() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtf_buscar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_nuevo = new javax.swing.JButton();
        jtf_codigo_p = new javax.swing.JTextField();
        jtf_telefono = new javax.swing.JTextField();
        jb_reporte = new javax.swing.JButton();
        jb_actualizar = new javax.swing.JButton();
        jtf_calle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_numero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jb_guardar = new javax.swing.JButton();
        jtf_nombre = new javax.swing.JTextField();
        jb_cancelar = new javax.swing.JButton();
        jtf_id = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jb_eliminar = new javax.swing.JButton();
        jtf_colonia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_sucursales = new javax.swing.JTable();

        setBackground(new java.awt.Color(76, 175, 80));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(46, 125, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(254, 254, 254));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/online-store.png"))); // NOI18N
        jLabel8.setText("SUCURSALES");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
        jPanel1.add(jtf_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 229, 20));

        jLabel12.setFont(new java.awt.Font("AnjaliOldLipi", 1, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Buscar");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 70, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 60));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_nuevo.setFont(new java.awt.Font("AnjaliOldLipi", 1, 15)); // NOI18N
        jb_nuevo.setForeground(new java.awt.Color(46, 125, 50));
        jb_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-user.png"))); // NOI18N
        jb_nuevo.setText("Nuevo ");
        jb_nuevo.setBorderPainted(false);
        jb_nuevo.setContentAreaFilled(false);
        jPanel2.add(jb_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, -1, -1));

        jtf_codigo_p.setBackground(new java.awt.Color(254, 254, 254));
        jtf_codigo_p.setForeground(new java.awt.Color(46, 125, 50));
        jtf_codigo_p.setBorder(null);
        jPanel2.add(jtf_codigo_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 229, 20));

        jtf_telefono.setBackground(new java.awt.Color(254, 254, 254));
        jtf_telefono.setForeground(new java.awt.Color(46, 125, 50));
        jtf_telefono.setBorder(null);
        jPanel2.add(jtf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 229, 20));

        jb_reporte.setBackground(new java.awt.Color(76, 175, 80));
        jb_reporte.setFont(new java.awt.Font("AnjaliOldLipi", 1, 15)); // NOI18N
        jb_reporte.setForeground(new java.awt.Color(46, 125, 50));
        jb_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf1.png"))); // NOI18N
        jb_reporte.setText("Reporte");
        jb_reporte.setBorderPainted(false);
        jb_reporte.setContentAreaFilled(false);
        jPanel2.add(jb_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 180, -1, -1));

        jb_actualizar.setFont(new java.awt.Font("AnjaliOldLipi", 1, 15)); // NOI18N
        jb_actualizar.setForeground(new java.awt.Color(46, 125, 50));
        jb_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exchange.png"))); // NOI18N
        jb_actualizar.setText("Actualizar");
        jb_actualizar.setBorderPainted(false);
        jb_actualizar.setContentAreaFilled(false);
        jPanel2.add(jb_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 60, -1, -1));

        jtf_calle.setBackground(new java.awt.Color(254, 254, 254));
        jtf_calle.setForeground(new java.awt.Color(46, 125, 50));
        jtf_calle.setBorder(null);
        jPanel2.add(jtf_calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 229, 20));

        jLabel6.setFont(new java.awt.Font("Loma", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(46, 125, 50));
        jLabel6.setText("Codigo postal");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 150, -1));

        jLabel4.setFont(new java.awt.Font("Loma", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(46, 125, 50));
        jLabel4.setText("Telefono");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 150, -1));

        jtf_numero.setBackground(new java.awt.Color(254, 254, 254));
        jtf_numero.setForeground(new java.awt.Color(46, 125, 50));
        jtf_numero.setBorder(null);
        jPanel2.add(jtf_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 229, 20));

        jLabel7.setFont(new java.awt.Font("Loma", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(46, 125, 50));
        jLabel7.setText("Numero Exterior");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 150, -1));

        jLabel2.setFont(new java.awt.Font("Loma", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(46, 125, 50));
        jLabel2.setText("Nombre ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 85, -1));

        jLabel11.setFont(new java.awt.Font("Loma", 1, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(46, 125, 50));
        jLabel11.setText("Calle");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 150, -1));

        jb_guardar.setFont(new java.awt.Font("AnjaliOldLipi", 1, 15)); // NOI18N
        jb_guardar.setForeground(new java.awt.Color(46, 125, 50));
        jb_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/disquette.png"))); // NOI18N
        jb_guardar.setText("Guardar");
        jb_guardar.setBorderPainted(false);
        jb_guardar.setContentAreaFilled(false);
        jPanel2.add(jb_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, -1, -1));

        jtf_nombre.setBackground(new java.awt.Color(254, 254, 254));
        jtf_nombre.setForeground(new java.awt.Color(46, 125, 50));
        jtf_nombre.setBorder(null);
        jtf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nombreActionPerformed(evt);
            }
        });
        jPanel2.add(jtf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 229, 20));

        jb_cancelar.setFont(new java.awt.Font("AnjaliOldLipi", 1, 15)); // NOI18N
        jb_cancelar.setForeground(new java.awt.Color(46, 125, 50));
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/x-button.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setBorderPainted(false);
        jb_cancelar.setContentAreaFilled(false);
        jPanel2.add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 180, -1, -1));

        jtf_id.setBackground(new java.awt.Color(254, 254, 254));
        jtf_id.setForeground(new java.awt.Color(46, 125, 50));
        jtf_id.setBorder(null);
        jtf_id.setCaretColor(new java.awt.Color(2, 119, 189));
        jtf_id.setOpaque(false);
        jPanel2.add(jtf_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 229, 20));

        jSeparator3.setForeground(new java.awt.Color(46, 125, 50));
        jSeparator3.setToolTipText("");
        jSeparator3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 230, 20));

        jSeparator6.setForeground(new java.awt.Color(46, 125, 50));
        jSeparator6.setToolTipText("");
        jSeparator6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 230, 20));

        jSeparator7.setForeground(new java.awt.Color(46, 125, 50));
        jSeparator7.setToolTipText("");
        jSeparator7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 230, 20));

        jSeparator8.setForeground(new java.awt.Color(46, 125, 50));
        jSeparator8.setToolTipText("");
        jSeparator8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 230, 20));

        jSeparator9.setForeground(new java.awt.Color(46, 125, 50));
        jSeparator9.setToolTipText("");
        jSeparator9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 230, 20));

        jb_eliminar.setFont(new java.awt.Font("AnjaliOldLipi", 1, 15)); // NOI18N
        jb_eliminar.setForeground(new java.awt.Color(46, 125, 50));
        jb_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/del.png"))); // NOI18N
        jb_eliminar.setText("Elimiar");
        jb_eliminar.setBorderPainted(false);
        jb_eliminar.setContentAreaFilled(false);
        jPanel2.add(jb_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 120, -1, -1));

        jtf_colonia.setBackground(new java.awt.Color(254, 254, 254));
        jtf_colonia.setForeground(new java.awt.Color(46, 125, 50));
        jtf_colonia.setBorder(null);
        jPanel2.add(jtf_colonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 229, 20));

        jLabel9.setFont(new java.awt.Font("Loma", 1, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(46, 125, 50));
        jLabel9.setText("Colonia ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 150, -1));

        jSeparator4.setForeground(new java.awt.Color(46, 125, 50));
        jSeparator4.setToolTipText("");
        jSeparator4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 230, 20));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 1210, 300));

        jtb_sucursales.setAutoCreateRowSorter(true);
        jtb_sucursales.setBackground(new java.awt.Color(254, 254, 254));
        jtb_sucursales.setBorder(null);
        jtb_sucursales.setFont(new java.awt.Font("AnjaliOldLipi", 0, 15)); // NOI18N
        jtb_sucursales.setForeground(new java.awt.Color(1, 1, 1));
        jtb_sucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Telefono", "Numero Exterior", "Calle", "Colonia ", "Telefono", "Codigo Postal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtb_sucursales.setGridColor(new java.awt.Color(46, 125, 50));
        jtb_sucursales.setOpaque(false);
        jtb_sucursales.setSelectionBackground(new java.awt.Color(46, 125, 50));
        jtb_sucursales.setSelectionForeground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setViewportView(jtb_sucursales);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 1210, 180));
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JButton jb_actualizar;
    public javax.swing.JButton jb_cancelar;
    public javax.swing.JButton jb_eliminar;
    public javax.swing.JButton jb_guardar;
    public javax.swing.JButton jb_nuevo;
    public javax.swing.JButton jb_reporte;
    public javax.swing.JTable jtb_sucursales;
    public javax.swing.JTextField jtf_buscar;
    public javax.swing.JTextField jtf_calle;
    public javax.swing.JTextField jtf_codigo_p;
    public javax.swing.JTextField jtf_colonia;
    public javax.swing.JTextField jtf_id;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_numero;
    public javax.swing.JTextField jtf_telefono;
    // End of variables declaration//GEN-END:variables
}
