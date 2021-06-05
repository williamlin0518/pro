package view;

import Lab2.FirstView;
import Player.Player;
import SubScene.FatherRoomSubScene;
import SubScene.LetterSubScene;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;

import static java.lang.Math.abs;

public class FatherRoom {
    Button next = new Button("");
    private Scene gameScene;
    private Stage fatherroomStage;
    private Stage livingStage;
    boolean fatherisactive=true;
    public static boolean isLab2=false;
    public int count=0;
    private final Pane root=new Pane();
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    ImageView openWardrobe = new ImageView(new Image(getClass().getResourceAsStream(("WARDROBE.png"))));
    boolean openwar;
    Player player1=new Player(imageView);
    double playerX,playerY,warX,warY;
    private boolean removeFatherRoom=true;
    FatherRoomSubScene boxSubScene;

    public FatherRoom() {
        ImageView p1 = new ImageView(new Image(getClass().getResourceAsStream(("1-2.jpg"))));
        p1.setX(0);p1.setY(0);p1.setVisible(false);
        root.getChildren().add(p1);
        ImageView p2 = new ImageView(new Image(getClass().getResourceAsStream(("1-3.jpg"))));
        p2.setX(0);p2.setY(0);p2.setVisible(false);
        root.getChildren().add(p2);
        Button buttonNext = new Button("");
        BackgroundImage buttonNextImage = new BackgroundImage(
                new Image(getClass().getResource("next.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background buttonBackGround = new Background(buttonNextImage);
        buttonNext.setPrefSize(150, 150);
        buttonNext.setLayoutX(525);
        buttonNext.setLayoutY(25);
        buttonNext.setBackground(buttonBackGround);
        buttonNext.setFocusTraversable(false);
        buttonNext.setVisible(false);
        root.getChildren().add(buttonNext);
        buttonNext.setOnAction(new EventHandler<ActionEvent>() {
                                   @Override
                                   public void handle(ActionEvent actionEvent) {
                                       count++;
                                       if(count==1){
                                           p2.setVisible(true);
                                           System.out.println("Next");}
                                       if(count==2){
                                           FirstView firstView= new FirstView(0,0,false);
                                           firstView.createFirstrView(fatherroomStage);
                                           System.out.println("Lab2");
                                       }

                                   }
                               });
    	openwar = true;
    	 warX = 0;
    	 warY = 0;
    	
    	openWardrobe.setLayoutX(warX);
    	openWardrobe.setLayoutY(warY);
    	root.getChildren().add(openWardrobe);
    	openWardrobe.setVisible(false);
    	
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
                	fatherisactive = true;
                    System.out.println("check");
                    System.out.println(playerX+", "+playerY);
                    if(playerX>=warX && playerX<=warX+70 && playerY<=warY+200 &&openwar) {
                    	System.out.println("open the wardrobe");
                    	openwar = false;
                    	//wardrobe.moveSubscene();
                    	openWardrobe.setVisible(true);
                    }else {
                    	openwar = true;
                    	openWardrobe.setVisible(false);
                    }
                    if(playerX>600&&playerY<50){
                        System.out.println("try to lock");
                        boxSubScene.moveSubScene();
                    }
                    fatherisactive=false;
                }
            }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)    { fatherisactive=false;
                
                }
            }});
        root.getChildren().add(player1);
        player1.setTranslateX(GameView.GAME_WIDTH-Player.PLAYER_WIDTH);//�_�l��m
        player1.setTranslateY(GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT);//�_�l��m
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
                if(isLab2){
                    buttonNext.setVisible(true);
                    p1.setVisible(true);
                    root.getChildren().remove(player1);
                }

                
                player1.updateFatherRoom(GameView.up,GameView.down,GameView.right,GameView.left);
            }
        };
        timer.start();
        createGameBackground();
        createFatherRoomSubScene();
    }
    public void createfatherroom(Stage menuStage,Player player,Pane pane){
        pane.getChildren().remove(player);
        player.setTranslateX(playerX);player.setTranslateY(playerY);
        this.livingStage=menuStage;
        this.livingStage.close();
        fatherroomStage.show();
    }
    private void createGameBackground(){
        Image backgroundImage= new Image("view\\fatherroom.png",GameView.GAME_WIDTH,GameView.GAME_HEIGHT,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }

    private void createFatherRoomSubScene(){
        boxSubScene=new FatherRoomSubScene(fatherroomStage);
        root.getChildren().add(boxSubScene);
    }



}