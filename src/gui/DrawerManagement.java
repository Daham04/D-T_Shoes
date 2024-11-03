package gui;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.UserBean;

public class DrawerManagement extends javax.swing.JPanel {

    UserBean userbean;

    public DrawerManagement(UserBean userBean) {
        this.userbean = userBean;
        initComponents();
        JTable[] jt = {jTable1};
        Dashboard.editTable(jt);
        loadTransactions("");
    }

    private void reset() {
        jFormattedTextField1.setText("");
        jTextField6.setText("");
        jTextArea2.setText("");
        buttonGroup1.clearSelection();
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jTextField6.setEnabled(true);
        jTable1.setEnabled(true);
    }

    private void loadTransactions(String text) {
        try {
            ResultSet results = MySQL.execute("SELECT * FROM `drawer` "
                    + "INNER JOIN `transaction_type` ON `drawer`.`transaction_type_id`=`transaction_type`.`id` "
                    + "INNER JOIN `user` ON `drawer`.`user_id`=`user`.`id` "
                    + "WHERE `description` LIKE '%" + text + "%' "
                    + "OR `date_time` like '" + text + "%' "
                    + "OR `transaction_type`.`type` like '" + text + "%' "
                    + "OR `user`.`username` like '" + text + "%'");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (results.next()) {
                Vector v = new Vector();
                v.add(results.getString("drawer.id"));
                v.add(results.getString("drawer.amount"));
                v.add(results.getString("drawer.description"));
                v.add(results.getString("transaction_type.type"));
                v.add(results.getString("user.username"));
                v.add(results.getString("drawer.date_time"));
                model.addRow(v);
            }
        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setToolTipText("Title Bar");
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/money (3).png"))); // NOI18N
        jLabel1.setText("Drawer Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(275, 654));

        jLabel2.setText("Amount");

        jLabel3.setText("Description");

        jButton1.setBackground(new java.awt.Color(27, 49, 77));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setText("Add Drawer Change");
        jButton1.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 117, 105));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setText("Update Drawer Change");
        jButton2.setEnabled(false);
        jButton2.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(118, 48, 129));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setText("Clear All");
        jButton4.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(128, 35));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setPreferredSize(new java.awt.Dimension(164, 150));
        jScrollPane2.setViewportView(jTextArea2);

        jLabel4.setText("Transaction Type");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Add");
        jRadioButton1.setActionCommand("1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Deduct");
        jRadioButton2.setActionCommand("2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Search Transaction");

        jTextField6.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addComponent(jLabel8))
                .addContainerGap(389, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Amount", "Description", "Transaction Type", "Username", "Date & Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        loadTransactions(jTextField6.getText());
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String amount = jFormattedTextField1.getText();
        String description = jTextArea2.getText();

        if (amount.isEmpty()) {
            jFormattedTextField1.setText("0.00");
        } else if (Double.parseDouble(amount) <= 0) {
            JOptionPane.showMessageDialog(this, "Amount should be greater than zero", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type description", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select transaction type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String selectionId = buttonGroup1.getSelection().getActionCommand();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            try {

                MySQL.execute("INSERT INTO `drawer` (`description`,`amount`,`date_time`,`transaction_type_id`,`user_id`) "
                        + "VALUES ('" + description + "','" + Double.parseDouble(amount) + "','" + format.format(new Date()) + "',"
                        + "'" + selectionId + "','" + userbean.getId() + "')");
                reset();
                loadTransactions("");
                JOptionPane.showMessageDialog(this, "Transaction successfull", "Information", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
        loadTransactions("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String amount = jFormattedTextField1.getText();
        String description = jTextArea2.getText();

        if (amount.isEmpty()) {
            jFormattedTextField1.setText("0.00");
        } else if (Double.parseDouble(amount) <= 0) {
            JOptionPane.showMessageDialog(this, "Amount should be greater than zero", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type description", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select transaction type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String selectionId = buttonGroup1.getSelection().getActionCommand();
            String id = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            try {

                MySQL.execute("UPDATE `drawer` SET `description`='" + description + "', `amount`='" + Double.parseDouble(amount)
                        + "', `transaction_type_id`='" + selectionId + "' WHERE `id`='" + id + "'");
                reset();
                loadTransactions("");
                JOptionPane.showMessageDialog(this, "Transaction updated successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int selectedRow = jTable1.getSelectedRow();
        if (evt.getClickCount() == 2 && selectedRow != -1) {
            jButton1.setEnabled(false);
            jButton2.setEnabled(true);
            jTextField6.setEnabled(false);
            jTable1.setEnabled(false);
            jFormattedTextField1.setText(String.valueOf(jTable1.getValueAt(selectedRow, 1)));
            jTextArea2.setText(String.valueOf(jTable1.getValueAt(selectedRow, 2)));
            String transactionType = String.valueOf(jTable1.getValueAt(selectedRow, 3));
            if (transactionType.equals("Add")) {
                jRadioButton1.setSelected(true);
            }
            if (transactionType.equals("Deduct")) {
                jRadioButton2.setSelected(true);
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField6;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
