/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.util.Calendar;
import java.util.Date;
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
public class TransactionControllerTest {
    
    public TransactionControllerTest() {
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
     * Test of addTransaction method, of class TransactionController.
     */
    @Test
    public void testAddTransaction() throws Exception {
        System.out.println("addTransaction");
        String name = "McDonald's";
        String category = "Food";
        Double Amount = 10.00;
        Calendar cal = Calendar.getInstance();
        cal.set(2016, 9, 10);
        Date date = cal.getTime();
        TransactionController instance = new TransactionController();
        instance.addTransaction(name, category, Amount, date);
        
        Transactions test = instance.controller.findTransactions(0);
        
        String expectedName = "McDonald's";
        String expectedCat = "Food";
        double expectedAmt = 10.00;
        Date expectedDate = cal.getTime();
        
        Assert.assertEquals(expectedName, test.getName());
        Assert.assertEquals(expectedCat, test.getCategoryFk().toString());
        Assert.assertEquals(expectedCat, instance.budgets.findBudgets(category).toString());
        Assert.assertEquals(expectedAmt, test.getAmount()); 
        Assert.assertEquals(expectedDate.toString(), test.getDate().toString());
        
        Assert.assertTrue(instance.budgets.findBudgets(category).getTransactionsCollection().contains(test));
    }
    
}
