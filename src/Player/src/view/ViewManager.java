package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
//import model.MySubscene;
//import model.SpaceRunnerButton;

import java.util.ArrayList;
import java.util.List;
/*
public class ViewManager {


    private static final int HEIGHT=800;
    private static final int WEIGHT=1024;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int MENU_BUTTONS_START_X=100;
    private final static int MENU_BUTTONS_START_Y=150;

    List<SpaceRunnerButton> menuButtons;

    private MySubscene credistsSubScene;
    private MySubscene helpsSubScene;
    private MySubscene scoreSubScene;
    private MySubscene shipChooseSubScene;

    public ViewManager(){
        menuButtons =new ArrayList<>();
        mainPane=new AnchorPane();
        mainScene=new Scene(mainPane,WEIGHT,HEIGHT);
        mainStage= new Stage();
        mainStage.setScene(mainScene);

        createButtons();
        String css = this.getClass().getResource("/model/Button.css").toExternalForm();
        mainScene.getStylesheets().add(css);

        createBackground();
        createLogo();

        createSubScenes();

    }

    private void createSubScenes() {
        credistsSubScene = new MySubscene();
        mainPane.getChildren().add(credistsSubScene);

        helpsSubScene = new MySubscene();
        mainPane.getChildren().add(helpsSubScene);

        scoreSubScene=new MySubscene();
        mainPane.getChildren().add(scoreSubScene);

        shipChooseSubScene=new MySubscene();
        mainPane.getChildren().add(shipChooseSubScene);
    }

    public Stage getMainStage(){
        return mainStage;
    }

    private void addMenuButton(SpaceRunnerButton button){
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y+menuButtons.size()*100);

        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createButtons() {
        createStartButton();
        createScoreButton();
        createHelpButton();
        createCredistsButton();
        createExitButton();

    }

    private void createStartButton(){
        SpaceRunnerButton startButton=new SpaceRunnerButton("PLAY");
        addMenuButton(startButton);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameView gameView=new GameView(870,680,false);
                gameView.createNewGame(mainStage);
            }
        });
    }

    private void createScoreButton(){
        SpaceRunnerButton scoreButton=new SpaceRunnerButton("SCORES");
        addMenuButton(scoreButton);

        scoreButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scoreSubScene.moveSubScene();
            }
        });
    }

    private void createHelpButton(){
        SpaceRunnerButton helpButton=new SpaceRunnerButton("HELP");
        addMenuButton(helpButton);

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                helpsSubScene.moveSubScene();
            }
        });
    }

    private void createCredistsButton(){
        SpaceRunnerButton creditsButton=new SpaceRunnerButton("CREDITS");
        addMenuButton(creditsButton);

        creditsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                credistsSubScene.moveSubScene();
            }
        });
    }
    private void createExitButton(){
        SpaceRunnerButton exitButton=new SpaceRunnerButton("EXIT");
        addMenuButton(exitButton);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
    }

    private void createBackground(){
        Image backgroundImage= new Image("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/model/resources/Jerusalem.jpeg",1024,800,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo(){
        ImageView logo =new ImageView(("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/model/resources/logo.png"));
        logo.setLayoutX(375 );
        logo.setLayoutY(10);

        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(new DropShadow());
            }
        });

        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(null);
            }
        });

        mainPane.getChildren().add(logo);

    }


//    public void createRunner(){
//
//        final ImageView p1=new ImageView(new Image("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/application/1.png"));
//        final ImageView p2=new ImageView(new Image("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/application/2.png"));
//        final ImageView p3=new ImageView(new Image("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/application/3.png"));
//        final ImageView p4=new ImageView(new Image("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/application/4.png"));
//        final ImageView p5=new ImageView(new Image("file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/application/5.png"));
//
//
//        bear=new Group(p1);
//
//        bear.setTranslateX(50);
//
//        bear.setTranslateY(600);
//
//        Timeline t =new Timeline();
//        t.setCycleCount(Timeline.INDEFINITE);
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(200),(ActionEvent event)-> {
//            bear.getChildren().setAll(p2);
//        }
//
//
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(300),(ActionEvent event)->{
//            bear.getChildren().setAll(p3);
//        }
//
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(400),(ActionEvent event)->{
//            bear.getChildren().setAll(p4);
//        }
//
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(500),(ActionEvent event)->{
//            bear.getChildren().setAll(p5);
//        }
//
//        ));
//        t.getKeyFrames().add(new KeyFrame(
//                Duration.millis(600),(ActionEvent event)->{
//            bear.getChildren().setAll(p1);
//        }
//        ));
//        t.play();
//
//
//        mainPane.getChildren().add(bear);
//    }




}*/
