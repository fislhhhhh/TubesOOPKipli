import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sunflower extends Plant   {
    private int timer=0;
    protected Sunflower(int X, int Y) {
        super(X, Y);
        name="Sunflower";
        cost=50;
        Health =100;
        attack_speed=0;
        attack_damage=0;
        range=0;
        cooldown=10;
        picture="res/Plants/Sunflowerremove.png";
    }


    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health+" plant health" );
        if(Health<=0){
            dead=true;
        }
    }
    public boolean check_Range(Shapes shape){
        return true;
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
        if(timer > 180){
            Sun.totalsun+=25;
            timer=0;
        }  
        timer++;
    }
    public void spawn_Plant(boolean lily){
        Sunflower sunflower=new Sunflower(X, Y);
        if(lily){
            sunflower.setHealth(Health+100);
        }
        Screen.plants.add(sunflower);
    }
}
