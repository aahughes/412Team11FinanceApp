/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Allison
 */
public class BudgetController {
    
    TotalBudget totalBudget;
    private Map<String,Budget> budgets;
    
    public BudgetController(){
       this.budgets = new HashMap();
       totalBudget = new TotalBudget(100.00,100.00,20.00);
    }
    
    public void addBudget(String category, Double amount, Double balance){
        Budget newBudget = new Budget(category,amount,balance);
        this.budgets.put(category,newBudget);
    }
    
    public void setBudgetAmount(String category, Double amount){
        Budget budget = budgets.get(category);
        budget.setAmount(amount);
    }
    
    public void setBudgetBalance(String category, Double balance){    
        Budget budget = budgets.get(category);
        budget.setBalance(balance);
    }
    
    public void subtractTotalBudget(Double amount){
        totalBudget.setBalance(totalBudget.getBalance() - amount);
    }
    
    
    // Get budget by category
    public Budget getBudget(String category){
        return budgets.get(category);     
    }
        
    // Get set of category names
    public Set<String> getBudgetNames(){
        return budgets.keySet();
    }
    
    // Get arraylist of category names
    public ArrayList<String> getBudgetNameList(){
        Set<String> set = budgets.keySet();
        ArrayList<String> names = new ArrayList();
        for (String name : set){
            names.add(name);
        }
        
        return names;
    }
    
    
    // Get list of budgets
    public ArrayList<Budget> getBudgetList(){
        return (ArrayList<Budget>) budgets.values();
    }
    
    public ArrayList<TransactionList> getTransactionLists(){
        ArrayList<TransactionList> transactionlists = new ArrayList();
        
        for (Budget b : budgets.values()){
            transactionlists.add(b.getTransactionList());
        }
        
        return transactionlists;
    }
}
