import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RaZombie extends Zombie {
    int contain_sun = 0;
    int  time =0;

    public void Attack(Plant plant){
        plant.damage(attack_damage);

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
            Sun.totalsun += contain_sun;
            dead=true;
        }
    }

    protected RaZombie(int X, int Y) {
        super(X, Y);
        name = "RaZombie";
        Health = 100;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=false;
        picture="res/Zombies/razombie.jpg";
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
        if (time >= 600){
            steal_sun();
        }
        timer++;
        time++;
        if(X== 30){
            System.out.println("lose");
        }
    }

    public void steal_sun(){
        if (!dead){
            if(Sun.totalsun >= 25){
                Sun.totalsun -= 25;
                contain_sun += 25;
                time = 0;
            }
        }
    }
    
}
