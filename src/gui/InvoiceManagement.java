package gui;

import java.awt.Color;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.UserBean;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import subpanel.CustomerList;
import subpanel.StockList;

public class InvoiceManagement extends javax.swing.JPanel {

    private UserBean userBean;

    private HashMap<String, String> paymentMethodMap = new HashMap<>();
    Dashboard dashboard;

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public InvoiceManagement(UserBean userBean) {
        this.userBean = userBean;
        initComponents();
        loadPaymentMethods();
        long invoiceID = System.currentTimeMillis();
        jLabel37.setText(String.valueOf(invoiceID));
    }

    public JTextField getJTextField1() {
        return jTextField1;
    }

    public JTextField getJTextField2() {
        return jTextField2;
    }

    public JLabel getJLabel13() {
        return jLabel13;
    }

    public JLabel getJLabel14() {
        return jLabel14;
    }

    public JLabel getJLabel15() {
        return jLabel15;
    }

    public JLabel getJLabel16() {
        return jLabel16;
    }

    public JLabel getJLabel17() {
        return jLabel17;
    }

    public JLabel getJLabel18() {
        return jLabel18;
    }

    public JLabel getJLabel19() {
        return jLabel19;
    }

    public JLabel getJLabel20() {
        return jLabel20;
    }

    public JLabel getJLabel22() {
        return jLabel22;
    }

    private void reset() {
        long invoiceID = System.currentTimeMillis();
        jLabel37.setText(String.valueOf(invoiceID));
        jTextField1.setText("None");
        jTextField2.setText("");
        jFormattedTextField1.setText("0.00");
        jLabel13.setText("");
        jLabel14.setText("");
        jLabel15.setText("");
        jLabel16.setText("");
        jLabel17.setText("");
        jLabel18.setText("");
        jLabel19.setText("");
        jLabel20.setText("");
        jLabel22.setText("");
        jLabel24.setText("0.00");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jLabel26.setText("0.00");
        jLabel28.setText("0.00");
        jLabel32.setText("0.00");
        jLabel35.setText("0.00");
        jFormattedTextField2.setText("");
        jFormattedTextField2.setEnabled(false);
        jComboBox1.setSelectedIndex(0);
        jComboBox1.setEnabled(false);
        jFormattedTextField2.setText("0.00");
        jFormattedTextField2.setEnabled(false);
        jButton8.setEnabled(false);
    }

    private void calculateSubTotal() {
        double total = 0;
        int rows = jTable1.getRowCount();
        for (int i = 0; i < rows; i++) {
            int quantity = Integer.parseInt(String.valueOf((jTable1.getValueAt(i, 10))));
            double price = Double.parseDouble(String.valueOf((jTable1.getValueAt(i, 8))));
            double itemDiscount = Double.parseDouble(String.valueOf((jTable1.getValueAt(i, 9))));
            double itemTotal = quantity * price - itemDiscount;
            total += itemTotal;
        }

        jLabel26.setText(String.valueOf(Dashboard.FORMAT.format(total)));
        jLabel28.setText(String.valueOf(Dashboard.FORMAT.format(total)));
        jLabel32.setText(String.valueOf(jTable1.getRowCount()));

        if (total == 0) {
            jComboBox1.setSelectedIndex(0);
            jComboBox1.setEnabled(false);
            jFormattedTextField3.setEnabled(false);
            jButton8.setEnabled(false);
        } else {
            jComboBox1.setSelectedIndex(0);
            jComboBox1.setEnabled(true);
            jFormattedTextField3.setEnabled(true);
            jButton8.setEnabled(true);
        }

        jFormattedTextField3.setText("0.00");

    }

    private void loadPaymentMethods() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `payment_method` ORDER BY `pm_name` ASC");

            Vector v = new Vector();
            v.add("Select");
            while (resultSet.next()) {
                v.add(resultSet.getString("pm_name"));
                paymentMethodMap.put(resultSet.getString("pm_name"), resultSet.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
            jComboBox1.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setToolTipText("Product Management");
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bill (4).png"))); // NOI18N
        jLabel1.setText("Invoice Management");
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel2.setText("Select Customer");

        jTextField1.setEditable(false);
        jTextField1.setText("None");
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 35));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setMinimumSize(new java.awt.Dimension(35, 35));
        jButton5.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Enter Barcode");

        jTextField2.setPreferredSize(new java.awt.Dimension(150, 35));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Discount");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(150, 35));
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 117, 105));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Add to Invoice");
        jButton6.setPreferredSize(new java.awt.Dimension(150, 35));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton10.setBorder(null);
        jButton10.setMinimumSize(new java.awt.Dimension(35, 35));
        jButton10.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel36.setText("Invoice Id");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel37.setPreferredSize(new java.awt.Dimension(150, 35));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel5.setText("Product Id");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel6.setText("Product Title");
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel7.setText("Brand");
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel8.setText("Main Category");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sub Category");
        jLabel9.setOpaque(true);
        jLabel9.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Size");
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Color");
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Price");
        jLabel12.setOpaque(true);
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel13.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel14.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel15.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel16.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setOpaque(true);
        jLabel17.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setOpaque(true);
        jLabel18.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setOpaque(true);
        jLabel19.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setOpaque(true);
        jLabel20.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Available");
        jLabel21.setOpaque(true);
        jLabel21.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setOpaque(true);
        jLabel22.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Discount");
        jLabel23.setOpaque(true);
        jLabel23.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("0.00");
        jLabel24.setOpaque(true);
        jLabel24.setPreferredSize(new java.awt.Dimension(75, 22));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product ID", "Product Title", "Brand", "Main Category", "Sub Category", "Color", "Size", "Price", "Discount", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel25.setText("Sub Total");
        jLabel25.setPreferredSize(new java.awt.Dimension(100, 35));

        jLabel26.setText("0.00");
        jLabel26.setPreferredSize(new java.awt.Dimension(150, 35));

        jLabel27.setText("Net Total");
        jLabel27.setPreferredSize(new java.awt.Dimension(100, 35));

        jLabel28.setText("0.00");
        jLabel28.setPreferredSize(new java.awt.Dimension(150, 35));

        jLabel29.setText("Bill Discount");
        jLabel29.setPreferredSize(new java.awt.Dimension(110, 35));

        jFormattedTextField2.setText("0.00");
        jFormattedTextField2.setEnabled(false);
        jFormattedTextField2.setPreferredSize(new java.awt.Dimension(150, 35));
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setPreferredSize(new java.awt.Dimension(25, 35));
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel30.setText("Payment method");
        jLabel30.setPreferredSize(new java.awt.Dimension(110, 35));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setEnabled(false);
        jComboBox1.setPreferredSize(new java.awt.Dimension(150, 35));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel31.setText("Total Items");
        jLabel31.setPreferredSize(new java.awt.Dimension(100, 35));

        jLabel32.setText("0");
        jLabel32.setPreferredSize(new java.awt.Dimension(150, 35));

        jLabel33.setText("Paid Amount");
        jLabel33.setPreferredSize(new java.awt.Dimension(110, 35));

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField3.setEnabled(false);
        jFormattedTextField3.setPreferredSize(new java.awt.Dimension(150, 35));
        jFormattedTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField3ActionPerformed(evt);
            }
        });

        jLabel34.setText("Balance");
        jLabel34.setPreferredSize(new java.awt.Dimension(110, 35));

        jLabel35.setText("0.00");
        jLabel35.setPreferredSize(new java.awt.Dimension(150, 35));

        jButton8.setBackground(new java.awt.Color(0, 117, 105));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Print Invoice");
        jButton8.setEnabled(false);
        jButton8.setPreferredSize(new java.awt.Dimension(150, 35));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(118, 48, 129));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Cancel Invoice");
        jButton9.setPreferredSize(new java.awt.Dimension(150, 35));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CustomerList cl = new CustomerList();
        cl.setDashboard(dashboard);
        cl.setInvoice(this);
        cl.setVisible(true);
        dashboard.setEnabled(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed

        String discount = jFormattedTextField1.getText();
        if (discount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type discount amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (Double.parseDouble(discount) < 0) {
            JOptionPane.showMessageDialog(this, "Discount amount should not be less than zero", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            jLabel24.setText(String.valueOf(Dashboard.FORMAT.format(Double.parseDouble(discount))));
            jFormattedTextField1.setText("0.00");
        }
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String barcode = jTextField2.getText();
        String productId = jLabel13.getText();
        String productTitle = jLabel14.getText();
        String brand = jLabel15.getText();
        String maincategory = jLabel16.getText();
        String subCategory = jLabel17.getText();
        String size = jLabel18.getText();
        String color = jLabel19.getText();
        String price = jLabel20.getText();
        String discountAmount = jLabel24.getText();
//        String qty = jLabel22.getText();

        if (barcode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter barode", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (productId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid barcode", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            int rows = jTable1.getRowCount();
            boolean barcodeFound = false;

            for (int i = 0; i < rows; i++) {
                String barcode2 = String.valueOf(jTable1.getValueAt(i, 0));
                if (barcode.equals(barcode2)) {
                    String qty2 = String.valueOf(jTable1.getValueAt(i, 10));
                    jTable1.setValueAt(Integer.parseInt(qty2) + 1, i, 10);
                    barcodeFound = true;
                    jTextField2.setText("");
                    jTextField2.setEnabled(true);
                    break;
                }
            }
            if (!barcodeFound) {
                Vector v = new Vector();
                v.add(barcode);
                v.add(productId);
                v.add(productTitle);
                v.add(maincategory);
                v.add(subCategory);
                v.add(brand);
                v.add(color);
                v.add(size);
                v.add(Dashboard.FORMAT.format(Double.parseDouble(price)));
                v.add(Dashboard.FORMAT.format(Double.parseDouble(discountAmount)));
                v.add(1);

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(v);
                jTextField2.setText("");
                jTextField2.setEnabled(true);
            }
            calculateSubTotal();

        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String paymentMethod = String.valueOf(jComboBox1.getSelectedItem());
        String paidAmount = jFormattedTextField3.getText();

        if (paymentMethod.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select payment method", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (paidAmount.isEmpty()) {
            jFormattedTextField3.setText("0.00");
        } else if (Double.parseDouble(paidAmount) < 0) {
            JOptionPane.showMessageDialog(this, "Paid amount cannot be less than zero", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String invoiceId = jLabel37.getText();
            Date dateTime = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            String billDiscount = jFormattedTextField2.getText();
            if (billDiscount.isEmpty()) {
                billDiscount = "0.00";
            }

            try {

                //Invoice Insert
                MySQL.execute("INSERT INTO `invoice` VALUES "
                        + "('" + invoiceId + "','" + format.format(dateTime) + "','" + userBean.getId() + "',"
                        + "'" + jTextField1.getText() + "','" + paymentMethodMap.get(jComboBox1.getSelectedItem().toString()) + "',"
                        + "'" + paidAmount + "','" + Double.parseDouble(billDiscount) + "')");
                //Invoice Item insert
                int rowCount = jTable1.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    String barcode = String.valueOf(jTable1.getValueAt(i, 0));
                    int qty = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 10)));
                    double discount = Double.parseDouble(String.valueOf(jTable1.getValueAt(i, 9)));
                    MySQL.execute("INSERT INTO `invoice_item`(`qty`,`in_id`,`discount`,`st_barcode`) "
                            + "VALUES ('" + qty + "','" + invoiceId + "','" + discount + "','" + barcode + "')");

                    //stock update
                    MySQL.execute("UPDATE `stock` SET `available_qty`=`available_qty`-'" + qty + "' WHERE `barcode`='" + barcode + "'");

                }

                //Print Invoice
                try {
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("invoice_id", invoiceId);
                    parameters.put("barcode", invoiceId);
                    parameters.put("date", format.format(dateTime));
                    parameters.put("cashier", userBean.getUsername());
                    parameters.put("sub_total", jLabel26.getText());
                    parameters.put("discount", jFormattedTextField2.getText());
                    parameters.put("net_total", jLabel28.getText());
                    parameters.put("paid_amount", paidAmount);
                    parameters.put("balance", jLabel35.getText());

                    String reportPath = "/reports/invoice.jasper";

                    DefaultTableModel model = new DefaultTableModel();
                    
                    model.addColumn("id");
                    model.addColumn("name");
                    model.addColumn("price");
                    model.addColumn("qty");
                    model.addColumn("discount");
                    model.addColumn("discount");


                    for (int x = 0; x < rowCount; x++) {
                        Vector v = new Vector();
                        String productName = String.valueOf(jTable1.getValueAt(x, 2) + "(" +String.valueOf(jTable1.getValueAt(x, 6)) + ") - Size " + String.valueOf(jTable1.getValueAt(x, 7)));
                        Double price = Double.parseDouble(String.valueOf(jTable1.getValueAt(x, 8)));
                        int qty = Integer.valueOf(String.valueOf(jTable1.getValueAt(x, 10)));
                        Double discount = Double.parseDouble(String.valueOf(jTable1.getValueAt(x, 9)));
                        Double total = (price * qty) - discount;

                        v.add(String.valueOf(x+1));
                        v.add(String.valueOf(productName));
                        v.add(String.valueOf(price));
                        v.add(String.valueOf(qty));
                        v.add(String.valueOf(discount));
                        v.add(String.valueOf(total));
                     
                        model.addRow(v);
                    }

                    JRDataSource dataSource = new JRTableModelDataSource(model);

                    JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(reportPath), parameters, dataSource);
                    JasperViewer.viewReport(print, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                reset();

            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }

        }


    }//GEN-LAST:event_jButton8ActionPerformed
    
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        reset();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        StockList sl = new StockList();
        sl.setDashboard(dashboard);
        sl.setInvoice(this);
        sl.setVisible(true);
        dashboard.setEnabled(false);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

        String barcode = jTextField2.getText();
        if (barcode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type barcode", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                ResultSet results = MySQL.execute("SELECT * FROM `stock` INNER JOIN `product`"
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
                        + "WHERE `stock`.`barcode`='" + barcode + "'");
                if (results.next()) {
                    jTextField2.setText(results.getString("stock.barcode"));
                    jLabel13.setText(results.getString("product.p_id"));
                    jLabel14.setText(results.getString("product.title"));
                    jLabel15.setText(results.getString("brand.b_name"));
                    jLabel16.setText(results.getString("main_category.mc_name"));
                    jLabel17.setText(results.getString("sub_category.sc_name"));
                    jLabel18.setText(results.getString("size.s_name"));
                    jLabel19.setText(results.getString("color.co_name"));
                    jLabel20.setText(results.getString("stock.price"));
                    jLabel22.setText(results.getString("stock.available_qty"));
                    jTextField2.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Barcode", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                SignIn.log1.warning(e.toString());
            }
        }

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int selectedRow = jTable1.getSelectedRow();
        if (evt.getClickCount() == 2 && selectedRow != -1) {

            int option = JOptionPane.showConfirmDialog(this, "Do you want to remove selected item?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(selectedRow);
                calculateSubTotal();
                if (Double.parseDouble(jLabel26.getText()) == 0) {
                    jCheckBox1.setSelected(false);
                    jFormattedTextField2.setText("0.00");
                }
            }

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged

        if (jCheckBox1.isSelected()) {
            jFormattedTextField2.setEnabled(true);
        } else {
            jFormattedTextField2.setEnabled(false);
        }

    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed

        String subTotal = jLabel26.getText();
        String billDiscount = jFormattedTextField2.getText();

        if (billDiscount.isEmpty()) {
            jFormattedTextField2.setText("0.00");
        } else if (Double.parseDouble(billDiscount) < 0) {
            JOptionPane.showMessageDialog(this, "Bill discount cannot be a negative value", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (Double.parseDouble(billDiscount) > Double.parseDouble(subTotal)) {
            JOptionPane.showMessageDialog(this, "Bill discount cannot be greater than sub total", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            double netTotalAmount = Double.parseDouble(subTotal) - Double.parseDouble(billDiscount);
            jLabel28.setText(Dashboard.FORMAT.format(netTotalAmount));

        }

    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        String subTotal = jLabel26.getText();
        if (Double.parseDouble(subTotal) == 0) {
            JOptionPane.showMessageDialog(this, "Please add items to table first", "Warning", JOptionPane.WARNING_MESSAGE);
            jCheckBox1.setSelected(false);
        } else {
            if (jCheckBox1.isSelected()) {
                jFormattedTextField2.setEnabled(true);
            } else {
                jFormattedTextField2.setEnabled(false);
            }
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        String paymentMethod = String.valueOf(jComboBox1.getSelectedItem());
        if (paymentMethod.equals("Card")) {
            jFormattedTextField3.setText(jLabel28.getText());
            jFormattedTextField3.setEnabled(false);
            jLabel35.setText("0.00");
        } else if (paymentMethod.equals("Cash")) {
            jFormattedTextField3.setEnabled(true);
        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jFormattedTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField3ActionPerformed

        String paidAmount = jFormattedTextField3.getText();
        if (paidAmount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type paid amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (Double.parseDouble(paidAmount) < 0) {
            JOptionPane.showMessageDialog(this, "Paid amount cannot be less than zero", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            double netTotal = Double.parseDouble(jLabel28.getText());
            double balance = Double.parseDouble(paidAmount) - netTotal;
            jLabel35.setForeground(Color.RED);
            jLabel35.setText(String.valueOf(Dashboard.FORMAT.format(balance)));
        }

    }//GEN-LAST:event_jFormattedTextField3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
