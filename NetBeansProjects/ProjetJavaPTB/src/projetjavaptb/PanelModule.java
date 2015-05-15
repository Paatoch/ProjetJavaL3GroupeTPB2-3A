/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class PanelModule extends JPanel implements ActionListener {

    JPanel panelModule = new JPanel();
    ArrayList<JTextField> listModulesName = new ArrayList<>();
    ArrayList<JTextField> listModulesDuree = new ArrayList<>();
    ArrayList<JTextField> listAbreviation = new ArrayList<>();
    ArrayList<JButton> listBoutonCouleur = new ArrayList<>();
    ArrayList<JCheckBox> listCheckBox = new ArrayList<>();
    ArrayList <Color> listCouleur = new ArrayList <> ();
    
    String temp;
    Color couleur;
    String abreviation;

    public PanelModule() {

        panelModule.setBorder(new TitledBorder("Ajout de module a la formation"));
        panelModule.setBackground(Color.GRAY);
        panelModule.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();
        int lesModules = 0;
        int yi = 1;

        contraintes.gridy = 0;
        contraintes.gridx = 0;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblNomModule = new JLabel ("Nom du module");
        panelModule.add(lblNomModule, contraintes);
        contraintes.gridy = 0;
        contraintes.gridx = 1;
         contraintes.fill = GridBagConstraints.HORIZONTAL;
        JLabel abvModule = new JLabel ("Abreviation du module");
        panelModule.add(abvModule, contraintes);
        JLabel lblnbSeancesModule = new JLabel ("Nombre de séances du module");
        contraintes.gridy = 0;
        contraintes.gridx = 2;
        panelModule.add(lblnbSeancesModule, contraintes);
        JLabel lblCouleurModule = new JLabel ("Couleur Module");
        contraintes.gridy = 0;
        contraintes.gridx = 4;
        panelModule.add(lblCouleurModule, contraintes);
        
        //Début de la boucle sur chaque formation
        for (Module unModule : Global.planning.getListePlanningF().getModule()) {
            contraintes.gridy = yi;
            contraintes.gridx = 0;
            listCouleur.add(unModule.getCouleurModule());
            listModulesName.add(new JTextField(unModule.getNomModule()));
            listModulesName.get(lesModules).addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent fe) {
                    for (JTextField search : listModulesName) {
                        if (fe.getSource().equals(search)) {
                            temp = search.getText();
                        }
                    }
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    int i = 0;
                    for (JTextField search : listModulesName) {
                        if (fe.getSource().equals(search)) {
                            if (temp != search.getText()) {
                                int dureeModule = Global.planning.getListePlanningF().getModule().get(i).getNbSeances();
                                couleur = Global.planning.getListePlanningF().getModule().get(i).getCouleurModule();
                                abreviation = Global.planning.getListePlanningF().getModule().get(i).getAbreviation();
                                Module leModule1 = new Module(search.getText(), dureeModule, couleur, abreviation);
                                Global.planning.getListePlanningF().getModule().set(i, leModule1);
                            }
                        }
                        i++;
                    }
                }
            });
            listModulesName.get(lesModules).setPreferredSize(new Dimension(100, 30));
            contraintes.fill = GridBagConstraints.HORIZONTAL;
            panelModule.add(listModulesName.get(lesModules), contraintes);
            
            JTextField uneAbreviation = new JTextField(unModule.getAbreviation());
            uneAbreviation.setEnabled(false);
            listAbreviation.add(uneAbreviation);
            contraintes.gridy = yi;
            contraintes.gridx = 1;
            contraintes.fill = GridBagConstraints.HORIZONTAL;
            panelModule.add(listAbreviation.get(yi-1), contraintes);
            
            contraintes.gridy = yi;
            contraintes.gridx = 2;
            listModulesDuree.add(new JTextField(Integer.toString(unModule.getNbSeances())));
            listModulesDuree.get(lesModules).addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent fe) {
                    for (JTextField search : listModulesDuree) {
                        if (fe.getSource().equals(search)) {
                            temp = search.getText();
                        }
                    }
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    int i = 0;
                    for (JTextField search : listModulesDuree) {
                        if (fe.getSource().equals(search)) {
                            if (!temp.equals(search.getText())) {
                                try {
                                    String nomModule = Global.planning.getListePlanningF().getModule().get(i).getNomModule();
                                    couleur = Global.planning.getListePlanningF().getModule().get(i).getCouleurModule();
                                    abreviation = Global.planning.getListePlanningF().getModule().get(i).getAbreviation();
                                    Module leModule1 = new Module(nomModule, Integer.parseInt(search.getText()), couleur, abreviation);
                                    Global.planning.getListePlanningF().getModule().set(i, leModule1);
                                } catch (NumberFormatException e) {
                                    search.setText(temp);
                                }

                            }
                        }
                        i++;
                    }
                }
            });
            listModulesDuree.get(lesModules).setPreferredSize(new Dimension(40, 30));
            contraintes.fill = GridBagConstraints.HORIZONTAL;
            panelModule.add(listModulesDuree.get(lesModules), contraintes);
            
            JCheckBox chkButton = new JCheckBox();
            chkButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int tempI = 0;
                    for (JCheckBox search : listCheckBox) {
                        if (ae.getSource().equals(search)) {
                            listBoutonCouleur.get(tempI).setEnabled(true);
                        }
                        else
                        {
                            search.setEnabled(false);
                            listBoutonCouleur.get(tempI).setSelected(false);
                        }
                        tempI++;
                    }
                }
            });
            chkButton.setSelected(false);
            listCheckBox.add(chkButton);
            contraintes.gridy = yi;
            contraintes.gridx = 3;
            contraintes.fill = GridBagConstraints.HORIZONTAL;
            panelModule.add(chkButton, contraintes);
            
            JButton monBoutton = new JButton("Couleur");
            monBoutton.setEnabled(false);
            monBoutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int tempI = 0;
                    for (JButton search : listBoutonCouleur) {
                        if (ae.getSource().equals(search)) {
                            if(search.isEnabled())
                            {
                                try {
                                    Color couleur = JColorChooser.showDialog(null, "couleur du fond", Color.WHITE);
                                    listCouleur.set(tempI, couleur);
                                    JOptionPane.showMessageDialog(panelModule, "Couleur choisie");
                                    for(JCheckBox x : listCheckBox) 
                                    {
                                        x.setEnabled(true);
                                        x.setSelected(false);
                                    }
                                    search.setEnabled(false);
                                    validate();
                                    repaint();
                                }
                                catch (NullPointerException ex){

                                }
                            }
                        }
                        tempI++;
                    }
                }
            });
            listBoutonCouleur.add(monBoutton);
            contraintes.gridy = yi;
            contraintes.gridx = 4;
            contraintes.fill = GridBagConstraints.HORIZONTAL;
            panelModule.add(monBoutton, contraintes);

            //listCouleur.add(new JLabel());
            yi++;
            lesModules++;
        }
        add(panelModule);
        setVisible(true);
        validate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
