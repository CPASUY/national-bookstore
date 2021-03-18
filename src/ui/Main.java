package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("PaneBase.fxml"));
		NationalLibraryController nlc=new NationalLibraryController(primaryStage);
		fxmload.setController(nlc);
		Parent root=fxmload.load();
		Scene scene = new Scene(root,676,481);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("National Book Store");
		nlc.initialize();
		nlc.loadConfiguration();
	}

}
