import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mainmenu extends JPanel implements MouseListener{
    Button button;
    private BufferedImage Png;
    Mainmenu(){
        this.setPreferredSize(new Dimension(Screen.tilesize*11,Screen.tilesize*8));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        addMouseListener(this);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        Button button = new Button(0, 120,Color.yellow);
        button.Draw(g2);
        Font font=new Font("Verdana",Font.BOLD,14);
        g2.setFont(font);
        g2.setColor(Color.RED);
        g2.drawString("Startgame", 0, 150);
        button = new Button(0, 180,Color.gray);
        button.Draw(g2);
        font=new Font("Verdana",Font.BOLD,14);
        g2.setFont(font);
        g2.setColor(Color.RED);
        g2.drawString("Help", 0, 210);
        button = new Button(0, 240,Color.green);
        button.Draw(g2);
        font=new Font("Verdana",Font.BOLD,14);
        g2.setFont(font);
        g2.setColor(Color.RED);
        g2.drawString("Plant", 0, 270);
        button = new Button(0, 300,Color.MAGENTA);
        button.Draw(g2);
        font=new Font("Verdana",Font.BOLD,14);
        g2.setFont(font);
        g2.setColor(Color.RED);
        g2.drawString("Zombie", 0, 330);
        button = new Button(0, 360,Color.black);
        button.Draw(g2);
        font=new Font("Verdana",Font.BOLD,14);
        g2.setFont(font);
        g2.setColor(Color.RED);
        g2.drawString("Exit", 0, 390);
        g2.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX>0&&mouseX<120&&mouseY>120&&mouseY<180){
            Gamepanel.Inventoryscene();
        }




        if(mouseX>0&&mouseX<120&&mouseY>360&&mouseY<420){
            System.exit(0);
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
