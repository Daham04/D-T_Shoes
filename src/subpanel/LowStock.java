package subpanel;

import gui.Dashboard;
import gui.SignIn;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class LowStock extends javax.swing.JDialog {

    Dashboard dashboard;

    public LowStock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dashboard = (Dashboard) parent;
        loadBrandTable();
    }

    private void loadBrandTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            ResultSet stockResultSet = MySQL.execute("SELECT * FROM `stock` INNER JOIN `product`"
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
                    + "WHERE `stock`.`available_qty`='0'");
            while (stockResultSet.next()) {
                Vector vector = new Vector();
                vector.add(stockResultSet.getString("stock.barcode"));
                vector.add(stockResultSet.getString("product.p_id"));
                vector.add(stockResultSet.getString("product.title"));
                vector.add(stockResultSet.getString("brand.b_name"));
                vector.add(stockResultSet.getString("main_category.mc_name"));
                vector.add(stockResultSet.getString("sub_category.sc_name"));
                vector.add(stockResultSet.getString("size.s_name"));
                vector.add(stockResultSet.getString("color.co_name"));
                vector.add(stockResultSet.getString("stock.price"));
                vector.add(stockResultSet.getString("stock.available_qty"));
                model.addRow(vector);
            }

        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setToolTipText("Title Bar");
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 117, 105));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(500, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bell (2).png"))); // NOI18N
        jLabel1.setText("Low Stock");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
