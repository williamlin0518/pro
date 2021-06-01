package Lab2;

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
import view.GameView;

import static java.lang.Math.abs;


public class SecondView {
    boolean right=true,left=false;
    boolean right2=true,left2=false;
    boolean right3=true,left3=false;
    boolean canUseEye;
    boolean isHidden=true;
    boolean isPickHammer;
    boolean createFirstView=true;
    private Scene secondScene;
    private Stage gameStage;
    private Stage secondRoomStage;
    private final Pane root=new Pane();
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    ImageView eyefalse = new ImageView(new Image(getClass().getResourceAsStream(("eyefalse.png"))));
    ImageView eyeTrue = new ImageView(new Image(getClass().getResourceAsStream("eyetrue.png")));
    ImageView hammer = new ImageView(new Image(getClass().getResourceAsStream(("hammer.png"))));





    Player player1=new Player(imageView);
    double playerX=60,playerY=200;


    public SecondView(boolean isPickLight){

        hammer.setX(600);
        hammer.setY(270);
        root.getChildren().add(hammer);
        eyefalse.setFitWidth(600);
        eyefalse.setFitHeight(400);
        eyefalse.setX(100);
        eyefalse.setY(100);

        eyeTrue.setFitWidth(600);
        eyeTrue.setFitHeight(400);
        eyeTrue.setX(100);
        eyeTrue.setY(100);



        System.out.println("Second View");
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);
        secondScene = new Scene(root, 732, 648);
        gameStage = new Stage();
        gameStage.setScene(secondScene); //will
        secondScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;GameView.up=true;}
                if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; GameView.down=true;}
                if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; GameView.right=true;}
                if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; GameView.left=true;}
                if (event.getCode() == KeyCode.S){
                    System.out.println("Second check");
                    System.out.println(playerX+", "+playerY);

                    if(playerX>50&&playerX<170&&playerY>150&&playerY<250){
                        System.out.println("use tele");
                        if(isPickLight){
                            if(isHidden) {
                                root.getChildren().add(eyeTrue);
                                isHidden=false;
                            }else{
                                root.getChildren().remove(eyeTrue);
                                isHidden=true;
                            }

                        }
                        if(!isPickLight){
                            if(isHidden) {
                                root.getChildren().add(eyefalse);
                                isHidden=false;
                            }else{
                                root.getChildren().remove(eyefalse);
                                isHidden=true;
                            }
                        }
                    }
                    if(playerX<650&&playerX>550&&playerY>200&&playerY<300){
                        root.getChildren().remove(hammer);
                        isPickHammer=true;
                    }
                }
            }});
        secondScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)    { GameView.interAction=false;}
            }});



        root.getChildren().add(player1);

        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX= player1.getTranslateX();
                playerY= player1.getTranslateY();


                if(playerX<50&&playerY>200&&playerY<350&&GameView.left==true&&createFirstView==true){
                    FirstView firstView=new FirstView(450,250,isPickHammer);
                    firstView.createFirstrView(gameStage);
                    createFirstView=false;
                }

                player1.updateFirstView(GameView.up,GameView.down,GameView.right,GameView.left);















            }
        };
        timer.start();
        createGameBackground();

    }


    private void createGameBackground(){
        Image backgroundImage= new Image("secondView.png",732,648,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }

    public void createSecondView(Stage firstroomStage){
       // pane.getChildren().remove(player);
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);

        this.secondRoomStage =firstroomStage;
        this.secondRoomStage.close();
        gameStage.show();
    }
    public void createSecondView(){
       // pane.getChildren().remove(player);
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);



        gameStage.show();
    }







}