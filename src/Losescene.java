import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Losescene extends JPanel implements MouseListener{
    private BufferedImage Png;
    protected String picture="res/llosescene.png";
    Losescene(){
        this.setPreferredSize(new Dimension(Screen.tilesize*5,Screen.tilesize*4));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        addMouseListener(this);


    }
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,0,0,5*Screen.tilesize,4*Screen.tilesize,null);
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
        if(mouseX>30&&mouseX<250&&mouseY>190&&mouseY<225){
            System.out.println("plant"); 
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

