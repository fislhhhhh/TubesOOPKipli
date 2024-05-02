import javax.swing.*;

public class Gamepanel  {
    static Screen screen = new Screen();
    static JFrame frame;
    static Inventory inventory;
    public static void Startgame() {
        frame.remove(inventory);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        screen = new Screen();
        frame.add(screen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Zombie zombie=new Zombie(10*Screen.tilesize, 1*Screen.tilesize);
        Spawner.spawn_Zombie(zombie);
        zombie=new Zombie(10*Screen.tilesize, 2*Screen.tilesize);
        Spawner.spawn_Zombie(zombie);
        Plant plant=new Plant(1*Screen.tilesize, 1*Screen.tilesize);
        Planter.spawn_Plant(plant);
    }
    public static void Inventoryscene(){
        frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        inventory = new Inventory();
        frame.add(inventory);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Ticksystem ticksystem=new Ticksystem();
        ticksystem.Startgame();
    }
    public static void up(){
        screen.screenrefresh();
        inventory.screenrefresh();
    }
}

