package gui;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class UserManagementPanel extends javax.swing.JPanel {

    private HashMap<String, String> typeMap = new HashMap<>();

    public UserManagementPanel() {
        initComponents();
        JTable[] jt = {jTable1};
        Dashboard.editTable(jt);
        loadUserTypes();
        loadUsers("SELECT * FROM `user` "
                + "INNER JOIN `user_type` ON `user`.`user_type_id`=`user_type`.`id` "
                + "INNER JOIN `status` ON `user`.`status_id`=`status`.`id`");

    }

    private void loadUserTypes() {
        try {
            ResultSet result = MySQL.execute("SELECT * FROM `user_type`");
            Vector v = new Vector();
            v.add("Select");
            while (result.next()) {
                v.add(result.getString("type"));
                typeMap.put(result.getString("type"), result.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }
    }

    private void loadUsers(String query) {

        try {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet results = MySQL.execute(query);

            while (results.next()) {
                Vector v = new Vector();
                v.add(results.getString("id"));
                v.add(results.getString("fname"));
                v.add(results.getString("lname"));
                v.add(results.getString("mobile"));
                v.add(results.getString("username"));
                v.add(results.getString("user_type.type"));
                v.add(results.getString("status.status"));
                model.addRow(v);
            }

        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }

    }

    private void resetUserPanel() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField6.setText("");
        jButton3.setEnabled(false);
        jButton2.setEnabled(false);
        jTable1.setEnabled(true);
        jTextField6.setEnabled(true);
        jButton1.setEnabled(true);
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
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setToolTipText("Title Bar");
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user (8).png"))); // NOI18N
        jLabel1.setText("User Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(275, 654));

        jLabel2.setText("First Name");

        jTextField1.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel3.setText("Last Name");

        jTextField2.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel4.setText("Mobile");

        jTextField3.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel5.setText("Username");

        jTextField4.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel6.setText("Password");

        jPasswordField1.setPreferredSize(new java.awt.Dimension(126, 35));

        jLabel7.setText("User Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(64, 35));

        jButton1.setBackground(new java.awt.Color(27, 49, 77));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setText("Create Account");
        jButton1.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 117, 105));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setText("Update Account");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Search User");

        jTextField6.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(27, 49, 77));
        jButton3.setText("Change Status");
        jButton3.setEnabled(false);
        jButton3.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N

        jButton5.setBackground(new java.awt.Color(27, 49, 77));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton5.setText("Get User Report");
        jButton5.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Mobile", "Username", "User Type", "User Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String fname = jTextField1.getText();
        String lname = jTextField2.getText();
        String mobile = jTextField3.getText();
        String username = jTextField4.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String type = String.valueOf(jComboBox1.getSelectedItem());

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First name is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.length() > 40) {
            JOptionPane.showMessageDialog(this, "First name shuld be less than 40 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last name is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.length() > 40) {
            JOptionPane.showMessageDialog(this, "Last name shuld be less than 40 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mobile number is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (type.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Select user type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `user` WHERE `mobile`='" + mobile + "' AND `password`='" + password + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "User already exists!", "warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.execute("INSERT INTO `user` "
                            + "(`fname`,`lname`,`mobile`,`username`,`password`,`user_type_id`) "
                            + "VALUES ('" + fname + "','" + lname + "','" + mobile + "','" + username + "','" + password + "',"
                            + "'" + typeMap.get(type) + "')");
                    resetUserPanel();
                    loadUsers("SELECT * FROM `user` "
                            + "INNER JOIN `user_type` ON `user`.`user_type_id`=`user_type`.`id` "
                            + "INNER JOIN `status` ON `user`.`status_id`=`status`.`id`");
                    JOptionPane.showMessageDialog(this, "User saved successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {

            String id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            String status = String.valueOf(jTable1.getValueAt(selectedRow, 6));

            try {
                if (status.equals("Active")) {
                    MySQL.execute("UPDATE `user` SET `status_id`='2' "
                            + "WHERE `id`='" + id + "'");
                } else {
                    MySQL.execute("UPDATE `user` SET `status_id`='1' "
                            + "WHERE `id`='" + id + "'");
                }
                loadUsers("SELECT * FROM `user` "
                        + "INNER JOIN `user_type` ON `user`.`user_type_id`=`user_type`.`id` "
                        + "INNER JOIN `status` ON `user`.`status_id`=`status`.`id`");

                JOptionPane.showMessageDialog(this, "User status changed successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String id = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        String fname = jTextField1.getText();
        String lname = jTextField2.getText();
        String mobile = jTextField3.getText();
        String username = jTextField4.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String type = String.valueOf(jComboBox1.getSelectedItem());

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First name is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.length() > 40) {
            JOptionPane.showMessageDialog(this, "First name shuld be less than 40 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last name is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.length() > 40) {
            JOptionPane.showMessageDialog(this, "Last name shuld be less than 40 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mobile number is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (type.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Select user type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                MySQL.execute("UPDATE `user` SET "
                        + "`fname`='" + fname + "',"
                        + "`lname`='" + lname + "',"
                        + "`mobile`='" + mobile + "',"
                        + "`username`='" + username + "',"
                        + "`password`='" + password + "',"
                        + "`user_type_id`='" + typeMap.get(type) + "'"
                        + "WHERE `id`='" + id + "'");
                resetUserPanel();
                loadUsers("SELECT * FROM `user` "
                        + "INNER JOIN `user_type` ON `user`.`user_type_id`=`user_type`.`id` "
                        + "INNER JOIN `status` ON `user`.`status_id`=`status`.`id`");
                JOptionPane.showMessageDialog(this, "User updated successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        resetUserPanel();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int selectedRow = jTable1.getSelectedRow();

        if (evt.getClickCount() == 1 && selectedRow != -1) {
            jButton3.setEnabled(true);
        } else if (evt.getClickCount() == 2 && selectedRow != -1) {
            jTable1.setEnabled(false);
            jButton3.setEnabled(false);
            jTextField6.setEnabled(false);
            jButton1.setEnabled(false);
            jButton2.setEnabled(true);

            jTextField1.setText(String.valueOf(jTable1.getValueAt(selectedRow, 1)));
            jTextField2.setText(String.valueOf(jTable1.getValueAt(selectedRow, 2)));
            jTextField3.setText(String.valueOf(jTable1.getValueAt(selectedRow, 3)));
            jTextField4.setText(String.valueOf(jTable1.getValueAt(selectedRow, 4)));
            jComboBox1.setSelectedItem(String.valueOf(jTable1.getValueAt(selectedRow, 5)));
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

        String text = jTextField6.getText();
        loadUsers("SELECT * FROM `user` "
                + "INNER JOIN `user_type` ON `user`.`user_type_id`=`user_type`.`id` "
                + "INNER JOIN `status` ON `user`.`status_id`=`status`.`id` WHERE "
                + "`fname` LIKE '" + text + "%' OR `lname` LIKE '" + text + "%' OR `username` LIKE '" + text + "%' OR `mobile` LIKE '" + text + "%'");

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:        
         try {
            HashMap<String, Object> map1 = new HashMap<>();

            String reportPath = "/reports/user.jasper";

            JRDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream(reportPath), map1, dataSource);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
