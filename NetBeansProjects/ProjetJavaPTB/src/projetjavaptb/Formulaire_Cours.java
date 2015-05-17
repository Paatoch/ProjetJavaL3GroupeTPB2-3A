/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import Exception.Exception_Module;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static projetjavaptb.Global.planning;

/**
 *
 * @author patrickcabral
 */
public class Formulaire_Cours extends JFrame implements ActionListener {

    private int jour, annee;
    public boolean matin, midi;
    private String mois;
    public JPanel panelFormulaire = new JPanel(new GridBagLayout());
    public JPanel panelWarning = new JPanel();

    private JLabel labelFormation = new JLabel();
    private JComboBox comboModules = new JComboBox();
    private JLabel labelDate = new JLabel();
    private JLabel horaire = new JLabel();

    private JButton boutonValiderCours = new JButton("Valider");
    private JButton boutonSupprimerCours = new JButton("Supprimer");
    private JButton boutonAnnuler = new JButton("Annuler");
    String moduleSelect;

    public Formulaire_Cours(int jour_cours, int annee_cours, String mois_cours, String horaire) {
        setLayout(new FlowLayout());
        this.jour = jour_cours;
        this.annee = annee_cours;
        this.mois = mois_cours;
        labelDate.setText(jour + "  " + mois + "  " + "  " + annee);
        labelFormation.setText(Global.planning.getListePlanningF().getNomFormation());
        String selectComboBox = "nOn";

        this.horaire.setText(horaire);
        for (Cours_Reservation ceCours : Global.planning.getListePlanningC()) {
            System.out.println("jour" + jour + "cejour" + ceCours.getJour());
            System.out.println(" mois" + mois + " cemois" + ceCours.getMois());
            System.out.println(" annee" + annee + " cetteAnnee" + ceCours.getAnnee());

            if (jour == ceCours.getJour() && mois.equals(ceCours.getMois()) && annee == ceCours.getAnnee()) {
                System.out.println("TestTest2");
                if (horaire.equals("matin")) {
                    System.out.println("TestTest2");
                    matin = true;
                    midi = false;
                    if (ceCours.isMatin()) {
                        selectComboBox = ceCours.getModule();
                    }
                } else if (horaire.equals("midi")) {
                    System.out.println("TestTest3");
                    midi = true;
                    matin = false;
                    selectComboBox = ceCours.getModule();
                }
            }
        }

        for (Module unModule : Global.planning.getListePlanningF().getModule()) {
            comboModules.addItem(unModule.getNomModule());
        }
        if (!selectComboBox.equals("nOn")) {
            comboModules.setSelectedItem(selectComboBox);
        }

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        panelFormulaire.add(labelDate, c);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        panelFormulaire.add(this.horaire, c);
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        panelFormulaire.add(labelFormation, c);
        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        panelFormulaire.add(comboModules, c);
        c.gridx = 0;
        c.gridy = 4;
        c.fill = GridBagConstraints.HORIZONTAL;

        /* verif si c'est le matin ou l'après midi */
        if (horaire.equals("matin")) {
            System.out.println("TestTest2");
            matin = true;
            midi = false;
        } else if (horaire.equals("midi")) {
            System.out.println("TestTest3");
            midi = true;
            matin = false;
        }
        panelFormulaire.add(boutonValiderCours, c);
        c.gridx = 0;
        c.gridy = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        panelFormulaire.add(boutonSupprimerCours, c);
        c.gridx = 0;
        c.gridy = 6;
        c.fill = GridBagConstraints.HORIZONTAL;
        panelFormulaire.add(boutonAnnuler, c);
        boutonValiderCours.addActionListener(this);
        boutonSupprimerCours.addActionListener(this);
        boutonAnnuler.addActionListener(this);
        // Ajout informations fenetre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Formulaire ajout cours");
        this.setLocationRelativeTo(null);
        this.add(panelFormulaire);
        this.add(panelWarning);
        this.setSize(180, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i, leMois;
        i = 0;
        leMois = 0;
        for (String unmois : Global.listeMois) {
            if (unmois.equals(mois)) {
                leMois = i;
            }
            i++;
        }
        if (e.getSource() == boutonValiderCours) {
            moduleSelect = comboModules.getSelectedItem().toString();
            Cours_Reservation cours = new Cours_Reservation(jour, annee, mois, Global.planning.getListePlanningF().getNomFormation(), moduleSelect, matin, midi);
                if (verifCours()) {
                    Global.planning.getListePlanningC().add(cours);
                    ContenuFenetre.Repaint(annee, leMois);
                    dispose();
                    Calendrier.Defaire.setEnabled(true);
                    Calendrier.tempCoursDefaire.copyCours(cours);
                } 
                else {
                    panelWarning.removeAll();
                    JLabel Attention = new JLabel("<html>Le nombre de cours <br/> pour ce module ne <br/>peut pas être dépassé <br/>veuillez changer de module</html>");
                    Attention.setForeground(Color.RED);
                    panelWarning.add(Attention);
                    repaint();
                    revalidate();
                }
        } 
        else {
            if (e.getSource() == boutonSupprimerCours) {
                Cours_Reservation cours = Global.planning.getCours(jour, annee, mois, matin, midi);
                if (cours != null) {
                    Global.planning.getListePlanningC().remove(cours);
                }
                ContenuFenetre.Repaint(annee, leMois);
                dispose();
            }
            else dispose();
        }
    }
    
    public boolean verifCours()
    {
        int nbModuleMax;
        nbModuleMax = Global.planning.getListePlanningF().getModule(moduleSelect).getNbSeances();
        int i = 0;
        for(Cours_Reservation cours : Global.planning.getListePlanningC())
        {
            if(cours.getModule().equals(moduleSelect)) i++;
        }
        if(i<nbModuleMax) return true;
        else return false;

    }

}
