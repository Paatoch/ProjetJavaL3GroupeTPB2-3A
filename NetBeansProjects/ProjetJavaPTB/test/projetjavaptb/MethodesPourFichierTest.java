/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.io.File;
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
public class MethodesPourFichierTest {
    
    public MethodesPourFichierTest() {
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
     * Test of ecriture method, of class MethodesPourFichier.
     */
    @Test
    public void testEcriture() {
        System.out.println("ecriture");
        Planning input = null;
        File cheminBinaryFile = null;
        MethodesPourFichier.ecriture(input, cheminBinaryFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lecture method, of class MethodesPourFichier.
     */
    @Test
    public void testLecture() {
        System.out.println("lecture");
        File fichier = null;
        Object expResult = null;
        Object result = MethodesPourFichier.lecture(fichier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
