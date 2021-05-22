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

public class FatherRoom {

    private Scene gameScene;
    private Stage fatherroomStage;
    private Stage livingStage;
    private final Pane root=new Pane();

    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    Player player1=new Player(imageView);


    public static final int GAME_WIDTH=1024;
    public static final int GAME_HEIGHT=800;

    private boolean up=false;
    private boolean down=false;
    private boolean right=false;
    private boolean left=false;

    private double playerX;
    private double playerY;

    private boolean removeFatherRoom=true;

    public FatherRoom() {
        gameScene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        fatherroomStage = new Stage();
        fatherroomStage.setScene(gameScene);

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP){
                    up=true;
                }
                if (event.getCode() == KeyCode.DOWN){
                    down=true;
                }
                if (event.getCode() == KeyCode.RIGHT){
                    right=true;
                }
                if (event.getCode() == KeyCode.LEFT){
                    left=true;
                }

            }
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    up = false;
                }
                if (event.getCode() == KeyCode.DOWN) {
                    down = false;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    right = false;
                }
                if (event.getCode() == KeyCode.LEFT) {
                    left = false;
                }

            }
        });
        root.getChildren().add(player1); ///

        player1.setTranslateX(890);
        player1.setTranslateY(700);

        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {


                playerX=player1.getTranslateX();
                playerY=player1.getTranslateY();


                if(playerX>891&&playerY>701&&removeFatherRoom){
                    System.out.println("go to livingroom");
                    GameView gameView=new GameView(162,31,true);

                    gameView.createNewGame(fatherroomStage);

                    removeFatherRoom=false;

                }


                player1.updateGameView(up,down,right,left);
            }
        };
        timer.start();
        createGameBackground();











    }


    public void createfatherroom(Stage menuStage,Player player,Pane pane){
        //pane.getChildren().remove(player);
        this.livingStage=menuStage;
        this.livingStage.hide();
        fatherroomStage.show();
    }

    private void createGameBackground(){
        Image backgroundImage= new Image("\\view\\fatherroom.png",1024,800,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }




}