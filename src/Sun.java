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
    String gambarsun = "";
    BufferedImage Png=null;
    Boolean gone = false;
    int waktudiam = 0;
    int bebas = acak.nextInt(720,1080);
    int timer = 0;

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

    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(gambarsun));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
    }
    
    public void sunhilang(){
        gone = true;
    }

    public void actionPerformed() {
            
        // if(falling){
        //     if(timer > 10){
        //         Y += 2; // Mengubah posisi Y untuk turun
        //         timer = 0; // Reset timer setelah setiap pergerakan
        //     }
        // }
        // timer++;
        
        
        if(falling && bebas > 0){
            if(timer > 10){
                Y += 2; // Mengubah posisi Y untuk turun
                timer = 0; // Reset timer setelah setiap pergerakan
                }
                bebas-=1;
        }
        else{   
            waktudiam +=1;
            if(waktudiam == 300){
            sunhilang();
            }
        }
        timer++;

}
    



}

