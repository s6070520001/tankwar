

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x;
    private int y;
    private Direction direction;
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }



    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        speed = 5;
    }

    public Image getImage() {
        if (direction == Direction.UP)
            return new ImageIcon("assets\\images\\itankU.png").getImage();
        if (direction == Direction.DOWN)
            return new ImageIcon("assets\\images\\itankD.png").getImage();
        if (direction == Direction.LEFT)
            return new ImageIcon("assets\\images\\itankL.png").getImage();
        if (direction == Direction.RIGHT)
            return new ImageIcon("assets\\images\\itankR.png").getImage();
        if (direction == Direction.UP_LEFT)
            return new ImageIcon("assets\\images\\itankLU.png").getImage();
        if (direction == Direction.UP_RIGHT)
            return new ImageIcon("assets\\images\\itankRU.png").getImage();
        if (direction == Direction.DOWN_LEFT)
            return new ImageIcon("assets\\images\\itankLD.png").getImage();
        if (direction == Direction.DOWN_RIGHT)
            return new ImageIcon("assets\\images\\itankRD.png").getImage();

        return null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(){
        switch (direction){
            case UP:
                y-=speed;
                break;
            case DOWN:
                y+=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
            case  LEFT:
                x-=speed;
                break;
            case  UP_LEFT:
                x-=Math.pow(Math.pow(speed,2),0.5);
                y-=Math.pow(Math.pow(speed,2),0.5);
                break;
            case  UP_RIGHT:
                x+=Math.pow(Math.pow(speed,2),0.5);
                y-=Math.pow(Math.pow(speed,2),0.5);
                break;
            case  DOWN_LEFT:
                x-=Math.pow(Math.pow(speed,2),0.5);
                y+=Math.pow(Math.pow(speed,2),0.5);
                break;
            case  DOWN_RIGHT:
                x+=Math.pow(Math.pow(speed,2),0.5);
                y+=Math.pow(Math.pow(speed,2),0.5);
                break;
        }
    }


}

