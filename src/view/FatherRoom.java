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

import static java.lang.Math.abs;

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
    double playerX=GAME_WIDTH-3*Player.PACE_SIZE,playerY=GAME_HEIGHT-3*Player.PACE_SIZE;

    private boolean removeFatherRoom=true;

    public FatherRoom() {
        gameScene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        fatherroomStage = new Stage();
        fatherroomStage.setScene(gameScene);
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;up=true;}
                if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; down=true;}
                if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; right=true;}
                if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; left=true;}
                if (event.getCode() == KeyCode.S){
                    System.out.println("check");
                }
            }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { up=false; }
                if (event.getCode() == KeyCode.DOWN)  { down=false; }
                if (event.getCode() == KeyCode.RIGHT) { right=false; }
                if (event.getCode() == KeyCode.LEFT)  { left=false; }
                if (event.getCode() == KeyCode.S)    { GameView.interAction=false;}
            }});
        root.getChildren().add(player1);
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX=player1.getTranslateX();
                playerY=player1.getTranslateY();
                if(playerX==GAME_WIDTH&&playerY==GAME_HEIGHT&&removeFatherRoom){
                    System.out.println("go to LivingRoom");
                    GameView gameView=new GameView((int)GameView.playerX,(int)GameView.playerY,true);
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
        Image backgroundImage= new Image("\\view\\fatherroom.png",GAME_HEIGHT,GAME_WIDTH,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }




}