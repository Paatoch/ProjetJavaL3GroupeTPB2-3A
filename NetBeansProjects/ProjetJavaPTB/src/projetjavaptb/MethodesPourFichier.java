/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavaptb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author patrickcabral
 * @author teddyBlonbou
 * @author benjaminTabet
 */
public class MethodesPourFichier {

    private String cheminBinaryFile = "Sauvegarde/sauvegarde";

    public static void ecriture(Object input, File cheminBinaryFile) {
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(cheminBinaryFile));
            stream.writeObject(input);
            stream.close();
            System.out.println("Ecriture dans le fichier");
        } catch (IOException e) {
            System.err.println("Erreur dans la m�thode ecriture de MethodesPourFichier");
            e.printStackTrace();
        }
    }//ecriture

    public static Object lecture(File fichier) {
        ObjectInputStream stream = null;
        Object resultat = null;
        try {
            stream = new ObjectInputStream(new FileInputStream(fichier));
            resultat = (Object) stream.readObject();
            stream.close();
        } catch (IOException e) {
            System.err.println("Erreur d'entree / sortie dans la methode lecture de MethodesPourFichier");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de classe dans la methode lecture de MethodesPourFichier");
            e.printStackTrace();
        }

        return resultat;
    }//lecture

}//class methodeparFichier

