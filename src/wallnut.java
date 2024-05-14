import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wallnut extends Plant {

    public Wallnut(int X, int Y) {
        super(X, Y);
        name="wallnut";
        cost=50;
        Health =1000;
        attack_speed=0;
        attack_damage=0;
        range=0;
        cooldown=20;
        picture="res/Plants/wallnut.jpg";
    }

    public void shoot(){

    }
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
    }

    
    @Override
    public void actionPerformed() {
    }
    public void spawn_Plant(boolean lily){
        Wallnut wallnut=new Wallnut(X, Y);
        if(lily){
            wallnut.setHealth(Health+100);
        }
        Screen.plants.add(wallnut);
    }
}
