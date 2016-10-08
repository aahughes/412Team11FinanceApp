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
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinanceAppPU");
    TransactionsJpaController controller = new TransactionsJpaController(emf);
    BudgetsJpaController budgets = new BudgetsJpaController(emf);
    
    int transactionID = 0;
    
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
