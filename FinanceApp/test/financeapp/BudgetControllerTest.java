/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
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

    /**
     * Test of subtractTotalBudget method, of class BudgetController.
     */
    @Test
    public void testSubtractTotalBudget() {
        System.out.println("subtractTotalBudget");
        Double amount = null;
        BudgetController instance = new BudgetController();
        instance.subtractTotalBudget(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBudget method, of class BudgetController.
     */
    @Test
    public void testGetBudget() {
        System.out.println("getBudget");
        String category = "";
        BudgetController instance = new BudgetController();
        Budget expResult = null;
        Budget result = instance.getBudget(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetNames method, of class BudgetController.
     */
    @Test
    public void testGetBudgetNames() {
        System.out.println("getBudgetNames");
        BudgetController instance = new BudgetController();
        Set<String> expResult = null;
        Set<String> result = instance.getBudgetNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetNameList method, of class BudgetController.
     */
    @Test
    public void testGetBudgetNameList() {
        System.out.println("getBudgetNameList");
        BudgetController instance = new BudgetController();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getBudgetNameList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetList method, of class BudgetController.
     */
    @Test
    public void testGetBudgetList() {
        System.out.println("getBudgetList");
        BudgetController instance = new BudgetController();
        ArrayList<Budget> expResult = null;
        ArrayList<Budget> result = instance.getBudgetList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactionLists method, of class BudgetController.
     */
    @Test
    public void testGetTransactionLists() {
        System.out.println("getTransactionLists");
        BudgetController instance = new BudgetController();
        instance.addBudget("food", 100.0, 100.0);
        Transaction t1 = new Transaction("food",1,LocalDate.now());
        instance.getBudget("food").addTransaction("food",1,LocalDate.now());
       
        ArrayList<TransactionList> expResult = new ArrayList<TransactionList>();
        expResult.add(e);
        ArrayList<TransactionList> result = instance.getTransactionLists();
        assertEquals(expResult, result);
        
    }
    
}
