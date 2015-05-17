/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class LegendeCalendrier extends JPanel {
    
    public LegendeCalendrier()
    {
        setLayout(new GridBagLayout());
        int x = 0;
        int y = 1;
        Float dureeFormation = Float.parseFloat("0");
        JPanel lesModule = new JPanel(new GridBagLayout());
        for(Module unModule : Global.planning.getListePlanningF().getModule())
        {
            Color couleurModule = unModule.getCouleurModule();
            JLabel jlNomModule = new JLabel(unModule.getNomModule());
            Float dureeModuleF = Float.parseFloat("0");
            Float dureeType = Global.planning.getListePlanningF().getDureeTypeSeance();
            int dureeHeureModuleI;
            for(Cours_Reservation unCours : Global.planning.getListePlanningC())
            {
                if(unCours.getModule().equals(unModule.getNomModule())) dureeModuleF+=dureeType;
            }
            dureeFormation+=dureeModuleF;
            dureeHeureModuleI = dureeModuleF.intValue();
            int dureeMinuteModuleI = (int) (60 * (dureeModuleF - dureeHeureModuleI));
            String heureModule;
            if(Integer.toString(dureeHeureModuleI).length()==1) heureModule = "0"+Integer.toString(dureeHeureModuleI);
            else heureModule = Integer.toString(dureeHeureModuleI);
            String minuteModule;
            if(Integer.toString(dureeMinuteModuleI).length()==1) minuteModule = "0"+Integer.toString(dureeMinuteModuleI);
            else minuteModule = Integer.toString(dureeMinuteModuleI);
            JLabel jlDureeModule = new JLabel(heureModule + "h" + minuteModule);
            
            /*DessineRectangle dessin = new DessineRectangle();
            dessin.setColor(couleurModule);
            dessin.drawRoundRect(x, 0, 5, 5, 0, 0);*/
            
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = y;
            lesModule.add(jlNomModule, c);
            c.gridx = 1;
            c.gridy = y;
            lesModule.add(jlDureeModule, c);
            x++;
            y++;
        }
        
        int heureFormation = dureeFormation.intValue();
        int minuteFormation = (int) (60* (dureeFormation - heureFormation));
        String jourFormation = "";
        String sHeureFormation;
        String sMinuteFormation;
        if(Integer.toString(heureFormation).length()==1) sHeureFormation = "0"+Integer.toString(heureFormation);
        else sHeureFormation = Integer.toString(heureFormation);
        if(Integer.toString(minuteFormation).length()==1) sMinuteFormation = "0"+Integer.toString(minuteFormation);
        else sMinuteFormation = Integer.toString(minuteFormation);
        if(heureFormation<24) jourFormation = "Moins d'un jour de formation";
        else{
            jourFormation = Integer.toString(heureFormation/24) + " jours de formation";
        }
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel(Global.planning.getListePlanningF().getNomFormation()+" "),c);
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel(sHeureFormation + "H" + sMinuteFormation + " soit " + jourFormation +" "),c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(lesModule,c);
    }
}
