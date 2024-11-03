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
import subpanel.AddSupplierCompany;

public class SupplierManagement extends javax.swing.JPanel {
    
    String selectedCompanyId = "";
    private HashMap<String, Object> companyMap = new HashMap<>();
    Dashboard dashboard;
    
    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
    
    public SupplierManagement() {
        initComponents();
        loadSuppliers();
        loadCompanyMap();
        loadPendingPayments();
        loadSettledPayments();
        JTable[] jt = {jTable1, jTable2, jTable3};
        Dashboard.editTable(jt);
        jTextField3.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1019, 720));

        kGradientPanel1.setToolTipText("Title Bar");
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 117, 105));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user (8).png"))); // NOI18N
        jLabel1.setText("Supplier Management");
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Supplier Mobile");

        jTextField1.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel3.setText("First Name");

        jTextField2.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel4.setText("Company");

        jTextField3.setPreferredSize(new java.awt.Dimension(69, 35));

        jLabel5.setText("Last Name");

        jTextField4.setPreferredSize(new java.awt.Dimension(69, 35));

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

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-button (1).png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Search");

        jTextField6.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending " }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(61, 35));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel10.setText("Sort By Name");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last Name", "Company", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jButton5.setBackground(new java.awt.Color(27, 49, 77));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton5.setText("Get Report");
        jButton5.setPreferredSize(new java.awt.Dimension(79, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Supplier Management", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last Name", "Company", "Full Amount", "Paid Amount", "Pending Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Search User");

        jTextField7.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N

        jLabel13.setText("Sort By");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name Ascending", "Name Descending " }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(61, 35));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(60, 60, 60)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pending Payment", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last Name", "Company", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("Search User");

        jTextField8.setPreferredSize(new java.awt.Dimension(249, 35));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/glass.png"))); // NOI18N

        jLabel16.setText("Sort By");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name Ascending", "Name Descending " }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(61, 35));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(60, 60, 60)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Settled Payment", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadCompanyMap() {
        try {
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `supplier`");
            
            while (resultSet.next()) {
                String mobile = resultSet.getString("mobile");
                String company_id = resultSet.getString("company_id");
                companyMap.put(mobile, company_id);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public JTextField getJTextField3() {
        return jTextField3;
    }
    
    public void setSelectedCompanyId(String selectedCompanyId) {
        this.selectedCompanyId = selectedCompanyId;
    }
    
    public String getSelectedCompanyId() {
        return this.selectedCompanyId;
    }
    
    private String getSupplierCompanyIdInMobile(String mobile) {
        String company_id = String.valueOf(companyMap.get(mobile));
        return company_id;
    }
    
    private void loadSuppliers() {
        
        String searchText = jTextField6.getText();
        int orderIndex = jComboBox1.getSelectedIndex();
        
        try {
            String orderType;
            if (orderIndex == 0) {
                orderType = "ASC";
            } else {
                orderType = "DESC";
            }
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `supplier` "
                    + "INNER JOIN `company` ON `company`.`id`=`supplier`.`company_id`"
                    + "INNER JOIN `status` ON `supplier`.`status_id`=`status`.`id` "
                    + "WHERE `mobile` LIKE '%" + searchText + "%' OR `fname` LIKE '%" + searchText + "%' OR `lname` LIKE '%" + searchText + "%' OR `company_name` LIKE '%" + searchText + "%' "
                    + "ORDER BY `fname` " + orderType + "");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("fname"));
                v.add(resultSet.getString("lname"));
                v.add(resultSet.getString("company_name"));
                v.add(resultSet.getString("status"));
                model.addRow(v);
                jTable1.setModel(model);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void reset() {
        
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField3.setText("");
        setSelectedCompanyId("");
        jTextField1.setEnabled(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
    }
    
    private void loadPendingPayments() {
        
        String searchText = jTextField7.getText();
        int orderIndex = jComboBox2.getSelectedIndex();
        
        try {
            String orderType;
            if (orderIndex == 0) {
                orderType = "ASC";
            } else {
                orderType = "DESC";
            }
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `supplier` "
                    + "INNER JOIN `company` ON `supplier`.`company_id`=`company`.`id`"
                    + "WHERE `mobile` LIKE '%" + searchText + "%' "
                    + "OR `fname` LIKE '%" + searchText + "%' "
                    + "OR `lname` LIKE '%" + searchText + "%' "
                    + "OR `company_name` LIKE '" + searchText + "' "
                    + "ORDER BY `fname` " + orderType + "");
            
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            
            while (resultSet.next()) {
                
                String mobile = resultSet.getString("mobile");
                
                ResultSet resultSet2 = MySQL.execute("SELECT * FROM `grn` "
                        + "WHERE `supplier_mobile`='" + mobile + "'");
                
                double fullAmount = 0;
                double paidAmount = 0;
                
                while (resultSet2.next()) {
                    String grnBarcode = resultSet2.getString("barcode");
                    
                    ResultSet resultSet3 = MySQL.execute("SELECT * FROM `grn_item` "
                            + "WHERE `grn_barcode`='" + grnBarcode + "' ");
                    
                    while (resultSet3.next()) {
                        Double buyingPrice = Double.parseDouble(resultSet3.getString("buying_price"));
                        int qty = Integer.parseInt(resultSet3.getString("qty"));
                        Double grnItemTotal = buyingPrice * qty;
                        fullAmount = fullAmount + grnItemTotal;
                    }
                    paidAmount = paidAmount + Double.parseDouble(resultSet2.getString("total"));
                }
                
                double pendingAmount = fullAmount - paidAmount;
                
                if (pendingAmount > 0) {
                    Vector vector = new Vector();
                    vector.add(resultSet.getString("mobile"));
                    vector.add(resultSet.getString("fname"));
                    vector.add(resultSet.getString("lname"));
                    vector.add(resultSet.getString("company_name"));
                    vector.add(Dashboard.FORMAT.format(fullAmount));
                    vector.add(Dashboard.FORMAT.format(paidAmount));
                    vector.add(Dashboard.FORMAT.format(pendingAmount));
                    model.addRow(vector);
                    jTable2.setModel(model);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadSettledPayments() {
        String searchText = jTextField8.getText();
        int orderIndex = jComboBox3.getSelectedIndex();
        
        try {
            String orderType;
            if (orderIndex == 0) {
                orderType = "ASC";
            } else {
                orderType = "DESC";
            }
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `supplier` "
                    + "INNER JOIN `company` ON `supplier`.`company_id`=`company`.`id`"
                    + "WHERE `mobile` LIKE '%" + searchText + "%' "
                    + "OR `fname` LIKE '%" + searchText + "%' "
                    + "OR `lname` LIKE '%" + searchText + "%' "
                    + "OR `company_name` LIKE '" + searchText + "' "
                    + "ORDER BY `fname` " + orderType + "");
            
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0);
            
            while (resultSet.next()) {
                
                String mobile = resultSet.getString("mobile");
                
                ResultSet resultSet2 = MySQL.execute("SELECT * FROM `grn` WHERE `supplier_mobile`='" + mobile + "'");
                
                double fullAmount = 0;
                double paidAmount = 0;
                
                while (resultSet2.next()) {
                    String grnBarcode = resultSet2.getString("barcode");
                    
                    ResultSet resultSet3 = MySQL.execute("SELECT * FROM `grn_item` WHERE `grn_barcode`='" + grnBarcode + "' ");
                    
                    while (resultSet3.next()) {
                        Double buyingPrice = Double.parseDouble(resultSet3.getString("buying_price"));
                        int qty = Integer.parseInt(resultSet3.getString("qty"));
                        Double grnItemTotal = buyingPrice * qty;
                        fullAmount = fullAmount + grnItemTotal;
                    }
                    paidAmount = paidAmount + Double.parseDouble(resultSet2.getString("total"));
                }
                
                double pendingAmount = fullAmount - paidAmount;
                
                if (pendingAmount == 0.0 && fullAmount != 0.0) {
                    Vector vector = new Vector();
                    vector.add(resultSet.getString("mobile"));
                    vector.add(resultSet.getString("fname"));
                    vector.add(resultSet.getString("lname"));
                    vector.add(resultSet.getString("company_name"));
                    vector.add(Dashboard.FORMAT.format(fullAmount));
                    model.addRow(vector);
                    jTable3.setModel(model);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AddSupplierCompany addSupplierCompany = new AddSupplierCompany();
        addSupplierCompany.setSupplierManagement(this);
        addSupplierCompany.setDashboard(dashboard);
        addSupplierCompany.setVisible(true);
        dashboard.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String mobile = jTextField1.getText();
        String fName = jTextField2.getText();
        String lName = jTextField4.getText();
        String companyId = getSelectedCompanyId();
        
        if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[1245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fName.length() > 45) {
            JOptionPane.showMessageDialog(this, "First Name is too long", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lName.length() > 45) {
            JOptionPane.showMessageDialog(this, "Last Name is too long", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (companyId.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select Supplier Company", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            
            try {
                
                ResultSet resultset = MySQL.execute("SELECT * FROM `supplier` WHERE `mobile`='" + mobile + "'");
                
                if (resultset.next()) {
                    JOptionPane.showMessageDialog(this, "Mobile Number already added to a Supplier", "warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.execute("INSERT INTO `supplier` (`mobile`,`fname`,`lname`,`status_id`,`company_id`)"
                            + "VALUES ('" + mobile + "','" + fName + "','" + lName + "','1','" + companyId + "') ");
                    loadSuppliers();
                    reset();
                    JOptionPane.showMessageDialog(this, "Supplier Added Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int selectedRow = jTable1.getSelectedRow();
        
        if (evt.getClickCount() == 2 && selectedRow != -1) {
            
            jTextField1.setText(String.valueOf(jTable1.getValueAt(selectedRow, 0)));
            jTextField2.setText(String.valueOf(jTable1.getValueAt(selectedRow, 1)));
            jTextField4.setText(String.valueOf(jTable1.getValueAt(selectedRow, 2)));
            jTextField3.setText(String.valueOf(jTable1.getValueAt(selectedRow, 3)));
            
            String compnyId = getSupplierCompanyIdInMobile(String.valueOf(jTable1.getValueAt(selectedRow, 0)));
            setSelectedCompanyId(compnyId);
            
            jTextField1.setEnabled(false);
            jButton1.setEnabled(false);
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        loadSuppliers();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
        loadSuppliers();
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String mobile = jTextField1.getText();
        String fName = jTextField2.getText();
        String lName = jTextField4.getText();
        String companyId = getSelectedCompanyId();
        
        if (fName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter First Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (fName.length() > 45) {
            JOptionPane.showMessageDialog(this, "First Name is too long", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (lName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Last Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (lName.length() > 45) {
            JOptionPane.showMessageDialog(this, "Last Name is too long", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (companyId.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select Supplier Company", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            
            try {
                
                ResultSet resultset = MySQL.execute("SELECT * FROM `supplier` WHERE `mobile`='" + mobile + "'");
                
                if (resultset.next()) {
                    MySQL.execute("UPDATE `Supplier` SET `fname`='" + fName + "',`lname`='" + lName + "',`company_id`='" + companyId + "' WHERE `mobile`='" + mobile + "' ");
                    loadSuppliers();
                    reset();
                    jTextField1.setEnabled(true);
                    jButton1.setEnabled(true);
                    jButton2.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Updated Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Something Went Wrong", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        loadPendingPayments();
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        loadPendingPayments();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
        loadSettledPayments();
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
        loadSettledPayments();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
            
         try {
            HashMap<String, Object> map1 = new HashMap<>();

            String reportPath = "/reports/suplier.jasper";

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
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables

    private void AddSupplierCompany() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
