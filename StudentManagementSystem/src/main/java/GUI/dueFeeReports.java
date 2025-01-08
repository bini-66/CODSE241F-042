/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.mycompany.studentmanagementsystem.DBcon;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author binit
 */
public class dueFeeReports extends javax.swing.JFrame {

    /**
     * Creates new form dueFeeReports
     */
    public dueFeeReports() {
        initComponents();
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_black.png")));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CBmnth = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtadm = new javax.swing.JTextField();
        btnadm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("View by Month");

        CBmnth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jButton1.setText("View Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        btnback.setBackground(new java.awt.Color(242, 242, 242));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jLabel2.setText("View by admission_no");

        btnadm.setText("View Report");
        btnadm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBmnth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtadm, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnadm)
                .addGap(257, 257, 257))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(CBmnth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel2)
                            .addComponent(txtadm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnadm))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           try{
             DBcon db = DBcon.getInstance();
            Connection con = db.getConnection();
           
            JasperReport jr = null;
          
             InputStream reportStream = getClass().getClassLoader().getResourceAsStream("reports/DUE_FEES_MONTHLY.jrxml");

            if (reportStream != null) {
              jr = JasperCompileManager.compileReport(reportStream);
                System.out.println("Report compiled successfully!");
            } else {
                System.out.println("Error: Resource 'reports/DUE_FEES_MONTHLY.jrxml' not found!");
            }

                //JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\binit\\JaspersoftWorkspace\\MyReports\\DUE_FEES_MONTHLY.jrxml");
                
                Map<String, Object> parameters = new HashMap<>();
                
                 if(CBmnth.getSelectedItem().toString().equals("January")){
                 parameters.put("MONTH", "JANUARY"); // Pass the month parameter
                 }
                 else  if(CBmnth.getSelectedItem().toString().equals("February")){
                 parameters.put("MONTH", "FEBRUARY"); // Pass the month parameter
                 }
                 else if(CBmnth.getSelectedItem().toString().equals("March")){
                 parameters.put("MONTH", "MARCH"); // Pass the month parameter
                 }
                  else if(CBmnth.getSelectedItem().toString().equals("April")){
                 parameters.put("MONTH", "APRIL"); // Pass the month parameter
                 }
                 else if(CBmnth.getSelectedItem().toString().equals("May")){
                 parameters.put("MONTH", "MAY"); // Pass the month parameter
                 }
                  else if(CBmnth.getSelectedItem().toString().equals("June")){
                 parameters.put("MONTH", "JUNE"); // Pass the month parameter
                 }
                else if(CBmnth.getSelectedItem().toString().equals("July")){
                 parameters.put("MONTH", "JULY"); // Pass the month parameter
                 }
                  else if(CBmnth.getSelectedItem().toString().equals("August")){
                 parameters.put("MONTH", "AUGUST"); // Pass the month parameter
                 }
                  else if(CBmnth.getSelectedItem().toString().equals("September")){
                 parameters.put("MONTH", "SEPTEMBER"); // Pass the month parameter
                 }
                  else if(CBmnth.getSelectedItem().toString().equals("October")){
                 parameters.put("MONTH", "OCTOBER"); // Pass the month parameter
                 }
                  else if(CBmnth.getSelectedItem().toString().equals("November")){
                 parameters.put("MONTH", "NOVEMBER"); // Pass the month parameter
                 }
                 else if(CBmnth.getSelectedItem().toString().equals("December")){
                 parameters.put("MONTH", "DECEMBER"); // Pass the month parameter
                 }
                 
                //displayng reports
            
                JasperPrint jp = JasperFillManager.fillReport(jr, parameters,con);
                //JasperViewer.viewReport(jp,false);
                 JRViewer viewer=new JRViewer(jp);
                 viewer.setPreferredSize(new java.awt.Dimension(800, 800)); // Set width and height
                 jPanel1.removeAll();
                 jPanel1.setLayout(new BorderLayout());
                 jPanel1.add(viewer, BorderLayout.NORTH);
                 jPanel1.revalidate();
                 jPanel1.repaint();
                
//
//           
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        reportViewer rep=new reportViewer();
        rep.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnadmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadmActionPerformed
        try{
              if(txtadm.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Enter an admission no", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
              }
           int admission_no=Integer.parseInt(txtadm.getText());
           
          
           
           DBcon db = DBcon.getInstance();
            Connection con = db.getConnection();
           
            PreparedStatement prestat1=con.prepareStatement("SELECT COUNT(*) FROM student WHERE admission_no=?");
            prestat1.setInt(1, admission_no);
            ResultSet rs=prestat1.executeQuery();
            
            if(rs.next()){
                 int count=rs.getInt(1);
                
                  if (count > 0) {
                
                //JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\binit\\JaspersoftWorkspace\\MyReports\\due_students.jrxml");
                
                JasperReport jr = null;
          
             InputStream reportStream = getClass().getClassLoader().getResourceAsStream("reports/due_students.jrxml");

            if (reportStream != null) {
              jr = JasperCompileManager.compileReport(reportStream);
                System.out.println("Report compiled successfully!");
            } else {
                System.out.println("Error: Resource 'reports/due_students.jrxml' not found!");
            }


                
                Map<String, Object> parameters = new HashMap<>();
                
                 
                 parameters.put("admission", admission_no); 
                 
                //displayng reports
            
                JasperPrint jp = JasperFillManager.fillReport(jr, parameters,con);
                //JasperViewer.viewReport(jp,false);
                 JRViewer viewer=new JRViewer(jp);
                 viewer.setPreferredSize(new java.awt.Dimension(800, 800)); // Set width and height
                 jPanel1.removeAll();
                 jPanel1.setLayout(new BorderLayout());
                 jPanel1.add(viewer, BorderLayout.NORTH);
                 jPanel1.revalidate();
                 jPanel1.repaint();  
          
                       
                 
            }
            else{
                 // Admission number does not exist
                        JOptionPane.showMessageDialog(null, "Admission number does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
            }
            }
               
                 
        }     
             catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

    }//GEN-LAST:event_btnadmActionPerformed

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
            java.util.logging.Logger.getLogger(dueFeeReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dueFeeReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dueFeeReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dueFeeReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dueFeeReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBmnth;
    private javax.swing.JButton btnadm;
    private javax.swing.JButton btnback;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtadm;
    // End of variables declaration//GEN-END:variables
}
