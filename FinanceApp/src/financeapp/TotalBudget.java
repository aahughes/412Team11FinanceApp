/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package financeapp;

/**
 *
 * @author mhilaire
 */
public class TotalBudget {
    private double amount;
    private double balance;
    private double budgetAlert;
    
    public TotalBudget (double newAmount, double newBalance, double newAlert) {
        this.amount = newAmount;
        this.balance = newBalance;
        this.budgetAlert = newAlert;
    }
    
    
    public void setBalance(double newBalance){
        balance = newBalance;
    }
    public double getBalance(){
        return balance;
    }
    
    public double getAlert(){
        return budgetAlert;
    }
    
    public void setAlert(double newAlert){
        budgetAlert = newAlert;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public void setAmount(double newAmount){
        amount = newAmount;
    }
    
}

