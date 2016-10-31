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
public class BudgetControllerTest {
    
    public BudgetControllerTest() {
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
     * Test of addBudget method, of class BudgetController.
     */
    @Test
    public void testAddBudget() {
        System.out.println("addBudget");
        String category = "Food";
        Double amount = 100.00;
        Double balance = 100.00;
        BudgetController instance = new BudgetController();
        instance.addBudget(category, amount, balance);
        
        Budget testBudget = instance.getBudget(category);
        
        String expectedstring = "Food";
        double expecteddouble = 100.00;
        
        Assert.assertEquals(expectedstring, testBudget.getCategory());
        Assert.assertEquals(expecteddouble, testBudget.getAmount());
        Assert.assertEquals(expecteddouble, testBudget.getBalance());        
        
    }

    /**
     * Test of setBudgetAmount method, of class BudgetController.
     */
    @Test
    public void testSetBudgetAmount() {
        System.out.println("setBudgetAmount");
        String category = "Food";
        Double amount = 100.00;
        BudgetController instance = new BudgetController();
        instance.setBudgetAmount(category, amount);

        Budget testBudget = instance.getBudget(category);
        
        String expectedstring = "Food";
        double expecteddouble = 100.00;
        
        Assert.assertEquals(expectedstring, testBudget.getCategory());
        Assert.assertEquals(expecteddouble, testBudget.getAmount());
    }

    /**
     * Test of setBudgetBalance method, of class BudgetController.
     */
    @Test
    public void testSetBudgetBalance() {
        System.out.println("setBudgetBalance");
        String category = "Food";
        Double balance = 100.00;
        BudgetController instance = new BudgetController();
        instance.setBudgetBalance(category, balance);
        
        Budget testBudget = instance.getBudget(category);
        
        String expectedstring = "Food";
        double expecteddouble = 100.00;
        
        Assert.assertEquals(expectedstring, testBudget.getCategory());
        Assert.assertEquals(expecteddouble, testBudget.getBalance());  
      
    }
    
}
