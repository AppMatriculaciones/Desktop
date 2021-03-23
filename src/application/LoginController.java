package application;

import java.net.ConnectException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

import data_access.GenerateHttpRequest;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

	@FXML
	private Button boton;

	@FXML
	private TextField txt_username;

	@FXML
	private TextField txt_password;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String user = txt_username.getText();
				String password = txt_password.getText();
				boolean si = validationAdmins(user, password);
				System.out.println(si);
				if (si == true) {
					System.out.println("LOGIN CORRECTO");
					ShowCiclosController showcicloscontroller = new ShowCiclosController();
					showcicloscontroller.newWindow();
				} else {
				}
			}
		});

	}

	public boolean validationAdmins(String user, String psswd) {
		String msgFail = "{\"msg\":\"Authentification failed.\"}";
		String responseBody = GenerateHttpRequest.get("/login/admin/"+user+"/"+psswd);
		if(responseBody.equals(msgFail)) {
			return false;
		}else {
			return true;
		}
	}

	public boolean loginError(Exception e) {
		e.printStackTrace();
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Login Error");
		alert.setHeaderText("Login Error");
		alert.setContentText("Has introducido mal el usuario/contraseña");
		alert.showAndWait();
		return false;
	}
}
