import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Inventorybag extends Square {
    Plant plant;
    private BufferedImage Png;
    Boolean picked = false;
    int X2=0;
    int Y2=0;
    protected Inventorybag(int X, int Y,Plant plant) {
        super(X*Screen.tilesize, Y*Screen.tilesize);
        this.plant=plant;
        //TODO Auto-generated constructor stub
    }
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(plant.getPicture()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(picked){
            g2.drawImage(Png,X2,Y2,1*Screen.tilesize,1*Screen.tilesize,null);
        }else{
            g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
        }
    }

}

