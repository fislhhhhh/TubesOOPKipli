public class Littlepea extends Plant  {
    private boolean firstshoot=true;
    private int membersar = 0;
    protected Littlepea(int X, int Y) {
        super(X, Y);
        name="Littlepea";
        cost=25;
        Health =50;
        attack_speed=4;
        attack_damage=10;
        range=-1;
        cooldown=15;
        picture="res/Plants/littlepea.png";
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

    @Override
    public void actionPerformed() {
        boolean shootable=true;
        if(firstshoot){
            for (Zombie zombie : Screen.zombies) {
                if(check_Range(zombie)&&shootable){
                    shoot();
                    membersar++;
                    if (membersar > 15){
                        attack_damage=attack_damage+2; 
                        membersar = 0;
                    }
                    shootable=false;
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
                    membersar++;
                    if (membersar > 15){
                        attack_damage=attack_damage+2; 
                        membersar = 0;
                    }
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
    public void spawn_Plant(boolean lily){
        Littlepea littlepea=new Littlepea(X, Y);
        if(lily){
            littlepea.setHealth(Health+100);
        }
        Screen.plants.add(littlepea);
    }
    public int getMembersar() {
        return membersar;
    }
    public void setMembersar(int membersar) {
        this.membersar = membersar;
    }
    public boolean getFirstshoot(){
        return firstshoot;
    }
    public void setFirstshoot(boolean firstshoot) {
        this.firstshoot = firstshoot;
    }
}
