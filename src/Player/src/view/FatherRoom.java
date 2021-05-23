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
    double playerX,playerY;

    private boolean removeFatherRoom=true;

    public FatherRoom() {
        gameScene = new Scene(root, GameView.GAME_WIDTH, GameView.GAME_HEIGHT);
        fatherroomStage = new Stage();
        fatherroomStage.setScene(gameScene);
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;GameView.up=true;}
                if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; GameView.down=true;}
                if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; GameView.right=true;}
                if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; GameView.left=true;}
                if (event.getCode() == KeyCode.S){
                    System.out.println("check");
                    GameView.interAction=false;
                }
            }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)    { GameView.interAction=false;}
            }});
        root.getChildren().add(player1);
        player1.setTranslateX(GameView.GAME_WIDTH-Player.PLAYER_WIDTH);//起始位置
        player1.setTranslateY(GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT);//起始位置
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX=player1.getTranslateX();
                playerY=player1.getTranslateY();
                if(playerX==GameView.GAME_WIDTH-Player.PLAYER_WIDTH&&playerY==GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT&&GameView.direction.equals(GameView.Direction.right)&&removeFatherRoom){
                    double playerX=16*Player.PACE_SIZE,playerY=16*Player.PACE_SIZE;
                    System.out.println("go to LivingRoom");
                    GameView gameView=new GameView(playerX,playerY,true);
                    gameView.createNewGame(fatherroomStage);
                    removeFatherRoom=false;
                }
                player1.updateFatherRoom(GameView.up,GameView.down,GameView.right,GameView.left);
            }
        };
        timer.start();
        createGameBackground();
    }
    public void createfatherroom(Stage menuStage,Player player,Pane pane){
        //pane.getChildren().remove(player);
        player.setTranslateX(playerX);player.setTranslateY(playerY);
        this.livingStage=menuStage;
        this.livingStage.hide();
        fatherroomStage.show();
    }
    private void createGameBackground(){
        Image backgroundImage= new Image("\\view\\fatherroom.png",GameView.GAME_HEIGHT,GameView.GAME_WIDTH,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }




}