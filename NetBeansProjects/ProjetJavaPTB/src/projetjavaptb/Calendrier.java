/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;
import javax.swing.JButton;
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
    public static JButton Defaire = new JButton("Défaire");
    public static JButton Refaire = new JButton("Refaire");
    public static Cours_Reservation tempCoursDefaire = new Cours_Reservation();
    public static Cours_Reservation tempCoursRefaire = new Cours_Reservation();
    public static JPanel mesBouttons = new JPanel();
    
    public Calendrier(int annee, int mois)
    {
        this.setLayout(new BorderLayout());
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
        
        Defaire.setEnabled(false);
        Refaire.setEnabled(false);
        
        Defaire.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int trouve = 0;
                int increment = 0;
                for(Cours_Reservation unCours : Global.planning.getListePlanningC())
                {
                    if(tempCoursDefaire.compare(unCours))
                    {
                        trouve = increment;
                        tempCoursRefaire = unCours;
                    }
                    increment++;
                }
                Refaire.setEnabled(true);
                Global.planning.getListePlanningC().remove(trouve);
                ContenuFenetre.Repaint(anneeCourante, moisCourant);
            }
        });
        
        tableauCalendrier = new JTable();
        tableauCalendrier.setDefaultRenderer(Object.class, new ModeleTableCalendrierJour.MonCellRenderer());
        tableauCalendrier.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
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
                           // tableauCalendrier.setValueAt("ggggg",row-1, col);
                            Formulaire_Cours formulaire =  new Formulaire_Cours (maValeur, anneeCourante,    Global.listeMois.get(moisCourant), "matin");
                            }
                    catch(NullPointerException e2){
                        }
                    }
                }

            }

        });
        tableauCalendrier.setModel(new ModeleTableCalendrierJour(premierJour, nbJour, nbSemaine, Global.listeMois.get(moisCourant) ,anneeCourante));
        
        mesBouttons.add(Defaire);
        mesBouttons.add(Refaire);
        JScrollPane Jpane = new JScrollPane(tableauCalendrier);
        JScrollPane JpaneLeft = new JScrollPane(new JTable(new ModeleTableCalendrierPeriode(nbSemaine)));
        add(Jpane, BorderLayout.CENTER);
        add(JpaneLeft, BorderLayout.WEST);
        add(mesBouttons, BorderLayout.SOUTH);
    }
}
