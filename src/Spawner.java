public class Spawner {
    static int zp=0;
    public static void spawn_Zombie(Zombie zombie){
        Screen.zombies[zp]=zombie;
        zp++;
    }
}
