package application;

import java.io.File;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class SceneController implements Runnable{
	@FXML
	private Stage stage;
	private Scene scene;
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
		Parent root = FXMLLoader.load(getClass().getResource("InputNameScene.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void Exit(ActionEvent event) throws Exception{
		System.exit(0);
	}
	@FXML
	TextField playerName;
	String Name;
	public void switchIntroduce(ActionEvent event) throws IOException {
		Name=playerName.getText().toString();
		
		Parent root = FXMLLoader.load(getClass().getResource("Introduce.fxml"));
		stage = (Stage)(( Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	@FXML
	Button Skip;
	@FXML
	Label intro;
	int count=0;
	public void Skip(ActionEvent event) throws Exception{
		
		if(count==0) {
			Thread.sleep(500);
			intro.setText("1948年第一次以阿戰爭爆發，大量砲火襲擊以色列");
			intro.setFont(Font.font("DFKai-SB",16));
			count++;
		}
		else if(count==1) {
			Thread.sleep(500);
			intro.setText("1948年第一次以阿戰爭爆發，大量砲火襲擊以色列\n"+Name+"在戰爭中和父母走散，目睹屍橫遍野的慘狀");
			count++;
		}
		else if(count==2) {
			Thread.sleep(500);
			intro.setText("1948年第一次以阿戰爭爆發，大量砲火襲擊以色列\n"+Name+"在戰爭中和父母走散，目睹屍橫遍野的慘狀\n戰爭後，"+Name+"被施內勒爾孤兒院的院長麗柏收養");
			count++;
		}
		else if(count==3) {
			Thread.sleep(500);
			intro.setText("1948年第一次以阿戰爭爆發，大量砲火襲擊以色列\n"+Name+"在戰爭中和父母走散，目睹屍橫遍野的慘狀\n戰爭後，"+Name+"被施內勒爾孤兒院的院長麗柏收養\n然而他得了戰後失憶症，不記得有關自己還有父母的記憶");
			count++;
		}
			
		else if(count==4) {
			Thread.sleep(500);
			intro.setText("1948年第一次以阿戰爭爆發，大量砲火襲擊以色列\n"+Name+"在戰爭中和父母走散，目睹屍橫遍野的慘狀\n戰爭後，"+Name+"被施內勒爾孤兒院的院長麗柏收養\n然而他卻得了戰後失憶症，不記得自己是誰還有和父母有關的記憶\n然而就在這一天，院長告知他...");
			count++;
		}
		else if(count==5) {
			int playerX=50*Player.UNIT_SIZE,playerY=50*Player.UNIT_SIZE;
	        GameView gameView =new GameView(playerX,playerY,false);
	        gameView.createNewGame((Stage)(( Node)event.getSource()).getScene().getWindow());
		}
		}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
