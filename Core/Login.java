/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DC.DBConnection;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class Login extends javax.swing.JFrame {
    private String server;
    private String ipaddress;
    Main a;
    SetUp b;
    InetAddress ip;
    Image img = (new ImageIcon(getClass().getResource("/Misc/BHIS.png"))).getImage();
    private String user;
    private String level;
    private String name;
    private String ln;
    private String fn;
    private String mi;
    private String requ;
    private String rean;
    private String pass;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        IPAdd();
        RefreshTime();
        FS();
    }

    void IPAdd() {
        this.systype.setText(getServer());
        if (getServer().equals("Server")){
            try {
                ip = InetAddress.getLocalHost();
                this.ipadd.setText(ip.getHostAddress());
            } catch (UnknownHostException e) {
                System.out.println(e);
            }
        } else {
            this.ipadd.setText(getIP());
        }
    }

    void Login() {
        boolean suc = false;
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps, ps1;
            ResultSet rs;
            ps = c.prepareStatement("Select * from account");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(this.tf_un.getText()) && rs.getString(2).equals(this.tf_pw.getText())) {
                    setUser(rs.getString(1));
                    setPW(rs.getString(2));
                    setLevel(rs.getString(3));
                    setName(rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(4));
                    setLn(rs.getString(4));
                    setFn(rs.getString(5));
                    setMi(rs.getString(6));
                    setRQ(rs.getString(8));
                    setRA(rs.getString(9));
                    ps1 = c.prepareStatement("INSERT INTO logs (user,lvl,actn,dati,info) VALUES" + "('" + this.getUser()+ "','" +this.getLevel()+ "','Login',DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'), 'The user login to the system successfully.')");
                    ps1.execute();
                    a = new Main(this);
                    a.setLocationRelativeTo(null);
                    this.dispose();
                    a.setVisible(true);
                    suc = false;
                    break;
                } else {
                    suc = true;
                }
            }
            if (suc) {
                JOptionPane.showMessageDialog(this, "Invalid! Make sure you entered a valid username and password.\nGo to Options->Help for more details", "Login Failed!", JOptionPane.ERROR_MESSAGE);
                tf_pw.setText("");
                tf_pw.requestFocusInWindow();
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Cannot load a data from MySQL. This error occur due to:\n  - Wrong server ip address.\n  - Configuration files is deleted.\n  - This pc cannot connect to the server connection.\n  - Server's Firewall is turned on.\n  - MySQL Server not install/configure properly.\nGo to Options->Help for more details", "Login Failed!", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_un = new javax.swing.JTextField();
        tf_pw = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        bt_fp = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        bt_login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        systype = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ipadd = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(img);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PassWord");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 30));

        tf_un.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_unActionPerformed(evt);
            }
        });
        jPanel2.add(tf_un, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 40));

        tf_pw.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_pw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_pw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_pwKeyPressed(evt);
            }
        });
        jPanel2.add(tf_pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 240, 40));

        jLabel2.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Username");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 240, 30));

        bt_fp.setBackground(new java.awt.Color(204, 255, 255));
        bt_fp.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        bt_fp.setText("Forgot Password");
        bt_fp.setBorder(null);
        bt_fp.setContentAreaFilled(false);
        bt_fp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_fp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_fpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_fpMouseExited(evt);
            }
        });
        bt_fp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fpActionPerformed(evt);
            }
        });
        jPanel2.add(bt_fp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 140, 20));

        jCheckBox1.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jCheckBox1.setText("Show Password");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        bt_login.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        bt_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Enter_20px.png"))); // NOI18N
        bt_login.setText("LOGIN");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        jPanel2.add(bt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 110, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 280, 300));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("SERVER IP ADDRESS:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 140, 20));

        systype.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(systype, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 210, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Login.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("SYSTEM TYPE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 90, 20));

        ipadd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(ipadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 160, 20));

        jMenu1.setText("Options");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Tree Structure_15px.png"))); // NOI18N
        jMenuItem4.setText("Setup Wizard");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Help_15px.png"))); // NOI18N
        jMenuItem1.setText("Help");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Info_15px.png"))); // NOI18N
        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exit");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_fpMouseEntered
        // TODO add your handling code here:
        bt_fp.setFont(new java.awt.Font("Felix Titling", Font.BOLD, 12));
        bt_fp.setForeground(java.awt.Color.RED);
    }//GEN-LAST:event_bt_fpMouseEntered

    private void bt_fpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_fpMouseExited
        // TODO add your handling code here:
        bt_fp.setFont(new java.awt.Font("Felix Titling", Font.PLAIN, 12));
        bt_fp.setForeground(java.awt.Color.BLACK);
    }//GEN-LAST:event_bt_fpMouseExited

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        // TODO add your handling code here:
        Login();
    }//GEN-LAST:event_bt_loginActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        About c = new About(new javax.swing.JFrame(), true);
        c.setLocationRelativeTo(this.a);
        c.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        b = new SetUp(new javax.swing.JFrame(), true, this);
        b.setLocationRelativeTo(this);
        b.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
            this.tf_pw.setEchoChar((char) 0);
        } else {
            this.tf_pw.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void bt_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fpActionPerformed
        // TODO add your handling code here:
        AccountRecover b = new AccountRecover(new javax.swing.JFrame(), true, this);
        b.setLocationRelativeTo(this.a);
        b.setVisible(true);
    }//GEN-LAST:event_bt_fpActionPerformed

    private void tf_pwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pwKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Login();
        }
    }//GEN-LAST:event_tf_pwKeyPressed

    private void tf_unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_unActionPerformed
        // TODO add your handling code here:
        tf_pw.requestFocusInWindow();
    }//GEN-LAST:event_tf_unActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Help();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public void Help (){
        String FileName = (System.getProperty("user.dir") + "\\data\\misc\\help.pdf");
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(FileName);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void RefreshTime() {
        TimerTask TT = new TimerTask() {
            @Override
            public void run() {
                IPAdd();
            }
        };
        Timer t = new Timer();
        t.scheduleAtFixedRate(TT, 1000, 1000);
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fp;
    private javax.swing.JButton bt_login;
    private javax.swing.JLabel ipadd;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel systype;
    private javax.swing.JPasswordField tf_pw;
    private javax.swing.JTextField tf_un;
    // End of variables declaration//GEN-END:variables

    void FS() {
        String FileName = (System.getProperty("user.dir") + "\\data\\config\\setup.txt");
        String line = null;
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(FileName);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!"NO".equals(line)) {
                b = new SetUp(new javax.swing.JFrame(), true, this);
                b.setLocationRelativeTo(this);
                b.setVisible(true);
        }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }
    
    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }
    
    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }
    
    public String getRQ() {
        return requ;
    }

    public void setRQ(String requ) {
        this.requ = requ;
    }
    
    public String getRA() {
        return rean;
    }

    public void setRA(String rean) {
        this.rean = rean;
    }
     
    public String getPW() {
        return pass;
    }

    public void setPW(String pass) {
        this.pass = pass;
    }
    
    public String getServer(){
        String FileName = (System.getProperty("user.dir") + "\\data\\config\\systemtype.txt");
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(FileName);
            br = new BufferedReader(fr);
            while ((server = br.readLine()) != null) {
                return server;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return server;
    }
    public String getIP(){
        String FileName = (System.getProperty("user.dir") + "\\data\\config\\ipaddress.txt");
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(FileName);
            br = new BufferedReader(fr);
            while ((ipaddress = br.readLine()) != null) {
                return ipaddress;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return ipaddress;
    }
}