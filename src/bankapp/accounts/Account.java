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
public abstract class Account {
    private int accNum;          
    private double balance;
    
    Account(int accNum,double initialDeposit ){
        this.accNum = accNum;
        this.balance = initialDeposit;
    }
    public abstract AccountType getAccountType();
    public int getAccNum() {
        return accNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
}
