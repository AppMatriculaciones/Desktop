package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import import_data.ImportCareers;
import import_data.ImportStudent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class ImportAlumnsController implements Initializable {
	@FXML
	private Button btnChooseCsv;

	@FXML
	private Button btnImportar;

	@FXML
	private Button btnMenu;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	public void chooseCsv() {
		FileChooser fileChooser = new FileChooser();
		ImportStudent is = new ImportStudent();
		fileChooser.setTitle("Open Resource File");
		File csv = fileChooser.showOpenDialog(Main.stage);
		Main.showLoadingMessage();
		try {
			is.readAlumns(csv);
			JOptionPane.showMessageDialog(null, "Insercion Correcta!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insercion INCORRECTA!");
		}
		Main.closeLoadingMessage();
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