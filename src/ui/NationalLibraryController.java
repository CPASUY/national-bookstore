package ui;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class NationalLibraryController {
	
	private Stage stage;
	
	@FXML
	private BorderPane basePane;
	public NationalLibraryController(Stage s) {
		stage=s;
	}
	public void initialize() {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				System.out.println("Closing the window!");
			}
		});

	}
	public void loadSeccion1() throws IOException {
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion1.fxml"));
		fxmload.setController(this);
		Parent root;
		root = fxmload.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
	}
	public void loadSeccion2() throws IOException{
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion2.fxml"));
		fxmload.setController(this);
		Parent root;
		root = fxmload.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
	}
	public void loadSeccion3() throws IOException{
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion3.fxml"));
		fxmload.setController(this);
		Parent root;
		root = fxmload.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
	}
}
