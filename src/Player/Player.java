package Player;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.GameView;

public class Player extends Pane {

    ImageView playerSize;
    public static int PLAYER_WIDTH=96;
    public static int PLAYER_HEIGHT=120;
    int PLAYER_X = 0;int PLAYER_Y = 0;
    public static int PACE_SIZE =3;
    int DELAY=200;
    SpriteAnimation animation;
    public Player(ImageView imageView){
        this.playerSize =imageView;
        this.playerSize.setViewport(new Rectangle2D(PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT));
        animation =new SpriteAnimation(imageView, Duration.millis(DELAY), GameView.rowImage, GameView.columnImage, PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
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
    public void updateGameView(boolean up, boolean down, boolean right, boolean left){
        if(up){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*1);
            if(unMovableUpGameView()){moveY(0);}
            else{this.moveY(PACE_SIZE);}
        }
        else if(down){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*0);
            if(unMovableDownGameView()){moveY(0);}
            else{this.moveY(PACE_SIZE);}
        }
        else if(right){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*3);
            if(unMovableRightGameView()){moveX(0);}
            else {this.moveX(PACE_SIZE);}
        }
        else if(left){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*2);
            if(unMovableLeftGameView()){moveX(0);}
            else{this.moveX(PACE_SIZE);}
        }
        else this.animation.stop();
    }
    int leftAisleWidthPace=74,upAisleHeightPace=2,downAisleHeightPace=85,rightAisleWidthPace=0;
    int cabinetWidthPace=67,cabinetHeightPace=52;
    public boolean unMovableUpGameView() {
        if (!GameView.direction.equals(GameView.Direction.down)) {
            //邊界
            if (this.getTranslateY() == 0) { return true; }
            //下面走道
            else if (this.getTranslateX()>leftAisleWidthPace*PACE_SIZE&&this.getTranslateX()<GameView.GAME_WIDTH&&this.getTranslateY()==GameView.GAME_HEIGHT-downAisleHeightPace*PACE_SIZE){return true;}
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableDownGameView() {
        if (!GameView.direction.equals(GameView.Direction.up)) {
            //邊界
            if (this.getTranslateY()+PLAYER_HEIGHT==GameView.GAME_HEIGHT) { return true; }
            //左下櫃子
            else if (this.getTranslateX() < cabinetWidthPace * PACE_SIZE && this.getTranslateY() + PLAYER_HEIGHT == GameView.GAME_HEIGHT - cabinetHeightPace * PACE_SIZE){return true;}
            //上面走道
            else if (this.getTranslateX()>leftAisleWidthPace*PACE_SIZE&&this.getTranslateX()<GameView.GAME_WIDTH&&this.getTranslateY()==upAisleHeightPace*PACE_SIZE){return true;}
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableLeftGameView() {
        if (!GameView.direction.equals(GameView.Direction.right)) {
            //邊界
            if (this.getTranslateX() == 0) { return true; }
            //左下櫃子
            else if (this.getTranslateX() == cabinetWidthPace * PACE_SIZE && this.getTranslateY() + PLAYER_HEIGHT > GameView.GAME_HEIGHT - cabinetHeightPace * PACE_SIZE){return true;}
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableRightGameView() {
        if (!GameView.direction.equals(GameView.Direction.left)) {
            //邊界
            if (this.getTranslateX()+PLAYER_WIDTH ==GameView.GAME_WIDTH) { return true; }
            //左邊走道
            else if (this.getTranslateX()==leftAisleWidthPace*PACE_SIZE&& this.getTranslateY() > upAisleHeightPace*PACE_SIZE&&this.getTranslateY()<GameView.GAME_HEIGHT-downAisleHeightPace*PACE_SIZE){return true;}
            //
            else {return false;}
        }
        else {return false;}
    }
    public void updateRoom1(boolean up, boolean down, boolean right, boolean left){
        if(up){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*1);
            if(unMovableUpRoom1()){moveY(0);}
            else{this.moveY(PACE_SIZE);}
        }
        else if(down){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*0);
            if(unMovableDownRoom1()){moveY(0);}
            else{this.moveY(PACE_SIZE);}
        }
        else if(right){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*3);
            if(unMovableRightRoom1()){moveX(0);}
            else {this.moveX(PACE_SIZE);}
        }
        else if(left){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*2);
            if(unMovableLeftRoom1()){moveX(0);}
            else{this.moveX(PACE_SIZE);}
        }
        else this.animation.stop();
    }
    public boolean unMovableUpRoom1() {
        if (!GameView.direction.equals(GameView.Direction.down)) {
            //邊界
            if (this.getTranslateY() == 0) { return true; }
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableDownRoom1() {
        if (!GameView.direction.equals(GameView.Direction.up)) {
            //邊界
            if (this.getTranslateY()+PLAYER_HEIGHT==GameView.GAME_HEIGHT) { return true; }
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableLeftRoom1() {
        if (!GameView.direction.equals(GameView.Direction.right)) {
            //邊界
            if (this.getTranslateX() == 0) { return true; }
            //左下櫃子
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableRightRoom1() {
        if (!GameView.direction.equals(GameView.Direction.left)) {
            //邊界
            if (this.getTranslateX()+PLAYER_WIDTH ==GameView.GAME_WIDTH) { return true; }
            //
            else {return false;}
        }
        else {return false;}
    }
    public void getLocation(int playerX, int playerY){

    }

}






