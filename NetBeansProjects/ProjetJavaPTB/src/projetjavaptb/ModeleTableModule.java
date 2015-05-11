/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BLONBOUT
 */
public class ModeleTableModule extends DefaultTableModel {
    
    private ArrayList<Integer> nonEditable;
    
    public ModeleTableModule(ArrayList<Formation> lesFormations)
    {
        this.setColumnCount(2);
        this.nonEditable = new ArrayList<>();
        int yi = 0;
        //Début de la boucle sur chaque formation
        for(Formation uneFormation : lesFormations)
        {
            JLabel lblNomFormation = new JLabel(uneFormation.nomFormation);
            nonEditable.add(yi);
            this.setValueAt(lblNomFormation, yi,0);
            yi++;
            for(Module unModule : uneFormation.getModule())
            {
                JLabel lblNomModule = new JLabel(unModule.getNomModule());
                this.setValueAt(lblNomModule,yi,0);
                JLabel lblDureeModule = new JLabel(Float.toString(unModule.getNbHeureModule()));
                this.setValueAt(lblDureeModule,yi,1);
                yi++;
            }
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        /* Aucune colonne n'est editable*/
        if (columnIndex == 0) {
            for(int integerTest  : nonEditable)
            {
                if(integerTest == rowIndex)return false;
            }
        }
        return true;
    }

}
