/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import Model.DbConnection;
import java.awt.Color;

/**
 *
 * @author r m s rathnayake
 */
public class Report extends javax.swing.JFrame {
      ReportJpanel jasperViewerFrame = new ReportJpanel();
    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
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
        tab05 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tab06 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tab07 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tab08 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        dateChooser1 = new com.toedter.calendar.JDateChooser();
        dateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        tab05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab05MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab05MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tab05MouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setText("Items");

        javax.swing.GroupLayout tab05Layout = new javax.swing.GroupLayout(tab05);
        tab05.setLayout(tab05Layout);
        tab05Layout.setHorizontalGroup(
            tab05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab05Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab05Layout.setVerticalGroup(
            tab05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab05Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab06MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab06MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tab06MouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel6.setText("Customer");

        javax.swing.GroupLayout tab06Layout = new javax.swing.GroupLayout(tab06);
        tab06.setLayout(tab06Layout);
        tab06Layout.setHorizontalGroup(
            tab06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab06Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        tab06Layout.setVerticalGroup(
            tab06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab06Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        tab07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab07MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab07MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tab07MouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setText("Rent");

        javax.swing.GroupLayout tab07Layout = new javax.swing.GroupLayout(tab07);
        tab07.setLayout(tab07Layout);
        tab07Layout.setHorizontalGroup(
            tab07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab07Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab07Layout.setVerticalGroup(
            tab07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab07Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        tab08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab08MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab08MouseEntered(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel5.setText("Return");

        javax.swing.GroupLayout tab08Layout = new javax.swing.GroupLayout(tab08);
        tab08.setLayout(tab08Layout);
        tab08Layout.setHorizontalGroup(
            tab08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab08Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab08Layout.setVerticalGroup(
            tab08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab08Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tab05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(tab05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Catering Item Rental System Reports");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("Catering Items Rent History");

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create a Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 200, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196)
                .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(dateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void generateReport() {

    Date selectedDate1 = new Date(dateChooser1.getDate().getTime());
    Date selectedDate2 = new Date(dateChooser2.getDate().getTime());

    try {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("returnDate1", selectedDate1);
        parameters.put("returnDate2", selectedDate2);

        // Clear and update the jasperViewerFrame
        jasperViewerFrame.getContentPane().removeAll();
        jasperViewerFrame.repaint();
        jasperViewerFrame.revalidate();

        // Your database connection setup
        Connection connection = DbConnection.getConnection();

        String sqlQuery = "SELECT\n" +
                "    BillMainHis.BillID,\n" +
                "    BillMainHis.rentdate,\n" +
                "    BillMainHis.returnDate,\n" +
                "    BillMainHis.CustomerID,\n" +
                "    BillMainHis.Total,\n" +
                "    BillMainHis.Fine,\n" +
                "    BillMainHis.TotalAmount,\n" +
                "    BillSubHis.BillSubID,\n" +
                "    BillSubHis.ItemID,\n" +
                "    BillSubHis.Quantity,\n" +
                "    BillSubHis.ItemTotal\n" +
                "FROM\n" +
                "    BillMainHis\n" +
                "LEFT JOIN\n" +
                "    BillSubHis ON BillMainHis.BillID = BillSubHis.BillID\n" +
                "WHERE\n" +
                "    BillMainHis.returnDate BETWEEN ? AND ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setDate(1, new java.sql.Date(selectedDate1.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(selectedDate2.getTime()));

            ResultSet resultSet = preparedStatement.executeQuery();

            JRDataSource dataSource = new JRResultSetDataSource(resultSet);

            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\r m s rathnayake\\Documents\\NetBeansProjects\\Caterware Rentals\\src\\View\\billReport.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, parameters, dataSource);

            // Assuming jasperViewerFrame is declared and accessible
            jasperViewerFrame.setLayout(new BorderLayout());
            JRViewer v = new JRViewer(jprint);
            jasperViewerFrame.add(v);

            // Set the properties of jasperViewerFrame as needed (title, size, etc.)
            jasperViewerFrame.setTitle("Attendance Report");
            jasperViewerFrame.setSize(800, 600);
            jasperViewerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jasperViewerFrame.setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace(); // Handle exceptions appropriately in your application
        }
    } catch (Exception ex) {
        ex.printStackTrace(); // Handle exceptions appropriately in your application
    }
}


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            generateReport();

    // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tab05MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab05MouseEntered
       float[] hsbvals = new float[3];
        Color.RGBtoHSB(255,255,204, hsbvals);
        tab05.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));
        // TODO add your handling code here:
    }//GEN-LAST:event_tab05MouseEntered

    private void tab05MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab05MouseExited
    float[] hsbvals = new float[3];
        Color.RGBtoHSB(242,242,242, hsbvals);
        tab05.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));
        // TODO add your handling code here:
    }//GEN-LAST:event_tab05MouseExited

    private void tab06MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab06MouseEntered
      float[] hsbvals = new float[3];
        Color.RGBtoHSB(255,255,204, hsbvals);
        tab06.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));
        // TODO add your handling code here:
    }//GEN-LAST:event_tab06MouseEntered

    private void tab06MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab06MouseExited
float[] hsbvals = new float[3];
        Color.RGBtoHSB(242,242,242, hsbvals);
        tab06.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));        
// TODO add your handling code here:
    }//GEN-LAST:event_tab06MouseExited

    private void tab07MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab07MouseEntered
float[] hsbvals = new float[3];
        Color.RGBtoHSB(255,255,204, hsbvals);
        tab07.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));        
// TODO add your handling code here:
    }//GEN-LAST:event_tab07MouseEntered

    private void tab07MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab07MouseExited
       float[] hsbvals = new float[3];
        Color.RGBtoHSB(242,242,242, hsbvals);
        tab07.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));
        // TODO add your handling code here:
    }//GEN-LAST:event_tab07MouseExited

    private void tab08MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab08MouseEntered
       float[] hsbvals = new float[3];
        Color.RGBtoHSB(255,255,204, hsbvals);
        tab08.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));
        // TODO add your handling code here:
    }//GEN-LAST:event_tab08MouseEntered

    private void tab05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab05MouseClicked
dispose(); 
        Items newForm = new Items();

        // Set the behavior of the new form (e.g., default close operation)
        newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        newForm.pack();
        newForm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tab05MouseClicked

    private void tab06MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab06MouseClicked
dispose(); 
        Customer newForm = new Customer();

        // Set the behavior of the new form (e.g., default close operation)
        newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        newForm.pack();
        newForm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tab06MouseClicked

    private void tab07MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab07MouseClicked
   dispose(); 
        Rental newForm = new Rental();

        // Set the behavior of the new form (e.g., default close operation)
        newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        newForm.pack();
        newForm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tab07MouseClicked

    private void tab08MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab08MouseClicked

dispose(); 
        Report newForm = new Report();

        // Set the behavior of the new form (e.g., default close operation)
        newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        newForm.pack();
        newForm.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_tab08MouseClicked

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser1;
    private com.toedter.calendar.JDateChooser dateChooser2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel tab05;
    private javax.swing.JPanel tab06;
    private javax.swing.JPanel tab07;
    private javax.swing.JPanel tab08;
    // End of variables declaration//GEN-END:variables
}
