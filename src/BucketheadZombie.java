public class BucketheadZombie extends Zombie {
    
    
    protected BucketheadZombie(int X, int Y) {
        super(X, Y);
        name = "BucketheadZombie";
        Health = 300;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=false;
        picture="res\\Zombies\\Buckethead.png";
    }
}
