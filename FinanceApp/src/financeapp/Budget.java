/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author aahughes
 */
public class Budget implements Serializable {
    
    private final String category;
    private double amount;
    private double balance;
    TransactionList transactions;
    Month month;
    
    public Budget(String name, double budgetedAmount, double newBalance){
        this.category = name;
        this.amount = budgetedAmount;
        this.balance = newBalance;
        this.transactions = new TransactionList();
        this.month = BudgetController.currentMonth;
    }
    
    public void setAmount(double newAmount){
        this.amount = newAmount;
    }
    
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
    
    public void subtractBalance(double paid){
        this.balance = balance - paid;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public String getCategory(){
        return category;
    }
    
    public TransactionList getTransactionList(){
        return transactions;
    }
    
    public ArrayList<Transaction> getTransactionsByDate(LocalDate date){
        return transactions.getTransactionsByDate(date);
    }
    
    public ArrayList<Transaction> getTransactionsByDateRange(LocalDate recentDate,LocalDate pastDate){
        return transactions.getTransactionsByDateRange(recentDate,pastDate);
    }
    
    public void addTransaction(String name,double amount, LocalDate date){
        Transaction transaction = new Transaction(name, amount, date);
        transactions.add(transaction);
        subtractBalance(amount);
    }
    
}
