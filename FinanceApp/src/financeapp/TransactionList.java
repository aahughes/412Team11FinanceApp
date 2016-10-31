/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Allison
 */
public class TransactionList extends ArrayList<Transaction> {
    
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
            }
        }
        return list;
    }
    
    
    // Returns true if beforeDate is before or equal to afterDate
    public boolean compareDates(LocalDate beforeDate, LocalDate afterDate){
        return (beforeDate.equals(afterDate) || beforeDate.isBefore(afterDate));     
        
    }
    
    
    
}
