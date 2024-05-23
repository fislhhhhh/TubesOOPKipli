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
        picture="res\\Zombies\\Assasinzombie.png";
    }

    @Override
    public void actionPerformed() {
        if(moving){
            if(is_slowed){
                if (timer > 20){
                    X-=1; 
                    timer = 0;
                    Plant_In_Range();
                    if (timerY>300){
                        Y = random.nextInt(1,7) *Screen.tilesize;
                        timerY = 0;
                    }
                }
            }
            else{
            if(timer>10){
                X-=1;
                timer=0;
                Plant_In_Range();
                if (timerY>360){
                    Y = random.nextInt(1,7) *Screen.tilesize;
                    timerY = 0;
                }
            }
            }
        }else{
            if(timer>=90&&is_slowed&&slowtime<180){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }else if(timer>=60){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }
        }
        timer++;
        timerY++;
        if(X<= 30){
            System.out.println("lose");
            Gamepanel.losescene();
        }

    }
    public int getTimerY() {
        return timerY;
    }
    public void setTimerY(int timerY) {
        this.timerY = timerY;
    }
}
