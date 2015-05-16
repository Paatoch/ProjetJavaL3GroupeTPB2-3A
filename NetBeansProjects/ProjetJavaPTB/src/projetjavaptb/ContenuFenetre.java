/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author BLONBOUT
 */
public class ContenuFenetre extends JPanel {

    private JPanel panelHaut = new JPanel(new GridBagLayout());
    private JPanel panelBas = new JPanel();
    private JPanel panelCalendrier = new JPanel();
    GridBagConstraints positionBox, positionBouttonPre, positionLabelMois, positionBouttonSuiv;
    private JComboBox comboAnnees = new JComboBox();
    public JLabel lblPre = new JLabel();
    public JLabel lblSuiv = new JLabel();
    public JLabel lblMois = new JLabel();
    private JLabel labelTeddy = new JLabel(" Teddy Blonbou  -   ");

    
    
    private JLabel labelPatrick = new JLabel("Patrick Cabral  -   ");
    private JLabel labelBenjamin = new JLabel("Benjamin Tabet    ");
    private int anneeCourante, moisCourant;
    private ItemListener itemListener;
    public boolean premierFois = false;

    public ContenuFenetre() {
        RemplitLabel("new");
        setLayout(new BorderLayout());
        
        setBackground(Color.GRAY);
        
        /****************/
        /***PANEL HAUT***/
        /****************/
        
        
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
                if(comboAnnees.getItemCount()==4)
                {
                    comboAnnees.removeItemAt(0);
                    panelHaut.repaint();
                    panelHaut.revalidate();
                }
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    if(!itemEvent.getItem().equals(""))anneeCourante = (int) itemEvent.getItem();                        
                    Affiche("");
                }
            }
        };
        comboAnnees.addItemListener(itemListener);
        panelHaut.add(comboAnnees, positionBox);
        panelHaut.add(lblPre, positionBouttonPre);
        panelHaut.add(lblMois, positionLabelMois);
        panelHaut.add(lblSuiv, positionBouttonSuiv);
        
        /**********************/
        /***PANEL CALENDRIER***/
        /**********************/
        
        //panelCalendrier.getPreferredSize();
        
        /***************/
        /***PANEL BAS***/
        /***************/
        
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

    /*public void setPlanning(Planning unPlanning) {
        Global.planning.setListePlanningC(unPlanning.getListePlanningC());
        Global.planning.setListePlanningF(unPlanning.getListePlanningF());
        Affiche("");
        revalidate();
        repaint();
    }*/

    public void setPanelCalendrier(JPanel panelCalendrier) {
        this.panelCalendrier = panelCalendrier;
    }
    
    public void Affiche(String moment) {
        if(!premierFois)
        {
            premierFois = true;
            if(anneeCourante == Calendar.getInstance().get(Calendar.YEAR))
            moisCourant = Calendar.getInstance().get(Calendar.MONTH);
            else moisCourant = 0;
        }
        else {
            premierFois = true;
        }
        panelHaut.setBorder(BorderFactory.createTitledBorder(null, "Choix Année & Mois", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));
        if(moment.equals("new"))
        {
            panelCalendrier.remove(this);
            lblMois.setVisible(false);
            lblPre.setVisible(false);
            lblSuiv.setVisible(false);
            premierFois = false;
            comboAnnees.removeAllItems();
            comboAnnees.addItem("");
            for (int i = 0; i <= 2; i++)comboAnnees.addItem(Calendar.getInstance().get(Calendar.YEAR) + i);
            comboAnnees.setSelectedIndex(0);
        }
        else    
        {
            FabriqueCalendrier(anneeCourante, moisCourant);
            lblMois.setText(Global.listeMois.get(moisCourant));
            lblMois.setVisible(true);
            lblPre.setVisible(true);
            lblSuiv.setVisible(true);
        }
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

    public void FabriqueCalendrier(int annee, int mois)
    {
        panelCalendrier.removeAll();
        setBorder(BorderFactory.createTitledBorder(null, "Planning", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));
        Calendrier monCalendrier = new Calendrier(annee,mois);
        panelCalendrier.add(monCalendrier);
        revalidate();
        repaint();
    }

    public JPanel getPanelCalendrier()
    {
        return(this.panelCalendrier);
    }
    
    public JPanel getPanelHaut()
    {
        return(this.panelHaut);
    }
    
    public JComboBox getComboAnnee()
    {
        return comboAnnees;
    }
    
}
