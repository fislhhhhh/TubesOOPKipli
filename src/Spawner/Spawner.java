package Spawner;

import Panel.Screen;
import Zombie.Zombie;

public class Spawner {
    public static void spawn_Zombie(Zombie zombie){
        Screen.zombies.add(zombie);
    }
}
