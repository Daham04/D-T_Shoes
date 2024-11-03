package gui;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import subpanel.AddBrand;
import subpanel.AddCategory;

public class ProductManagement extends javax.swing.JPanel {

    public String brandId;//
    
    public ProductManagement() {
        initComponents();
        JTable[] jt = {jTable1};
        Dashboard.editTable(jt);
        loadProductTable();
    }

    private void loadProductTable() {

        String text = jTextField6.getText();

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `product` "
                    + "INNER JOIN `brand` ON `product`.`b_id` = `brand`.`b_id` "
                    + "INNER JOIN `category` ON`product`.`c_id` = `category`.`c_id` "
                    + "INNER JOIN `main_category` ON `category`.`mc_id` = `main_category`.`mc_id` "
                    + "INNER JOIN `sub_category` ON `category`.`sc_id` = `sub_category`.`sc_id` "
                    + "WHERE `b_name` LIKE '%" + text + "%' "
                    + "OR `title` LIKE '%" + text + "%' "
                    + "OR `mc_name` LIKE '%" + text + "%'"
                    + "OR `sc_name` LIKE '%" + text + "%' "
                    + "ORDER BY `product`.`p_id` ASC");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {

                Vector v = new Vector();
                v.add(resultSet.getString("p_id"));
                v.add(resultSet.getString("title"));
                v.add(resultSet.getString("b_name"));
                v.add(resultSet.getString("c_id"));
                v.add(resultSet.getString("mc_name"));
                v.add(resultSet.getString("sc_name"));
                model.addRow(v);
                jTable1.setModel(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void resetProductButton(){
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jButton1.setEnabled(true);
        jButton3.setEnabled(false);
        jTable1.setEnabled(true);
        jTextField6.setEnabled(true);
    }

    public String getBrandId(String brandId) {//
        this.brandId = brandId;
        return brandId;
    }
    
    public JTextField getJTextField5() {
        return jTextField5;
    }
    
    public JTextField getJTextField7() {
        return jTextField7;
    }

    public JTextField getJTextField8() {
        return jTextField8;
    }
    
    public JTextField getJTextField9() {
        return jTextField9;
    }

    Dashboard dashboard;

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setToolTipText("Product Management");
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/box (2).png"))); // NOI18N
        jLabel1.setText("Product Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(275, 654));

        jLabel5.setText("Sub Category ");

        jTextField9.setEditable(false);
        jTextField9.setPreferredSize(new java.awt.Dimension(69, 35));

        jButton1.setBackground(new java.awt.Color(27, 49, 77));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setText("Save Product");
        jButton1.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 117, 105));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setText("Clear All");
        jButton2.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(118, 48, 129));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton3.setText("Update Product");
        jButton3.setEnabled(false);
        jButton3.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Category Id");

        jLabel11.setText("Product Title ");

        jTextField4.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel7.setText("Brand");

        jTextField5.setEditable(false);
        jTextField5.setPreferredSize(new java.awt.Dimension(69, 35));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField7.setEditable(false);
        jTextField7.setPreferredSize(new java.awt.Dimension(69, 35));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField8.setEditable(false);
        jTextField8.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel12.setText("Main Category");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)
                            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 2, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addGap(12, 12, 12)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextField6.setPreferredSize(new java.awt.Dimension(350, 35));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N

        jLabel13.setText("Search Product");

        jButton4.setBackground(new java.awt.Color(27, 49, 77));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setText("Get Report");
        jButton4.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Title", "Brand", "Category Id", "Main Category", "Sub Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
/////////ADD
        String productTitle = jTextField4.getText();
        String Brand = jTextField5.getText();
        String categoryId = jTextField7.getText();
        
        if (productTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Title", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Brand.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Brand", "warning", JOptionPane.WARNING_MESSAGE);
        }else if (categoryId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Category Id", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `product` "
                        + "INNER JOIN `category` ON `product`.`c_id` = `category`.`c_id` "
                        + "WHERE `title` = '" + productTitle + "' "
                          + "AND `b_id` = '" + brandId + "' "
                          + "AND `product`.`c_id` = '" + categoryId + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Product already exists!", "warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    
                        MySQL.execute("INSERT INTO `product` (`title`,`b_id`,`c_id`) "
                            + "VALUES ('" + productTitle + "','" + brandId + "','" + categoryId + "')");
                        JOptionPane.showMessageDialog(this, "Product added successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

                        loadProductTable();
                        
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
/////////UPDATE
        String productTitle = jTextField4.getText();
        String Brand = jTextField5.getText();
        String categoryId = jTextField7.getText();

        if (productTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Title", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Brand.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Brand", "warning", JOptionPane.WARNING_MESSAGE);
        }else if (categoryId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Category Id", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `product` "
                        + "INNER JOIN `category` ON `product`.`c_id` = `category`.`c_id` "
                        + "WHERE `title` = '" + productTitle + "' "
                        + "AND `b_id` = '" + brandId + "' "
                        + "AND `product`.`c_id` = '" + categoryId + "'");
                
                
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Product already exists!", "warning", JOptionPane.WARNING_MESSAGE);
                } else {
                        int selectedRow = jTable1.getSelectedRow();
                        String productId = String.valueOf(jTable1.getValueAt(selectedRow, 0));
                                        
                        MySQL.execute("UPDATE `product` SET "
                             + "`title` = '" + productTitle + "',"
                             + "`b_id`='" + brandId + "',"
                             + "`c_id`='" + categoryId + "'"
                             + " WHERE `p_id` = '" + productId + "'");
                        
                        loadProductTable();
                        resetProductButton();
                        
                        JOptionPane.showMessageDialog(this, "Product updated successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

                        
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        AddBrand addBrand = new AddBrand();
        addBrand.setDashboard(dashboard);
        addBrand.setProductManagement(this);
        addBrand.setVisible(true);
        dashboard.setEnabled(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
        loadProductTable();
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        if (evt.getClickCount() == 2) {

            jTable1.setEnabled(false);
            jButton1.setEnabled(false);
            jButton3.setEnabled(true);
            jTextField6.setEnabled(false);

            int selectedRow = jTable1.getSelectedRow();
            
            String productId = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            try {
                
                ResultSet resultSet = MySQL.execute("SELECT * FROM `product` WHERE `p_id` = '" + productId + "'");
                
                if (resultSet.next()) {
                    brandId = resultSet.getString("b_id");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            String productTitle = String.valueOf(jTable1.getValueAt(selectedRow, 1));
            jTextField4.setText(productTitle);

            String Brand = String.valueOf(jTable1.getValueAt(selectedRow, 2));
            jTextField5.setText(Brand);

            String categoryId = String.valueOf(jTable1.getValueAt(selectedRow, 3));
            jTextField7.setText(categoryId);

            String mainCategory = String.valueOf(jTable1.getValueAt(selectedRow, 4));
            jTextField8.setText(mainCategory);
            
            String subCategory = String.valueOf(jTable1.getValueAt(selectedRow, 5));
            jTextField9.setText(subCategory);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here: 
        AddCategory addCategory = new AddCategory();
        addCategory.setDashboard(dashboard);
        addCategory.setProductManagement(this);
        addCategory.setVisible(true);
        dashboard.setEnabled(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadProductTable();
        resetProductButton();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
         try {
            HashMap<String, Object> map1 = new HashMap<>();

            String reportPath = "/reports/product.jasper";

            JRDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream(reportPath), map1, dataSource);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
