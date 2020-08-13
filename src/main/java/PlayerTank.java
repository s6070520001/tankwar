import java.awt.*;

public class PlayerTank extends Tank implements Superfire {
    public PlayerTank(int x , int y , Direction direction,boolean enemy, Image[] image){
        super(x,y,direction,enemy,image);
    }

    @Override
    public void superFire(){
        for(Direction direction:Direction.values()){
            Bullet bullet = new Bullet(x+width/2-GameClient.bulletImage[0].getWidth(null)/2,
                    y+height/2-GameClient.bulletImage[0].getHeight(null)/2,direction,true,GameClient.bulletImage);
        TankWar.gameClient.addGameObject(bullet);
        }

    }
}
