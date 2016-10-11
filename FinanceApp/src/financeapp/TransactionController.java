package financeapp;

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
        
        Budgets budget = budgets.findBudgets(category);
        newtransaction.setCategoryFk(budget);
                        
        controller.create(newtransaction);        
    }
    
}
