import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Squash extends Plant  {
    boolean hasAttacked = false;
    protected Squash(int X, int Y) {
        super(X, Y);
        name="Squash";
        cost=50;
        Health =100;
        attack_speed=0;
        attack_damage=5000;
        range=1;
        cooldown=20;
        picture="res/Plants/Squash.jpg";
    }

    public void shoot(){
        Bullet bullet = new Stomp(X, Y,attack_damage);
        Projectile.Project_in(bullet);
    }

    

    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health+" plant health" );
        if(Health<=0){
            dead=true;
        }
    }
    public void afterkill(){
       this.Health = 0;
       dead = true;
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
                if(X<shape.getX()&&X+1*Screen.tilesize>shape.getX()&&Y==shape.getY()){
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
        if (!hasAttacked) {  
            for (Zombie zombie : Screen.zombies) {
                if (check_Range(zombie)) {
                    shoot();
                    hasAttacked = true;  
                    break;  
                }
            }
        }
        if (hasAttacked) {  
            afterkill();  
        }
    }
    public void spawn_Plant(boolean lily){
        Squash squash=new Squash(X, Y);
        if(lily){
            squash.setHealth(Health+100);
        }
        Screen.plants.add(squash);
    }
}
    

