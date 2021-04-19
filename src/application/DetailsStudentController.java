package application;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import data_access.DaoI;
import data_access.DaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.DocumentId;
import models.RequirementsProfile;
import models.Student;
import models.Tutor;
import models.Uf;

public class DetailsStudentController implements Initializable {
	
	private static DaoI daoI = new DaoImpl();

	private Student selectedStudent;

	private ArrayList<Uf> ufs_completed;

	private ArrayList<RequirementsProfile> allReqProfiles;

	@FXML
	private Label lblName;

	@FXML
	private Label lbFirstSurname;

	@FXML
	private Label lbSecondSurname;

	@FXML
	private Label lbEmail;

	@FXML
	private Label lbPhone;

	@FXML
	private Label lbRalcId;

	@FXML
	private TextField tfName;

	@FXML
	private TextField tfFirstSurname;

	@FXML
	private TextField tfSecondSurname;

	@FXML
	private TextField tfEmail;

	@FXML
	private TextField tfPhone;

	@FXML
	private TextField tfRalcId;

	@FXML
	private Label lbId;

	@FXML
	private Label lbIdType;

	@FXML
	private TextField tfId;

	@FXML
	private ComboBox<String> cboxIdType;

	@FXML
	private Label cBirthday;

	@FXML
	private Label lbSex;

	@FXML
	private RadioButton rdBtnMan;

	@FXML
	private RadioButton rdBtnWoman;

	@FXML
	private Label lbCityBirth;

	@FXML
	private Label lbCountryBirth;

	@FXML
	private Label lbAddress;

	@FXML
	private Label lbType;

	@FXML
	private Label lbNameAddress;

	@FXML
	private Label lbNumber;

	@FXML
	private Label lbOthers;

	@FXML
	private TextField tfType;

	@FXML
	private TextField tfNameAddress;

	@FXML
	private TextField tfNumber;

	@FXML
	private TextField tfOthers;

	@FXML
	private Label lbState;

	@FXML
	private TextField tfState;

	@FXML
	private Label lbCity;

	@FXML
	private TextField tfCity;

	@FXML
	private Label lbDistrict;

	@FXML
	private TextField tfDistrict;

	@FXML
	private Label lbCp;

	@FXML
	private Label lbCountry;

	@FXML
	private TextField tfCountry;

	@FXML
	private Label lbLenguajes;

	@FXML
	private TextField tfLenguajes;

	@FXML
	private Label lbReligion;

	@FXML
	private TextField tfReligion;

	@FXML
	private Label lbNationality;

	@FXML
	private TextField tfNationality;

	@FXML
	private Label lbGeneralData;

	@FXML
	private Label lbOtherData;

	@FXML
	private Label lbSchoolCode;

	@FXML
	private Label lbSchoolName;

	@FXML
	private Label lbCourseCode;

	@FXML
	private Label lbCourseName;

	@FXML
	private Label lbCourseProc;

	@FXML
	private TextField tfSchoolCode;

	@FXML
	private TextField tfSchoolName;

	@FXML
	private TextField tfCourrseCode;

	@FXML
	private TextField tfCourseName;

	@FXML
	private TextField tfCourseProc;

	@FXML
	private Label lbRequirementsProfile;

	@FXML
	private ComboBox<RequirementsProfile> cboxReqProfile;

	@FXML
	private Label lbUfsCompleted;

	@FXML
	private Label lbTutors;

	@FXML
	private ListView<Tutor> listVTutors;

	@FXML
	private ListView<Uf> listVUfsCompleted;

	@FXML
	private Button btnAddTutor;

	@FXML
	private Button btnDeleteTutor;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnSave;

	@FXML
	private TextField tfCp;

	@FXML
	private TextField tfBirthCountry;

	@FXML
	private TextField tfBirthCity;

	@FXML
	private DatePicker calBirthday;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		selectedStudent = ShowStudentsController.selectedStudent;
		ufs_completed = ShowStudentsController.ufs_completed;
		allReqProfiles = ShowStudentsController.allReqProfiles;

		ToggleGroup toggleGroup = new ToggleGroup();
		rdBtnMan.setToggleGroup(toggleGroup);
		rdBtnWoman.setToggleGroup(toggleGroup);

		loadData();
	}

	private void loadData() {
		tfName.setText(selectedStudent.getName());
		tfFirstSurname.setText(selectedStudent.getFirst_surname());
		tfSecondSurname.setText(selectedStudent.getSecond_surname());
		tfEmail.setText(selectedStudent.getEmail());
		tfPhone.setText(String.valueOf(selectedStudent.getPhone()));
		tfRalcId.setText(selectedStudent.getRalc_id());
		tfId.setText(selectedStudent.getDocument_id().getId());
		tfType.setText(selectedStudent.getDocument_id().getType());
		tfNameAddress.setText(selectedStudent.getAddress().getName());
		tfNumber.setText(selectedStudent.getAddress().getNumber());
		tfOthers.setText(selectedStudent.getAddress().getOthers());
		tfState.setText(selectedStudent.getAddress().getState());
		tfCity.setText(selectedStudent.getAddress().getCity());
		tfDistrict.setText(selectedStudent.getAddress().getDistrict());
		tfCountry.setText(selectedStudent.getAddress().getCountry());
		tfLenguajes.setText(selectedStudent.getLanguages());
		tfReligion.setText(selectedStudent.getReligion());
		tfNationality.setText(selectedStudent.getNationality());
		tfSchoolCode.setText(selectedStudent.getFormer_studies().getSchool_code());
		tfSchoolName.setText(selectedStudent.getFormer_studies().getSchool_name());
		tfCourrseCode.setText(selectedStudent.getFormer_studies().getCourse_code());
		tfCourseName.setText(selectedStudent.getFormer_studies().getCourse_name());
		tfCourseProc.setText(selectedStudent.getFormer_studies().getCourse_proc());
		tfReligion.setText(selectedStudent.getReligion());
		tfCp.setText(selectedStudent.getAddress().getCp());
		tfBirthCountry.setText(selectedStudent.getBirthplace().getCountry());
		tfBirthCity.setText(selectedStudent.getBirthplace().getCity());
		calBirthday.setValue(selectedStudent.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

		if (selectedStudent.getSex().equals("Home")) {
			rdBtnMan.setSelected(true);
		} else {
			rdBtnWoman.setSelected(true);
		}

		ObservableList<String> optionsDocType = FXCollections.observableArrayList("DNI", "NIE", "PASS");
		cboxIdType.setItems(optionsDocType);
		cboxIdType.setValue(selectedStudent.getDocument_id().getType());

		ObservableList<RequirementsProfile> optionsReqProfiles = FXCollections.observableArrayList(allReqProfiles);
		cboxReqProfile.setItems(optionsReqProfiles);
		for (RequirementsProfile rp : allReqProfiles) {
			if (rp.get_id().equals(selectedStudent.getRequirements_profile_id())) {
				cboxReqProfile.setValue(rp);
			}
		}

		ObservableList<Uf> ufs_completedList = FXCollections.observableArrayList(ufs_completed);
		listVUfsCompleted.setItems(ufs_completedList);

		ObservableList<Tutor> tutorsList = FXCollections.observableArrayList(selectedStudent.getTutors());
		listVTutors.setItems(tutorsList);
	}
	
	@FXML
	private void deleteTutor() {
		int selectedIndex = listVTutors.getSelectionModel().getSelectedIndex();
		selectedStudent.getTutors().remove(listVTutors.getItems().get(selectedIndex));
		listVTutors.getItems().remove(selectedIndex);
	}
	
	@FXML
	private void addTutor() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Rellene los campos indicados del nuevo tutor:");
		
		GridPane gridPane = new GridPane();
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);

	    ChoiceBox<String> cboxDocType = new ChoiceBox<String>();
	    cboxDocType.getItems().addAll("DNI", "NIE", "PASS");
	    TextField tfDocId = new TextField();
	    tfDocId.setPromptText("ID");
	    TextField tfName = new TextField();
	    tfName.setPromptText("Nombre");
	    TextField tfFirstSurname = new TextField();
	    tfFirstSurname.setPromptText("Primer apellido");
	    TextField tfSecondSurname = new TextField();
	    tfSecondSurname.setPromptText("Segundo apellido");
	    
	    ButtonType btnAdd = new ButtonType("Añadir");
		ButtonType btnCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);

	    gridPane.add(cboxDocType, 0, 0);
	    gridPane.add(tfDocId, 2, 0);
	    gridPane.add(tfName, 0, 2);
	    gridPane.add(tfFirstSurname, 2, 2);
	    gridPane.add(tfSecondSurname, 4, 2);

	    alert.getDialogPane().setContent(gridPane);
	    
		alert.getButtonTypes().setAll(btnAdd, btnCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == btnAdd){
		    DocumentId docIdTutor = new DocumentId(cboxDocType.getSelectionModel().getSelectedItem(), tfDocId.getText());
		    Tutor newTutor = new Tutor(docIdTutor, tfName.getText(), tfFirstSurname.getText(), tfSecondSurname.getText());
		    selectedStudent.getTutors().add(newTutor);
		    ObservableList<Tutor> tutorsList = FXCollections.observableArrayList(selectedStudent.getTutors());
			listVTutors.setItems(tutorsList);
		} 
	}
	
	@FXML
	private void saveData() {
		selectedStudent.setName(tfName.getText());
		selectedStudent.setFirst_surname(tfFirstSurname.getText());
		selectedStudent.setSecond_surname(tfSecondSurname.getText());
		selectedStudent.setEmail(tfEmail.getText());
		
		try {
			int newPhone = Integer.valueOf(tfPhone.getText());
			selectedStudent.setPhone(newPhone);
		}catch (Exception e){
			
		}
		
		selectedStudent.setRalc_id(tfRalcId.getText());
		selectedStudent.getDocument_id().setId(tfId.getText());
		selectedStudent.getAddress().setName(tfNameAddress.getText());
		selectedStudent.getAddress().setNumber(tfNumber.getText());
		selectedStudent.getAddress().setOthers(tfOthers.getText());
		selectedStudent.getAddress().setState(tfState.getText());
		selectedStudent.getAddress().setCity(tfCity.getText());
		selectedStudent.getAddress().setDistrict(tfDistrict.getText());
		selectedStudent.getAddress().setCountry(tfCountry.getText());
		selectedStudent.setLanguages(tfLenguajes.getText());
		selectedStudent.setReligion(tfReligion.getText());
		selectedStudent.setNationality(tfNationality.getText());
		selectedStudent.getFormer_studies().setSchool_code(tfSchoolCode.getText());
		selectedStudent.getFormer_studies().setSchool_name(tfSchoolName.getText());
		selectedStudent.getFormer_studies().setCourse_code(tfCourrseCode.getText());
		selectedStudent.getFormer_studies().setCourse_name(tfCourseName.getText());
		selectedStudent.getFormer_studies().setCourse_proc(tfCourseProc.getText());
		//tfType.setText(selectedStudent.getDocument_id().getType());
		selectedStudent.getAddress().setCp(tfCp.getText());
		selectedStudent.getBirthplace().setCountry(tfBirthCountry.getText());
		selectedStudent.getBirthplace().setCity(tfBirthCity.getText());
		Date newBirthday = Date.from(calBirthday.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()); 
		selectedStudent.setBirthday(newBirthday);
		
		if(cboxIdType.getSelectionModel().getSelectedItem() != null) {
			selectedStudent.getDocument_id().setType(cboxIdType.getSelectionModel().getSelectedItem());
		}
		if(cboxReqProfile.getSelectionModel().getSelectedItem() != null) {
			System.out.println(cboxReqProfile.getSelectionModel().getSelectedItem().get_id());
			selectedStudent.setRequirements_profile_id(cboxReqProfile.getSelectionModel().getSelectedItem().get_id());
		}
		
		if (rdBtnMan.isSelected()) {
			selectedStudent.setSex("Home");
		} else {
			selectedStudent.setSex("Mujer");
		}
		
		daoI.updateStudentByDocId(selectedStudent);
		goShowStudents();
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
