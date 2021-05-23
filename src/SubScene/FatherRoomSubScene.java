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


public class FatherRoomSubScene extends SubScene {

    Button button1 = new Button("1");
    Button button2 = new Button("2");
    Button button3 = new Button("3");
    Button buttonEnter = new Button("輸入");

    Stage fatherRoomStage;
    boolean isPressedButton1;
    boolean isPressedButton2;
    boolean isPressedButton3;

    private boolean isHidden=  true ;

    private final static String FONT_PATH ="src/model/resources/Real Chinese.otf";
    private final static String BACKGROUND_IMAGE="\\view\\box.png";

    public FatherRoomSubScene(Stage fatherStage){
        super(new AnchorPane(),500,400);
        prefWidth(500);
        prefHeight(400);






        BackgroundImage image=new BackgroundImage(new Image(BACKGROUND_IMAGE,500,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane root2 =(AnchorPane) this.getRoot();




        button1.setPrefSize(100,100);
        button1.setLayoutX(100);
        button1.setLayoutY(100);

        button2.setPrefSize(100,100);
        button2.setLayoutX(200);
        button2.setLayoutY(100);


        button3.setPrefSize(100,100);
        button3.setLayoutX(300);
        button3.setLayoutY(100);

        buttonEnter.setPrefSize(50,50);
        buttonEnter.setLayoutX(220);
        buttonEnter.setLayoutY(300);

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
                if(isPressedButton1 ==false){
                    button1.setStyle("-fx-background-color: MediumSeaGreen");
                    isPressedButton1 =true;
                }else {
                    isPressedButton1 =false;
                    button1.setStyle("-fx-background-color: Yellow");
                }
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(isPressedButton2 ==false){
                    button2.setStyle("-fx-background-color: MediumSeaGreen");
                    isPressedButton2 =true;
                }else {
                    isPressedButton2 =false;
                    button2.setStyle("-fx-background-color: Yellow");
                }
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(isPressedButton3 ==false){
                    button3.setStyle("-fx-background-color: MediumSeaGreen");
                    isPressedButton3 =true;
                }else {
                    button3.setStyle("-fx-background-color: Yellow");
                    isPressedButton3 = false;

                }
            }
        });
        buttonEnter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(isPressedButton1 && isPressedButton2 ==false&& isPressedButton3){
                    fatherRoomStage=fatherStage;
                    fatherRoomStage.close();
                }
            }
        });


    }

    public void moveSubScene(){
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(0.5));
        transition.setNode(this);


        if(isHidden) {
            transition.setToX(0);
            transition.setToY(700);
            isHidden=false;
        } else{
            transition.setToX(0);
            transition.setToY(-550);
            isHidden= true;
        }
        transition.play();
    }




}