/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

// Aaron McFarland
// airon1995@gmail.com
// 23-Sep-16

import javax.swing.*;
import java.awt.event.*;

/**
 * This class will be what the user sees when
 * first opening the application.
 */

public class MenuScreen extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JButton balance;
    private JButton history;
    private JButton withdrawlDeposit;
    private JButton settings;
    private final int WINDOW_WIDTH = 200;
    private final int WINDOW_HEIGHT = 300;
    
    /**
     * Constructor
     */
    
    public MenuScreen(){
        setTitle("Menu");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel("Welcome to _____");
        
        // Creating the four buttons.
        balance = new JButton("Balance");
        history = new JButton("History");
        withdrawlDeposit = new JButton("Withdrawl/Deposit");
        settings = new JButton("Settings");
        
        // Registering an event listener with all 4 buttons.
        balance.addActionListener(new BalanceButtonListener());
        history.addActionListener(new HistoryButtonListener());
        withdrawlDeposit.addActionListener(new WithdrawlDepositButtonListener());
        settings.addActionListener(new SettingsButtonListener());
        
        // Creating the panel and adding the components to it.
        panel = new JPanel();
        panel.add(label);
        panel.add(balance);
        panel.add(history);
        panel.add(withdrawlDeposit);
        panel.add(settings);
        
        // Adding the panel to the frame.
        add(panel);
        
        // Displaying the window.
        setVisible(true);
    }
    
    /**
     * Private inner class that handles event
     * when the user clicks the Balance button.
     */
    
    private class BalanceButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           
        }
    }
    
    /**
     * Private inner class that handles event
     * when the user clicks the History button.
     */
    
    private class HistoryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    /**
     * Private inner class that handles event
     * when the user clicks the Withdrawl/Deposit button.
     */
    
    private class WithdrawlDepositButtonListener implements ActionListener {
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

