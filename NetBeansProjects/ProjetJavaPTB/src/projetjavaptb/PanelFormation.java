/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private JLabel lblModuleHeure = new JLabel("Nombre d'heures du module");

    ArrayList<JTextField> textFieldModule = new ArrayList<JTextField>();
    ArrayList<JTextField> textFieldNbHeureTypeModule = new ArrayList<JTextField>();

    private JButton boutonAjouter = new JButton("Ajouter Formation");
    private boolean bool_Reponse;
    int i = 1;
    JPanel panelFormation = new JPanel();
    JPanel panelBoutons = new JPanel ();
    JPanel panelNoms = new JPanel ();

    
    JLabel labelTeddy = new JLabel (" Teddy Blonbou  -   ");
    JLabel labelPatrick = new JLabel ("Patrick Cabral  -   ");
    JLabel labelBenjamin = new JLabel ("Benjamin Tabet    ");
    
    public PanelFormation() {
        final File fichier = new File("sauvegarde/sauvegarde");
        if (fichier.length() != 0) {
            MethodesPourFichier.lecture(fichier);
            System.out.println("lecture planning");
        } else {
            System.out.println("init planning");
        }
     
        // Ajout des elements au panel`
        //this.add(label, contraintes);
        this.setLayout (new BorderLayout ());
        panelFormation.setBorder(new TitledBorder("Formation"));
        panelFormation.setBackground(Color.GRAY);
        //panelFormation.setPreferredSize(new Dimension(500, 400));
        panelFormation.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();

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

        contraintes.gridx = 0;
        contraintes.gridy = 2;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(lblModule, contraintes);

        contraintes.gridx = 1;
        contraintes.gridy = 2;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        JTextField text = new JTextField();
        textFieldModule.add(text);
        text.setPreferredSize(new Dimension(100, 30));
        panelFormation.add(textFieldModule.get(0), contraintes);

        contraintes.gridx = 2;
        contraintes.gridy = 2;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(lblModuleHeure, contraintes);

        contraintes.gridx = 3;
        contraintes.gridy = 2;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        JTextField textHeure = new JTextField();
        textFieldNbHeureTypeModule.add(textHeure);
        textHeure.setPreferredSize(new Dimension(100, 30));
        panelFormation.add(textFieldNbHeureTypeModule.get(0), contraintes);

        contraintes.gridx = 1;
        contraintes.gridy = 4;

        panelBoutons.setLayout(new FlowLayout());
        boutonAjouter.addActionListener(this);
        //panelFormation.add(boutonAjouter, contraintes);
        panelBoutons.add(boutonAjouter);

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
                String nomFormation = textFieldNomFormation.getText();
                String nbHeureTypeS = textFieldNbHeureTypeSeance.getText();
                Float nbHeureType = Float.parseFloat(nbHeureTypeS);
                Float nbHeureModule = null;
                String nomModule = null;
                String nbHeureModules = null;
                //System.out.println(nomFormation + " " + nbHeureType);
                ArrayList<String> ArrayString = new ArrayList<String>();
                Formation formation = new Formation(nomFormation, nbHeureType);

                int i = 0;
                for (JTextField text : textFieldModule) {
                    for (JTextField text2 : textFieldNbHeureTypeModule) {
                        if (text.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(panelFormation, "Veuillez renseigner une formation");
                        } else {
                            nomModule = text.getText();
                            ArrayString.add(text2.getText());
                            nbHeureModules = text2.getText();
                            nbHeureModule = Float.parseFloat(nbHeureModules);
                        }
                    }
                    Module module = new Module(nomModule, Float.parseFloat(ArrayString.get(i)));
                    i++;
                    formation.addModule(module);
                }
                MethodesPourFichier.ecriture(formation, fichier);
                System.out.println(formation);
            }
        });

        panelBoutons.add(lblValider);
        //lblValider.setPreferredSize(new Dimension (20,50));
        contraintes.gridx = 1;
        contraintes.gridy = 5;
        //panelFormation.setPreferredSize(new Dimension (400,500));
        
        panelNoms.add(labelTeddy);
        panelNoms.add(labelPatrick);
        panelNoms.add(labelBenjamin);
        
        add(panelFormation, BorderLayout.NORTH);
        add(panelBoutons, BorderLayout.CENTER);
        add(panelNoms, BorderLayout.SOUTH);
        
        labelBenjamin.setFont(new Font("Arial",Font.BOLD,14));
        labelTeddy.setFont(new Font("Arial",Font.BOLD,14));
        labelPatrick.setFont(new Font("Arial",Font.BOLD,14));
        setVisible(true);
        validate();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == (boutonAjouter)) {

            int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous ajouter une formation?", "Ajout", JOptionPane.YES_NO_CANCEL_OPTION);
            if (reponse == JOptionPane.YES_OPTION) {
                // while (bool_Reponse = true) {
                JTextField field = new JTextField();

                textFieldModule.add(field);
                JTextField fieldHeure = new JTextField();

                textFieldNbHeureTypeModule.add(fieldHeure);

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
                panelFormation.add(new JLabel("Nombre d'heures du module"), contraintes);

                contraintes.gridx = 3;
                contraintes.gridy = 3 + i;
                contraintes.fill = GridBagConstraints.HORIZONTAL;
                fieldHeure.setPreferredSize(new Dimension(100, 30));
                panelFormation.add(fieldHeure, contraintes);

                validate();
                repaint();
                i++;
                //  }

            } else {
                bool_Reponse = false;
            }
        } else {

        }
    }

}
