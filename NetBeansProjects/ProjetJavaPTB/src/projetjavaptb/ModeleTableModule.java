/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author patrickcabral
 */
public class ModeleTableModule extends DefaultTableModel {

    private ArrayList<Module> modules;

    String title[] = {"Nom Module", "Heures module"};

    private Formation formation ;
    public ModeleTableModule() {
    addModule (new Module ("Maths",15));
    
    for (int i = 0; i<title.length;i++){
       //if (this.getRowCount()==0)
       for (int j = 0; j < this.getRowCount(); j ++) {
         this.setValueAt(modules.get(i), j, i);
    }
    }
    }

  

    public int getColumnCount() {
        return title.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return title[columnIndex];
    }

    
    public void addModule(Module parModule) {
        modules.add(parModule);
        fireTableRowsInserted(modules.size() - 1, modules.size() - 1);
    }

    public void removeModule(int indexLigne) {
        modules.remove(indexLigne);
        fireTableRowsDeleted(indexLigne, indexLigne);

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
