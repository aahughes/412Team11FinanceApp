package financeapp;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Allison
 */
public class TransactionController {
    
    EntityManagerFactory emf;
    TransactionsJpaController controller;
    BudgetsJpaController budgets;
    int transactionID;
    
    

    public TransactionController() {
        this.emf = Persistence.createEntityManagerFactory("FinanceAppPU");
        this.budgets = new BudgetsJpaController(emf);
        this.controller = new TransactionsJpaController(emf);
        transactionID = controller.getTransactionsCount();
    }
    
    public void addTransaction(String name, String category, Double amount, Date date) throws Exception{
        Transactions newtransaction = new Transactions();
        newtransaction.setName(name);
        newtransaction.setDate(date);
        newtransaction.setAmount(amount);
        newtransaction.setId(transactionID);
        transactionID++;
        
        // Get budget by category to set FK for new transaction
        Budgets budget = budgets.findBudgets(category);
        newtransaction.setCategoryFk(budget);
        
        // Update balance for the budget to remove amount spent in transaction
        double newbalance = (budget.getBalance() - amount);
        budget.setBalance(newbalance);
                        
        controller.create(newtransaction);        
    }
    
    
    // Get list of transactions in budget category
    public ArrayList getTransactionsByCategory(String category){
        ArrayList list = new ArrayList();
        Budgets budget = budgets.findBudgets(category);
        
        list.addAll(budget.getTransactionsCollection());
                
        return list;
    }
    
    // Get list of transactions on date
    public ArrayList getTransactionsByDate(Date date){
        return (ArrayList)controller.findTransactionsByDate(date);
    }
    
    // Get list of transactions between date1 and date2
    public ArrayList getTransactionsByDateRange(Date date1, Date date2){
        return (ArrayList)controller.findTransactionsByDateRange(date1,date2);
    }
}
