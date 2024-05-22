
public class Lilypad extends Plant  {

    protected Lilypad(int X, int Y) {
        super(X, Y);
        name="Lilypad";
        cost=25;
        Health =100;
        attack_speed=0;
        attack_damage=0;
        range=0;
        cooldown=10;
        picture="res\\Plants\\Lilypad.png";
    }

    public void shoot(){
        Bullet bullet = new Bullet(X, Y,attack_damage);
        Projectile.Project_in(bullet);
    }

    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health+" plant health" );
        if(Health<=0){
            dead=true;
        }
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

    }
    public void spawn_Plant(boolean lily){
        Lilypad lilypad=new Lilypad(X, Y);
        Screen.plants.add(lilypad);
    }
}
