public class ConeheadZombie extends Zombie {
    protected ConeheadZombie(int X, int Y) {
        super(X, Y);
        name = "ConeheadZombie";
        Health =250;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=false;
        moving=true;
        picture="res\\Zombies\\Conehead.png";
    }
    
}
