/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.io.Serializable;
import java.time.Month;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author hughe
 */
public class MonthlyBudget implements Serializable{
    
    private Month month;
    private Map<String,Budget> budgets;
    private TotalBudget totalBudget;
    
    MonthlyBudget(Month month, Map<String,Budget> budgets, TotalBudget totalBudget){
        this.month = month;
        this.budgets = budgets;
        this.totalBudget = totalBudget;
    }
    
    
    public TotalBudget getTotalBudget(){
        return totalBudget;
    }
    
    public Map<String,Budget> getBudgets(){
        return budgets;
    }
    
    public ArrayList<Budget> getBudgetList(){
        ArrayList<Budget> al = new ArrayList<>();
        al.addAll(budgets.values());        
        return al;
    }
}
