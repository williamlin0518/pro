
package SubScene;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.FatherRoom;
import view.GameView;

public class FatherRoomSubScene extends SubScene {
	Button button1 = new Button("");
	Button button2 = new Button("");
	Button button3 = new Button("");
	Button buttonEnter = new Button("");
	Stage fatherRoomStage;
	boolean isPressedButtonA = true;
	boolean isPressedButton1 = true;
	boolean isPressedButtonB = true;
	boolean isPressedButton2 = true;
	boolean isPressedButtonC = true;
	boolean isPressedButton3 = true;
	private boolean isHidden = true;
	private final static String FONT_PATH = "Real Chinese.otf";
	private final static String BACKGROUND_IMAGE = "SubScene\\box.png";

	public FatherRoomSubScene(Stage fatherStage) {
		super(new AnchorPane(), 500, 400);
		prefWidth(500);
		prefHeight(400);

		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 500, 400, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

		AnchorPane root2 = (AnchorPane) this.getRoot();

		BackgroundImage backgroundImage11 = new BackgroundImage(
				new Image(getClass().getResource("button11.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background11 = new Background(backgroundImage11);

		BackgroundImage backgroundImage12 = new BackgroundImage(
				new Image(getClass().getResource("button12.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background12 = new Background(backgroundImage12);

		BackgroundImage backgroundImage13 = new BackgroundImage(
				new Image(getClass().getResource("button13.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background13 = new Background(backgroundImage13);

		BackgroundImage backgroundImage21 = new BackgroundImage(
				new Image(getClass().getResource("button21.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background21 = new Background(backgroundImage21);

		BackgroundImage backgroundImage22 = new BackgroundImage(
				new Image(getClass().getResource("button22.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background22 = new Background(backgroundImage22);

		BackgroundImage backgroundImage23 = new BackgroundImage(
				new Image(getClass().getResource("button23.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background23 = new Background(backgroundImage23);

		BackgroundImage backgroundImage31 = new BackgroundImage(
				new Image(getClass().getResource("button31.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background31 = new Background(backgroundImage31);

		BackgroundImage backgroundImage32 = new BackgroundImage(
				new Image(getClass().getResource("button32.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background32 = new Background(backgroundImage32);

		BackgroundImage backgroundImage33 = new BackgroundImage(
				new Image(getClass().getResource("button33.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background33 = new Background(backgroundImage33);

		BackgroundImage buttonenter = new BackgroundImage(
				new Image(getClass().getResource("buttonEnter.png").toExternalForm()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background buttonenterImage = new Background(buttonenter);

		button1.setPrefSize(110, 105);
		button1.setLayoutX(100);
		button1.setLayoutY(90);
		button1.setFocusTraversable(false);

		button2.setPrefSize(110, 105);
		button2.setLayoutX(205);
		button2.setLayoutY(90);
		button2.setFocusTraversable(false);

		button3.setPrefSize(110,105);
		button3.setLayoutX(315);
		button3.setLayoutY(90);
		button3.setFocusTraversable(false);

		buttonEnter.setPrefSize(80,70);
		buttonEnter.setLayoutX(210);
		buttonEnter.setLayoutY(230);
		buttonEnter.setBackground(buttonenterImage);
		buttonEnter.setFocusTraversable(false);

		root2.getChildren().add(button1);
		root2.getChildren().add(button2);
		root2.getChildren().add(button3);
		root2.getChildren().add(buttonEnter);
		root2.setBackground(new Background(image));

		setLayoutX(200);
		setLayoutY(-550);

		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {

				if (isPressedButtonA == true && isPressedButton1) {
					button1.setBackground(background11);
					isPressedButtonA = false;
				} else if (isPressedButtonA ==false && isPressedButton1) {
					button1.setBackground(background13);

					isPressedButton1 = false;
				} else if (isPressedButton1 == false) {
					button1.setBackground(background12);
					isPressedButtonA = true;
					isPressedButton1 = true;
				}
			}
		});
		button2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {

				if (isPressedButtonB == true && isPressedButton2) {
					button2.setBackground(background21);
					isPressedButtonB = false;
				} else if (isPressedButtonB == false && isPressedButton2) {
					button2.setBackground(background23);
					isPressedButton2 = false;
				} else if (isPressedButton2 == false) {
					button2.setBackground(background22);

					isPressedButtonB = true;
					isPressedButton2 = true;
				}
			}
		});
		button3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) {

				if (isPressedButtonC == true && isPressedButton3) {
					button3.setBackground(background31);
					isPressedButtonC = false;
				} else if (isPressedButtonC == false && isPressedButton3) {
					button3.setBackground(background33);
					isPressedButton3 = false;
				} else if (isPressedButton3 == false) {
					button3.setBackground(background32);

					isPressedButtonC= true;
					isPressedButton3 = true;
				}
			}
		});
		buttonEnter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				if (isPressedButton1==false  && isPressedButton2==false && isPressedButton3==false&&isPressedButtonA==false&&isPressedButtonB==false&&isPressedButtonC==false) {
					fatherRoomStage = fatherStage;
					moveSubScene();
					FatherRoom.isLab2=true;
				}
			}
		});

	}

	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.5));
		transition.setNode(this);

		if (isHidden) {
			transition.setToX(0);
			transition.setToY(700);
			isHidden = false;
		} else {
			transition.setToX(0);
			transition.setToY(-550);
			isHidden = true;
		}
		transition.play();
	}

}