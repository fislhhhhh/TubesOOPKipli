public class DiggerZombie extends Zombie {
    protected DiggerZombie(int X, int Y) {
        super(X, Y);
        name = "DiggerZombie";
        Health =150;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=false;
        picture="res/Zombies/DiggerZombie.jpeg";
    }
}
