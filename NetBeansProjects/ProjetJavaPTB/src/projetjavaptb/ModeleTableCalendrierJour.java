/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

/**
 *
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeleTableCalendrierJour extends DefaultTableModel {

    int jourEnCours = 0;

    public ModeleTableCalendrierJour(int premierJour, int nbJourMois, int nbSemaines) {
        String title[] = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        this.setRowCount(nbSemaines * 3);
        this.setColumnIdentifiers(title);
        for (int i = 0; i < 7; i++) {
            if (premierJour != 1) {
                if (i >= premierJour - 2) {
                    jourEnCours++;
                    this.setValueAt(jourEnCours, 0, i);
                }
            } else {
                jourEnCours=1;
                this.setValueAt(1, 0, 6);
            }
        }
        
        for (int j = 3; j < this.getRowCount(); j += 3) {
            for (int i = 0; i < 7; i++) {
                jourEnCours++;
                if(jourEnCours<=nbJourMois) this.setValueAt(jourEnCours, j, i);
            }
        }
        this.setColumnCount(7);
    }
}
