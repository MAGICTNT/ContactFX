package application;



import java.io.File;

import fr.mj.contact.Personne;
import fr.mj.contact.Repertoire;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MenuController {
	
	private Main mainApp;
	
	@FXML
	MenuItem fichierFermer;
	@FXML
	MenuItem fichierSauvegarde;
	@FXML
	MenuItem fichierSauvegardeSous;
	@FXML
	MenuBar menuBar;
	@FXML
	Label nomDuFichier;

	@FXML
	TableView<Personne> tableView;
	@FXML
	TableColumn<Personne,String> tableauNom;
	@FXML
	TableColumn<Personne,String> tableauPrenom;
	@FXML
	TableColumn<Personne,String> tableauNaissance;
	
//	private Repertoire repertoire;
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	public void initialize() {
		gestionButtonMenuFichier(true);
	}

	@FXML
	public void chargement() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("textFile","*.txt"));
		fileChooser.setInitialDirectory(new File("C:\\java\\"));

		File selectionFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
		
		if(selectionFile != null) {
			mainApp.getPrimaryStage().setTitle(Main.APP_NAME + " - " + selectionFile); 
			gestionButtonMenuFichier(false);
			mainApp.setRepertoire(selectionFile);
			mainApp.getRepertoire().charger();
			mainApp.showGestionContact();
			System.out.println("document charger");
//		initialiseTableau();
		}

	}

	@FXML
	public void fermerFichier() {		
		mainApp.fermer();
		gestionButtonMenuFichier(true);
	}
	
	@FXML
	public void initialiseTableau() {
//		tableauNom.setCellValueFactory(cellData -> cellData.getValue().getNom());
//		tableauPrenom.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
//		tableauNaissance.setCellValueFactory(cellData -> cellData.getValue().getNumeroDeTelephone());
//		tableView.setItems(repertoire.getPersonneSortedList());
	}
	
	private void gestionButtonMenuFichier(boolean etat) {
		fichierFermer.setDisable(etat);
		fichierSauvegarde.setDisable(etat);
		fichierSauvegardeSous.setDisable(etat);
	}







	
}
