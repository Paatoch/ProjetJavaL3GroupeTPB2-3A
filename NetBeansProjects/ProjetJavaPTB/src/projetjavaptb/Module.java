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
    private float nbHeureModule ;
    
    public Module (String parNomModule, float parNbHeureModule){
        this.nomModule = parNomModule;
        this.nbHeureModule = parNbHeureModule;
        
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public float getNbHeureModule() {
        return nbHeureModule;
    }

    public void setNbHeureModule(float nbHeureModule) {
        this.nbHeureModule = nbHeureModule;
    }

    public String toString (){
        String s = getNomModule() + 
         "  qui dure  :" + nbHeureModule + " heures " +"\n";
       return s;
    }
    

}
