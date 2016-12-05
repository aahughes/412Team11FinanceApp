/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
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


       //debug/test values
       addBudget("food",100.0,100.0);
       getBudget("food").addTransaction("apple", 1.00, LocalDate.now());
       getBudget("food").addTransaction("pear", 1.00, LocalDate.now());
    
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
        ArrayList<Budget> al = new ArrayList<>();
        al.addAll(budgets.values());        
        return al;
    }
    
    public ArrayList<TransactionList> getTransactionLists(){
        ArrayList<TransactionList> transactionlists = new ArrayList();
        
        for (Budget b : budgets.values()){
            transactionlists.add(b.getTransactionList());

            //debug
            System.out.println(b.getTransactionList().toString());
        }
        return transactionlists;
    } 


    // serialize budget map
    
    public void saveBudgets(){
        try{
            FileOutputStream fileOut = new FileOutputStream("budgets.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(budgets);
            out.close();
            
            System.out.println("Budgets saved.");
        }catch(IOException e){
        }
        
        try{
            FileOutputStream fileOut = new FileOutputStream("totalbudget.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(totalBudget);
            out.close();
            
            System.out.println("Total budget saved.");
        }catch(IOException e){
        }
    }
    
    public void loadBudgets(){
        try{
            FileInputStream fileIn = new FileInputStream("budgets.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            budgets = (Map<String,Budget>) in.readObject();
            in.close();
            
            System.out.println(budgets.toString());
        } catch (IOException | ClassNotFoundException e){
            }
        
        try{
            FileInputStream fileIn = new FileInputStream("totalbudget.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            totalBudget = (TotalBudget) in.readObject();
            in.close();
            
            System.out.println(budgets.toString());
        } catch (IOException | ClassNotFoundException e){
            }
    }
}
