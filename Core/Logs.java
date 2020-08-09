/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DC.DBConnection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class Logs extends javax.swing.JInternalFrame {
    Main a;
    DefaultTableModel model1 = new DefaultTableModel();
    Calendar cal = Calendar.getInstance();
    
    /**
     * Creates new form Purok
     */
    public Logs() {
        initComponents();
        model1 = (DefaultTableModel) table_logs.getModel();
        LoadLogs();
        txt_desc.setLineWrap(true);
        txt_desc.setWrapStyleWord(true);
    }
    public Logs(Main a) {
        initComponents();
        this.a = a;
        model1 = (DefaultTableModel) table_logs.getModel();
        LoadLogs();
        txt_desc.setLineWrap(true);
        txt_desc.setWrapStyleWord(true);
    }
    public void LoadLogs() {
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d;
            ps = c.prepareStatement("Select * from logs order by dati DESC");
            rs = ps.executeQuery();
            model1.setRowCount(0);
            while (rs.next()) {
                try {
                    d = dateFormat.parse(rs.getString(5));
                    SimpleDateFormat tim = new SimpleDateFormat("hh:mm:ss a");
                    SimpleDateFormat dat = new SimpleDateFormat("MMMM dd, yyyy");
                    model1.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(4), tim.format(d), dat.format(d)});
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void LoadLogs(String query) {
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d;
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            model1.setRowCount(0);
            while (rs.next()) {
                try {
                    d = dateFormat.parse(rs.getString(5));
                    SimpleDateFormat tim = new SimpleDateFormat("hh:mm:ss a");
                    SimpleDateFormat dat = new SimpleDateFormat("MMMM dd, yyyy");
                    model1.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(4), tim.format(d), dat.format(d)});
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void GenerateLogs(){
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
        if(jComboBox2.getSelectedIndex()==0 && jComboBox3.getSelectedIndex()==1){
            LoadLogs();
        } else if(jComboBox2.getSelectedIndex()==0 && jComboBox3.getSelectedIndex()==0){
            LoadLogs("SELECT * FROM logs where dati between '" + d1.format(cal.getTime()) + " 00:00:00' and '" + d1.format(cal.getTime()) + " 23:59:59' order by dati DESC");
        } else if(jComboBox2.getSelectedIndex()> 0 && jComboBox3.getSelectedIndex()==1){
            LoadLogs("SELECT * FROM logs where lvl='" + (String)jComboBox2.getSelectedItem() + "' order by dati DESC");
        } else {
            LoadLogs("SELECT * FROM logs where dati between '" + d1.format(cal.getTime()) + " 00:00:00' and '" + d1.format(cal.getTime()) + " 23:59:59' and lvl='" + (String)jComboBox2.getSelectedItem() + "' order by dati DESC");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_logs = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_desc = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setBorder(null);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_logs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_logs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "User", "Action", "Time", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_logs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_logsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_logs);
        if (table_logs.getColumnModel().getColumnCount() > 0) {
            table_logs.getColumnModel().getColumn(0).setResizable(false);
            table_logs.getColumnModel().getColumn(0).setPreferredWidth(5);
            table_logs.getColumnModel().getColumn(1).setResizable(false);
            table_logs.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_logs.getColumnModel().getColumn(2).setResizable(false);
            table_logs.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_logs.getColumnModel().getColumn(3).setResizable(false);
            table_logs.getColumnModel().getColumn(3).setPreferredWidth(60);
            table_logs.getColumnModel().getColumn(4).setResizable(false);
            table_logs.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 750, 560));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("INFORMATION:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        txt_desc.setEditable(false);
        txt_desc.setColumns(20);
        txt_desc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_desc.setRows(5);
        jScrollPane2.setViewportView(txt_desc);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 230, 130));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "GENERATE REPORT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Date To:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 20));

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jPanel2.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 120, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("date.");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Date From:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, 20));

        jSpinner2.setModel(new javax.swing.SpinnerDateModel());
        jPanel2.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 120, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("SHOW IN TABLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Username:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("It will print report about the user's");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("activities in the specific time and");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 210, 20));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("MAKE REPORT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 150, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 230, 250));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "GENERAL OPTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Action" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 210, -1));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Level", "Administrator", "Secretary", "Treasurer" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 140, 20));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Search for:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 20));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Today Logs", "All Logs" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 100, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Show by:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 20));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Refresh_10px.png"))); // NOI18N
        jButton3.setToolTipText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 30, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_logsMouseClicked
        // TODO add your handling code here:
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("Select * from logs");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(String.valueOf(model1.getValueAt(table_logs.getSelectedRow(), 0)))){
                    txt_desc.setText(rs.getString(6));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_table_logsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat d2 = new SimpleDateFormat("MMMM dd, yyyy hh:mm s");
        try{
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\LogReport.jrxml");
            String SQL = "SELECT * FROM logs where dati between '" + d1.format(jSpinner2.getValue()) + "' and '" + d1.format(jSpinner1.getValue()) + "' and user='" + jTextField2.getText() + "'";
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("user", jTextField2.getText());
            m.put("desc", "This is the log report of the user in the system from " + d2.format(jSpinner2.getValue()) + " to " + d2.format(jSpinner1.getValue()) + ".");
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        GenerateLogs();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        GenerateLogs();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        GenerateLogs();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LoadLogs("SELECT * FROM logs where dati between '" + d1.format(jSpinner2.getValue()) + "' and '" + d1.format(jSpinner1.getValue()) + "' and user='" + jTextField2.getText() + "'");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable table_logs;
    private javax.swing.JTextArea txt_desc;
    // End of variables declaration//GEN-END:variables
}
