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
public class PlanningTest {
    
    public PlanningTest() {
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
     * Test of toString method, of class Planning.
     */
    @Test
    public void testToString() {
        System.out.println("*****************");
        System.out.println("Test : toString");
        ArrayList<Cours_Reservation> mesCours  = new ArrayList<Cours_Reservation>();
        Cours_Reservation unCours = new Cours_Reservation(1, 2015, "octobre", "informatique", "java", true, true);
        mesCours.add(unCours);
        Formation maFormation = new Formation("informatique", (float)0.5);
        Planning instance = new Planning(mesCours, maFormation);
        String expResult = "\n" + "[informatique" + "\n" + "java]" + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListePlanningC method, of class Planning.
     */
    @Test
    public void testGetListePlanningC() {
        System.out.println("getListePlanningC");
        ArrayList<Cours_Reservation> mesCours  = new ArrayList<Cours_Reservation>();
        Cours_Reservation unCours = new Cours_Reservation(1, 2015, "octobre", "informatique", "java", true, true);
        mesCours.add(unCours);
        Formation maFormation = new Formation("informatique", (float)0.5);
        Planning instance = new Planning(mesCours, maFormation);
        ArrayList<Cours_Reservation> result = instance.getListePlanningC();
        assertEquals(mesCours, result);
    }

    /**
     * Test of getCours method, of class Planning.
     */
    @Test
    public void testGetCours() {
        System.out.println("getCours");
        ArrayList<Cours_Reservation> mesCours  = new ArrayList<Cours_Reservation>();
        Cours_Reservation unCours = new Cours_Reservation(1, 2015, "octobre", "informatique", "java", true, true);
        mesCours.add(unCours);
        Formation maFormation = new Formation("informatique", (float)0.5);
        Planning instance = new Planning(mesCours, maFormation);
        int jour = 1;
        int annee = 2015;
        String mois = "octobre";
        boolean matin = true;
        boolean midi = true;
        String expResult = "informatique" + "\n" + "java";
        Cours_Reservation result = instance.getCours(jour, annee, mois, matin, midi);
        System.out.println("Test:OK");
    }

    /**
     * Test of setListePlanningC method, of class Planning.
     */
    @Test
    public void testSetListePlanningC() {
        System.out.println("setListePlanningC");
        ArrayList<Cours_Reservation> mesCours  = new ArrayList<Cours_Reservation>();
        ArrayList<Cours_Reservation> mesCours1  = new ArrayList<Cours_Reservation>();
        Cours_Reservation unCours = new Cours_Reservation(1, 2015, "octobre", "informatique", "java", true, true);
        mesCours1.add(unCours);
        Formation maFormation = new Formation("informatique", (float)0.5);
        Planning instance = new Planning(mesCours, maFormation);
        instance.setListePlanningC(mesCours1);
        System.out.println("test ok ");
    }

    /**
     * Test of getListePlanningF method, of class Planning.
     */
    @Test
    public void testGetListePlanningF() {
        System.out.println("getListePlanningF");
        Formation uneFormation = new Formation("java", (float)0.5);
        Planning instance = new Planning(null, uneFormation);
        Formation expResult = uneFormation;
        Formation result = instance.getListePlanningF();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListePlanningF method, of class Planning.
     */
    @Test
    public void testSetListePlanningF() {
        System.out.println("setListePlanningF");
        Formation listePlanningF =  new Formation("java", (float)0.5);
        Planning instance = new Planning(null, listePlanningF);
        instance.setListePlanningF(listePlanningF);
        assertEquals(instance.getListePlanningF(), listePlanningF);
    }


    
}
