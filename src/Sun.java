import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Sun extends Shapes implements CustomListener{
    String namesun = "Sun";
    int jumlahsun = 0;
    int pointsun = 25;
    int intervalsun;
    boolean falling = false ;
    Random acak = new Random();
    

    protected Sun(int X ,int Y){
        super(X,Y);
    }

    public void Start_falling(){
        falling=true;


    }
    public void Stop_falling(){
        falling=false;
    }
    
    public void sunnambah(){
        jumlahsun = jumlahsun + 25;
    }

    public void hapussun(){
        jumlahsun = 0;
    }
    public void actionPerformed() {
            int bebas = acak.nextInt(120,240);
            while (bebas > 0){
                Start_falling();
                Y = Y -1;
                bebas = bebas -1 ;
            }
            Stop_falling();
        }
    
    



}
