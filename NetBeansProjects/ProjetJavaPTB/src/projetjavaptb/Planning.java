/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

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

public class Planning {
    protected ArrayList<Cours_Reservation> listePlanning = new ArrayList<Cours_Reservation>();

    public Planning( ) {
            }

	public String toString (){
           String chaine = "" ;
           for ( int i=0; i<listePlanning.size() ; i++)
        {
            chaine += "\n" + listePlanning+ "\n" ;}
	return chaine ; 
        }
	
   
}
