package application;
	
import java.io.File;
import java.io.IOException;

import fr.mj.contact.Repertoire;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	static final String APP_NAME = "Gestion des contact exo";
	
	private Repertoire repertoire;

	@FXML
	AnchorPane menuLayout;
	
	@FXML
	TableView tableView;
	@FXML
	TableColumn tableauNom;
	@FXML
	TableColumn tableauPrenom;
	@FXML
	TableColumn tableauNaissance;
	
	
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(APP_NAME);
        try {
            FXMLLoader myFXMLloader = new FXMLLoader(Main.class.getResource("/layout/Menu.fxml"));
            menuLayout = myFXMLloader.load();
            Scene scene = new Scene(menuLayout);
            scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
            primaryStage.setScene(scene);
            MenuController menuController = myFXMLloader.getController();
            menuController.setMainApp(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setRepertoire(File file) {
		this.repertoire = new Repertoire(file);
	}

	public Repertoire getRepertoire() {
		return repertoire;
	}

	public void fermer() {
		// Method pour voir si un changement a etait fait
		this.repertoire = null;
		if(repertoire == null)
			System.out.println("repertoire null");
		else
			System.out.println("repertoire pas null");
	}
	
	@Override
	public void stop() throws Exception{
		repertoirChanged();
}


	private void repertoirChanged() {
		// TODO Auto-generated method stub
	}


	public void showGestionContact() {
		try {
			FXMLLoader myFXMLloader = new FXMLLoader(Main.class.getResource("/layout/tableau.fxml"));
            menuLayout = myFXMLloader.load();
			
		}catch(Exception e){
			
		}
	}


}
