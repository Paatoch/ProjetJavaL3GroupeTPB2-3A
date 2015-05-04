package projetjavaptb;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BLONBOUT
 */
public class ModeleTableCalendrierJour extends DefaultTableModel {
    
    public ModeleTableCalendrierJour()
    {
        String title[] = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        this.setRowCount(3);
        this.setColumnIdentifiers(title);        
        this.setColumnCount(7);        
    }
}
