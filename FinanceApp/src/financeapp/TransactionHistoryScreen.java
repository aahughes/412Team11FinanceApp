/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

// Aaron McFarland
// airon1995@gmail.com
// 12-Oct-16

import javax.swing.*;
import java.awt.event.*;

public class TransactionHistoryScreen extends JPanel {
    AppFrame frame;
    
    private JLabel title;
    private JLabel timeFrameLabel;
    private JComboBox timeFrameList;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 400;
    
    public TransactionHistoryScreen(AppFrame theframe) {
        frame = theframe;
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        String[] timeFrame = {"Last Week", "Last Month", "Last 6 Months"};
        
        timeFrameList = new JComboBox(timeFrame);
        
        add(title);
        add(timeFrameLabel);
        add(timeFrameList);
    }
}