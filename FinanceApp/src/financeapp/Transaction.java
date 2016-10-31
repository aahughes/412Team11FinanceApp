/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.time.LocalDate;

/**
 *
 * @author Allison
 */
public class Transaction {
    
    private String name;
    private double amount;
    private LocalDate date;
    
    public Transaction(String newName, double newAmount, LocalDate newDate){
        this.name = newName;
        this.amount = newAmount;
        this.date = newDate;
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public String getName(){
        return name;
    }
    
    public void setDate(LocalDate newDate){
        this.date = newDate;
    }
    
    public void setAmount(double newAmount){
        this.amount = newAmount;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    
    
}
