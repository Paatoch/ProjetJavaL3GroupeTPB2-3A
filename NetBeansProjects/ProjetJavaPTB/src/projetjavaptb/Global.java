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
public class Global {
        public static Planning planning = new Planning();
        public static ArrayList<String> listeMois = new ArrayList<>();
        public static void Remplit()
        {
            listeMois.add("Janvier");
            listeMois.add("Fevrier");
            listeMois.add("Mars");
            listeMois.add("Avril");
            listeMois.add("Mai");
            listeMois.add("Juin");
            listeMois.add("Juillet");
            listeMois.add("Aout");
            listeMois.add("Septembre");
            listeMois.add("Octobre");
            listeMois.add("Novembre");
            listeMois.add("Decembre");
        }
}
