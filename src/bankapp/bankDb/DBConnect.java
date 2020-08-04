/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp.bankDb;

import bankapp.accounts.Account;
import bankapp.accounts.AccountType;
import bankapp.accounts.CheckingsAccount;
import bankapp.accounts.SavingsAccount;
import bankapp.users.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnect {
    public static Connection dbConnect() throws ClassNotFoundException{
     String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
     String DB_URL = "jdbc:mysql://localhost:3306/bankapp?autoReconnect=true&useSSL=false ";
     String DB_USERNAME = "root";
     String DB_PASSWORD = "root";
     Connection conn = null;
     
       try {
           Class.forName(DB_DRIVER);
           conn=DriverManager.getConnection(DB_URL,DB_USERNAME, DB_PASSWORD);
           
       } catch (SQLException ex) {
           System.out.println(ex);
       }
       
      return conn; 
    
    }

    public void addAccount(String firstName, String lastName, String nic, String contactNumber, String street, String town, AccountType accountType, double initialDeposit) throws ClassNotFoundException, SQLException {
       Connection conn = dbConnect();
       int customerId = 0; 
       int accountId =0;
        //Add Customer
        System.out.println("dbConnection");
        try (PreparedStatement addCustomer = conn.prepareStatement("INSERT INTO customer"
                  + "(FirstName, LastName, NIC, ContactNumber,Street,Town)"
                  + " VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS))
        {
            addCustomer.setString(1, firstName);
            addCustomer.setString(2, lastName);
            addCustomer.setString(3, nic);
            addCustomer.setString(4, contactNumber);
            addCustomer.setString(5, street);
            addCustomer.setString(6, town);
            addCustomer.executeUpdate();
            System.out.println(Statement.RETURN_GENERATED_KEYS);
            ResultSet addCustomerResults = addCustomer.getGeneratedKeys();
            if (addCustomerResults.next()){
                customerId = addCustomerResults.getInt(1);
            }
        }
        
        //Add Account
        try (PreparedStatement addAccount = conn.prepareStatement("INSERT INTO account(AccountType, Balance) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
            addAccount.setString(1, accountType.name());
            addAccount.setDouble(2, initialDeposit);
            addAccount.executeUpdate();
            ResultSet addAccountResults = addAccount.getGeneratedKeys();
            if (addAccountResults.next()) {
                accountId = addAccountResults.getInt(1);
            }
        }
        //map customer and account
        if (customerId > 0 && accountId > 0) {
            try (PreparedStatement linkAccount = conn.prepareStatement("INSERT INTO Mappings(CustomerId, AccountId) VALUES(?,?)")) {
                    linkAccount.setInt(1, customerId);
                    linkAccount.setInt(2, accountId);
                    linkAccount.executeUpdate();
            }
        } 
        else{
            conn.rollback();
        }
            //Disconnect
        conn.close();
    }

    public double getBalance(int accountNo) throws ClassNotFoundException {
        Connection conn = dbConnect();
        Double balance = null;
        try (PreparedStatement getBalance = conn.prepareStatement(
            "SELECT Balance FROM account WHERE AccountId = ?")) {
            getBalance.setInt(1, accountNo);
            ResultSet findUserResults = getBalance.executeQuery();
            if(findUserResults.next()){
            balance = findUserResults.getDouble("Balance");
                System.out.println("Balance :"+balance);
            conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }

    public void updateBalance(int accountNo, double balance) throws ClassNotFoundException {
       Connection conn = dbConnect(); 
       try (PreparedStatement updateBalance = conn.prepareStatement(
            "UPDATE account SET Balance = ? WHERE AccountId = ?")) {
                updateBalance.setDouble(1, balance);
                updateBalance.setInt(2, accountNo);
                updateBalance.executeUpdate();
                conn.close();
            } catch (SQLException ex) {
            System.err.println("An error has occured." + ex.getMessage());
        }
}

    public boolean addUser(String nic, String firstName, String lastName, String contactNumber, String role, String userName, String password) throws SQLException {
        Connection conn = null;
        boolean success= false;
        System.out.println(password);
        try {
            conn = dbConnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Add Customer
        System.out.println("dbConnection");
        try (PreparedStatement addUser = conn.prepareStatement("INSERT INTO users "
                  + "(NIC, FirstName, LastName, ContactNumber,Role, UserName,Password)"
                  + " VALUES(?,?,?,?,?,?,?)"))
        {   addUser.setString(1, nic);
            addUser.setString(2, firstName);
            addUser.setString(3, lastName);
            addUser.setString(4, contactNumber);
            addUser.setString(5, role);
            addUser.setString(6, userName);
            addUser.setString(7, password);
            System.out.println("Cashier Added");
            addUser.executeUpdate();
            conn.close();
            success = true;
            
        }
        catch(Exception e){
            System.err.println(e);
        
        }
        return(success);
    }

    public ArrayList<Customer> getAllCustomers() throws ClassNotFoundException {
        Connection conn = null;
        try {
            conn = dbConnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Customer> customerList = new ArrayList();
        try (PreparedStatement getAllCustomers = conn.prepareStatement(
                    "SELECT *"
                    + "FROM customer a JOIN mappings b on a.CustomerId = b.CustomerId "
                    + "JOIN account c on b.AccountId = c.AccountId")) {
                ResultSet rs = getAllCustomers.executeQuery();
                while (rs.next()) {
                    int CustomerId = rs.getInt("CustomerId");
                    System.out.println(CustomerId);
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String nic = rs.getString("NIC");
                    String contactNumber = rs.getString("ContactNumber");
                    String street = rs.getString("Street");
                    String town = rs.getString("Town");
                    int accountId = rs.getInt("AccountId");
                    String accountType = rs.getString("AccountType");
                    Double balance = rs.getDouble("Balance");
                    Account account;
                    System.out.println(balance);
                    if (accountType.equals(AccountType.checkings.name())) {
                        account = new CheckingsAccount(accountId, balance);
                    } else {
                        account = new SavingsAccount(accountId, balance);
                    }
                    System.out.println(account);
                    Customer customer = new Customer(CustomerId,firstName,lastName,nic,contactNumber,street,town,account);
                    customerList.add(customer);
                }
            }
        catch (SQLException ex) {
        Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }
}