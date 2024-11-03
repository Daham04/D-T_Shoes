package gui;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import subpanel.CustomProductDetails;

public class CustomManagement extends javax.swing.JPanel {

    Dashboard dashboard;

    private Boolean custometConfim = false;
    private String updatingBarcode;
    private Date orderedDate;

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public CustomManagement() {
        initComponents();
        loadCustomServicesTable();

        JTable[] jt = {jTable1};
        Dashboard.editTable(jt);
    }

    public void loadCustomServicesTable() {

        String searchText = jTextField7.getText();

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `other_service` "
                    + "INNER JOIN `order_status` ON `other_service`.`order_status_id`=`order_status`.`id`"
                    + "INNER JOIN `customer` ON `other_service`.`customer_mobile`=`customer`.`mobile`"
                    + "WHERE `barcode` LIKE '" + searchText + "%'");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Double totalAmount = Double.parseDouble(resultSet.getString("amount")) * Integer.parseInt(resultSet.getString("qty"));
                Vector v = new Vector();
                v.add(resultSet.getString("barcode"));
                v.add(resultSet.getString("description"));
                v.add(resultSet.getString("customer_mobile"));
                v.add(resultSet.getString("fname") + " " + resultSet.getString("lname"));
                v.add(resultSet.getString("amount"));
                v.add(resultSet.getString("qty"));
                v.add(totalAmount);
                v.add(resultSet.getString("payment"));
                v.add(resultSet.getString("order_date"));
                v.add(resultSet.getString("deliver_date"));
                v.add(resultSet.getString("status"));
                model.addRow(v);
                jTable1.setModel(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCustomOrderDetails() {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            String barcode = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            CustomProductDetails customProductDetails = new CustomProductDetails(barcode);
            customProductDetails.setDashboard(dashboard);
            customProductDetails.setCustomManagement(this);
            customProductDetails.setVisible(true);
            dashboard.setEnabled(false);
        }
    }

    private void clearAll() {
        jTextField1.setText("");
        jTextArea1.setText("");
        jTextField4.setText("");
        jTextField6.setText("");
        jTextField5.setText("");
        jDateChooser1.setDate(null);

        jLabel2.setText(" ");

        custometConfim = false;
        jTextField1.setEnabled(true);
        jButton5.setEnabled(true);
        jTextArea1.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField5.setEnabled(false);
        jDateChooser1.setEnabled(false);

        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
    }

    private void confirmCustomerMobile() {
        String customerMobileText = jTextField1.getText();

        if (customerMobileText.isEmpty()) {
            jLabel2.setForeground(new java.awt.Color(163, 0, 3));
            jLabel2.setText("Enter Customer Mobile");
        } else {

            try {
                ResultSet resultset = MySQL.execute("SELECT * FROM `customer` WHERE `mobile`='" + customerMobileText + "' ");
                if (resultset.next()) {
                    String customerName = resultset.getNString("fname") + " " + resultset.getNString("lname");
                    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                    jLabel2.setText("Name : " + customerName);

                    custometConfim = true;

                    jTextField1.setEnabled(false);
                    jButton5.setEnabled(false);
                    jTextArea1.setEnabled(true);
                    jTextField4.setEnabled(true);
                    jTextField6.setEnabled(true);
                    jTextField5.setEnabled(true);
                    jDateChooser1.setEnabled(true);

                } else {
                    jLabel2.setForeground(new java.awt.Color(163, 0, 3));
                    jLabel2.setText("Not a Registerd Customer Mobile");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setToolTipText("Title Bar");
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user (8).png"))); // NOI18N
        jLabel1.setText("Custom Product Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText(" ");

        jTextField1.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel3.setText("Description");

        jLabel5.setText("Product Amount (Rs.)");

        jTextField4.setEnabled(false);
        jTextField4.setPreferredSize(new java.awt.Dimension(69, 35));

        jButton1.setBackground(new java.awt.Color(27, 49, 77));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setText("Add Custom Service");
        jButton1.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 117, 105));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setText("Update Service");
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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel6.setText("Advance Payment (Rs.)");

        jTextField5.setEnabled(false);
        jTextField5.setPreferredSize(new java.awt.Dimension(69, 35));

        jButton5.setBackground(new java.awt.Color(27, 49, 77));
        jButton5.setText("Add");
        jButton5.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantity");

        jTextField6.setEnabled(false);
        jTextField6.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel8.setText("Date To Be Delivered");

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setEnabled(false);

        jLabel4.setText("Customer Mobile");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Search By Barcode");

        jTextField7.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N

        jButton7.setBackground(new java.awt.Color(27, 49, 77));
        jButton7.setText("More Details");
        jButton7.setEnabled(false);
        jButton7.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Description", "Customer Mobile", "Customer Name", "Amount", "Quantity", "Total Amount", "Paid Amount", "Orderd Date", "Deliver Date", "Order Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        loadCustomServicesTable();
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        confirmCustomerMobile();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clearAll();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        confirmCustomerMobile();

        String mobile = jTextField1.getText();
        String description = jTextArea1.getText();
        String amount = jTextField4.getText();
        String qty = jTextField6.getText();
        String advance = jTextField5.getText();
        Date deliverDate = jDateChooser1.getDate();

        if (!custometConfim) {
            JOptionPane.showMessageDialog(this, "Please Set Customer Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!amount.matches("\\-?\\d+\\.?\\d{0,2}")||Double.parseDouble(amount)<0) {
            JOptionPane.showMessageDialog(this, "Invalid Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!qty.matches("^[0-9]*$")||Double.parseDouble(qty)<0) {
            JOptionPane.showMessageDialog(this, "Invalid Qunatity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (advance.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Advance Payment", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!advance.matches("\\-?\\d+\\.?\\d{0,2}")||Double.parseDouble(advance)<0) {
            JOptionPane.showMessageDialog(this, "Invalid Advance Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if ((Double.parseDouble(amount) * Integer.parseInt(qty)) < Double.parseDouble(advance)) {
            JOptionPane.showMessageDialog(this, "Advance Payment Cannot Be Higher Than Full Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (deliverDate == null) {
            JOptionPane.showMessageDialog(this, "Invaid Date To Be Delivered", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Date date = new Date();

            if (!deliverDate.after(date)) {
                JOptionPane.showMessageDialog(this, "Date To Be Delivered Cannot be less than today", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String today = String.valueOf(format.format(date));
                String formattedDeleverDate = String.valueOf(format.format(deliverDate));
                long barcode = System.currentTimeMillis();

                try {
                    MySQL.execute("INSERT INTO `other_service` (`barcode`,`description`,`amount`,`qty`,`payment`,`customer_mobile`,`order_status_id`,`order_date`,`deliver_date`)"
                            + "VALUES ('" + barcode + "','" + description + "','" + amount + "','" + qty + "','" + advance + "','" + mobile + "','1','" + today + "','" + formattedDeleverDate + "')");
                    loadCustomServicesTable();
                    clearAll();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            jButton7.setEnabled(true);
        }

        if (evt.getClickCount() == 2 && selectedRow != -1) {

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse(String.valueOf(jTable1.getValueAt(selectedRow, 9)));

                Double amount = Double.parseDouble(String.valueOf(jTable1.getValueAt(selectedRow, 4)));
                Double advance = Double.parseDouble(String.valueOf(jTable1.getValueAt(selectedRow, 7)));

                jTextField1.setText(String.valueOf(jTable1.getValueAt(selectedRow, 2)));
                jTextArea1.setText(String.valueOf(jTable1.getValueAt(selectedRow, 1)));
                jLabel2.setText("Name : " + String.valueOf(jTable1.getValueAt(selectedRow, 3)));
                jTextField4.setText(dashboard.FORMAT.format(amount));
                jTextField6.setText(String.valueOf(jTable1.getValueAt(selectedRow, 5)));
                jTextField5.setText(dashboard.FORMAT.format(advance));
                jDateChooser1.setDate(date);

                updatingBarcode = String.valueOf(jTable1.getValueAt(selectedRow, 0));
                orderedDate = format.parse(String.valueOf(jTable1.getValueAt(selectedRow, 8)));

                jTextField1.setEnabled(false);
                jButton5.setEnabled(false);
                jTextArea1.setEnabled(true);
                jTextField4.setEnabled(true);
                jTextField6.setEnabled(true);
                jTextField5.setEnabled(true);
                jDateChooser1.setEnabled(true);

                jButton1.setEnabled(false);
                jButton2.setEnabled(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (evt.getClickCount() == 3 && selectedRow != -1){
            loadCustomOrderDetails();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String description = jTextArea1.getText();
        String amount = jTextField4.getText();
        String qty = jTextField6.getText();
        String advance = jTextField5.getText();
        Date deliverDate = jDateChooser1.getDate();

        if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!amount.matches("\\-?\\d+\\.?\\d{0,2}")||Double.parseDouble(amount)<0) {
            JOptionPane.showMessageDialog(this, "Invalid Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!qty.matches("^[0-9]*$")||Double.parseDouble(qty)<0) {
            JOptionPane.showMessageDialog(this, "Invalid Qunatity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (advance.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Advance Payment", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!advance.matches("\\-?\\d+\\.?\\d{0,2}")||Double.parseDouble(advance)<0) {
            JOptionPane.showMessageDialog(this, "Invalid Advance Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if ((Double.parseDouble(amount) * Integer.parseInt(qty)) < Double.parseDouble(advance)) {
            JOptionPane.showMessageDialog(this, "Advance Payment Cannot Be Higher Than Full Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (deliverDate == null) {
            JOptionPane.showMessageDialog(this, "Invaid Date To Be Delivered", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Date date = new Date();

            if (!deliverDate.after(orderedDate)) {
                JOptionPane.showMessageDialog(this, "Date To Be Delivered Cannot be less than Ordered Date", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String today = String.valueOf(format.format(date));
                String formattedDeleverDate = String.valueOf(format.format(deliverDate));

                try {
                    MySQL.execute("UPDATE `other_service` SET `description`='" + description + "', `amount`='" + amount + "', `qty`='" + qty + "', `payment`='" + advance + "', `deliver_date`='" + formattedDeleverDate + "'"
                            + "WHERE `barcode` ='" + updatingBarcode + "'  ");
                    loadCustomServicesTable();
                    clearAll();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        loadCustomOrderDetails();
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
