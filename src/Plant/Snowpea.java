package Plant;

import Panel.Screen;
import Spawner.Projectile;
import Zombie.Zombie;

public class Snowpea extends Plant {

    boolean firstshoot=true;
    public Snowpea(int X, int Y) {
        super(X, Y);
        
        name="Snowpea";
        cost=175;
        Health =100;
        attack_speed=4;
        attack_damage=25;
        range=-1;
        cooldown=10;
        picture="res\\Plants\\Snowpea.png";
    }

    public void shoot(){
        Slowbullet bullet = new Slowbullet(X, Y,attack_damage);
        Projectile.Project_in(bullet);
    }

    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health+" plant health" );
        if(Health<=0){
            dead=true;
            System.out.println(dead);
        }
    }
    @Override
    public void actionPerformed() {
        boolean shootable=true;
        if(firstshoot){
            for (Zombie zombie : Screen.zombies) {
                if(check_Range(zombie)&&shootable){
                    shoot();
                    shootable=false;
                }
            }
            firstshoot=false;
            time=0 ;
        }else if(time>60*attack_speed){
            Zombie temp=null;
            for (Zombie zombie : Screen.zombies) {
                if(check_Range(zombie)&&shootable){
                    shoot();
                    shootable=false;
                    temp=zombie;
                }
            }
            if(temp==null){
                firstshoot=true;
            }
            time=0 ;
        }else{
            time++;
        }
    }
    public void spawn_Plant(boolean lily){
        Snowpea snowpea=new Snowpea(X, Y);
        if(lily){
            snowpea.setHealth(Health+100);
            lily=false;
        }
        Screen.plants.add(snowpea);
    }
    public boolean getFirstshoot(){
        return firstshoot;
    }
    public void setFirstshoot(boolean firstshoot) {
        this.firstshoot = firstshoot;
    }
}