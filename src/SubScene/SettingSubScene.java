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
    Button backtogame = new Button("");//Hunk0525
	Button keysetting = new Button("");//Hunk0525
	Button backtomenu = new Button("");//Hunk0525
	

    private final static String BACKGROUND_IMAGE = "settingPic.jpg";

    public SettingSubScene() {
        super(new AnchorPane(),1024, 768);
        prefWidth(1024);
        prefHeight(768);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,423, 500, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
      
        AnchorPane rootset = (AnchorPane) this.getRoot();
       
        
        rootset.setBackground(new Background(image));
        
        setLayoutX(100);
        setLayoutY(-1000);
        BackgroundImage backgroundImage1 = new BackgroundImage( new Image( getClass().getResource("keyboardsetting.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background1 = new Background(backgroundImage1);
        
        BackgroundImage backgroundImage2 = new BackgroundImage( new Image( getClass().getResource("backtogame.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background2 = new Background(backgroundImage2);
        
        BackgroundImage backgroundImage3 = new BackgroundImage( new Image( getClass().getResource("backtomenu.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background3 = new Background(backgroundImage3);
        
        BackgroundImage backgroundImage4 = new BackgroundImage( new Image( getClass().getResource("backtosetting.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background4 = new Background(backgroundImage4);
        
       
        backtogame.setPrefSize(232, 100);
        backtogame.setLayoutX(100);
        backtogame.setLayoutY(100);
        backtogame.setBackground(background2);
       
        keysetting.setPrefSize(232,100);
        keysetting.setLayoutX(100);
        keysetting.setLayoutY(225);
        keysetting.setBackground(background1);
        
        backtomenu.setPrefSize(232,100);
        backtomenu.setLayoutX(100);
        backtomenu.setLayoutY(350);
        backtomenu.setBackground(background3);
        
        rootset.getChildren().add(backtogame);
        rootset.getChildren().add(keysetting);
        rootset.getChildren().add(backtomenu);//Hunk0525
        
        backtogame.setFocusTraversable(false);
        keysetting.setFocusTraversable(false);
        backtomenu.setFocusTraversable(false);
        backtogame.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
        	
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
				 rootset.getChildren().add(keyBoard);
				 keyBoard.setX(0);
				 keyBoard.setY(125);
				 
				 Button backtosetting = new Button("");
					backtosetting.setPrefSize(250, 100);
			        backtosetting.setLayoutX(75);
			        backtosetting.setLayoutY(350);
			        backtosetting.setBackground(background4);
			        rootset.getChildren().add(backtosetting);
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
				System.exit(0);
			}
        	
        });

    }//Hunk0525
    

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);


        if (isHidden) {
            transition.setToX(100);
            transition.setToY(1050);
            isHidden = false;
        } else {
            transition.setToX(100);
            transition.setToY(-1000);
            isHidden = true;
        }
        transition.play();
    }
}	