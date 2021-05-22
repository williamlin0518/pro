package Player;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Player extends Pane {

    ImageView imageView;
    int count=4;
    int columns =4;
    int offsetX=0;
    int offsetY=0;
    int width=64;
    int height=100;


    private int playerX;
    private int playerY;




    SpriteAnimation animation;

    public Player(ImageView imageView){
        this.imageView=imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation =new SpriteAnimation(imageView, Duration.millis(200),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(imageView);

        System.out.println("player con");
    }

    public void moveX(int x){
        boolean right= x > 0;
        for(int i=0;i<Math.abs(x);i++){
            if(right){
                this.setTranslateX(this.getTranslateX()+1);
            } else this.setTranslateX(this.getTranslateX()-1);

        }
        //System.out.println("moveX");
    }
    public void moveY(int y){
        boolean down= y > 0;
        for(int i=0;i<Math.abs(y);i++){
            if(down){
                this.setTranslateY(this.getTranslateY()+1);
            } else this.setTranslateY(this.getTranslateY()-1);

        }
        //System.out.println("moveY");
    }


    public void update(boolean up,boolean down,boolean right,boolean left){
        if(up){
            this.animation.play();
            this.animation.setOffsetY(290);
            this.moveY(-3);
            //System.out.println("up");
        }
        else if(down){
            this.animation.play();
            this.animation.setOffsetY(0);
            this.moveY(3);
        }
        else if(right){
            this.animation.play();
            this.animation.setOffsetY(195);
            this.moveX(3);
        }
        else if(left){
            this.animation.play();
            this.animation.setOffsetY(98 );
            this.moveX(-3);
        }
        else this.animation.stop();
    }


    public void getLocation(int playerX, int playerY){

    }






}
