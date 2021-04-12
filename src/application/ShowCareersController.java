package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import data_access.DaoI;
import data_access.DaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import models.Career;
import models.Mp;
import models.Uf;

public class ShowCareersController implements Initializable {

	private static DaoI daoI = new DaoImpl();

	@FXML
	private AnchorPane apShowCareers;

	@FXML
	private AnchorPane apAccordion;

	@FXML
	private Label lblCareers;

	@FXML
	private ComboBox<String> cboxCareers;

	private String nameCareerSelected;

	private Career careerSelected;

	private ArrayList<Career> careers;

	@FXML
	private Button btnSelect;

	@FXML
	private Button btnMenu;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		careers = daoI.getCareers();
		ArrayList<String> careersName = getCareersName(careers);
		ObservableList<String> listCareers = FXCollections.observableArrayList(careersName);
		cboxCareers.setItems(listCareers);

	}

	private ArrayList<String> getCareersName(ArrayList<Career> careers) {
		ArrayList<String> careersName = new ArrayList<String>();
		for (Career career : careers) {
			careersName.add(career.getName());
		}
		return careersName;
	}

	@FXML
	private Career getSelectedCareer() {
		nameCareerSelected = cboxCareers.getSelectionModel().getSelectedItem();
		for (Career career : careers) {
			if (nameCareerSelected.equals(career.getName())) {
				return career;
			}
		}
		return null;
	}

	@FXML
	private void loadAccordion() {
		Accordion accMps = new Accordion();
		accMps.snapPositionX(50);
		accMps.snapPositionY(50);
		accMps.setPrefHeight(300);
		accMps.setPrefWidth(600);
		careerSelected = getSelectedCareer();
		ArrayList<Mp> mps = daoI.getMpsByCareer(careerSelected.getCode());

		for (Mp mp : mps) {
			ArrayList<Uf> ufs = daoI.getUfsByMp(mp.getCode());
			ArrayList<String> ufsInfo = getUfInfo(ufs);

			AnchorPane apMp = new AnchorPane();
			ListView<String> listVMp = new ListView<String>();
			ObservableList<String> listUfs = FXCollections.observableArrayList(ufsInfo);
			listVMp.setItems(listUfs);
			apMp.getChildren().add(listVMp);

			TitledPane tpMp = new TitledPane(mp.getName(), apMp);

			accMps.getPanes().add(tpMp);
		}

		apAccordion.getChildren().add(accMps);
	}

	private ArrayList<String> getUfInfo(ArrayList<Uf> ufs) {
		ArrayList<String> ufsInfo = new ArrayList<String>();

		for (Uf uf : ufs) {
			ufsInfo.add(uf.getCode() + " " + uf.getName() + " " + uf.getDuration() + " H");
		}
		return ufsInfo;
	}
	
	@FXML
	private void goMainMenu() {
		AnchorPane root;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Menu");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
