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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import models.Enrollment;
import models.Requirement;
import models.RequirementRow;

public class DocumentsStudentController implements Initializable {

	public static Enrollment selectedStudentEnrollment;

	@FXML
	private AnchorPane aDocumentsStudent;

	private ArrayList<RequirementRow> requirementsRows = new ArrayList<RequirementRow>();

	@FXML
	private TableView<RequirementRow> tableVDocuments;

	@FXML
	private Button btnReturn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		selectedStudentEnrollment = ShowStudentsController.selectedStudentEnrollment;
		System.out.println(selectedStudentEnrollment);

		TableColumn imageCol = new TableColumn("Documento");
		TableColumn btnValidateCol = new TableColumn("Accion");
		TableColumn btnDenyCol = new TableColumn("Accion");
		tableVDocuments.getColumns().addAll(imageCol, btnValidateCol, btnDenyCol);
		
		for (int i = 0; i < selectedStudentEnrollment.getRequirements().size(); i++) {
			RequirementRow reqRow = new RequirementRow(selectedStudentEnrollment.getRequirements().get(i), i);
			requirementsRows.add(reqRow);
		}
		
		ObservableList<RequirementRow> rows = FXCollections.observableArrayList(requirementsRows);
		imageCol.setCellValueFactory(
				new PropertyValueFactory<RequirementRow, String>("imageView")
				);
		btnValidateCol.setCellValueFactory(
				new PropertyValueFactory<RequirementRow, String>("btnValidate")
				);
		btnDenyCol.setCellValueFactory(
				new PropertyValueFactory<RequirementRow, String>("btnDeny")
				);
		
		tableVDocuments.setItems(rows);
	}
	
	@FXML
	private void goShowStudents() {
		AnchorPane root;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("ShowStudents.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Ver alumnos");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
