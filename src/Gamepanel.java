import javax.swing.*;

public class Gamepanel  {
    static Screen screen = new Screen();
    static JFrame frame;
    static Inventory inventory = new Inventory();
    static Mainmenu mainmenu;
    static Ticksystem ticksystem;
    public static void Startgame() {
        frame.remove(inventory);
        frame.remove(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        screen = new Screen();
        frame.add(screen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Sun.sun = new Sun(0, 0);
        DuckyTubeZombie zombie=new DuckyTubeZombie(10*60, 3*60);
        Spawner.spawn_Zombie(zombie);
        Zombie zombi=new Zombie(10*60, 2*60);
        Spawner.spawn_Zombie(zombi);
        zombi=new Zombie(9*60, 2*60);
        Spawner.spawn_Zombie(zombi);
        ticksystem.start=true;
    }
    public static void Inventoryscene(){
        frame.remove(mainmenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(inventory);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ticksystem=new Ticksystem();
        ticksystem.Startgame();
    }
    public static void mainMenu(){
        frame =new JFrame();
        frame.setTitle("PVZ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        mainmenu = new Mainmenu();
        frame.add(mainmenu);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void up(){
        screen.screenrefresh();
        inventory.screenrefresh();
    }
}

