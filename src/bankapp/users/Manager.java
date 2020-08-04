/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp.users;

import bankapp.bankDb.DBConnect;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Manager extends Cashier{

    DBConnect db = new DBConnect();
      public boolean addCashier(String nic, String firstName, String lastName, String contactNumber, String role, String userName, String password) throws SQLException {
      boolean success= db.addUser(nic, firstName, lastName, contactNumber,  role, userName,  password);
      return success;
    }
}
