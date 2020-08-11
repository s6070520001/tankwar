import javax.swing.*;
import java.awt.*;

public abstract class GameObject {
    protected int x, y ,oldX,oldY;
    private int bricks;
    protected   int width;
    protected   int height;
    protected  Image[] image;
    protected  boolean alive;

    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }




    public GameObject(int x, int y, Image[] image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.alive = true;
        width = image[0].getWidth(null);
        height = image[0].getHeight(null);
    }
    abstract void draw(Graphics g);

}
