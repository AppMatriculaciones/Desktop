package application;

import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import models.RequirementsProfile;
import models.Student;
import models.Tutor;
import models.Uf;

public class DetailsStudentController implements Initializable{
	
	private Student selectedStudent;
	
	private ArrayList<Uf> ufs_completed;
	
	private RequirementsProfile reqProfile;
	
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
	    private ComboBox<?> cboxIdType;

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
		reqProfile = ShowStudentsController.reqProfile;
		allReqProfiles = ShowStudentsController.allReqProfiles;
		ToggleGroup toggleGroup = new ToggleGroup();
		rdBtnMan.setToggleGroup(toggleGroup);
		rdBtnWoman.setToggleGroup(toggleGroup);
		loadData();
		System.out.println(selectedStudent);
		for(Uf uf: ufs_completed) {
			System.out.println(uf);
		}
		System.out.println(reqProfile);
		System.out.println(allReqProfiles);
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
		
		if(selectedStudent.getSex().equals("Home")) {
			rdBtnMan.setSelected(true);
		}else {
			rdBtnWoman.setSelected(true);
		}
		/*
		    cboxIdType
		   cBirthday
		   rdBtnMan
		  rdBtnWoman
		    
		   cboxReqProfile 
		   listVTutors*/
	}

}
