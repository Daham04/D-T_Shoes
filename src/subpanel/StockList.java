package subpanel;

import gui.Dashboard;
import gui.InvoiceManagement;
import gui.SignIn;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class StockList extends javax.swing.JFrame {

    Dashboard dashboard;
    InvoiceManagement invoice;

    public void setInvoice(InvoiceManagement invoice) {
        this.invoice = invoice;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public StockList() {
        initComponents();
        loadStock("SELECT * FROM `stock` INNER JOIN `product`\n"
                + "ON `stock`.`p_id` = `product`.`p_id`\n"
                + "INNER JOIN `brand`\n"
                + "ON `product`.`b_id` = `brand`.`b_id`\n"
                + "INNER JOIN `category`\n"
                + "ON `product`.`c_id` = `category`.`c_id`\n"
                + "INNER JOIN `main_category`\n"
                + "ON `main_category`.mc_id = `category`.`mc_id`\n"
                + "INNER JOIN `sub_category`\n"
                + "ON `sub_category`.sc_id = `category`.`sc_id`\n"
                + "INNER JOIN `size`\n"
                + "ON `size`.`s_id` = `stock`.`s_id`\n"
                + "INNER JOIN `color`\n"
                + "ON `stock`.`co_id` = `color`.`co_id`");

    }

    private void loadStock(String query) {

        try {

            ResultSet stockResultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            while (stockResultSet.next()) {
                String stockBarcode = stockResultSet.getString("stock.barcode");
                String productId = stockResultSet.getString("product.p_id");
                String productTitle = stockResultSet.getString("product.title");
                String brandName = stockResultSet.getString("brand.b_name");
                String mainCategory = stockResultSet.getString("main_category.mc_name");
                String subCategory = stockResultSet.getString("sub_category.sc_name");
                String size = stockResultSet.getString("size.s_name");
                String colorName = stockResultSet.getString("color.co_name");
                String price = stockResultSet.getString("stock.price");
                String availableqty = stockResultSet.getString("stock.available_qty");

                Vector vector = new Vector();
                vector.add(stockBarcode);
                vector.add(productId);
                vector.add(productTitle);
                vector.add(brandName);
                vector.add(mainCategory);
                vector.add(subCategory);
                vector.add(size);
                vector.add(colorName);
                vector.add(price);
                vector.add(availableqty);

                model.addRow(vector);
                jTable2.setModel(model);
            }

        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(465, 402));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Search");

        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField6.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
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
                        .addContainerGap(691, Short.MAX_VALUE))))
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

        kGradientPanel2.setToolTipText("Title Bar");
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 117, 105));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(479, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user (8).png"))); // NOI18N
        jLabel1.setText("Select Stock");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setIconTextGap(10);
        jLabel1.setPreferredSize(new java.awt.Dimension(168, 40));

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product ID", "Product Title", "Brand", "Main Category", "Sub Category", "Size", "Color", "Selling Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dashboard.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int selectedRow = jTable2.getSelectedRow();

        if (evt.getClickCount() == 2 && selectedRow != -1) {
            invoice.getJTextField2().setText(String.valueOf(jTable2.getValueAt(selectedRow, 0)));
            invoice.getJLabel13().setText(String.valueOf(jTable2.getValueAt(selectedRow, 1)));
            invoice.getJLabel14().setText(String.valueOf(jTable2.getValueAt(selectedRow, 2)));
            invoice.getJLabel15().setText(String.valueOf(jTable2.getValueAt(selectedRow, 3)));
            invoice.getJLabel16().setText(String.valueOf(jTable2.getValueAt(selectedRow, 4)));
            invoice.getJLabel17().setText(String.valueOf(jTable2.getValueAt(selectedRow, 5)));
            invoice.getJLabel18().setText(String.valueOf(jTable2.getValueAt(selectedRow, 6)));
            invoice.getJLabel19().setText(String.valueOf(jTable2.getValueAt(selectedRow, 7)));
            invoice.getJLabel20().setText(String.valueOf(jTable2.getValueAt(selectedRow, 8)));
            invoice.getJLabel22().setText(String.valueOf(jTable2.getValueAt(selectedRow, 9)));
            invoice.getJTextField2().setEnabled(false);
            dashboard.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

        String text = jTextField6.getText();
        loadStock("SELECT * FROM `stock` INNER JOIN `product`"
                + "ON `stock`.`p_id` = `product`.`p_id`"
                + "INNER JOIN `brand`"
                + "ON `product`.`b_id` = `brand`.`b_id`"
                + "INNER JOIN `category`"
                + "ON `product`.`c_id` = `category`.`c_id`"
                + "INNER JOIN `main_category`"
                + "ON `main_category`.mc_id = `category`.`mc_id`"
                + "INNER JOIN `sub_category`"
                + "ON `sub_category`.sc_id = `category`.`sc_id`"
                + "INNER JOIN `size`"
                + "ON `size`.`s_id` = `stock`.`s_id`"
                + "INNER JOIN `color`"
                + "ON `stock`.`co_id` = `color`.`co_id` "
                + "WHERE `product`.`title` LIKE '%" + text + "%' OR `stock`.`barcode` LIKE '%" + text + "%'");
    }//GEN-LAST:event_jTextField6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField6;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
