package Player;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.GameView;

public class Player extends Pane {

    ImageView playerSize;
    int numMove = 4;int columns = 4;
    int PLAYER_X = 0;int PLAYER_Y = 0;
    int PLAYER_WIDTH =64;int PLAYER_HEIGHT =100;
    int DELAY=200;
    SpriteAnimation animation;
    public Player(ImageView imageView){
        this.playerSize =imageView;
        this.playerSize.setViewport(new Rectangle2D(PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT));
        animation =new SpriteAnimation(imageView, Duration.millis(DELAY), numMove,columns, PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
        getChildren().addAll(imageView);
    }
    public void moveX(int moveX){
        for(int i=0;i<Math.abs(moveX);i++){
            if(GameView.right){ this.setTranslateX(this.getTranslateX()+1); }
            if(GameView.left) { this.setTranslateX(this.getTranslateX()-1); }
        }
    }
    public void moveY(int moveY){
        for(int j=0;j<Math.abs(moveY);j++){
            if(GameView.down)   { this.setTranslateY(this.getTranslateY()+1); }
            if(GameView.up) { this.setTranslateY(this.getTranslateY()-1); }
        }
    }


    public void update(boolean up,boolean down,boolean right,boolean left){
        if(up){
            this.animation.play();
            this.animation.setOffsetY(290);
            this.moveY(-3);
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








}
