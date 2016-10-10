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
public class Budget {
    private String categoryName;
    private double amount;
    private double balance;
    private double remainingBalance;
    
    public Budget (String newCategoryName, double newAmount, double newBalance, double newRemainingBalance) {
        categoryName = newCategoryName;
        amount = newAmount;
        balance = newBalance;
        remainingBalance = newRemainingBalance;
    }
    
    public void setRemainingBalance(double newRemainingBalance){
        remainingBalance = newRemainingBalance;
    }
    public double getRemainingBalance(){
        return remainingBalance;
    }
    
}

