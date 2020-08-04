/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp.accounts;

/**
 *
 * @author User
 */
public class CheckingsAccount extends Account {
    


    public CheckingsAccount(int accountId, Double balance) {
        super(accountId,balance);
       
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.checkings;
    }
    
    
}
