package Plant;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Panel.Screen;
import Rest.Shapes;
import Rest.Square;
import Update.CustomListener;
import Zombie.Zombie;
public class Bullet extends Square implements CustomListener{
    int time=0;
    int damage=0;
    Boolean hit=false;
    BufferedImage Png=null;
    String name="Bullet";
    public Bullet(int X, int Y, int damage) {
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
        damage=0;
        hit=true;
    }
    
    public boolean check_hit(Shapes shape){
        if(Y==shape.getY()){
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
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public Boolean getHit() {
        return hit;
    }
}
