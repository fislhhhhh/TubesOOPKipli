package UI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.Screen;
import Rest.Square;
public class Button extends Square {
    int width=Screen.tilesize*2;
    int height =Screen.tilesize;
    String img;
    public Button(int X, int Y,int width,int height,String img) {
        super(X, Y);
        this.width=width;
        this.height=height;
        this.img= img;
    }
    public void Draw(Graphics2D g2) {
        BufferedImage Png=null;
        try {
            Png = ImageIO.read(new File(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,width,height,null);
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
    return height;
    }
}
