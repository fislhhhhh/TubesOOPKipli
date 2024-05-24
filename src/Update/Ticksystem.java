package Update;
import java.util.Iterator;
import java.util.Random;

import Panel.Gamepanel;
import Panel.Inventory;
import Panel.Screen;
import Plant.Bullet;
import Plant.Plant;
import Rest.Inventorybag;
import Rest.Sun;
import Spawner.Spawner;
import Zombie.AssassinZombie;
import Zombie.BucketheadZombie;
import Zombie.ConeheadZombie;
import Zombie.DiggerZombie;
import Zombie.DolphinRiderZombie;
import Zombie.DuckyTubeZombie;
import Zombie.PoleVaultingZombie;
import Zombie.RaZombie;
import Zombie.ScreenDoorZombie;
import Zombie.Zombie;
public class Ticksystem implements Runnable {
    Thread gamThread;
    int fps=60;
    int i=0;
    int timer=0;
    private int time=0;
    private int spawntime=0;
    private boolean Running=true;
    private boolean start=false;
    private CustomListener listener;
    Random random =new Random();
    public void setCustomListener(CustomListener listener) {
        this.listener = listener;
    }
    public void doSomething() {
        // Trigger the listener's actionPerformed method
        if (listener != null) {
            listener.actionPerformed();
        }
    }
    public void Startgame(){
        gamThread = new Thread(this);
        gamThread.start();
    }
    public void setTime(int amount){
        time=amount;
    }
    public int getSpawntime() {
        return spawntime;
    }
    public void setSpawntime(int spawntime) {
        this.spawntime = spawntime;
    }
    @Override
    public void run() {
        double interval = 1000000000/fps;
        double delta =0;
        long lastTime=System.nanoTime();
        Long currettime;
        while (Running) {
            currettime=System.nanoTime();
            delta += (currettime-lastTime)/interval;
            lastTime=currettime;
            if(delta>=1){
                Update();
                delta--;
            }
            
        }
    }
    public void setRunning(boolean run){
        Running=run;
    }
    public boolean getRunning(){
        return Running;
    }
    public int getTime(){
        return time;
    }
    public void start(boolean run){
        start=run;
    }
    public void Update(){
        Gamepanel.up();
        Iterator<Bullet> bulletIterator = Screen.bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            this.setCustomListener(bullet);
            this.doSomething();
            if (bullet.getHit()) {
                bulletIterator.remove(); // Remove the bullet from the list
            }
        }
        Iterator<Zombie> zombieIterator = Screen.zombies.iterator();
        while (zombieIterator.hasNext()) {
            Zombie zombie = zombieIterator.next();
            this.setCustomListener(zombie);
            this.doSomething();
            if (zombie.getDead()) {
                System.out.println(zombie.getName());
                zombieIterator.remove(); // Remove the Zombie from the list
            }
        }
        Iterator<Plant> plantIterator = Screen.plants.iterator();
        while (plantIterator.hasNext()) {
            Plant plant = plantIterator.next();
            this.setCustomListener(plant);
            this.doSomething();
            if (plant.getDead()) {
                plantIterator.remove(); // Remove the Plant from the list
            }
        }
        Iterator<Inventorybag> invIterator = Inventory.decks.iterator();
        while (invIterator.hasNext()) {
            Inventorybag bag = invIterator.next();
            this.setCustomListener(bag);
            this.doSomething();
        }
        if(timer>60&&time<=200&&start){
            time++;
            spawntime++;
            if(time>=20&&time<=160 ){
                if(time==50||time==150){
                    for (int i = 0; i < 5; i++) {
                        spawnZombie();
                        System.out.println("flag");
                    }
                }else if((Screen.zombies.size()<10)&&spawntime>=3){
                    int d=random.nextInt(1,11);
                    if(d==3||d==7||d==10){
                        spawnZombie();
                    }
                    spawntime=0;
                }

            }
            timer=0;
        }else{
            timer++;
        }
        if(!Screen.day&&time<100){
            Screen.day=true;
        }
        if(time>100){
            Screen.day=false;
        }
        if(time>=200&&Screen.zombies.isEmpty()){
            System.out.println("gameover");
            Gamepanel.winscene();
        }
        if(start){
            this.setCustomListener(Sun.sun);
            this.doSomething();
        }
    }

    private void spawnZombie(){
        int y;
        y =random.nextInt(1,7);
                    if((y==3)||(y==4)){
                        int x =random.nextInt(1,4);
                        switch (x) {
                            case 1:
                            Zombie zombie = new DuckyTubeZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 2:
                            zombie = new DolphinRiderZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 3:
                            zombie = new AssassinZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                        
                        }

                    }else{
                        int x =random.nextInt(1,13);
                        switch (x) {
                            case 1:
                            Zombie zombie = new Zombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 2:
                            zombie = new BucketheadZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 3:
                            zombie = new ConeheadZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 4:
                            zombie = new ScreenDoorZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 5:
                            zombie = new PoleVaultingZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 6:
                            zombie = new RaZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 7:
                            zombie = new Zombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 8:
                            zombie = new DiggerZombie(7*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break; 
                            case 9:
                            zombie = new Zombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 10:
                            zombie = new Zombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 11:
                            zombie = new Zombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 12:
                            zombie = new Zombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;

                        }

                    }
    }
    
}
