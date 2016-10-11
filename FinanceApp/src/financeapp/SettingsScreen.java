/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

// Aaron McFarland
// airon1995@gmail.com
// 10-Oct-16


// some refactoring/edits by aahughes
// 10-Oct-16

import javax.swing.*;
import java.awt.event.*;

public class SettingsScreen extends JPanel {
    
    public AppFrame frame;
    
    private JLabel budgetLabel;
    private JTextField budgetTextField;
    private JLabel alertLabel;
    private JTextField alertTextField;
    private JButton menuButton;
    private JButton saveButton;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 400;
    
    /**
     * Constructor
     * @param theframe
     */
    
    public SettingsScreen(AppFrame theframe){
        //setTitle("Settings");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        this.frame = theframe;
        
        budgetLabel = new JLabel("Monthly Budget : ");
        budgetTextField = new JTextField(10);
        alertLabel = new JLabel("Budget Alert : ");
        alertTextField = new JTextField(10);
        menuButton = new JButton("Menu");
        saveButton = new JButton("Save");
        
        menuButton.addActionListener(new MenuButtonListener());
        saveButton.addActionListener(new SaveButtonListener());
        
        this.add(budgetLabel);
        this.add(budgetTextField);
        this.add(alertLabel);
        this.add(alertTextField);
        this.add(menuButton);
        this.add(saveButton);
        
        //setVisible(true);
    }
    
     /**
     * Private inner class that handles event
     * when the user clicks the Menu button.
     */
    
     private class MenuButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           frame.openMenu();
        }
    }
    
     /**
     * Private inner class that handles event
     * when the user clicks the Save button.
     */
     
      private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           JOptionPane.showMessageDialog(null,"Your settings have been saved.");
        }
    }
}
