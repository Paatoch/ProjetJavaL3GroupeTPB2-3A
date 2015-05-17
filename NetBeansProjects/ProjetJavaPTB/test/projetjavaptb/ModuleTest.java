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
        String expResult = "test  qui contient  :12 séances  " + "\n" + " java.awt.Color[r=0,g=255,b=255]  CH";
        System.out.println(expResult);
        String result = instance.toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCouleurModule method, of class Module.
     */
    @Test
    public void testGetCouleurModule() {
        System.out.println("getCouleurModule");
        Module instance = new Module("informatique", 10, Color.darkGray, "info");
        Color expResult = Color.DARK_GRAY;
        Color result = instance.getCouleurModule();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCouleurModule method, of class Module.
     */
    @Test
    public void testSetCouleurModule() {
        System.out.println("setCouleurModule");
        Color couleurModule = Color.DARK_GRAY;
        Module instance = new Module("informatique", 10, Color.BLACK, "info");
        instance.setCouleurModule(couleurModule);
        assertEquals(instance.getCouleurModule(), couleurModule);
    }

    /**
     * Test of getAbreviation method, of class Module.
     */
    @Test
    public void testGetAbreviation() {
        System.out.println("getAbreviation");
        Module instance = new Module("informatique", 10, Color.BLACK, "info");;
        String expResult = "info";
        String result = instance.getAbreviation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAbreviation method, of class Module.
     */
    @Test
    public void testSetAbreviation() {
        System.out.println("setAbreviation");
        String abreviation = "inf";
        Module instance = new Module("informatique", 10, Color.BLACK, "info");;
        instance.setAbreviation(abreviation);
        assertEquals(instance.getAbreviation(), abreviation);
    }
    
}
