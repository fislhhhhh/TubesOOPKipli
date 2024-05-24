package Zombie;
import Plant.Plant;

public class PoleVaultingZombie extends Zombie {

    boolean is_jump = false;

    public void Attack(Plant plant){
        if(!is_jump){
            is_jump = true;
            plant.damage(100000);
            X = X-120;
        }else{
            plant.damage(attack_damage);

        }
    }


    public PoleVaultingZombie(int X, int Y) {
        super(X, Y);
        name = "PoleVaultingZombie";
        Health =175;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=false;
        picture="res\\Zombies\\Pole.png";
    }
    public boolean getis_jump(){
        return is_jump;
    }
    public void setIs_jump(boolean is_jump) {
        this.is_jump = is_jump;
    }
}
