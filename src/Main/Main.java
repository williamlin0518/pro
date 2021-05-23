package Main;


import Player.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import view.GameView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            int playerX=50*Player.UNIT_SIZE,playerY=50*Player.UNIT_SIZE;
            GameView gameView =new GameView(playerX,playerY,false);
            gameView.createNewGame(primaryStage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
