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
public class TransactionList extends ArrayList<Transaction> implements Serializable {
    
    public ArrayList<Transaction> getTransactionsByDate(LocalDate date){
        ArrayList<Transaction> list = new ArrayList<>();
        for (Transaction t : this) {
            if (t.getDate().equals(date)){
                list.add(t);
            }
        }
        return list;
    }
    
    public ArrayList<Transaction> getTransactionsByDateRange(LocalDate recentDate, LocalDate pastDate){
        ArrayList<Transaction> list = new ArrayList<>();
        for (Transaction t : this) {
            if (compareDates(t.getDate(),recentDate) && compareDates(pastDate,t.getDate())){
                list.add(t);
                
                //debug
                System.out.println("list added " + t.getName());
            }
        }
        return list;
    }
    
    
    // Returns true if beforeDate is before or equal to afterDate
    public boolean compareDates(LocalDate beforeDate, LocalDate afterDate){
        return (beforeDate.equals(afterDate) || beforeDate.isBefore(afterDate));     
        
    }
    
    public ArrayList<Transaction> getTransactionsByMonth(Month month){
        ArrayList<Transaction> list = new ArrayList<>();
        for (Transaction t : this) {
            if (t.getDate().getMonth().equals(month)){
                list.add(t);
            }
        }
        return list;
    }
    
    
    @Override
    public String toString(){
        String transactionlist = "";
        for (Transaction t : this){
            transactionlist = transactionlist + " " + t.getName();
        }
        
        return transactionlist;
    }
    
    
}
