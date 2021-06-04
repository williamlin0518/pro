package SubScene;



import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ShopSubScene extends SubScene {
    public boolean isHidden=true;
    private final static String BACKGROUND_IMAGE = "SubScene\\test2.jpg";
    public ShopSubScene() {
        super(new AnchorPane(), 600, 200);
        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 200, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();

        root2.setBackground(new Background(image));
        setLayoutX(60);
        setLayoutY(450);
    }
}
