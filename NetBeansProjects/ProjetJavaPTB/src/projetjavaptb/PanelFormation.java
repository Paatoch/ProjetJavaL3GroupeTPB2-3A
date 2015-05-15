/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JButton;
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
public class PanelFormation extends JPanel implements ActionListener {

    private JTextField textFieldNbHeureTypeSeance = new JTextField();
    private JTextField textFieldNomFormation = new JTextField("");
    private JLabel lblNomFormation = new JLabel("Nom de la formation");
    private JLabel lblNbHeureTypeSeance = new JLabel("Nombre d'heures type pour une séance");
    //private JLabel lblValider = new JLabel();
    private JButton boutonValider = new JButton("Valider formation");
    //ImageIcon iconValidate = new ImageIcon("Images/validate.png");
    private JLabel lblModule = new JLabel("Nom du module");
    private JLabel lblModuleHeure = new JLabel("Nombre de seances du module");

    ArrayList<JTextField> textFieldModule = new ArrayList<JTextField>();
    ArrayList<JTextField> textFieldNbHeureTypeModule = new ArrayList<JTextField>();
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ArrayList<Color> listcouleur = new ArrayList<Color>();
    private JButton boutonAjouter = new JButton("Ajouter Module");
    int i = 1;
    int xi = 1;
    Float nbHeure = null;
    String nomFormation = null;
    JTextField moduleEncours = null;
    JPanel panelFormation = new JPanel();
    JPanel panelBouton = new JPanel (new FlowLayout ());

    String abreviation;
    Color couleurModule;

    public PanelFormation() {
        this.setLayout(new BorderLayout ());
        // Ajout des elements au panel`
        //this.add(label, contraintes);
        panelFormation.getPreferredSize();
        panelFormation.setBorder(new TitledBorder("Formation"));
        panelFormation.setBackground(Color.GRAY);
        //panelFormation.setPreferredSize(new Dimension(500, 400));
        panelFormation.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();

        if (!Global.planning.getListePlanningF().getModule().isEmpty()) {
            nomFormation = textFieldNomFormation.getText();
            textFieldNomFormation.setText(Global.planning.getListePlanningF().getNomFormation());
            nbHeure = Global.planning.getListePlanningF().getDureeTypeSeance();
            textFieldNbHeureTypeSeance.setText(Float.toString(Global.planning.getListePlanningF().getDureeTypeSeance()));
            textFieldNomFormation.setEditable(false);
            textFieldNbHeureTypeSeance.setEditable(false);
            textFieldNomFormation.setBackground(Color.LIGHT_GRAY);
            textFieldNbHeureTypeSeance.setBackground(Color.LIGHT_GRAY);
        }
        else
        {
            
            textFieldNomFormation.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent fe) {}

                @Override
                public void focusLost(FocusEvent fe) {
                    if(textFieldNomFormation.getText() != ""){
                        nomFormation = textFieldNomFormation.getText();
                    } else
                    {
                        JOptionPane.showMessageDialog(panelFormation,"Veuillez saisir le nom de la formation");
                        textFieldNomFormation.requestFocusInWindow();
                    }
                }
            });
            
            textFieldNbHeureTypeSeance.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent fe) {}

                @Override
                public void focusLost(FocusEvent fe) {
                    try{
                        nbHeure = Float.parseFloat(textFieldNbHeureTypeSeance.getText());
                    } catch (NumberFormatException e) 
                    {
                        JOptionPane.showMessageDialog(panelFormation,"La valeur saisie n'est pas une valeur numérique");
                        textFieldNbHeureTypeSeance.requestFocusInWindow();
                    }
                }
            });
        }
        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(lblNomFormation, contraintes);

        contraintes.gridx = 1;
        contraintes.gridy = 0;
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

        if (!Global.planning.getListePlanningF().getModule().isEmpty()) {
            for (Module unModule : Global.planning.getListePlanningF().getModule()) {
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

                JTextField txtSeanceModule = new JTextField(Integer.toString(unModule.getNbSeances()));
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
                listcouleur.add(unModule.getCouleurModule());
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
        text.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent fe) {}

                @Override
                public void focusLost(FocusEvent fe) {
                    int i = 0;
                    int position = 0;
                    for (JTextField search : textFieldModule) {
                        if (fe.getSource().equals(search)) {
                            moduleEncours = search;
                            position = i;
                        }
                        i++;
                    }
                    boolean searchModule = false;
                    for (JTextField search : textFieldModule) {
                        if(moduleEncours.getText().equals(search.getText()) && !search.equals(moduleEncours)) searchModule = true;
                    }
                    if(searchModule) 
                    {
                        JOptionPane.showMessageDialog(panelFormation,"Veuillez saisir le nom de la formationCe nom de module existe deja");
                        moduleEncours.requestFocusInWindow();
                    }
                    else
                    {
                        textFieldModule.set(position, moduleEncours);
                    }
                    moduleEncours = null;
                }
            });
        text.setPreferredSize(new Dimension(100, 30));
        panelFormation.add(textFieldModule.get(xi - 1), contraintes);

        contraintes.gridx = 2;
        contraintes.gridy = xi;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        panelFormation.add(lblModuleHeure, contraintes);

        contraintes.gridx = 3;
        contraintes.gridy = xi;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        JTextField textHeure = new JTextField("");
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
        boutonValider.addActionListener(this);
        panelBouton.add(boutonAjouter);
        panelBouton.add(boutonValider);


       
        this.add(panelFormation, BorderLayout.NORTH);
        this.add(panelBouton);
        setVisible(true);
        validate();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttonList.size(); i++) {
            if (e.getSource() == buttonList.get(i)) {
                if(textFieldModule.get(i).getText().equals("") || textFieldNbHeureTypeModule.get(i).getText().equals(""))
                {
                    if(textFieldModule.get(i).getText().equals(""))  
                    {
                        JOptionPane.showMessageDialog(panelFormation,"Le champs nom du module ne peut rester vide");
                        // textFieldModule.get(i).requestFocusInWindow();
                    }
                    else    { 
                        JOptionPane.showMessageDialog(panelFormation,"Le champs nombre de séance ne peut rester vide");
                        //textFieldNbHeureTypeModule.get(i).requestFocusInWindow();
                    }
                }
                else
                {
                    if(nbHeure != null || nomFormation != null)
                    {
                        try {
                            Color couleur = JColorChooser.showDialog(null, "couleur du fond", Color.WHITE);
                            boolean couleurExist = false;
                            for(Color uneCouleur : listcouleur)
                            {
                                if(uneCouleur.equals(couleur))couleurExist = true;
                            }
                            if(!couleurExist)
                            {
                                listcouleur.add(couleur);
                                JOptionPane.showMessageDialog(panelFormation, "Couleur choisie");
                                buttonList.get(i).setEnabled(false);
                                validate();
                                repaint();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(panelFormation, "Cette couleur existe déjà our une formation, veuillez en sélectionner une autre");
                            }                            
                        } catch (NullPointerException ex) {

                        }
                    }
                    else
                    {
                        if(nomFormation == null)
                        {
                            JOptionPane.showMessageDialog(panelFormation,"Le nom d'une formation est vide");
                            //textFieldNomFormation.requestFocusInWindow();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(panelFormation,"Le champs duree d'une formation est incorrect");
                            //textFieldNbHeureTypeSeance.requestFocusInWindow();
                        }
                    }
                }
            }

        }
        if (e.getSource() == boutonValider) {
            int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous valider votre formation?", "Valider", JOptionPane.YES_NO_CANCEL_OPTION);
            if (reponse == JOptionPane.YES_OPTION) {
            
                String nomFormation = textFieldNomFormation.getText();
                Float nbHeureType = Float.parseFloat(textFieldNbHeureTypeSeance.getText());

                Global.planning.getListePlanningF().clear();
                Global.planning.getListePlanningF().setNomFormation(nomFormation);
                Global.planning.getListePlanningF().setDureeTypeSeance(nbHeureType);

                
                for (int x = 0; x < textFieldModule.size(); x++) {
                    String nomModule = textFieldModule.get(x).getText();
                    int nbSeanceModules = Integer.parseInt(textFieldNbHeureTypeModule.get(x).getText());
                    String uneAbreviation;

                    Color uneCouleur = listcouleur.get(x);
                    if (nomModule.length() < 2 && nomFormation.length() < 2)uneAbreviation = nomFormation;
                    else
                    {
                        if (nomFormation.length() < 2)  uneAbreviation = nomFormation.substring(0, 1) + "-" + nomModule;
                        else    uneAbreviation = nomFormation + "-" + nomModule.substring(0, 1);
                    }

                    Module module = new Module(nomModule, nbSeanceModules, uneCouleur, uneAbreviation);
                    Global.planning.getListePlanningF().addModule(module);
                }
            }
        }

        if (e.getSource() == (boutonAjouter)) {

            int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous ajouter un module?", "Ajout", JOptionPane.YES_NO_CANCEL_OPTION);
            if (reponse == JOptionPane.YES_OPTION) {
                JTextField field = new JTextField();
                textFieldModule.add(field);
                field.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent fe) {}

                @Override
                public void focusLost(FocusEvent fe) {
                    int i = 0;
                    int position = 0;
                    for (JTextField search : textFieldModule) {
                        if (fe.getSource().equals(search)) {
                            moduleEncours = search;
                            position = i;
                        }
                        i++;
                    }
                    boolean searchModule = false;
                    for (JTextField search : textFieldModule) {
                        if(moduleEncours.getText().equals(search.getText()) && !search.equals(moduleEncours)) searchModule = true;
                    }
                    if(searchModule) 
                    {
                        JOptionPane.showMessageDialog(panelFormation,"Veuillez saisir le nom de la formationCe nom de module existe deja");
                        moduleEncours.requestFocusInWindow();
                    }
                    else
                    {
                        textFieldModule.set(position, moduleEncours);
                    }
                    moduleEncours = null;
                }
            });
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
            }
        }
    }

}
