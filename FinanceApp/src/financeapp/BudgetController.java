/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author aahughes
 */
public class BudgetController {
    
    public static Month currentMonth = LocalDate.now().getMonth();
    
    TotalBudget totalBudget;
    private Map<String,Budget> budgets;
    
    private Map<Month,MonthlyBudget> monthlyBudgets;
    
    public BudgetController(){ 
       totalBudget = new TotalBudget(100.0,100.0,20.0);
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
        
        monthlyBudgets.put(Month.NOVEMBER, new MonthlyBudget(Month.NOVEMBER, new HashMap(), new TotalBudget(100.0,100.0,20.0)));
        monthlyBudgets.get(Month.NOVEMBER).getBudgets().put("food", new Budget("food",100.0,100.0));
        monthlyBudgets.get(Month.NOVEMBER).getBudgets().get("food").addTransaction("pineapple",3.00,LocalDate.of(2016, Month.NOVEMBER,1));
        monthlyBudgets.get(Month.NOVEMBER).getTotalBudget().setBalance(97.00);
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
    
    // get list of all transactions from all current budgets
    public ArrayList<TransactionList> getTransactionLists(){
        ArrayList<TransactionList> transactionlists = new ArrayList();
        
        for (Budget b : budgets.values()){
            transactionlists.add(b.getTransactionList());

            //debug
            System.out.println(b.getTransactionList().toString());
        }
        return transactionlists;
    } 

    public ArrayList<TransactionList>getTransactionListsbyMonth(Month month){
        ArrayList<TransactionList> transactionlists = new ArrayList();
        
        if (!(monthlyBudgets.containsKey(month)) || monthlyBudgets.get(month).getBudgets().isEmpty()){
            return transactionlists;
        }
        
        for (Budget b : monthlyBudgets.get(month).getBudgets().values()){
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
    
    
    // methods to serialize monthlyBudget map
    
    public void saveBudgets(){
        // update monthlyBudgets and save all its data to file
        try{
            updateMonth();
            
            FileOutputStream fileOut = new FileOutputStream("monthlybudgets.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(monthlyBudgets);
            out.close();
            
            System.out.println("Budgets saved.");
        }catch(IOException e){
        }
    }
    
    public boolean loadBudgets(){
        // try to load budget data from file and set program's current values to this month's if possible, return true if data is loaded
        try{
            FileInputStream fileIn = new FileInputStream("monthlyBudgets.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            monthlyBudgets = (Map<Month,MonthlyBudget>) in.readObject();
            in.close();
            
            System.out.println(monthlyBudgets.toString());
            
            // check if current month is not in monthlyBudgets
            if (!monthlyBudgets.containsKey(currentMonth)){
                
                // check if previous month is in monthlyBudgets and set totalBudget amount and alert to previous month's amounts if so, set default totalBudget if not
                if (monthlyBudgets.containsKey(currentMonth.minus(1))){
                    double budgetAmount = monthlyBudgets.get(currentMonth.minus(1)).getTotalBudget().getAmount();
                    double alertAmount = monthlyBudgets.get(currentMonth.minus(1)).getTotalBudget().getAlert();
                    totalBudget = new TotalBudget(budgetAmount,budgetAmount,alertAmount);
                }
                else {
                    totalBudget = new TotalBudget(100.0,100.0,20.0);
                }
            }
            
            // if current month is in monthlyBudgets, get current month data for current totalBudget and budgets variables
            else {
                totalBudget = monthlyBudgets.get(currentMonth).getTotalBudget();
                budgets = monthlyBudgets.get(currentMonth).getBudgets();
            }
            
            return true;
        } catch (IOException | ClassNotFoundException e){
            
            // set default, new values if data cannot be read in, return false to show data was not loaded
            
            totalBudget = new TotalBudget(100.0,100.0,20.0);
            budgets = new HashMap();
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
