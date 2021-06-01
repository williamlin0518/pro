package Lab2;

import Player.Enemy;
import Player.Player;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.GameView;

import static java.lang.Math.abs;


public class FirstView {


    boolean enemyRight =true;
    boolean right2=true;
    boolean right3=true;

    boolean createSecondView=true;
    boolean isWallBroken;
    boolean isAllBroken;
    boolean isPickLight;

    private Scene firstScene;
    private Stage gameStage;
    private Stage fatherroomStage;
    private final Pane root=new Pane();
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    ImageView enemyImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy2ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy3ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView wall1 = new ImageView(new Image(getClass().getResourceAsStream(("wall1.png"))));
    ImageView wall2 = new ImageView(new Image(getClass().getResourceAsStream(("wall2.png"))));
    ImageView circle = new ImageView(new Image(getClass().getResourceAsStream(("circle.png"))));

    Label label=new Label();

    Enemy enemy1=new Enemy(enemyImageView);
    Enemy enemy2=new Enemy(enemy2ImageView);
    Enemy enemy3=new Enemy(enemy3ImageView);
    Player player1=new Player(imageView);
    double playerX,playerY;
    double enemyX,enemyY;
    double enemy2X,enemy2Y;
    double enemy3X,enemy3Y;

    public FirstView(int x,int y,boolean isPickHammer){

        System.out.println("First VIew");


        playerX=x;
        playerY=y;
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);

        wall1.setX(0);
        wall1.setY(176);

        wall2.setY(176);
        firstScene = new Scene(root,732, 648);
        gameStage = new Stage();
        gameStage.setScene(firstScene); //will
        firstScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;GameView.up=true;}
                if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; GameView.down=true;}
                if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; GameView.right=true;}
                if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; GameView.left=true;}
                if (event.getCode() == KeyCode.S){
                    System.out.println("firstView check");
                    System.out.println(playerX+", "+playerY);

                    if(playerX<180&&playerX>100&&playerY<360&&playerY>300&&isPickHammer&&isAllBroken==false){
                        if(!isWallBroken) {
                            root.getChildren().add(wall1);
                            isWallBroken=true;
                        }
                        else{
                            root.getChildren().add(wall2);
                            isAllBroken=true;
                            isPickLight=true;
                        }



                    }
                }
            }});
        firstScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)    { GameView.interAction=false;}
            }});
        root.getChildren().add(enemy1);
        root.getChildren().add(enemy2);
        //root.getChildren().add(enemy3);

        enemy1.setTranslateX(100);
        enemy1.setTranslateY(600);
        enemy2.setTranslateX(700);
        enemy2.setTranslateY(650);
        //enemy2.setTranslateX(400);
        //enemy3.setTranslateY(300);


        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX= player1.getTranslateX();
                playerY= player1.getTranslateY();

                enemyX=enemy1.getTranslateX();
                enemyY=enemy1.getTranslateY();
                enemy2X=enemy2.getTranslateX();
                enemy2Y=enemy2.getTranslateY();

                enemy3X=enemy3.getTranslateX();
                enemy3Y=enemy3.getTranslateY();

                player1.updateFirstView(GameView.up,GameView.down,GameView.right, GameView.left);
                
                if(playerX>650&&playerX<800&&playerY>250&&playerY<300&&GameView.up==true&&createSecondView){
                    SecondView secondView=new SecondView(isPickLight);
                    secondView.createSecondView(gameStage);
                    createSecondView=false;

                }



                 if (enemyRight) {
                    enemy1.update(false, false, true, false,5);
                    if(enemyX>950) {
                        enemyRight = false;
                        //System.out.println("right");

                    }
                }
                if (!enemyRight){
                    enemy1.update(false,false,false,true,5);

                    if(enemyX<50) {
                        enemyRight = true;
                        //System.out.println("=====");

                    }
                }




                if (right2) {
                    enemy2.update(false, false, true, false,5);
                    if(enemy2X>950) {
                        right2 = false;
                    }
                }
                if (!right2){
                    enemy2.update(false,false,false,true,5);

                    if(enemy2X<50) {
                        right2 = true;
                    }
                }

                if (right3) {
                    enemy3.update(false, false, true, false,5);
                    if(enemy3X>900) {
                        right3 = false;
                    }
                }
                if (!right3){
                    enemy3.update(false,false,false,true,5);
                    if(enemy3X<100) {
                        right3 = true;
                    }
                }

            }
        };
        timer.start();
        createGameBackground();

        root.getChildren().add(player1);
    }


    private void createGameBackground(){
        Image backgroundImage= new Image("firstView.jpg",732,648,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }

    public void createFirstrView(Stage fatherroomStage){
       // pane.getChildren().remove(player);
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);

        this.fatherroomStage=fatherroomStage;
        this.fatherroomStage.close();
        gameStage.show();
    }
    public void createFirstrView(){
       // pane.getChildren().remove(player);
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);



        gameStage.show();
    }







}