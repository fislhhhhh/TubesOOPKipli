import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Zombie extends Square implements CustomListener {
    String name = "Zombie";
    int Health =125;
    int attack_damage=100;
    int attack_speed=1;
    boolean is_aquatic=false;
    boolean moving=true;
    BufferedImage test=null;
    int timer=0;
    public void Attack(){
        System.out.println(this.name+" attack");
    }
    public void Stop_moving(){

    }
    protected Zombie(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }
    public void Draw(Graphics2D g2) {
        try {
            test = ImageIO.read(new File("res/Zombies/images.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(test,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
        System.out.println(X*Screen.tilesize +" test");
    }
    @Override
    public void actionPerformed() {
        if(timer>10){
            X--;
            timer=0;
        }else{
            timer++;
        }
    }
    
     
}