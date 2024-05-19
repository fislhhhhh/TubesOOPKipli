import javax.swing.*;

public class Gamepanel  {
    static Screen screen = new Screen();
    static JFrame frame;
    static Inventory inventory = new Inventory();
    static Mainmenu mainmenu = new Mainmenu();
    static Ticksystem ticksystem;
    static Almanachoose almanachoose;
    public static void Startgame() {
        frame.remove(inventory);
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
    public static void saveGame(){

    }
    public static void loadGame(){
        frame.remove(mainmenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(screen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        if(!ticksystem.getRunning()){
            ticksystem.Startgame();
            ticksystem.setRunning(true);
            inventory.filledInventory();
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
        Sun.sun.setSun(0);
        Screen.plants.clear();
        Screen.zombies.clear();
        Screen.bullets.clear();
        ticksystem.setTime(0);
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
    public static void almanaChoose(){
        frame.remove(mainmenu);
        frame.setTitle("Almanac");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        almanachoose = new Almanachoose();
        frame.add(almanachoose);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void mainMenubalik(){
        frame.remove(almanachoose);
        frame.setTitle("Main Menu");
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
    public static void up(){
        screen.screenrefresh();
        inventory.screenrefresh();
    }
}

