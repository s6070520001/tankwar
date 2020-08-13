import java.awt.*;

public class Bullet extends MoveObject {
    public Bullet(int x, int y, Direction direction, boolean enemy, Image[] image) {
        super(x, y, direction, enemy, image);
        speed = 10;
    }

    @Override
    public void draw(Graphics g) {
        if (!alive) {
            return;
        }
        move();
        collision();
        g.drawImage(image[direction.ordinal()], x, y, null);
    }

    @Override

    public boolean collision() {
        if (collisionBound()) {
            alive = false;
            TankWar.gameClient.addGameObject(new Explosion(x + (GameClient.explosionImage[0].getWidth(null) - width) / 2,
                    y + (GameClient.explosionImage[0].getHeight(null) - height) / 2, GameClient.explosionImage));
            return true;
        }
        //bullet does not collision
        for (GameObject object : TankWar.gameClient.getObjects()) {
            if (object instanceof Bullet || object instanceof Explosion) {
                continue;
            }
            //Tank collision
            if (object instanceof Tank) {
                if (((Tank) object).enemy == enemy) {
                    continue;
                }

            }
            //collision and disappear
            if (object.getRectangle().intersects(this.getRectangle())) {
                alive = false;
                if (object instanceof Tank) {
                    object.alive = false;
                }
                //create explosion
                TankWar.gameClient.addGameObject(new Explosion(x + (GameClient.explosionImage[0].getWidth(null) - width) / 2,
                        y + (GameClient.explosionImage[0].getHeight(null) - height) / 2, GameClient.explosionImage));
                return true;
            }
        }
        return false;
    }

}



