/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Benjamin Tabet
 */
public class Cours_ReservationTest {

    
    public Cours_ReservationTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * Test of getJour method, of class Cours_Reservation.
     */
    @Test
    public void testGetJour() {
        System.out.println("*****************");
        System.out.println("Test : getJour");
        Cours_Reservation instance = new Cours_Reservation();
        instance.setJour(26);
        int expResult = 26;
        int result = instance.getJour();
        assertEquals(expResult, result);
    }

    /**
     * Test of setJour method, of class Cours_Reservation.
     */
    @Test
    public void testSetJour() {
        System.out.println("*****************");
        System.out.println("Test : setJour");
        int jour = 26;
        Cours_Reservation instance = new Cours_Reservation();
        instance.setJour(jour);
        assertEquals(instance.getJour(), jour);
    }

    /**
     * Test of getAnnee method, of class Cours_Reservation.
     */
    @Test
    public void testGetAnnee() {
        System.out.println("*****************");
        System.out.println("Test : getAnnee");
        Cours_Reservation instance = new Cours_Reservation();
        instance.setAnnee(1994);
        int expResult = 1994;
        int result = instance.getAnnee();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnnee method, of class Cours_Reservation.
     */
    @Test
    public void testSetAnnee() {
        System.out.println("*****************");
        System.out.println("Test : setAnnee");
        int annee = 1994;
        Cours_Reservation instance = new Cours_Reservation();
        instance.setAnnee(annee);
        assertEquals(instance.getAnnee(), annee);
    }

    /**
     * Test of getMois method, of class Cours_Reservation.
     */
    @Test
    public void testGetMois() {
        System.out.println("*****************");
        System.out.println("Test : getMois");
        Cours_Reservation instance = new Cours_Reservation();
        instance.setMois("octobre");
        String expResult = "octobre";
        String result = instance.getMois();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMois method, of class Cours_Reservation.
     */
    @Test
    public void testSetMois() {
        System.out.println("*****************");
        System.out.println("Test : setMois");
        String mois = "octobre";
        Cours_Reservation instance = new Cours_Reservation();
        instance.setMois(mois);
        assertEquals(instance.getMois(), mois);
    }

    /**
     * Test of getFormation method, of class Cours_Reservation.
     */
    @Test
    public void testGetFormation() {
        System.out.println("*****************");
        System.out.println("Test : getFormation");
        Cours_Reservation instance = new Cours_Reservation();
        String expResult = "Miage";
        instance.setFormation("Miage");
        String result = instance.getFormation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFormation method, of class Cours_Reservation.
     */
    @Test
    public void testSetFormation() {
        System.out.println("*****************");
        System.out.println("Test : setFormation");
        String formation = "Miage";
        Cours_Reservation instance = new Cours_Reservation();
        instance.setFormation(formation);
        assertEquals(instance.getFormation(), formation);
    }

    /**
     * Test of getModule method, of class Cours_Reservation.
     */
    @Test
    public void testGetModule() {
        System.out.println("*****************");
        System.out.println("Test : getModule");
        Cours_Reservation instance = new Cours_Reservation();
        instance.setModule("programmation");
        String expResult = "programmation";
        String result = instance.getModule();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModule method, of class Cours_Reservation.
     */
    @Test
    public void testSetModule() {
        System.out.println("*****************");
        System.out.println("Test : setModule");
        String module = "programmation";
        Cours_Reservation instance = new Cours_Reservation();
        instance.setModule(module);
        assertEquals(module, instance.getModule());
    }

    /**
     * Test of isMatin method, of class Cours_Reservation.
     */
    @Test
    public void testIsMatin() {
        System.out.println("*****************");
        System.out.println("Test : isMatin");
        Cours_Reservation instance = new Cours_Reservation();
        instance.setMatin(false);
        boolean expResult = false;
        boolean result = instance.isMatin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMatin method, of class Cours_Reservation.
     */
    @Test
    public void testSetMatin() {
        System.out.println("*****************");
        System.out.println("Test : setMatin");
        boolean matin = false;
        Cours_Reservation instance = new Cours_Reservation();
        instance.setMatin(matin);
        assertEquals(matin, instance.isMatin());
    }

    /**
     * Test of isMidi method, of class Cours_Reservation.
     */
    @Test
    public void testIsMidi() {
        System.out.println("*****************");
        System.out.println("Test : isMidi");
        Cours_Reservation instance = new Cours_Reservation();
        instance.setMidi(false);
        boolean expResult = false;
        boolean result = instance.isMidi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMidi method, of class Cours_Reservation.
     */
    @Test
    public void testSetMidi() {
        System.out.println("*****************");
        System.out.println("Test : setMidi");
        boolean midi = false;
        Cours_Reservation instance = new Cours_Reservation();
        instance.setMidi(midi);
        assertEquals(instance.isMidi(), midi);
    }

    /**
     * Test of toString method, of class Cours_Reservation.
     */
    @Test
    public void testToString() {
        System.out.println("*****************");
        System.out.println("Test : toString");
        Cours_Reservation instance = new Cours_Reservation();
        instance.setFormation("Miage");
        instance.setModule("programmation");
        String expResult = instance.getFormation() + "\n" + instance.getModule() ;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class Cours_Reservation.
     * On vérifie que la comparaison a bien fonctionné entre les deux cours 
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Cours_Reservation cours1 = new Cours_Reservation(1, 2015, "octobre", "esiag", "informatique", false, true);
        Cours_Reservation instance = new Cours_Reservation(2, 2015, "octobre", "esiag", "informatique", false, true);
        boolean expResult = false;
        boolean result = instance.compare(cours1);
        assertEquals(expResult, result);
    }

    /**
     * Test of copyCours method, of class Cours_Reservation.
     * on test le fait que l'annee du cours ait bien été copié dans l'autre cours
     */
    @Test
    public void testCopyCours() {
        System.out.println("copyCours");
        Cours_Reservation unCours = new Cours_Reservation(1, 2015, "octobre", "esiag", "informatique", false, true);
        Cours_Reservation instance = new Cours_Reservation();
        instance.copyCours(unCours);
        assertEquals(unCours.getAnnee(), instance.getAnnee());
    }

    /**
     * Test of clear method, of class Cours_Reservation.
     * On test le fait que l'année ait bien été remise a zéro aprtès l'appel de la fonction
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Cours_Reservation instance = new Cours_Reservation(1, 2015, "octobre", "esiag", "informatique", false, true);
        instance.clear();
        assertEquals(instance.getAnnee(), 0);
    }


    
}
