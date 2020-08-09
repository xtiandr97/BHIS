/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Christian
 */
public class FirstSetUp extends javax.swing.JFrame {

    /**
     * Creates new form FirstSetUp
     */
    public FirstSetUp() {
        initComponents();
        setLocationRelativeTo(null);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rb_ct = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        rb_st = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        p3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        txt_ipadd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        p4 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        p5 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Setup Wizard");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sytem Setup Wizard");
        p1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 200, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Palili Padada Barangay Hall");
        p1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 200, 20));

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Welcome to the system. This is the first\nrun of this system and you need to set\nup all the following requirements to make\nthis system work properly.\n\n\n\n\n\nIf do you want to continue, click the \nNEXT button.");
        jTextArea1.setBorder(null);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        p1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 200, 160));

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        p1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 70, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/FS.png"))); // NOI18N
        p1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        getContentPane().add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, 280));

        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setText("Next");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        p2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 70, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("What type of the sytem do you want to use?");
        p2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 20));

        rb_ct.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rb_ct.setText("Client Type");
        rb_ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_ctActionPerformed(evt);
            }
        });
        p2.add(rb_ct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        p2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 70, -1));

        rb_st.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rb_st.setSelected(true);
        rb_st.setText("Server Type");
        rb_st.setOpaque(false);
        rb_st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_stActionPerformed(evt);
            }
        });
        p2.add(rb_st, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("This type of system is not required high memory and fast CPU computers\nbut this system will not work without at least one server type system. It\ncan view and manage data information to the main server.");
        jTextArea2.setBorder(null);
        jTextArea2.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea2);

        p2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 360, 90));

        jScrollPane5.setBorder(null);
        jScrollPane5.setOpaque(false);

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setText("This type of system is required high memory and fast CPU computers to\nhave better performance and work properly and smoothly. This system act\nas main server and all client type system can connect to this sytem and all\nthe data want to stored in the client type software will the stored in this\nsystem.");
        jTextArea5.setBorder(null);
        jTextArea5.setOpaque(false);
        jScrollPane5.setViewportView(jTextArea5);

        p2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 90));

        getContentPane().add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, 280));

        p3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        p3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 70, -1));

        jButton7.setText("Next");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        p3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Connect to the server");
        p3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 20));

        jScrollPane6.setBorder(null);
        jScrollPane6.setOpaque(false);

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea6.setRows(5);
        jTextArea6.setText("You must connect this computer to the main server computer by LAN/WiFi\nand check the IP address of the main server.");
        jTextArea6.setBorder(null);
        jTextArea6.setOpaque(false);
        jScrollPane6.setViewportView(jTextArea6);

        p3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 360, 70));
        p3.add(txt_ipadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel5.setText("Example: 192.168.8.102");
        p3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 130, 20));

        jLabel6.setText("Main Server IP Address:");
        p3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 150, 20));

        getContentPane().add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, 280));

        p4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setText("Back");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        p4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 70, -1));

        jButton9.setText("Finish");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        p4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 70, -1));

        jScrollPane7.setBorder(null);
        jScrollPane7.setOpaque(false);

        jTextArea7.setEditable(false);
        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea7.setRows(5);
        jTextArea7.setText("*  The computer must connect to the LAN/Wi-Fi so that the client type\n    systems can access the server type.\n*  Client type system wont work unless there is one server type.\n*  You must set the connection type to WORK to secure your data.\n\n\n\n\n\n\n\n\n\n\n\nIf you have done, click the Finish button.");
        jTextArea7.setBorder(null);
        jTextArea7.setOpaque(false);
        jScrollPane7.setViewportView(jTextArea7);

        p4.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 360, 230));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Important tips and Guidance before using this system");
        p4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 20));

        getContentPane().add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, 280));

        p5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setText("Close");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        p5.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 70, -1));

        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("All the important information is set up\nsuccessfuly. You can use this system\nnow.");
        jTextArea3.setBorder(null);
        jTextArea3.setOpaque(false);
        jScrollPane3.setViewportView(jTextArea3);

        p5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 200, 70));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sytem Setup Wizard");
        p5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 200, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Completed");
        p5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 200, 20));

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Do not show when login");
        p5.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/FS.png"))); // NOI18N
        p5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        getContentPane().add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        p1.setVisible(false);
        p2.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        p2.setVisible(false);
        p1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String FileName = (System.getProperty("user.dir") + "\\data\\config\\systemtype.txt");
        System.out.println(FileName);
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(FileName);
            bw = new BufferedWriter(fw);
            if (rb_ct.isSelected()){
                bw.write("client");
            } else {
                bw.write("server");
        }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        if (rb_ct.isSelected()){
            p2.setVisible(false);
            p3.setVisible(true);
        } else {
            p2.setVisible(false);
            p4.setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        p3.setVisible(false);
        p2.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (rb_ct.isSelected()){
            p4.setVisible(false);
            p3.setVisible(true);
        } else {
            p4.setVisible(false);
            p2.setVisible(true);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void rb_stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_stActionPerformed
        // TODO add your handling code here:
        if(rb_st.isSelected()){
            rb_ct.setSelected(false);
        } else {
            rb_st.setSelected(true);
        }
    }//GEN-LAST:event_rb_stActionPerformed

    private void rb_ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_ctActionPerformed
        // TODO add your handling code here:
        if(rb_ct.isSelected()){
            rb_st.setSelected(false);
        } else {
            rb_ct.setSelected(true);
        }
    }//GEN-LAST:event_rb_ctActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        p4.setVisible(false);
        p5.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String FileName = (System.getProperty("user.dir") + "\\data\\config\\ipaddress.txt");
        System.out.println(FileName);
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(FileName);
            bw = new BufferedWriter(fw);
            bw.write(txt_ipadd.getText());
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        p3.setVisible(false);
        p4.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FirstSetUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FirstSetUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FirstSetUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirstSetUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstSetUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JRadioButton rb_ct;
    private javax.swing.JRadioButton rb_st;
    private javax.swing.JTextField txt_ipadd;
    // End of variables declaration//GEN-END:variables
}
