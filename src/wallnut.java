public class Wallnut extends Plant {

    public Wallnut(int X, int Y) {
        super(X, Y);
        name="Wallnut";
        cost=50;
        Health =1000;
        attack_speed=0;
        attack_damage=0;
        range=0;
        cooldown=20;
        picture="res\\Plants\\Wallnut.png";
    }

    public void shoot(){

    }

    
    @Override
    public void actionPerformed() {
    }
    public void spawn_Plant(boolean lily){
        Wallnut wallnut=new Wallnut(X, Y);
        if(lily){
            wallnut.setHealth(Health+100);
        }
        Screen.plants.add(wallnut);
    }
}
