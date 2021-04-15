package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage stage;
	public static Alert loadingMessage;

	@Override
	public void start(Stage firstStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			firstStage.setTitle("App Matriculacions");
			firstStage.setScene(scene);
			firstStage.show();
			stage = firstStage;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void showLoadingMessage() {
		loadingMessage = new Alert(AlertType.NONE);
		loadingMessage.setHeight(100);
		loadingMessage.setWidth(200);
		loadingMessage.setContentText("Cargando...");
		loadingMessage.setTitle("");
		loadingMessage.show();
	}

	public static void closeLoadingMessage() {
		loadingMessage.getButtonTypes().add(ButtonType.CLOSE);
		loadingMessage.close();
	}
}
