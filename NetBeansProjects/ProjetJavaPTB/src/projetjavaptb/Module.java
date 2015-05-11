/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.io.Serializable;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */

public class Module implements Serializable  {
    private String nomModule ;
    private int nbSeances ;
    
    public Module (String parNomModule, int parNbSeance){
        this.nomModule = parNomModule;
        this.nbSeances = parNbSeance;
        
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public int getNbSeances() {
        return nbSeances;
    }

    public void setNbSeances(int nbHeureModule) {
        this.nbSeances = nbHeureModule;
    }

    public String toString (){
        String s = getNomModule() + 
         "  qui contient  :" + nbSeances + " séances " +"\n";
       return s;
    }
    

}
