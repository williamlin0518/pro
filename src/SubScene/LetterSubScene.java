package SubScene;



import Player.Player;
import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;


public class LetterSubScene extends SubScene {
    private boolean isHidden = true;

    private final static String FONT_PATH = "SubScene\\Real Chinese.otf";
    private final static String BACKGROUND_IMAGE = "view\\openLetter.png";

    public LetterSubScene() {
        super(new AnchorPane(), 1024, 768);
        prefWidth(1024);prefHeight(768);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 1024, 768, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        AnchorPane rootLetter = (AnchorPane) this.getRoot();
        rootLetter.setBackground(new Background(image));
        setLayoutX(250);
        setLayoutY(-1000);
    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.5));
        transition.setNode(this);


        if (isHidden) {
            transition.setToX(-300);
            transition.setToY(900);
            isHidden = false;
        } else {
            transition.setToX(-50);
            transition.setToY(-1000);
            isHidden = true;
        }
        transition.play();
    }
}


