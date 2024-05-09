import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cherrybomb extends Plant  {
    private String name="Cherrybomb";
    int cost=75;
    int Health =100;
    int attack_speed=2;
    int attack_damage=5000;
    int range=1;
    int cooldown=20;
    boolean dead =false;
    int time=0;
    boolean hasAttacked = false;
    BufferedImage Png=null;
    private String picture="res/Plants/images.jpg";
    protected Cherrybomb(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }

    public void shoot(){
        Bullet bullet = new Boom(X, Y,attack_damage);
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
            shoot();
            afterkill();
        }else{
            time++;
        }
    }
    public String getPicture() {
        return picture;
    }
    public String getName(){
        return name;
    }
}
