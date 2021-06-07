package Lab2;

import Player.Enemy;
import Player.Player;
import Setting.Setting;
import SubScene.SettingSubScene;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import view.GameView;

import static java.lang.Math.abs;
import Lab3.Walking;

public class ShopView {
	private Scene gameScene;
	private Stage shopStage;
	private Stage firstviewStage;
	boolean createFirstView = true;
	boolean isHidden1, isHidden2, isHidden3, isHiddendialogBox;
	boolean shopisactive;
	boolean enemyRight = true;
	boolean enemyRight2 = true;
	boolean enemyRight3 = true;
	boolean talk;
	boolean lockShow;
	private final Pane shopRoot = new Pane();
	ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
	ImageView top = new ImageView(new Image(getClass().getResourceAsStream("top.png"), 600, 400, false, false));
	ImageView middle = new ImageView(new Image(getClass().getResourceAsStream("middle.png"), 600, 400, false, false));
	ImageView bottom = new ImageView(new Image(getClass().getResourceAsStream("bottom.png"), 600, 400, false, false));
	ImageView dialogBox = new ImageView(new Image(getClass().getResourceAsStream("nine.png"), 640, 250, false, false));
	ImageView lock = new ImageView(new Image(getClass().getResourceAsStream("lock.png"), 300, 500, false, false));
	ImageView merchantView = new ImageView(new Image(getClass().getResourceAsStream(("merchant2.png"))));
	ImageView enemyImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
	ImageView enemy2ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));
	ImageView enemy3ImageView = new ImageView(new Image(getClass().getResourceAsStream(("enemySmall.png"))));

//    ImageView labelEmpty =new ImageView(new Image(getClass().getResourceAsStream("labelEmpty.png")));
	Player playerShop = new Player(imageView);
	private double playerX;
	private double playerY;
	private Setting settingButton;
	SettingSubScene settingSubScene;
	public TextArea textArea = new TextArea("In Shop");
	private Label keyLabelPane = new Label();

	public ShopView() {
		Enemy enemy1 = new Enemy(enemyImageView);
		Enemy enemy2 = new Enemy(enemy2ImageView);
		Enemy enemy3 = new Enemy(enemy3ImageView);
		enemy1.setTranslateX(0);
    	enemy2.setTranslateX(100);
    	enemy3.setTranslateX(200);
    	enemy1.setTranslateY(230);
    	enemy2.setTranslateY(390);
    	enemy3.setTranslateY(525);
    	shopRoot.getChildren().add(enemy1);
		shopRoot.getChildren().add(enemy2);
		shopRoot.getChildren().add(enemy3);
		shopRoot.getChildren().add(lock);
		Button enterButton = new Button("Enter");
		enterButton.setLayoutX(600);
		enterButton.setLayoutY(480);
		enterButton.setMaxSize(70, 70);
		enterButton.setMinSize(70, 70);
		enterButton.setPrefSize(70, 70);
		enterButton.setVisible(false);
		lock.setVisible(false);

		TextField text1 = new TextField();
		text1.setLayoutX(520);
		text1.setLayoutY(225);
		text1.setMaxHeight(45);
		text1.setMinHeight(45);
		text1.setPrefHeight(Region.USE_COMPUTED_SIZE);
		text1.setMaxWidth(30);
		text1.setMaxWidth(30);
		text1.setPrefWidth(Region.USE_COMPUTED_SIZE);
		text1.setVisible(false);
		text1.setFocusTraversable(false);
		text1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

		TextField text2 = new TextField();
		text2.setLayoutX(330);
		text2.setLayoutY(320);
		text2.setMaxHeight(60);
		text2.setMinHeight(60);
		text2.setPrefHeight(Region.USE_COMPUTED_SIZE);
		text2.setMaxWidth(40);
		text2.setMaxWidth(40);
		text2.setPrefWidth(Region.USE_COMPUTED_SIZE);
		text2.setVisible(false);
		text2.setFocusTraversable(false);
		text2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

		TextField text3 = new TextField();
		text3.setLayoutX(445);
		text3.setLayoutY(450);
		text3.setMaxHeight(60);
		text3.setMinHeight(60);
		text3.setPrefHeight(Region.USE_COMPUTED_SIZE);
		text3.setMaxWidth(30);
		text3.setMaxWidth(30);
		text3.setPrefWidth(Region.USE_COMPUTED_SIZE);
		text3.setVisible(false);
		text3.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		text3.setFocusTraversable(false);
		shopRoot.getChildren().add(text1);
		shopRoot.getChildren().add(text2);
		shopRoot.getChildren().add(text3);
		shopRoot.getChildren().add(enterButton);
		
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

		dialogBox.setFitWidth(640);
		dialogBox.setFitHeight(250);
		dialogBox.setX(80);
		dialogBox.setY(250);

		isHidden1 = true;
		isHidden2 = true;

		isHiddendialogBox = true;
		/*keyLabelPane.setPrefSize(100, 100);
		keyLabelPane.setLayoutX(732);
		keyLabelPane.setLayoutY(0);
//        keyLabelPane.setGraphic(labelEmpty);
		keyLabelPane.setEffect(new DropShadow(1.0, Color.BLACK));

		textArea.setTranslateX(732);
		textArea.setTranslateY(200);
		textArea.setPrefSize(200, 548); // will
		textArea.setEditable(false);
		textArea.setFocusTraversable(false);
		textArea.setStyle("-fx-font-alignment: left");*/

		gameScene = new Scene(shopRoot, GameView.GAME_WIDTH , GameView.GAME_HEIGHT);
//        gameScene.getStylesheets().add(getClass().getResource("view\\view.css").toExternalForm());
		shopStage = new Stage();
		shopStage.setScene(gameScene);
		settingButton = new Setting();
		// settingButton.setOnAction(new EventHandler<ActionEvent>() {

		// @Override
		// public void handle(ActionEvent actionEvent) {
		// GameView gameView=new GameView(870,680,false);
		// gameView.createNewGame(room1Stage);
		/// }
		// });

		settingButton.setOnAction(new EventHandler<ActionEvent>() { // will

			@Override
			public void handle(ActionEvent actionEvent) {
				settingSubScene.moveSubScene();
				System.out.println("setting");
			}
		});

		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
					shopisactive = true;
					if (playerX > 532 && playerX < 732 && playerY > 448 && playerY < 648 && !lockShow) {
						lock.setVisible(true);
						lockShow = true;
						text1.setVisible(true);
						text2.setVisible(true);
						text3.setVisible(true);
						enterButton.setVisible(true);

						enterButton.setOnAction(new EventHandler() {

							@Override
							public void handle(Event arg0) {
								if (Integer.parseInt(text1.getText()) == 7 && Integer.parseInt(text2.getText()) == 1
										&& Integer.parseInt(text3.getText()) == 2) {
									Walking walk = new Walking();
									walk.createWalkingView(shopStage);
									text1.setVisible(false);
									text2.setVisible(false);
									text3.setVisible(false);
									enterButton.setVisible(false);
									lock.setVisible(false);

									System.out.println("Success");
								} else if (text1.getText() == "" && text2.getText() == "" && text3.getText() == "") {
									text1.setVisible(false);
									text2.setVisible(false);
									text3.setVisible(false);
									enterButton.setVisible(false);
									lock.setVisible(false);
									lockShow = false;
								} else {
									text1.setVisible(false);
									text2.setVisible(false);
									text3.setVisible(false);
									enterButton.setVisible(false);
									lock.setVisible(false);
									lockShow = false;

									System.out.println("false");
								}

							}
						});
						System.out.println(text1.getText());
					} else if (lockShow) {
						text1.setVisible(false);
						text2.setVisible(false);
						text3.setVisible(false);
						enterButton.setVisible(false);
						lock.setVisible(false);
						lockShow = false;
					}
					
					
					
				}
			}
		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
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
					shopisactive = false;
					System.out.println("shopView check");
					System.out.println(playerX + ", " + playerY);
				}
			}
		});
		int merchantX = 620, merchantY = 0;
		shopRoot.getChildren().add(merchantView);
		merchantView.setX(merchantX);
		merchantView.setY(merchantY);
		shopRoot.getChildren().add(playerShop);
		//shopRoot.getChildren().add(settingButton);
		//shopRoot.getChildren().add(keyLabelPane);
		//shopRoot.getChildren().add(textArea);

		playerShop.setTranslateX(0);
		playerShop.setTranslateY(0);
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				playerX = playerShop.getTranslateX();
				playerY = playerShop.getTranslateY();
				/*
				 * if(playerX==0&&playerY==GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT&&GameView.
				 * direction.equals(GameView.Direction.down)&& goLivingRoom){ double
				 * playerX=16*Player.PACE_SIZE,playerY=16*Player.PACE_SIZE; GameView
				 * gameView=new GameView(playerX,playerY,enterFatherRoom);
				 * System.out.println("go LivingRoom"); gameView.createNewGame(room1Stage);
				 * goLivingRoom =false; } if (
				 * r1isactive&&(abs(playerX+Player.PLAYER_WIDTH-GameView.GAME_WIDTH) == 0) &&
				 * (abs(playerY) == 0)) { System.out.println("open box");
				 * textArea.appendText("\nopen box"); keyLabelPane.setGraphic(keyLabel);
				 * textArea.appendText("\nget fatherRoom key"); enterFatherRoom =true;
				 * r1isactive = false; } if( r1isactive){ System.out.println("check");
				 * textArea.appendText("\ncheck"); System.out.println(playerX+" , "+playerY);
				 * r1isactive=false; }
				 */
				if (enemyRight) {
                    enemy1.update(false, false, true, false,1);
                   
                    if(enemy1.getTranslateX()>600) {
                    	enemyRight = false;
                    }
                   
                }
				if(!enemyRight) {
					enemy1.update(false, false, false, true,1);
                   
                    
                    if(enemy1.getTranslateX()<0) {
                    	enemyRight = true;
                    }
				}
				if (enemyRight2) {
                    enemy2.update(false, false, true, false,3);
                   
                    if(enemy2.getTranslateX()>600) {
                    	enemyRight2 = false;
                    }
                   
                }
				if(!enemyRight2) {
					
                    enemy2.update(false, false, false, true,3);
                 
                    
                    if(enemy2.getTranslateX()<0) {
                    	enemyRight2 = true;
                    }
				}
                    if (enemyRight3) {
                        
                        enemy3.update(false, false, true, false,2);
                        if(enemy3.getTranslateX()>570) {
                        	enemyRight3 = false;
                        }
                       
                    }
    				if(!enemyRight3) {
    					
                        enemy3.update(false, false, false,true,2);
                        
                        if(enemy3.getTranslateX()<0) {
                        	enemyRight3 = true;
                        }
    				}
				if (shopisactive && abs(playerX - merchantX) < 100 && abs(playerY - merchantY-75) < 50) {
					if (isHiddendialogBox) {
						shopRoot.getChildren().add(dialogBox);
						isHiddendialogBox = false;
						// System.out.println("middle");
					} else {
						shopRoot.getChildren().remove(dialogBox);
						isHiddendialogBox = true;
						// System.out.println("middle middle");
					}
					shopisactive = false;
				}
				/*
				 * if(shopisactive&&abs(playerX-merchantX)<50&&abs(playerY-merchantY)<50){
				 * shopSubScene.setVisible(true); shopisactive=false;
				 * System.out.println("open"); }
				 */
				if (shopisactive && playerY > 360 && playerY < 400 && playerX > 60 && playerX < 140) {
					if (isHidden2) {
						shopRoot.getChildren().add(middle);
						isHidden2 = false;
						// System.out.println("middle");
					} else {
						shopRoot.getChildren().remove(middle);
						isHidden2 = true;
						// System.out.println("middle middle");
					}
					shopisactive = false;

				}
				if (shopisactive && playerX > 40 && playerX < 260 && playerY > 490 && playerY < 560) {

					if (isHidden3) {
						shopRoot.getChildren().add(bottom);
						isHidden3 = false;
						// System.out.println("top");
					} else {
						shopRoot.getChildren().remove(bottom);
						isHidden3 = true;
						// System.out.println("top top");
					}
					shopisactive = false;
				}

				if (shopisactive && playerX > 470 && playerX < 550 && playerY > 180 && playerY < 250) {

					if (isHidden3) {
						shopRoot.getChildren().add(top);
						isHidden3 = false;
						System.out.println("hi");
					} else {
						shopRoot.getChildren().remove(top);
						isHidden3 = true;
						System.out.println("hi hi");
					}
					shopisactive = false;

				}

				/*
				 * if(shopisactive&&playerX>532&&playerX<732&&playerY>448&&playerY<648) {
				 * 
				 * if(isHidden3) { shopRoot.getChildren().add(lock); isHidden3=false;
				 * System.out.println("hi"); }else{ shopRoot.getChildren().remove(lock);
				 * isHidden3=true; System.out.println("hi hi"); } shopisactive=false; }
				 */

				playerShop.updateRoom1(GameView.up, GameView.down, GameView.right, GameView.left);
			}
		};
		timer.start();
		createGameBackground();
		createSettingSubScene();
	}

	public void createShopView(Stage firstviewStage) {
		// pane.getChildren().remove(player);
		playerShop.setTranslateX(playerX);
		playerShop.setTranslateY(playerY);

		this.firstviewStage = firstviewStage;
		this.firstviewStage.close();
		shopStage.show();
	}

	private void createGameBackground() {
		Image backgroundImage = new Image("ThirdView.png", GameView.GAME_WIDTH, GameView.GAME_HEIGHT, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		shopRoot.setBackground(new Background(background));
	}

	private void createSettingSubScene() {
		settingSubScene = new SettingSubScene(); // will
		shopRoot.getChildren().add(settingSubScene);
	}

}