import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Jalapeno  extends Plant {

    Boolean hasAttacked = false;
    protected Jalapeno(int X, int Y) {
        super(X, Y);
        name="Jalapeno";
        cost=150;
        Health =100;
        attack_speed=0;
        attack_damage=5000;
        range=-1;
        cooldown=20;
        picture="res/Plants/jalapeno.jpg";
    }

    public void shoot(){
            for (Zombie zombie : Screen.zombies) {
                System.out.println(Y+" test");
                System.out.println(zombie.getY()+" ztest");
                if (zombie.getY() == Y) {  // Check if the zombie is in the same lane

                    zombie.dead = true;  // Optionally set zombies as dead if damage is fatal
                }
            }
            hasAttacked = true;  // Mark as attacked to prevent further attacks
            afterkill();  // Call afterkill to handle cleanup of Jalapeno itself
        }
        
    
    public void afterkill(){
        this.Health = 0;
        dead = true;
     }

    public void damage(int amount){

    }
    public boolean check_Range(Shapes shape){
        switch (range) {
            case -1:
            if(shape!=null){
                if(Y==shape.getY()){
                    System.out.println("case -1");
                    return true;
                }
            }
            break;

            case 0:
            System.out.println("case 0");
            return true;

            default:
            if(shape!=null){
                if(X<shape.getX()&&X+1*Screen.tilesize>shape.getX()){
                    return true;
                }
            }
            return false;
        }
        return false;
        
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
        shoot();
    }
    public void spawn_Plant(boolean lily) {
        Jalapeno jalapeno=new Jalapeno(X, Y);
        if(lily){
            jalapeno.setHealth(Health+100);
        }
        Screen.plants.add(jalapeno);

    }
}
