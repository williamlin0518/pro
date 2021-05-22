package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.GameView;
import view.ViewManager;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            GameView gameView =new GameView(870,680,false);
            gameView.createNewGame(primaryStage);
            





        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
