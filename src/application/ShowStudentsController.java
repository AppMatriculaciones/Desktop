package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import data_access.DaoI;
import data_access.DaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.Enrollment;
import models.RequirementsProfile;
import models.Student;
import models.Uf;

public class ShowStudentsController implements Initializable {
	
	protected static ArrayList<Student> studentsFetched;
	
	protected static Student selectedStudent;
	
	protected static ArrayList<Uf> ufs_completed;
	
	protected static ArrayList<RequirementsProfile> allReqProfiles;
	
	protected static Enrollment selectedStudentEnrollment;
	
	private static DaoI daoI = new DaoImpl();

	@FXML
	private ListView<Student> listVStudents;

	@FXML
	private Button btnMenu;

	@FXML
	private Button btnFilter;

	private ObservableList<Student> listStudents;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listVStudents.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		if(studentsFetched != null) {
			listStudents = FXCollections.observableArrayList(studentsFetched);
			listVStudents.setItems(listStudents);
		}
		
		listVStudents.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				selectedStudent = listVStudents.getSelectionModel().getSelectedItem();
				createAlert();
			}
			
		});
		
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
	
	private void createAlert() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Seleccione una opcion:");
		ButtonType btnDetails = new ButtonType("Detalles alumno");
		ButtonType btnDocuments = new ButtonType("Documentos alumno");
		ButtonType btnCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(btnDetails, btnDocuments, btnCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == btnDetails){
			ufs_completed = getUfsCompleted(selectedStudent);
			allReqProfiles = daoI.getRequirementsProfile();
		    goDetailsStudent();
		} else if (result.get() == btnDocuments) {
		    selectedStudentEnrollment = daoI.getEnrollmentByStudentId(selectedStudent);
		    goDocumentsStudent();
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
	}
	
	private ArrayList<Uf> getUfsCompleted(Student student){
		ArrayList<Uf> ufs_completed = new ArrayList<Uf>();
		for(String uf_id: student.getUfs_completed()) {
			Uf uf = daoI.getUfById(uf_id);
			ufs_completed.add(uf);
		}
		return ufs_completed;
	}
	
	@FXML
	private void goDetailsStudent() {
		AnchorPane root;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("DetailsStudent.fxml"));
			Scene scene = new Scene(root, 900, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Detailles alumno");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void goDocumentsStudent() {
		AnchorPane root;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("DocumentsStudent.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Documentos alumno");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
