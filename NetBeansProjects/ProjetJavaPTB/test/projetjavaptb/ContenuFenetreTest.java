/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
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
public class ContenuFenetreTest {

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
     * Test of setPanelCalendrier method, of class ContenuFenetre.
     */
//    @Test
//    public void testSetPanelCalendrier() {
//        System.out.println("setPanelCalendrier");
//        JPanel panelCalendrier = null;
//        ContenuFenetre instance = new ContenuFenetre();
//        instance.setPanelCalendrier(panelCalendrier);
//    }

    /**
     * Test of Affiche method, of class ContenuFenetre.
     */
    @Test
    public void testAffiche() {
        System.out.println("Affiche");
        String moment1 = "new";
        ContenuFenetre instance = new ContenuFenetre();
        instance.Affiche(moment1);
        boolean expResult1 = false;
        boolean result1 = instance.lblMois.isVisible();
//      Test sur la visibilité des éléments à afficher
        assertEquals(expResult1, result1); 
    }

    /**
     * Test of RemplitLabel method, of class ContenuFenetre.
     */
    @Test
    public void testRemplitLabel() {
        System.out.println("RemplitLabel");
        String moment = "";
        ContenuFenetre instance = new ContenuFenetre();
        instance.RemplitLabel(moment);
        Icon iconPre = instance.lblPre.getIcon();
        String nomIconPre = iconPre.toString();
        String expNomIconPre = "Images/prev.png";
        assertEquals(nomIconPre, expNomIconPre);
        Icon iconSuiv = instance.lblSuiv.getIcon();
        String nomIconSuiv = iconSuiv.toString();
        String expNomIconSuiv = "Images/next.png";
        assertEquals(nomIconSuiv, expNomIconSuiv);        
    }

    /**
     * Test of setPanelCalendrier method, of class ContenuFenetre.
     */
    @Test
    public void testSetPanelCalendrier() {
        System.out.println("setPanelCalendrier");
        JPanel panelCalendrier = new JPanel();
        ContenuFenetre instance = new ContenuFenetre();
        instance.setPanelCalendrier(panelCalendrier);
        System.out.println(panelCalendrier);
        System.out.println(instance.getPanelCalendrier());
        assertEquals(instance.getPanelCalendrier(), panelCalendrier);
    }

    /**
     * Test of FabriqueCalendrier method, of class ContenuFenetre.
     */
    @Test
    public void testFabriqueCalendrier() {
        System.out.println("FabriqueCalendrier");
        int annee = 0;
        int mois = 0;
        ContenuFenetre instance = new ContenuFenetre();
        instance.FabriqueCalendrier(annee, mois);
    }

    /**
     * Test of StatFabriqueCal method, of class ContenuFenetre.
     */
    @Test
    public void testStatFabriqueCal() {
        System.out.println("StatFabriqueCal");
        int annee = 2015;
        int mois = 10;
//        ContenuFenetre.StatFabriqueCal(annee, mois);
        
    }

    /**
     * Test of Repaint method, of class ContenuFenetre.
     */
    @Test
    public void testRepaint() {
        System.out.println("Repaint");
        int annee = 0;
        int mois = 0;
        ContenuFenetre.Repaint(annee, mois);
    }

    /**
     * Test of getPanelCalendrier method, of class ContenuFenetre.
     */
    @Test
    public void testGetPanelCalendrier() {
        System.out.println("getPanelCalendrier");
        ContenuFenetre instance = new ContenuFenetre();
        JPanel expResult = null;
        JPanel result = instance.getPanelCalendrier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPanelHaut method, of class ContenuFenetre.
     */
    @Test
    public void testGetPanelHaut() {
        System.out.println("getPanelHaut");
        ContenuFenetre instance = new ContenuFenetre();
        JPanel expResult = null;
        JPanel result = instance.getPanelHaut();
        assertEquals(expResult, result);
    }

    /**
     * Test of getComboAnnee method, of class ContenuFenetre.
     */
    @Test
    public void testGetComboAnnee() {
        System.out.println("getComboAnnee");
        ContenuFenetre instance = new ContenuFenetre();
        JComboBox expResult = null;
        JComboBox result = instance.getComboAnnee();
        assertEquals(expResult, result);
    }
}

  
