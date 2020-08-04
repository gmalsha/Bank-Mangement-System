/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp.users;

import bankapp.accounts.Account;

/**
 *
 * @author Prabamina
 */
   public class Customer {
       
   private final int customerId;
   private final String firstName;
   private final String lastName;
   private final String nic;
   private final String contactNumber;
   private final String street;
   private final String town;

 
   private final Account account;
   
   public Customer(int customerId, String firstName, String lastName, String nic, String contactNumber, String street,String Town, Account account) {
   this.customerId = customerId;
   this.firstName =  firstName;
   this.lastName = lastName;
   this.nic = nic;
   this.contactNumber = contactNumber;
   this.street = street;
   this.town = Town;
   this.account = account;
   }

    public Customer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Account getAccount() {
        return account;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNic() {
        return nic;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }
    

}
