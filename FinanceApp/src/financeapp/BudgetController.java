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
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Allison
 */
public class BudgetController {
    
    public static Month currentMonth = LocalDate.now().getMonth();
    
    TotalBudget totalBudget;
    private Map<String,Budget> budgets;
    
    private Map<Month,MonthlyBudget> monthlyBudgets;
    
    public BudgetController(){ 
       currentMonth = LocalDate.now().getMonth();
       this.budgets = new HashMap();
       this.monthlyBudgets = new HashMap();
       monthlyBudgets.put(currentMonth, new MonthlyBudget(currentMonth,budgets,totalBudget));
    }

    //add debug/test values if they do not already exist
    public void addTestBudgetValues(){
       if (getBudget("food") == null){
       addBudget("food",100.0,100.0);
       addTransaction(getBudget("food"),"apple", 1.00, LocalDate.now());
       addTransaction(getBudget("food"),"pear", 1.00, LocalDate.now());  
       monthlyBudgets.put(Month.NOVEMBER, new MonthlyBudget(Month.NOVEMBER, new HashMap(), totalBudget));
       monthlyBudgets.get(Month.NOVEMBER).getBudgets().put("food", new Budget("food",100.0,100.0));
       monthlyBudgets.get(Month.NOVEMBER).getBudgets().get("food").addTransaction("pineapple",3.00,LocalDate.of(2016, Month.NOVEMBER,1));
       }
       updateMonth();
    }
    
    public MonthlyBudget getMonthlyBudget(Month month){
        return monthlyBudgets.get(month);
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
    
    // subtract an amount from total budget
    public void subtractTotalBudget(Double amount){
        totalBudget.setBalance(totalBudget.getBalance() - amount);
    }
    
    // used for adding test transactions to ensure total budget updates
    public void addTransaction(Budget budget, String name, Double amount, LocalDate date){
        budget.addTransaction(name, amount, date);
        subtractTotalBudget(amount);
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

    
    // updates the monthlybudgets list with current month's budgets and total budget
    
    public void updateMonth(){
        monthlyBudgets.put(currentMonth, new MonthlyBudget(currentMonth,budgets,totalBudget));
    }

    // Delete budgets and transactions
    public void deleteBudgets(){
        this.totalBudget = new TotalBudget(100.0,100.0,20.0);
        this.budgets = new HashMap();
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
            updateMonth();
            
            FileOutputStream fileOut = new FileOutputStream("monthlybudgets.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(monthlyBudgets);
            out.close();
            
            System.out.println("Total budgets saved.");
        }catch(IOException e){
        }
    }
    
    public boolean loadBudgets(){
        try{
            FileInputStream fileIn = new FileInputStream("monthlyBudgets.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            monthlyBudgets = (Map<Month,MonthlyBudget>) in.readObject();
            in.close();
            
            System.out.println(budgets.toString());
            if (!monthlyBudgets.containsKey(currentMonth)){
                if (monthlyBudgets.containsKey(currentMonth.minus(1))){
                double budgetAmount = monthlyBudgets.get(currentMonth.minus(1)).getTotalBudget().getAmount();
                double alertAmount = monthlyBudgets.get(currentMonth.minus(1)).getTotalBudget().getAlert();
                totalBudget = new TotalBudget(budgetAmount,budgetAmount,alertAmount);
                }
                else {
                    totalBudget = new TotalBudget(100.0,100.0,20.0);
                }
            }
            else
                totalBudget = monthlyBudgets.get(currentMonth).getTotalBudget();
            
            fileIn = new FileInputStream("budgets.ser");
            in = new ObjectInputStream(fileIn);
            budgets = (Map<String,Budget>) in.readObject();
            in.close();
            
            System.out.println(budgets.toString());
            
            if (!budgets.isEmpty()){
                Month budgetMonth = getBudgetList().get(0).month;
                if (budgetMonth != currentMonth){
                    monthlyBudgets.put(budgetMonth, new MonthlyBudget(budgetMonth,budgets,totalBudget));
                }
            }
            budgets = new HashMap();
            
            return true;
        } catch (IOException | ClassNotFoundException e){
            totalBudget = new TotalBudget(100.0,100.0,20.0);
            monthlyBudgets.put(currentMonth, new MonthlyBudget(currentMonth,budgets,totalBudget));
            return false;
            } 
    }
    
    // return total budget balance
    
    public double getTotalBalance(){
        return totalBudget.getBalance();
    }
    
    
    // check if total budget alert should trigger
     
    public boolean checkAlert(){
        return  totalBudget.getBalance() <= totalBudget.getAlert();
    }
}
