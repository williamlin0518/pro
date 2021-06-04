package Lab2;
import Player.Player;
import Setting.Setting;
import SubScene.LetterSubScene;
import SubScene.SettingSubScene;
import SubScene.ShopSubScene;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.GameView;

import static java.lang.Math.abs;

public class ShopView {
    private Scene gameScene;
    private Stage shopStage;
    private Stage firstviewStage;
    public ShopSubScene shopSubScene;
    boolean createFirstView=true;
    boolean shopisactive;
    private final Pane shopRoot =new Pane();
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    ImageView merchantView = new ImageView(new Image(getClass().getResourceAsStream(("merchant2.png"))));
//    ImageView labelEmpty =new ImageView(new Image(getClass().getResourceAsStream("labelEmpty.png")));
    Player playerShop =new Player(imageView);
    private double playerX;
    private double playerY;
    private Setting settingButton;
    SettingSubScene settingSubScene;
    public TextArea textArea=new TextArea("In Shop");
    private Label keyLabelPane =new Label();
    public ShopView(boolean isBridge) {
        keyLabelPane.setPrefSize(100,100);
        keyLabelPane.setLayoutX(732);
        keyLabelPane.setLayoutY(0);
//        keyLabelPane.setGraphic(labelEmpty);
        keyLabelPane.setEffect(new DropShadow(1.0, Color.BLACK));

        textArea.setTranslateX(732);
        textArea.setTranslateY(200);
        textArea.setPrefSize(200,548);                                       //will
        textArea.setEditable(false);
        textArea.setFocusTraversable(false);
        textArea.setStyle("-fx-font-alignment: left");

        gameScene = new Scene(shopRoot, GameView.GAME_WIDTH+200, GameView.GAME_HEIGHT);
//        gameScene.getStylesheets().add(getClass().getResource("view\\view.css").toExternalForm());
        shopStage = new Stage();
        shopStage.setScene(gameScene);
        settingButton =new Setting();
        createShopSubScene();
        shopSubScene.setVisible(false);
        //settingButton.setOnAction(new EventHandler<ActionEvent>() {

        //	@Override
        //  public void handle(ActionEvent actionEvent) {
        //      GameView gameView=new GameView(870,680,false);
        //      gameView.createNewGame(room1Stage);
        ///   }
        // });

        settingButton.setOnAction(new EventHandler<ActionEvent>() {        //will

            @Override
            public void handle(ActionEvent actionEvent) {
                settingSubScene.moveSubScene();
                System.out.println("setting");
            }
        });

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { GameView.direction= GameView.Direction.up;GameView.up=true;}
                if (event.getCode() == KeyCode.DOWN) { GameView.direction= GameView.Direction.down; GameView.down=true;}
                if (event.getCode() == KeyCode.RIGHT){ GameView.direction= GameView.Direction.right; GameView.right=true;}
                if (event.getCode() == KeyCode.LEFT) { GameView.direction= GameView.Direction.left; GameView.left=true;}
                if (event.getCode() == KeyCode.S)    { shopisactive=true;}
            }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)     { shopisactive=false;
                System.out.println("shopView check");
                System.out.println(playerX + ", " + playerY);}
            }});
        int merchantX=550,merchantY=150;
        shopRoot.getChildren().add(merchantView);merchantView.setX(merchantX);merchantView.setY(merchantY);
        shopRoot.getChildren().add(playerShop);
        shopRoot.getChildren().add(settingButton);
        shopRoot.getChildren().add(keyLabelPane);
        shopRoot.getChildren().add(textArea);
        playerShop.setTranslateX(0);
        playerShop.setTranslateY(0);
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX= playerShop.getTranslateX();
                playerY= playerShop.getTranslateY();
                /*
                if(playerX==0&&playerY==GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT&&GameView.direction.equals(GameView.Direction.down)&& goLivingRoom){
                    double playerX=16*Player.PACE_SIZE,playerY=16*Player.PACE_SIZE;
                    GameView gameView=new GameView(playerX,playerY,enterFatherRoom);
                    System.out.println("go LivingRoom");
                    gameView.createNewGame(room1Stage);
                    goLivingRoom =false;

                }
                if ( r1isactive&&(abs(playerX+Player.PLAYER_WIDTH-GameView.GAME_WIDTH) == 0) && (abs(playerY) == 0)) {
                    System.out.println("open box");
                    textArea.appendText("\nopen box");
                    keyLabelPane.setGraphic(keyLabel);
                    textArea.appendText("\nget fatherRoom key");
                    enterFatherRoom =true;
                    r1isactive = false;
                }
                if( r1isactive){
                    System.out.println("check");
                    textArea.appendText("\ncheck");
                    System.out.println(playerX+" , "+playerY);
                    r1isactive=false;
                }

                 */

                if(playerX>0&&playerX<50&&playerY>0&&playerY<30&&GameView.up==true&&createFirstView==true){
                    FirstView firstView=new FirstView(50,520,true);
                    firstView.createFirstrView(shopStage);
                    createFirstView=false;
                }
                if(shopisactive&&abs(playerX-merchantX)<50&&abs(playerY-merchantY)<50){
                    shopSubScene.setVisible(true);
                    shopisactive=false;
                    System.out.println("open");
                }


                playerShop.updateShop(GameView.up,GameView.down,GameView.right,GameView.left);
            }
        };
        timer.start();
        createGameBackground();
        createSettingSubScene();//
    }
    public void createShopView(Stage firstviewStage){
        // pane.getChildren().remove(player);
        playerShop.setTranslateX(playerX);
        playerShop.setTranslateY(playerY);

        this.firstviewStage=firstviewStage;
        this.firstviewStage.close();
        shopStage.show();
    }

    private void createGameBackground(){
        Image backgroundImage= new Image("Lab2\\shop.jpg",GameView.GAME_WIDTH,GameView.GAME_HEIGHT,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        shopRoot.setBackground(new Background(background));
    }

    private void createSettingSubScene(){
        settingSubScene=new SettingSubScene();                //will
        shopRoot.getChildren().add(settingSubScene);
    }
    private void createShopSubScene(){
        shopSubScene =new ShopSubScene();
        shopRoot.getChildren().add(shopSubScene);
    }




}
