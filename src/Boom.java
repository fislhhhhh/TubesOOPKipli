import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Boom extends Bullet{
    int time=0;
    int damage=0;
    private BufferedImage Png;
    Boolean hit=false;
    protected Boom(int X, int Y, int damage) {
        super(X, Y,damage);
        this.damage=damage;
        //TODO Auto-generated constructor stub
    }
    
    public void Draw(Graphics2D g2) {
      
        
    }
    
    public void hit(Zombie zombie){
        zombie.damage(damage);
        System.out.println(damage);
        damage=0;
        hit=true;
    }
    @Override
    public boolean check_hit(Shapes shape) {
        int tilesize = Screen.tilesize;  
        int thisLeftX = X;
        int thisRightX = X + tilesize;
        int thisTopY = Y;
        int thisBottomY = Y + tilesize;
    
        int shapeLeftX = shape.getX();
        int shapeRightX = shape.getX() + tilesize;
        int shapeTopY = shape.getY();
        int shapeBottomY = shape.getY() + tilesize;
    
        
        if ((shapeRightX >= thisLeftX - tilesize && shapeLeftX <= thisRightX + tilesize) &&
            (shapeBottomY >= thisTopY - tilesize && shapeTopY <= thisBottomY + tilesize)) {
            return true;
        }
    
        return false;
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
