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
public class BudgetTest {
    
    public BudgetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setRemainingBudget method, of class Budget.
     */
    @Test
    public void testSetRemainingBalance() {
        System.out.println("setRemainingBudget");
        double remainingBudget = 0.0;
        Budget instance = new Budget("Test",0.0,0.0,0.0);
        double expResult = 0.0;
        double result = instance.getRemainingBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRemainingBudget method, of class Budget.
     */
    @Test
    public void testGetRemainingBalance() {
        System.out.println("getRemainingBudget");
        Budget instance = new Budget("Test",0.0,0.0,0.0);
        double expResult = 0.0;
        double result = instance.getRemainingBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
