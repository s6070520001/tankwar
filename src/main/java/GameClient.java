

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {
    private int width;
    private int height;
    private  boolean stop;
    //???a?Z?J
    private Tank playTank;

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



    public void init() {
        playTank = new Tank(400, 100, Direction.DOWN);
    }


    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //g.drawImage(playTank.getImage(), playTank.getX(), playTank.getY(), null);
        playTank.draw(g);
    }



    public void keyPressed(KeyEvent e) {
        boolean[] dirs = playTank.getDirs();
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
                playTank.setDirection(Direction.UP);
                //playTank.setY(playTank.getY() - playTank.getSpeed());
//                if (playTank.getY()==0){
//                    playTank.setY()==600;
//                }
                break;
            case KeyEvent.VK_DOWN:
                playTank.setDirection(Direction.DOWN);
                //playTank.setY(playTank.getY() + playTank.getSpeed());
                break;
            case KeyEvent.VK_LEFT:
                playTank.setDirection(Direction.LEFT);
                //playTank.setX(playTank.getX() - playTank.getSpeed());
                break;
            case KeyEvent.VK_RIGHT:
                playTank.setDirection(Direction.RIGHT);
                //playTank.setX(playTank.getX() + playTank.getSpeed());
                break;
            default:

        }

        playTank.move();

    }


    public void keyReleased(KeyEvent e){
        boolean[] dirs = playTank.getDirs();
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
