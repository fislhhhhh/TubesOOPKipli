import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DuckyTubeZombie extends Zombie {

    
    protected DuckyTubeZombie(int X, int Y) {
        super(X, Y);
        name = "DUckyTubeZombie";
        Health = 100;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=true;
        moving=true;
        picture="res/Zombies/DuckyTubeZombie.jpeg";
    }
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

    

    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
    }

    
}
