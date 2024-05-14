import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DolphinRiderZombie extends Zombie {
    String name = "DolphinRiderZombie";
    int Health =175;
    int attack_damage=100000;
    int attack_speed=1;
    boolean is_aquatic=true;
    boolean moving=true;
    BufferedImage Png=null;
    boolean plant_in_range=false;
    int timer=0;
    boolean dead=false;
    boolean attack=false;
    Plant target=null;
    String picture="res/Zombies/DolphinRiderZombie.jpeg";
    Boolean is_slowed=false;
    boolean is_jump = false;

    public void Attack(Plant plant){
        plant.damage(attack_damage);
        if(!is_jump){
            is_jump = true;
            attack_damage = 100;
            X = X-120;
        }
    }
    public void Start_moving(){
        moving=true;
    }
    public void Stop_moving(){
        moving=false;
    }

    public void Plant_In_Range(){
        Start_moving();
        for (Plant plant : Screen.plants) {
            if(plant!=null){
                if(check_Range(plant)){
                    Stop_moving();
                target=plant;
                }
            }
        }
    }

    public boolean check_Range(Shapes shape){
        if(shape!=null){
            if(Y==shape.Y){
                if(X-1*Screen.tilesize<shape.getX()&&X>shape.getX()){
                    return true;
                }else
                {
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health);
        if(Health<=0){
            dead=true;
        }
    }

    protected DolphinRiderZombie(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
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
        if(moving){
            if(is_slowed){
                if (timer > 10){
                    X-=1;
                    Plant_In_Range();
                    timer = 0;
                }
            }
            else{
            if(timer>5){
                X-=1;
                Plant_In_Range();
                timer=0;
            }
            }

        }else{
            if(timer>60){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }
        }
        timer++;
        System.out.println(X);
    }


}
