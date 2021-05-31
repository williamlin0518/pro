package view;

import Player.Player;
import Setting.Setting;
import SubScene.SettingSubScene;
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

import static java.lang.Math.abs;

public class Room1View {
    private Scene gameScene;
    private Stage room1Stage;
    private Stage livingStage;
    boolean r1isactive;
    private final Pane root=new Pane();
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(("playerImageNew.png"))));
    ImageView labelEmpty =new ImageView(new Image(getClass().getResourceAsStream("keyLabelEmpty.png")));
    ImageView keyLabel =new ImageView(new Image(getClass().getResourceAsStream("keyLabel.png")));
    Player playerRoom1 =new Player(imageView);
    private boolean goLivingRoom = true;
    //private boolean canOpenBox;
    private boolean enterFatherRoom;
    private double playerX;
    private double playerY;
    private Setting settingButton;
    SettingSubScene settingSubScene;
    public TextArea textArea=new TextArea("In my room");
    private Label keyLabelPane =new Label();
    public Room1View(boolean canOpenBox) {
    	 keyLabelPane.setPrefSize(100,100);
         keyLabelPane.setLayoutX(732);
         keyLabelPane.setLayoutY(0);

         keyLabelPane.setGraphic(labelEmpty);
         keyLabelPane.setEffect(new DropShadow(1.0, Color.BLACK));
         
    	 textArea.setTranslateX(732);
         textArea.setTranslateY(200);
         textArea.setPrefSize(200,548);                                       //will
         textArea.setEditable(false);
         textArea.setFocusTraversable(false);
         textArea.setStyle("-fx-font-alignment: left");

        gameScene = new Scene(root, GameView.GAME_WIDTH+200, GameView.GAME_HEIGHT);
        gameScene.getStylesheets().add(getClass().getResource("view.css").toExternalForm()); 
        room1Stage = new Stage();
        room1Stage.setScene(gameScene);
       
        settingButton =new Setting();
        
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
                if (event.getCode() == KeyCode.S)    {  r1isactive=true;}
            }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { GameView.up=false; }
                if (event.getCode() == KeyCode.DOWN)  { GameView.down=false; }
                if (event.getCode() == KeyCode.RIGHT) { GameView.right=false; }
                if (event.getCode() == KeyCode.LEFT)  { GameView.left=false; }
                if (event.getCode() == KeyCode.S)     {  r1isactive=false;}
        }});
        root.getChildren().add(playerRoom1);
        root.getChildren().add(settingButton);
        root.getChildren().add(keyLabelPane);
        root.getChildren().add( textArea);
        playerRoom1.setTranslateX(Player.PLAYER_WIDTH);//起始位置
        playerRoom1.setTranslateY(GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT);//起始位置
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX= playerRoom1.getTranslateX();
                playerY= playerRoom1.getTranslateY();
                if(playerX==0&&playerY==GameView.GAME_HEIGHT-Player.PLAYER_HEIGHT&&GameView.direction.equals(GameView.Direction.down)&& goLivingRoom){
                    double playerX=16*Player.PACE_SIZE,playerY=16*Player.PACE_SIZE;
                    GameView gameView=new GameView(playerX,playerY,enterFatherRoom);
                    System.out.println("go LivingRoom");
                    gameView.createNewGame(room1Stage);
                    goLivingRoom =false;
                   
                }
                if ( r1isactive&&(abs(playerX+Player.PLAYER_WIDTH-GameView.GAME_WIDTH) == 0) && (abs(playerY) == 0)&&canOpenBox) {
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
                playerRoom1.updateRoom1(GameView.up,GameView.down,GameView.right,GameView.left);
            }
        };
        timer.start();
        createGameBackground();
        createSettingSubScene();//
    }
    public void createRoom1(Stage menuStage,Player player,Pane pane){
    	 pane.getChildren().remove(player);
        this.livingStage=menuStage;
        this.livingStage.close();
        room1Stage.show();
    }

    private void createGameBackground(){
        Image backgroundImage= new Image("room1.png",GameView.GAME_WIDTH,GameView.GAME_HEIGHT,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        root.setBackground(new Background(background));
    }

    private void createSettingSubScene(){
        settingSubScene=new SettingSubScene();                //will
        root.getChildren().add(settingSubScene);
    }




}