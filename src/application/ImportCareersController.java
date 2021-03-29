package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import import_data.ImportCareers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class ImportCareersController implements Initializable {
	
	ImportCareers importCareers;
	
	@FXML
	private Button btnChooseCsv;

	@FXML
	private ListView<String> listVCareers;

	private ObservableList<String> listCareers;

	@FXML
	private Button btnImportar;

	@FXML
	private Button btnMenu;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listVCareers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listCareers = FXCollections.observableArrayList();
		listVCareers.setItems(listCareers);
	}

	@FXML
	public void chooseCsv() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File csv = fileChooser.showOpenDialog(Main.stage);
		
		Main.showLoadingMessage();
		importCareers = new ImportCareers(csv);
		importCareers.readCareers();
		for (int i = 0; i < importCareers.getCareersCode().size(); i++) {
			listCareers.add(importCareers.getCareersCode().get(i) + " - " + importCareers.getCareersName().get(i));
		}
		listVCareers.setItems(listCareers);
		Main.closeLoadingMessage();
	}
	
	@FXML
	public void importSelectedCareers() {
		Main.showLoadingMessage();
		ArrayList<String> selectedCareersCode = new ArrayList<String>();
		ObservableList<String> selectedCareers = listVCareers.getSelectionModel().getSelectedItems();
		for(String careerCode : selectedCareers){
			selectedCareersCode.add(careerCode.split(" - ")[0]);
        }
		importCareers.setSelectedCareersCode(selectedCareersCode);
		try {
			importCareers.importData();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while importing careers.");
			e.printStackTrace();
		}
		Main.closeLoadingMessage();
	}
	
	@FXML
	private void goMainMenu() {
    	AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Menu");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

}
