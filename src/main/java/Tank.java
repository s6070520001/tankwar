

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank extends GameObject {
    protected Direction direction;
    protected int speed;
    protected boolean[] dirs = new boolean[4];
    protected boolean enemy;


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private void determineDirection() {
        if (dirs[0] && dirs[2] && !dirs[1] && !dirs[3]) direction = Direction.UP_LEFT;
        else if (dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) direction = Direction.UP_RIGHT;
        else if (!dirs[0] && dirs[1] && dirs[2] && !dirs[3]) direction = Direction.DOWN_LEFT;
        else if (!dirs[0] && dirs[1] && !dirs[2] && dirs[3]) direction = Direction.DOWN_RIGHT;
        else if (dirs[0] && !dirs[1] && !dirs[2] && !dirs[3]) direction = Direction.UP;
        else if (!dirs[0] && dirs[1] && !dirs[2] && !dirs[3]) direction = Direction.DOWN;
        else if (!dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) direction = Direction.LEFT;
        else if (!dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) direction = Direction.RIGHT;
    }

    public Tank(int x, int y, Direction direction, Image[] image) {
        this(x, y, direction, false, image);
    }

    public Tank(int x, int y, Direction direction, boolean enemy, Image[] image) {
        super(x, y, image);
        this.direction = direction;
        speed = 10;
        this.enemy = enemy;
    }

    public void fire(){
        TankWar.gameClient.addGameObject(new Bullet(x+width/2-GameClient.bulletImage[0].getWidth(null)/2,
                y+height/2-GameClient.bulletImage[0].getHeight(null)/2,direction,enemy,GameClient.bulletImage));
    }

    public void draw(Graphics g) {
        if (!isStop()) {
            determineDirection();
            move();
            collision();
        }
        g.drawImage(image[direction.ordinal()], x, y, null);
    }

    public boolean isStop() {
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i]) {
                return false;
            }
        }
        return true;
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

    public void move() {
        oldX = x;
        oldY = y;
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case UP_LEFT:
                x -= speed;
                y -= speed;
                break;
            case UP_RIGHT:
                x += speed;
                y -= speed;
                break;
            case DOWN_LEFT:
                x -= speed;
                y += speed;
                break;
            case DOWN_RIGHT:
                x += speed;
                y += speed;
                break;
        }


    }
    public boolean  collisionBound(){
        if (x < 0) {
            x = 0;
            return true;
        } else if (x > TankWar.gameClient.getWidth() - width) {
            x = TankWar.gameClient.getWidth() - width;
            return true;
        }

        if (y < 0) {
            y = 0;
            return true;
        } else if (y > TankWar.gameClient.getHeight() - height) {
            y = TankWar.gameClient.getHeight() - height;
            return true;
        }
        return false;
    }
    //bound
    public void collision(){
        collisionBound();
        //wall bound
        for (GameObject object:TankWar.gameClient.getObjects()){
            if(object!=this){
                if(object.getRectangle().intersects(this.getRectangle())){
                    x=oldX;
                    y=oldY;

                }
            }
        }

    }

    public boolean[] getDirs() {
        return dirs;
    }

    public void setDirs(boolean[] dirs) {
        this.dirs = dirs;
    }
}

