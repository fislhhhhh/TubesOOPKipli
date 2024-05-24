package UI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Rest.Square;

public class Land extends Square {

    public Land(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }
    public void Draw(Graphics2D g2) {
        BufferedImage Png=null;
        try {
            Png = ImageIO.read(new File("res\\UI\\Grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,60,60,null);
    }
    
}
