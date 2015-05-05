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
    public ModeleTableCalendrierPeriode(int nbSemaine)
    {
        String title[] = {"Periode"};
        String data[] = {"Jour","Matin","Apres-midi"};
        this.setRowCount(3*nbSemaine);
        this.setColumnIdentifiers(title);
        int j = 0;
        for (int i = 0; i<this.getRowCount();i++)
        {
            if(j== 3)j=0;
            this.setValueAt(data[j], i, 0);        
            j++;
        }
        this.setColumnCount(1);        
    }
}

