package SubScene;





import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class SettingSubScene extends SubScene {

    private boolean isHidden = true;


    private final static String BACKGROUND_IMAGE = "file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/SubScene/openletter.png";

    public SettingSubScene() {
        super(new AnchorPane(), 400, 500);
        prefWidth(400);
        prefHeight(500);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 400, 500, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();

        root2.setBackground(new Background(image));

        setLayoutX(250);
        setLayoutY(-550);

    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);


        if (isHidden) {
            transition.setToX(0);
            transition.setToY(600);
            isHidden = false;
        } else {
            transition.setToX(0);
            transition.setToY(-550);
            isHidden = true;
        }
        transition.play();
    }
}
