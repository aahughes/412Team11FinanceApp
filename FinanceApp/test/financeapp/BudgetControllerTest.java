/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
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
        instance.addBudget(category,200.0,100.0);
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
        instance.addBudget(category, 200.0, 200.0);
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
        Double amount = 10.0;
        BudgetController instance = new BudgetController();
        instance.totalBudget.setBalance(20.0);
        instance.subtractTotalBudget(amount);
        Double result = instance.totalBudget.getBalance();
        assertEquals(amount,result);
    }

    /**
     * Test of getBudget method, of class BudgetController.
     */
    @Test
    public void testGetBudget() {
        System.out.println("getBudget");
        String category = "food";         
        BudgetController instance = new BudgetController();
        instance.addBudget("food",100.0,100.0);
        
        Budget expResult = new Budget("food",100.0,100.0);
        Budget result = instance.getBudget(category);
        assertEquals(expResult.getCategory(), result.getCategory());
    }

    /**
     * Test of getBudgetNames method, of class BudgetController.
     */
    @Test
    public void testGetBudgetNames() {
        System.out.println("getBudgetNames");
        BudgetController instance = new BudgetController();
        instance.addBudget("food", 100.0, 100.0);
        instance.addBudget("rent", 1000.0, 1000.0);
        
        Set<String> expResult = new HashSet<>();
        expResult.add("food");
        expResult.add("rent");
        Set<String> result = instance.getBudgetNames();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getBudgetNameList method, of class BudgetController.
     */
    @Test
    public void testGetBudgetNameList() {
        System.out.println("getBudgetNameList");
        BudgetController instance = new BudgetController();
        instance.addBudget("food", 100.0, 100.0);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("food");
        ArrayList<String> result = instance.getBudgetNameList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBudgetList method, of class BudgetController.
     */
    @Test
    public void testGetBudgetList() {
        System.out.println("getBudgetList");
        String category = "food";
        Double amount = 100.0;
        Double balance = 100.0;
        
        BudgetController instance = new BudgetController();
        instance.addBudget(category, amount, balance);
        ArrayList<Budget> expResult = new ArrayList<>();
        expResult.add(new Budget(category,amount,balance));
        ArrayList<Budget> result = instance.getBudgetList();
        assertEquals(expResult.get(0).getCategory(), result.get(0).getCategory());
        
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
       
        ArrayList<TransactionList> expResult = new ArrayList<>();
        TransactionList tlist1 = new TransactionList();
        tlist1.add(t1);
        expResult.add(tlist1);
        ArrayList<TransactionList> result = instance.getTransactionLists();
        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        
    }
    
}
