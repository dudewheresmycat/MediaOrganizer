package gabeAndJakeFinalProject.mediaOrganizer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaOrganizerGUI extends Application {
	//REQ #9
	@Override
	public void start(Stage stage) throws Exception {
		
		// Load the FXML file.
		Parent parent = FXMLLoader.load(getClass().getResource("MediaOrganizer.fxml"));

		// Build the scene graph
		Scene scene = new Scene(parent);

		// Display our window, using the scene graph.
		stage.setTitle("Tunes Library - A creation by Jake and Gabe");//REQ#1
		stage.setScene(scene);
		stage.show();
		
	     
	}

	public static void main(String[] args) {
		// Launch the application
		launch(args);
	}
}