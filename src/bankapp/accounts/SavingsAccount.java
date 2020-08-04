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
public class SavingsAccount extends Account {
    
  

    public SavingsAccount(int accountNumber, double initialDeposit) {
        super(accountNumber,initialDeposit);
       
    }



    @Override
    public AccountType getAccountType() {
        return AccountType.savings;
    }
    
    
}
