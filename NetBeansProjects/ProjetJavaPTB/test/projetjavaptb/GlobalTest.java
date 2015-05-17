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
 * @author Benjamin Tabet
 */
public class GlobalTest {
    
    public GlobalTest() {
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
     * Test of Remplit method, of class Global.
     * Fonction static et qui sert a remplir la liste de mois donc rien a tester
     */
    @Test
    public void testRemplit() {
        System.out.println("Remplit");
        Global.Remplit();
        
    }
    
}
