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
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeleTableCalendrierJour extends DefaultTableModel {

    int jourEnCours = 0;
    Color c1 = new Color(0,0,0);
    
    public ModeleTableCalendrierJour(int premierJour, int nbJourMois, int nbSemaines) {
        String title[] = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        this.setRowCount(nbSemaines * 3);
        this.setColumnIdentifiers(title);
        for (int i = 0; i < 7; i++) {
            //if(i>=5) this.getColumnClass(i).
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
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        //ici la cellule (1, 2) est non-editable
        if (columnIndex >= 5){
            return false;
        }
        
        //le reste est editable
        return true;
    }
}
