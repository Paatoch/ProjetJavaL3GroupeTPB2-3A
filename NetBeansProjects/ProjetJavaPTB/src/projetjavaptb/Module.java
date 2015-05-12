/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.awt.Color;
import java.io.Serializable;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class Module implements Serializable {

    private String nomModule;
    private int nbSeances;
    Color couleurModule;
    String abreviationModule;
      
    public Module(String parNomModule, int parNbSeance, Color parCouleurModule, String parAbreviationModule) {
        this.nomModule = parNomModule;
        this.nbSeances = parNbSeance;
        couleurModule = parCouleurModule;
        abreviationModule = parAbreviationModule;

    }

    public Color getCouleurModule() {
        return couleurModule;
    }

    public void setCouleurModule(Color couleurModule) {
        this.couleurModule = couleurModule;
    }

    public String getAbreviation() {
        return abreviationModule;
    }

    public void setAbreviation(String abreviation) {
        this.abreviationModule = abreviation;
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

    public String toString() {
        String s = getNomModule()
                + "  qui contient  :" + getNbSeances() + " séances " + "\n"
                + " " + getCouleurModule ().toString() + "  " + getAbreviation() ;
        return s;
    }

}
