

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {
    private int width;
    private int height;
    private  boolean stop;
    //玩家坦克
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
        g.drawImage(playTank.getImage(), playTank.getX(), playTank.getY(), null);
    }


    //按鍵指令:讓坦克上下左右
    public void keyPressed(KeyEvent e) {
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
}
