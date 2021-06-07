package Lab2;

import Player.Enemy;
import Player.Player;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import view.GameView;

import static java.lang.Math.abs;

public class FirstView {

	boolean enemyRight = true;
	boolean right2 = true;
	boolean right3 = true;
	boolean createShopView = true;
	boolean createSecondView = true;
	boolean isWallBroken;
	boolean isAllBroken;
	boolean isPickLight;
	boolean bridgeIsOpen = false;
	private Scene firstScene;
	private Stage gameStage;
	private Stage fatherroomStage;
	private final Pane root = new Pane();
	ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
	ImageView enemyImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
	ImageView enemy2ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
	ImageView enemy3ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
	ImageView wall1 = new ImageView(new Image(getClass().getResourceAsStream("wall1.png"), 160, 130, false, false));
	ImageView wall2 = new ImageView(new Image(getClass().getResourceAsStream("wall2.png"), 160, 130, false, false));
	ImageView circle = new ImageView(new Image(getClass().getResourceAsStream("circle.png"),500,400,false,false));
	ImageView bridge = new ImageView(new Image(getClass().getResourceAsStream("bridge.png"),150,180,false,false));

	Label label = new Label();

	Enemy enemy1 = new Enemy(enemyImageView);
	Enemy enemy2 = new Enemy(enemy2ImageView);
	Enemy enemy3 = new Enemy(enemy3ImageView);
	Player player1 = new Player(imageView);
	double playerX, playerY;
	double enemyX, enemyY;
	double enemy2X, enemy2Y;
	double enemy3X, enemy3Y;
	boolean circleShow;
	
	public FirstView(int x, int y, boolean isPickHammer) {
		
		System.out.println("First VIew");

		playerX = x;
		playerY = y;
		player1.setTranslateX(playerX);
		player1.setTranslateY(playerY);
		circle.setVisible(false);
		circle.setX(260);
		circle.setY(100);
		wall1.setX(0);
		wall1.setY(145);
		wall2.setX(0);
		wall2.setY(145);
		wall1.setVisible(false);
		wall2.setVisible(false);
		bridge.setX(390);
		bridge.setY(335);
		bridge.setVisible(false);
		root.getChildren().add(wall1);
		root.getChildren().add(wall2);
		root.getChildren().add(circle);
		root.getChildren().add(bridge);
		
		firstScene = new Scene(root, 732, 648);
		gameStage = new Stage();
		gameStage.setScene(firstScene); // will
		
		
		Button enterButton = new Button("Enter"); 
		enterButton.setLayoutX(630);
		enterButton.setLayoutY(275);
		enterButton.setMaxSize(70, 70);
		enterButton.setMinSize(70, 70);
		enterButton.setPrefSize(70, 70);
		enterButton.setVisible(false);
		
		
		TextField text1 = new TextField();
		text1.setLayoutX(530);
		text1.setLayoutY(175);
		text1.setMaxHeight(60);
		text1.setMinHeight(60);
		text1.setPrefHeight(Region.USE_COMPUTED_SIZE);
		text1.setMaxWidth(60);
		text1.setMaxWidth(60);
		text1.setPrefWidth(Region.USE_COMPUTED_SIZE);
		text1.setVisible(false);
		text1.setFocusTraversable(false);
		text1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		
		TextField text2 = new TextField();
		text2.setLayoutX(530);
		text2.setLayoutY(275);
		text2.setMaxHeight(60);
		text2.setMinHeight(60);
		text2.setPrefHeight(Region.USE_COMPUTED_SIZE);
		text2.setMaxWidth(60);
		text2.setMaxWidth(60);
		text2.setPrefWidth(Region.USE_COMPUTED_SIZE);
		text2.setVisible(false);
		text2.setFocusTraversable(false);
		text2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		TextField text3 = new TextField();
		text3.setLayoutX(535);
		text3.setLayoutY(385);
		text3.setMaxHeight(60);
		text3.setMinHeight(60);
		text3.setPrefHeight(Region.USE_COMPUTED_SIZE);
		text3.setMaxWidth(60);
		text3.setMaxWidth(60);
		text3.setPrefWidth(Region.USE_COMPUTED_SIZE);
		text3.setVisible(false);
		text3.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		text3.setFocusTraversable(false);
		root.getChildren().add(text1);
		root.getChildren().add(text2);
		root.getChildren().add(text3);
		root.getChildren().add(enterButton);
		
		firstScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@SuppressWarnings("unchecked")
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					GameView.direction = GameView.Direction.up;
					GameView.up = true;
				}
				if (event.getCode() == KeyCode.DOWN) {
					GameView.direction = GameView.Direction.down;
					GameView.down = true;
				}
				if (event.getCode() == KeyCode.RIGHT) {
					GameView.direction = GameView.Direction.right;
					GameView.right = true;
				}
				if (event.getCode() == KeyCode.LEFT) {
					GameView.direction = GameView.Direction.left;
					GameView.left = true;
				}
				if (event.getCode() == KeyCode.S) {
					System.out.println("firstView check");
					System.out.println(playerX + ", " + playerY);

					if (playerX < 160 && playerX > 0 && playerY < 300 && playerY > 220 && isAllBroken == false&&isPickHammer) {
						if (!isWallBroken) {
							wall1.setVisible(true);
							// root.getChildren().add(wall1);
							isWallBroken = true;
						} else {
							// root.getChildren().add(wall2);
							wall2.setVisible(true);
							isAllBroken = true;
							isPickLight = true;
						}

					}
					if(playerX >190 && playerX < 270 && playerY > 180 && playerY < 240 && !circleShow) {
						circle.setVisible(true);
						circleShow = true;
						text1.setVisible(true);
						text2.setVisible(true);
						text3.setVisible(true);
						enterButton.setVisible(true);
						
						enterButton.setOnAction(new EventHandler() {
						    
							@Override
							public void handle(Event arg0) {
								if(Integer.parseInt(text1.getText())==4 && Integer.parseInt(text2.getText())==3 && Integer.parseInt(text3.getText())==2) {
									bridge.setVisible(true);
									text1.setVisible(false);
									text2.setVisible(false);
									text3.setVisible(false);
									enterButton.setVisible(false);
									circle.setVisible(false);
									bridgeIsOpen =true;
								System.out.println("Success");
							}else if(text1.getText()=="" && text2.getText()=="" && text3.getText()=="") {
								text1.setVisible(false);
								text2.setVisible(false);
								text3.setVisible(false);
								enterButton.setVisible(false);
								circle.setVisible(false);
								circleShow = false;
							}else {
								text1.setVisible(false);
								text2.setVisible(false);
								text3.setVisible(false);
								enterButton.setVisible(false);
								circle.setVisible(false);
								circleShow = false;
								
								System.out.println("false");
							}

							
						}});
						System.out.println(text1.getText());
					}else if (circleShow) {
						text1.setVisible(false);
						text2.setVisible(false);
						text3.setVisible(false);
						enterButton.setVisible(false);
						circle.setVisible(false);
						circleShow = false;
					}
				}
			}
		});
		firstScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					GameView.up = false;
				}
				if (event.getCode() == KeyCode.DOWN) {
					GameView.down = false;
				}
				if (event.getCode() == KeyCode.RIGHT) {
					GameView.right = false;
				}
				if (event.getCode() == KeyCode.LEFT) {
					GameView.left = false;
				}
				if (event.getCode() == KeyCode.S) {
					GameView.interAction = false;
				}
			}
		});
		
	
		root.getChildren().add(enemy1);
		root.getChildren().add(enemy2);
		// root.getChildren().add(enemy3);

		enemy1.setTranslateX(50);
		enemy1.setTranslateY(500);
		enemy2.setTranslateX(700);
		enemy2.setTranslateY(400);
		// enemy2.setTranslateX(400);
		// enemy3.setTranslateY(300);

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				playerX = player1.getTranslateX();
				playerY = player1.getTranslateY();

				enemyX = enemy1.getTranslateX();
				enemyY = enemy1.getTranslateY();
				enemy2X = enemy2.getTranslateX();
				enemy2Y = enemy2.getTranslateY();

				//enemy3X = enemy3.getTranslateX();
				//enemy3Y = enemy3.getTranslateY();

				player1.updateRoom1(GameView.up, GameView.down, GameView.right, GameView.left);

				if (playerX > 400 && playerX < 560 && playerY > 150 && playerY < 200 && GameView.up == true
						&& createSecondView) {
					SecondView secondView = new SecondView(isPickLight);
					secondView.createSecondView(gameStage);
					createSecondView = false;

				}
				if(playerX > 0 && playerX < 200 && playerY > 500 && playerY < 648 && GameView.down == true
						&& createShopView&&bridgeIsOpen) {
					System.out.println("ThirdRoom");
					ShopView thirdView = new ShopView();
					thirdView.createShopView(gameStage);
					createShopView = false;
				}
				
				

				if (enemyRight) {
					enemy1.update(false, false, true, false, 3);
					if (enemyX > 650) {
						enemyRight = false;
						 //System.out.println("right");
					}
				}
				if (!enemyRight) {
					enemy1.update(false, false, false, true, 3);

					if (enemyX < 20) {
						enemyRight = true;
						// System.out.println("=====");

					}
				}

				if (right2) {
					enemy2.update(false, false, true, false, 3);
					if (enemy2X > 650) {
						right2 = false;
					}
				}
				if (!right2) {
					enemy2.update(false, false, false, true, 3);

					if (enemy2X < 20) {
						right2 = true;
					}
				}

				if (right3) {
					enemy3.update(false, false, true, false, 5);
					if (enemy3X > 900) {
						right3 = false;
					}
				}
				if (!right3) {
					enemy3.update(false, false, false, true, 5);
					if (enemy3X < 100) {
						right3 = true;
					}
				}

			}
		};
		timer.start();
		createGameBackground();

		root.getChildren().add(player1);
	}

	private void createGameBackground() {
		Image backgroundImage = new Image("firstView.jpg", 732, 648, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		root.setBackground(new Background(background));
	}

	public void createFirstrView(Stage fatherroomStage) {
		// pane.getChildren().remove(player);
		player1.setTranslateX(playerX);
		player1.setTranslateY(playerY);

		this.fatherroomStage = fatherroomStage;
		this.fatherroomStage.close();
		gameStage.show();
	}

	public void createFirstrView() {
		// pane.getChildren().remove(player);
		player1.setTranslateX(playerX);
		player1.setTranslateY(playerY);

		gameStage.show();
	}

}