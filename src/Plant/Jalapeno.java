package Plant;

import Panel.Screen;
import Rest.Shapes;
import Zombie.Zombie;

public class Jalapeno  extends Plant {

    public Jalapeno(int X, int Y) {
        super(X, Y);
        name="Jalapeno";
        cost=150;
        Health =100;
        attack_speed=0;
        attack_damage=5000;
        range=-1;
        cooldown=20;
        picture="res\\Plants\\jalapeno.png";
    }

    public void shoot(){
            for (Zombie zombie : Screen.zombies) {
                if (zombie.getY() == Y) {  // Check if the zombie is in the same lane

                    zombie.setdead(true);  // Optionally set zombies as dead if damage is fatal
                }
            }
            afterkill();  // Call afterkill to handle cleanup of Jalapeno itself
        }
        
    
    public void afterkill(){
        this.Health = 0;
        dead = true;
     }

    public void damage(int amount){

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
    @Override
    public void actionPerformed() { 
        shoot();
    }
    public void spawn_Plant(boolean lily) {
        Jalapeno jalapeno=new Jalapeno(X, Y);
        if(lily){
            jalapeno.setHealth(Health+100);
        }
        Screen.plants.add(jalapeno);

    }
}
