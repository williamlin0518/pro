package SubScene;





import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class SettingSubScene extends SubScene {

    private boolean isHidden = true;
    Button backtogame = new Button("Back to game");//Hunk0525
	Button keysetting = new Button("Key setting");//Hunk0525
	Button backtomenu = new Button("Back to menu");//Hunk0525
	

    private final static String BACKGROUND_IMAGE = "file:/Users/linchengwei/IdeaProjects/SpaceRunner2/src/SubScene/openletter.png";

    public SettingSubScene() {
        super(new AnchorPane(), 400, 500);
        prefWidth(400);
        prefHeight(500);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 400, 500, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane rootset = (AnchorPane) this.getRoot();

        rootset.setBackground(new Background(image));

        setLayoutX(250);//Hunk0525 35-50
        setLayoutY(-550);
         setLayoutX(-100);
        setLayoutY(-1000);
        backtogame.setPrefSize(100, 50);
        backtogame.setLayoutX(300);
        backtogame.setLayoutY(300);
        keysetting.setPrefSize(100, 50);
        keysetting.setLayoutX(450);
        keysetting.setLayoutY(300);
        backtomenu.setPrefSize(100, 50);
        backtomenu.setLayoutX(600);
        backtomenu.setLayoutY(300);
        rootset.getChildren().add(backtogame);
        rootset.getChildren().add(keysetting);
        rootset.getChildren().add(backtomenu);//Hunk0525
        
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
				 ImageView keyBoard=  new ImageView(new Image(getClass().getResourceAsStream("keyBoard.jpg")));
				 rootLetter.getChildren().add(keyBoard);
				 keyBoard.setX(100);
				 keyBoard.setY(200);
				 
				 Button backtosetting = new Button("Back to setting");
					backtosetting.setPrefSize(200, 50);
			        backtosetting.setLayoutX(450);
			        backtosetting.setLayoutY(700);
			        rootLetter.getChildren().add(backtosetting);
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
