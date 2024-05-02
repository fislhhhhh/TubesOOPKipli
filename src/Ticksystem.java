import java.util.Iterator;
import java.util.Random;
public class Ticksystem implements Runnable {
    Thread gamThread;
    int fps=60;
    int i=0;
    int timer=0;
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
            if (zombie.dead) {
                zombieIterator.remove(); // Remove the bullet from the list
            }
        }
        Iterator<Plant> plantIterator = Screen.plants.iterator();
        while (plantIterator.hasNext()) {
            Plant plant = plantIterator.next();
            this.setCustomListener(plant);
            this.doSomething();
            if (plant.dead) {
                plantIterator.remove(); // Remove the bullet from the list
            }
        }
        if(timer>60){
            Random random =new Random();
            int y=random.nextInt(1,11);
            if(y==3||y==5||y==7){
                y =random.nextInt(1,7);
                Zombie zombie = new Zombie(10*Screen.tilesize, y*Screen.tilesize);
                Spawner.spawn_Zombie(zombie);
            }
            timer=0;
        }else{
            timer++;
        }
    }
    
}
