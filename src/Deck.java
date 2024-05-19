import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Deck extends Square{
    String picture;
    
    protected Deck(int X, int Y,String picture) {
        super(X*Screen.tilesize, Y*Screen.tilesize);
        this.picture=picture;
        //TODO Auto-generated constructor stub
    }
    public void Draw(Graphics2D g2) {
        BufferedImage Png=null;
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);

    }
}
