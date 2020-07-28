import javax.swing.*;
import java.awt.*;

public class GameClient extends JComponent {
    private int width;
    private int height;

    GameClient(){
        this.setPreferredSize(new Dimension(800,600));
    }

    public GameClient(int width,int height){
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width,height));
    }

}

