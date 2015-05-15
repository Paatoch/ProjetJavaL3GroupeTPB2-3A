/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author patrickcabral
 */
public class Formulaire_Cours extends JFrame implements ActionListener {

    private int jour, annee;
    public boolean matin, midi;
    private String mois;
    public JPanel panelFormulaire = new JPanel(new GridBagLayout());

    private JLabel labelFormation = new JLabel();
    private JComboBox comboModules = new JComboBox();
    private JLabel labelDate = new JLabel();
    private JLabel horaire = new JLabel();

    private JButton boutonValiderCours = new JButton("Valider");

    public Formulaire_Cours(int jour_cours, int annee_cours, String mois_cours, String horaire) {
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
        boutonValiderCours.addActionListener(this);
        // Ajout informations fenetre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Formulaire ajout cours");
        this.setSize(150, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelFormulaire);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cours_Reservation cours = new Cours_Reservation(jour, annee, mois, Global.planning.getListePlanningF().getNomFormation(), comboModules.getSelectedItem().toString(), matin, midi);
        System.out.println(cours);
        Global.planning.getListePlanningC().add(cours);
        dispose();
    }

}
