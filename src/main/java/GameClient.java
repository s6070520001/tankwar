

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameClient extends JComponent {
    private int width;
    private int height;
    private  boolean stop;
    //???a?Z?J
    private Tank playerTank;

    private List<Tank> enemyTanks = new ArrayList<>();

    private  List<Wall>walls =new ArrayList<>();

    public void init(){
        playerTank = new Tank(500 ,100,Direction.DOWN);
        for (int i = 0; i<3; i++){
            for(int j=0 ;j<8;j++){
                enemyTanks.add(new Tank(200+j*80,500+80*i,Direction.UP,true));
            }
        }
        Image image = Tools.getImage("brick.png");
        Wall[] walls={
                new Wall(300,150,15,true,image),
                new Wall(150,200,15,false,image),
                new Wall(850,200,15,false,image)
        };
        this.walls.addAll(Arrays.asList(walls));
    }



    GameClient() {
        this.setPreferredSize(new Dimension(800, 600));
    }

    public GameClient(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        init();
        new  Thread(()->{
            while(!stop){
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



//    public void init() {
//        playerTank = new Tank(400, 100, Direction.DOWN);
//    }


    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //g.drawImage(playTank.getImage(), playTank.getX(), playTank.getY(), null);
        playerTank.draw(g);
        for (Tank tank:enemyTanks){
            tank.draw(g);
        }
        for (Wall wall:walls){
            wall.draw(g);
        }


    }




    public void keyPressed(KeyEvent e) {
        boolean[] dirs = playerTank.getDirs();
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                dirs[0]=true;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=true;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2]=true;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3]=true;
                break;
        }


        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                playerTank.setDirection(Direction.UP);
                //playTank.setY(playTank.getY() - playTank.getSpeed());
//                if (playTank.getY()==0){
//                    playTank.setY()==600;
//                }
                break;
            case KeyEvent.VK_DOWN:
                playerTank.setDirection(Direction.DOWN);
                //playTank.setY(playTank.getY() + playTank.getSpeed());
                break;
            case KeyEvent.VK_LEFT:
                playerTank.setDirection(Direction.LEFT);
                //playTank.setX(playTank.getX() - playTank.getSpeed());
                break;
            case KeyEvent.VK_RIGHT:
                playerTank.setDirection(Direction.RIGHT);
                //playTank.setX(playTank.getX() + playTank.getSpeed());
                break;
            default:

        }

        playerTank.move();

    }


    public void keyReleased(KeyEvent e){
        boolean[] dirs = playerTank.getDirs();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = false;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = false;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2] = false;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3] = false;
                break;
        }
    }
}
