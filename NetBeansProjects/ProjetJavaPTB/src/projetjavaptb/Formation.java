/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import Exception.*;

import java.util.ArrayList;

/**
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class Formation {

    protected String nomFormation;
    protected Float dureeTypeSeance;
    protected ArrayList<Module> listeModule = new ArrayList<>();

    public Formation(String nomFormation, Float parDureeTypeSeance, Module parModule) {
        this.nomFormation = nomFormation;
        this.dureeTypeSeance = parDureeTypeSeance;
        this.listeModule.add(parModule);

    }

   public  Formation(String nomFormation, Float nbHeureType) {
         this.nomFormation = nomFormation;
        this.dureeTypeSeance = nbHeureType;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public Float getDureeTypeSeance() {
        return dureeTypeSeance;
    }

    public void setDureeTypeSeance(Float dureeTypeSeance) {
        this.dureeTypeSeance = dureeTypeSeance;
    }

    public void addModule(Module parModule) {
        this.listeModule.add(parModule);
    }

    public Module getModule(String parModule) throws Exception_Module {
        for (Module c : listeModule) {

            if (c.getNomModule().toUpperCase().equals(parModule.toUpperCase())) {
                return c;
            } else {
                throw new Exception_Module();
            }
        }
        return null;
    }
    
    public String toString (){
        String s = "La formation  "+ getNomFormation() + " : " +"\n" +
                " Dont le nombre d'heure type est : " + getDureeTypeSeance() +"\n"  ;
        s+= "A pour modules :";
        for( Module c : listeModule){
            s += " "+ c.toString()+"\n";
        }
       return s;
    }
}
