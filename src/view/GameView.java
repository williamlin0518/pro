package view;
import Player.Player;
import SubScene.LetterSubScene;
import SubScene.NoteSubScene;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
//import model.MySubscene;
//import view.FatherRoom;
import static java.lang.Math.abs;
public class GameView {
    Pane test = new Pane();
    boolean letterfind=true;
    boolean goRoom1 =true;
    boolean canMoveFlower =true;
    boolean canFindKey =false;
    boolean enterFatherRoom=false;
    boolean canOpenBox;
    ImageView imageView=  new ImageView(new Image(getClass().getResourceAsStream("playerImageNew.png")));
    public static int rowImage = 4;public static int columnImage = 4;
    ImageView textView=   new ImageView(new Image(getClass().getResourceAsStream("text.png")));
    ImageView flowerView= new ImageView(new Image(getClass().getResourceAsStream("flower.png")));
    ImageView keyView=    new ImageView(new Image(getClass().getResourceAsStream("key.png")));
    ImageView letterView = new ImageView(new Image(getClass().getResourceAsStream("letter.png")));
    Player player=new Player(imageView);
    //static Pane root;
    public Pane nowRoot=new Pane();
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;
    //private Stage fatherroomStage;
    //public MySubscene textSubScene;
    public NoteSubScene noteSubScene;
    public LetterSubScene letterSubScene;
    public static final int GAME_WIDTH=732;
    public static final int GAME_HEIGHT=648;
    public enum Direction {left, right, up, down}
    public static Direction direction =Direction.down;
    public static boolean up=false,down=false,right=false,left=false,interAction=false;
    private double playerX=50*Player.PACE_SIZE,playerY=50*Player.PACE_SIZE;
    double letterX =190*Player.PACE_SIZE, letterY =133*Player.PACE_SIZE;
    double noteX =32*Player.PACE_SIZE, noteY =180*Player.PACE_SIZE;
    double keyX=210*Player.PACE_SIZE,keyY=18*Player.PACE_SIZE;
    double flowerX=200*Player.PACE_SIZE,flowerY=0*Player.PACE_SIZE;
    //private double letterX=letterView.getLayoutX();
    //private double letterY=letterView.getLayoutY();
    public GameView(double x,double y,boolean enterFatherRoom) {
        playerX=x;playerY=y;
        nowRoot.getChildren().add(player);player.setTranslateX(playerX);player.setTranslateY(playerY);
        nowRoot.getChildren().add(letterView);
        letterView.setX(letterX);
        letterView.setY(letterY);
        nowRoot.getChildren().add(keyView);keyView.setX(keyX);keyView.setY(keyY);
        nowRoot.getChildren().add(textView);textView.setX(noteX); textView.setY(noteY);
        nowRoot.getChildren().add(flowerView);flowerView.setX(flowerX);flowerView.setY(flowerY);
        createLetterSubScene();
        createNoteSubScene();
        this.enterFatherRoom=enterFatherRoom;
        gameScene = new Scene(nowRoot, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
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
                if (event.getCode() == KeyCode.S){
                    System.out.println("check");
                    System.out.println(playerX+" , "+playerY);
                    if((canMoveFlower ==true)&&abs(playerX)==GAME_WIDTH-Player.PLAYER_WIDTH&&abs(playerY)==0){
                        System.out.println("move flower");
                        double moveFlowerX=0*Player.PACE_SIZE,moveFlowerY=20*Player.PACE_SIZE;
                        flowerView.setTranslateX(moveFlowerX);
                        flowerView.setTranslateY(moveFlowerY);
                        flowerView.setRotate(90);
                        canMoveFlower =false;
                        canFindKey =true;
                    }
                    if(canFindKey ==true&&abs(playerX)==GameView.GAME_WIDTH-Player.PLAYER_WIDTH&&abs(playerY)==0){
                        System.out.println("pick key");
                        keyView.setVisible(false);
                        canOpenBox=true;
                    }

                    if(abs(playerX-noteX)<40*Player.PACE_SIZE&&abs(playerY- noteY)<7*Player.PACE_SIZE){
                        System.out.println("open note");
                        noteSubScene.moveSubScene();

                    }
                    if(abs(playerX-letterX)<10*Player.PACE_SIZE&&abs(playerY- letterY)<7*Player.PACE_SIZE){
                        System.out.println("open letter");
                        letterSubScene.moveSubScene();

                    }
                }
        }});
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { up=false; }
                if (event.getCode() == KeyCode.DOWN)  { down=false; }
                if (event.getCode() == KeyCode.RIGHT) { right=false; }
                if (event.getCode() == KeyCode.LEFT)  { left=false; }
                if (event.getCode() == KeyCode.S)    { interAction=false;}
            }});
        int doorWidth=8*Player.PACE_SIZE;
        int goRoom1X=3*Player.PACE_SIZE,goRoom1Y=3*Player.PACE_SIZE;
        int goFatherRoomX=3*Player.PACE_SIZE,goFatherRoomY=10*Player.PACE_SIZE;
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
                if (playerX >=goRoom1X &&playerX<=goRoom1X+doorWidth&& playerY<goRoom1Y&&direction.equals(Direction.up)&&goRoom1) {
                    System.out.println("go to Room1");
                    Room1View roomView = new Room1View(canOpenBox);
                    roomView.createRoom1(gameStage, player, nowRoot);
                    goRoom1 = false;
                    direction = Direction.up;
                }
                if (playerX<=goFatherRoomX&& playerY>=goFatherRoomY&&playerY<goFatherRoomY+doorWidth&&direction.equals(Direction.left)&&goRoom1&&enterFatherRoom) {
                    System.out.println("go to FatherRoom");
                    FatherRoom fatherRoom = new FatherRoom();
                    fatherRoom.createfatherroom(gameStage, player, nowRoot);
                    goRoom1 = false;
                    direction=Direction.left;
                }
                //System.out.println(playerX);
                player.updateGameView(up, down, right, left);
            }
        };
        timer.start();
        createGameBackground();
    }

    public void createNewGame(Stage menuStage,Player player,Pane pane){
        pane.getChildren().remove(player);
        this.menuStage=menuStage;
        this.menuStage.hide();
        gameStage.show();
    }

    public void createNewGame(Stage menuStage){
        this.menuStage=menuStage;
        this.menuStage.hide();
        gameStage.show();
    }
    private void createGameBackground(){
        Image backgroundImage= new Image("file:/Users/linchengwei/IdeaProjects/Space/src/view/map1.png",GAME_WIDTH,GAME_HEIGHT,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        nowRoot.setBackground(new Background(background));
    }

/*
    private void createTextSubScene() {
        textSubScene = new MySubscene();
        nowRoot.getChildren().add(textSubScene);
    }
*/
    private void createLetterSubScene(){
        letterSubScene=new LetterSubScene();
        nowRoot.getChildren().add(letterSubScene);
    }

    private void createNoteSubScene(){
        noteSubScene=new NoteSubScene();
        nowRoot.getChildren().add(noteSubScene);
    }
//    private void disappearLetterSubScene(){
//        letterSubScene.moveSubScene();
//    }





}