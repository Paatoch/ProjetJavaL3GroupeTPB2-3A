/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author patrickcabral
 */
public class Formulaire_Cours extends JFrame implements ActionListener{
    private int jour, annee;
    private String mois ;
    public JPanel panelFormulaire = new JPanel (new GridBagLayout());
    
    private JLabel labelFormation = new JLabel ();
    private JComboBox comboModules = new JComboBox ();
    private JLabel labelDate = new JLabel ();
    
    private JCheckBox checkMatin = new JCheckBox ("Matin");
    private JCheckBox checkAprem = new JCheckBox ("Après-Midi");
    
    private JButton boutonValiderCours = new JButton ("Valider");
    
    public Formulaire_Cours(int jour_cours, int annee_cours, String mois_cours, final Formation formation) {
        this.jour = jour_cours;
        this.annee = annee_cours;
        this.mois = mois_cours;
        
        labelDate.setText( jour + "  " + mois + "  " + "  " + annee);
        
        panelFormulaire.add(labelDate);
        labelFormation.setText(formation.nomFormation);
        panelFormulaire.add(labelFormation);
        addItems (formation);
        
        panelFormulaire.add(comboModules);
        
        panelFormulaire.add(checkMatin);
        panelFormulaire.add(checkAprem);
        
        boutonValiderCours.addActionListener(this);
        // Ajout informations fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Formulaire ajout cours");
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelFormulaire);
        this.setVisible(true);
        
    }
    
    public void addItems (Formation formation){
        
        for (Module unModule : formation.getModule()) {
               comboModules.addItem(unModule.getNomModule());
            }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
}
