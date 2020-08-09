/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DC.DBConnection;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author XtianDR
 */
public class UserSetting extends javax.swing.JDialog {
    Main a;
    Image img = (new ImageIcon(getClass().getResource("/Misc/null.png"))).getImage();

    public UserSetting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    public UserSetting(java.awt.Frame parent, boolean modal, Main a) {
        super(parent, modal);
        initComponents();
        this.a = a;
        LoadUserData();
        
    }
    
    void LoadUserData(){
        txt_ln.setText(this.a.a.getLn());
        txt_fn.setText(this.a.a.getFn());
        txt_mi.setText(this.a.a.getMi());
        txt_un.setText(this.a.a.getUser());
        txt_lvl.setText(this.a.a.getLevel());
        txt_rq.setText(this.a.a.getRQ());
        txt_ra.setText(this.a.a.getRA());
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_lvl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_ln = new javax.swing.JTextField();
        txt_fn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_mi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_un = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txt_w1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_conpass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txt_oldpass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txt_newpass = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        txt_w2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cb_rq = new javax.swing.JComboBox<>();
        txt_ra = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_rean = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_rq = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Account Settings");
        setIconImage(img);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Account Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("LEVEL:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 20));

        txt_lvl.setEditable(false);
        txt_lvl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_lvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 210, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("LAST NAME:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 20));

        txt_ln.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 210, -1));

        txt_fn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 210, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("FIRST NAME:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("MIDDLE INITIAL:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 20));

        txt_mi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("USER NAME:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 20));

        txt_un.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_un, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 210, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 70, 30));

        txt_w1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txt_w1.setForeground(java.awt.Color.red);
        jPanel2.add(txt_w1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, 20));

        jTabbedPane1.addTab("General", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ENTER OLD PASSWORD:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 20));

        txt_conpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("ENTER NEW PASSWORD:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 20));

        txt_oldpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CONFIRM NEW PASSWORD:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 20));

        txt_newpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 150, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("SAVE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 70, 30));

        txt_w2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txt_w2.setForeground(java.awt.Color.red);
        jPanel3.add(txt_w2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, 20));

        jTabbedPane1.addTab("Change Password", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_rq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_rq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT RECOVERY QUESTION--", "What is your favorite color?", "What is your father's middle name?", "Who is your favorite actor, singer or artist?", "What was the name of your high school?" }));
        jPanel4.add(cb_rq, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 260, -1));

        txt_ra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_ra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 310, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("RECOVERY QUESTION:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 20));

        txt_rean.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(txt_rean, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 260, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("SAVE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 70, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("RECOVERY ANSWER:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("---------- SAVED RECOVERY QUESTION ----------");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 330, 20));

        txt_rq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_rq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_rq, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 310, 20));

        jTabbedPane1.addTab("Account Recovery", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 360, 270));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Cancel_20px.png"))); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String mi;
        if (txt_ln.getText().isEmpty()){
            txt_w1.setText("*Last name is required");
        } else if (txt_fn.getText().isEmpty()){
            txt_w1.setText("*First name is required");
        } else if (txt_mi.getText().isEmpty()){
            txt_w1.setText("*Username is required");
        } else if (txt_un.getText().length()<4){
            txt_w1.setText("*Username have a least 5 characters.");
        } else {
            try {
                DBConnection.init();
                Connection c = (Connection) DBConnection.getConnection();
                PreparedStatement ps, ps1;
                ps = c.prepareStatement("Update account set user =(?), ln =(?), fn =(?), mi =(?) where user like (?)");
                ps.setString(1, txt_un.getText());
                ps.setString(2, txt_ln.getText());
                ps.setString(3, txt_fn.getText());
                ps.setString(4, txt_mi.getText());
                ps.setString(5, this.a.a.getUser());
                ps1 = c.prepareStatement("INSERT INTO logs (user,lvl,actn,dati,info) VALUES" + "('" + this.a.a.getUser() + "','" +this.a.a.getLevel()+ "','Update User Setting',DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'), 'The user updated his/her general information to the system.')");
                int n = JOptionPane.showConfirmDialog(this, "Do you want to update your general information?", "Confirm Save", JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    ps.executeUpdate();
                    ps1.execute();
                    this.a.a.setUser(txt_un.getText());
                    this.a.a.setName(txt_fn.getText() + " " + txt_mi.getText() + " " + txt_ln.getText());
                    this.a.a.setLn(txt_ln.getText());
                    this.a.a.setFn(txt_fn.getText());
                    this.a.a.setMi(txt_mi.getText());
                    this.a.LoadUserInfo();
                    JOptionPane.showMessageDialog(this, "You update your general information successfully.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (txt_oldpass.getText().isEmpty()){
            txt_w2.setText("*Old password is required");
        } else if(!this.txt_oldpass.getText().equals(this.a.a.getPW())){
            txt_w2.setText("*You entered wrong old password");
            txt_oldpass.setText("");
            txt_newpass.setText("");
            txt_conpass.setText("");
        } else if (txt_newpass.getText().isEmpty()){
            txt_w2.setText("*New password is required");
        } else if (txt_conpass.getText().isEmpty()){
            txt_w2.setText("*Confirm password is required");
        } else if (!txt_newpass.getText().equals(txt_conpass.getText())){
            txt_w2.setText("*New password and confirm password not match");
            txt_newpass.setText("");
            txt_conpass.setText("");
        } else {
            try {
                DBConnection.init();
                Connection c = (Connection) DBConnection.getConnection();
                PreparedStatement ps, ps1;
                ps = c.prepareStatement("Update account set pass =(?) where user like (?)");
                ps.setString(1, txt_newpass.getText());
                ps.setString(2, this.a.a.getUser());
                ps1 = c.prepareStatement("INSERT INTO logs (user,lvl,actn,dati,info) VALUES" + "('" + this.a.a.getUser() + "','" +this.a.a.getLevel()+ "','Update User Setting',DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'), 'The user changed his/her password to the system.')");
                int n = JOptionPane.showConfirmDialog(this, "Do you want to changed your old password?", "Confirm Save", JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    ps.executeUpdate();
                    ps1.execute();
                    this.a.a.setPW(txt_newpass.getText());
                    JOptionPane.showMessageDialog(this, "You changed your password successfully.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
                DBConnection.init();
                Connection c = (Connection) DBConnection.getConnection();
                PreparedStatement ps, ps1;
                ps = c.prepareStatement("Update account set requ =(?), rean =(?) where user like (?)");
                ps.setString(1, (String) cb_rq.getSelectedItem());
                ps.setString(2, txt_rean.getText());
                ps.setString(3, this.a.a.getUser());
                ps1 = c.prepareStatement("INSERT INTO logs (user,lvl,actn,dati,info) VALUES" + "('" + this.a.a.getUser() + "','" +this.a.a.getLevel()+ "','Update User Setting',DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'), 'The user updated his/her account recovery to the system.')");
                int n = JOptionPane.showConfirmDialog(this, "Do you want to update your account recovery?", "Confirm Save", JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    ps.executeUpdate();
                    ps1.execute();
                    this.a.a.setRQ( (String) cb_rq.getSelectedItem());
                    this.a.a.setRA(txt_rean.getText());
                    JOptionPane.showMessageDialog(this, "You update your account recovery successfully.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserSetting dialog = new UserSetting(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_rq;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField txt_conpass;
    private javax.swing.JTextField txt_fn;
    private javax.swing.JTextField txt_ln;
    private javax.swing.JTextField txt_lvl;
    private javax.swing.JTextField txt_mi;
    private javax.swing.JPasswordField txt_newpass;
    private javax.swing.JPasswordField txt_oldpass;
    private javax.swing.JLabel txt_ra;
    private javax.swing.JTextField txt_rean;
    private javax.swing.JLabel txt_rq;
    private javax.swing.JTextField txt_un;
    private javax.swing.JLabel txt_w1;
    private javax.swing.JLabel txt_w2;
    // End of variables declaration//GEN-END:variables
}
