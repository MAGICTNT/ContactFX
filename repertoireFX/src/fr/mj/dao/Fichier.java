package fr.mj.dao;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Fichier {

    private File nomFichier;

    public Charset getCharset() {
        return charset;
    }

    private Charset charset;

    public Fichier(File nomFichier,Charset charset) {
        this.nomFichier = nomFichier;
        this.charset = charset;
    }

    public ArrayList<String> lire() {
        ArrayList<String> lignes = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(nomFichier,charset))) {
            String ligne;
            while ((ligne = bufferedReader.readLine()) != null)
                lignes.add(ligne);
        }
        catch (IOException e) {
            System.out.println("Erreur lors de la lecture : " + e.getMessage());
        }
        return lignes;
    }

    public void ecrire(List<String> lignes) {

        try (PrintWriter printwriter = new PrintWriter(
                new FileWriter(nomFichier,charset))) {

            for (String ligne : lignes)
                printwriter.println(ligne);

        } catch (IOException exception) {
            System.out.println(
                    "Erreur lors de l'écriture : " + exception.getMessage());
        }
    }

}
