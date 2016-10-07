/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Allison
 */
public class BudgetController {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinanceAppPU");
    BudgetsJpaController controller = new BudgetsJpaController(emf);
    
    
    public void addBudget(String category, Double amount, Double balance) throws Exception{
        Budgets newbudget = new Budgets();
        newbudget.setCategory(category);
        newbudget.setAmount(amount);
        newbudget.setBalance(balance);
                
        controller.create(newbudget);
        
    }
    
    public void setBudgetAmount(String category, Double amount) throws Exception{
        Budgets budget = controller.findBudgets(category);
        budget.setAmount(amount);
        
        controller.edit(budget);
    }
    
    public void setBudgetBalance(String category, Double balance) throws Exception{
        
        Budgets budget = controller.findBudgets(category);
        budget.setBalance(balance);
        
        controller.edit(budget);
        
    }
}
