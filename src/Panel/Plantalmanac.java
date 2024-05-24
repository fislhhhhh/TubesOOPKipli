package Panel;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plantalmanac extends JPanel implements MouseListener{
    private BufferedImage Png;
    protected String picture="res/Almanac/Plant.png";
    private String bigpath="res\\Almanac\\cherry.png";
    Plantalmanac(){
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
            DrawSmall((Graphics2D) g,"res\\Almanac\\cherry.png",1,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\doom.png",2,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\jalapeno.png",3,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\little.png",4,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\pad.png",5,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\pea.png",1,4);
            DrawSmall((Graphics2D) g,"res\\Almanac\\snow.png",2,4);
            DrawSmall((Graphics2D) g,"res\\Almanac\\Squash.png",3,4);
            DrawSmall((Graphics2D) g,"res\\Almanac\\sun.png",4,4);
            DrawSmall((Graphics2D) g,"res\\Almanac\\wallnut.png",5,4);
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
                        bigpath="res\\Almanac\\cherry.png";
                        break;
                    case 2:
                    bigpath="res\\Almanac\\doom.png";
                        break;
                    case 3:
                    bigpath="res\\Almanac\\jalapeno.png";
                        break;
                    case 4:
                    bigpath="res\\Almanac\\little.png";
                        break;
                    case 5:
                    bigpath="res\\Almanac\\pad.png";
                        break;
                
                }
            }else{
                switch (x) {
                    case 1:
                    bigpath="res\\Almanac\\pea.png";
                        break;
                    case 2:
                    bigpath="res\\Almanac\\snow.png";
                        break;
                    case 3:
                    bigpath="res\\Almanac\\Squash.png";
                        break;
                    case 4:
                    bigpath="res\\Almanac\\sun.png";
                        break;
                    case 5:
                    bigpath="res\\Almanac\\wallnut.png";
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

