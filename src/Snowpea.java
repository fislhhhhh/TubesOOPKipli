import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Snowpea extends Plant {
    String name="snowpea";
    private int cost=175;
    int Health =100;
    int attack_speed=4;
    int attack_damage=25;
    int range=-1;
    int cooldown=10;
    boolean dead =false;
    int time=0;
    BufferedImage Png=null;
    private String picture;
    boolean firstshoot=true;
    protected Snowpea(int X, int Y) {
        super(X, Y);
        picture="res/Plants/Snow.jpg";
        //TODO Auto-generated constructor stub
    }

    public void shoot(){
        Bullet bullet = new Slowbullet(X, Y,attack_damage);
        Projectile.Project_in(bullet);
        
    }

    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health+" plant health" );
        if(Health<=0){
            dead=true;
            System.out.println(dead);
        }
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
    public void sloweffect(Zombie zombie){
        zombie.is_slowed = true;
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
        if(firstshoot){
            for (Zombie zombie : Screen.zombies) {
                if(check_Range(zombie)){
                    shoot();
                }
            }
            firstshoot=false;
        }else if(time>60*attack_speed){
            Zombie temp=null;
            for (Zombie zombie : Screen.zombies) {
                if(check_Range(zombie)){
                    shoot();
                    
                }
            }
            if(temp==null){
                firstshoot=true;
            }
            time=0 ;
        }else{
            time++;
        }
    }
    public String getPicture() {
        return picture;
    }
    public void spawn_Plant(boolean lily){
        Snowpea snowpea=new Snowpea(X, Y);
        if(lily){
            snowpea.setHealth(Health+100);
            lily=false;
        }
        Screen.plants.add(snowpea);
    }
    public int getCost() {
        return cost;
    }
    public int getHealth() {
        return Health;
    }
    public void setHealth(int health) {
        Health = health;
    }
    public boolean getDead(){
        return dead;
    }
}