
package bankapp.accounts;

import bankapp.bankDb.DBConnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bank {

    /**
     *
     * @param firstName
     * @param lastName
     * @param nic
     * @param contactNumber
     * @param street
     * @param town
     * @param accountType
     * @param initialDeposit
     */
    
    DBConnect db = new DBConnect();
    public void openAccount(String firstName, String lastName, String nic,String contactNumber,  String street, String town, AccountType accountType, double initialDeposit) {
        try {
            db.addAccount(firstName,lastName,nic,contactNumber,street,town,accountType,initialDeposit);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public double getBalance(int accountNo) throws ClassNotFoundException {
        System.out.println(accountNo);
        return db.getBalance(accountNo);
    }

    public void updateBalance(int accountNo, double balance) throws ClassNotFoundException {
        db.updateBalance(accountNo,balance);
    }

//    public void addCashier(String nic, String firstName, String lastName, String contactNumber, String role, String userName, String password) throws SQLException {
//        db.addUser(nic, firstName, lastName, contactNumber,  role, userName,  password);
//    }

    
}