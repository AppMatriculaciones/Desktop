package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.util.ResourceBundle;

import import_data.ImportCareers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowCiclosController implements Initializable {
	@FXML
	private Button btnVerCiclos;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btnVerCiclos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("entrando########################");
				goShowCiclos();
			}
		});
	}

	private void goShowCiclos() {
		AnchorPane root;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("ShowCiclosController.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Menu Principal");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newWindow() {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShowCiclos.fxml"));
		Parent root1;
		try {
			root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] ciclos = new String[] { "1", "2" };
		Accordion accordion = new Accordion();

		TitledPane pane1 = new TitledPane("Boats", new Label("Show all boats available"));
		TitledPane pane2 = new TitledPane("Cars", new Label("Show all cars available"));
		TitledPane pane3 = new TitledPane("Planes", new Label("Show all planes available"));

		accordion.getPanes().add(pane1);
		accordion.getPanes().add(pane2);
		accordion.getPanes().add(pane3);

		for (int i = 1; i < ciclos.length; i++) {
			for (int j = 0; j < ciclos.length; j++) {
				try {
					System.out.println(ciclos[i]);
					accordion.getPanes().add(createTitledPane("o", j));
				} catch (Exception e) {
				}
			}
		}
//
//		Accordion accordion = new Accordion();
//		VBox vBox = new VBox(accordion);
//		Scene scene = new Scene(vBox);
//		try {
//			AnchorPane root = FXMLLoader.load(getClass().getResource("ShowCiclos.fxml"));
//			Stage stage = new Stage();
//			stage.setTitle("Ventana 2");
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}

	}

	public TitledPane createTitledPane(String ciclo, int j) {
		String[] modulos = new String[] { "Modulo1", "Modulo2" };
		TitledPane titledPane = new TitledPane(ciclo, createLabel(j));
		return titledPane;
	}

	public Label createLabel(int j) {
		String[] ufs = new String[] { "UF1", "UF2" };
		Label Label = new Label(ufs[j]);
		return Label;
	}
}