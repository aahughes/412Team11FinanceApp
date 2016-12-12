/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package financeapp;

/**
 *
 * @author mhilaire, aahughes
 */
public class TransactionHistory {
    private String year;
    private String month;
    private String day;
    
    public TransactionHistory(String newMonth, String newDay, String newYear){
        year = newYear;
        month = newMonth;
        day = newDay;
    }
    
    public String getHistory(){
        return month + " " + day + ", " + year;
    }
}
