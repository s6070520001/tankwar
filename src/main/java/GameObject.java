import javax.swing.*;
import java.awt.*;

public abstract class GameObject {
    protected int x, y;
    private int bricks;
    protected Image image;

    public GameObject(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }
    abstract void draw(Graphics g);

}
