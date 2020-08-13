

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank extends MoveObject {
    protected boolean[] dirs = new boolean[4];

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
        super(x, y, direction, enemy, image);
        this.direction = direction;
        speed = 10;
        this.enemy = enemy;
    }

    public void fire() {
        TankWar.gameClient.addGameObject(new Bullet(x + width / 2 - GameClient.bulletImage[0].getWidth(null) / 2,
                y + height / 2 - GameClient.bulletImage[0].getHeight(null) / 2, direction, enemy, GameClient.bulletImage));
    }

    public void superFire() {
        for (Direction direction : Direction.values()) {
            Bullet bullet = new Bullet(x + width / 2 - GameClient.bulletImage[0].getWidth(null) / 2,
                    y + height / 2 - GameClient.bulletImage[0].getHeight(null) / 2, direction, enemy, GameClient.bulletImage);
            bullet.setSpeed(15);
            TankWar.gameClient.addGameObject(bullet);
        }
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


    //bound
    public boolean collision() {
        if(collisionBound()){
            return true;
        }

        //wall bound
        for (GameObject object : TankWar.gameClient.getObjects()) {
            if (object != this) {
                if (object.getRectangle().intersects(this.getRectangle())) {
                    x = oldX;
                    y = oldY;
                    return true;

                }
            }
        }
        return false;
    }

    public boolean[] getDirs() {
        return dirs;
    }

    public void setDirs(boolean[] dirs) {
        this.dirs = dirs;
    }
}

