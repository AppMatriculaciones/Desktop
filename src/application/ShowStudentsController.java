package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import models.Student;

public class ShowStudentsController implements Initializable {
	
	protected static ArrayList<Student> studentsFetched;
	
	private ArrayList<String> students = new ArrayList<String>();

	@FXML
	private ListView<String> listVStudents;

	@FXML
	private Button btnMenu;

	@FXML
	private Button btnFilter;

	private ObservableList<String> listStudents;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listVStudents.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		if(studentsFetched != null) {
			students = new ArrayList<String>();
			for(Student student: studentsFetched) {
				students.add(student.getDocument_id().getId()+" "+student.getName()+" "+student.getFirst_surname()+" "+student.getSecond_surname());
			}
			listStudents = FXCollections.observableArrayList(students);
			listVStudents.setItems(listStudents);
		}
		
	}

	@FXML
	private void goFilterByCareers() {
		AnchorPane root;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("FilterByCareers.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Filtrar por ciclos");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
