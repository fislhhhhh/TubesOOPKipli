import javax.swing.*;

public class Gamepanel  {
    static Screen screen = new Screen();
    static JFrame frame;
    static Inventory inventory = new Inventory();
    static Mainmenu mainmenu = new Mainmenu();
    static Ticksystem ticksystem;
    static Almanachoose almanachoose= new Almanachoose();
    static Plantalmanac plantalmanac= new Plantalmanac();
    static Zombiealmanac zombiealmanac = new Zombiealmanac();
    static Help help = new Help();
    public static void Startgame() {
        frame.remove(inventory);
        inventory.setPlantdata(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(screen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ticksystem.start(true);
    }
    public static void inventoryScene(){
        frame.remove(mainmenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(inventory);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        if(!ticksystem.getRunning()){
            ticksystem.Startgame();
            ticksystem.setRunning(true);
            inventory.filledInventory();
        }
    }
    public static void loadGame(){
        frame.remove(mainmenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(screen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        ticksystem.setRunning(false);
        frame.setVisible(true);
        if(!ticksystem.getRunning()){
            ticksystem.Startgame();
            ticksystem.setRunning(true);
            inventory.filledInventory();
            System.out.println("test");
            ticksystem.start(true);
        }
        Loadgame.loading();
    }
    public static void mainMenu(){
        frame.remove(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(mainmenu);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ticksystem.setRunning(false);
        ticksystem.start(false);
        Savegame savegame= Savegame.getInstance();
        savegame.saving();
        Sun.sun.setSun(50);
        Screen.plants.clear();
        Screen.zombies.clear();
        Screen.bullets.clear();
        ticksystem.setTime(0);
        ticksystem.setSpawntime(0);
    }
    public static void start(){
        frame =new JFrame();
        frame.setTitle("PVZ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(mainmenu);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ticksystem=new Ticksystem();
        ticksystem.Startgame();
        Sun.sun = new Sun(0, 0);
    }
    public static void help(){
        frame.remove(mainmenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(help);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void almanaChoose(){
        frame.remove(mainmenu);
        frame.remove(plantalmanac);
        frame.remove(zombiealmanac);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(almanachoose);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void plantAlmanac(){
        frame.remove(almanachoose);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(plantalmanac);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void zombieAlmanac(){
        frame.remove(almanachoose);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(zombiealmanac);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void mainMenubalik(){
        frame.remove(almanachoose);
        frame.remove(inventory);
        inventory.setPlantdata(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(mainmenu);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ticksystem.setRunning(false);
    }
    public static void up(){
        screen.screenrefresh();
        inventory.screenrefresh();
    }
}

