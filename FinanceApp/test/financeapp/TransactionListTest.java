/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
