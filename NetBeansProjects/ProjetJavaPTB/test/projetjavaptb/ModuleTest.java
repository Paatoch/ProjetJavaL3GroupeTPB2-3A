/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Utilisateur
 */
public class ModuleTest {
    
    public ModuleTest() {
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
     * Test of getNomModule method, of class Module.
     */
    @Test
    public void testGetNomModule() {
        System.out.println("*****************");
        System.out.println("Test : getNomModule");
        Module instance = new Module("java", 10, Color.CYAN, "CH");
        String expResult = "java";
        String result = instance.getNomModule();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNomModule method, of class Module.
     */
    @Test
    public void testSetNomModule() {
        System.out.println("*****************");
        System.out.println("Test : setNomModule");
        String nomModule = "java";
        Module instance = new Module ("test", 12, Color.CYAN, "CH");
        instance.setNomModule(nomModule);
        assertEquals(instance.getNomModule(), nomModule);
    }

    /**
     * Test of getNbSeances method, of class Module.
     */
    @Test
    public void testGetNbSeances() {
        System.out.println("*****************");
        System.out.println("Test : getNbSeances");
        Module instance = new Module ("test", 12, Color.CYAN, "CH");
        int expResult = 12;
        int result = instance.getNbSeances();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNbSeances method, of class Module.
     */
    @Test
    public void testSetNbSeances() {
        System.out.println("*****************");
        System.out.println("Test : setNbSeances");
        int nbHeureModule = 12;
        Module instance = new Module ("test", 12, Color.CYAN, "CH");
        instance.setNbSeances(nbHeureModule);
        assertEquals(instance.getNbSeances(), nbHeureModule);
    }

    /**
     * Test of toString method, of class Module.
     */
    @Test
    public void testToString() {
        System.out.println("*****************");
        System.out.println("Test : toString");
        Module instance = new Module ("test", 12, Color.CYAN, "CH");
        String expResult = instance.getNomModule() + "  qui contient  :" + instance.getNbSeances() + " séances "+"\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
