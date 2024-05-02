import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Sun extends Shapes{
    int pointsun = 25;
    int intervalsun;
    Random acak = new Random();
    String gambarsun = "";
    BufferedImage Png=null;
    int timer = 0;
    static int totalsun = 0;

    protected Sun(int X ,int Y){
        super(X,Y);
    }
    public void sunpakai(int amount){
        totalsun -= amount;
    }
    public void sunnambah(){
        totalsun = totalsun + pointsun;
    }


    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(gambarsun));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
    }
    


    public void actionPerformed() {
        if(timer > 1 ){
        sunnambah(); // Mengubah posisi Y untuk turun
        timer = 0; // Reset timer setelah setiap pergerakan
        }
        timer++;
        
    }
}

    


