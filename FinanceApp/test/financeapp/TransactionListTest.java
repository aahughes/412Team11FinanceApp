/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author aah5307
 */
public class TransactionListTest {
    
    public TransactionListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getTransactionsByDate method, of class TransactionList.
     */
    @Test
    public void testGetTransactionsByDate() {
        System.out.println("getTransactionsByDate");
        String name = "apple";
        Double amount = 1.00;
        LocalDate date = LocalDate.now();
        Transaction t1 = new Transaction(name,amount,date);
        
        TransactionList instance = new TransactionList();
        
        instance.add(t1);
        ArrayList<Transaction> expResult = new ArrayList<>();
        expResult.add(t1);
        ArrayList<Transaction> result = instance.getTransactionsByDate(date);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTransactionsByDateRange method, of class TransactionList.
     */
    @Test
    public void testGetTransactionsByDateRange() {
        System.out.println("getTransactionsByDateRange");
        LocalDate recentDate = LocalDate.now();
        LocalDate pastDate = LocalDate.of(2016, Month.OCTOBER, 26);
        
        Transaction t1 = new Transaction("apple",1,LocalDate.of(2016, Month.OCTOBER, 30));
        Transaction t2 = new Transaction("grape",1,LocalDate.of(2016, Month.OCTOBER, 29));
        Transaction t3 = new Transaction("pear",2,LocalDate.of(2016, Month.OCTOBER, 25));
        TransactionList instance = new TransactionList();
        instance.add(t1);
        instance.add(t2);
        instance.add(t3);
        ArrayList<Transaction> expResult = new ArrayList<>();
        expResult.add(t1); expResult.add(t2);
        ArrayList<Transaction> result = instance.getTransactionsByDateRange(recentDate, pastDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareDates method, of class TransactionList.
     */
    @Test
    public void testCompareDates() {
        System.out.println("compareDates");
        LocalDate beforeDate = LocalDate.of(2016, Month.OCTOBER, 20);
        LocalDate afterDate = LocalDate.of(2016,Month.NOVEMBER,2);
        TransactionList instance = new TransactionList();
        boolean expResult = true;
        boolean result = instance.compareDates(beforeDate, afterDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTransactionsByMonth method, of class TransactionList.
     */
    @Test
    public void testGetTransactionsByMonth() {
        System.out.println("getTransactionsByMonth");
        Month month = BudgetController.currentMonth;
        TransactionList instance = new TransactionList();
        instance.add(new Transaction("apple",1.00,LocalDate.now()));
        instance.add(new Transaction("pear",2.00,LocalDate.of(1, Month.JANUARY, 1)));
        
        TransactionList resultList = new TransactionList();
        resultList.add(new Transaction("apple",1.00,LocalDate.now()));
        ArrayList<Transaction> expResult = resultList;
        ArrayList<Transaction> result = instance.getTransactionsByMonth(month);
        assertEquals(expResult.size(), result.size());
        
    }

    /**
     * Test of toString method, of class TransactionList.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        TransactionList instance = new TransactionList();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class TransactionList.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        TransactionList instance = new TransactionList();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
