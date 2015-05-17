/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.Color;
import java.io.File;
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
       Module monModule= new Module ("Jave", 10, Color.darkGray, "J");
       Formation formation = new Formation (null, Float.NaN, monModule);
       Cours_Reservation cours = new Cours_Reservation (5, 2015, "mai", formation.getNomFormation(), monModule.getNomModule(), true, false);
       ArrayList <Cours_Reservation> array = new ArrayList ();
       array.add(cours);
       Planning plann = new Planning (array, formation);
       MethodesPourFichier.ecriture(plann);
    }

//    /**
//     * Test of lecture method, of class MethodesPourFichier.
//     */
//    @Test
//    public void testLecture() {
//        System.out.println("lecture");
//        File fichier = null;
//        Object expResult = null;
//        Object result = MethodesPourFichier.lecture(fichier);
//        assertEquals(expResult, result);
//    }
    
}
