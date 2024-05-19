public class ScreenDoorZombie extends Zombie {
    
    
    protected ScreenDoorZombie(int X, int Y) {
        super(X, Y);
        name = "ScreenDoorZombie";
        Health = 100;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=false;
        picture="res/Zombies/screenzombie.jpg";

    }




    @Override
    public void actionPerformed() {
        if(moving){
            if(timer>5){
                X-=1;
                Plant_In_Range();
                timer=0;
            }
            
        }else{
            if(timer>60){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }
        }
        timer++;
        if(X== 30){
            System.out.println("lose");
        }
    }
    
}
