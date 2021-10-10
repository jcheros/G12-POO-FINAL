/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.view;

/**
 *
 * @author HP
 */
public class ConsultaVentasView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaVentasView
     */
    public ConsultaVentasView() {
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

        jpnConsultaDeVentas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbx_TipoPublicacion = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReporteConsultaDeVentas = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setTitle("CONSULTA DE VENTAS");

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel1.setText("SELECCIONA TIPO DE PUBLICACIÓN:");

        cbx_TipoPublicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_TipoPublicacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_TipoPublicacionItemStateChanged(evt);
            }
        });
        cbx_TipoPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_TipoPublicacionActionPerformed(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(0, 153, 51));
        btnConsultar.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        tblReporteConsultaDeVentas.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        tblReporteConsultaDeVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID VENTA ", "CLIENTE", "FECHA", "ID EMPLEADO", "ID PUBLICACIÓN", "CANTIDAD", "PRECIO", "DSCTO", "SUB-TOTAL", "IMPUESTO", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblReporteConsultaDeVentas);

        btnSalir.setBackground(new java.awt.Color(0, 102, 204));
        btnSalir.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnConsultaDeVentasLayout = new javax.swing.GroupLayout(jpnConsultaDeVentas);
        jpnConsultaDeVentas.setLayout(jpnConsultaDeVentasLayout);
        jpnConsultaDeVentasLayout.setHorizontalGroup(
            jpnConsultaDeVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnConsultaDeVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnConsultaDeVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnConsultaDeVentasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_TipoPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnConsultaDeVentasLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnConsultaDeVentasLayout.setVerticalGroup(
            jpnConsultaDeVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnConsultaDeVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnConsultaDeVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_TipoPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnConsultaDeVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnConsultaDeVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_TipoPublicacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_TipoPublicacionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_TipoPublicacionItemStateChanged

    private void cbx_TipoPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_TipoPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_TipoPublicacionActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbx_TipoPublicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnConsultaDeVentas;
    private javax.swing.JTable tblReporteConsultaDeVentas;
    // End of variables declaration//GEN-END:variables
}