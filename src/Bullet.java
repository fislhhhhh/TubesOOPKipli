import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Bullet extends Square implements CustomListener{
    int time=0;
    int damage=0;
    private BufferedImage Png;
    Boolean hit=false;
    protected Bullet(int X, int Y, int damage) {
        super(X, Y);
        this.damage=damage;
        //TODO Auto-generated constructor stub
    }
    
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File("res/bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize/2,1*Screen.tilesize/2,null);
    }
    
    public void hit(Zombie zombie){
        zombie.damage(damage);
        System.out.println(damage);
        damage=0;
        hit=true;
    }
    public boolean check_hit(Shapes shape){
        if(X<shape.getX()&&X+1*Screen.tilesize/2>shape.getX()){
            return true;
        }else
        {
            return false;
        }
    }
    public void actionPerformed() {
        X+=2;
        for (Zombie zombie : Screen.zombies) {
            if(check_hit(zombie)){
                hit(zombie);
            }
        }
    }
}
