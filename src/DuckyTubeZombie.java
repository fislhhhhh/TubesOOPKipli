public class DuckyTubeZombie extends Zombie {

    
    protected DuckyTubeZombie(int X, int Y) {
        super(X, Y);
        name = "DuckyTubeZombie";
        Health = 100;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=true;
        moving=true;
        picture="res/Zombies/DuckyTubeZombie.jpeg";
    }

}
