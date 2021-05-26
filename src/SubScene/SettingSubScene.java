package SubScene;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
public class SettingSubScene extends SubScene {
    private boolean isHidden = true;
    Button backtogame = new Button("Back to game");//Hunk0525
    Button keysetting = new Button("Key setting");//Hunk0525
    Button backtomenu = new Button("Back to menu");//Hunk0525
    private final static String BACKGROUND_IMAGE = "\\view\\openLetter.png";
    public SettingSubScene() {
        super(new AnchorPane(), 1024, 768);
        prefWidth(1024);prefHeight(768);
        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 1024, 768, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane rootSetting = (AnchorPane) this.getRoot();
        rootSetting.setBackground(new Background(image));
        setLayoutX(-100);setLayoutY(-1000);
        backtogame.setPrefSize(100, 50);
        backtogame.setLayoutX(300);
        backtogame.setLayoutY(300);
        keysetting.setPrefSize(100, 50);
        keysetting.setLayoutX(450);
        keysetting.setLayoutY(300);
        backtomenu.setPrefSize(100, 50);
        backtomenu.setLayoutX(600);
        backtomenu.setLayoutY(300);
        rootSetting.getChildren().add(backtogame);
        rootSetting.getChildren().add(keysetting);
        rootSetting.getChildren().add(backtomenu);//Hunk0525
        backtogame.setFocusTraversable(false);
        keysetting.setFocusTraversable(false);
        backtomenu.setFocusTraversable(false);
        backtogame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                // TODO Auto-generated method stub
                moveSubScene();
            }

        });//Hunk0525

        keysetting.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                // TODO Auto-generated method stub
                ImageView keyBoard = new ImageView(new Image(getClass().getResourceAsStream("keyBoard.jpg")));
                rootSetting.getChildren().add(keyBoard);
                keyBoard.setX(100);
                keyBoard.setY(200);

                Button backtosetting = new Button("Back to setting");
                backtosetting.setPrefSize(200, 50);
                backtosetting.setLayoutX(450);
                backtosetting.setLayoutY(700);
                rootSetting.getChildren().add(backtosetting);
                backtosetting.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {

                        // TODO Auto-generated method stub
                        keyBoard.setVisible(false);
                        backtosetting.setVisible(false);
                    }

                });
            }

        });//Hunk0525

        backtomenu.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                // TODO Auto-generated method stub

            }

        });

    }//Hunk0525


    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);


        if (isHidden) {
            transition.setToX(-100);
            transition.setToY(900);
            isHidden = false;
        } else {
            transition.setToX(-100);
            transition.setToY(-1000);
            isHidden = true;
        }
        transition.play();
    }
}
