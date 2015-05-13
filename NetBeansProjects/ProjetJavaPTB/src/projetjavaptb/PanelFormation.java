/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class PanelFormation extends JPanel implements ActionListener {

    private JTextField textFieldNbHeureTypeSeance = new JTextField();
    private JTextField textFieldNomFormation = new JTextField();
    private JLabel lblNomFormation = new JLabel("Nom de la formation");
    private JLabel lblNbHeureTypeSeance = new JLabel("Nombre d'heures type pour une séance");
    private JLabel lblValider = new JLabel();
    ImageIcon iconValidate = new ImageIcon("Images/validate.png");
    private JLabel lblModule = new JLabel("Nom du module");
    private JLabel lblModuleHeure = new JLabel("Nombre de seances du module");

    ArrayList<JTextField> textFieldModule = new ArrayList<JTextField>();
    ArrayList<JTextField> textFieldNbHeureTypeModule = new ArrayList<JTextField>();
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ArrayList<Color> listcouleur = new ArrayList<Color>();
    private JButton boutonAjouter = new JButton("Ajouter Module");
    private boolean bool_Reponse;
    int i = 1;
    int xi = 1;
    JPanel panelFormation = new JPanel();

    String abreviation;
    Color couleurModule;

    public PanelFormation(final Formation formation) {

        // Ajout des elements au panel`
        //this.add(label, contraintes);
        panelFormation.setBorder(new TitledBorder("Formation"));
        panelFormation.setBackground(Color.GRAY);
        //panelFormation.setPreferredSize(new Dimension(500, 400));
        panelFormation.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();

        if (!formation.getModule().isEmpty()) {
            textFieldNomFormation.setText(formation.getNomFormation());
            textFieldNbHeureTypeSeance.setText(Float.toString(formation.getDureeTypeSeance()));
            textFieldNomFormation.setEditable(false);
            textFieldNbHeureTypeSeance.setEditable(false);
            textFieldNomFormation.setBackground(Color.LIGHT_GRAY);
            textFieldNbHeureTypeSeance.setBackground(Color.LIGHT_GRAY);
        }

        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(lblNomFormation, contraintes);

        contraintes.gridx = 1;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        textFieldNomFormation.setPreferredSize(new Dimension(100, 30));
        panelFormation.add(textFieldNomFormation, contraintes);

        contraintes.gridx = 2;
        contraintes.gridy = 0;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(lblNbHeureTypeSeance, contraintes);

        contraintes.gridx = 3;
        contraintes.gridy = 0;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(textFieldNbHeureTypeSeance, contraintes);

        if (!formation.getModule().isEmpty()) {
            for (Module unModule : formation.getModule()) {
                JLabel lblModuleLoop = new JLabel("Nom du module");
                contraintes.gridx = 0;
                contraintes.gridy = xi;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                panelFormation.add(lblModuleLoop, contraintes);

                JTextField txtNomModule = new JTextField(unModule.getNomModule());
                contraintes.gridx = 1;
                contraintes.gridy = xi;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                txtNomModule.setEditable(false);
                txtNomModule.setBackground(Color.LIGHT_GRAY);
                panelFormation.add(txtNomModule, contraintes);

                JLabel lblModuleHeureLoop = new JLabel("Nombre de seances du module");
                contraintes.gridx = 2;
                contraintes.gridy = xi;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                panelFormation.add(lblModuleHeureLoop, contraintes);

                JTextField txtSeanceModule = new JTextField(Float.toString(unModule.getNbSeances()));
                contraintes.gridx = 3;
                contraintes.gridy = xi;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                txtSeanceModule.setEditable(false);
                txtSeanceModule.setBackground(Color.LIGHT_GRAY);
                panelFormation.add(txtSeanceModule, contraintes);

                JButton boutonCouleur = new JButton("Couleur");
                contraintes.gridx = 4;
                contraintes.gridy = xi;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                boutonCouleur.setEnabled(false);
                panelFormation.add(boutonCouleur, contraintes);
                xi++;
                textFieldNbHeureTypeModule.add(txtSeanceModule);
                textFieldModule.add(txtNomModule);
                buttonList.add(boutonCouleur);
            }
        }

        contraintes.gridx = 0;
        contraintes.gridy = xi;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(lblModule, contraintes);

        contraintes.gridx = 1;
        contraintes.gridy = xi;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        JTextField text = new JTextField();
        textFieldModule.add(text);
        text.setPreferredSize(new Dimension(100, 30));
        panelFormation.add(textFieldModule.get(xi - 1), contraintes);

        contraintes.gridx = 2;
        contraintes.gridy = xi;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(lblModuleHeure, contraintes);

        contraintes.gridx = 3;
        contraintes.gridy = xi;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        JTextField textHeure = new JTextField();
        textFieldNbHeureTypeModule.add(textHeure);
        textHeure.setPreferredSize(new Dimension(100, 30));
        panelFormation.add(textFieldNbHeureTypeModule.get(xi - 1), contraintes);

        contraintes.gridx = 4;
        contraintes.gridy = xi;
        JButton boutonC = new JButton("Couleur");
        //contraintes.fill = GridBagConstraints.HORIZONTAL;
        buttonList.add(boutonC);
        panelFormation.add(buttonList.get(xi - 1), contraintes);

        for (JButton boutons : buttonList) {
            boutons.addActionListener(this);
        }
        boutonAjouter.addActionListener(this);
        add(boutonAjouter);

        lblValider.setIcon(iconValidate);
        lblValider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            public void mouseClicked(MouseEvent me) {

                String nomFormation = null;
                String nbHeureTypeS = null;
                Float nbHeureType = null;
                try {
                    nomFormation = textFieldNomFormation.getText();
                    System.out.println(nomFormation);
                } catch (NumberFormatException excp) {
                    JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs");
                }
                try {
                    nbHeureTypeS = textFieldNbHeureTypeSeance.getText();
                    System.out.println(nbHeureTypeS);
                    nbHeureType= Float.parseFloat(nbHeureTypeS);
                } catch (NumberFormatException excp) {
                    JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs");
                }
                Color uneCouleur = null;
                int nbSeanceModules = 0;
                
                formation.clear();
                formation.setNomFormation(nomFormation);
                formation.setDureeTypeSeance(nbHeureType);

                for (int x = 0; x < textFieldModule.size(); x++) {
                    try {
                        String nomModule = textFieldModule.get(x).getText();
                        nbSeanceModules = Integer.parseInt(textFieldNbHeureTypeModule.get(x).getText());
                        String uneAbreviation;

                        uneCouleur = listcouleur.get(x);
                        if (nomModule.length() < 2 && nomFormation.length() < 2) {
                            uneAbreviation = nomFormation;
                        } else if (nomFormation.length() < 2) {
                            uneAbreviation = nomFormation.substring(0, 1) + "-" + nomModule;
                        } else {
                            uneAbreviation = nomFormation + "-" + nomModule.substring(0, 1);
                        }

                        Module module = new Module(nomModule, nbSeanceModules, uneCouleur, uneAbreviation);
                        formation.addModule(module);

                    } catch (NumberFormatException excpetion) {
                        JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs");
                    } catch (NullPointerException exception) {
                        JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs");
                    } catch (IndexOutOfBoundsException exceptionE) {
                        JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs");

                    }

                }

            }
        });

        add(lblValider);
        //lblValider.setPreferredSize(new Dimension (20,50));
        contraintes.gridx = 1;
        contraintes.gridy = 5;

        add(panelFormation);
        setVisible(true);
        validate();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttonList.size(); i++) {
            if (e.getSource() == buttonList.get(i)) {

                try {
                    Color couleur = JColorChooser.showDialog(null, "couleur du fond", Color.WHITE);
                    listcouleur.add(couleur);
                    JOptionPane.showMessageDialog(panelFormation, "Couleur choisie");
                    buttonList.get(i).setEnabled(false);
                    validate();
                    repaint();
                } catch (NullPointerException ex) {

                }
            }

        }

        if (e.getSource() == (boutonAjouter)) {

            int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous ajouter un module?", "Ajout", JOptionPane.YES_NO_CANCEL_OPTION);
            if (reponse == JOptionPane.YES_OPTION) {
                // while (bool_Reponse = true) {
                JTextField field = new JTextField();

                textFieldModule.add(field);
                JTextField fieldHeure = new JTextField();

                textFieldNbHeureTypeModule.add(fieldHeure);

                JButton boutonC = new JButton("Couleur");
                buttonList.add(boutonC);
                panelFormation.add(textFieldModule.get(textFieldModule.size() - 1));
                GridBagConstraints contraintes = new GridBagConstraints();
                contraintes.gridx = 0;
                contraintes.gridy = 3 + i;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                panelFormation.add(new JLabel("Nom du module"), contraintes);

                contraintes.gridx = 1;
                contraintes.gridy = 3 + i;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                field.setPreferredSize(new Dimension(100, 30));
                panelFormation.add(field, contraintes);

                contraintes.gridx = 2;
                contraintes.gridy = 3 + i;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                panelFormation.add(new JLabel("Nombre de séances du module"), contraintes);

                contraintes.gridx = 3;
                contraintes.gridy = 3 + i;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                fieldHeure.setPreferredSize(new Dimension(100, 30));
                panelFormation.add(fieldHeure, contraintes);

                contraintes.gridx = 4;
                contraintes.gridy = 3 + i;

                //contraintes.fill = GridBagConstraints.HORIZONTAL;
                for (JButton boutons : buttonList) {
                    boutons.addActionListener(this);
                }
                panelFormation.add(boutonC, contraintes);

                validate();
                repaint();
                i++;

            } else {
                bool_Reponse = false;
            }
        } else {

        }
    }
    /*public void paint( Graphics g, Color couleur, int x, int y)
     {    g.setColor(couleur);
     g.fillRect(x,y,10, 20);
	
     }*/

}
