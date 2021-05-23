package SubScene;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class NoteSubScene extends SubScene {

    private boolean isHidden = true;

    private final static String FONT_PATH = "src/model/resources/Real Chinese.otf";
    private final static String BACKGROUND_IMAGE = "\\view\\openNote.png";

    public NoteSubScene() {
        super(new AnchorPane(), 600, 365);
        prefWidth(600);
        prefHeight(365);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 365, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();

        root2.setBackground(new Background(image));

        setLayoutX(-500);
        setLayoutY(-500);

    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.0));
        transition.setNode(this);


        if (isHidden) {
            transition.setToX(500);
            transition.setToY(650);
            isHidden = false;
        } else {
            transition.setToX(-600);
            transition.setToY(0);
            isHidden = true;
        }
        transition.play();
    }
}
