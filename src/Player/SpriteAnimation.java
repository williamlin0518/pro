package Player;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {
    public static int rowImage = 4;public static int columnImage = 4;
    private final ImageView imageView;
    private int offsetX;
    private int offsetY;
    private final int width;
    private final int height;
    public SpriteAnimation(
            ImageView imageView,
            Duration duration,
            int rowImage,
            int columnImage,
            int offsetX,
            int offsetY,
            int width,
            int height
    )
    {
        this.imageView=imageView;
        this.rowImage =rowImage;
        this.columnImage =columnImage;
        this.offsetX=offsetX;
        this.offsetY=offsetY;
        this.width=width;
        this.height=height;
        setCycleDuration(duration);
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
    }
    public void setOffsetX(int x){
        this.offsetX=x;
    }
    public void setOffsetY(int y){
        this.offsetY=y;
    }
    @Override
    protected void interpolate(double v) {
        final int index=Math.min((int)Math.floor(rowImage *v), rowImage -1);
        final int x=(index% columnImage)*width+offsetX;
        final int y=(index/ columnImage)*height+offsetY;
        imageView.setViewport(new Rectangle2D(x,y,width,height));
    }
}