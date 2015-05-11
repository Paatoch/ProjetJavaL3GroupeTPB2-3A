/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.util.ArrayList;
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
public class FormationTest {
    
    public FormationTest() {
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
     * Test of getNomFormation method, of class Formation.
     */
    @Test
    public void testGetNomFormation() {
        System.out.println("*****************");
        System.out.println("Test : getNomFormation");
        Formation instance = new Formation();
        instance.setNomFormation("java");
        String expResult = "java";
        String result = instance.getNomFormation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNomFormation method, of class Formation.
     */
    @Test
    public void testSetNomFormation() {
        System.out.println("*****************");
        System.out.println("Test : setNomFormation");
        String nomFormation = "java";
        Formation instance = new Formation();
        instance.setNomFormation(nomFormation);
        assertEquals(instance.getNomFormation(), nomFormation);
    }

    /**
     * Test of getDureeTypeSeance method, of class Formation.
     */
    @Test
    public void testGetDureeTypeSeance() {
        System.out.println("*****************");
        System.out.println("Test : getDureeTypeSeance");
        Formation instance = new Formation();
        instance.setDureeTypeSeance((float)0.5);
        Float expResult = (float)0.5;
        Float result = instance.getDureeTypeSeance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDureeTypeSeance method, of class Formation.
     */
    @Test
    public void testSetDureeTypeSeance() {
        System.out.println("*****************");
        System.out.println("Test : setDureeTypeSeance");
        Float dureeTypeSeance = (float)0.5;
        Formation instance = new Formation();
        instance.setDureeTypeSeance(dureeTypeSeance);
        assertEquals(instance.getDureeTypeSeance(), dureeTypeSeance);
    }

    /**
     * Test of addModule method, of class Formation.
     */
    @Test
    public void testAddModule() {
        System.out.println("*****************");
        System.out.println("Test : addModule");
        Module unModule = new Module("java", 10);
        Module parModule = unModule;
        String chaine = unModule.toString();
//        System.out.println(chaine);
        Formation instance = new Formation();
        instance.addModule(parModule);
//        System.out.println(instance.getModule());
        assertEquals(instance.getModule(), chaine);
    }

    /**
     * Test of getModule method, of class Formation.
     */
    @Test
    public void testGetModule_String() throws Exception {
        System.out.println("*****************");
        System.out.println("Test : getModule");
        String parModule = "java";
        Formation instance = new Formation();
        Module expResult = null ;
        Module result = instance.getModule(parModule);
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class Formation.
     */
    @Test
    public void testClear() {
        System.out.println("*****************");
        System.out.println("Test : clear");
        Formation instance = new Formation();
        instance.clear();
    }

    /**
     * Test of getModule method, of class Formation.
     */
    @Test
    public void testGetModule_0args() {
        System.out.println("*****************");
        System.out.println("Test : getModule");
        Formation instance = new Formation();
        ArrayList<Module> expResult = null;
        ArrayList<Module> result = instance.getModule();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Formation.
     */
    @Test
    public void testToString() {
        System.out.println("*****************");
        System.out.println("Test : toString");
        Formation instance = new Formation();
        instance.setDureeTypeSeance((float) 0.5);
        instance.setNomFormation("java");
        String expResult = "La formation  "+ instance.getNomFormation() + " : " +"\n" + " Dont le nombre d'heure type est : " + instance.getDureeTypeSeance() + "\nA pour modules :" ;
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
