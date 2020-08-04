/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp.views;

import bankapp.bankDb.DBConnect;
import bankapp.users.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Prabamina
 */
public class AccountView extends javax.swing.JFrame {

    /**
     * Creates new form AccountView
     */
    DBConnect sql = new DBConnect();
    
    
    public AccountView() {
        initComponents();
        try {
            displayAllCustomers();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Customer> getAllCustomers() throws ClassNotFoundException{
    ArrayList<Customer> customers = new ArrayList();
    customers = sql.getAllCustomers();
    return customers;
     }

    public void displayAllCustomers() throws ClassNotFoundException{
    DefaultTableModel  model = (DefaultTableModel) accountTable.getModel();
    ArrayList<Customer> customerlist =getAllCustomers();
    Object[] row = new Object[10];
    for(int i =0;i<customerlist.size();i++){
        row[0] = customerlist.get(i).getCustomerId();
        row[1] = customerlist.get(i).getFirstName();
        row[2] = customerlist.get(i).getLastName();
        row[3] = customerlist.get(i).getNic();
        row[4] = customerlist.get(i).getContactNumber();
        row[5] = customerlist.get(i).getStreet();
        row[6] = customerlist.get(i).getTown();
        row[7] = customerlist.get(i).getAccount().getAccNum();
        row[8] = customerlist.get(i).getAccount().getAccountType();
        row[9] = customerlist.get(i).getAccount().getBalance();
        model.addRow(row);
        System.out.println("Displayed");
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchItem = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Details");

        searchItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "NIC", "Account Type" }));
        searchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchItemActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "First Name", "Last name", "NIC", "Contact Number", "Street", "Town", "Account Id", "Account Type", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(accountTable);
        if (accountTable.getColumnModel().getColumnCount() > 0) {
            accountTable.getColumnModel().getColumn(0).setResizable(false);
            accountTable.getColumnModel().getColumn(1).setResizable(false);
            accountTable.getColumnModel().getColumn(2).setResizable(false);
            accountTable.getColumnModel().getColumn(3).setResizable(false);
            accountTable.getColumnModel().getColumn(4).setResizable(false);
            accountTable.getColumnModel().getColumn(5).setResizable(false);
            accountTable.getColumnModel().getColumn(6).setResizable(false);
            accountTable.getColumnModel().getColumn(7).setResizable(false);
            accountTable.getColumnModel().getColumn(8).setResizable(false);
            accountTable.getColumnModel().getColumn(9).setResizable(false);
        }

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchField)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchItemActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
    DBConnect  db= new DBConnect();
    Connection conn = null;  
        try {
            conn = db.dbConnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountView.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(searchItem.getSelectedItem().toString().equals("Name")){
             String sql = "SELECT a.CustomerId,FirstName,LastName, NIC, ContactNumber , Street, Town,c.AccountId, AccountType, Balance FROM customer a JOIN mappings b on a.CustomerId = b.CustomerId JOIN account c on b.AccountId = c.AccountId where FirstName = ?";
            try {
            PreparedStatement getAllCustomers = conn.prepareStatement(sql);
            getAllCustomers.setString(1, searchField.getText());
            ResultSet rs = getAllCustomers.executeQuery();
            accountTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
            Logger.getLogger(AccountView.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
         
            else if(searchItem.getSelectedItem().toString().equals("NIC")){
             String sql = "SELECT a.CustomerId,FirstName,LastName, NIC, ContactNumber , Street, Town,c.AccountId, AccountType, Balance FROM customer a JOIN mappings b on a.CustomerId = b.CustomerId JOIN account c on b.AccountId = c.AccountId where NIC = ?";
            try {
            PreparedStatement getAllCustomers = conn.prepareStatement(sql);
            getAllCustomers.setString(1, searchField.getText());
            ResultSet rs = getAllCustomers.executeQuery();
            accountTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
            Logger.getLogger(AccountView.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
                  
            else {
            String sql = "SELECT a.CustomerId,FirstName,LastName, NIC, ContactNumber , Street, Town,c.AccountId, AccountType, Balance FROM customer a JOIN mappings b on a.CustomerId = b.CustomerId JOIN account c on b.AccountId = c.AccountId where AccountType = ?";
            try {
            PreparedStatement getAllCustomers = conn.prepareStatement(sql);
            getAllCustomers.setString(1, searchField.getText());
            ResultSet rs = getAllCustomers.executeQuery();
            accountTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
            Logger.getLogger(AccountView.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
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
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchItem;
    // End of variables declaration//GEN-END:variables
}
