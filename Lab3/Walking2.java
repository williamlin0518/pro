package Lab3;

import Player.Player;
import Player.*;
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
import view.GameView;


public class Walking2 {


    private Scene WalkingScene;
    private Stage WalkingStage;
    private Stage secondRoomStage;
    private final Pane root = new Pane();
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    ImageView enemyImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
    ImageView enemy2ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
    ImageView enemy3ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
    ImageView enemy4ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
    ImageView enemy5ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
    ImageView enemy6ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
    ImageView enemy7ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
    ImageView enemy8ImageView = new ImageView(new Image(getClass().getResourceAsStream("enemySmall.png")));
    ImageView passImageView = new ImageView(new Image(getClass().getResourceAsStream("end.jpg"),1200,700,false,false));
    Enemy enemy1=new Enemy(enemyImageView);
    Enemy enemy2=new Enemy(enemy2ImageView);
    Enemy enemy3=new Enemy(enemy3ImageView);
    Enemy enemy4=new Enemy(enemy4ImageView);
    Enemy enemy5=new Enemy(enemy5ImageView);
    Enemy enemy6=new Enemy(enemy6ImageView);
    Enemy enemy7=new Enemy(enemy7ImageView);
    Enemy enemy8=new Enemy(enemy8ImageView);
    
    boolean enemyRight=true;

    Player player1=new Player(imageView);
    double playerX=0,playerY=300;


    public Walking2()  {
    	root.getChildren().add(passImageView);
    	passImageView.setVisible(false);
    	enemy1.setTranslateX(-150);
    	enemy2.setTranslateX(-150);
    	enemy3.setTranslateX(-150);
    	enemy4.setTranslateX(-150);
    	enemy5.setTranslateX(-150);
    	enemy6.setTranslateX(-150);
    	enemy7.setTranslateX(-150);
    	enemy8.setTranslateX(-150);
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
        Button skip =new Button("®¥³ßµ²§ô");
    	BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("setting.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        
       
        skip.setPrefSize(100, 100);
        skip.setLayoutX(200);
        skip.setLayoutY(200);
        skip.setBackground(background);
        
       skip.setOnAction( new EventHandler<ActionEvent>() {
        	
			@Override
			public void handle(ActionEvent actionEvent) {
				System.exit(0);
				
			}
        	
        });
       skip.setVisible(false);
       root.getChildren().add(skip);
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
        


        AnimationTimer timer=new AnimationTimer() {

            @Override
            public void handle(long now) {
                playerX= player1.getTranslateX();
                playerY= player1.getTranslateY();
                if(enemy1.getTranslateX()>390) {
                	enemy1.setTranslateX(390);
                	enemy2.setTranslateX(390);
                	enemy3.setTranslateX(390);
                	enemy4.setTranslateX(390);
                	enemy5.setTranslateX(390);
                	enemy6.setTranslateX(390);
                	enemy7.setTranslateX(390);
                	enemy8.setTranslateX(390);
                }



                if (enemyRight) {
                    enemy1.update(false, false, true, false,2);
                    enemy2.update(false, false, true, false,2);
                    enemy3.update(false, false, true, false,2);
                    enemy4.update(false, false, true, false,2);
                    enemy5.update(false, false, true, false,2);
                    enemy6.update(false, false, true, false,2);
                    enemy7.update(false, false, true, false,2);
                    enemy8.update(false, false, true, false,2);
                   
                }



                player1.updateShop(GameView.up,GameView.down,GameView.right,GameView.left);
               
            }
        };




        timer.start();



        createGameBackground();

    }


    private void createGameBackground(){
        Image backgroundImage= new Image("running2.png",1200,700,false,true);
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