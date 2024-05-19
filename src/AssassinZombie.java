import java.util.Random;

public class AssassinZombie extends Zombie {

    Random random=new Random();
    int timerY=0;

    protected AssassinZombie(int X, int Y) {
        super(X, Y);
        name = "AssassinZombie";
        Health = 125;
        attack_damage=100;
        attack_speed=2;
        is_aquatic=true;
        picture="res/Zombies/AssassinZombie.jpeg";
    }

    @Override
    public void actionPerformed() {
        if(moving){
            if(is_slowed){
                if (timer > 10){
                    X-=1; 
                    Plant_In_Range();
                    timer = 0;
                    if (timerY>300){
                        Y = random.nextInt(1,7) *Screen.tilesize;
                        timerY = 0;
                    }
                }
            }
            else{
            if(timer>5){
                X-=1;
                Plant_In_Range();
                timer=0;
                if (timerY>360){
                    Y = random.nextInt(1,7) *Screen.tilesize;
                    timerY = 0;
                }
            }
            }
        }else{
            if(timer>60){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }
        }
        timer++;
        timerY++;

    }
    public int getTimerY() {
        return timerY;
    }
    public void setTimerY(int timerY) {
        this.timerY = timerY;
    }
}