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
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;

/**
 *
 * @author Christian
 */
public class Doc extends javax.swing.JInternalFrame {
    Main a;
    SimpleDateFormat day = new SimpleDateFormat("dd");
    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MMMM");
    /**
     * Creates new form Doc
     */
    public Doc() {
        initComponents();
    }
    public Doc(Main a) {
        initComponents();
        this.a = a;
        setTextArea();
        
    }
        
    void setTextArea(){
        txt_bodyletter.setLineWrap(true);
        txt_bodyletter.setWrapStyleWord(true);
        txt_body.setLineWrap(true);
        txt_body.setWrapStyleWord(true);
        txt_kbody.setLineWrap(true);
        txt_kbody.setWrapStyleWord(true);
        txt_purpose2.setLineWrap(true);
        txt_purpose2.setWrapStyleWord(true);
        txt_purpose3.setLineWrap(true);
        txt_purpose3.setWrapStyleWord(true);
        txt_purpose1.setLineWrap(true);
        txt_purpose1.setWrapStyleWord(true);
        txt_purpose.setLineWrap(true);
        txt_purpose.setWrapStyleWord(true);
    }
    void setAppointment(){
        
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
    
    String getPurokLeader (String purok){
        String name = null;
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("Select * from officials where prk=" + purok);
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
    
    void RSF(){
        txt_purpose2.setText("Author: Hon. Rose D. Tecson\nEXCERPT FROM THE MINUTES DURING THE REGULAR SESSION OF THE BARANGAY COUNCIL OF PALILI, PADADA, DAVAO DEL SUR HELD ON NOVEMBER 09, 2016 AT EXACTLY  02:30 IN THE AFTERNOON AT BARANGAY SESSION HALL.");
        txt_purpose3.setText("A RESOLUTION  AUTHORIZING ACTING BARANGAY CAPTAIN, FLORITES L. DEMABILDO AND BARANGAY TREASURER, LYN GAY L. LANTICSE ,  AS OFFICIAL SIGNATORIES IN ANY WITHDRAWALS OF BARANGAY PALILI, PADADA, DAVAO DEL SUR AT DEVELOPMENT BANK OF THE PHILIPPINES (DBP)  FOR BARANGAY  PALILI, PADADA, DAVAO DEL SUR.");
        txt_purpose1.setText("\tWHEREAS, Sangguniang Barangay of Barangay Palili, was informed that the reimbursement of Year End Evaluation 2015  is amounting to One Hundred Eighteen Thousand  (P118,000.00)Pesos , intended for the expenses of the conduct of year end evaluation of the 7 puroks held last December 19, 2016 at Barangay Palili, Padada, Davao del Sur;\n\n"
                + "\tWHEREAS, the same Sanggunian  need to conduct an evaluation for the information of the constituents what are the projects and accomplishments of the barangay all through the year of 2015;\n\n"
                + "\tWHEREAS, the same Sanggunian Barangay facilitates the  said evaluation and need to be re-imbursed the expenses of meals and snacks of the barangay constituents  during the activity , since  the barangay officials was informed that the Punong Barangay appoints newly  barangay treasurer that is why the said amount was not withdrawed during the said activity.\n"
                + "\t\t\tNOW THEREFORE,\n"
                + "\tBE IT RESOLVED by the SANGGUNIANG BARANGAY to appropriate amount for the reimbursement of  Year End Evaluation 2015 amounting to One Hundred Eighteen (P118,000.00) Pesos , held last December 19, 2016 at Barangay Palili, Padada, Davao del Sur."
                + "\tADOPTED UNANIMOUSLY on January 06, 2016\n"
                + "x-----------------------------------------------------------------------------------------x\n"
                + "\t\tI HEREBY CERTIFY to the correctness of the foregoing\n"
                + "\t\tresolution which was duly adopted by the Sangguniang\n"
                + "\t\tBarangay during its Regular Session held on January 6, 2016.");
        jTextField3.setText("46");
    }
    
    void RSC(){
        txt_purpose2.setText("");
        txt_purpose3.setText("");
        txt_purpose1.setText("");
        jTextField3.setText("");
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
        p_brgyclearance = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_issued = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        cb_status = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_rescer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_date = new com.toedter.calendar.JDateChooser();
        bt_preview = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cb_purok = new javax.swing.JComboBox<>();
        txt_place = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_purpose = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        txt_married = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cb_type = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        txt_bodyletter = new javax.swing.JTextArea();
        bt_view = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_to1 = new javax.swing.JTextField();
        txt_to2 = new javax.swing.JTextField();
        txt_subject = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_body = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        txt_to4 = new javax.swing.JTextField();
        txt_to5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_purpose1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_purpose2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_purpose3 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cb_purok1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_wn4 = new javax.swing.JTextField();
        txt_role1 = new javax.swing.JTextField();
        txt_wn2 = new javax.swing.JTextField();
        txt_wn1 = new javax.swing.JTextField();
        txt_nym1 = new javax.swing.JTextField();
        txt_role2 = new javax.swing.JTextField();
        txt_nym2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_kbody = new javax.swing.JTextArea();
        txt_wn3 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        p_brgyclearance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Issued This:");
        p_brgyclearance.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 90, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Name:");
        p_brgyclearance.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 90, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Address:");
        p_brgyclearance.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 90, 20));

        txt_issued.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_brgyclearance.add(txt_issued, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 410, -1));

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_brgyclearance.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 410, -1));

        txt_address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_brgyclearance.add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 410, -1));

        cb_status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT YOUR STATUS--", "Single", "Married" }));
        p_brgyclearance.add(cb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 410, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Purok:");
        p_brgyclearance.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 90, 20));

        txt_rescer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_brgyclearance.add(txt_rescer, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 410, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Res. Cer. No.:");
        p_brgyclearance.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Place of Issue:");
        p_brgyclearance.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 90, 20));

        txt_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_brgyclearance.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 410, -1));

        bt_preview.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_preview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Show Property_20px.png"))); // NOI18N
        bt_preview.setText("PREVIEW");
        bt_preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_previewActionPerformed(evt);
            }
        });
        p_brgyclearance.add(bt_preview, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 120, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Date of Issue:");
        p_brgyclearance.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 90, 20));

        cb_purok.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_purok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT YOUR PORUK--", "1", "2", "3", "4", "5", "6", "7" }));
        p_brgyclearance.add(cb_purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 410, -1));

        txt_place.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_brgyclearance.add(txt_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 410, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Civil Status:");
        p_brgyclearance.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 90, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Married To:");
        p_brgyclearance.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 90, 20));

        txt_purpose.setColumns(20);
        txt_purpose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_purpose.setRows(5);
        jScrollPane1.setViewportView(txt_purpose);

        p_brgyclearance.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 410, 90));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Purpose:");
        p_brgyclearance.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 90, 20));

        txt_married.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_brgyclearance.add(txt_married, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 410, -1));

        jTabbedPane1.addTab("Barangay Clearance", new javax.swing.ImageIcon(getClass().getResource("/Misc/Word_30px.png")), p_brgyclearance); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blank", "Certificate of Residency", "Death Certificate", "PHIL HEALTH", "SSS Certification", "Certificate of Indigency" }));
        cb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_typeActionPerformed(evt);
            }
        });
        jPanel1.add(cb_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 550, -1));

        txt_bodyletter.setColumns(20);
        txt_bodyletter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_bodyletter.setRows(5);
        jScrollPane11.setViewportView(txt_bodyletter);

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 550, 400));

        bt_view.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Show Property_20px.png"))); // NOI18N
        bt_view.setText("PREVIEW");
        bt_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_viewActionPerformed(evt);
            }
        });
        jPanel1.add(bt_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 120, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Certification Template:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Body of the letter:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, 20));

        jTabbedPane1.addTab("Certification", new javax.swing.ImageIcon(getClass().getResource("/Misc/Word_30px.png")), jPanel1); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Subject:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 60, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("From:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 60, 20));

        txt_to1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_to1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 490, -1));

        txt_to2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_to2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 490, -1));

        txt_subject.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 490, -1));

        txt_body.setColumns(20);
        txt_body.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_body.setRows(5);
        jScrollPane2.setViewportView(txt_body);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 550, 300));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Show Property_20px.png"))); // NOI18N
        jButton1.setText("PREVIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 120, -1));

        txt_to4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_to4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 490, -1));

        txt_to5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(txt_to5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 490, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("To:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 60, 20));

        jTabbedPane1.addTab("Appointment", new javax.swing.ImageIcon(getClass().getResource("/Misc/Word_30px.png")), jPanel2); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_purpose1.setColumns(20);
        txt_purpose1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_purpose1.setRows(5);
        jScrollPane3.setViewportView(txt_purpose1);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 820, 220));

        jScrollPane4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_purpose2.setColumns(20);
        txt_purpose2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_purpose2.setRows(5);
        jScrollPane4.setViewportView(txt_purpose2);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 820, 90));

        txt_purpose3.setColumns(20);
        txt_purpose3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_purpose3.setRows(5);
        jScrollPane5.setViewportView(txt_purpose3);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 820, 90));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Show Property_20px.png"))); // NOI18N
        jButton3.setText("PREVIEW");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 120, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("RESTORE SAMPLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 160, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("CLEAR ALL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, 100, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel20.setForeground(java.awt.Color.red);
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 280, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel21.setForeground(java.awt.Color.red);
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 350, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel22.setForeground(java.awt.Color.red);
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 350, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("RESOLUTION NO.:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, 20));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 60, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel24.setForeground(java.awt.Color.red);
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 320, 20));

        jTabbedPane1.addTab("Resolution", new javax.swing.ImageIcon(getClass().getResource("/Misc/Word_30px.png")), jPanel3); // NOI18N

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel15.setForeground(java.awt.Color.red);
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 370, 20));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 410, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 410, -1));

        jCalendar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });
        jPanel4.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 410, 180));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Subject:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 60, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Date:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 60, 20));

        cb_purok1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_purok1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT PORUK--", "1", "2", "3", "4", "5", "6", "7" }));
        jPanel4.add(cb_purok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 410, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Show Property_20px.png"))); // NOI18N
        jButton4.setText("PREVIEW");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 120, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Purok:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 60, 20));

        jTabbedPane1.addTab("Attendance Sheet", new javax.swing.ImageIcon(getClass().getResource("/Misc/Word_30px.png")), jPanel4); // NOI18N

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_wn4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(txt_wn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 240, -1));

        txt_role1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(txt_role1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 240, 20));

        txt_wn2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(txt_wn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 240, -1));

        txt_wn1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(txt_wn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 240, -1));

        txt_nym1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(txt_nym1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 240, -1));

        txt_role2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(txt_role2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 240, 20));

        txt_nym2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(txt_nym2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 240, -1));

        txt_kbody.setColumns(20);
        txt_kbody.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_kbody.setRows(5);
        jScrollPane6.setViewportView(txt_kbody);

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 650, 260));

        txt_wn3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(txt_wn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 240, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel26.setText("Ex: Tag-iya");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 240, 20));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empty Kasulatan", "Nagprenda", "Nag-arkila" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 330, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("---------------------------------------- Witnesses ----------------------------------------");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 540, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel27.setText("(Name)");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 50, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel28.setText("(Name)");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 50, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel29.setText("Ex: Giprendahan");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 240, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel31.setText("(Name)");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 50, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel32.setText("(Name)");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 50, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel33.setText("(Name)");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 50, 20));

        jLabel34.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel34.setText("(Name)");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 50, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Type of Kasulatan:");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 120, 20));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Misc/Show Property_20px.png"))); // NOI18N
        jButton6.setText("PREVIEW");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 120, 30));

        jTabbedPane1.addTab("Kasulatan", new javax.swing.ImageIcon(getClass().getResource("/Misc/Word_30px.png")), jPanel5); // NOI18N

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 990, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_previewActionPerformed
        // TODO add your handling code here:
        String query = "Select * from people";
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        String date = (String) sdf.format(txt_date.getDate());
        String status = (String) this.cb_status.getSelectedItem();
        try {
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\BrgyClearance.jrxml");
            String SQL = query;
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("captain", getOfficials("KPTN"));
            m.put("kagawad1", getOfficials("KGWD1"));
            m.put("kagawad2", getOfficials("KGWD2"));
            m.put("kagawad3", getOfficials("KGWD3"));
            m.put("kagawad4", getOfficials("KGWD4"));
            m.put("kagawad5", getOfficials("KGWD5"));
            m.put("kagawad6", getOfficials("KGWD6"));
            m.put("kagawad7", getOfficials("KGWD7"));
            m.put("secretary", getOfficer("SECR"));
            m.put("treasurer", getOfficer("TREA"));
            m.put("name", this.txt_name.getText());
            m.put("address", this.txt_address.getText());
            m.put("rescerno", this.txt_rescer.getText());
            m.put("issue", this.txt_issued.getText());
            m.put("married", this.txt_married.getText());
            m.put("leader", getPurokLeader(String.valueOf(cb_purok.getSelectedIndex())));
            m.put("purok", String.valueOf(cb_purok.getSelectedIndex()));
            m.put("date", date);
            m.put("status", status);
            m.put("place", this.txt_place.getText());
            m.put("purpose", "\t  " + this.txt_purpose.getText());
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_previewActionPerformed

    private void cb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_typeActionPerformed
        // TODO add your handling code here:
        switch (cb_type.getSelectedIndex()) {
            case 1:
                txt_bodyletter.setText("\tThis is to certify that the __________, is a bonafide resident of Purok __, Barangay Palili, Padada, Davao del Sur.\n\n\tThis is to certify further that he/she is  _________.\n\n\tThis certification is issued upon the verbal  request  for whatever legal purpose this may serve him/her best.\n\n\tIssued this __________ at Barangay Palili, Padada, Davao del Sur.");
                break;
            case 2:
                txt_bodyletter.setText("\tThis is to certify that the __________, is a bonafide resident of Purok __, Barangay Palili, Padada, Davao del Sur.\n\n\tThis is to certify further that he/she died __________.\n\n\tThis certification is issued upon the verbal request of __________ to apply for death certificate and to whatever legal purpose this may served his/her best.\n\n\tIssued this __________ at Barangay Palili, Padada, Davao del Sur.");
                break;
            case 3:
                txt_bodyletter.setText("\tThis is to certify that the __________, is a bonafide resident of Purok __, Barangay Palili, Padada, Davao del Sur.\n\n\tThis is to certify further that she is personally known to the undersigned as a member of Province Philhealth.\n\n\tThis certification is issued upon the request of the  above- mention named   for whatever legal purpose this may serve her best.\n\n\tIssued this __________ at Barangay Palili, Padada, Davao del Sur.");
                break;
            case 4:
                txt_bodyletter.setText("\tThis is to certify that the __________, is a bonafide resident of Purok __, Barangay Palili, Padada, Davao del Sur.\n\n\tThis is to certify further that the said person has no income due to old age ___________.\n\n\tThis certification is issued upon the request of the above-named person in connection with his desire to apply for retirement with the Social Security System (SSS) and/or for whatever legal purpose this may serve him best.\n\n\tIssued this __________ at Barangay Palili, Padada, Davao del Sur.");
                break;
            case 5:
                txt_bodyletter.setText("\tThis is to certify that  __________,  of legal age,  Filipino Citizen, and a resident of Purok __, Barangay Palili, Padada, Davao del Sur, belongs to the low/marginal income taxpayer in the community where he resides.\n\n\tThis is to certify further that he is considered as indigent due to his irregular source of income.\n\n\tThis certification is being  issued upon the request of the  above-named  person in connection with his desire to apply for __________, and for whatever legal purpose this may serve him best.\n\n\tIssued this __________ at Barangay Palili, Padada, Davao del Sur.");
                break;
            default:
                txt_bodyletter.setText("");
                break;
        }
    }//GEN-LAST:event_cb_typeActionPerformed

    private void bt_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_viewActionPerformed
        // TODO add your handling code here:
        String query = "Select * from people";
        try {
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\Certification.jrxml");
            String SQL = query;
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("bodyletter", txt_bodyletter.getText());
            m.put("captain", getOfficials("KPTN"));
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_viewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String query = "Select * from people";
        try {
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\Appointment.jrxml");
            String SQL = query;
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("name", txt_to1.getText());
            m.put("place", txt_to2.getText());
            m.put("name2", txt_to4.getText());
            m.put("place2", txt_to5.getText());
            m.put("subject", txt_subject.getText());
            m.put("bodyletter", txt_body.getText());
            m.put("captain", getOfficials("KPTN"));
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        jTextField1.setText((String) sdf.format(jCalendar1.getDate()));
    }//GEN-LAST:event_jCalendar1PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTextField2.getText().isEmpty()){
            jLabel15.setText("*Subject is required");
        } else if (cb_purok1.getSelectedIndex()==0){
            jLabel15.setText("*Purok is required");
        } else {
        try {
            String query = "Select * from people where prk = " + String.valueOf(cb_purok1.getSelectedIndex());
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\AttendanceSheet.jrxml");
            String SQL = query;
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("subject", jTextField2.getText());
            m.put("prk", String.valueOf(cb_purok1.getSelectedIndex()));
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (txt_purpose2.getText().isEmpty()){
            jLabel21.setText("*This field must not empty");
        } else if (txt_purpose3.getText().isEmpty()){
            jLabel22.setText("*This field must not empty");
        } else if (txt_purpose1.getText().isEmpty()){
            jLabel20.setText("*This field must not empty");
        } else if (jTextField3.getText().isEmpty()){
            jLabel24.setText("*Resolution no is required");
        } else {
        try {
            String query = "Select * from people";
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\Resolution.jrxml");
            String SQL = query;
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("author", txt_purpose2.getText());
            m.put("head", txt_purpose3.getText());
            m.put("rn", jTextField3.getText());
            m.put("body", txt_purpose1.getText());
            m.put("captain", getOfficials("KPTN"));
            m.put("secr", getOfficials("SECR"));
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        RSC();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RSF();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            String query = "Select * from people";
            JasperReport JR;
            JasperPrint JP;
            DBConnection.init();
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\data\\\\reports\\\\Kasulatan.jrxml");
            String SQL = query;
            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);
            HashMap m = new HashMap<>();
            m.put("body", txt_kbody.getText());
            m.put("captain", getOfficials("KPTN"));
            m.put("secr", getOfficials("SECR"));
            m.put("n1", txt_nym1.getText());
            m.put("n2", txt_nym2.getText());
            m.put("p1", txt_role1.getText());
            m.put("p2", txt_role2.getText());
            m.put("w1", txt_wn1.getText());
            m.put("w2", txt_wn2.getText());
            m.put("w3", txt_wn3.getText());
            m.put("w4", txt_wn4.getText());
            JP = JasperFillManager.fillReport(JR, m, this.a.OpenDatabaseConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        switch (jComboBox1.getSelectedIndex()) {
            case 1:
                txt_kbody.setText("Alang sa Hingtungdan:\n\n\tKining maong kasulatan, nagpamatuod nga kami midangop sa Buhatan sa Barangay Kapitan aron sa pagpahimo ug kasulatan, ug kining maong kasulatan nagpamatuod nga kami nagkauyon nga;\n\n\tAko si _________, nagpa-arkila ug yuta nga iyang gipanag-iyahan sa _____________, ngadto kang ___________ nga taga _______________ nga adunay gidak-on nga ____________ \n\n\tNga ang maong arkila nagsugod atong ___________ hangtud _____________.\n\n\tKaning kasulatan gihimo niining ika-" + day.format(new Date()) + ", bulan sa " + month.format(new Date()) + ", tuig " + year.format(new Date()) + ", sa Barangay Palili, Padada, Davao del Sur.");
                txt_nym1.setText("");
                txt_nym2.setText("");
                txt_role1.setText("Tag-iya/Namirenda");
                txt_role2.setText("Giprendahan");
                txt_wn1.setText("");
                txt_wn2.setText("");
                txt_wn3.setText("");
                txt_wn4.setText("");
                break;
            case 2:
                txt_kbody.setText("Alang sa Hingtungdan:\n\n\tKining maong kasulatan, nagpamatuod nga kami midangop sa Buhatan sa Barangay Kapitan aron sa pagpahimo ug kasulatan, ug kining maong kasulatan nagpamatuod nga kami nagkauyon nga;\n\n\tAko si _________, nagpa-arkila ug yuta nga iyang gipanag-iyahan sa _____________, ngadto kang ___________ nga taga _______________ nga adunay gidak-on nga ____________ \n\n\tNga ang maong arkila nagsugod atong ___________ hangtud _____________.\n\n\tKaning kasulatan gihimo niining ika-" + day.format(new Date()) + ", bulan sa " + month.format(new Date()) + ", tuig " + year.format(new Date()) + ", sa Barangay Palili, Padada, Davao del Sur.");
                txt_nym1.setText("");
                txt_nym2.setText("");
                txt_role1.setText("Tag-iya/Nagpa-arkila");
                txt_role2.setText("Nag-arkila sa yuta");
                txt_wn1.setText("");
                txt_wn2.setText("");
                txt_wn3.setText("");
                txt_wn4.setText("");
                break;
            default:
                txt_kbody.setText("");
                txt_nym1.setText("");
                txt_nym2.setText("");
                txt_role1.setText("");
                txt_role2.setText("");
                txt_wn1.setText("");
                txt_wn2.setText("");
                txt_wn3.setText("");
                txt_wn4.setText("");
                break;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_preview;
    private javax.swing.JButton bt_view;
    private javax.swing.JComboBox<String> cb_purok;
    private javax.swing.JComboBox<String> cb_purok1;
    private javax.swing.JComboBox<String> cb_status;
    private javax.swing.JComboBox<String> cb_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel p_brgyclearance;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextArea txt_body;
    private javax.swing.JTextArea txt_bodyletter;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_issued;
    private javax.swing.JTextArea txt_kbody;
    private javax.swing.JTextField txt_married;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nym1;
    private javax.swing.JTextField txt_nym2;
    private javax.swing.JTextField txt_place;
    private javax.swing.JTextArea txt_purpose;
    private javax.swing.JTextArea txt_purpose1;
    private javax.swing.JTextArea txt_purpose2;
    private javax.swing.JTextArea txt_purpose3;
    private javax.swing.JTextField txt_rescer;
    private javax.swing.JTextField txt_role1;
    private javax.swing.JTextField txt_role2;
    private javax.swing.JTextField txt_subject;
    private javax.swing.JTextField txt_to1;
    private javax.swing.JTextField txt_to2;
    private javax.swing.JTextField txt_to4;
    private javax.swing.JTextField txt_to5;
    private javax.swing.JTextField txt_wn1;
    private javax.swing.JTextField txt_wn2;
    private javax.swing.JTextField txt_wn3;
    private javax.swing.JTextField txt_wn4;
    // End of variables declaration//GEN-END:variables
}
