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

public class Room1View {

    private Scene gameScene;
    private Stage room1Stage;
    private Stage livingStage;
    private final Pane root=new Pane();

    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    Player player1=new Player(imageView);

    private boolean goLivingRoom = true;
    //private boolean canOpenBox;
    private boolean enterFatherRoom;
    private double playerX;
    private double playerY;
    public Room1View(boolean canOpenBox) {
        gameScene = new Scene(root, GameView.GAME_WIDTH, GameView.GAME_HEIGHT);
        room1Stage = new Stage();
        room1Stage.setScene(gameScene);
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;GameView.up=true;}
                if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; GameView.down=true;}
                if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; GameView.right=true;}
                if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; GameView.left=true;}
                if (event.getCode() == KeyCode.S)    { GameView.interAction=true;}
            }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)     { GameView.interAction=false;}
        }});
        root.getChildren().add(player1); ///
        player1.setTranslateX(Player.PLAYER_WIDTH);
        player1.setTranslateY(GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT);
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX=player1.getTranslateX();
                playerY=player1.getTranslateY();
                if(playerX==0&&playerY==GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT&&GameView.direction.equals(GameView.Direction.down)&& goLivingRoom){
                    GameView gameView=new GameView((int)GameView.playerX,(int)GameView.playerY,enterFatherRoom);
                    System.out.println("go LivingRoom");
                    gameView.createNewGame(room1Stage);
                    goLivingRoom =false;
                }
                if ((abs(playerX+Player.PLAYER_WIDTH-GameView.GAME_WIDTH) == 0) && (abs(playerY) == 0)&&canOpenBox) {
                    System.out.println("open box");
                    enterFatherRoom =true;
                }
                player1.updateRoom1(GameView.up,GameView.down,GameView.right,GameView.left);
            }
        };
        timer.start();
        createGameBackground();











    }


    public void createRoom1(Stage menuStage,Player player,Pane pane){
        //pane.getChildren().remove(player);
        this.livingStage=menuStage;
        this.livingStage.hide();
        room1Stage.show();
    }

    private void createGameBackground(){
        Image backgroundImage= new Image("\\view\\room1.png",GameView.GAME_WIDTH,GameView.GAME_HEIGHT,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }




}


