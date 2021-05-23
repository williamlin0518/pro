package SubScene;



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
    private final static String BACKGROUND_IMAGE = "SubScene\\openletter.png";

    public LetterSubScene() {
        super(new AnchorPane(), 400, 500);
        prefWidth(400);
        prefHeight(500);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 400, 500, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane rootLetter = (AnchorPane) this.getRoot();

        rootLetter.setBackground(new Background(image));

        setLayoutX(250);
        setLayoutY(-550);

        Label letter =new Label("\n\n\n戰爭開始了…\n在戰爭中跟你走丟是爸爸的不對，\n如果你看到這封信，那真的太好了，\n爸媽房間裡應該有放軍徽，\n帶著那個就可以去地點了，\n希望你能順利躲過路上的敵人，\n自己要小心啊!");
        Font font = Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,25);
        letter.setFont(font);
        letter.setGraphicTextGap(300);
        letter.setTextFill(Color.BLUE);
        letter.setTextAlignment(TextAlignment.CENTER);
        rootLetter.getChildren().add(letter);
    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.5));
        transition.setNode(this);


        if (isHidden) {
            transition.setToX(-50);
            transition.setToY(600);
            isHidden = false;
        } else {
            transition.setToX(-50);
            transition.setToY(-550);
            isHidden = true;
        }
        transition.play();
    }
}


