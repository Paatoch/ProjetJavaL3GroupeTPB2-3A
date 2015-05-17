/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */


/*
Cette classe represente la reservation d'un cours 
Le planning entier / par mois 
Il y aura donc une array Liste de Cours_Reservation
c'est a remplir
*/

public class Planning implements Serializable{
    private ArrayList<Cours_Reservation> listePlanningC = new ArrayList<Cours_Reservation>();
    private Formation listePlanningF = new Formation();
    
    public Planning(){}
    
    public Planning( ArrayList<Cours_Reservation> mesCours, Formation maFormation) 
    {
        listePlanningC = mesCours;
        listePlanningF = maFormation;
    }
    
    public ArrayList<Cours_Reservation> getListePlanningC() {
        return listePlanningC;
    }
    
    public Cours_Reservation getCours(int jour, int annee, String mois, boolean matin, boolean midi)
    {
        for(Cours_Reservation cours :listePlanningC)
        {
            if(cours.getJour()==jour && cours.getAnnee()==annee && cours.getMois().equals(mois))
            {
                if(matin && cours.isMatin()) return cours;
                if(midi && cours.isMidi()) return cours;
            }
        }
        return null;
    }

    public void setListePlanningC(ArrayList<Cours_Reservation> listePlanningC) {
        this.listePlanningC.clear();
        this.listePlanningC = listePlanningC;
    }

    public Formation getListePlanningF() {
        return listePlanningF;
    }

    public void setListePlanningF(Formation listePlanningF) {
        this.listePlanningF = listePlanningF;
    }

    public void clear()
    {
        listePlanningC.clear();
        listePlanningF.clear();
    }
    
    public String toString (){
       String chaine = "" ;
       for ( int i=0; i<listePlanningC.size() ; i++)
    {
        chaine += "\n" + listePlanningC+ "\n" ;}
    return chaine ; 
    }
	
   
}
