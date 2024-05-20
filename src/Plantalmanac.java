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
    private String bigpath="res\\Almanac\\Snowpea.PNG";
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
    public void DrawGiant(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(bigpath));
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
        g.setColor(Color.BLUE);
        g.fillRect(5, 27, 60, 60);
        DrawGiant((Graphics2D) g);
        for (int i = 1; i < 6; i++) {
            DrawSmall((Graphics2D) g,"res\\Almanac\\Snowpea.PNG",i,2);
            DrawSmall((Graphics2D) g,"res\\Almanac\\Snowpea.PNG",i,4);
        }
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
            System.out.println(x+" "+y);
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

