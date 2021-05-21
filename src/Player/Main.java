package Player;

import javafx.application.Application;
import javafx.stage.Stage;
import view.GameView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameView gameView = new GameView();
        gameView.createNewGame(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
