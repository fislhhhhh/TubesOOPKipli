import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;

public class Sunflower extends Plant   {
    String name="Sunflower";
    int cost=50;
    int Health =100;
    int attack_speed=0;
    int attack_damage=0;
    int range=0;
    int cooldown=10;
    boolean dead =false;
    BufferedImage Png=null;

    private String picture="res/Plants/images.jpg";
    private int timer=0;
    private int xsun;
    private int ysun;
    protected Sunflower(int X, int Y) {
        super(X, Y);
        this.xsun = X;
        this.ysun = Y;
        
        
        //TODO Auto-generated constructor stub
    }

    public void makesun(){
        Sun matahari = new Sun(xsun, ysun);
        matahari.isfromflower = true;
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
        if(timer > 6){
            makesun();
            timer = 0; 
            }
            timer= timer +1;
        }  
}
