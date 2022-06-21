package fr.mj.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import fr.mj.contact.Personne;
import fr.mj.contact.Repertoire;

public class ContactDAO {

    private Fichier fichier;

    public ContactDAO(File nomDeFichier) {
        fichier = new Fichier(nomDeFichier, StandardCharsets.UTF_8);
    }

    public ArrayList<Personne> lire() {
        ArrayList<String> lignes = fichier.lire();
        ArrayList<Personne> personnes = new ArrayList<>();

        for (String ligne : lignes)
            personnes.add(StringToPersonne(ligne));

        return personnes;
    }

    public void save(Repertoire repertoire) {
        ArrayList<String> lignes = fichier.lire();
        for (Personne personne : repertoire.getAllContact())
            lignes.add(String.valueOf(personne));
        fichier.ecrire(lignes);
    }

    private Personne StringToPersonne(String ligne) {

        String[] colonnes = ligne.split("/");
        if(colonnes.length == 3 )
            return new Personne(colonnes[0], colonnes[1], colonnes[2]);
		return null;

    }
}
