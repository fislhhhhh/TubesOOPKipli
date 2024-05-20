import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Zombiealmanac extends JPanel implements MouseListener{
    private BufferedImage Png;
    protected String picture="res/Almanac/Zombie.png";
    Zombiealmanac(){
        this.setPreferredSize(new Dimension(Screen.tilesize*11,Screen.tilesize*8));
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
        g2.drawImage(Png,0,0,11*Screen.tilesize,8*Screen.tilesize,null);
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
        if(mouseX>80&&mouseX<225&&mouseY>230&&mouseY<275){
            System.out.println("plant"); 
        }
        if(mouseX>435&&mouseX<574&&mouseY>230&&mouseY<275){
            System.out.println("zombos");
       
        }
        if(mouseX>5&&mouseX<65&&mouseY>15&&mouseY<75){
            Gamepanel.almanaChoose();
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


