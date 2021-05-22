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
import model.MySubscene;


import static java.lang.Math.abs;

public class GameView {

    Pane test = new Pane();

    boolean letterfind=true;
    boolean removeGameview=true;
    boolean moveFlower=true;
    boolean keyfind=false;




    Image img;
    //ImageView imageView = new ImageView(new Image("images2.png"));
    Image william = new Image(getClass().getResourceAsStream(("images3.png")));
    //ImageView imageView=new ImageView(new Image(getClass().getResourceAsStream("images2.png")));
    ImageView imageView = new ImageView(william);


    ImageView textView =new ImageView(new Image(getClass().getResourceAsStream("text.png")));
    ImageView flowerView=new ImageView(new Image(getClass().getResourceAsStream("/flower.png")));
    ImageView keyView=new ImageView(new Image(getClass().getResourceAsStream("key.png")));
    ImageView letterView=new ImageView(new Image(getClass().getResourceAsStream("letter.png")));

    Player player=new Player(imageView);
    static Pane root;
    private final Pane nowRoot=new Pane();


    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;
    private Stage fatherroomStage;
    public MySubscene textSubScene;
    public LetterSubScene letterSubScene;


    public static final int GAME_WIDTH=1024;
    public static final int GAME_HEIGHT=800;

    private boolean up=false;
    private boolean down=false;
    private boolean right=false;
    private boolean left=false;


    private double playerX;
    private double playerY;

    //private double letterX=letterView.getLayoutX();
    //private double letterY=letterView.getLayoutY();




    public GameView(int x,int y) {


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
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    up = false;
                }
                if (event.getCode() == KeyCode.DOWN) {
                    down = false;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    right = false;
                }
                if (event.getCode() == KeyCode.LEFT) {
                    left = false;
                }


            }
        });


        textView.setX(100);
        textView.setY(593);
        flowerView.setX(880);
        flowerView.setY(10);
        keyView.setX(900);
        keyView.setY(65);
        letterView.setX(600);
        letterView.setY(400);


        nowRoot.getChildren().add(letterView);
        nowRoot.getChildren().add(keyView);
        nowRoot.getChildren().add(textView);
        nowRoot.getChildren().add(player);
        nowRoot.getChildren().add(flowerView);
        createLetterSubScene();

        player.setTranslateX(x);
        player.setTranslateY(y);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {


                playerX = player.getTranslateX();
                playerY = player.getTranslateY();


                //System.out.println(playerX +"+"+ playerY);


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

                if (playerX < 30 && playerY < 200 && playerY > 76 && removeGameview) {

                    System.out.println("go to room1");

                    Room1View roomView = new Room1View();
                    roomView.createRoom1(gameStage, player, nowRoot);
                    removeGameview = false;
                }

                if (playerX < 160 && playerY < 30 && removeGameview) {
                    System.out.println("go to fatherroom");

                    FatherRoom fatherRoom = new FatherRoom();
                    fatherRoom.createfatherroom(gameStage, player, nowRoot);
                    removeGameview = false;
                }


                gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.UP) {
                            up = true;
                        }
                        if (event.getCode() == KeyCode.DOWN) {
                            down = true;
                        }
                        if (event.getCode() == KeyCode.RIGHT) {
                            right = true;
                        }
                        if (event.getCode() == KeyCode.LEFT) {
                            left = true;
                        }
                        if (event.getCode() == KeyCode.J) {
                            System.out.println("check");
                            if((moveFlower==true)&&abs(playerX-880)<50&&abs(playerY-30)<40){
                                System.out.println("move flower");
                                flowerView.setTranslateX(10);
                                flowerView.setTranslateY(60);
                                flowerView.setRotate(90);
                                moveFlower=false;
                                keyfind=true;
                            }
                            if(keyfind==true&&abs(playerX-880)<30&&abs(playerY-30)<30){
                                System.out.println("pick key");
                                keyView.setVisible(false);
                            }
                            if(abs(playerX-600)<30&&abs(playerY-400)<30){
                                letterSubScene.moveSubScene();

                            }
                        }

                    }
                });



                //System.out.println(playerX);
                player.update(up, down, right, left);
            }
        };
        timer.start();
        createGameBackground();


        System.out.println((abs(playerX - 100) < 50) + "+" + abs(playerY - 593));
    }


//        if(playerX<80&&playerY<200&&playerY>76){
//            System.out.println("go to room1");
//            Room1View roomView=new Room1View();
//            roomView.createRoom1(gameStage);
//        }








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
        Image backgroundImage= new Image("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/view/map1.png",1024,800,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        nowRoot.setBackground(new Background(background));
    }


    private void createTextSubScene() {
        textSubScene = new MySubscene();
        nowRoot.getChildren().add(textSubScene);
    }

    private void createLetterSubScene(){
        letterSubScene=new LetterSubScene();
        nowRoot.getChildren().add(letterSubScene);
    }
//    private void disappearLetterSubScene(){
//        letterSubScene.moveSubScene();
//    }





}
