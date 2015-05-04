/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BLONBOUT
 */
public class ModeleTableCalendrierPeriode extends DefaultTableModel{
    public ModeleTableCalendrierPeriode()
    {
        String title[] = {"Période"};
        String data[] = {"Jour","Matin","Après-midi"};
        this.setRowCount(3);
        this.setColumnIdentifiers(title);
        for (int i = 0; i<3;i++)this.setValueAt(data[i], i, 0);        
        this.setColumnCount(1);        
    }
}
