import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Plant extends Shapes implements CustomListener  {
    protected String name="Plant";
    protected int cost=50;
    protected int Health =100;
    protected int attack_speed=4;
    protected int attack_damage=25;
    protected int range=-1;
    protected int cooldown=10;
    protected boolean dead =false;
    protected int time=0;
    protected BufferedImage Png=null;
    protected String picture="res/Plants/images.jpg";
    protected Plant(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }

    public void shoot(){
        
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
        if(time>60*attack_speed){
            
            for (Zombie zombie : Screen.zombies) {
                if(check_Range(zombie)){
                    shoot();
                }
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
    }
    public int getCost() {
        return cost;
    }
    public void setHealth(int health) {
        Health = health;
    }
    public int getHealth() {
        return Health;
    }
    public boolean getDead(){
        return dead;
    }
}
