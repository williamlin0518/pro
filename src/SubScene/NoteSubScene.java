package SubScene;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class NoteSubScene extends SubScene {

    private boolean isHidden = true;

    private final static String FONT_PATH = "src/model/resources/Real Chinese.otf";
    private final static String BACKGROUND_IMAGE = "file:/Users/linchengwei/IdeaProjects/Space/src/SubScene/note.png";

    public NoteSubScene() {
        super(new AnchorPane(), 400, 500);
        prefWidth(400);
        prefHeight(500);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 400, 500, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();

        root2.setBackground(new Background(image));

        setLayoutX(-500);
        setLayoutY(100);

    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.0));
        transition.setNode(this);


        if (isHidden) {
            transition.setToX(600);
            transition.setToY(0);
            isHidden = false;
        } else {
            transition.setToX(-600);
            transition.setToY(0);
            isHidden = true;
        }
        transition.play();
    }
}
