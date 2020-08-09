/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import javax.swing.table.DefaultTableModel;
import DC.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Christian
 */
public class Money extends javax.swing.JInternalFrame {
    Main a;
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model3 = new DefaultTableModel();
    DecimalFormat digit = new DecimalFormat("0.00");
    
    /**
     * Creates new form Purok
     */
    public Money() {
        initComponents();
        model1 = (DefaultTableModel) table_item.getModel();
        model2 = (DefaultTableModel) table_trans.getModel();
        model3 = (DefaultTableModel) table_cashier.getModel();
        generateTID();
        txt_information.setLineWrap(true);
        txt_information.setWrapStyleWord(true);
    }
    
    public Money(Main a) {
        initComponents();
        this.a = a;
        model1 = (DefaultTableModel) table_item.getModel();
        model2 = (DefaultTableModel) table_trans.getModel();
        model3 = (DefaultTableModel) table_cashier.getModel();
        generateTID();
        txt_information.setLineWrap(true);
        txt_information.setWrapStyleWord(true);
        
    }
    public void LoadItem() {
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("SELECT * from items");
            rs = ps.executeQuery();
            model1.setRowCount(0);
            while (rs.next()) {
                model1.addRow(new Object[]{rs.getString(1), rs.getString(2), String.valueOf(digit.format(Double.parseDouble(rs.getString(3)))), rs.getString(4), rs.getString(5)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void LoadTrans() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        double totme = 0;
        double totmu = 0;
        double todme = 0;
        double todmu = 0;
        double totml, todml;
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps, ps1;
            ResultSet rs, rs1;
            ps = c.prepareStatement("SELECT * from trans");
            ps1 = c.prepareStatement("SELECT * from trans where pay_date like '" + dateFormat.format(new Date()) + "%'");
            rs = ps.executeQuery();
            rs1 = ps1.executeQuery();
            model2.setRowCount(0);
            while (rs.next()) {
                model2.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(7), String.valueOf(digit.format(Double.parseDouble(rs.getString(4)))), rs.getString(5), rs.getString(6)});
                if (rs.getString(7).equals("Withdraw")){
                    totmu = totmu + Double.parseDouble(rs.getString(4));
                } else {
                    totme = totme + Double.parseDouble(rs.getString(4));
                }
            }
            while (rs1.next()) {
                if (rs1.getString(7).equals("Withdraw")){
                    todmu = todmu + Double.parseDouble(rs1.getString(4));
                } else {
                    todme = todme + Double.parseDouble(rs1.getString(4));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        totml = totme - totmu;
        todml = todme - todmu;
        txt_totme.setText(digit.format(totme));
        txt_totmu.setText(digit.format(totmu));
        txt_totml.setText(digit.format(totml));
        txt_todme.setText(digit.format(todme));
        txt_todmu.setText(digit.format(todmu));
        txt_todml.setText(digit.format(todml));
    }
    public String getLastTrans() {
        String tid = null;
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("SELECT * from trans");
            rs = ps.executeQuery();
            while (rs.next()) {
                tid = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tid;
    }
    public void generateTID (){
        if (getLastTrans() == null){
            txt_tid.setText("1");
        } else {
            txt_tid.setText(String.valueOf(Integer.parseInt(getLastTrans())+1));
        }
    }
    public void getInfo(String ID) {
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("SELECT * from trans where ID = " + ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (ID.equals(rs.getString(1))){
                    txt_information.setText(rs.getString(3));
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void clearAll(){
        txt_totpay.setText("");
        txt_iid.setText("");
        txt_pnym.setText("");
        txt_pcash.setText("");
        model3.setRowCount(0);
    }
    public void showReceipt(String tid, String payor, String total, String cash, String change, String incharge){
        String query = "Select * from receipt";
        try {
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\Receipt.jrxml");
            String SQL = query;
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("tid", tid);
            m.put("payor", payor);
            m.put("total", total);
            m.put("amount", cash);
            m.put("change", change);
            m.put("incharge", incharge);
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void clearRecept(){
        try {
                DBConnection.init();
                Connection c = (Connection) DBConnection.getConnection();
                PreparedStatement ps;
                ps = c.prepareStatement("Truncate table receipt");
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
    }
    public void insertReceipt(String quantity, String item, String price, String total){
        try {
                DBConnection.init();
                Connection c = (Connection) DBConnection.getConnection();
                PreparedStatement ps;
                ps = c.prepareStatement("Insert into receipt (quan, item, pric, tot) values (" + quantity + ",'" + item + "'," + price + ", " + total + ")");
                ps.execute();
            } catch (Exception e) {
                System.out.println(e);
            }
    }
    public void insertTransaction(String tid,String payor, String info, String total, String incharge){
        try {
                DBConnection.init();
                Connection c = (Connection) DBConnection.getConnection();
                PreparedStatement ps;
                ps = c.prepareStatement("Insert into trans (ID, payor, info, tot_amount, pay_date, treasurer, type) values (" + tid + " ,'" + payor + "','" + info + "'," + total + ", DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'), '" + incharge + "', 'Transaction')");
                ps.execute();
            } catch (Exception e) {
                System.out.println(e);
            }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_cashier = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txt_totpay = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_pchange = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_pcash = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_isnym = new javax.swing.JTextField();
        txt_idd = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_totco = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_costq = new javax.swing.JTextField();
        txt_qntty = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txt_iid = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        txt_tid = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txt_pnym = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_trans = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txt_todmu = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_todme = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_totme = new javax.swing.JTextField();
        txt_totmu = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txt_todml = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_totml = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_information = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jPanel11 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_item = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_cashier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Item Name", "Cost", "Total Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_cashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cashierMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_cashier);
        if (table_cashier.getColumnModel().getColumnCount() > 0) {
            table_cashier.getColumnModel().getColumn(0).setResizable(false);
            table_cashier.getColumnModel().getColumn(1).setResizable(false);
            table_cashier.getColumnModel().getColumn(2).setResizable(false);
            table_cashier.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 710, 410));

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_totpay.setEditable(false);
        txt_totpay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel6.add(txt_totpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 140, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("TOTAL PAYMENT:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Php.");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 40, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Php.");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 40, 30));

        txt_pchange.setEditable(false);
        txt_pchange.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel6.add(txt_pchange, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 140, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("CHANGE:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 90, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("CASH:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 60, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Php.");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 40, 30));

        txt_pcash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_pcash.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_pcashCaretUpdate(evt);
            }
        });
        txt_pcash.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_pcashFocusLost(evt);
            }
        });
        jPanel6.add(txt_pcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 140, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 960, 50));

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Php.");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 30, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("NAME:");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("TOTAL COST:");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("QUANTITY:");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 70, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("COST/QUANTITY:");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        txt_isnym.setEditable(false);
        jPanel7.add(txt_isnym, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 170, -1));

        txt_idd.setEditable(false);
        jPanel7.add(txt_idd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("ID:");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        txt_totco.setEditable(false);
        jPanel7.add(txt_totco, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 80, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Php.");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 30, 20));

        txt_costq.setEditable(false);
        jPanel7.add(txt_costq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 80, -1));

        txt_qntty.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_qnttyCaretUpdate(evt);
            }
        });
        jPanel7.add(txt_qntty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 60, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("ADD ITEM/SERV.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 180, 30));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 240, 230));

        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_iid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_iid.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_iidCaretUpdate(evt);
            }
        });
        jPanel8.add(txt_iid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 100, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("ITEM/SERVICE ID:");
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("BROWSE ITEMS/SERV.");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 120));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("TRANSACTION ID:");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 120, 20));

        txt_tid.setEditable(false);
        txt_tid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 110, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("SAVE AND VIEW RECEIPT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 240, 30));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("CLEAR ALL");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 240, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("PAYOR:");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 60, 20));

        txt_pnym.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_pnym, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 270, -1));

        jTabbedPane1.addTab("Cashier", new javax.swing.ImageIcon(getClass().getResource("/Misc/Buy_30px.png")), jPanel3); // NOI18N

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_trans.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_trans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Payor", "Type", "Amount", "Date and Time", "In-charge"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_trans);
        if (table_trans.getColumnModel().getColumnCount() > 0) {
            table_trans.getColumnModel().getColumn(0).setResizable(false);
            table_trans.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_trans.getColumnModel().getColumn(1).setResizable(false);
            table_trans.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_trans.getColumnModel().getColumn(2).setResizable(false);
            table_trans.getColumnModel().getColumn(3).setResizable(false);
            table_trans.getColumnModel().getColumn(3).setPreferredWidth(15);
            table_trans.getColumnModel().getColumn(4).setResizable(false);
            table_trans.getColumnModel().getColumn(4).setPreferredWidth(80);
            table_trans.getColumnModel().getColumn(5).setResizable(false);
            table_trans.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 760, 360));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "SUMMARY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Php.");
        jPanel9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 30, 20));

        txt_todmu.setEditable(false);
        txt_todmu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel9.add(txt_todmu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Php.");
        jPanel9.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 30, 20));

        txt_todme.setEditable(false);
        txt_todme.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel9.add(txt_todme, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 100, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("-----TOTAL-----");
        jPanel9.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 100, 20));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Php.");
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 30, 20));

        txt_totme.setEditable(false);
        txt_totme.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel9.add(txt_totme, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 100, -1));

        txt_totmu.setEditable(false);
        txt_totmu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel9.add(txt_totmu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 100, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Php.");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 30, 20));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("Money Used:");
        jPanel9.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Money Left:");
        jPanel9.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 20));

        txt_todml.setEditable(false);
        txt_todml.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel9.add(txt_todml, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Php.");
        jPanel9.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 30, 20));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("Php.");
        jPanel9.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 30, 20));

        txt_totml.setEditable(false);
        txt_totml.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel9.add(txt_totml, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 100, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Money Earned:");
        jPanel9.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("-----TODAY-----");
        jPanel9.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 100, 20));

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 400, 130));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setOpaque(false);

        txt_information.setEditable(false);
        txt_information.setColumns(20);
        txt_information.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_information.setRows(5);
        txt_information.setOpaque(false);
        jScrollPane4.setViewportView(txt_information);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 100));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 560, 130));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "GENERATE REPORTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("MAKE REPORT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("TO:");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 40, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("in the specific date.");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("FROM:");
        jPanel10.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 40, 20));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("It will print a report about");
        jPanel10.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("the list of transactions and the");
        jPanel10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("total money earned and used");
        jPanel10.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, -1));

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jPanel10.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 110, -1));

        jSpinner2.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1488297600000L), null, null, java.util.Calendar.DAY_OF_MONTH));
        jPanel10.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 110, -1));

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 190, 220));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "GENERAL OPTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("WITHDRAW/DEPOSIT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Search for:");
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Payor", "In-charge" }));
        jPanel11.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, 20));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel11.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 170, -1));

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 150));

        jTabbedPane1.addTab("Transaction", new javax.swing.ImageIcon(getClass().getResource("/Misc/Banknotes_30px.png")), jPanel5); // NOI18N

        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_item.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_item.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item/Service Name", "Cost (Php.)", "Added by", "Date Added/Update"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_item);
        if (table_item.getColumnModel().getColumnCount() > 0) {
            table_item.getColumnModel().getColumn(0).setResizable(false);
            table_item.getColumnModel().getColumn(0).setPreferredWidth(2);
            table_item.getColumnModel().getColumn(1).setResizable(false);
            table_item.getColumnModel().getColumn(1).setPreferredWidth(150);
            table_item.getColumnModel().getColumn(2).setResizable(false);
            table_item.getColumnModel().getColumn(2).setPreferredWidth(15);
            table_item.getColumnModel().getColumn(3).setResizable(false);
            table_item.getColumnModel().getColumn(3).setPreferredWidth(100);
            table_item.getColumnModel().getColumn(4).setResizable(false);
            table_item.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 680, 450));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Delete_20px.png"))); // NOI18N
        jButton1.setText("DELETE");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 100, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Plus_20px.png"))); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Edit_20px.png"))); // NOI18N
        jButton3.setText("UPDATE");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 180, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("ID #:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 180, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 180, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("NAME:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("PRICE:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("DATE:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 180, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("ADDED BY:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 180, 20));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 270, 450));

        jTabbedPane1.addTab("Items/Services", new javax.swing.ImageIcon(getClass().getResource("/Misc/Combo Chart_30px.png")), jPanel2); // NOI18N

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 990, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (txt_idd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Sorry! No item/service selected.", "Add Item/Service Failed", JOptionPane.ERROR_MESSAGE);
        } else {
        
        double tot = 0;
        model3.addRow(new Object[]{txt_qntty.getText(),txt_isnym.getText(),txt_costq.getText(),txt_totco.getText()});
        if (model3.getRowCount()!=0){
            for (int i=0; i < model3.getRowCount(); i++){
            tot = tot + Double.parseDouble((String) model3.getValueAt(i, 3));
        }
            txt_totpay.setText(digit.format(tot));
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddItem b = new AddItem(new javax.swing.JFrame(), true, this);
        b.setLocationRelativeTo(this.a);
        b.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_iidCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_iidCaretUpdate
        // TODO add your handling code here:
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("SELECT * from items");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (txt_iid.getText().equals(rs.getString(1))){
                    txt_costq.setText(digit.format(Double.parseDouble(rs.getString(3))));
                    txt_idd.setText(rs.getString(1));
                    txt_isnym.setText(rs.getString(2));
                    txt_qntty.setText("1");
                    txt_totco.setText(digit.format((Double.parseDouble(rs.getString(3)))*(Integer.parseInt(txt_qntty.getText()))));
                    break;
                } else {
                    txt_qntty.setText("");
                    txt_idd.setText("");
                    txt_isnym.setText("");
                    txt_costq.setText("");
                    txt_totco.setText("");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_txt_iidCaretUpdate

    private void txt_qnttyCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_qnttyCaretUpdate
        // TODO add your handling code here:   
        if(txt_qntty.getText().isEmpty()){
            
        } else {
            txt_totco.setText(digit.format((Double.parseDouble(txt_costq.getText()))*(Integer.parseInt(txt_qntty.getText()))));
        }
    }//GEN-LAST:event_txt_qnttyCaretUpdate

    private void table_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cashierMouseClicked
        // TODO add your handling code here:
        model3.removeRow(table_cashier.getSelectedRowCount()-1);
    }//GEN-LAST:event_table_cashierMouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        switch (jTabbedPane1.getSelectedIndex()) {
            case 2:
                LoadItem();
                break;
            case 1:
                LoadTrans();
                break;
            default:
                
                break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Items bc = new Items (new javax.swing.JFrame(), true, this);
        bc.setLocationRelativeTo(this.a);
        bc.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (model3.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Sorry! You have not have any item/services in the purchase list.", "Purchased Failed", JOptionPane.ERROR_MESSAGE);
        } else {
            int n = JOptionPane.showConfirmDialog(this, "Do you want to purchase this and add to the transaction?\nYou can't undo this action.", "Confirm Purchase", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
            String x = "Item and services purchased:";
            for (int i=0; i < model3.getRowCount(); i++){
                x = x + "\n" +(model3.getValueAt(i, 0) + " - " + model3.getValueAt(i, 1) + " (Php. " + model3.getValueAt(i, 2)  +") ==>> Php. "+ model3.getValueAt(i, 3));
                insertReceipt(String.valueOf(model3.getValueAt(i, 0)), String.valueOf(model3.getValueAt(i, 1)), String.valueOf(model3.getValueAt(i, 2)), String.valueOf(model3.getValueAt(i, 3)));
            }
            showReceipt(txt_tid.getText(), txt_pnym.getText(), txt_totpay.getText(), txt_pcash.getText(), txt_pchange.getText(), this.a.a.getName());
            x = x + "\nTotal: Php. " + txt_totpay.getText() + "\nCash: Php. " + txt_pcash.getText() + "\nChange: Php. " + txt_pchange.getText();
            insertTransaction(txt_tid.getText(),txt_pnym.getText() , x,  txt_totpay.getText() ,  this.a.a.getName());
            clearRecept();
            generateTID();
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_pcashCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_pcashCaretUpdate
        // TODO add your handling code here:
        double change = 0;
        if (!txt_pcash.getText().isEmpty()){
            change = (Double.parseDouble(txt_pcash.getText()) - Double.parseDouble(txt_totpay.getText()));
        }
        if (change < 0){
            txt_pchange.setForeground(java.awt.Color.RED);
            txt_pchange.setText(digit.format(change));
        } else {
            txt_pchange.setForeground(java.awt.Color.BLACK);
            txt_pchange.setText(digit.format(change));
        }
    }//GEN-LAST:event_txt_pcashCaretUpdate

    private void table_transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_transMouseClicked
        // TODO add your handling code here:
        getInfo(String.valueOf(model2.getValueAt(table_trans.getSelectedRow(), 0)));
    }//GEN-LAST:event_table_transMouseClicked

    private void txt_pcashFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pcashFocusLost
        // TODO add your handling code here:
        if (!txt_pcash.getText().isEmpty()){
            txt_pcash.setText(digit.format(Double.parseDouble(txt_pcash.getText())));
        }
    }//GEN-LAST:event_txt_pcashFocusLost

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        generateTID();
        clearAll();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        WithdrawDeposit bv = new WithdrawDeposit (new javax.swing.JFrame(), true, this);
        bv.setLocationRelativeTo(this.a);
        bv.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dt2 = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
        double totme = 0;
        double totmu = 0;
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("SELECT * from trans  where pay_date between '" + dt.format(jSpinner2.getValue()) + "' and '" + dt.format(jSpinner1.getValue()) + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(7).equals("Withdraw")){
                    totmu = totmu + Double.parseDouble(rs.getString(4));
                } else {
                    totme = totme + Double.parseDouble(rs.getString(4));
                }
            }
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\IncomeReport.jrxml");
            String SQL = "SELECT * from trans  where pay_date between '" + dt.format(jSpinner2.getValue()) + "' and '" + dt.format(jSpinner1.getValue()) + "'";
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("datefrom", dt2.format(jSpinner2.getValue()));
            m.put("dateto", dt2.format(jSpinner1.getValue()));
            m.put("moneyearned", "Php. " + totme);
            m.put("moneyused", "Php. " + totmu);
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table_cashier;
    private javax.swing.JTable table_item;
    private javax.swing.JTable table_trans;
    private javax.swing.JTextField txt_costq;
    private javax.swing.JTextField txt_idd;
    private javax.swing.JTextField txt_iid;
    private javax.swing.JTextArea txt_information;
    private javax.swing.JTextField txt_isnym;
    private javax.swing.JTextField txt_pcash;
    private javax.swing.JTextField txt_pchange;
    private javax.swing.JTextField txt_pnym;
    private javax.swing.JTextField txt_qntty;
    private javax.swing.JTextField txt_tid;
    private javax.swing.JTextField txt_todme;
    private javax.swing.JTextField txt_todml;
    private javax.swing.JTextField txt_todmu;
    private javax.swing.JTextField txt_totco;
    private javax.swing.JTextField txt_totme;
    private javax.swing.JTextField txt_totml;
    private javax.swing.JTextField txt_totmu;
    private javax.swing.JTextField txt_totpay;
    // End of variables declaration//GEN-END:variables
}
