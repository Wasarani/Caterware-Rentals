/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.DbConnection;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author r m s rathnayake
 */
public class Return extends javax.swing.JFrame {

    
    /**
     * Creates new form Return
     */
    public Return() {
        initComponents();
        findrentID();
        
    }

 private void displayBillDetails() {
    String billID = (String) rentIDCom.getSelectedItem();

    try (Connection connection = DbConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BillMain WHERE BillID = ?");
         PreparedStatement billSubStatement = connection.prepareStatement("SELECT * FROM BillSub WHERE BillID = ?")) {

        preparedStatement.setString(1, billID);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                rentDateChooser.setDate(resultSet.getDate("rentdate"));
                ReturnDateChooser.setDate(resultSet.getDate("returnDate"));
                customerFeild.setText(resultSet.getString("CustomerID"));
                txtItemTotal.setText(resultSet.getString("Total"));
            }
        }

        billSubStatement.setString(1, billID);

        try (ResultSet billSubResultSet = billSubStatement.executeQuery()) {
            DefaultTableModel tableModel = (DefaultTableModel) billList.getModel();

            // Clear existing rows in the table
            tableModel.setRowCount(0);

            while (billSubResultSet.next()) {
                String billSubID = billSubResultSet.getString("BillSubID");
                String itemID = billSubResultSet.getString("ItemID");
                String quantity = billSubResultSet.getString("Quantity");
                String itemTotal = billSubResultSet.getString("ItemTotal");

                // Add a new row to the model
                tableModel.addRow(new Object[]{billSubID, itemID, quantity, itemTotal});
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void insertBillDetailsToHistory() {
    String billID = (String) rentIDCom.getSelectedItem();
    String fine = txtFine.getText();
    String subtotal = txtFTotal.getText();
    int confirmDialogResult = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to move the data to history tables?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION);

    if (confirmDialogResult == JOptionPane.YES_OPTION) {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement insertBillMainHisStatement = connection.prepareStatement(
                     "INSERT INTO BillMainHis (rentdate, returnDate, CustomerID, Total, Fine, TotalAmount) " +
                             "SELECT rentdate, returnDate, CustomerID, Total, ?, ? FROM BillMain WHERE BillID = ?");
             PreparedStatement insertBillSubHisStatement = connection.prepareStatement(
                     "INSERT INTO BillSubHis (BillID, ItemID, Quantity, ItemTotal) " +
                             "SELECT BillID, ItemID, Quantity, ItemTotal FROM BillSub WHERE BillID = ?");
             PreparedStatement deleteBillMainStatement = connection.prepareStatement("DELETE FROM BillMain WHERE BillID = '" + billID + "'");
             PreparedStatement deleteBillSubStatement = connection.prepareStatement("DELETE FROM BillSub WHERE BillID = '" + billID + "'")) {

            connection.setAutoCommit(false);

            // Insert into BillMainHis
            insertBillMainHisStatement.setBigDecimal(1, new BigDecimal(fine));
            insertBillMainHisStatement.setBigDecimal(2, new BigDecimal(subtotal));
            insertBillMainHisStatement.setString(3, billID);
            insertBillMainHisStatement.executeUpdate();

            // Insert into BillSubHis
            insertBillSubHisStatement.setString(1, billID);
            insertBillSubHisStatement.executeUpdate();

            // Delete from BillMain
            deleteBillMainStatement.executeUpdate();

            // Delete from BillSub
            deleteBillSubStatement.executeUpdate();

            connection.commit();

            // Success message
            JOptionPane.showMessageDialog(null, "Data successfully moved to history tables.", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Clear input fields
            rentDateChooser.setDate(null);
            ReturnDateChooser.setDate(null);
            customerFeild.setText("");
            txtItemTotal.setText("");
            txtFine.setText("");
            txtFTotal.setText("");

            // Clear table
            DefaultTableModel tableModel = (DefaultTableModel) billList.getModel();
            tableModel.setRowCount(0);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions and possibly rollback the transaction if needed
        }
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
        tab01 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tab02 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tab03 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tab04 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rentIDCom = new javax.swing.JComboBox<>();
        customerFeild = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtItemTotal = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billList = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        rentDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        ReturnDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        Fine = new javax.swing.JLabel();
        txtFine = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtFTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        tab01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab01MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab01MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tab01MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel9.setText("Items");

        javax.swing.GroupLayout tab01Layout = new javax.swing.GroupLayout(tab01);
        tab01.setLayout(tab01Layout);
        tab01Layout.setHorizontalGroup(
            tab01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab01Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab01Layout.setVerticalGroup(
            tab01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab01Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab02MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab02MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tab02MouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel10.setText("Customer");

        javax.swing.GroupLayout tab02Layout = new javax.swing.GroupLayout(tab02);
        tab02.setLayout(tab02Layout);
        tab02Layout.setHorizontalGroup(
            tab02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab02Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab02Layout.setVerticalGroup(
            tab02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab02Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tab03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab03MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab03MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tab03MouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel11.setText("Rent");

        javax.swing.GroupLayout tab03Layout = new javax.swing.GroupLayout(tab03);
        tab03.setLayout(tab03Layout);
        tab03Layout.setHorizontalGroup(
            tab03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab03Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab03Layout.setVerticalGroup(
            tab03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab03Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        tab04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab04MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tab04MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tab04MouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel12.setText("Reports");

        javax.swing.GroupLayout tab04Layout = new javax.swing.GroupLayout(tab04);
        tab04.setLayout(tab04Layout);
        tab04Layout.setHorizontalGroup(
            tab04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab04Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        tab04Layout.setVerticalGroup(
            tab04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab04Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tab01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(tab01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Return Items");

        jPanel3.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Rent  Id");

        rentIDCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        rentIDCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentIDComActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("item Total");

        btnReturn.setBackground(new java.awt.Color(0, 51, 255));
        btnReturn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setText("Rented Items");

        billList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Bill Sub Id", "Item Id", "Quantity", "item Total"
            }
        ));
        jScrollPane2.setViewportView(billList);

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setText("RentDate");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setText("Customer Id");

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel15.setText("Return Date");

        Fine.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Fine.setText("fine");

        txtFine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFineActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel16.setText("sub total");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentIDCom, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(customerFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReturnDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(263, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Fine, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFine, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtItemTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(136, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentIDCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReturnDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(rentDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(204, 204, 204)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(238, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rentIDComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentIDComActionPerformed
            displayBillDetails();        // TODO add your handling code here:
    }//GEN-LAST:event_rentIDComActionPerformed

    private void txtFineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFineActionPerformed
    Double itemTotal = Double.parseDouble(txtItemTotal.getText());
    Double fine = Double.parseDouble(txtFine.getText());
    Double subtotal = itemTotal + fine;
    txtFTotal.setText(String.valueOf(subtotal));
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFineActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        insertBillDetailsToHistory();        // TODO add your handling code here:
    }//GEN-LAST:event_btnReturnActionPerformed

    private void tab01MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab01MouseEntered

float[] hsbvals = new float[3];
        Color.RGBtoHSB(255,255,204, hsbvals);
        tab01.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));        // TODO add your handling code here:
    }//GEN-LAST:event_tab01MouseEntered

    private void tab01MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab01MouseExited
       
        float[] hsbvals = new float[3];
        Color.RGBtoHSB(242,242,242, hsbvals);
        tab01.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));
        // TODO add your handling code here:
    }//GEN-LAST:event_tab01MouseExited

    private void tab02MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab02MouseEntered
       
        float[] hsbvals = new float[3];
        Color.RGBtoHSB(255,255,204, hsbvals);
        tab02.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));
// TODO add your handling code here:
    }//GEN-LAST:event_tab02MouseEntered

    private void tab02MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab02MouseExited
       
        float[] hsbvals = new float[3];
        Color.RGBtoHSB(242,242,242, hsbvals);
        tab02.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));  // TODO add your handling code here:
    }//GEN-LAST:event_tab02MouseExited

    private void tab03MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab03MouseEntered
float[] hsbvals = new float[3];
        Color.RGBtoHSB(255,255,204, hsbvals);
        tab03.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));        
// TODO add your handling code here:
    }//GEN-LAST:event_tab03MouseEntered

    private void tab03MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab03MouseExited
       float[] hsbvals = new float[3];
        Color.RGBtoHSB(242,242,242, hsbvals);
        tab03.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));  
        // TODO add your handling code here:
    }//GEN-LAST:event_tab03MouseExited

    private void tab04MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab04MouseEntered
       
        float[] hsbvals = new float[3];
        Color.RGBtoHSB(255,255,204, hsbvals);
        tab04.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));// TODO add your handling code here:
    }//GEN-LAST:event_tab04MouseEntered

    private void tab04MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab04MouseExited
       float[] hsbvals = new float[3];
        Color.RGBtoHSB(242,242,242, hsbvals);
        tab04.setBackground(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));  
        // TODO add your handling code here:
    }//GEN-LAST:event_tab04MouseExited

    private void tab04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab04MouseClicked
dispose(); 
        Report newForm = new Report();

        // Set the behavior of the new form (e.g., default close operation)
        newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        newForm.pack();
        newForm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tab04MouseClicked

    private void tab01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab01MouseClicked
dispose(); 
        Items newForm = new Items();

        // Set the behavior of the new form (e.g., default close operation)
        newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        newForm.pack();
        newForm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tab01MouseClicked

    private void tab02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab02MouseClicked
dispose(); 
        Customer newForm = new Customer();

        // Set the behavior of the new form (e.g., default close operation)
        newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        newForm.pack();
        newForm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tab02MouseClicked

    private void tab03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab03MouseClicked
dispose(); 
        Rental newForm = new Rental();

        // Set the behavior of the new form (e.g., default close operation)
        newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        newForm.pack();
        newForm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tab03MouseClicked

           private void findrentID() {
        try {
           try( // Establish a database connection
            Connection connection = DbConnection.getConnection();) {
                String sql = "SELECT BillId FROM BillMain ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Create a DefaultComboBoxModel to store the car registration data
                DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

                // Iterate through the result set and add car registration values to the model
                while (resultSet.next()) {
                    String customerId = resultSet.getString("BillId");
                    comboBoxModel.addElement(customerId);
                }

                // Set the model with car registration data to the carCom JComboBox
                rentIDCom.setModel(comboBoxModel);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fine;
    private com.toedter.calendar.JDateChooser ReturnDateChooser;
    private javax.swing.JTable billList;
    private javax.swing.JButton btnReturn;
    private javax.swing.JTextField customerFeild;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser rentDateChooser;
    private javax.swing.JComboBox<String> rentIDCom;
    private javax.swing.JPanel tab01;
    private javax.swing.JPanel tab02;
    private javax.swing.JPanel tab03;
    private javax.swing.JPanel tab04;
    private javax.swing.JTextField txtFTotal;
    private javax.swing.JTextField txtFine;
    private javax.swing.JTextField txtItemTotal;
    // End of variables declaration//GEN-END:variables
}
