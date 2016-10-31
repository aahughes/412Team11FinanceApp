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
public class TotalBudgetTest {
    
    public TotalBudgetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setRemainingBudget method, of class TotalBudget.
     */
    @Test
    public void testSetRemainingBalance() {
        System.out.println("setRemainingBudget");
        double remainingBudget = 100.0;
        TotalBudget instance = new TotalBudget(0.0,0.0,0.0);
        double expResult = 100.0;
        instance.setBalance(remainingBudget);
        double result = instance.getBalance();
        assertEquals(expResult, result, 100.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRemainingBudget method, of class TotalBudget.
     */
    @Test
    public void testGetRemainingBalance() {
        System.out.println("getRemainingBudget");
        TotalBudget instance = new TotalBudget(0.0,0.0,0.0);
        double expResult = 0.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
