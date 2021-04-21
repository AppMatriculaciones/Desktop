package models;

import application.DocumentsStudentController;
import application.Main;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RequirementRow {

	private Requirement requirement;
	private ImageView imageView;
	private Button btnValidate;
	private Button btnDeny;
	private int index;
	
	public RequirementRow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequirementRow(Requirement requirement, int index) {
		super();
		this.requirement = requirement;
		this.imageView = new ImageView(new Image("https://appmatriculacioaaj.herokuapp.com/document/get/"+requirement.getPath()));
		this.imageView.setFitWidth(200);
		this.imageView.setPreserveRatio(true);
		this.btnValidate = new Button("Validar");
		this.btnDeny = new Button("Denegar");
		this.index = index;
		
		this.btnValidate.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	DocumentsStudentController.selectedStudentEnrollment.getRequirements().get(index).setStatus(2);
	        	Main.daoI.updateEnrollmentById(DocumentsStudentController.selectedStudentEnrollment);
	        }
	    });
		
		this.btnDeny.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	DocumentsStudentController.selectedStudentEnrollment.getRequirements().get(index).setStatus(3);
	        	Main.daoI.updateEnrollmentById(DocumentsStudentController.selectedStudentEnrollment);
	        }
	    });
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public Button getBtnValidate() {
		return btnValidate;
	}

	public void setBtnValidate(Button btnValidate) {
		this.btnValidate = btnValidate;
	}

	public Button getBtnDeny() {
		return btnDeny;
	}

	public void setBtnDeny(Button btnDeny) {
		this.btnDeny = btnDeny;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
