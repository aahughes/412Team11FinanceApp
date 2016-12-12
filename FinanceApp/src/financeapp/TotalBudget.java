/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package financeapp;

import java.io.Serializable;
import java.time.*;

/**
 *
 * @author mhilaire, aahughes
 */
public class TotalBudget implements Serializable{
    private double amount;
    private double balance;
    private double budgetAlert;
    private Month month;
    
    public TotalBudget (double newAmount, double newBalance, double newAlert) {
        this.amount = newAmount;
        this.balance = newBalance;
        this.budgetAlert = newAlert;
        this.month = BudgetController.currentMonth;
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

