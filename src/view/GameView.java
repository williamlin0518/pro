package view;
import Player.Player;
import SubScene.LetterSubScene;
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
    boolean removeGameview=true;
    boolean moveFlower=true;
    boolean keyfind=false;
    boolean enterFatherRoom=false;
    boolean canOpenBox;
    ImageView imageView=  new ImageView(new Image(getClass().getResourceAsStream("playerImageNew.png")));
    public static int rowImage = 4;public static int columnImage = 4;
    ImageView textView=   new ImageView(new Image(getClass().getResourceAsStream("text.png")));
    ImageView flowerView= new ImageView(new Image(getClass().getResourceAsStream("flower.png")));
    ImageView keyView=    new ImageView(new Image(getClass().getResourceAsStream("key.png")));
    ImageView letterView= new ImageView(new Image(getClass().getResourceAsStream("letter.png")));
    Player player=new Player(imageView);
    //static Pane root;
    public static Pane nowRoot=new Pane();
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;
    //private Stage fatherroomStage;
    //public MySubscene textSubScene;
    public LetterSubScene letterSubScene;
    public static final int GAME_WIDTH=732;
    public static final int GAME_HEIGHT=648;
    public enum Direction {left, right, up, down}
    public static Direction direction =Direction.down;
    public static boolean up=false,down=false,right=false,left=false,interAction=false;
    private double playerX,playerY;
    //private double letterX=letterView.getLayoutX();
    //private double letterY=letterView.getLayoutY();
    public GameView(int x,int y,boolean enterFatherRoom) {
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
                if (event.getCode() == KeyCode.S)
                    if (event.getCode() == KeyCode.S) {
                        System.out.println("check");
                        if((moveFlower==true)&&abs(playerX)==GAME_WIDTH-Player.PLAYER_WIDTH&&abs(playerY)==0){
                            System.out.println("move flower");
                            flowerView.setTranslateX(10);
                            flowerView.setTranslateY(60);
                            flowerView.setRotate(90);
                            moveFlower=false;
                            keyfind=true;
                        }
                        if(keyfind==true&&abs(playerX)==GameView.GAME_WIDTH-Player.PLAYER_WIDTH&&abs(playerY)==0){
                            System.out.println("pick key");
                            keyView.setVisible(false);
                            canOpenBox=true;
                        }
                        if(abs(playerX-600)<30&&abs(playerY-400)<30){
                            letterSubScene.moveSubScene();

                        }
                    }
            }
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP)    { up=false; }
                if (event.getCode() == KeyCode.DOWN)  { down=false; }
                if (event.getCode() == KeyCode.RIGHT) { right=false; }
                if (event.getCode() == KeyCode.LEFT)  { left=false; }
                if (event.getCode() == KeyCode.S)    { interAction=false;}
            }});
        nowRoot.getChildren().add(player);
        player.setTranslateX(x);
        player.setTranslateY(y);
        nowRoot.getChildren().add(letterView);textView.setX(100); textView.setY(593);
        nowRoot.getChildren().add(keyView);keyView.setX(600);keyView.setY(6);
        nowRoot.getChildren().add(textView);letterView.setX(600);letterView.setY(400);
        nowRoot.getChildren().add(flowerView);flowerView.setX(600);flowerView.setY(0);
        createLetterSubScene();
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
                if (playerX < 30 && playerY < 200 && playerY > 76 && removeGameview) {
                    System.out.println("go to room1");
                    Room1View roomView = new Room1View(canOpenBox);
                    roomView.createRoom1(gameStage, player, nowRoot);
                    removeGameview = false;
                }
                if (playerX < 160 && playerY < 30 && removeGameview&&enterFatherRoom) {
                    System.out.println("go to fatherroom");
                    FatherRoom fatherRoom = new FatherRoom();
                    fatherRoom.createfatherroom(gameStage, player, nowRoot);
                    removeGameview = false;
                }
                //System.out.println(playerX);
                player.updateGameView(up, down, right, left);
            }
        };
        timer.start();
        createGameBackground();
        System.out.println((abs(playerX - 100) < 50) + "+" + abs(playerY - 593));
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
        Image backgroundImage= new Image("\\view\\map1.png",GAME_WIDTH,GAME_HEIGHT,false,true);
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
//    private void disappearLetterSubScene(){
//        letterSubScene.moveSubScene();
//    }





}