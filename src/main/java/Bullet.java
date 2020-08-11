import java.awt.*;

public class Bullet extends MoveObject {
    public Bullet(int x, int y, Direction direction, boolean enemy, Image[] image) {
        super(x, y, direction, enemy, image);
        speed = 10;
    }

    @Override
    public void draw(Graphics g) {
        if(!alive){
            return;
        }
        move();
        collision();
        g.drawImage(image[direction.ordinal()], x, y, null);
    }

    @Override

    public void collision() {
        if (collisionBound()){
            alive = false;
            return;
        }
        //wall bound
        for (GameObject object : TankWar.gameClient.getObjects()) {
            if (object == this) {
                continue;
            }
            if (object instanceof Tank) {
                if (((Tank) object).enemy == enemy) {
                    continue;
                }

            }
            if (object.getRectangle().intersects(this.getRectangle())) {
                alive = false;
                if(object instanceof Tank){
                    object.alive=false;
                }
                return;
            }
        }
    }

}



