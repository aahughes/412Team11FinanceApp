/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Allison
 */
public class UIControllerTest {
    
    public UIControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of openMenu method, of class UIController.
     */
    @Test
    public void testOpenMenu() {
        System.out.println("openMenu");
        UIController instance = new UIController();
        instance.openMenu();
        Assert.assertTrue(instance.menu.isVisible());
    }

    /**
     * Test of openBudgetview method, of class UIController.
     */
    @Test
    public void testOpenBudgetview() {
        System.out.println("openBudgetview");
        UIController instance = new UIController();
        instance.openBudgetview();
        Assert.assertTrue(instance.budgetview.isVisible());
    }

    /**
     * Test of openSettings method, of class UIController.
     */
    @Test
    public void testOpenSettings() {
        System.out.println("openSettings");
        UIController instance = new UIController();
        instance.openSettings();
        Assert.assertTrue(instance.settings.isVisible());
    }

    /**
     * Test of openTransactionEntry method, of class UIController.
     */
    @Test
    public void testOpenTransactionEntrry() {
        System.out.println("openTransactionEntry");
        UIController instance = new UIController();
        instance.openTransactionEntry();
        Assert.assertTrue(instance.transactionentry.isVisible());
    }
    
}
