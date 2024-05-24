package Plant;

import Panel.Screen;
import Rest.Shapes;
import Zombie.Zombie;

public class Doompea extends Plant {

    public Doompea(int X, int Y) {
        super(X, Y);
        name="Doompea";
        cost=425;
        Health =100;
        attack_speed=0;
        attack_damage=5000;
        range=-1;
        cooldown=20;
        picture="res/Plants/doom.png";
    }

    public void shoot(){
        
            for (Zombie zombie : Screen.zombies) {
                zombie.setdead(true);  
            }
            afterkill();  
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
        Doompea doompea=new Doompea(X, Y);
        if(lily){
            doompea.setHealth(Health+100);
        }
        Screen.plants.add(doompea);

    }
}
