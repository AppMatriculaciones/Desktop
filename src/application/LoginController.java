package application;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

	@FXML
	private Button boton;

	@FXML
	private TextField txt_username;

	@FXML
	private TextField txt_password;

	@FXML
	private Button btnVerCiclos;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Main.showLoadingMessage();
				String user = txt_username.getText();
				String password = txt_password.getText();
				boolean si = validationAdmins(user, password);
				System.out.println(si);
				if (si == true) {
					System.out.println("LOGIN CORRECTO");
					Main.closeLoadingMessage();
					goMainMenu();
				} else {
				}
			}
		});
	}

	public boolean validationAdmins(String user, String psswd) {
		String msgFail = "{\"msg\":\"Authentification failed.\"}";
		String responseBody = GenerateHttpRequest.get("/login/admin/" + user + "/" + psswd);
		if (responseBody.equals(msgFail)) {
			return false;
		} else {
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

	private void goMainMenu() {
		AnchorPane root;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Menu Principal");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
