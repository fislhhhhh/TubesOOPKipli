import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Doompea extends Plant {

    protected Doompea(int X, int Y) {
        super(X, Y);
        name="Doompea";
        cost=425;
        Health =100;
        attack_speed=0;
        attack_damage=5000;
        range=-1;
        cooldown=20;
        picture="res/Plants/doom.png";
    }

    public void shoot(){
        
            for (Zombie zombie : Screen.zombies) {
                zombie.setdead(true);  
            }
            afterkill();  
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
        Doompea doompea=new Doompea(X, Y);
        if(lily){
            doompea.setHealth(Health+100);
        }
        Screen.plants.add(doompea);

    }
}
