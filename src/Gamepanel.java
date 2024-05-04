import java.awt.BorderLayout;

import javax.swing.*;

public class Gamepanel  {
    static Screen screen = new Screen();
    static JFrame frame;
    static Inventory inventory;
    static Ticksystem ticksystem;
    public static void Startgame() {
        frame.remove(inventory);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        screen = new Screen();
        frame.add(screen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Sun.sun = new Sun(0, 0);
        Zombie zombie=new Zombie(10*60, 3*60);
        Spawner.spawn_Zombie(zombie);
        ticksystem.start=true;
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
        ticksystem=new Ticksystem();
        ticksystem.Startgame();
    }
    public static void up(){
        screen.screenrefresh();
        inventory.screenrefresh();
    }
}

