package view;

import Player.Player;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class GameView {
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("images3.png")));
    ImageView letterView=new ImageView(new Image(getClass().getResourceAsStream("letter.png")));
    Player player=new Player(imageView);
    static Pane root=new Pane();
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;
    public static final int GAME_WIDTH=1000;
    public static final int GAME_HEIGHT=600;
    static Direction direction =Direction.down;
    public enum Direction {left, right, up, down}
    public static boolean up=false,down=false,right=false,left=false;
    public GameView(){
        gameScene=new Scene(root,GAME_WIDTH,GAME_HEIGHT);
        gameStage =new Stage();
        gameStage.setScene(gameScene);
        //createKeyListeners();
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { direction=Direction.up;up=true;}
                if (event.getCode() == KeyCode.DOWN) { direction=Direction.down; down=true;}
                if (event.getCode() == KeyCode.RIGHT){ direction=Direction.right; right=true;}
                if (event.getCode() == KeyCode.LEFT) { direction=Direction.left; left=true;}
            }
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { up=false; }
                if (event.getCode() == KeyCode.DOWN)  { down=false; }
                if (event.getCode() == KeyCode.RIGHT) { right=false; }
                if (event.getCode() == KeyCode.LEFT)  { left=false; }
            }
        });

        letterView.setX(570);
        letterView.setY(500);
        root.getChildren().add(letterView);
        root.getChildren().add(player);
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.update(up,down,right,left);}
        };
        timer.start();
        createGameBackground();
    }

    public void createNewGame(Stage menuStage){
        this.menuStage=menuStage;
        this.menuStage.hide();
        gameStage.show();
    }
    private void createGameBackground(){
        Image backgroundImage= new Image("\\view\\map1.png",1024,800,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }


    private void pickItem(){

    }







}
