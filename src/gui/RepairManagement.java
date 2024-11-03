package gui;

import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class RepairManagement extends javax.swing.JPanel {

    public RepairManagement() {
        initComponents();
        JTable[] jt = {jTable1};
        Dashboard.editTable(jt);
//        loadRepairTable();
        loadRepairCustomers("SELECT * FROM `repair` "
                + "INNER JOIN `order_status` ON `repair`.`order_status_id`=`order_status`.`id`");

        jTextField5.setEnabled(false);

        long barcode = System.currentTimeMillis();
        jTextField5.setText(String.valueOf(barcode));
    }

    private void loadRepairCustomers(String query) {

        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            model.setRowCount(0);

            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("barcode"));
                v.add(resultSet.getString("customer_mobile"));
                v.add(resultSet.getString("qty"));
                v.add(resultSet.getString("description"));
                v.add(resultSet.getString("amount"));
                v.add(resultSet.getString("payment"));
                v.add(resultSet.getString("order_date"));
                v.add(resultSet.getString("deliver_date"));
                v.add(resultSet.getString("order_status.status"));

                model.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetPanel() {
        jTextField5.setText("");
        jTextField1.setText("");
        jFormattedTextField1.setText("");
        jTextArea1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);

        long barcode = System.currentTimeMillis();
        jTextField5.setText(String.valueOf(barcode));

        jButton2.setEnabled(false);
        jTextField6.setEnabled(true);
        jTextField1.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jTable1.setEnabled(true);
        jButton1.setEnabled(true);
        jButton3.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 720));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Amount");

        jTextField1.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel4.setText("Description");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("Customer Mobile");

        jButton1.setBackground(new java.awt.Color(27, 49, 77));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(118, 48, 129));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear All");
        jButton4.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField4.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel7.setText("Paid Amount");

        jLabel10.setText("Barcode");

        jTextField5.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel3.setText("Quantity");

        jLabel11.setText("Order Date");

        jLabel12.setText("Delivery Date");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jButton2.setBackground(new java.awt.Color(0, 117, 105));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setText("Update");
        jButton2.setEnabled(false);
        jButton2.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField3.setPreferredSize(new java.awt.Dimension(69, 35));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField1)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField6.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N

        jLabel8.setText("Search ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setToolTipText("Title Bar");
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user (8).png"))); // NOI18N
        jLabel1.setText("Repair Management");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Customer Mobile", "qty", "Description", "Amount", "Paid Amount", "Order Date", "Deliver Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
        jScrollPane3.setViewportView(jTable1);

        jLabel13.setText("Status ");

        jButton3.setBackground(new java.awt.Color(27, 49, 77));
        jButton3.setText("Change Status");
        jButton3.setEnabled(false);
        jButton3.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String Barcode = jTextField5.getText();
        String description = jTextArea1.getText();
        String amount = jTextField3.getText();
        String quantity = jFormattedTextField1.getText();
        String paidAmount = jTextField4.getText();
        String mobile = jTextField1.getText();
        Date orderDate = jDateChooser1.getDate();
        Date deliverDate = jDateChooser2.getDate();

        if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type mobile number!",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number!",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (jFormattedTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Integer.parseInt(quantity) <= 0) {
            JOptionPane.showMessageDialog(this, "Quantity Should be greater than Zero",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter a Description of the Repair",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the Total amount the customer should pay",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (paidAmount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the amount the customer have paid",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (orderDate == null) {
            JOptionPane.showMessageDialog(this, "Please Enter the Order Set Date", "warning",
                    JOptionPane.WARNING_MESSAGE);
        } else if (deliverDate == null) {
            JOptionPane.showMessageDialog(this, "Please Enter the Delivery Date", "warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM customer "
                        + "WHERE `mobile`='" + mobile + "'");

                if (resultSet.next()) {
                    MySQL.execute("INSERT INTO `repair` "
                            + "(`barcode`,`description`,`amount`,`qty`,`payment`,`customer_mobile`,"
                            + "`order_date`,`deliver_date`) "
                            + "VALUES ('" + Barcode + "','" + description + "','" + amount + "',"
                            + "'" + quantity + "','" + paidAmount + "',"
                            + "'" + mobile + "','" + format.format(orderDate) + "',"
                            + "'" + format.format(deliverDate) + "')");
                    resetPanel();
                    loadRepairCustomers("SELECT * FROM `repair` "
                            + "INNER JOIN `order_status` ON `repair`.`order_status_id`=`order_status`.`id`");
                    JOptionPane.showMessageDialog(this, "Customer saved successfully!",
                            "information", JOptionPane.INFORMATION_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(this, "Register Customer Before proceeding",
                            "warning", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int selectedRow = jTable1.getSelectedRow();

        if (evt.getClickCount() == 1 && selectedRow != -1) {

            jButton3.setEnabled(true);

        } else if (evt.getClickCount() == 2 && selectedRow != -1) {

            jTable1.setEnabled(false);
            jButton2.setEnabled(true);
            jButton1.setEnabled(false);

            jTextField6.setEnabled(false);
            jTextField1.setEnabled(false);
            jDateChooser1.setEnabled(false);

            jTextField5.setText(String.valueOf(jTable1.getValueAt(selectedRow, 0)));
            jTextField1.setText(String.valueOf(jTable1.getValueAt(selectedRow, 1)));
            jFormattedTextField1.setText(String.valueOf(jTable1.getValueAt(selectedRow, 2)));
            jTextArea1.setText(String.valueOf(jTable1.getValueAt(selectedRow, 3)));
            jTextField3.setText(String.valueOf(jTable1.getValueAt(selectedRow, 4)));
            jTextField4.setText(String.valueOf(jTable1.getValueAt(selectedRow, 5)));

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = dateFormat.parse(String.valueOf(jTable1.getValueAt(selectedRow, 6)));
                Date date2 = dateFormat.parse(String.valueOf(jTable1.getValueAt(selectedRow, 7)));

                jDateChooser1.setDate(date1);
                jDateChooser2.setDate(date2);
            } catch (ParseException ex) {
                ex.printStackTrace();
                // Handle parsing exception
            }
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        resetPanel();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

        String text = jTextField6.getText();
        loadRepairCustomers("SELECT * FROM `repair` "
                + "INNER JOIN `order_status` ON `repair`.`order_status_id`=`order_status`.`id`"
                + "WHERE `barcode` LIKE '%" + text + "%' "
                + "OR `customer_mobile` LIKE '" + text + "%'"
                + "OR `description` LIKE '" + text + "%'"
                + "OR `deliver_date` LIKE '" + text + "%'"
                + "OR `order_date` LIKE '" + text + "%'"
                + "OR `order_status`.`status` LIKE '" + text + "%'");
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String Barcode = jTextField5.getText();
        String description = jTextArea1.getText();
        String amount = jTextField3.getText();
        int quantity = Integer.parseInt(jFormattedTextField1.getText());
        String paidAmount = jTextField4.getText();
        String mobile = jTextField1.getText();
        Date orderDate = jDateChooser1.getDate();
        Date deliverDate = jDateChooser2.getDate();

        if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type mobile number!",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number!",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter a Description of the Repair",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the Total amount the customer should pay",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (paidAmount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the amount the customer have paid",
                    "warning", JOptionPane.WARNING_MESSAGE);
        } else if (orderDate == null) {
            JOptionPane.showMessageDialog(this, "Please Enter the Order Set Date", "warning",
                    JOptionPane.WARNING_MESSAGE);
        } else if (deliverDate == null) {
            JOptionPane.showMessageDialog(this, "Please Enter the Delivery Date", "warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                MySQL.execute("UPDATE `repair` SET "
                        + "`description`='" + description + "',"
                        + "`amount`='" + amount + "',"
                        + "`qty`='" + quantity + "',"
                        + "`payment`='" + paidAmount + "',"
                        + "`deliver_date`='" + format.format(deliverDate) + "'"
                        + "WHERE `barcode`='" + Barcode + "'");

                resetPanel();

                loadRepairCustomers("SELECT * FROM `repair` "
                        + "INNER JOIN `order_status` ON `repair`.`order_status_id`=`order_status`.`id`");

                JOptionPane.showMessageDialog(this, "Updated successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {

            String barcode = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            String status = String.valueOf(jTable1.getValueAt(selectedRow, 8));

            try {
                if (status.equals("inprogress")) {
                    MySQL.execute("UPDATE `repair` SET `order_status_id`='2' "
                            + "WHERE `barcode`='" + barcode + "'");
                } else {
                    MySQL.execute("UPDATE `repair` SET `order_status_id`='1' "
                            + "WHERE `barcode`='" + barcode + "'");
                }
                loadRepairCustomers("SELECT * FROM `repair` "
                        + "INNER JOIN `order_status` ON `repair`.`order_status_id`=`order_status`.`id`");

                JOptionPane.showMessageDialog(this, "status changed successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables

}
