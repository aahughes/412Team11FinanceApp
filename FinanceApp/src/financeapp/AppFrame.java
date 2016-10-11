/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.awt.CardLayout;
import javax.swing.*;

/**
 * 
 * Main Frame of the application; contains other screens as panels
 * and switches between them as needed
 * 
 * @author Allison
 */
public class AppFrame extends JFrame {
    
    
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 400;
    
    MenuScreen menu;
    BudgetViewScreen budgetview;
    SettingsScreen settings;
    TransactionEntryScreen transactionentry;
    //TransactionHistoryScreen transactionhistory;
    //BudgetEntryScreen budgetentry;
    
    

    AppFrame(){
        setTitle("Finance App");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setLocationRelativeTo(null);
        
        this.setLayout(new CardLayout());
        
        menu = new MenuScreen(this);
        //budgetview = new BudgetViewScreen(this);
        settings = new SettingsScreen(this);
        transactionentry = new TransactionEntryScreen(this);
        //transactionhistory = new TransactionHistoryScreen(this);
        //budgetentry = new BudgetEntryScreen(this);
        
        this.add(menu);
    }
    
    public void openMenu(){
        this.setContentPane(menu);
        //this.setSize(menu.getSize());
        this.repaint();
        this.setVisible(true);
    }
    
    public void openBudgetView(){
        //openPanel(budgetview);
    }
    
     public void openBudgetEntry(){
        //openPanel(budgetentry);
    }
    
    public void openSettings(){
        openPanel(settings);
    }
    
    public void openTransactionEntry(){
        openPanel(transactionentry);
    }
    
    public void openTransactionHistory(){
        //openPanel(transactionhistory);
    }
    
    public void openPanel(JComponent content){
        this.setContentPane(content);
        this.repaint();
        this.setVisible(true);
    }
}
