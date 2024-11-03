package gui;

import javax.swing.JTable;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import subpanel.AddProductList;
import subpanel.AddSupplier;

public class GrnManagement extends javax.swing.JPanel {

    private HashMap<String, String> colorMap = new HashMap<>();
    private HashMap<String, String> sizeMap = new HashMap<>();

    public GrnManagement() {
        initComponents();
        loadSize();
        loadColor();
        JTable[] jt = {jTable1};
        Dashboard.editTable(jt);

    }
    Dashboard dashboard;

    public void setDashboard(Dashboard dashboard) {

        this.dashboard = dashboard;
    }

    public JTextField getJTextField1() {
        return jTextField1;
    }

    public JTextField getJTextField19() {

        return jTextField19;
    }

    public JTextField getJTextField120() {

        return jTextField20;
    }

    public JTextField getJTextField13() {
        //product id
        return jTextField3;
    }

    public JTextField getJTextField7() {
        //product name
        return jTextField7;
    }

    public JTextField getJTextField8() {
        //brand name
        return jTextField8;
    }

    public JTextField getJTextField9() {
        //main category
        return jTextField9;
    }

    public JTextField getJTextField2() {
        //sub category
        return jTextField2;
    }

    private void generateRandomGRN() {
        long id = System.currentTimeMillis();
        // Ensures it's a 10-digit number
        jTextField18.setText(String.valueOf(id));
    }

    private void loadSize() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `size`");
            Vector v = new Vector();
            v.add("Select");
            while (resultSet.next()) {
                sizeMap.put(resultSet.getString("s_name"), resultSet.getString("s_id"));
                v.add(resultSet.getString("s_name"));

            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);

            jComboBox2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadColor() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `color`");
            Vector v = new Vector();
            v.add("Select");
            while (resultSet.next()) {
                colorMap.put(resultSet.getString("co_name"), resultSet.getString("co_id"));

                v.add(resultSet.getString("co_name"));

            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);

            jComboBox1.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clearGRN() {

        jTextField1.setText("");
        jTextField3.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField19.setText("");
        jTextField18.setText("");
        jTextField20.setText("");
        jComboBox1.setSelectedItem("Select");
        jComboBox2.setSelectedItem("Select");
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
        jFormattedTextField3.setText("");
        jLabel21.setText("");
        jDateChooser1.setDate(null);
        jDateChooser1.setEnabled(true);
        jButton3.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }

    private void calculateTotal() {
        double total = 0;
        int rows = jTable1.getRowCount();
        for (int i = 0; i < rows; i++) {
            int quantity = Integer.parseInt(String.valueOf((jTable1.getValueAt(i, 5))));
            double bPrice = Double.parseDouble(String.valueOf((jTable1.getValueAt(i, 8))));
            double itemTotal = quantity * bPrice;
            total += itemTotal;
        }

        jLabel21.setText(String.valueOf(total));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 720));

        kGradientPanel2.setToolTipText("Title Bar");
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user (8).png"))); // NOI18N
        jLabel1.setText("GRN");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Brand Name", "Main Category", "Sub Category", "Qty", "Size", "Color", "Buying Price", "Selling Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(27, 49, 77));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm");
        jButton1.setPreferredSize(new java.awt.Dimension(83, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Supplier");
        jLabel2.setPreferredSize(new java.awt.Dimension(43, 35));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("GRN Date");
        jLabel3.setPreferredSize(new java.awt.Dimension(51, 35));

        jTextField3.setPreferredSize(new java.awt.Dimension(64, 35));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setPreferredSize(new java.awt.Dimension(64, 35));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton8.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Product");
        jLabel4.setPreferredSize(new java.awt.Dimension(42, 35));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Quantity");
        jLabel5.setPreferredSize(new java.awt.Dimension(46, 35));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Buying Price");
        jLabel6.setPreferredSize(new java.awt.Dimension(66, 35));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Size");
        jLabel7.setPreferredSize(new java.awt.Dimension(64, 35));

        jTextField7.setPreferredSize(new java.awt.Dimension(300, 35));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Product Name ");
        jLabel8.setPreferredSize(new java.awt.Dimension(80, 35));

        jTextField8.setPreferredSize(new java.awt.Dimension(64, 35));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Brand Name ");
        jLabel9.setPreferredSize(new java.awt.Dimension(69, 35));

        jTextField9.setPreferredSize(new java.awt.Dimension(64, 35));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 117, 105));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add to GRN");
        jButton4.setPreferredSize(new java.awt.Dimension(105, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(118, 48, 129));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Clear All");
        jButton5.setPreferredSize(new java.awt.Dimension(85, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Main Category");
        jLabel10.setPreferredSize(new java.awt.Dimension(86, 35));

        jTextField2.setPreferredSize(new java.awt.Dimension(64, 35));

        jLabel18.setText("Sub Category");
        jLabel18.setPreferredSize(new java.awt.Dimension(71, 35));

        jComboBox1.setPreferredSize(new java.awt.Dimension(72, 35));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Selling Price");
        jLabel19.setPreferredSize(new java.awt.Dimension(64, 35));

        jComboBox2.setPreferredSize(new java.awt.Dimension(72, 35));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Color");
        jLabel20.setPreferredSize(new java.awt.Dimension(64, 35));

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(64, 35));

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.setPreferredSize(new java.awt.Dimension(64, 35));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, 91, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("GRN Date");
        jLabel15.setPreferredSize(new java.awt.Dimension(51, 35));

        jLabel16.setText("GRN No ");
        jLabel16.setPreferredSize(new java.awt.Dimension(46, 35));

        jLabel17.setText("Supplier");
        jLabel17.setPreferredSize(new java.awt.Dimension(43, 35));

        jTextField18.setEditable(false);
        jTextField18.setPreferredSize(new java.awt.Dimension(64, 35));
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jTextField19.setEditable(false);
        jTextField19.setPreferredSize(new java.awt.Dimension(64, 35));
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        jTextField20.setEditable(false);
        jTextField20.setPreferredSize(new java.awt.Dimension(64, 35));

        jLabel12.setText("Payment");
        jLabel12.setPreferredSize(new java.awt.Dimension(47, 35));

        jLabel13.setText("Balance");
        jLabel13.setPreferredSize(new java.awt.Dimension(41, 35));

        jButton6.setBackground(new java.awt.Color(27, 49, 77));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Cancel GRN");
        jButton6.setPreferredSize(new java.awt.Dimension(101, 35));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 117, 105));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Save GRN");
        jButton7.setEnabled(false);
        jButton7.setPreferredSize(new java.awt.Dimension(89, 35));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel11.setText("Total");
        jLabel11.setPreferredSize(new java.awt.Dimension(26, 35));

        jButton9.setBackground(new java.awt.Color(118, 48, 129));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Generate");
        jButton9.setPreferredSize(new java.awt.Dimension(85, 35));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel21.setPreferredSize(new java.awt.Dimension(43, 35));

        jLabel22.setPreferredSize(new java.awt.Dimension(43, 35));

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField3.setPreferredSize(new java.awt.Dimension(64, 35));
        jFormattedTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Date gRNDate = jDateChooser1.getDate();
        Date today = new Date();

        if (gRNDate == null) {
            JOptionPane.showMessageDialog(this, "Select a Date Please!", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else if (gRNDate.after(today)) {
            JOptionPane.showMessageDialog(this, "GRN date is incompatible, Please select Another Date!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            jTextField20.setText(String.valueOf(format.format(gRNDate)));
            jDateChooser1.setEnabled(false);
            jButton3.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        AddProductList addProductList = new AddProductList();
        addProductList.setDashboard(dashboard);
        addProductList.setGrnManagement(this);
        addProductList.setVisible(true);
        dashboard.setEnabled(false);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here: supplier addition        
        AddSupplier addSupplier = new AddSupplier();
        addSupplier.setDashboard(dashboard);
        addSupplier.setGrnManagement(this);
        addSupplier.setVisible(true);
        dashboard.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed

    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        generateRandomGRN();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String supplierId = jTextField1.getText();
        String productId = jTextField3.getText();
        String productName = jTextField7.getText();
        String brandName = jTextField8.getText();
        String mainCategory = jTextField9.getText();
        String subCategory = jTextField2.getText();
        String qty = jTextField4.getText();
        String size = String.valueOf(jComboBox2.getSelectedItem());
        String color = String.valueOf(jComboBox1.getSelectedItem());
        String bPrice = jFormattedTextField1.getText();
        String sPrice = jFormattedTextField2.getText();

        if (supplierId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a Supplier!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (productId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a Product!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type quantity!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Integer.parseInt(qty) <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid quantity!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (jFormattedTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type buying price!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Double.parseDouble(bPrice) <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid buying price!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (jFormattedTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type selling price!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Double.parseDouble(sPrice) <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid selling price!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Double.parseDouble(bPrice) > Double.parseDouble(sPrice)) {
            JOptionPane.showMessageDialog(this, "Selling price is lower than buying price!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox2.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(this, "Select a Size!", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox1.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(this, "Select a Color!", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int rows = jTable1.getRowCount();
            double buyingPrice = Double.parseDouble(bPrice);
            double sellingPrice = Double.parseDouble(sPrice);
            boolean found = false;
            boolean canAdd = true;

            try {

                ResultSet results = MySQL.execute("SELECT * FROM `stock` "
                        + "INNER JOIN `product` ON `stock`.`p_id`=`product`.`p_id` "
                        + "INNER JOIN `grn_item` ON `product`.`p_id`=`grn_item`.`product_p_id` WHERE `stock`.`p_id`='" + productId + "' "
                        + "AND `stock`.`s_id`='" + sizeMap.get(size) + "' "
                        + "AND `stock`.`co_id`='" + colorMap.get(color) + "' "
                        + "AND `grn_item`.`buying_price`='" + buyingPrice + "'");

                if (results.next()) {
                    double stockSellingPrice = results.getDouble("stock.price");
                    if (stockSellingPrice != sellingPrice) {
                        JOptionPane.showMessageDialog(this, "Same product already in stock! selling price cannot be different", "warning", JOptionPane.WARNING_MESSAGE);
                        canAdd = false;
                    }
                }

                if (canAdd) {
                    for (int i = 0; i < rows; i++) {
                        String productId2 = String.valueOf(jTable1.getValueAt(i, 0));
                        String color2 = String.valueOf(jTable1.getValueAt(i, 7));
                        String size2 = String.valueOf(jTable1.getValueAt(i, 6));
                        String qty2 = String.valueOf(jTable1.getValueAt(i, 5));

                        if (productId2.equals(productId)) {
                            if (color2.equals(color)) {
                                if (size2.equals(size)) {
                                    jTable1.setValueAt(Integer.parseInt(qty2) + Integer.parseInt(qty), i, 5);
                                    found = true;
                                    break;

                                }

                            }
                        }
                    }

                    if (!found) {
                        Vector v = new Vector();
                        v.add(productId);
                        v.add(productName);
                        v.add(brandName);
                        v.add(mainCategory);
                        v.add(subCategory);
                        v.add(qty);
                        v.add(size);
                        v.add(color);
                        v.add(buyingPrice);
                        v.add(sellingPrice);

                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.addRow(v);

                    }
                    calculateTotal();
                    jButton7.setEnabled(true);
                }

            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clearGRN();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jFormattedTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField3KeyReleased
        String payment = jFormattedTextField3.getText();
        String total = jLabel21.getText();
        if (total.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Total amount is empty!", "warning", JOptionPane.WARNING_MESSAGE);
            jFormattedTextField3.setText(null);

        } else if (!payment.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
            jLabel22.setText("Invalid");
            jLabel22.setForeground(Color.red);

        } else {
            double balanceAmount = Double.parseDouble(total) - Double.parseDouble(payment);
            jLabel22.setText(String.valueOf(balanceAmount));

        }
    }//GEN-LAST:event_jFormattedTextField3KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String grnNo = jTextField18.getText();
        String grnDate = jTextField20.getText();
        String supplierMobile = jTextField1.getText();
        String total = jLabel21.getText();
        String paidAmount = jFormattedTextField3.getText();

        if (grnNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please generate GRN number", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (grnDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select GRN date", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (supplierMobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a supplier", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (paidAmount.isEmpty()) {
            jFormattedTextField3.setText("0.00");
        } else if (Double.parseDouble(paidAmount) < 0) {
            JOptionPane.showMessageDialog(this, "Paid amount should be greater than zero", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {

                // grn table
                MySQL.execute("INSERT INTO `grn` (`barcode`,`date_time`,`total`,`supplier_mobile`) "
                        + "VALUES ('" + grnNo + "','" + format.format(jDateChooser1.getDate()) + "','" + paidAmount + "','" + supplierMobile + "')");

                int rowCount = jTable1.getRowCount();
                for (int i = 0; i < rowCount; i++) {

                    String buyingPrice = String.valueOf(jTable1.getValueAt(i, 8));
                    String sellingPrice = String.valueOf(jTable1.getValueAt(i, 9));
                    String qty = String.valueOf(jTable1.getValueAt(i, 5));
                    String productId = String.valueOf(jTable1.getValueAt(i, 0));
                    String size = String.valueOf(jTable1.getValueAt(i, 6));
                    String color = String.valueOf(jTable1.getValueAt(i, 7));

                    // stock table
                    ResultSet results = MySQL.execute("SELECT * FROM `stock` "
                            + "WHERE `stock`.`p_id`='" + productId + "' "
                            + "AND `stock`.`s_id`='" + sizeMap.get(size) + "' "
                            + "AND `stock`.`co_id`='" + colorMap.get(color) + "' "
                            + "AND `stock`.`price`='" + sellingPrice + "'");

                    String stockBarcode;

                    if (results.next()) {
                        //stock exists             
                        stockBarcode = results.getString("barcode");

                        String currentQty = results.getString("available_qty");
                        String updatedQty = String.valueOf(Integer.parseInt(currentQty) + Integer.parseInt(qty));
                        MySQL.execute("UPDATE `stock` SET `available_qty`='" + updatedQty + "' WHERE `barcode`='" + stockBarcode + "'");

                    } else {
                        //new stock          
                        stockBarcode = String.valueOf(System.currentTimeMillis());

                        MySQL.execute("INSERT INTO `stock` (`barcode`,`p_id`,`s_id`,`co_id`,`price`,`available_qty`) "
                                + "VALUES ('" + stockBarcode + "','" + productId + "','" + sizeMap.get(size) + "',"
                                + "'" + colorMap.get(color) + "','" + sellingPrice + "','" + qty + "')");

                    }

                    // grn table
                    MySQL.execute("INSERT INTO `grn_item` (`buying_price`,`qty`,`product_p_id`,`grn_barcode`) "
                            + "VALUES ('" + buyingPrice + "','" + qty + "','" + productId + "','" + grnNo + "')");

                }             

                clearGRN();
                JOptionPane.showMessageDialog(this, "success", "Warning", JOptionPane.WARNING_MESSAGE);

            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clearGRN();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int selectedRow = jTable1.getSelectedRow();

        if (evt.getClickCount() == 2 && selectedRow != -1) {

            int option = JOptionPane.showConfirmDialog(this, "Do you want to remove selected Row?", "Message",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(selectedRow);
                calculateTotal();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
