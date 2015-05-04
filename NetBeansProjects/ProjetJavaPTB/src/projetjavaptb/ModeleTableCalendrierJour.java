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
    
    public ModeleTableCalendrierJour()
    {
        String title[] = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        this.setRowCount(3);
        this.setColumnIdentifiers(title);        
        this.setColumnCount(7);        
    }
}


