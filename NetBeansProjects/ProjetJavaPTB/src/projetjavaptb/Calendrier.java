/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author BLONBOUT
 */
public class Calendrier extends JPanel {
        
    private int tempMouse, anneeCourante, moisCourant;
    private JTable tableauCalendrier;
    
    public Calendrier(int annee, int mois)
    {
        tempMouse = 0;
        anneeCourante = annee;
        moisCourant = mois;
        /*Création du calendrier grégorien*/
        GregorianCalendar startDate = new GregorianCalendar(annee, mois, 1);
        startDate.setMinimalDaysInFirstWeek(1);
        
        /*Variable contenant le nombre de semaine présent dans le mois*/
        int nbSemaine = startDate.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        
        /*Variable contenant le nombre de jours présent dans le mois*/
        int nbJour = startDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        
        /*Variable contenant le premier jour du mois*/
        int premierJour = startDate.get(GregorianCalendar.DAY_OF_WEEK);
        
        
        tableauCalendrier = new JTable();
        tableauCalendrier.setDefaultRenderer(Object.class, new ModeleTableCalendrierJour.MonCellRenderer());
        tableauCalendrier.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (e.getClickCount() == 2) {
                    //System.out.println(e.getID());
                    if(tempMouse != e.getID())
                    {
                        Point p = e.getPoint(); //recup la position de la souris 
                        int row = tableauCalendrier.rowAtPoint(p); //indice de la ligne a cette position
                        int col = tableauCalendrier.columnAtPoint(p); //indice colonne 
                        //JOptionPane.showMessageDialog(contentPanel, contentTemp.getValueAt(row, col)); //element a ligne row et colonne col 
                        tempMouse = e.getID();
                        int maValeur;
                        try{
                            maValeur = (int)tableauCalendrier.getValueAt(row-2, col);
                            Formulaire_Cours formulaire =  new Formulaire_Cours (maValeur, anneeCourante,Global.listeMois.get(moisCourant), "midi");
                        }
                        catch(NullPointerException e1){
                            try{
                                maValeur = (int)tableauCalendrier.getValueAt(row-1, col);
                                Formulaire_Cours formulaire =  new Formulaire_Cours (maValeur, anneeCourante,    Global.listeMois.get(moisCourant), "matin");
                                }
                        catch(NullPointerException e2){
                            }
                        }
                    }
                    else tempMouse = 0;
                }

            }

        });
        ArrayList<JPanel> content = new ArrayList<>();
        tableauCalendrier.setModel(new ModeleTableCalendrierJour(premierJour, nbJour, nbSemaine, Global.listeMois.get(moisCourant) ,anneeCourante));
        JTable leftContent = new JTable(new ModeleTableCalendrierPeriode(nbSemaine));
        JScrollPane Jpane = new JScrollPane(tableauCalendrier);
        JScrollPane JpaneLeft = new JScrollPane(new JTable(new ModeleTableCalendrierPeriode(nbSemaine)));
        JPanel temp = new JPanel(new BorderLayout());
        temp.add(Jpane, BorderLayout.CENTER);
        temp.add(JpaneLeft, BorderLayout.WEST);
        content.add(temp);
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.insets = new Insets(4, 0, 10, 0);
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.weightx = 0.3;
        contraintes.weighty = 1;
        
        
        for (int i = 0; i < content.size(); i++) {
            contraintes.gridy = i + 1;
            add(content.get(i), contraintes);
        }
        content.clear();
        getPreferredSize();
    }
}
