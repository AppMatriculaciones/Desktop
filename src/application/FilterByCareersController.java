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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.Career;

public class FilterByCareersController implements Initializable{
	
	private static DaoI daoI = new DaoImpl();
	
	private String careersCodeSelected = "";
	
	private ObservableList<String> listCareers;
	
	private ObservableList<String> listCareersSelected;
	
	@FXML
    private ListView<String> listVCareers;

    @FXML
    private ListView<String> listVCareersSelected;

    @FXML
    private Button btnAddMany;

    @FXML
    private Button btnAddOne;

    @FXML
    private Button btnCleanFilter;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSearch;
    
    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfCodeCareer;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listVCareers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listCareers = FXCollections.observableArrayList(this.getCareersCode());
		listVCareers.setItems(listCareers);
		
		
		listVCareersSelected.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listCareersSelected = FXCollections.observableArrayList();
		listVCareersSelected.setItems(listCareersSelected);
	}
	
	@FXML
	private void goShowStudentsSearch() {
		AnchorPane root;
		try {
			careersCodeSelected = "";
			if(listCareersSelected.size() > 0) {
				for(String career: listCareersSelected) {
					careersCodeSelected = careersCodeSelected+"&"+career;
				}
				ShowStudentsController.studentsFetched = daoI.getStudentsByCareersCode(careersCodeSelected);
			}else {
				ShowStudentsController.studentsFetched = daoI.getStudents();
			}
		
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("ShowStudents.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Ver estudiantes");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	private void goShowStudentsCancel() {
		AnchorPane root;
		try {
			careersCodeSelected = "";
			ShowStudentsController.studentsFetched = null;
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("ShowStudents.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Ver estudiantes");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> getCareersCode(){
		ArrayList<String> careersCode = new ArrayList<String>();
		ArrayList<Career> careers = daoI.getCareers();
		for(Career career: careers) {
			careersCode.add(career.getCode());
		}
		return careersCode;
	}
	
	public void addOne() {
		listCareersSelected.add(tfCodeCareer.getText());
		listVCareersSelected.setItems(listCareersSelected);
		tfCodeCareer.clear();
	}
	
	public void addMany() {
		ObservableList<String> addCareers = listVCareers.getSelectionModel().getSelectedItems();
		for(String career: addCareers) {
			listCareersSelected.add(career);
		}
		listVCareersSelected.setItems(listCareersSelected);
	}
	
	public void remove() {
		ObservableList<String> removeCareers = listVCareersSelected.getSelectionModel().getSelectedItems();
		for(String career: removeCareers) {
			listCareersSelected.remove(career);
		}
		listVCareersSelected.setItems(listCareersSelected);
	}
	
	public void clearFilter() {
		listCareersSelected.clear();
		listVCareersSelected.setItems(listCareersSelected);
	}

}
