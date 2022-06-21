package fr.mj.contact;

import fr.mj.dao.ContactDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Repertoire {

    private File nomFichier;
    private final Charset charset = StandardCharsets.UTF_8;

    private boolean modification;
    private ObservableList<Personne> AllContact;
    private FilteredList<Personne> listFiltre;
    private SortedList<Personne> personneSortedList;
    private ContactDAO contactDAO;



    public Repertoire(File nomFichier) {
    	contactDAO = new ContactDAO(nomFichier);
    	AllContact = FXCollections.observableArrayList();
    	listFiltre = new FilteredList<Personne>(AllContact , criter -> true);
    	personneSortedList = new SortedList<Personne>(listFiltre);
    }


    public File getNomFichier() {
        return nomFichier;
    }
    public void setNomFichier(File nomFichier) {
        this.nomFichier = nomFichier;
    }
    public Charset getCharset() {
        return charset;
    }
    public boolean ModificationFaite() {
        return modification = true;
    }

    public boolean ModificationSave() {
        return modification = false;
    }

    public void nouveauFichier(){
    	AllContact = (ObservableList<Personne>) new ContactDAO(nomFichier).lire();
    }

    public boolean isModification() {
        return modification;
    }

    public ObservableList<Personne> getAllContact() {
		return AllContact;
	}





	public void setAllContact(ObservableList<Personne> allContact) {
		AllContact = allContact;
	}





	public FilteredList<Personne> getListFiltre() {
		return listFiltre;
	}



	public void setListFiltre(FilteredList<Personne> listFiltre) {
		this.listFiltre = listFiltre;
	}


	public SortedList<Personne> getPersonneSortedList() {
		return personneSortedList;
	}


	public void setPersonneSortedList(SortedList<Personne> personneSortedList) {
		this.personneSortedList = personneSortedList;
	}


	public ContactDAO getContactDAO() {
		return contactDAO;
	}


	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}


	public void setModification(boolean modification) {
		this.modification = modification;
	}


	public void ajouterContact(Personne personne) {
        getAllContact().add(personne);
    }

    public void suprimerContact(Personne personne) {
        getAllContact().remove(personne);
    }

	public void charger() {
		AllContact = FXCollections.observableArrayList(contactDAO.lire());
    	listFiltre = new FilteredList<Personne>(AllContact , criter -> true);
    	personneSortedList = new SortedList(AllContact);
//		AllContact = new ContactDAO(nomFichier).lire();
	}
	
	
	
	private void actualiseContact(String filtre) {
		listFiltre.setPredicate(personne -> isContains(filtre, personne));
	}
	private boolean isContains(String filtre, Personne personne) {
		boolean nom = ((List<Personne>) personne.getNom()).contains(filtre.toUpperCase());
		boolean prenom = ((List<Personne>) personne.getPrenom()).contains(filtre.toUpperCase());
		
		return nom || prenom;
	}


}
