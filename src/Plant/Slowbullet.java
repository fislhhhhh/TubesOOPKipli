package Plant;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.Screen;
import Zombie.Zombie;

public class Slowbullet extends Bullet {

    public Slowbullet(int X, int Y, int damage) {
        super(X, Y,damage);
        name="SlowBullet";
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public void hit(Zombie zombie){
        super.hit(zombie);
        zombie.setIs_slowed(true);
        zombie.setSlowtime(0);
        damage=0;
        hit=true;
    }
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File("res/slowbullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize/2,1*Screen.tilesize/2,null);
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

