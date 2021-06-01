package Player;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


import javafx.geometry.Rectangle2D;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.Pane;
        import javafx.util.Duration;

public class Enemy extends Pane {

    ImageView imageView;
    int count = 4;
    int columns = 4;
    int offsetX = 0;
    int offsetY = 0;
    int width = 100;
    int height = 200;


    private int playerX;
    private int playerY;


    SpriteAnimation animation;

    public Enemy(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        animation = new SpriteAnimation(imageView, Duration.millis(200), count, columns, offsetX, offsetY, width, height);
        getChildren().addAll(imageView);

        System.out.println("enemy con");
    }

    public void moveX(int x) {
        boolean right = x > 0;
        for (int i = 0; i < Math.abs(x); i++) {
            if (right) {
                this.setTranslateX(this.getTranslateX() + 1);
            } else this.setTranslateX(this.getTranslateX() - 1);

        }
        //System.out.println("moveX");
    }

    public void moveY(int y) {
        boolean down = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {
            if (down) {
                this.setTranslateY(this.getTranslateY() + 1);
            } else this.setTranslateY(this.getTranslateY() - 1);

        }
        //System.out.println("moveY");
    }


    public void update(boolean up, boolean down, boolean right, boolean left,int speed) {
        if (up) {
            this.animation.play();
            this.animation.setOffsetY(120);
            this.moveY(-speed);
            //System.out.println("up");
        } else if (down) {
            this.animation.play();
            this.animation.setOffsetY(0);
            this.moveY(speed);
        } else if (right) {
            this.animation.play();
            this.animation.setOffsetY(200);
            this.moveX(speed);
        } else if (left) {
            this.animation.play();
            this.animation.setOffsetY(0);
            this.moveX(-speed);
        } else this.animation.stop();
    }
}

