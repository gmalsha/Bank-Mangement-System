/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp.views;


import bankapp.accounts.AccountType;
import bankapp.accounts.Bank;
import javax.swing.JOptionPane;



public class AddAccountView extends javax.swing.JFrame {
private Bank bank;
 
        AddAccountView(Bank bank) {
        initComponents();
        setLocationRelativeTo(null);
        this.bank = bank;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nicField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        contactNumberField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        townField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        accountTypeField = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        initialDepositField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add New Account");
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridLayout(9, 2, 5, 5));

        jLabel1.setText("         First Name");
        getContentPane().add(jLabel1);

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(firstNameField);

        jLabel2.setText("        Last name");
        getContentPane().add(jLabel2);

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(lastNameField);

        jLabel3.setText("         NIC");
        getContentPane().add(jLabel3);
        getContentPane().add(nicField);

        jLabel4.setText("        Contact Number");
        getContentPane().add(jLabel4);
        getContentPane().add(contactNumberField);

        jLabel5.setText("        Street");
        getContentPane().add(jLabel5);
        getContentPane().add(streetField);

        jLabel6.setText("       Town");
        getContentPane().add(jLabel6);
        getContentPane().add(townField);

        jLabel7.setText("       Account Type");
        getContentPane().add(jLabel7);

        accountTypeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "savings", "checkings" }));
        accountTypeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountTypeFieldActionPerformed(evt);
            }
        });
        getContentPane().add(accountTypeField);

        jLabel8.setText("       Initial Deposit");
        getContentPane().add(jLabel8);
        getContentPane().add(initialDepositField);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void accountTypeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountTypeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountTypeFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
        
    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        StringBuilder warnings = new StringBuilder();
        String firstName = "", lastName = "", contactNumber = "", nic = "",street = "",town = "";
        double initialDeposit = 0;
        
        if (firstNameField.getText().isEmpty()) {
            warnings.append("First name must not be empty.\n");
        } else {
            firstName = firstNameField.getText();
        }
        
        if (lastNameField.getText().isEmpty()) {
            warnings.append("First name must not be empty.\n");
        } else {
            lastName = lastNameField.getText();
        }
       
        if (contactNumberField.getText().matches("(0/91)?[7-9][0-9]{9}")) {
            warnings.append("First name must not be empty.\n");
        } else {
            contactNumber = contactNumberField.getText();
        }  
        
        if (nicField.getText().isEmpty()) {
            warnings.append("First name must not be empty.\n");
        } else {
            contactNumber = nicField.getText();
        }  
            
        if (streetField.getText().isEmpty()) {
            warnings.append("First name must not be empty.\n");
        } else {
            contactNumber = streetField.getText();
        }  
              
        if (townField.getText().isEmpty()) {
            warnings.append("First name must not be empty.\n");
        } else {
            contactNumber = townField.getText();
        }  
            
        if (initialDepositField.getText().isEmpty()) {
            warnings.append("Initial deposit must be entered.");
        } else {
            try {
                initialDeposit = Double.parseDouble(initialDepositField.getText());
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }
        }
        if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Input Warnings", JOptionPane.WARNING_MESSAGE);
        } 
        else {
                    AccountType accountType = AccountType.Undefined;
            if ("checkings".equals(accountTypeField.getSelectedItem().toString())) {
                if (initialDeposit >= 100) {
                    accountType = AccountType.checkings;
                    System.out.println("Checkings");
                } 
            } else if ("savings".equals(accountTypeField.getSelectedItem().toString())) {
                if (initialDeposit >= 50) {
                    System.out.println("Savings");
                    accountType = AccountType.savings;
                } 
            }
            if (accountType != AccountType.Undefined) {
                try {
                    bank.openAccount(firstName, lastName,nic,  contactNumber, street , town, accountType, initialDeposit); 
                    System.out.println("Opend the account");
                    JOptionPane.showMessageDialog(this, "Congratulations! Account Created Successfuly");
                    this.dispose();
                } catch (Exception e) {
                System.out.println("Error");
                }
                
            } 
        
        }

        
    }//GEN-LAST:event_okButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountTypeField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField contactNumberField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField initialDepositField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField nicField;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField streetField;
    private javax.swing.JTextField townField;
    // End of variables declaration//GEN-END:variables
}
