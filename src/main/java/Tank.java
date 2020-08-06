

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank extends GameObject {
    private Direction direction;
    private int speed;
    private boolean[] dirs = new boolean[4];
    private boolean enemy;


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

//    public Image getImage() {
//
//        String name =enemy ? "etank":"itank";
//
//        if (direction == Direction.UP)
//            return new ImageIcon("assets\\images\\"+name+"U.png").getImage();
//        if (direction == Direction.DOWN)
//            return new ImageIcon("assets\\images\\"+name+"D.png").getImage();
//        if (direction == Direction.LEFT)
//            return new ImageIcon("assets\\images\\"+name+"L.png").getImage();
//        if (direction == Direction.RIGHT)
//            return new ImageIcon("assets\\images\\"+name+"R.png").getImage();
//        if (direction == Direction.UP_LEFT)
//            return new ImageIcon("assets\\images\\"+name+"LU.png").getImage();
//        if (direction == Direction.UP_RIGHT)
//            return new ImageIcon("assets\\images\\"+name+"RU.png").getImage();
//        if (direction == Direction.DOWN_LEFT)
//            return new ImageIcon("assets\\images\\"+name+"LD.png").getImage();
//        if (direction == Direction.DOWN_RIGHT)
//            return new ImageIcon("assets\\images\\"+name+"RD.png").getImage();
//
//        return null;
//    }

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
    //bound
    public void collision(){
        if (x < 0) {
            x = 0;
        } else if (x > TankWar.gameClient.getWidth() - width) {
            x = TankWar.gameClient.getWidth() - width;
        }

        if (y < 0) {
            y = 0;
        } else if (y > TankWar.gameClient.getHeight() - height) {
            y = TankWar.gameClient.getHeight() - height;
        }
        //wall bound
        for (GameObject object:TankWar.gameClient.getObjects()){
            if(object!=this){
                if(object.getRectangle().intersects(this.getRectangle())){
                    x=oldX;
                    y=oldY;
                    System.out.println("1");
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

