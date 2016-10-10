/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

/**
 *
 * @author Allison
 */
public class UIController {
    MenuScreen menu = new MenuScreen();
    BudgetViewScreen budgetview = new BudgetViewScreen();
    SettingsScreen settings = new SettingsScreen();
    TransactionEntryScreen transactionentry = new TransactionEntryScreen();
    
    public void openMenu(){
        menu.setVisible(true);
        budgetview.setVisible(false);
        settings.setVisible(false);
    }
    
    public void openBudgetview(){
        budgetview.setVisible(true);
        menu.setVisible(false);
    }
    
    public void openSettings(){
        settings.setVisible(true);
        menu.setVisible(false);
    }
    
    public void openTransactionEntry(){
        transactionentry.setVisible(true);
        menu.setVisible(false);
    }
    
}
