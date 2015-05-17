/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bnejamin Tabet
 */
public class ModeleTableCalendrierJourTest {
    
    public ModeleTableCalendrierJourTest() {
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
     * Test of isCellEditable method, of class ModeleTableCalendrierJour.
     * test du retour de la fonction
     */
    @Test
    public void testIsCellEditable() {
        System.out.println("isCellEditable");
        int rowIndex = 1;
        int columnIndex = 1;
        ModeleTableCalendrierJour instance = new ModeleTableCalendrierJour(1,1,1, "octobre", 2015);
        boolean expResult = false;
        boolean result = instance.isCellEditable(rowIndex, columnIndex);
        assertEquals(expResult, result);
    }
    
}
