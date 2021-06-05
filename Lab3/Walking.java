package Lab3;

import Player.Player;
import Player.*;
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


public class Walking {


    private Scene WalkingScene;
    private Stage WalkingStage;
    private Stage secondRoomStage;
    private final Pane root=new Pane();
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    ImageView enemyImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy2ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy3ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy4ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy5ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy6ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy7ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy8ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy9ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));
    ImageView enemy10ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemy.png"))));

    Enemy enemy1=new Enemy(enemyImageView);
    Enemy enemy2=new Enemy(enemy2ImageView);
    Enemy enemy3=new Enemy(enemy3ImageView);
    Enemy enemy4=new Enemy(enemy4ImageView);
    Enemy enemy5=new Enemy(enemy5ImageView);
    Enemy enemy6=new Enemy(enemy6ImageView);
    Enemy enemy7=new Enemy(enemy7ImageView);
    Enemy enemy8=new Enemy(enemy8ImageView);
    Enemy enemy9=new Enemy(enemy9ImageView);
    Enemy enemy10=new Enemy(enemy10ImageView);
    boolean enemyRight=true;

    Player player1=new Player(imageView);
    double playerX=60,playerY=280;


    public Walking() throws InterruptedException {

        System.out.println("Walking View");
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);
        enemy1.setTranslateY(200);
        enemy2.setTranslateY(300);
        enemy3.setTranslateY(400);
        enemy4.setTranslateY(500);
        enemy5.setTranslateY(600);
        enemy6.setTranslateY(700);
        enemy7.setTranslateY(0);
        enemy8.setTranslateY(100);
        enemy9.setTranslateY(150);
        enemy10.setTranslateY(250);


        WalkingScene = new Scene(root, 1200, 700);
        WalkingStage = new Stage();
        WalkingStage.setScene(WalkingScene); //will
        WalkingScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;GameView.up=true;}
                if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; GameView.down=true;}
                if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; GameView.right=true;}
                if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; GameView.left=true;}
                if (event.getCode() == KeyCode.S){
                    System.out.println("WALLLLLking check");
                    System.out.println(playerX+", "+playerY);



                }
            }});
        WalkingScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)    { GameView.interAction=false;}
            }});



        root.getChildren().add(player1);
        root.getChildren().add(enemy1);
        root.getChildren().add(enemy2);
        root.getChildren().add(enemy3);
        root.getChildren().add(enemy4);
        root.getChildren().add(enemy5);
        root.getChildren().add(enemy6);
        root.getChildren().add(enemy7);
        root.getChildren().add(enemy8);
        root.getChildren().add(enemy9);
        root.getChildren().add(enemy10);


        AnimationTimer timer=new AnimationTimer() {

            @Override
            public void handle(long now) {
                playerX= player1.getTranslateX();
                playerY= player1.getTranslateY();




                if (enemyRight) {
                    enemy1.update(false, false, true, false,1);
                    enemy2.update(false, false, true, false,1);
                    enemy3.update(false, false, true, false,1);
                    enemy4.update(false, false, true, false,1);
                    enemy5.update(false, false, true, false,1);
                    enemy6.update(false, false, true, false,1);
                    enemy7.update(false, false, true, false,2);
                    enemy8.update(false, false, true, false,2);
                    enemy9.update(false, false, true, false,2);
                    enemy10.update(false, false, true, false,2);

                }



                player1.update(GameView.up,GameView.down,GameView.right,GameView.left);

            }
        };




        timer.start();



        createGameBackground();

    }


    private void createGameBackground(){
        Image backgroundImage= new Image("secondView.png",1024,700,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }

    public void createWalkingView(Stage firstroomStage){
        //pane.getChildren().remove(player);
        player1.setTranslateX(playerX);
        player1.setTranslateY(playerY);

        this.secondRoomStage =firstroomStage;
        this.secondRoomStage.close();
        WalkingStage.show();
    }







}