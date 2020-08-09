/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DC.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Christian
 */
public class Officials extends javax.swing.JInternalFrame {
    Main a;
    /**
     * Creates new form 
     */
    public Officials() {
        initComponents();
    }
    public Officials(Main a) {
        initComponents();
        this.a = a;
        LoadOfficial();
    }
    
    String getOfficials (String id){
        String name = null;
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("Select * from officials where id='" + id + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                name = "Hon. " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(2);
                break;
            }
         }catch (Exception e) {
            System.out.println(e);
        }
        return name;
    }
    
    String getOfficer (String id){
        String name = null;
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("Select * from officials where id='" + id + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(7).equals("Single") && rs.getString(8).equals("Female")){
                    name = "Ms. " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(2);
                } else if (rs.getString(7).equals("Married") && rs.getString(8).equals("Female")){
                    name = "Mrs. " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(2);
                } else {
                    name = "Mr. " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(2);
                }
                break;
            }
         }catch (Exception e) {
            System.out.println(e);
        }
        return name;
    }
    
    void LoadOfficial(){
        txt_kptn.setText(this.getOfficials("kptn"));
        kgwd1.setText(this.getOfficials("kgwd1"));
        kgwd2.setText(this.getOfficials("kgwd2"));
        kgwd3.setText(this.getOfficials("kgwd3"));
        kgwd4.setText(this.getOfficials("kgwd4"));
        kgwd5.setText(this.getOfficials("kgwd5"));
        kgwd6.setText(this.getOfficials("kgwd6"));
        kgwd7.setText(this.getOfficials("kgwd7"));
        txt_secr.setText(this.getOfficer("secr"));
        txt_trea.setText(this.getOfficer("trea"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_trea = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kgwd2 = new javax.swing.JLabel();
        kgwd1 = new javax.swing.JLabel();
        kgwd4 = new javax.swing.JLabel();
        kgwd3 = new javax.swing.JLabel();
        kgwd6 = new javax.swing.JLabel();
        kgwd5 = new javax.swing.JLabel();
        kgwd7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_kptn = new javax.swing.JLabel();
        txt_secr = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OFFICIALS AND STAFF");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 930, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PUNONG BARANGAY");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 930, 20));

        txt_trea.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txt_trea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txt_trea, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 430, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TREASURER");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 430, 20));

        kgwd2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kgwd2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(kgwd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 430, 30));

        kgwd1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kgwd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(kgwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 430, 30));

        kgwd4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kgwd4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(kgwd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 430, 30));

        kgwd3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kgwd3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(kgwd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 430, 30));

        kgwd6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kgwd6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(kgwd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 430, 30));

        kgwd5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kgwd5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(kgwd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 430, 30));

        kgwd7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kgwd7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(kgwd7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 430, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KAGAWAD");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 430, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SECRETARY");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 430, 20));

        txt_kptn.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txt_kptn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txt_kptn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 930, 30));

        txt_secr.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txt_secr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txt_secr, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 430, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("UPDATE OFFICIALS AND STAFF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, 220, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 990, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UpdateOfficials b = new UpdateOfficials(new javax.swing.JFrame(), true, this);
        b.setLocationRelativeTo(this.a);
        b.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel kgwd1;
    private javax.swing.JLabel kgwd2;
    private javax.swing.JLabel kgwd3;
    private javax.swing.JLabel kgwd4;
    private javax.swing.JLabel kgwd5;
    private javax.swing.JLabel kgwd6;
    private javax.swing.JLabel kgwd7;
    private javax.swing.JLabel txt_kptn;
    private javax.swing.JLabel txt_secr;
    private javax.swing.JLabel txt_trea;
    // End of variables declaration//GEN-END:variables
}
