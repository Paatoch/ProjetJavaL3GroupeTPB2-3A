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
import javax.swing.JLabel;
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
    ArrayList<JButton> listBoutonCouleur = new ArrayList<>();
    ArrayList <Color> listCouleur = new ArrayList <> ();
   
    String temp;
    Color couleur;
    String abreviation;

    public PanelModule(final Formation formation) {

        panelModule.setBorder(new TitledBorder("Modules par formations"));
        panelModule.setBackground(Color.GRAY);
        panelModule.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();
        int lesModules = 0;
        int yi = 0;

        //Début de la boucle sur chaque formation
        for (Module unModule : formation.getModule()) {
            contraintes.gridy = yi;
            contraintes.gridx = 0;
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
                                int dureeModule = formation.getModule().get(i).getNbSeances();
                                couleur = formation.getModule().get(i).getCouleurModule();
                                abreviation = formation.getModule().get(i).getAbreviation();
                                Module leModule1 = new Module(search.getText(), dureeModule, couleur, abreviation);
                                formation.getModule().set(i, leModule1);
                            }
                        }
                        i++;
                    }
                }
            });
            listModulesName.get(lesModules).setPreferredSize(new Dimension(100, 30));
            contraintes.fill = GridBagConstraints.HORIZONTAL;
            panelModule.add(listModulesName.get(lesModules), contraintes);
            contraintes.gridy = yi;
            contraintes.gridx = 1;
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
                                    String nomModule = formation.getModule().get(i).getNomModule();
                                    couleur = formation.getModule().get(i).getCouleurModule();
                                    abreviation = formation.getModule().get(i).getAbreviation();
                                    Module leModule1 = new Module(nomModule, Integer.parseInt(search.getText()), couleur, abreviation);
                                    formation.getModule().set(i, leModule1);
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
