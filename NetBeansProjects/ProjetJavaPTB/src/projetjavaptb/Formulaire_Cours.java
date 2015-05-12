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
import java.util.ArrayList;
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
public class Formulaire_Cours extends JFrame implements ActionListener {

    private int jour, annee;
    private String mois;
    public JPanel panelFormulaire = new JPanel(new GridBagLayout());

    private JLabel labelFormation = new JLabel();
    private JComboBox comboModules = new JComboBox();
    private JLabel labelDate = new JLabel();

    private JCheckBox checkMatin = new JCheckBox("Matin");
    private JCheckBox checkAprem = new JCheckBox("Après-Midi");

    private JButton boutonValiderCours = new JButton("Valider");
    private Formation uneFormation = new Formation();
    private ArrayList<Cours_Reservation> listeCours = new ArrayList<Cours_Reservation>();
    private JPanel laFenetrePrincipal = new JPanel();
    
    public Formulaire_Cours(int jour_cours, int annee_cours, String mois_cours, final Formation formation, final ArrayList <Cours_Reservation> lesCours, String horaire, final JPanel contentPanel) {
        laFenetrePrincipal = contentPanel;
        listeCours = lesCours;
        uneFormation = formation;
        this.jour = jour_cours;
        this.annee = annee_cours;
        this.mois = mois_cours;
        labelDate.setText(jour + "  " + mois + "  " + "  " + annee);
        labelFormation.setText(formation.getNomFormation());
        String selectComboBox = "nOn";
        
        for(Cours_Reservation ceCours : listeCours)
        {
            if(jour == ceCours.getJour() && mois == ceCours.getMois() && annee == ceCours.getAnnee())
            {
                if(horaire == "matin")
                {
                    if(ceCours.isMatin()) 
                    {
                        selectComboBox = ceCours.getModule();
                        checkMatin.setSelected(true);
                    }
                }
                else if(ceCours.isMidi()){
                    selectComboBox = ceCours.getModule();
                    checkAprem.setSelected(true);
                }
            }
        }
        
        for (Module unModule : formation.getModule()) {
            comboModules.addItem(unModule.getNomModule());
        }
        if(!selectComboBox.equals("nOn"))   comboModules.setSelectedItem(selectComboBox);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy= 0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        panelFormulaire.add(labelDate, c);
        c.gridx = 0;
        c.gridy= 1;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.anchor = GridBagConstraints.CENTER;
        panelFormulaire.add(labelFormation,c);
        c.gridx = 0;
        c.gridy= 2;
         c.fill = GridBagConstraints.HORIZONTAL;
        panelFormulaire.add(comboModules, c);
        c.gridx = 0;
        c.gridy= 3; c.fill = GridBagConstraints.HORIZONTAL;
        panelFormulaire.add(checkMatin, c);
        c.gridx = 0;
        c.gridy= 3; 
        c.fill = GridBagConstraints.HORIZONTAL;
        panelFormulaire.add(checkAprem,c);
        c.gridx = 0;
        c.gridy= 4; 
        c.fill = GridBagConstraints.HORIZONTAL;
        
        if(horaire=="matin") checkAprem.setVisible(false);
        else checkMatin.setVisible(false);
        
        panelFormulaire.add(boutonValiderCours,c);
        boutonValiderCours.addActionListener(this);
        // Ajout informations fenetre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Formulaire ajout cours");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelFormulaire);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Cours_Reservation cours = new Cours_Reservation(jour, annee, mois, uneFormation.getNomFormation(), comboModules.getSelectedItem().toString(),checkMatin.isSelected(),checkAprem.isSelected());
        listeCours.add(cours);
        laFenetrePrincipal.repaint();
        laFenetrePrincipal.validate();
        dispose();
    }

}
