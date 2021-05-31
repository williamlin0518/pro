package view;
import Player.Player;
import Setting.Setting;
import SubScene.LetterSubScene;
import SubScene.NoteSubScene;
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
//import model.MySubscene;
//import view.FatherRoom;
import static java.lang.Math.abs;
public class GameView {
    Pane test = new Pane();
    boolean letterfind=true;
    boolean isGoRoom1 =true;
    boolean isMovableFlower =true;
    boolean isFindableKey =false;
    boolean isOpenDoor = false;
    boolean openHole = false;//Hunk0524
    static boolean isGoFatherRoom =true;
    static boolean enterFatherRoom=false,interAction=false;
    static boolean isOpenBox;
    ImageView imageView=  new ImageView(new Image(getClass().getResourceAsStream("playerImageNew.png")));
    ImageView noteView =   new ImageView(new Image(getClass().getResourceAsStream("note.png")));
    ImageView flowerView= new ImageView(new Image(getClass().getResourceAsStream("flower.png")));
    ImageView letterView = new ImageView(new Image(getClass().getResourceAsStream("letter.png")));
    ImageView keyView=  new ImageView(new Image(getClass().getResourceAsStream("key.png"),145,117,false,false));//Hunk0524
    ImageView holeView = new ImageView(new Image(getClass().getResourceAsStream("openHole.png"),145,117,false,false));//Hunk0524
    //ImageView settingView = new ImageView(new Image(getClass().getResourceAsStream("setting.png")));  //will
    ImageView keyLabel=new ImageView(new Image(getClass().getResourceAsStream("keyLabel.png")));
    ImageView letterLabel=new ImageView(new Image(getClass().getResourceAsStream("letterLabel.png")));
    ImageView noteLabel=new ImageView(new Image(getClass().getResourceAsStream("noteLabel.png")));
    ImageView labelEmpty =new ImageView(new Image(getClass().getResourceAsStream("keyLabelEmpty.png")));
    ImageView labelEmpty1 =new ImageView(new Image(getClass().getResourceAsStream("keyLabelEmpty.png")));
    ImageView labelEmpty2 =new ImageView(new Image(getClass().getResourceAsStream("keyLabelEmpty.png")));
    //BackgroundImage labelbackground=new BackgroundImage(new Image(getClass().getResourceAsStream("keyLabel.png")), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
    Player player=new Player(imageView);
    //static Pane root;
    public Pane nowRoot=new Pane();
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;
    private Setting settingButton;
    //private Stage fatherroomStage;
    //public MySubscene textSubScene;
    public NoteSubScene noteSubScene;
    public LetterSubScene letterSubScene;
    public SettingSubScene settingSubScene;
    public static final int GAME_WIDTH=732;
    public static final int GAME_HEIGHT=648;
    public enum Direction {left, right, up, down}
    public static Direction direction =Direction.down;
    public static boolean up=false,down=false,right=false,left=false, isActive =false;
    private double playerX,playerY;
    double letterX =190*Player.UNIT_SIZE, letterY =133*Player.UNIT_SIZE;
    double noteX =20*Player.UNIT_SIZE, noteY =160*Player.UNIT_SIZE;
    double keyX=202*Player.UNIT_SIZE,keyY=4.5*Player.UNIT_SIZE;
    double holeX = 202*Player.UNIT_SIZE,holeY=4.5*Player.UNIT_SIZE;
    double flowerX=0*Player.UNIT_SIZE,flowerY=30*Player.UNIT_SIZE;
    //private double letterX=letterView.getLayoutX();
    //private double letterY=letterView.getLayoutY();
    private Label keyLabelPane =new Label();
    private Label letterLabelPane=new Label();                             //will
    private Label noteLabelPane=new Label();
    public TextArea textArea=new TextArea("In living room");

    public GameView(double x,double y,boolean enterFatherRoom) {
        playerX=x;playerY=y;
       
        nowRoot.getChildren().add(letterView);letterView.setX(letterX);letterView.setY(letterY);
        nowRoot.getChildren().add(keyView);keyView.setX(keyX);keyView.setY(keyY);
        nowRoot.getChildren().add(noteView);noteView.setX(noteX); noteView.setY(noteY);
        nowRoot.getChildren().add(flowerView);flowerView.setX(flowerX);flowerView.setY(flowerY);
        nowRoot.getChildren().add(holeView);holeView.setX(holeX);holeView.setY(holeY);//Hunk0524
        nowRoot.getChildren().add(player);player.setTranslateX(playerX);player.setTranslateY(playerY);

        holeView.setVisible(false);//Hunk0524
        keyView.setVisible(false);//Hunk0524
        createLetterSubScene();
        createNoteSubScene();
        this.enterFatherRoom =enterFatherRoom;
        gameScene = new Scene(nowRoot, GAME_WIDTH+200, GAME_HEIGHT);
        gameScene.getStylesheets().add(getClass().getResource("view.css").toExternalForm());   //will
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        
        keyLabelPane.setPrefSize(100,100);
        keyLabelPane.setLayoutX(732);
        keyLabelPane.setLayoutY(0);

        keyLabelPane.setGraphic(labelEmpty);
        keyLabelPane.setEffect(new DropShadow(1.0, Color.BLACK));



        letterLabelPane.setPrefSize(100,100);
        letterLabelPane.setLayoutX(732);
        letterLabelPane.setLayoutY(100);

        letterLabelPane.setGraphic(labelEmpty1);
        letterLabelPane.setEffect(new DropShadow(1.0, Color.BLACK));


        noteLabelPane.setPrefSize(100,100);
        noteLabelPane.setLayoutX(832);
        noteLabelPane.setLayoutY(100);

        noteLabelPane.setGraphic(labelEmpty2);
        noteLabelPane.setEffect(new DropShadow(1.0, Color.YELLOW));
        //label1.setBackground(new Background(labelbackground));
        textArea.setTranslateX(732);
        textArea.setTranslateY(200);
        textArea.setPrefSize(200,548);                                       //will
        textArea.setEditable(false);
        textArea.setFocusTraversable(false);
        textArea.setStyle("-fx-font-alignment: left");

        settingButton =new Setting();
        settingButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                settingSubScene.moveSubScene();
                System.out.println("setting");


            }
        });

        nowRoot.getChildren().add(textArea);
        nowRoot.getChildren().add(keyLabelPane);
        nowRoot.getChildren().add(letterLabelPane);
        nowRoot.getChildren().add(noteLabelPane);
        nowRoot.getChildren().add(settingButton);







        //createLetterSubScenes();
        //createKeyListeners();
//        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if (event.getCode() == KeyCode.UP) {
//                    up = true;
//                }
//                if (event.getCode() == KeyCode.DOWN) {
//                    down = true;
//                }
//                if (event.getCode() == KeyCode.RIGHT) {
//                    right = true;
//                }
//                if (event.getCode() == KeyCode.LEFT) {
//                    left = true;
//                }
//                if (event.getCode() == KeyCode.J) {
//                    if((moveFlower==true)&&abs(playerX-880)<30&&abs(playerX-880)<40&&abs(playerY-880)<40){
//                        letterView.setTranslateX(10);
//                        letterView.setTranslateY(60);
//                        letterView.setRotate(90);
//                        moveFlower=false;
//                    }
//                }
//
//            }
//        });
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)   { direction=Direction.up;up=true;}
                if (event.getCode() == KeyCode.DOWN) { direction=Direction.down; down=true;}
                if (event.getCode() == KeyCode.RIGHT){ direction=Direction.right; right=true;}
                if (event.getCode() == KeyCode.LEFT) { direction=Direction.left; left=true;}
                if (event.getCode() == KeyCode.S){ isActive =true;interAction=true;}
            }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { up=false; }
                if (event.getCode() == KeyCode.DOWN)  { down=false; }
                if (event.getCode() == KeyCode.RIGHT) { right=false; }
                if (event.getCode() == KeyCode.LEFT)  { left=false; }
                if (event.getCode() == KeyCode.S)    { isActive =false;interAction=false;}
            }});
        int doorWidth=10*Player.UNIT_SIZE;
        int goRoom1X=3*Player.UNIT_SIZE,goRoom1Y=3*Player.UNIT_SIZE;
        int goFatherRoomX=5*Player.UNIT_SIZE,goFatherRoomY=65*Player.UNIT_SIZE;
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerX = player.getTranslateX();
                playerY = player.getTranslateY();
                //System.out.println(playerX +"+"+ playerY);
/*
                if ((abs(playerX - 100) < 70) && (abs(playerY - 593) < 70) && letterfind == true) {
                    System.out.println("open letter");
                    createTextSubScene();
                    textSubScene.moveSubScene();
                    letterfind = false;
                }
                if ((abs(playerX - 100) > 70) || (abs(playerY - 593) > 70) && letterfind == false) {
                    //System.out.println("close letter");
                    nowRoot.getChildren().remove(textSubScene);
                    letterfind = true;
                }
 */

                if(isActive && openHole &&abs(keyX-playerX)<=25*Player.UNIT_SIZE&&abs(keyY-playerY)<=25*Player.UNIT_SIZE) {
                    System.out.println("open hole");
                    keyView.setVisible(true);
                    isFindableKey =true;
                    isActive = false;
                    openHole = false;
                }//Hunk0524
                else if(isActive && isFindableKey  &&abs(holeX-playerX)<=25*Player.UNIT_SIZE&&abs(holeY-playerY)<=50*Player.UNIT_SIZE) {
                    System.out.println("pick key");
                    textArea.appendText("\npick box key");
                    keyLabelPane.setGraphic(keyLabel);
                    keyView.setVisible(false);
                    holeView.setVisible(true);
                    isFindableKey=false;
                    isOpenBox =true;
                    isOpenDoor = true;
                    isActive = false;
                }//Hunk0524
                else if(isActive&&abs(playerX-noteX)<40*Player.UNIT_SIZE&&abs(playerY- noteY)<60*Player.UNIT_SIZE){
                    System.out.println("open note");
                    textArea.appendText("\nopen note");
                    System.out.println("can open hole");//Hunk0524
                    noteSubScene.moveSubScene();
                    noteLabelPane.setGraphic(noteLabel);
                    openHole = true;//Hunk0524
                    isActive=false;

                }
                else if(isActive&&abs(playerX-letterX)<10*Player.UNIT_SIZE&&abs(playerY- letterY)<7*Player.UNIT_SIZE){
                    System.out.println("open letter");
                    textArea.appendText("\nopen letter");
                    
                    letterSubScene.moveSubScene();
                    letterLabelPane.setGraphic(letterLabel);
                    isActive=false;
                }
                else if(isActive && isMovableFlower &&abs(flowerX-playerX)<=25*Player.UNIT_SIZE&&abs(flowerY-playerY)<=25*Player.UNIT_SIZE){
                    System.out.println("move flower");
                    textArea.appendText("\nmove flower");
                    double moveFlowerX=0*Player.UNIT_SIZE,moveFlowerY=20*Player.UNIT_SIZE;
                    flowerView.setTranslateX(moveFlowerX);
                    flowerView.setTranslateY(moveFlowerY);
                    flowerView.setRotate(90);
                    isMovableFlower =false;
                    isActive=false;
                    //isFindableKey =true;//Hunk0524
                }
                else if(isActive){
                    System.out.println("game check");
                    textArea.appendText("\n");
                    textArea.appendText("check");
                    System.out.println(playerX+" , "+playerY);
                    isActive=false;
                }
                /*if(isActive &&!isMovableFlower && isFindableKey &&abs(keyX-playerX)<=25*Player.UNIT_SIZE&&abs(keyY-playerY)<=25*Player.UNIT_SIZE){
                    System.out.println("pick key");
                    keyView.setVisible(false);
                    isFindableKey =false;
                    isOpenBox =true;
                }*///Hunk0524
                if(abs(noteX -playerX)<25*Player.UNIT_SIZE &&abs(noteY -playerY)<25*Player.UNIT_SIZE){
                    letterSubScene.moveSubScene();

                }
                if (playerX >=goRoom1X &&playerX<=goRoom1X+doorWidth&& playerY<goRoom1Y&&direction.equals(Direction.up)&& isGoRoom1&&isOpenDoor ) {
                    System.out.println("go to Room1");
                    Room1View roomView = new Room1View(isOpenBox);
                    roomView.createRoom1(gameStage, player, nowRoot);
                    isGoRoom1 = false;
                    direction = Direction.up;
                }
                if (playerX<=goFatherRoomX&& playerY>=goFatherRoomY&&playerY<goFatherRoomY+doorWidth&&direction.equals(Direction.left) ) {
                    System.out.println("go to FatherRoom");
                    FatherRoom fatherRoom = new FatherRoom();
                    fatherRoom.createfatherroom(gameStage, player, nowRoot);
                    isGoFatherRoom=false;
                    direction=Direction.left;
                }
                //System.out.println(playerX);
                player.updateGameView(up, down, right, left);
            }
        };
        timer.start();
        createGameBackground();
        createSettingSubScene();      // will
    }

    public void createNewGame(Stage menuStage,Player player,Pane pane){
        pane.getChildren().remove(player);
        this.menuStage=menuStage;
        this.menuStage.close();
        
        gameStage.show();
    }

    public void createNewGame(Stage menuStage){
        this.menuStage=menuStage;
        this.menuStage.close();
        gameStage.show();
    }
    private void createGameBackground(){
        Image backgroundImage= new Image("map1.png",GAME_WIDTH,GAME_HEIGHT,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        nowRoot.setBackground(new Background(background));
    }
    private void createLetterSubScene(){
        letterSubScene=new LetterSubScene();
        nowRoot.getChildren().add(letterSubScene);
    }

    private void createNoteSubScene(){
        noteSubScene=new NoteSubScene();
        nowRoot.getChildren().add(noteSubScene);
    }
    private void createSettingSubScene(){
        settingSubScene=new SettingSubScene();                //will
        nowRoot.getChildren().add(settingSubScene);
    }




}