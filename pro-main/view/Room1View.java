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

    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("images3.png"))));
    Player player1=new Player(imageView);


    public static final int GAME_WIDTH=1024;
    public static final int GAME_HEIGHT=800;

    private boolean up=false;
    private boolean down=false;
    private boolean right=false;
    private boolean left=false;

    private boolean removeFatherroom=true;
    //private boolean canOpenBox;
    private boolean enterFatherRoom;

    private double playerX;
    private double playerY;

    public Room1View(boolean canOpenBox) {


        gameScene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        room1Stage = new Stage();
        room1Stage.setScene(gameScene);

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

        player1.setTranslateX(80);
        player1.setTranslateY(680);

        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {


                playerX=player1.getTranslateX();
                playerY=player1.getTranslateY();


                if(playerX<80&&playerY>690&&removeFatherroom){

                    GameView gameView=new GameView(31, 201,enterFatherRoom);

                    System.out.println("go livingroom");
                    gameView.createNewGame(room1Stage);

                    removeFatherroom=false;
                }
                if ((abs(playerX - 935) < 50) && (abs(playerY -120) < 50)&&canOpenBox) {


                    System.out.println("open box");



                    enterFatherRoom =true;

                }



                player1.update(up,down,right,left);
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
        Image backgroundImage= new Image("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/view/room1.png",1024,800,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }




}

