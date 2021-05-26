package Player;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.GameView;

public class Player extends Pane {
    public static int UNIT_SIZE=3;
    public static int paceLong=1*UNIT_SIZE;
    ImageView playerSize;
    public static int PLAYER_WIDTH=32*UNIT_SIZE;
    public static int PLAYER_HEIGHT=40*UNIT_SIZE;
    int PLAYER_X = 0;int PLAYER_Y = 0;
    int DELAY=200;
    SpriteAnimation animation;
    public Player(ImageView imageView){
        this.playerSize =imageView;
        this.playerSize.setViewport(new Rectangle2D(PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT));
        animation =new SpriteAnimation(imageView, Duration.millis(DELAY), SpriteAnimation.rowImage, SpriteAnimation.columnImage, PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
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
            else{this.moveY(paceLong);}
        }
        else if(down){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*0);
            if(unMovableDownGameView()){moveY(0);}
            else{this.moveY(paceLong);}
        }
        else if(right){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*3);
            if(unMovableRightGameView()){moveX(0);}
            else {this.moveX(paceLong);}
        }
        else if(left){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*2);
            if(unMovableLeftGameView()){moveX(0);}
            else{this.moveX(paceLong);}
        }
        else this.animation.stop();
    }
    int GameViewLeftAisleWidth =74*Player.UNIT_SIZE, GameViewUpAisleHeight =2* UNIT_SIZE, GameViewDownAisleHeight =85* UNIT_SIZE, GameViewRightAisleWidth =0* UNIT_SIZE;
    int GameViewCabinetWidth =67* UNIT_SIZE, GameViewCabinetHeight =52* UNIT_SIZE;
    public boolean unMovableUpGameView() {
        if (!GameView.direction.equals(GameView.Direction.down)) {
            //邊界
            if (this.getTranslateY() == 0) { return true; }
            //下面走道
            else if (this.getTranslateX()> GameViewLeftAisleWidth &&this.getTranslateX()<GameView.GAME_WIDTH&&this.getTranslateY()==GameView.GAME_HEIGHT- GameViewDownAisleHeight){return true;}
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
            else if (this.getTranslateX() < GameViewCabinetWidth && this.getTranslateY()+PLAYER_HEIGHT==GameView.GAME_HEIGHT- GameViewCabinetHeight){return true;}
            //上面走道
            else if (this.getTranslateX()> GameViewLeftAisleWidth &&this.getTranslateX()<GameView.GAME_WIDTH&&this.getTranslateY()== GameViewUpAisleHeight){return true;}
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
            else if (this.getTranslateX() == GameViewCabinetWidth && this.getTranslateY() + PLAYER_HEIGHT > GameView.GAME_HEIGHT - GameViewCabinetHeight){return true;}
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
            else if (this.getTranslateX()== GameViewLeftAisleWidth && this.getTranslateY() > GameViewUpAisleHeight &&this.getTranslateY()<GameView.GAME_HEIGHT- GameViewDownAisleHeight){return true;}
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
            else{this.moveY(paceLong);}
        }
        else if(down){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*0);
            if(unMovableDownRoom1()){moveY(0);}
            else{this.moveY(paceLong);}
        }
        else if(right){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*3);
            if(unMovableRightRoom1()){moveX(0);}
            else {this.moveX(paceLong);}
        }
        else if(left){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*2);
            if(unMovableLeftRoom1()){moveX(0);}
            else{this.moveX(paceLong);}
        }
        else this.animation.stop();
    }
    int Room1LeftAisleWidth =92*Player.UNIT_SIZE, Room1UpAisleHeight =0* UNIT_SIZE, Room1DownAisleHeight =100* UNIT_SIZE, Room1RightAisleWidth =52* UNIT_SIZE;
    int Room1RuinsWidth =90* UNIT_SIZE, Room1RuinsHeight =90* UNIT_SIZE;
    int boxWidth=50*UNIT_SIZE,boxHeight=10*UNIT_SIZE;
    public boolean unMovableUpRoom1() {
        if (!GameView.direction.equals(GameView.Direction.down)) {
            //邊界
            if (this.getTranslateY() == 0) { return true; }
            //下面走道
            else if (this.getTranslateX()> Room1LeftAisleWidth &&this.getTranslateX()<GameView.GAME_WIDTH-Room1RightAisleWidth&&this.getTranslateY()==GameView.GAME_HEIGHT- Room1DownAisleHeight){return true;}
            //左邊廢墟
            else if (this.getTranslateX()>=0 &&this.getTranslateX()<Room1LeftAisleWidth &&this.getTranslateY()==Room1RuinsHeight){return true;}
            //右上箱子
            else if (this.getTranslateX()>=GameView.GAME_WIDTH-Room1RightAisleWidth &&this.getTranslateX()<=GameView.GAME_WIDTH&& this.getTranslateY()==boxHeight){return true;}
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
            //右邊走道
            else if (this.getTranslateX()== GameView.GAME_WIDTH-Room1RightAisleWidth && this.getTranslateY() < GameView.GAME_HEIGHT-Room1DownAisleHeight &&this.getTranslateY()>0){return true;}
            //左邊廢墟
            else if (this.getTranslateX()==Room1RuinsWidth && this.getTranslateY() < Room1RuinsHeight &&this.getTranslateY()>0){return true;}
            else if (this.getTranslateX()==Room1RuinsWidth-20*UNIT_SIZE && this.getTranslateY() <= Room1RuinsHeight &&this.getTranslateY()>=0){return true;}
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableRightRoom1() {
        if (!GameView.direction.equals(GameView.Direction.left)) {
            //邊界
            if (this.getTranslateX()+PLAYER_WIDTH ==GameView.GAME_WIDTH) { return true; }
            //左邊走道
            else if (this.getTranslateX()== Room1LeftAisleWidth && this.getTranslateY() <= GameView.GAME_HEIGHT-Room1DownAisleHeight &&this.getTranslateY()>=0){return true;}

            //
            else {return false;}
        }
        else {return false;}
    }
    public void updateFatherRoom(boolean up, boolean down, boolean right, boolean left){
        if(up){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*1);
            if(unMovableUpFatherRoom()){moveY(0);}
            else{this.moveY(paceLong);}
        }
        else if(down){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*0);
            if(unMovableDownFatherRoom()){moveY(0);}
            else{this.moveY(paceLong);}
        }
        else if(right){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*3);
            if(unMovableRightFatherRoom()){moveX(0);}
            else {this.moveX(paceLong);}
        }
        else if(left){
            this.animation.play();
            this.animation.setOffsetY(PLAYER_HEIGHT*2);
            if(unMovableLeftFatherRoom()){moveX(0);}
            else{this.moveX(paceLong);}
        }
        else this.animation.stop();
    }
    int FatherRoomLeftAisleWidth =28*Player.UNIT_SIZE, FatherRoomUpAisleHeight =0* UNIT_SIZE, FatherRoomDownAisleHeight =90* UNIT_SIZE, FatherRoomRightAisleWidth =70* UNIT_SIZE;
    int FatherRoomBoxWidth=110*UNIT_SIZE,FatherRoomBoxHeight=20*UNIT_SIZE;
    int FatherRoomCabinetWidth=28*UNIT_SIZE,FatherRoomCabinetHeight=60*UNIT_SIZE;
    public boolean unMovableUpFatherRoom() {
        if (!GameView.direction.equals(GameView.Direction.down)) {
            //邊界
            if (this.getTranslateY() == 0) { return true; }
            //下面走道
            else if (this.getTranslateX() < GameView.GAME_WIDTH-FatherRoomRightAisleWidth&&this.getTranslateX()>FatherRoomLeftAisleWidth&& this.getTranslateY()==GameView.GAME_HEIGHT-FatherRoomDownAisleHeight){return true;}
            //右邊箱子
            else if (this.getTranslateX() >= GameView.GAME_WIDTH-FatherRoomRightAisleWidth&&this.getTranslateX()<=GameView.GAME_WIDTH&& this.getTranslateY()==FatherRoomBoxHeight){return true;}
            //左邊櫃子
            else if (this.getTranslateX() >= 0 && this.getTranslateX() <= FatherRoomLeftAisleWidth &&this.getTranslateY()==FatherRoomCabinetHeight){return true;}
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableDownFatherRoom() {
        if (!GameView.direction.equals(GameView.Direction.up)) {
            //邊界
            if (this.getTranslateY()+PLAYER_HEIGHT==GameView.GAME_HEIGHT) { return true; }
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableLeftFatherRoom() {
        if (!GameView.direction.equals(GameView.Direction.right)) {
            //邊界
            if (this.getTranslateX() == 0) { return true; }
            //右邊走道
            else if (this.getTranslateX()== GameView.GAME_WIDTH-FatherRoomRightAisleWidth && this.getTranslateY() < GameView.GAME_HEIGHT-FatherRoomDownAisleHeight &&this.getTranslateY()>0){return true;}
            //
            else {return false;}
        }
        else {return false;}
    }
    public boolean unMovableRightFatherRoom() {
        if (!GameView.direction.equals(GameView.Direction.left)) {
            //邊界
            if (this.getTranslateX()+PLAYER_WIDTH ==GameView.GAME_WIDTH) { return true; }
            //左邊走道
            else if (this.getTranslateX()== FatherRoomLeftAisleWidth && this.getTranslateY() < GameView.GAME_HEIGHT-FatherRoomDownAisleHeight &&this.getTranslateY()>0){return    true;}
            //
            else {return false;}
        }
        else {return false;}
    }
    public void getLocation(int playerX, int playerY){

    }

}






