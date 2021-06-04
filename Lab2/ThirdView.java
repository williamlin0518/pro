package Lab2;

import Player.Player;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.GameView;

public class ThirdView {
	private Scene ThirdScene;
	private Stage gameStage;
	private Stage ThirdRoomStage;
	private final Pane root = new Pane();
	ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
	ImageView top = new ImageView(new Image(getClass().getResourceAsStream("top.png"), 600, 400, false, false));
	ImageView middle = new ImageView(new Image(getClass().getResourceAsStream("middle.png"), 600, 400, false, false));
	ImageView bottom = new ImageView(new Image(getClass().getResourceAsStream("bottom.png"), 600, 400, false, false));
	ImageView lock = new ImageView(new Image(getClass().getResourceAsStream("lock.png"), 300, 500, false, false));
	Player player1 = new Player(imageView);
	double playerX = 0, playerY = 0;
	boolean isHidden1,isHidden2,isHidden3;

	public ThirdView() {
	    	 top.setFitWidth(600);
	    	 top.setFitHeight(400);
	    	 top.setX(50);
	    	 top.setY(100);
	    	 
	    	 middle.setFitWidth(600);
	    	 middle.setFitHeight(400);
	    	 middle.setX(50);
	    	 middle.setY(100);
	    	 
	    	 bottom.setFitWidth(600);
	    	 bottom.setFitHeight(500);
	    	 bottom.setX(50);
	    	 bottom.setY(100);
	    	 

	    	 lock.setFitWidth(300);
	    	 lock.setFitHeight(500);
	    	 lock.setX(300);
	    	 lock.setY(50);
	    	 isHidden1  =true;
	    	 isHidden2 = true;
	    	 isHidden3 = true;
	    	 player1.setTranslateX(playerX);
	         player1.setTranslateY(playerY);
	         ThirdScene = new Scene(root, 732, 648);
	         gameStage = new Stage();
	         gameStage.setScene(ThirdScene); 
	         
	         
	         ThirdScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	             @Override
	             public void handle(KeyEvent event) {
	                 if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;GameView.up=true;}
	                 if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; GameView.down=true;}
	                 if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; GameView.right=true;}
	                 if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; GameView.left=true;}
	                 if (event.getCode() == KeyCode.S){
	                     System.out.println("Second check");
	                     System.out.println(playerX+", "+playerY);
	                     if(playerY>360&&playerY<400&&playerX>60&&playerX<140) {
                        	 if(isHidden2) {
                                 root.getChildren().add(middle);
                                 isHidden2=false;
                                 //System.out.println("middle");
                             }else{
                                 root.getChildren().remove(middle);
                                 isHidden2=true;
                                 //System.out.println("middle middle");
                             }
                             
                         }
	                     if(playerX>40&&playerX<260&&playerY>490&&playerY<560) {
	                    	 		
	                    	 if(isHidden3) {
                                 root.getChildren().add(bottom);
                                 isHidden3=false;
                                 //System.out.println("top");
                             }else{
                                 root.getChildren().remove(bottom);
                                 isHidden3=true;
                                 //System.out.println("top top");
                             }
	                     }
	                            
		                             if(playerX>470&&playerX<550&&playerY>180&&playerY<250) {
			                    	 		
			                             if(isHidden3) {
			                                 root.getChildren().add(top);
			                                 isHidden3=false;
			                                 System.out.println("hi");
			                             }else{
			                                 root.getChildren().remove(top);
			                                 isHidden3=true;
			                                 System.out.println("hi hi");
			                             }
	                             
		                             }
		                             if(playerX>532&&playerX<732&&playerY>448&&playerY<648) {
			                    	 		
			                             if(isHidden3) {
			                                 root.getChildren().add(lock);
			                                 isHidden3=false;
			                                 System.out.println("hi");
			                             }else{
			                                 root.getChildren().remove(lock);
			                                 isHidden3=true;
			                                 System.out.println("hi hi");
			                             }
	                             
		                             }
	                             

	                         
	                     }

	                 }     
	             });
	         ThirdScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
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

	                

	                 player1.updateFirstView(GameView.up,GameView.down,GameView.right,GameView.left);


	             }
	         };
	         timer.start();
	         createGameBackground();

	     }


	     private void createGameBackground(){
	         Image backgroundImage= new Image("ThirdView.png",732,648,false,true);
	         BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
	         root.setBackground(new Background(background));
	     }

	     public void createThirdView(Stage firstroomStage){
	        // pane.getChildren().remove(player);
	         player1.setTranslateX(playerX);
	         player1.setTranslateY(playerY);

	         this.ThirdRoomStage =firstroomStage;
	         this.ThirdRoomStage.close();
	         gameStage.show();
	     }
	     public void createThirdView(){
	        // pane.getChildren().remove(player);
	         player1.setTranslateX(playerX);
	         player1.setTranslateY(playerY);



	         gameStage.show();
	     }



	         }




	    
