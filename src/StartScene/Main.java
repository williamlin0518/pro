package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("FinalProject");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		File f = new File("C:\\music2.mp3");
	 	Media media = new Media(f.toURI().toString());
	 	final JFXPanel fxPanel = new JFXPanel();
   		MediaPlayer mediaPlayer = new MediaPlayer(media);
   		
   		mediaPlayer.setVolume(0.3);
    	mediaPlayer.play();
		launch(args);
	}
}
