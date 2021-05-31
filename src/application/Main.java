package application;


import java.io.File;

import Player.Player;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import view.GameView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
        	/*Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("FinalProject");
			primaryStage.setScene(scene);
			primaryStage.show();*/
        	int playerX=215*Player.UNIT_SIZE,playerY=175*Player.UNIT_SIZE;
	        GameView gameView =new GameView(playerX,playerY,false);
	        gameView.createNewGame(primaryStage);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    	File f = new File("C:\\Users\\user\\Desktop\\ProjectLearning\\NEWest\\music.mp3");
	 	Media media = new Media(f.toURI().toString());
	 	final JFXPanel fxPanel = new JFXPanel();
   		MediaPlayer mediaPlayer = new MediaPlayer(media);
   		
   		mediaPlayer.setVolume(0);
    	mediaPlayer.play();
        launch(args);
    }
}