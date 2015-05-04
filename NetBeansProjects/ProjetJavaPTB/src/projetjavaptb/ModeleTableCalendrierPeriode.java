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
 
  import javax.swing.table.DefaultTableModel;

public class ModeleTableCalendrierPeriode extends DefaultTableModel{
    public ModeleTableCalendrierPeriode()
    {
        String title[] = {"Periode"};
        String data[] = {"Jour","Matin","Apres-midi"};
        this.setRowCount(3);
        this.setColumnIdentifiers(title);
        for (int i = 0; i<3;i++)this.setValueAt(data[i], i, 0);        
        this.setColumnCount(1);        
    }
}

