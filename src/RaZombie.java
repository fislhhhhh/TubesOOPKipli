public class RaZombie extends Zombie {
    int contain_sun = 0;
    int  time =0;
    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health);
        if(Health<=0){
            Sun.totalsun += contain_sun;
            dead=true;
        }
    }

    protected RaZombie(int X, int Y) {
        super(X, Y);
        name = "RaZombie";
        Health = 100;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=false;
        picture="res\\Zombies\\Razombie.png";
    }

    @Override
    public void actionPerformed() {
        if(moving){
            if(is_slowed){
                if (timer >= 15){
                    X-=1;
                    timer = 0;
                    Plant_In_Range();
                }
            }
            else{
            if(timer>=10){
                X-=1;
                timer=0;
                Plant_In_Range();
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
        if (time >= 600){
            steal_sun();
        }
        timer++;
        time++;
        if(X== 30){
            System.out.println("lose");
        }
    }

    public void steal_sun(){
        if (!dead){
            if(Sun.totalsun >= 25){
                Sun.totalsun -= 25;
                contain_sun += 25;
                time = 0;
            }
        }
    }
    public int getContain_sun() {
        return contain_sun;
    }
    public int getTime() {
        return time;
    }
    public void setContain_sun(int contain_sun) {
        this.contain_sun = contain_sun;
    }
    public void setTime(int time) {
        this.time = time;
    }
    
}
