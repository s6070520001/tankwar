import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankWar {
    public static void main(String[] args) {
        JFrame frame= new JFrame();
        final GameClient gameClient = new GameClient(1024,768);
        frame.add(gameClient);
        frame.setTitle("Tank WAR");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        //gameClient.repaint();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gameClient.keyPressed(e);
//                super.keyPressed(e);
//                System.out.println((char)e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

    }
}
