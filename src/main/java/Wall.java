import javax.swing.*;
import java.awt.*;

public class Wall extends GameObject {
    private int bricks;
    private boolean horizontal;

    public Wall(int x, int y, int bricks,boolean horizontal ,Image[] image) {
        super(x, y, image);
        this.bricks = bricks;
        this.horizontal = horizontal;
        //image = new ImageIcon("assets/images/brick.png").getImage();
        //image=Tools.getImage("brick.png");
    }


    public void draw(Graphics g) {
        if (horizontal) {
            for (int i = 0;i<bricks;i++){
                g.drawImage(image[0],x+i*width,y,null);
            }}
        else{
            for (int i=0;i<bricks;i++){
                g.drawImage(image[0],x,y+i*height,null);

                }
            }
        }

        @Override
    public  Rectangle getRectangle(){
        return horizontal? new Rectangle(x,y,bricks*width,height):new Rectangle(x,y,width,bricks*height);

        }
    }
