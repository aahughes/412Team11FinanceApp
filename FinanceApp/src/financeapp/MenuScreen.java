/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

// Aaron McFarland
// airon1995@gmail.com
// 10-Oct-16

import javax.swing.*;
import java.awt.event.*;

/**
 * This class will be what the user sees when
 * first opening the application.
 */

public class MenuScreen extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JButton budgetButton;
    private JButton budgetEntryButton;
    private JButton transactionEntryButton;
    private JButton transactionHistoryButton;
    private JButton settingsButton;
    private final int WINDOW_WIDTH = 200;
    private final int WINDOW_HEIGHT = 300;
    
    /**
     * Constructor
     */
    
    public MenuScreen(){
        setTitle("Menu");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel("Welcome to Finance App");
        
        // Creating the four buttons.
        budgetButton = new JButton("Budget");
        budgetEntryButton = new JButton("Budget Entry");
        transactionEntryButton = new JButton("Transaction Entry");
        transactionHistoryButton = new JButton("Transaction History");
        settingsButton = new JButton("Settings");
        
        // Registering an event listener with all 4 buttons.
        budgetButton.addActionListener(new BudgetButtonListener());
        budgetEntryButton.addActionListener(new BudgetEntryButtonListener());
        transactionEntryButton.addActionListener(new TransactionEntryButtonListener());
        transactionHistoryButton.addActionListener(new TransactionHistoryButtonListener());
        settingsButton.addActionListener(new SettingsButtonListener());
        
        // Creating the panel and adding the components to it.
        panel = new JPanel();
        panel.add(label);
        panel.add(budgetButton);
        panel.add(budgetEntryButton);
        panel.add(transactionEntryButton);
        panel.add(transactionHistoryButton);
        panel.add(settingsButton);
        
        // Adding the panel to the frame.
        add(panel);
        
        // Displaying the window.
        setVisible(true);
    }
    
    /**
     * Private inner class that handles event
     * when the user clicks the Budget button.
     */
    
    private class BudgetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           //BudgetViewScreen budgetViewScreen = new BudgetViewScreen();
        }
    }
    
    /**
     * Private inner class that handles event
     * when the user clicks the Budget Entry button.
     */
    
    private class BudgetEntryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           
        }
    }
    
    /**
     * Private inner class that handles event
     * when the user clicks the Transaction Entry button.
     */
    
    private class TransactionEntryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            TransactionEntry transactionEntry = new TransactionEntry();
        }
    }
    
    /**
     * Private inner class that handles event
     * when the user clicks the Transaction History button.
     */
    
    private class TransactionHistoryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    
    /**
     * Private inner class that handles event
     * when the user clicks the Settings button.
     */
    
    private class SettingsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           SettingsScreen settings = new SettingsScreen(); 
        }
    }
}

