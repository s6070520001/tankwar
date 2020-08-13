import java.awt.*;
import java.util.Random;

public class EnemyTank extends Tank {

    public EnemyTank(int x, int y, Direction direction,boolean enemy, Image[] image) {
        super(x, y, direction,enemy,image);
    }

    public void ai() {
        Random random = new Random();
        if (random.nextInt(20) == 1) {
            dirs = new boolean[4];
            //stop
            if (random.nextBoolean()==false) {
                return;
            }
            getNewDirection();
        }
        //fire
        if (random.nextInt(50) == 1) {
            fire();
        }
    }

    public void getNewDirection() {
        Random random = new Random();
        //up,down,right,left
        int dir = random.nextInt(Direction.values().length);

        if (dir <= Direction.RIGHT.ordinal()) {
            dirs[dir] = true;
        }else{
            if(dir ==Direction.UP_LEFT.ordinal()){
                dirs[0]=true;
                dirs[2]=true;
            }else if(dir==Direction.UP_RIGHT.ordinal()){
                dirs[0]=true;
                dirs[3]=true;
            }else if(dir==Direction.DOWN_LEFT.ordinal()){
                dirs[1]=true;
                dirs[2]=true;
            }else if(dir==Direction.DOWN_RIGHT.ordinal()){
                dirs[1]=true;
                dirs[3]=true;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        ai();
        super.draw(g);
    }
    @Override
    public boolean collision(){
        if(super.collision()){
            getNewDirection();
            return true;
        }
        return false;
    }

}
