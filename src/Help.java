import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Help extends JPanel implements MouseListener{
    Button button;
    private BufferedImage Png;
    protected String picture="res/Help.png";
    Help(){
        this.setPreferredSize(new Dimension(Screen.tilesize*10,Screen.tilesize*6));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        addMouseListener(this);


    }
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,0,0,10*Screen.tilesize,6*Screen.tilesize,null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Draw((Graphics2D) g);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX>0&&mouseX<60&&mouseY>0&&mouseY<60){
            Gamepanel.mainMenubalik();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

}
