import java.util.Iterator;
import java.util.Random;
public class Ticksystem implements Runnable {
    Thread gamThread;
    int fps=60;
    int i=0;
    int timer=0;
    int time=0;
    boolean start=false;
    private CustomListener listener;

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
    @Override
    public void run() {
        double interval = 1000000000/fps;
        double delta =0;
        long lastTime=System.nanoTime();
        Long currettime;
        while (gamThread!=null) {
            currettime=System.nanoTime();
            delta += (currettime-lastTime)/interval;
            lastTime=currettime;
            if(delta>=1){
                Update();
                delta--;
            }
            
        }
    }

    public void Update(){
        Gamepanel.up();
        Iterator<Bullet> bulletIterator = Screen.bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            this.setCustomListener(bullet);
            this.doSomething();
            if (bullet.hit) {
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
        if(timer>60&&time<=200&&start){
            time++;
            if(time>=20&&time<=160 && Screen.zombies.size()<10){
                Random random =new Random();
                int y=random.nextInt(1,11);
                if(y==3||y==7||y==10){
                    y =random.nextInt(1,7);
                    if((y==3)||(y==4)){
                        int x =random.nextInt(1,3);
                        switch (x) {
                            case 1:
                            Zombie zombie = new DuckyTubeZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                            case 2:
                            zombie = new DolphinRiderZombie(10*Screen.tilesize, y*Screen.tilesize);
                            Spawner.spawn_Zombie(zombie);
                                break;
                        
                        }

                    }else{
                        int x =random.nextInt(1,7);
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

                        }

                    }

                }

            }
            timer=0;
        }else{
            timer++;
        }
        if(time>100){
            Screen.day=false;
        }
        if(time>=200&&Screen.zombies.isEmpty()){
            System.out.println("gameover");
        }
        this.setCustomListener(Sun.sun);
        this.doSomething();
    }
    
}
