import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Sun extends Shapes implements CustomListener{
    int pointsun = 25;
    int intervalsun=0;
    Random acak = new Random();
    String gambarsun = "";
    BufferedImage Png=null;
    int timer = 0;
    static Sun sun;
    static int totalsun = 200;
    protected Sun(int X ,int Y){
        super(X,Y);
    }
    static void sunpakai(int amount){
        totalsun =totalsun- amount;
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
    

    @Override
    public void actionPerformed() {
        if(Screen.day){
            if(timer > intervalsun*60 ){
            sunnambah(); // Mengubah posisi Y untuk turun
            timer = 0; // Reset timer setelah setiap pergerakan
            intervalsun=acak.nextInt(5,11);
            }
            timer++;
        }
        
    }
}

    


