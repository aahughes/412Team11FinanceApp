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
public class TransactionHistory {
    private String year;
    private String month;
    private String day;
    
    public TransactionHistory(String newYear, String newMonth, String newDay){
        year = newYear;
        month = newMonth;
        day = newDay;
    }
    
    public String getHistory(){
        return month + day + ", " + year;
    }
}
