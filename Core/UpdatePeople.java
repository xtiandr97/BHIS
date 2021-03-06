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
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class UpdatePeople extends javax.swing.JDialog {
    Image img = (new ImageIcon(getClass().getResource("/Misc/null.png"))).getImage();
    String cvst = "Single";
    String occu = "None";
    String gndr = "Male";
    People a;

    /**
     * Creates new form AddPeople
     */
    public UpdatePeople(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public UpdatePeople(java.awt.Frame parent, boolean modal, People a) {
        super(parent, modal);
        initComponents();
        this.a = a;
        UpdateInfo();
        
    }
    void UpdateInfo (){
        txt_ln.setText(this.a.ln);
        txt_fn.setText(this.a.fn);
        txt_mi.setText(this.a.mi);
        txt_bd.setDate(this.a.d);
        txt_cn.setText(this.a.cntn);
        if (this.a.occu.equals("None")) {
            txt_occu.setEditable(false);
            cb_yes.setSelected(false);
            cb_no.setSelected(true);
            txt_occu.setText("");
        } else {
            txt_occu.setEditable(true);
            cb_yes.setSelected(true);
            cb_no.setSelected(false);
            txt_occu.setText(this.a.occu);
        }
        if (this.a.gndr.equals("Male")) {
            cb_male.setSelected(true);
            cb_female.setSelected(false);
        } else {
            cb_male.setSelected(false);
            cb_female.setSelected(true);
        }
        if (this.a.rlgn.equals(cb_religion.getItemAt(1))) {
            txt_religion.setEditable(false);
            cb_religion.setSelectedIndex(1);
        } else if (this.a.rlgn.equals(cb_religion.getItemAt(2))) {
            txt_religion.setEditable(false);
            cb_religion.setSelectedIndex(2);
        } else if (this.a.rlgn.equals(cb_religion.getItemAt(3))) {
            cb_religion.setSelectedIndex(3);
        } else if (this.a.rlgn.equals(cb_religion.getItemAt(4))) {
            txt_religion.setEditable(false);
            cb_religion.setSelectedIndex(4);
        } else if (this.a.rlgn.equals(cb_religion.getItemAt(5))) {
            txt_religion.setEditable(false);
            cb_religion.setSelectedIndex(5);
        } else {
            cb_religion.setSelectedIndex(6);
            txt_religion.setEditable(true);
            txt_religion.setText(this.a.rlgn);
        }
        switch (this.a.prk) {
            case 1:
                cb_prk.setSelectedIndex(1);
                break;
            case 2:
                cb_prk.setSelectedIndex(2);
                break;
            case 3:
                cb_prk.setSelectedIndex(3);
                break;
            case 4:
                cb_prk.setSelectedIndex(4);
                break;
            case 5:
                cb_prk.setSelectedIndex(5);
                break;
            case 6:
                cb_prk.setSelectedIndex(6);
                break;
            case 7:
                cb_prk.setSelectedIndex(7);
                break;
            default:
                cb_prk.setSelectedIndex(8);
                break;
        }
        if (this.a.pstn.equals(cb_pstn.getItemAt(1))) {
            cb_pstn.setSelectedIndex(1);
        } else if (this.a.pstn.equals(cb_pstn.getItemAt(2))) {
            cb_pstn.setSelectedIndex(2);
        } else if (this.a.pstn.equals(cb_pstn.getItemAt(3))) {
            cb_pstn.setSelectedIndex(3);
        } else if (this.a.pstn.equals(cb_pstn.getItemAt(4))) {
            cb_pstn.setSelectedIndex(4);
        } else if (this.a.pstn.equals(cb_pstn.getItemAt(5))) {
            cb_pstn.setSelectedIndex(5);
        } else if (this.a.pstn.equals(cb_pstn.getItemAt(6))) {
            cb_pstn.setSelectedIndex(6);
        } else if (this.a.pstn.equals(cb_pstn.getItemAt(7))) {
            cb_pstn.setSelectedIndex(7);
        } else if (this.a.pstn.equals(cb_pstn.getItemAt(8))) {
            cb_pstn.setSelectedIndex(8);
        } else {
            cb_pstn.setSelectedIndex(9);
        }
        switch (this.a.cvst) {
            case "Single":
                this.cb_single.setSelected(true);
                this.cb_married.setSelected(false);
                this.cb_widow.setSelected(false);
                break;
            case "Married":
                this.cb_single.setSelected(false);
                this.cb_married.setSelected(true);
                this.cb_widow.setSelected(false);
                break;
            default:
                this.cb_single.setSelected(false);
                this.cb_married.setSelected(false);
                this.cb_widow.setSelected(true);
                break;
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
        jLabel1 = new javax.swing.JLabel();
        txt_mi = new javax.swing.JTextField();
        txt_ln = new javax.swing.JTextField();
        txt_fn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_bd = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_cn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cb_prk = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cb_pstn = new javax.swing.JComboBox<>();
        bt_add = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cb_religion = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cb_no = new javax.swing.JCheckBox();
        cb_female = new javax.swing.JCheckBox();
        cb_yes = new javax.swing.JCheckBox();
        cb_widow = new javax.swing.JCheckBox();
        cb_male = new javax.swing.JCheckBox();
        cb_single = new javax.swing.JCheckBox();
        cb_married = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        txt_occu = new javax.swing.JTextField();
        txt_religion = new javax.swing.JTextField();
        txt_w = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update People");
        setIconImage(img);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("M.I.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 30, -1));

        txt_mi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_mi, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 30, -1));

        txt_ln.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 220, -1));

        txt_fn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Birth Date:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 200, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("First Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 190, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        txt_bd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_bd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Gender:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 50, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Civil Status:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Contact Number:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, 20));

        txt_cn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Purok:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 40, 20));

        cb_prk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_prk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT PUROK--", "Purok 1", "Purok 2", "Purok 3", "Purok 4", "Purok 5", "Purok 6", "Purok 7" }));
        jPanel1.add(cb_prk, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 200, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Position:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, 20));

        cb_pstn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_pstn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT POSITION--", "President", "Vice President", "Secretary", "Assistant Secretary", "Treasurer", "Peace In Order", "Business Manager", "Collector", "Member" }));
        jPanel1.add(cb_pstn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 200, -1));

        bt_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Ok_20px.png"))); // NOI18N
        bt_add.setText("OK");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        jPanel1.add(bt_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 80, -1));

        bt_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Cancel_20px.png"))); // NOI18N
        bt_cancel.setText("CANCEL");
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(bt_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Religion:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        cb_religion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_religion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT RELIGION--", "None", "Roman Catholic", "Islam", "One Way", "Born Again", "Others" }));
        cb_religion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_religionActionPerformed(evt);
            }
        });
        jPanel1.add(cb_religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 160, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Occupation:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        cb_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_no.setSelected(true);
        cb_no.setText("No");
        cb_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_noActionPerformed(evt);
            }
        });
        jPanel1.add(cb_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, 20));

        cb_female.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_female.setText("Female");
        cb_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_femaleActionPerformed(evt);
            }
        });
        jPanel1.add(cb_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, 20));

        cb_yes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_yes.setText("Yes");
        cb_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_yesActionPerformed(evt);
            }
        });
        jPanel1.add(cb_yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, 20));

        cb_widow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_widow.setText("Widow");
        cb_widow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_widowActionPerformed(evt);
            }
        });
        jPanel1.add(cb_widow, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, 20));

        cb_male.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_male.setSelected(true);
        cb_male.setText("Male");
        cb_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_maleActionPerformed(evt);
            }
        });
        jPanel1.add(cb_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, 20));

        cb_single.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_single.setSelected(true);
        cb_single.setText("Single");
        cb_single.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_singleActionPerformed(evt);
            }
        });
        jPanel1.add(cb_single, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, 20));

        cb_married.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_married.setText("Married");
        cb_married.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_marriedActionPerformed(evt);
            }
        });
        jPanel1.add(cb_married, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Do you have work?");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 20));

        txt_occu.setEditable(false);
        txt_occu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_occu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 160, -1));

        txt_religion.setEditable(false);
        txt_religion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 250, -1));

        txt_w.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txt_w.setForeground(java.awt.Color.red);
        jPanel1.add(txt_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 300, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void cb_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_maleActionPerformed
        // TODO add your handling code here:
        if (cb_male.isSelected()) {
            cb_female.setSelected(false);
            gndr = "Male";
        } else {
            cb_male.setSelected(true);
        }
    }//GEN-LAST:event_cb_maleActionPerformed

    private void cb_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_femaleActionPerformed
        // TODO add your handling code here:
        if (cb_female.isSelected()) {
            cb_male.setSelected(false);
            gndr = "Female";
        } else {
            cb_female.setSelected(true);
        }
    }//GEN-LAST:event_cb_femaleActionPerformed

    private void cb_singleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_singleActionPerformed
        // TODO add your handling code here:
        if (cb_single.isSelected()) {
            cb_married.setSelected(false);
            cb_widow.setSelected(false);
            cvst = "Single";
        } else {
            cb_single.setSelected(true);
        }
    }//GEN-LAST:event_cb_singleActionPerformed

    private void cb_widowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_widowActionPerformed
        // TODO add your handling code here:
        if (cb_widow.isSelected()) {
            cb_married.setSelected(false);
            cb_single.setSelected(false);
            cvst = "Widow";
        } else {
            cb_widow.setSelected(true);
        }
    }//GEN-LAST:event_cb_widowActionPerformed

    private void cb_marriedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_marriedActionPerformed
        // TODO add your handling code here:
        if (cb_married.isSelected()) {
            cb_widow.setSelected(false);
            cb_single.setSelected(false);
            cvst = "Married";
        } else {
            cb_married.setSelected(true);
        }
    }//GEN-LAST:event_cb_marriedActionPerformed

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        // TODO add your handling code here:
        if (txt_ln.getText().isEmpty()) {
            txt_w.setText("*Last Name is required");
        } else if (txt_fn.getText().isEmpty()) {
            txt_w.setText("*First Name is required");
        } else if (txt_bd.getDate() == null) {
            txt_w.setText("*Birth Date is required");
        } else if (cb_religion.getSelectedIndex() == 0) {
            txt_w.setText("*Select your religion");
        } else if (cb_religion.getSelectedIndex() == 6 && txt_religion.getText().isEmpty()) {
            txt_w.setText("*Enter your religion");
        } else if (cb_prk.getSelectedIndex() == 0) {
            txt_w.setText("*Purok is required");
        } else if (cb_pstn.getSelectedIndex() == 0) {
            txt_w.setText("*Your purok position is required");
        } else if (cb_yes.isSelected() && txt_occu.getText().isEmpty()) {
            txt_w.setText("*Your occupation is required");
        } else {
            String rlgn;
            if (cb_religion.getSelectedIndex() == 6) {
                rlgn = txt_religion.getText();
            } else {
                rlgn = (String) cb_religion.getSelectedItem();
            }
            if (cb_yes.isSelected()) {
                occu = txt_occu.getText();
            }
            txt_w.setText("");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = (String) sdf.format(txt_bd.getDate());
            try {
                DBConnection.init();
                Connection c = (Connection) DBConnection.getConnection();
                PreparedStatement ps, ps1;
                ps = c.prepareStatement("Update people set ID =(?),ln =(?),fn =(?),mi =(?),brdt =(?),prk =(?),pstn =(?),cnt =(?),cvst =(?),occu =(?),rlgn =(?),gndr =(?) where ID like (?)");
                ps1 = c.prepareStatement("INSERT INTO logs (user,lvl,actn,dati,info) VALUES" + "('" + this.a.a.a.getUser() + "','" +this.a.a.a.getLevel()+ "','Update People',DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'), 'The user updated people named " + txt_fn.getText() + " " + txt_mi.getText() + " " + txt_ln.getText() + "[" + this.a.id + "] to the system.')");
                ps.setString(1, this.a.id);
                ps.setString(2, txt_ln.getText());
                ps.setString(3, txt_fn.getText());
                ps.setString(4, txt_mi.getText());
                ps.setString(5, date);
                ps.setString(6, String.valueOf(cb_prk.getSelectedIndex()));
                ps.setString(7, (String) cb_pstn.getSelectedItem());
                ps.setString(8, txt_cn.getText());
                ps.setString(9, cvst);
                ps.setString(10, occu);
                ps.setString(11, rlgn);
                ps.setString(12, gndr);
                ps.setString(13, this.a.id);
                int n = JOptionPane.showConfirmDialog(null, "Do you want to update this people?", "Confirm Update", JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    ps.executeUpdate();
                    ps1.execute();
                    JOptionPane.showMessageDialog(null, "You update this people successfully");
                    dispose();
                    a.LoadPeople();
                    a.SetNull();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_bt_addActionPerformed

    private void cb_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_yesActionPerformed
        // TODO add your handling code here:
        if (cb_yes.isSelected()) {
            cb_no.setSelected(false);
            txt_occu.setEditable(true);
        } else {
            cb_yes.setSelected(true);
        }
    }//GEN-LAST:event_cb_yesActionPerformed

    private void cb_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_noActionPerformed
        // TODO add your handling code here:
        if (cb_no.isSelected()) {
            cb_yes.setSelected(false);
            txt_occu.setEditable(false);
        } else {
            cb_no.setSelected(true);
        }
    }//GEN-LAST:event_cb_noActionPerformed

    private void cb_religionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_religionActionPerformed
        // TODO add your handling code here:
        if (cb_religion.getSelectedIndex() == 6) {
            txt_religion.setEditable(true);
        } else {
            txt_religion.setEditable(false);
        }
    }//GEN-LAST:event_cb_religionActionPerformed

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
            java.util.logging.Logger.getLogger(UpdatePeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdatePeople dialog = new UpdatePeople(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_cancel;
    private javax.swing.JCheckBox cb_female;
    private javax.swing.JCheckBox cb_male;
    private javax.swing.JCheckBox cb_married;
    private javax.swing.JCheckBox cb_no;
    private javax.swing.JComboBox<String> cb_prk;
    private javax.swing.JComboBox<String> cb_pstn;
    private javax.swing.JComboBox<String> cb_religion;
    private javax.swing.JCheckBox cb_single;
    private javax.swing.JCheckBox cb_widow;
    private javax.swing.JCheckBox cb_yes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txt_bd;
    private javax.swing.JTextField txt_cn;
    private javax.swing.JTextField txt_fn;
    private javax.swing.JTextField txt_ln;
    private javax.swing.JTextField txt_mi;
    private javax.swing.JTextField txt_occu;
    private javax.swing.JTextField txt_religion;
    private javax.swing.JLabel txt_w;
    // End of variables declaration//GEN-END:variables
}
