import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Lilypad extends Plant  {
    private String name="Lilypad";
    int cost=25;
    int Health =100;
    int attack_speed=0;
    int attack_damage=0;
    int range=0;
    int cooldown=10;
    boolean dead =false;
    boolean is_aquatic = true;
    int time=0;
    BufferedImage Png=null;
    private String picture="res/Plants/Lilypad.jpg";
    protected Lilypad(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }

    public void shoot(){
        Bullet bullet = new Bullet(X, Y,attack_damage);
        Projectile.Project_in(bullet);
    }

    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health+" plant health" );
        if(Health<=0){
            dead=true;
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
        Lilypad lilypad=new Lilypad(X, Y);
        Screen.plants.add(lilypad);
    }
    public String getPicture() {
        return picture;
    }
    public String getName(){
        return name;
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
