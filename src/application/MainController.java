package application;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {

	@FXML
	private Button boton;

	@FXML
	private TextField txt_username;

	@FXML
	private TextField txt_password;
	
	@FXML
	private ComboBox<String> cb_Ciclos;
	ObservableList<String> data = FXCollections.observableArrayList("a","b","c");
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		boton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				newWindow();
				/*
				String user = txt_username.getText();
				String password = txt_password.getText();
				boolean si = validationAdmins(user, password);
				System.out.println(si);
				if (si == true) {
					newWindow();
				} else {

				}
				*/
			}
		});

	}

	public boolean validationAdmins(String user, String psswd) {
		System.out.println(user);
		System.out.println(psswd);
		String msg = "{\"msg\":\"Authentification failed.\"}";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://appmatriculacioaaj.herokuapp.com/login/admins/" + user + "/" + psswd)).build();
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			String httpResponse = response.body().toString();
			if (httpResponse.equals(msg) == false) {
				return true;
			} else {
				return false;
			}
		} catch (ConnectException ce) {
			System.out.println("Conexion Refused");
			return loginError(ce);
		} catch (Exception e) {
			return loginError(e);
		}
	}

	public void newWindow() {
		AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("SecondWindow.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Ventana 2");
			stage.setScene(new Scene(root, 900, 600));
			stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
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
