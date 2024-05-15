import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DolphinRiderZombie extends Zombie {
    boolean is_jump = false;

    public void Attack(Plant plant){
        plant.damage(attack_damage);
        if(!is_jump){
            is_jump = true;
            attack_damage = 100;
            X = X-120;
        }
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


    protected DolphinRiderZombie(int X, int Y) {
        super(X, Y);
        name = "DolphinRiderZombie";
        Health =175;
        attack_damage=100000;
        attack_speed=1;
        is_aquatic=true;
        picture="res/Zombies/dolphinezombie.jpg";
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
