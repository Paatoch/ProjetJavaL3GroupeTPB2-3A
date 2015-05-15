
package projetjavaptb;

import java.io.Serializable;


/*
 Cette classe represente la reservation d'un cours 
 Il faudra donc récupéré les paramètres lors du click sur le bouton valider une réservation
 il y aura donc en paramètre :

 - Jour
 - Mois 
 - Année
 sélectionnés par l'utilisateur
 - Formation + Module  
 - Matin / après midi 
 */

public class Cours_Reservation implements Serializable {

    private int jour, annee;
    private String mois, formation, module;
    private boolean matin, midi;

    public Cours_Reservation() {
    }
    
    
    public Cours_Reservation(int un_jour, int une_annee, String un_mois, String une_formation, String un_module, boolean un_matin, boolean un_midi) {
        jour = un_jour;
        annee = une_annee;
        mois = un_mois;
        formation = une_formation;
        module = un_module;
        matin = un_matin;
        midi = un_midi;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public boolean isMatin() {
        return matin;
    }

    public void setMatin(boolean matin) {
        this.matin = matin;
    }

    public boolean isMidi() {
        return midi;
    }

    public void setMidi(boolean midi) {
        this.midi = midi;
    }

    @Override
    public String toString()
    {
        String chaine =  getFormation() + "\n" + getModule()  ;
        return chaine;
    }
}
