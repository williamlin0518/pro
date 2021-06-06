package SubScene;



import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class LetterSubScene extends SubScene {

    private boolean isHidden = true;

    private final static String FONT_PATH = "Real Chinese.otf";
    private final static String BACKGROUND_IMAGE = "SubScene\\openletter.png";

    public LetterSubScene() {
        super(new AnchorPane(), 1024, 768);
        prefWidth(1024);
        prefHeight(768);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 1024, 768, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();

        root2.setBackground(new Background(image));

        setLayoutX(-100);
        setLayoutY(-1000);

    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.5));
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