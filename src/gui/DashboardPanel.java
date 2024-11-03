package gui;

import chart.ModelChart;
import chart.ModelPieChart;
import chart.PieChart;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ModelData;
import model.MySQL;

public class DashboardPanel extends javax.swing.JPanel {

    public DashboardPanel() {
        initComponents();
        loadPieChart();
        loadLineChart();
        setData();
        setTotalIncome();
        setTodayIncome();
        setMonthlyIncome();
        setPayment();
        setDrawerBalance();
    }

    private void setDrawerBalance() {
        double add = 0;
        double deduct = 0;
        double balance = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        try {

            ResultSet results = MySQL.execute("SELECT * FROM `drawer` "
                    + "INNER JOIN `transaction_type` ON `drawer`.`transaction_type_id`=`transaction_type`.`id` "
                    + "WHERE `date_time` LIKE '" + date + "%'");
            while (results.next()) {
                if (results.getString("type").equals("Add")) {
                    add += results.getDouble("amount");
                } else {
                    deduct += results.getDouble("amount");
                }
            }
            balance = add - deduct;
            jLabel20.setText("Rs. " + String.valueOf(Dashboard.FORMAT.format(balance)));

        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }
    }

    private void setPayment() {
        double cash = 0;
        double card = 0;
        try {

            ResultSet results = MySQL.execute("SELECT * FROM `invoice` "
                    + "INNER JOIN `payment_method` ON `invoice`.`pm_id`=`payment_method`.`id`");
            while (results.next()) {
                if (results.getString("pm_name").equals("Cash")) {
                    cash += results.getDouble("invoice.payment");
                } else {
                    card += results.getDouble("invoice.payment");
                }
            }
            jLabel16.setText("Rs. " + String.valueOf(Dashboard.FORMAT.format(card)));
            jLabel18.setText("Rs. " + String.valueOf(Dashboard.FORMAT.format(cash)));

        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }
    }

    private void setMonthlyIncome() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String date = format.format(new Date());
        double totalBillDiscount = calculateTotalBillDiscounts("SELECT * FROM `invoice` WHERE `in_date_time` LIKE '" + date + "%'");
        double otherServiceIncome = calculateOtherServiceIncome("SELECT * FROM `other_service` WHERE `order_date` LIKE '" + date + "%'");
        double invoiceItemIncome = calculateTotalInvoiceItemsTable("SELECT * FROM `invoice_item` "
                + "INNER JOIN `invoice` ON `invoice_item`.`in_id`=`invoice`.`in_id` "
                + "INNER JOIN `stock` ON `invoice_item`.`st_barcode`=`stock`.`barcode` WHERE `invoice`.`in_date_time` LIKE '" + date + "%'");
        double repairIncome = calculateRepairIncome("SELECT * FROM `repair` WHERE `order_date` LIKE '" + date + "%'");
        double totalIncome = invoiceItemIncome + otherServiceIncome + repairIncome;
        double netTotalIncome = totalIncome - totalBillDiscount;
        jLabel6.setText("Rs. " + String.valueOf(Dashboard.FORMAT.format(netTotalIncome)));

    }

    private void setTodayIncome() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        double totalBillDiscount = calculateTotalBillDiscounts("SELECT * FROM `invoice` WHERE `in_date_time` LIKE '" + date + "%'");
        double otherServiceIncome = calculateOtherServiceIncome("SELECT * FROM `other_service` WHERE `order_date` LIKE '" + date + "%'");
        double invoiceItemIncome = calculateTotalInvoiceItemsTable("SELECT * FROM `invoice_item` "
                + "INNER JOIN `invoice` ON `invoice_item`.`in_id`=`invoice`.`in_id` "
                + "INNER JOIN `stock` ON `invoice_item`.`st_barcode`=`stock`.`barcode` WHERE `invoice`.`in_date_time` LIKE '" + date + "%'");
        double repairIncome = calculateRepairIncome("SELECT * FROM `repair` WHERE `order_date` LIKE '" + date + "%'");
        double totalIncome = invoiceItemIncome + otherServiceIncome + repairIncome;
        double netTotalIncome = totalIncome - totalBillDiscount;
        jLabel3.setText("Rs. " + String.valueOf(Dashboard.FORMAT.format(netTotalIncome)));

    }

    private void setTotalIncome() {
        double totalBillDiscount = calculateTotalBillDiscounts("SELECT * FROM `invoice`");
        double otherServiceIncome = calculateOtherServiceIncome("SELECT * FROM `other_service`");
        double invoiceItemIncome = calculateTotalInvoiceItemsTable("SELECT * FROM `invoice_item` "
                + "INNER JOIN `stock` ON `invoice_item`.`st_barcode`=`stock`.`barcode`");
        double repairIncome = calculateRepairIncome("SELECT * FROM `repair`");
        double totalIncome = invoiceItemIncome + otherServiceIncome + repairIncome;
        double netTotalIncome = totalIncome - totalBillDiscount;
        jLabel9.setText("Rs. " + String.valueOf(Dashboard.FORMAT.format(netTotalIncome)));
    }

    private void loadLineChart() {
        curveLineChart1.setTitle("Chart Data");
        curveLineChart1.addLegend("Income", Color.decode("#525CEB"), Color.decode("#F5DD61"));
        curveLineChart1.addLegend("Expences", Color.decode("#FFA62F"), Color.decode("#4CCD99"));
    }

    private void setData() {

        String[] totalMonths = {"Jan", "Feb", "Mar", "April", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        double[] costList = {10, 12, 10, 15, 20, 40, 50, 12, 21, 23, 36, 45};
        double[] profitList = {50, 20, 30, 40, 50, 10, 20, 38, 56, 60, 23, 60};
        List<ModelData> list = new ArrayList<>();

        for (int i = 0; i < totalMonths.length; i++) {
            String month = totalMonths[i];
            double cost = costList[i];
            double profit = profitList[i];
            list.add(new ModelData(month, cost, profit));
        }

        for (int y = 0; y < list.size(); y++) {
            ModelData d = list.get(y);
            curveLineChart1.addData(new ModelChart(d.getMonth(), new double[]{d.getCost(), d.getProfit()}));
        }
        curveLineChart1.start();
    }

    private void loadPieChart() {

        int grnRows = 0;
        int invoiceRows = 0;
        int customerReturnRows = 0;
        int supplierReturnRows = 0;

        try {

            ResultSet results1 = MySQL.execute("SELECT COUNT(`barcode`) AS `grnRows` FROM `grn`");
            if (results1.next()) {
                grnRows = results1.getInt("grnRows");
            }

            ResultSet results2 = MySQL.execute("SELECT COUNT(`in_id`) AS `invoiceRows` FROM `invoice`");
            if (results2.next()) {
                invoiceRows = results2.getInt("invoiceRows");
            }

            ResultSet results3 = MySQL.execute("SELECT COUNT(`id`) AS `customerReturnRows` FROM `customer_return`");
            if (results3.next()) {
                customerReturnRows = results3.getInt("customerReturnRows");
            }

            ResultSet results4 = MySQL.execute("SELECT COUNT(`id`) AS `supplierReturnRows` FROM `supplier_return`");
            if (results4.next()) {
                supplierReturnRows = results4.getInt("supplierReturnRows");
            }

        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }

        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        pieChart1.addData(new ModelPieChart("Invoices", invoiceRows, new Color(210, 100, 154)));
        pieChart1.addData(new ModelPieChart("Customer Returns", customerReturnRows, new Color(250, 194, 19)));
        pieChart1.addData(new ModelPieChart("GRN", grnRows, new Color(96, 239, 184)));
        pieChart1.addData(new ModelPieChart("Supplier Returns", supplierReturnRows, new Color(82, 92, 235)));

    }

    private double calculateTotalBillDiscounts(String query) {

        double totalBillDiscounts = 0;
        try {
            ResultSet results = MySQL.execute(query);
            while (results.next()) {
                totalBillDiscounts += results.getDouble("discount");
            }
        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }
        return totalBillDiscounts;
    }

    private double calculateTotalInvoiceItemsTable(String query) {
        double netTotal = 0;
        try {
            ResultSet results = MySQL.execute(query);
            while (results.next()) {
                double subTotal = results.getDouble("invoice_item.qty") * results.getDouble("stock.price");
                netTotal += subTotal - results.getDouble("invoice_item.discount");
            }
        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }

        return netTotal;
    }

    private double calculateOtherServiceIncome(String query) {
        double otherIncome = 0;
        try {
            ResultSet results = MySQL.execute(query);
            while (results.next()) {
                otherIncome += results.getInt("qty") * results.getDouble("amount");
            }
        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }
        return otherIncome;
    }

    private double calculateRepairIncome(String query) {
        double repairIncome = 0;
        try {
            ResultSet results = MySQL.execute(query);
            while (results.next()) {
                repairIncome += results.getDouble("amount");
            }
        } catch (Exception e) {
            SignIn.log1.warning(e.toString());
        }
        return repairIncome;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        curveLineChart1 = new chart.CurveLineChart();
        jPanel7 = new javax.swing.JPanel();
        pieChart1 = new chart.PieChart();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setToolTipText("Title Bar");
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(27, 49, 77));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 117, 105));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(206, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/money (3).png"))); // NOI18N
        jLabel14.setText("Dashboard");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel14.setIconTextGap(10);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(956, 150));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jPanel2.setBackground(new java.awt.Color(21, 52, 72));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wallet.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Today Sales");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Rs. 0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(118, 48, 129));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dividends.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Monthly Sales");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Rs. 0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 117, 105));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bar-chart.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total Sales");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Rs. 0.00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanel1.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(0, 400));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        curveLineChart1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(curveLineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curveLineChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Products Overview");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel8.setLayout(flowLayout1);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/record.png"))); // NOI18N
        jLabel11.setText("Invoices");
        jPanel8.add(jLabel11);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/record (1).png"))); // NOI18N
        jLabel12.setText("Customer Returns");
        jPanel8.add(jLabel12);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/record (2).png"))); // NOI18N
        jLabel13.setText("GRN");
        jPanel8.add(jLabel13);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle.png"))); // NOI18N
        jLabel21.setText("Suplier Returns");
        jPanel8.add(jLabel21);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Card Payments");
        jLabel15.setOpaque(true);
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Rs. 24,500.00");
        jLabel16.setPreferredSize(new java.awt.Dimension(150, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Cash Payments");
        jLabel17.setOpaque(true);
        jLabel17.setPreferredSize(new java.awt.Dimension(150, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Rs. 24,500.00");
        jLabel18.setPreferredSize(new java.awt.Dimension(150, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Drawer Balance");
        jLabel19.setOpaque(true);
        jLabel19.setPreferredSize(new java.awt.Dimension(150, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Rs. 24,500.00");
        jLabel20.setPreferredSize(new java.awt.Dimension(150, 40));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.CurveLineChart curveLineChart1;
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private chart.PieChart pieChart1;
    // End of variables declaration//GEN-END:variables
}
