package Plant;

import Panel.Screen;
import Rest.Shapes;
import Rest.Sun;


public class Sunflower extends Plant   {
    private int timer=0;
    public Sunflower(int X, int Y) {
        super(X, Y);
        name="Sunflower";
        cost=50;
        Health =100;
        attack_speed=0;
        attack_damage=0;
        range=0;
        cooldown=10;
        picture="res\\Plants\\Sunflower.png";
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
