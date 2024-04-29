public class Ticksystem implements Runnable {
    Thread gamThread;
    int fps=60;
    int i=0;
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
                for (Bullet bullet : Screen.bullets) {
                    this.setCustomListener(bullet);
                    this.doSomething();
                }
                for (Zombie zombie : Screen.zombies) {
                    this.setCustomListener(zombie);
                    this.doSomething();
                }
                this.setCustomListener(Gamepanel.peashooter);
                this.doSomething();
                delta--;
            }
            
        }
    }

    public void Update(){
        Gamepanel.up();
    }
    
}
