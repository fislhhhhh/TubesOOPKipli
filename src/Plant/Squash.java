package Plant;

import Panel.Screen;
import Rest.Shapes;
import Zombie.Zombie;

public class Squash extends Plant  {
    boolean hasAttacked = false;
    public Squash(int X, int Y) {
        super(X, Y);
        name="Squash";
        cost=50;
        Health =100;
        attack_speed=0;
        attack_damage=5000;
        range=1;
        cooldown=20;
        picture="res\\Plants\\Squash.png";
    }

    public void shoot(){
        for (Zombie zombie : Screen.zombies) {
            if(zombie.getX()>=X&&zombie.getX()<=X+90&&zombie.getY()==Y){
                zombie.setdead(true);
            }
        }
        this.Health=0;
        dead=true;
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
                if(X<shape.getX()&&X+1*Screen.tilesize>shape.getX()&&Y==shape.getY()){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public void actionPerformed() {
            for (Zombie zombie : Screen.zombies) {
                if (check_Range(zombie)) {
                    shoot();
                }
            }

    }
    public void spawn_Plant(boolean lily){
        Squash squash=new Squash(X, Y);
        if(lily){
            squash.setHealth(Health+100);
        }
        Screen.plants.add(squash);
    }
}
    

