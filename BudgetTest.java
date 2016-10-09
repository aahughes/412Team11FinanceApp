/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module3activity1;

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
    public void testSetRemainingBudget() {
        System.out.println("setRemainingBudget");
        double remainingBudget = 0.0;
        Budget instance = null;
        double expResult = 0.0;
        double result = instance.setRemainingBudget(remainingBudget);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRemainingBudget method, of class Budget.
     */
    @Test
    public void testGetRemainingBudget() {
        System.out.println("getRemainingBudget");
        Budget instance = null;
        double expResult = 0.0;
        double result = instance.getRemainingBudget();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
