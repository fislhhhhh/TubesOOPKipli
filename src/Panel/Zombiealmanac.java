package Panel;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Zombiealmanac extends JPanel implements MouseListener{
    private BufferedImage Png;
    protected String picture="res\\Almanac\\Zombie.png";
    private String bigpath="res\\Almanac\\bucket.png";
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
    public void DrawGiant(Graphics2D g2,String path) {
        try {
            Png = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,415,115,60*4,60*6,null);
    }
    public void DrawSmall(Graphics2D g2,String path,int x,int y) {
        try {
            Png = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,60*x,60*y,60*1,60*2,null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Draw((Graphics2D) g);
            DrawGiant((Graphics2D) g,bigpath);
            DrawSmall((Graphics2D) g,"res\\Almanac\\bucket.png",1,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\cone.png",2,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\digger.png",3,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\door.png",4,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\duckey.png",5,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\normal.png",1,4);
            DrawSmall((Graphics2D) g,"res\\Almanac\\pole.png",2,4);
            DrawSmall((Graphics2D) g,"res\\Almanac\\ra.png",3,4);
            DrawSmall((Graphics2D) g,"res\\Almanac\\rider.png",4,4);
            DrawSmall((Graphics2D) g,"res\\Almanac\\Shadow.png",5,4);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX>5&&mouseX<65&&mouseY>27&&mouseY<87){
            Gamepanel.almanaChoose();
        }
        if(mouseX>=60&&mouseX<=360&&mouseY>=120&&mouseY<=360){
            Float a=(float) (mouseX/60);
            Float b=(float) (mouseY/60);
            int x=Math.round(a);
            int y=Math.round(b);
            if(y==3){
                y=2;
            }
            if(y==5){
                y=4;
            }
            if(y==2){
                switch (x) {
                    case 1:
                        bigpath="res\\Almanac\\bucket.png";
                        break;
                    case 2:
                    bigpath="res\\Almanac\\cone.png";
                        break;
                    case 3:
                    bigpath="res\\Almanac\\digger.png";
                        break;
                    case 4:
                    bigpath="res\\Almanac\\door.png";
                        break;
                    case 5:
                    bigpath="res\\Almanac\\duckey.png";
                        break;
                
                }
            }else{
                switch (x) {
                    case 1:
                    bigpath="res\\Almanac\\normal.png";
                        break;
                    case 2:
                    bigpath="res\\Almanac\\pole.png";
                        break;
                    case 3:
                    bigpath="res\\Almanac\\ra.png";
                        break;
                    case 4:
                    bigpath="res\\Almanac\\rider.png";
                        break;
                    case 5:
                    bigpath="res\\Almanac\\Shadow.png";
                        break;
                }
            }

        }
        repaint();
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

