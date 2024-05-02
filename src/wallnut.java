import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class wallnut extends Plant {
    String name="wallnut";
    int cost=50;
    int Health =1000;
    int attack_speed=0;
    int attack_damage=0;
    int range=0;
    int cooldown=0;
    boolean dead =false;
    int time=0;
    BufferedImage Png=null;
    String picture="res/Plants/images.jpg";
    public wallnut(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }

    
    public void shoot(){
        
    }

    
    @Override
    public void actionPerformed() {
    }
}
