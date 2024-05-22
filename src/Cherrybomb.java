public class Cherrybomb extends Plant  {

    protected Cherrybomb(int X, int Y) {
        super(X, Y);
        name="Cherrybomb";
        cost=75;
        Health =100;
        attack_speed=2;
        attack_damage=5000;
        range=1;
        cooldown=20;
        picture="res\\Plants\\Cherry.png";
    }

    public void shoot(){
        for (Zombie zombie : Screen.zombies) {
            if ((zombie.getY() >= Y-90&&zombie.getY() <= Y+90)&&(zombie.getX() >= X-90&&zombie.getX() <= X+90)) {  // Check if the zombie is in the same lane

                zombie.setdead(true);  // Optionally set zombies as dead if damage is fatal
            }
        }
        afterkill();
    }

    public void damage(int amount){

    }

    public void afterkill(){
        this.Health = 0;
        dead = true;
     }

    public boolean check_Range(Shapes shape){
        switch (range) {
            case -1:
            if(shape!=null){
                if(Y==shape.getY()){
                    System.out.println("case -1");
                    return true;
                }
            }
            break;

            case 0:
            System.out.println("case 0");
            return true;

            default:
            if(shape!=null){
                if(X<shape.getX()&&X+1*Screen.tilesize>shape.getX()){
                    return true;
                }
            }
            return false;
        }
        return false;
        
    }
    @Override
    public void actionPerformed() {
        shoot();
    }
    public void spawn_Plant(boolean lily){
        Cherrybomb cherrybomb=new Cherrybomb(X, Y);
        if(lily){
            cherrybomb.setHealth(Health+100);
        }
        Screen.plants.add(cherrybomb);
    }
}
