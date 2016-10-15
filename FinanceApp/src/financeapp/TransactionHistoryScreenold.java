/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

// Aaron McFarland
// airon1995@gmail.com
// 12-Oct-16

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

/*public class TransactionHistoryScreen extends JPanel {
    AppFrame frame;
    
    private JLabel title;
    private JLabel timeFrameLabel;
    private JComboBox timeFrameList;
    private JButton backButton;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 400;
    
    public TransactionHistoryScreen(AppFrame theframe){
        frame = theframe;
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        String[] timeFrame = {"Last Week", "Last Month", "Last 6 Months"};
        
        title = new JLabel("Transaction History");
        timeFrameLabel = new JLabel("Time Frame");
        timeFrameList = new JComboBox(timeFrame);
        backButton = new JButton("Back");
        
        this.setLayout(new GridLayout(2,2));
        
        backButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }          
        });
        
        
        this.add(title);
        this.add(timeFrameLabel);
        this.add(timeFrameList);
        this.add(backButton);
    }
    
    private void backButtonActionPerformed(ActionEvent evt) {
        frame.openMenu();
    }
}*/