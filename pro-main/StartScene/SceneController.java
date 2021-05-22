package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToSettingScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SettingScene.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchToStartScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchInputScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("InputNameSetting.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void ExitScene(ActionEvent event) throws Exception{
		System.exit(0);
	}
	
	
}
