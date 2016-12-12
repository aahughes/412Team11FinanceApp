/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import javax.swing.JComponent;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aah5307
 */
public class AppFrameTest {
    
    public AppFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of openMenu method, of class AppFrame.
     */
    @Test
    public void testOpenMenu() {
        System.out.println("openMenu");
        AppFrame instance = new AppFrame();
        instance.openMenu();
        
        Assert.assertTrue(instance.menu.isVisible());
    }

    /**
     * Test of openBudgetView method, of class AppFrame.
     */
    @Test
    public void testOpenBudgetView() {
        System.out.println("openBudgetView");
        AppFrame instance = new AppFrame();
        instance.openBudgetView();
        
        Assert.assertTrue(instance.budgetview.isVisible());
    }

    /**
     * Test of openBudgetEntry method, of class AppFrame.
     */
    @Test
    public void testOpenBudgetEntry() {
        System.out.println("openBudgetEntry");
        AppFrame instance = new AppFrame();
        instance.openBudgetEntry();
        
        Assert.assertTrue(instance.budgetentry.isVisible());
    }

    /**
     * Test of openSettings method, of class AppFrame.
     */
    @Test
    public void testOpenSettings() {
        System.out.println("openSettings");
        AppFrame instance = new AppFrame();
        instance.openSettings();
        
        Assert.assertTrue(instance.settings.isVisible());
    }

    /**
     * Test of openTransactionEntry method, of class AppFrame.
     */
    @Test
    public void testOpenTransactionEntry() {
        System.out.println("openTransactionEntry");
        AppFrame instance = new AppFrame();
        instance.openTransactionEntry();
        Assert.assertTrue(instance.transactionentry.isVisible());
    }

    /**
     * Test of openTransactionHistory method, of class AppFrame.
     */
    @Test
    public void testOpenTransactionHistory() {
        System.out.println("openTransactionHistory");
        AppFrame instance = new AppFrame();
        instance.openTransactionHistory();
        
        //Assert.assertTrue(instance.transactionhistory.isVisible());
    }

    /**
     * Test of openPanel method, of class AppFrame.
     */
    @Test
    public void testOpenPanel() {
        System.out.println("openPanel");
        javax.swing.JPanel testpanel = new javax.swing.JPanel();
        AppFrame instance = new AppFrame();
        instance.openPanel(testpanel);
        
        Assert.assertTrue(testpanel.isVisible());
        
    }
    
}
