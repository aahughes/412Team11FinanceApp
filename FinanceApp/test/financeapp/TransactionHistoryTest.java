/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package financeapp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mhilaire
 */
public class TransactionHistoryTest {
    
    public TransactionHistoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getHistory method, of class TransactionHistory.
     */
    @Test
    public void testGetHistory() {
        System.out.println("getHistory");
        TransactionHistory instance = new TransactionHistory("September", "22", "2016");
        String expResult = "September 22, 2016";
        String result = instance.getHistory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
