/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class ContenuFenetre extends JPanel {

    private JPanel panelHaut = new JPanel(new GridBagLayout());
    private JPanel panelBas = new JPanel();
    private static JPanel panelCalendrier = new JPanel(new BorderLayout());
    GridBagConstraints positionBox, positionBouttonPre, positionLabelMois, positionBouttonSuiv;
    private JComboBox comboAnnees = new JComboBox();
    public JLabel lblPre = new JLabel();
    public JLabel lblSuiv = new JLabel();
    public JLabel lblMois = new JLabel();
    private JLabel labelTeddy = new JLabel(" Teddy Blonbou  -   ");

    public static JButton defaire = new JButton("Défaire");
    public static JButton refaire = new JButton("Refaire");
    public static String tempAction;
    static JPanel panelButon = new JPanel(new FlowLayout());
    private JLabel labelPatrick = new JLabel("Patrick Cabral  -   ");
    private JLabel labelBenjamin = new JLabel("Benjamin Tabet    ");
    private int anneeCourante, moisCourant;
    private ItemListener itemListener;
    public boolean premierFois = false;
    public boolean newCreate = true;

    public ContenuFenetre() {
        RemplitLabel("new");
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

        /**
         * *************
         */
        /**
         * *PANEL HAUT**
         */
        /**
         * *************
         */
        /*
         * Ajout des données dans la liste déroulante des années *
         */
        comboAnnees.addItem("");
        for (int i = 0; i <= 2; i++) {
            comboAnnees.addItem(Calendar.getInstance().get(Calendar.YEAR) + i);
        }

        /*
         * Positionnement de la liste déroulate *
         */
        positionBox = new GridBagConstraints();
        positionBox.insets = new Insets(2, 0, 4, 0);
        positionBox.fill = GridBagConstraints.LINE_START;
        positionBox.gridx = 2;
        positionBox.gridy = 0;
        positionBox.weightx = 0.3;
        positionBox.weighty = 1;

        /*
         * Positionnement du boutton précédent *
         */
        positionBouttonPre = new GridBagConstraints();
        positionBouttonPre.insets = new Insets(2, 0, 4, 0);
        positionBouttonPre.gridx = 1;
        positionBouttonPre.gridy = 1;
        positionBouttonPre.weightx = 0.3;
        positionBouttonPre.weighty = 1;

        /*
         * Position du mois *
         */
        positionLabelMois = new GridBagConstraints();
        positionLabelMois.insets = new Insets(2, 0, 4, 0);
        positionLabelMois.gridx = 2;
        positionLabelMois.gridy = 1;
        positionLabelMois.weightx = 0.3;
        positionLabelMois.weighty = 1;

        /*
         * Positionnement du boutton suivant *
         */
        positionBouttonSuiv = new GridBagConstraints();
        positionBouttonSuiv.gridx = 3;
        positionBouttonSuiv.gridy = 1;
        positionBouttonSuiv.weightx = 0.3;
        positionBouttonSuiv.weighty = 1;

        panelHaut.setBorder(BorderFactory.createTitledBorder(null, "Choix Année", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));

        itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (comboAnnees.getItemCount() == 4) {
                    comboAnnees.removeItemAt(0);
                    panelHaut.repaint();
                    panelHaut.revalidate();
                }
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    if (!itemEvent.getItem().equals("")) {
                        anneeCourante = (int) itemEvent.getItem();
                    }
                    if (newCreate) {
                        Affiche("");
                    } else {
                        newCreate = true;
                    }
                }
            }
        };
        comboAnnees.addItemListener(itemListener);
        panelHaut.add(comboAnnees, positionBox);
        panelHaut.add(lblPre, positionBouttonPre);
        panelHaut.add(lblMois, positionLabelMois);
        panelHaut.add(lblSuiv, positionBouttonSuiv);

        /**
         * *******************
         */
        /**
         * *PANEL CALENDRIER**
         */
        /**
         * *******************
         */
        defaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Defaire();
            }
        });

        refaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aev) {
                Refaire();
            }
        });

        panelCalendrier.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ek) {

                if (ek.isControlDown() && ek.getKeyCode() == KeyEvent.VK_Y) {

                    Refaire();
                }

                if ((ek.getKeyCode() == KeyEvent.VK_W) && ((ek.getModifiers() | KeyEvent.CTRL_MASK) == KeyEvent.CTRL_MASK)) {

                    Defaire();
                }

            }
        });

        panelButon.add(defaire);
        panelButon.add(refaire);

        //panelCalendrier.getPreferredSize();
        /**
         * ************
         */
        /**
         * *PANEL BAS**
         */
        /**
         * ************
         */
        panelBas.add(labelTeddy);
        panelBas.add(labelPatrick);
        panelBas.add(labelBenjamin);
        labelBenjamin.setFont(new Font("Arial", Font.BOLD, 14));
        labelTeddy.setFont(new Font("Arial", Font.BOLD, 14));
        labelPatrick.setFont(new Font("Arial", Font.BOLD, 14));
        add(panelHaut, BorderLayout.NORTH);
        add(panelCalendrier, BorderLayout.CENTER);
        add(panelBas, BorderLayout.SOUTH);

    }

    public void setPanelCalendrier(JPanel panelCalendrier) {
        this.panelCalendrier = panelCalendrier;
    }

    public void Affiche(String moment) {
        if (!premierFois) {
            premierFois = true;
            if (anneeCourante == Calendar.getInstance().get(Calendar.YEAR)) {
                moisCourant = Calendar.getInstance().get(Calendar.MONTH);
            } else {
                moisCourant = 0;
            }
        } else {
            premierFois = true;
        }
        panelHaut.setBorder(BorderFactory.createTitledBorder(null, "Choix Année & Mois", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));
        if (moment.equals("new")) {
            panelCalendrier.removeAll();
            lblMois.setVisible(false);
            lblPre.setVisible(false);
            lblSuiv.setVisible(false);
            premierFois = false;
            comboAnnees.removeAllItems();
            newCreate = false;
            comboAnnees.addItem("");
            for (int i = 0; i <= 2; i++) {
                comboAnnees.addItem(Calendar.getInstance().get(Calendar.YEAR) + i);
            }
            comboAnnees.setSelectedIndex(0);
        } else {
            FabriqueCalendrier(anneeCourante, moisCourant);
            lblMois.setText(Global.listeMois.get(moisCourant));
            lblMois.setVisible(true);
            lblPre.setVisible(true);
            lblSuiv.setVisible(true);
        }
        refaire.setEnabled(false);
        defaire.setEnabled(false);
        revalidate();
        repaint();
    }

    public void RemplitLabel(String moment) {
        ImageIcon iconPrev = new ImageIcon("Images/prev.png");
        ImageIcon iconNext = new ImageIcon("Images/next.png");
        lblPre.setIcon(iconPrev);
        lblSuiv.setIcon(iconNext);
        lblMois.setFont(new Font("Arial", Font.BOLD, 16));
        anneeCourante = Calendar.getInstance().get(Calendar.YEAR);
        moisCourant = Calendar.getInstance().get(Calendar.MONTH);

        /*Définition de l'action sur l'écouteur de l'image (précédant)*/
        lblPre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (moisCourant > 0) {
                    moisCourant -= 1;
                    /*Récupération du nom du mois */
                    lblMois.setText(Global.listeMois.get(moisCourant));
                    FabriqueCalendrier(anneeCourante, moisCourant);
                } else {
                    /*Condition dans le cas ou l'on passe à l'année précédante*/
                    if (anneeCourante > Calendar.getInstance().get(Calendar.YEAR)) {
                        moisCourant = 11;
                        anneeCourante -= 1;
                        comboAnnees.setSelectedItem(anneeCourante);
                        lblMois.setText(Global.listeMois.get(moisCourant));
                        FabriqueCalendrier(anneeCourante, moisCourant);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        /*Définition de l'action sur l'écouteur de l'image (suivant)*/
        lblSuiv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                /*Si le mois courant est strictement inferieur a decembre alors on incremente de 1 le mois*/
                if (moisCourant < 11) {
                    moisCourant += 1;
                    lblMois.setText(Global.listeMois.get(moisCourant));
                    lblMois.setVisible(true);
                    FabriqueCalendrier(anneeCourante, moisCourant);
                } else {
                    if (anneeCourante < Calendar.getInstance().get(Calendar.YEAR) + 2) {
                        moisCourant = 0;
                        /*Ajout d'une année dans le cas ou le mois est celui suivant Décembre*/
                        anneeCourante += 1;
                        comboAnnees.setSelectedItem(anneeCourante);
                        lblMois.setText(Global.listeMois.get(moisCourant));
                        FabriqueCalendrier(anneeCourante, moisCourant);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        lblMois.setVisible(false);
        lblPre.setVisible(false);
        lblSuiv.setVisible(false);
    }

    public void FabriqueCalendrier(int annee, int mois) {
        panelCalendrier.removeAll();
        setBorder(BorderFactory.createTitledBorder(null, "Planning", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));
        Calendrier monCalendrier = new Calendrier(annee, mois);
        panelCalendrier.add(monCalendrier, BorderLayout.CENTER);
        LegendeCalendrier legende = new LegendeCalendrier();
        panelCalendrier.add(legende, BorderLayout.SOUTH);
        //TestFalse();
        panelCalendrier.add(panelButon, BorderLayout.NORTH);
        panelCalendrier.setFocusable(true);
        panelCalendrier.requestFocusInWindow();
        revalidate();
        repaint();
    }

    public static void StatFabriqueCal(int annee, int mois) {
        panelCalendrier.removeAll();
        Calendrier monCalendrier = new Calendrier(annee, mois);
        panelCalendrier.add(monCalendrier, BorderLayout.CENTER);
        LegendeCalendrier legende = new LegendeCalendrier();
        panelCalendrier.add(legende, BorderLayout.SOUTH);
        panelCalendrier.add(panelButon, BorderLayout.NORTH);
        panelCalendrier.setFocusable(true);
        panelCalendrier.requestFocusInWindow();
    }

    public static void Repaint(int annee, int mois) {
        StatFabriqueCal(annee, mois);
        panelCalendrier.revalidate();
        panelCalendrier.repaint();
    }

    public JPanel getPanelCalendrier() {
        return (this.panelCalendrier);
    }

    public JPanel getPanelHaut() {
        return (this.panelHaut);
    }

    public JComboBox getComboAnnee() {
        return comboAnnees;
    }

    public void Defaire() {
        switch (tempAction) {
            case "Ajout":
                int trouve = 0;
                int increment = 0;
                Cours_Reservation tempCoursTest = new Cours_Reservation();
                for (Cours_Reservation unCours : Global.planning.getListePlanningC()) {
                    if (Calendrier.tempCours.compare(unCours)) {
                        trouve = increment;
                        tempCoursTest = unCours;
                    }
                    increment++;
                }
                Global.planning.getListePlanningC().remove(tempCoursTest);
                tempAction = "Suppression";
                break;

            case "Modifier":
                modifier();
                break;
            default:
                break;
        }
        refaire.setEnabled(true);
        defaire.setEnabled(false);
        ContenuFenetre.Repaint(anneeCourante, moisCourant);
    }

    public void Refaire() {
        switch (tempAction) {
            case "Suppression":
                Global.planning.getListePlanningC().add(Calendrier.tempCours);
                tempAction = "Ajout";
                break;

            case "Modifier":
                modifier();
                break;
        }
        defaire.setEnabled(true);
        refaire.setEnabled(false);
        ContenuFenetre.Repaint(anneeCourante, moisCourant);
    }

    public void modifier() {
        Cours_Reservation cours = Global.planning.getCours(Calendrier.tempCours.getJour(), Calendrier.tempCours.getAnnee(), Calendrier.tempCours.getMois(), Calendrier.tempCours.isMatin(), Calendrier.tempCours.isMidi());
        String nomModule = Calendrier.tempCours2.getModule();
        Calendrier.tempCours2 = null;
        Calendrier.tempCours2 = new Cours_Reservation();
        Calendrier.tempCours2.copyCours(cours);
        cours.setModule(nomModule);
        Calendrier.tempCours = null;
        Calendrier.tempCours = new Cours_Reservation();
        Calendrier.tempCours.copyCours(cours);
        tempAction = "Modifier";

    }
}
