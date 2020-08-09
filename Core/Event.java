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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class Event extends javax.swing.JInternalFrame {
    Main a;
    DefaultTableModel model1 = new DefaultTableModel();
    String id, tl, ds, da, st, en;
    
    public Event() {
        initComponents();
        model1 = (DefaultTableModel) table_event.getModel();
        LoadEvents();
        txt_desc.setLineWrap(true);
        txt_desc.setWrapStyleWord(true);
        txt_title.setLineWrap(true);
        txt_title.setWrapStyleWord(true);
    }
    public Event(Main a) {
        initComponents();
        this.a = a;
        model1 = (DefaultTableModel) table_event.getModel();
        LoadEvents();
        txt_desc.setLineWrap(true);
        txt_desc.setWrapStyleWord(true);
        txt_title.setLineWrap(true);
        txt_title.setWrapStyleWord(true);
    }
    public void LoadEvents() {
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start, end;
            ps = c.prepareStatement("Select * from events");
            rs = ps.executeQuery();
            model1.setRowCount(0);
            while (rs.next()) {
                try {
                    start = dateFormat.parse(rs.getString(4));
                    end = dateFormat.parse(rs.getString(5));
                    SimpleDateFormat tim = new SimpleDateFormat("hh:mm a");
                    SimpleDateFormat dat = new SimpleDateFormat("MMMM dd, yyyy");
                    model1.addRow(new Object[]{rs.getString(1), rs.getString(2), dat.format(start), tim.format(start), tim.format(end),rs.getString(1)});
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_event = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_title = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_desc = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txt_inc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_end = new javax.swing.JTextField();
        txt_date = new javax.swing.JTextField();
        txt_start = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_event.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_event.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Date", "Start", "End"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_event.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_eventMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_event);
        if (table_event.getColumnModel().getColumnCount() > 0) {
            table_event.getColumnModel().getColumn(0).setResizable(false);
            table_event.getColumnModel().getColumn(0).setPreferredWidth(5);
            table_event.getColumnModel().getColumn(1).setResizable(false);
            table_event.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 750, 520));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ADDED BY:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 20));

        txt_title.setEditable(false);
        txt_title.setBackground(new java.awt.Color(240, 240, 240));
        txt_title.setColumns(20);
        txt_title.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_title.setRows(5);
        jScrollPane2.setViewportView(txt_title);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("EVENT TITLE:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        txt_desc.setEditable(false);
        txt_desc.setBackground(new java.awt.Color(240, 240, 240));
        txt_desc.setColumns(20);
        txt_desc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_desc.setRows(5);
        jScrollPane3.setViewportView(txt_desc);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("END:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, 20));

        txt_inc.setEditable(false);
        txt_inc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_inc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DESCRIPTION:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        txt_end.setEditable(false);
        txt_end.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 100, -1));

        txt_date.setEditable(false);
        txt_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, -1));

        txt_start.setEditable(false);
        txt_start.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txt_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("DATE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("START:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 520));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Delete_20px.png"))); // NOI18N
        jButton1.setText("DELETE");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 110, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Plus_20px.png"))); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Edit_20px.png"))); // NOI18N
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddEvent b = new AddEvent(new javax.swing.JFrame(), true, this);
        b.setLocationRelativeTo(this.a);
        b.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void table_eventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_eventMouseClicked
        // TODO add your handling code here:
        id = String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 0));
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("Select * from events");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 0)))){
                    txt_title.setText(String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 1)));
                    txt_desc.setText(rs.getString(3));
                    txt_date.setText(String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 2)));
                    txt_start.setText(String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 3)));
                    txt_end.setText(String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 4)));
                    txt_inc.setText(rs.getString(6));
                    tl = String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 1));
                    ds = rs.getString(3);
                    da = String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 2));
                    st = String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 3));
                    en = String.valueOf(model1.getValueAt(table_event.getSelectedRow(), 4));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_table_eventMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (this.id==null){
            JOptionPane.showMessageDialog(this, "Sorry! You have not select one of the events in the table.", "Update Event", JOptionPane.ERROR_MESSAGE);
        } else {
            UpdateEvent c = new UpdateEvent(new javax.swing.JFrame(), true, this);
            c.setLocationRelativeTo(this.a);
            c.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_event;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextArea txt_desc;
    private javax.swing.JTextField txt_end;
    private javax.swing.JTextField txt_inc;
    private javax.swing.JTextField txt_start;
    private javax.swing.JTextArea txt_title;
    // End of variables declaration//GEN-END:variables
}