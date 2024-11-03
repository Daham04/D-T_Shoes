package gui;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
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
import subpanel.grnItemView;
import subpanel.grnView;
import subpanel.invoiceItemView;
import subpanel.invoiceView;

public class ReturnManagement extends javax.swing.JPanel {

    Dashboard dashboard;

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public ReturnManagement() {
        initComponents();
        loadCustomerReturns();
        loadSupplierReturns();
        JTable[] jt = {jTable1, jTable2};
        Dashboard.editTable(jt);

    }

    //Invoice ID
    public JFormattedTextField getjFormattedTextField9() {
        return jFormattedTextField9;
    }

    //Invoice Item ID
    public JFormattedTextField getjFormattedTextField3() {
        return jFormattedTextField3;
    }

    //Product Title
    public JTextField getjTextField3() {
        return jTextField3;
    }

    //Stock Barcode
    public JFormattedTextField getjFormattedTextField1() {
        return jFormattedTextField1;
    }

    //Color
    public JTextField getjTextField10() {
        return jTextField10;
    }

    //Size
    public JFormattedTextField getjFormattedTextField2() {
        return jFormattedTextField2;
    }

    //GRN ID
    public JTextField getjFormattedTextField10() {
        return jFormattedTextField10;
    }

    //GRN Item ID
    public JTextField getjFormattedTextField6() {
        return jFormattedTextField6;
    }

    //GRN Product Title
    public JTextField getjTextField9() {
        return jTextField9;
    }

    //GRN Barcode
    public JFormattedTextField getjFormattedTextField7() {
        return jFormattedTextField10;
    }

    //GRN Color
    public JTextField getjTextField11() {
        return jTextField11;
    }

    //GRN Size
    public JFormattedTextField getjFormattedTextField8() {
        return jFormattedTextField8;
    }

    private void loadCustomerReturns() {
        try {
            ResultSet customerReturnResultSet = MySQL.execute("SELECT *\n"
                    + "FROM `customer_return`\n"
                    + "INNER JOIN `invoice_item` ON `customer_return`.`invoice_item_init_id` = `invoice_item`.`init_id`\n"
                    + "INNER JOIN `invoice` ON `invoice`.`in_id`= `invoice_item`.`in_id`\n"
                    + "INNER JOIN `stock` ON `stock`.`barcode` = `invoice_item`.`st_barcode`\n"
                    + "INNER JOIN `size` ON `size`.`s_id` = `stock`.`s_id`\n"
                    + "INNER JOIN `color` ON `color`.`co_id` = `stock`.`co_id`\n"
                    + "INNER JOIN `product` ON `product`.p_id = `stock`.`p_id`");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (customerReturnResultSet.next()) {
                String invoiceId = customerReturnResultSet.getString("invoice_item.init_id");
                String stockBarcode = customerReturnResultSet.getString("stock.barcode");
                String productTitle = customerReturnResultSet.getString("product.title");
                String size = customerReturnResultSet.getString("size.s_name");
                String color = customerReturnResultSet.getString("color.co_name");
                String quantity = customerReturnResultSet.getString("customer_return.qty");

                Vector vector = new Vector();
                vector.add(invoiceId);
                vector.add(stockBarcode);
                vector.add(productTitle);
                vector.add(size);
                vector.add(color);
                vector.add(quantity);

                model.addRow(vector);
                jTable1.setModel(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadSupplierReturns() {

        try {

            ResultSet supplierResultSet = MySQL.execute("SELECT * FROM `supplier_return` INNER JOIN `grn_item`\n"
                    + "ON `supplier_return`.grn_item_id = `grn_item`.`id`\n"
                    + "INNER JOIN `product`\n"
                    + "ON `product`.`p_id` = `grn_item`.`product_p_id`\n"
                    + "INNER JOIN `stock`\n"
                    + "ON `stock`.`p_id` = `product`.`p_id`\n"
                    + "INNER JOIN `color`\n"
                    + "ON `color`.`co_id` = `stock`.`co_id`\n"
                    + "INNER JOIN`size`\n"
                    + "ON `size`.`s_id`= `stock`.`s_id`\n"
                    + "INNER JOIN `grn`\n"
                    + "ON `grn`.barcode =`grn_item`.`grn_barcode`");

            DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
            model1.setRowCount(0);

            while (supplierResultSet.next()) {
                String GRNitemId = supplierResultSet.getString("grn_item.id");
                String GrnBarcode = supplierResultSet.getString("grn.barcode");
                String productTitle = supplierResultSet.getString("title");
                String size = supplierResultSet.getString("s_name");
                String color = supplierResultSet.getString("co_name");
                String quantity = supplierResultSet.getString("qty");

                Vector vector1 = new Vector();
                vector1.add(GrnBarcode);
                vector1.add(GRNitemId);
                vector1.add(productTitle);
                vector1.add(size);
                vector1.add(color);
                vector1.add(quantity);

                model1.addRow(vector1);
                jTable2.setModel(model1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetAll() {

        jFormattedTextField3.setText(" ");
        jFormattedTextField1.setText(" ");
        jTextField3.setText(" ");
        jTextField10.setText(" ");
        jFormattedTextField2.setText(" ");
        jFormattedTextField4.setText(" ");
        jFormattedTextField9.setText(" ");

        jFormattedTextField3.setFocusable(true);

        jFormattedTextField10.setText(" ");
        jFormattedTextField6.setText(" ");
        jTextField9.setText(" ");
        jTextField11.setText(" ");
        jFormattedTextField8.setText(" ");
        jFormattedTextField5.setText(" ");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jButton5 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jFormattedTextField9 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jFormattedTextField6 = new javax.swing.JFormattedTextField();
        jFormattedTextField8 = new javax.swing.JFormattedTextField();
        jButton6 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jFormattedTextField10 = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 720));

        kGradientPanel1.setToolTipText("Title Bar");
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user (8).png"))); // NOI18N
        jLabel1.setText("Return Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(275, 654));

        jLabel2.setText("Invoice ID");

        jLabel3.setText("Stock Barcode");

        jButton1.setBackground(new java.awt.Color(27, 49, 77));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm Return");
        jButton1.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 117, 105));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear All");
        jButton2.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Product Title");

        jTextField3.setEditable(false);
        jTextField3.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel13.setText("Color");

        jTextField10.setEditable(false);
        jTextField10.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel14.setText("Size");

        jLabel15.setText("Quantity");

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(69, 35));

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setPreferredSize(new java.awt.Dimension(69, 35));

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setPreferredSize(new java.awt.Dimension(69, 35));

        jFormattedTextField4.setPreferredSize(new java.awt.Dimension(69, 35));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });

        jLabel18.setText("Invoice Item ID");

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton7KeyPressed(evt);
            }
        });

        jFormattedTextField9.setEditable(false);
        jFormattedTextField9.setPreferredSize(new java.awt.Dimension(69, 35));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
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
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Item ID", "Stock Barcode", "Product", "Size", "Color", "Quantity"
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
        jScrollPane1.setViewportView(jTable1);

        jButton9.setBackground(new java.awt.Color(27, 49, 77));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Get Report");
        jButton9.setPreferredSize(new java.awt.Dimension(150, 35));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(166, 166, 166)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customer  Return", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(275, 654));

        jLabel5.setText("GRN Barcode");

        jButton3.setBackground(new java.awt.Color(27, 49, 77));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton3.setText("Confirm Return");
        jButton3.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 117, 105));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setText("Clear All");
        jButton4.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Size");

        jLabel12.setText("Product Title");

        jTextField9.setEditable(false);
        jTextField9.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel16.setText("Color");

        jTextField11.setEditable(false);
        jTextField11.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel17.setText("Quantity");

        jFormattedTextField5.setPreferredSize(new java.awt.Dimension(69, 35));

        jFormattedTextField6.setEditable(false);
        jFormattedTextField6.setPreferredSize(new java.awt.Dimension(69, 35));

        jFormattedTextField8.setEditable(false);
        jFormattedTextField8.setPreferredSize(new java.awt.Dimension(69, 35));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel19.setText("GRN Item ID");

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jFormattedTextField10.setEditable(false);
        jFormattedTextField10.setPreferredSize(new java.awt.Dimension(69, 35));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jFormattedTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Search");

        jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField8.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 117, 105));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton10.setText("Get Report");
        jButton10.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN Barcode", "GRN Item ID", "Product", "Size", "Color", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Supplier Return", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String invoiceId = jFormattedTextField3.getText();
        String stockId = jFormattedTextField1.getText();
        String productTitle = jTextField3.getText();
        String productColor = jTextField10.getText();
        String productSize = jFormattedTextField2.getText();
        String quantity = jFormattedTextField4.getText();

        //customer return validation
        if (invoiceId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Invoice Item Id", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (stockId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Stock Id", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (productTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Title", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (productColor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Color", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (productSize.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Size", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            double getQty = Double.parseDouble(quantity);
            double getInvoiceId = Double.parseDouble(invoiceId);
            double getStockId = Double.parseDouble(stockId);

            if (getQty <= 0) {
                JOptionPane.showMessageDialog(this, "Product Quanttiy Cant be 0 0r Negative", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    //Customer_return Search 
                    ResultSet productResultSet = MySQL.execute("SELECT * FROM `invoice_item` "
                            + "INNER JOIN `stock` ON `invoice_item`.`st_barcode`=`stock`.`barcode`"
                            + " WHERE `barcode`='" + getStockId + "' AND `init_id`='" + getInvoiceId + "'");

                    if (productResultSet.next()) {
                        double dbQuantity = Double.parseDouble(productResultSet.getString("invoice_item.qty"));
                        if (dbQuantity < getQty) {
                            JOptionPane.showMessageDialog(this, "Entered Quantity Greater Than Purchased Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {

                            //Update Stock
                            double availableStock = Double.parseDouble(productResultSet.getString("available_qty"));
                            double UpdateStock = availableStock + getQty;

                            //Update InvoiceItemQty
                            double purchasedQty = Double.parseDouble(productResultSet.getString("invoice_item.qty"));
                            double UpdateInvoiceQty = purchasedQty - getQty;

                            //Set time and date
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String formattedDateTime = now.format(formatter);

                            // Insert customer_return
                            MySQL.execute("INSERT INTO `customer_return` (`date_time`,`qty`,`invoice_item_init_id`) "
                                    + "VALUES ('" + formattedDateTime + "','" + getQty + "','" + getInvoiceId + "') ");

                            //Update invoiceItemQty
                            MySQL.execute("UPDATE `invoice_item` SET `qty`='" + UpdateInvoiceQty + "' WHERE `init_id`='" + getInvoiceId + "'");

                            //Update stock
                            MySQL.execute("UPDATE `stock` SET `available_qty`='" + UpdateStock + "' WHERE `barcode`='" + getStockId + "'");
                            loadCustomerReturns();
                            JOptionPane.showMessageDialog(this, "Product Returned Succesfully", "Information", JOptionPane.INFORMATION_MESSAGE);

                            jFormattedTextField3.setEditable(true);
                            jFormattedTextField1.setEditable(true);
                            jTextField3.setEditable(true);
                            jTextField10.setEditable(true);
                            jFormattedTextField2.setEditable(true);

                            resetAll();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        String grnId = jFormattedTextField10.getText();
        String grnitemId = jFormattedTextField6.getText();
        String productTitle = jTextField9.getText();
        String productColor = jTextField11.getText();
        String productSize = jFormattedTextField8.getText();
        String quantity = jFormattedTextField5.getText();

        //Supplier Return Validation
        if (grnId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Stock Id", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (grnitemId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter GRN Item Id", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (productTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Title", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (productColor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Color", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (productSize.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Size", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            double getQty = Double.parseDouble(quantity);
            double getGrnitemId = Double.parseDouble(grnitemId);
            double getGrnId = Double.parseDouble(grnId);

            if (getQty <= 0) {
                JOptionPane.showMessageDialog(this, "Product Quanttiy Cant be 0 0r Negative", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {

                try {
                    //Suplier return Query
                    ResultSet grnResultSet = MySQL.execute("SELECT * FROM `grn_item`\n"
                            + "INNER JOIN `grn` \n"
                            + "ON `grn`.`barcode`=`grn_item`.`grn_barcode`\n"
                            + "INNER JOIN `product` \n"
                            + "ON `grn_item`.`product_p_id`=`product`.`p_id` \n"
                            + "INNER JOIN `stock` \n"
                            + "ON `stock`.`p_id` = `product`.`p_id`\n"
                            + "WHERE `grn`.`barcode`='" + getGrnId + "' AND `id`='" + getGrnitemId + "'");

                    if (grnResultSet.next()) {
                        double dbQuantity = Double.parseDouble(grnResultSet.getString("grn_item.qty"));
                        if (dbQuantity < getQty) {
                            JOptionPane.showMessageDialog(this, "Entered Quantity Greater Than Purchased Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
//
                            double availableStock = Double.parseDouble(grnResultSet.getString("available_qty"));
                            double UpdateStock = availableStock - getQty;

                            //Update InvoiceItemQty
                            double purchasedQty = Double.parseDouble(grnResultSet.getString("grn_item.qty"));
                            double UpdateGrnQty = purchasedQty - getQty;

                            //Set date and time 
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String formattedDateTime = now.format(formatter);

                            //Insert supplier_return
                            MySQL.execute("INSERT INTO `supplier_return` (`date_time`,`qty`,`grn_item_id`) "
                                    + "VALUES ('" + formattedDateTime + "','" + getQty + "','" + getGrnitemId + "') ");

                            //Update GRNItemQty
                            MySQL.execute("UPDATE `grn_item` SET `qty`='" + UpdateGrnQty + "' WHERE `id`='" + getGrnitemId + "'");

                            //Stock Update
                            double sbarcode = Double.parseDouble(grnResultSet.getString("stock.barcode"));
                            MySQL.execute("UPDATE `stock` SET `available_qty`='" + UpdateStock + "' WHERE `stock`.`barcode`='" + sbarcode + "'");
                            loadSupplierReturns();
                            JOptionPane.showMessageDialog(this, "Product Returned Succesfully", "Information", JOptionPane.INFORMATION_MESSAGE);

                            jFormattedTextField6.setEditable(true);
                            jFormattedTextField10.setEditable(true);
                            jTextField9.setEditable(true);
                            jFormattedTextField8.setEditable(true);
                            jTextField11.setEditable(true);

                            resetAll();

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        resetAll();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String inid = jFormattedTextField9.getText();

        if (inid.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Invoice First", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            invoiceItemView invoiceItem = new invoiceItemView();
            invoiceItem.setreturnManagement(this);
            invoiceItem.loadInvoiceItemProduct(inid);
            invoiceItem.setDashboard(dashboard);
            invoiceItem.setVisible(true);
            dashboard.setEnabled(false);

            jFormattedTextField3.setEditable(false);
            jFormattedTextField1.setEditable(false);
            jTextField3.setEditable(false);
            jTextField10.setEditable(false);
            jFormattedTextField2.setEditable(false);

        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String grnbarcode = jFormattedTextField10.getText();

        if (grnbarcode.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select GRN First", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            grnItemView grnItem = new grnItemView();
            grnItem.setreturnManagement(this);
            grnItem.loadSupplierReturns(grnbarcode);
            grnItem.setDashboard(dashboard);
            grnItem.setVisible(true);
            dashboard.setEnabled(false);

            jFormattedTextField6.setEditable(false);
            jFormattedTextField10.setEditable(false);
            jTextField9.setEditable(false);
            jFormattedTextField8.setEditable(false);
            jTextField11.setEditable(false);

        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here: 

        String search = jTextField6.getText();

        try {
            ResultSet customerReturnResultSet = MySQL.execute("SELECT * FROM `customer_return` INNER JOIN `invoice_item`\n"
                    + "ON `customer_return`.invoice_item_init_id = `invoice_item`.`init_id`\n"
                    + "INNER JOIN `invoice`\n"
                    + "ON `invoice`.`in_id`= `invoice_item`.`in_id`\n"
                    + "INNER JOIN `stock`\n"
                    + "ON `stock`.`barcode` = `invoice_item`.`st_barcode`\n"
                    + "INNER JOIN `size`\n"
                    + "ON `size`.`s_id` = `stock`.`s_id`\n"
                    + "INNER JOIN `color`\n"
                    + "ON `color`.`co_id` = `stock`.`co_id`\n"
                    + "INNER JOIN `product` \n"
                    + "ON `product`.p_id = `stock`.`p_id` WHERE `barcode` LIKE '%" + search + "%'"
                    + "OR `invoice_item`.`init_id` LIKE '%" + search + "%' "
                    + "OR `product`.`title` LIKE '%" + search + "%' ");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (customerReturnResultSet.next()) {
                String invoiceId = customerReturnResultSet.getString("init_id");
                String stockBarcode = customerReturnResultSet.getString("barcode");
                String productTitle = customerReturnResultSet.getString("title");
                String size = customerReturnResultSet.getString("s_name");
                String color = customerReturnResultSet.getString("co_name");
                String quantity = customerReturnResultSet.getString("qty");

                Vector vector = new Vector();
                vector.add(invoiceId);
                vector.add(stockBarcode);
                vector.add(productTitle);
                vector.add(size);
                vector.add(color);
                vector.add(quantity);

                model.addRow(vector);
                jTable1.setModel(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jTextField6KeyReleased

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        resetAll();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
        String search = jTextField8.getText();

        try {
            ResultSet supplierResultSet = MySQL.execute("SELECT * FROM `supplier_return` INNER JOIN `grn_item`\n"
                    + "ON `supplier_return`.grn_item_id = `grn_item`.`id`\n"
                    + "INNER JOIN `product`\n"
                    + "ON `product`.`p_id` = `grn_item`.`product_p_id`\n"
                    + "INNER JOIN `stock`\n"
                    + "ON `stock`.`p_id` = `product`.`p_id`\n"
                    + "INNER JOIN `color`\n"
                    + "ON `color`.`co_id` = `stock`.`co_id`\n"
                    + "INNER JOIN`size`\n"
                    + "ON `size`.`s_id`= `stock`.`s_id`\n"
                    + "INNER JOIN `grn`\n"
                    + "ON `grn`.barcode =`grn_item`.`grn_barcode` WHERE `grn`.`barcode` LIKE '%" + search + "%'"
                    + " OR `grn_item`.`id` LIKE '%" + search + "%' "
                    + "OR `product`.`title` LIKE '%" + search + "%'");

            DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
            model1.setRowCount(0);

            while (supplierResultSet.next()) {
                String GRNitemId = supplierResultSet.getString("grn_item.id");
                String GrnBarcode = supplierResultSet.getString("grn.barcode");
                String productTitle = supplierResultSet.getString("title");
                String size = supplierResultSet.getString("s_name");
                String color = supplierResultSet.getString("co_name");
                String quantity = supplierResultSet.getString("qty");

                Vector vector1 = new Vector();
                vector1.add(GrnBarcode);
                vector1.add(GRNitemId);
                vector1.add(productTitle);
                vector1.add(size);
                vector1.add(color);
                vector1.add(quantity);

                model1.addRow(vector1);
                jTable2.setModel(model1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jTextField8KeyReleased

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        invoiceView invoiceView = new invoiceView();
        invoiceView.setDashboard(dashboard);
        invoiceView.setreturnManagement(this);
        invoiceView.setVisible(true);
        dashboard.setEnabled(false);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        grnView grn = new grnView();
        grn.setreturnManagement(this);
        grn.setDashboard(dashboard);
        grn.setVisible(true);
        dashboard.setEnabled(false);


    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
         try {
            HashMap<String, Object> map1 = new HashMap<>();

            String reportPath = "/reports/customerReturn.jasper";

            JRDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream(reportPath), map1, dataSource);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        try {
            HashMap<String, Object> map1 = new HashMap<>();

            String reportPath = "/reports/supplierReturn.jasper";

            JRDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream(reportPath), map1, dataSource);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField10;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JFormattedTextField jFormattedTextField8;
    private javax.swing.JFormattedTextField jFormattedTextField9;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
