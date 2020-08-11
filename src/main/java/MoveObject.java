

import java.awt.*;

public abstract class MoveObject extends GameObject {
    protected Direction direction;
    protected int speed;
    protected boolean enemy;


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public MoveObject(int x, int y, Direction direction, Image[] image) {
        this(x, y, direction, false, image);
    }

    public MoveObject(int x, int y, Direction direction, boolean enemy, Image[] image) {
        super(x, y, image);
        this.direction = direction;
        speed = 10;
        this.enemy = enemy;
    }


    public void draw(Graphics g) {


        move();
        collision();

        g.drawImage(image[direction.ordinal()], x, y, null);
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

    public boolean collisionBound() {
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
    public abstract void collision();


}

