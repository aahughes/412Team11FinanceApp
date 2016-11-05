/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;


import javax.swing.*;

/**
 * 
 * Main Frame of the application; contains other screens as panels
 * and switches between them as needed
 * 
 * @author Allison
 */
public class AppFrame extends JFrame {
    
    
    private final int WINDOW_WIDTH = 450;
    private final int WINDOW_HEIGHT = 500;
    
    MenuScreen menu;
    BudgetViewScreen budgetview;
    SettingsScreen settings;
    TransactionEntryScreen transactionentry;
    TransactionHistoryScreen transactionhistory;
    BudgetEntryScreen budgetentry;
    
    BudgetController controller;
    
    

    AppFrame(){
        setTitle("Finance App");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setLocationRelativeTo(null);
        
        controller = new BudgetController();
                
        menu = new MenuScreen(this);
       
        
        this.add(menu);
    }
    
    public void openMenu(){
        this.setContentPane(menu);
        //this.setSize(menu.getSize());
        this.repaint();
        this.setVisible(true);
    }
    
    public void openBudgetView(){
        budgetview = new BudgetViewScreen(this);
        openPanel(budgetview);
    }
    
     public void openBudgetEntry(){
        budgetentry = new BudgetEntryScreen(this);
        openPanel(budgetentry);
    }
    
    public void openSettings(){
        settings = new SettingsScreen(this,controller.totalBudget.getAmount(),controller.totalBudget.getAlert());
        openPanel(settings);
    }
    
    public void openTransactionEntry(){ 
        transactionentry = new TransactionEntryScreen(this);
        openPanel(transactionentry);
    }
    
    public void openTransactionHistory(){
        transactionhistory = new TransactionHistoryScreen(this);
        openPanel(transactionhistory);
    }
    
    public void openPanel(JComponent content){
        this.setContentPane(content);
        this.repaint();
        this.setVisible(true);
    }
}
