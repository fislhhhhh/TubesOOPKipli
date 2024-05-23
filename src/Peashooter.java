public class Peashooter extends Plant  {
    private boolean firstshoot=true;

    protected Peashooter(int X, int Y) {
        super(X, Y);
        name="Peashooter";
        cost=100;
        Health =100;
        attack_speed=4;
        attack_damage=25;
        range=-1;
        cooldown=10;
        picture="res\\Plants\\Peashooter.png";
    }

    @Override
    public void actionPerformed() {
        boolean shootable=true;
        if(firstshoot){
            for (Zombie zombie : Screen.zombies) {
                if(check_Range(zombie)&&shootable){
                    shoot();
                    shootable=false;
                    System.out.println("test");
                }
            }
            firstshoot=false;
            time=0 ;
        }else if(time>60*attack_speed){
            Zombie temp=null;
            for (Zombie zombie : Screen.zombies) {
                if(check_Range(zombie)&&shootable){
                    shoot();
                    shootable=false;
                    temp=zombie;
                    System.out.println("test2");
                }
            }
            if(temp==null){
                firstshoot=true;
            }
            time=0 ;
        }else{
            time++;
        }
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

    public void spawn_Plant(boolean lily){
        Peashooter peashooter=new Peashooter(X, Y);
        if(lily){
            peashooter.setHealth(Health+100);
        }
        Screen.plants.add(peashooter);
    }
    public boolean getFirstshoot(){
        return firstshoot;
    }
    public void setFirstshoot(boolean firstshoot) {
        this.firstshoot = firstshoot;
    }
}
