import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Slowbullet extends Bullet {
    int time=0;
    int damage=0;
    private BufferedImage Png;
    Boolean hit=false;
    protected Slowbullet(int X, int Y, int damage) {
        super(X, Y,damage);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public void hit(Zombie zombie){
        super.hit(zombie);
        zombie.is_slowed = true;
    
    }
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File("res/slowbullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize/2,1*Screen.tilesize/2,null);
    }

    public boolean check_hit(Shapes shape){
        if(Y==shape.Y){
            if(X<shape.getX()&&X+1*Screen.tilesize/2>shape.getX()){
                return true;
            }else
            {
                return false;
            }
        }else{
            return false;
        }
    }


    
    public void actionPerformed() {
        X+=2;
        if(X>11*Screen.tilesize){
            hit=true;
        }
        for (Zombie zombie : Screen.zombies) {
            if(check_hit(zombie)){
                hit(zombie);
            }
        }
    }
}

