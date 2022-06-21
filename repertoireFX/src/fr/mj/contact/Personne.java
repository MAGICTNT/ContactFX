package fr.mj.contact;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne implements Comparable<Personne>{

    private StringProperty nom;
    private StringProperty prenom;
    private ObjectProperty<LocalDate> dateDeNaissance;
    private StringProperty numeroDeTelephone;

    public Personne(String nom, String prenom, String numeroDeTelephone) {
        this.nom = new SimpleStringProperty();
        this.prenom =  new SimpleStringProperty();
        this.dateDeNaissance = new SimpleObjectProperty<LocalDate>();
        this.numeroDeTelephone =  new SimpleStringProperty();
    }



    public StringProperty getNom() {
		return nom;
	}



	public void setNom(StringProperty nom) {
		this.nom = nom;
	}



	public StringProperty getPrenom() {
		return prenom;
	}



	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}



	public ObjectProperty<LocalDate> getDateDeNaissance() {
		return dateDeNaissance;
	}



	public void setDateDeNaissance(ObjectProperty<LocalDate> dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}



	public StringProperty getNumeroDeTelephone() {
		return numeroDeTelephone;
	}



	public void setNumeroDeTelephone(StringProperty numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}



	@Override
    public int compareTo(Personne o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroDeTelephone='" + numeroDeTelephone + '\'' +
                '}';
    }
}
