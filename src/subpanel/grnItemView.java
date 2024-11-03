/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subpanel;

import gui.Dashboard;
import gui.ReturnManagement;
import gui.SignIn;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author daham
 */
public class grnItemView extends javax.swing.JFrame {

    private ReturnManagement returnManagement;
    private Dashboard dashboard;

    String grnbarcode;

    public void setreturnManagement(ReturnManagement returnManagement) {
        this.returnManagement = returnManagement;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public void loadSupplierReturns(String grnbarcode) {

        try {

            ResultSet supplierResultSet = MySQL.execute("SELECT * FROM `grn_item` "
                    + "INNER JOIN `product`\n"
                    + "ON `product`.`p_id` = `grn_item`.`product_p_id`\n"
                    + "INNER JOIN `stock`\n"
                    + "ON `stock`.`p_id` = `product`.`p_id`\n"
                    + "INNER JOIN `color`\n"
                    + "ON `color`.`co_id` = `stock`.`co_id`\n"
                    + "INNER JOIN`size`\n"
                    + "ON `size`.`s_id`= `stock`.`s_id`\n"
                    + "INNER JOIN `grn`\n"
                    + "ON `grn`.barcode =`grn_item`.`grn_barcode`"
                    + "WHERE `grn_item`.`grn_barcode` = '" + grnbarcode + "'");

            DefaultTableModel model1 = (DefaultTableModel) jTable4.getModel();
            model1.setRowCount(0);

            while (supplierResultSet.next()) {
                String GRNitemId = supplierResultSet.getString("grn_item.id");
                String GrnBarcode = supplierResultSet.getString("grn.barcode");
                String productTitle = supplierResultSet.getString("title");
                String size = supplierResultSet.getString("s_name");
                String color = supplierResultSet.getString("co_name");
                String quantity = supplierResultSet.getString("qty");

                Vector vector1 = new Vector();
                vector1.add(GRNitemId);
                vector1.add(GrnBarcode);
                vector1.add(productTitle);
                vector1.add(size);
                vector1.add(color);
                vector1.add(quantity);

                model1.addRow(vector1);
                jTable4.setModel(model1);
            }

        } catch (Exception e) {
             SignIn.log1.warning(e.toString());
        }
    }

    /**
     * Creates new form grnItemView
     */
    public grnItemView() {
        initComponents();
        loadSupplierReturns(grnbarcode);
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
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(465, 402));

        kGradientPanel1.setToolTipText("Title Bar");
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 117, 105));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(147, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GRN Item");
        jLabel2.setPreferredSize(new java.awt.Dimension(73, 40));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Search");

        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField6.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN Item ID", "GRN Barcode", "Product", "Size", "Color", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:

        int row = jTable4.getSelectedRow();

        if (evt.getClickCount() == 2 && jTable4.getSelectedRow() != -1) {

            String qty = String.valueOf(jTable4.getValueAt(row, 5));
            int grnqty = Integer.parseInt(qty);
            if (grnqty == 0) {
                JOptionPane.showMessageDialog(this, "Product Quantity Zero Can't Return Product", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (returnManagement != null) {
                returnManagement.getjFormattedTextField6().setText(String.valueOf(jTable4.getValueAt(row, 0)));
                returnManagement.getjTextField9().setText(String.valueOf(jTable4.getValueAt(row, 2)));
                returnManagement.getjFormattedTextField7().setText(String.valueOf(jTable4.getValueAt(row, 1)));
                returnManagement.getjTextField11().setText(String.valueOf(jTable4.getValueAt(row, 4)));
                returnManagement.getjFormattedTextField8().setText(String.valueOf(jTable4.getValueAt(row, 3)));
                dashboard.setEnabled(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:

        String search = jTextField6.getText();

        try {

            ResultSet supplierResultSet = MySQL.execute("SELECT * FROM `grn_item` "
                    + "INNER JOIN `product`\n"
                    + "ON `product`.`p_id` = `grn_item`.`product_p_id`\n"
                    + "INNER JOIN `stock`\n"
                    + "ON `stock`.`p_id` = `product`.`p_id`\n"
                    + "INNER JOIN `color`\n"
                    + "ON `color`.`co_id` = `stock`.`co_id`\n"
                    + "INNER JOIN`size`\n"
                    + "ON `size`.`s_id`= `stock`.`s_id`\n"
                    + "INNER JOIN `grn`\n"
                    + "ON `grn`.barcode =`grn_item`.`grn_barcode`"
                    + "WHERE `grn_item`.`id` LIKE '%" + search + "%'"
                    + "OR `grn`.`barcode` LIKE '%" + search + "%'"
                    + "OR  `product`.`title` LIKE '%" + search + "%'");

            DefaultTableModel model1 = (DefaultTableModel) jTable4.getModel();
            model1.setRowCount(0);

            while (supplierResultSet.next()) {
                String GRNitemId = supplierResultSet.getString("grn_item.id");
                String GrnBarcode = supplierResultSet.getString("grn.barcode");
                String productTitle = supplierResultSet.getString("title");
                String size = supplierResultSet.getString("s_name");
                String color = supplierResultSet.getString("co_name");
                String quantity = supplierResultSet.getString("qty");

                Vector vector1 = new Vector();
                vector1.add(GRNitemId);
                vector1.add(GrnBarcode);
                vector1.add(productTitle);
                vector1.add(size);
                vector1.add(color);
                vector1.add(quantity);

                model1.addRow(vector1);
                jTable4.setModel(model1);
            }

        } catch (Exception e) {
             SignIn.log1.warning(e.toString());
        }


    }//GEN-LAST:event_jTextField6KeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      dashboard.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField6;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}