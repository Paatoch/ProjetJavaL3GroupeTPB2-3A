/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ModeleTableCalendrierJour extends DefaultTableModel {

    int jourEnCours = 0;
    Color c1 = new Color(0, 0, 0);
    
    
    public ModeleTableCalendrierJour(int premierJour, int nbJourMois, int nbSemaines, String leMois, int leAnnee) {
        String title[] = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        this.setRowCount(nbSemaines * 3);
        this.setColumnIdentifiers(title);
        for (int i = 0; i < 7; i++) {
             if (premierJour != 1) {
                if (i >= premierJour - 2) {
                    jourEnCours++;
                    this.setValueAt(jourEnCours, 0, i);
                    for(Cours_Reservation unCours : Global.planning.getListePlanningC())
                    {
                        
                        if(unCours.getAnnee() == leAnnee && unCours.getMois().equals(leMois) && jourEnCours == unCours.getJour())
                        {   if(unCours.isMatin()){
                                this.setValueAt(unCours, 1, i);}
                            if(unCours.isMidi())this.setValueAt(unCours, 2, i);
                            System.out.println(unCours);
                        }
                    }
                }
            } else {
                jourEnCours = 1;
                this.setValueAt(1, 0, 6);
                
            }
        }

        for (int j = 3; j < this.getRowCount(); j += 3) {
            for (int i = 0; i < 7; i++) {
                jourEnCours++;
                if (jourEnCours <= nbJourMois) {
                    this.setValueAt(jourEnCours, j, i);
                    for(Cours_Reservation unCours : Global.planning.getListePlanningC())
                    {
                        if(unCours.getAnnee() == leAnnee && unCours.getMois().equals(leMois) && jourEnCours == unCours.getJour())
                        {
                            if(unCours.isMatin())this.setValueAt(unCours, j+1, i);
                            if(unCours.isMidi())this.setValueAt(unCours, j+2, i);
                        }
                    }
                }
            }
        }
        this.setColumnCount(7);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        /* Aucune colonne n'est editable*/
        if (columnIndex >= 0) {
            return false;
        }

        //le reste est editable
        return true;
    }

    public static class MonCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);
            String s = table.getModel().getValueAt(row, col).toString();

            this.setForeground(Color.BLACK);

            if (column >= 5) {
                cell.setBackground(Color.GRAY);
            } 
            else {
                cell.setBackground(Color.WHITE);
                //this.setFont(new Font("Arial", Font.BOLD, 14));
                this.setForeground(Color.BLACK);
               
            }
            
            
            return cell;
        }
       
    }

 
}
