public class DolphinRiderZombie extends Zombie {
    boolean is_jump = false;

    public void Attack(Plant plant){
        if(!is_jump){
            is_jump = true;
            plant.damage(100000);
            X = X-120;
        }else{
            plant.damage(attack_damage);

        }
    }


    protected DolphinRiderZombie(int X, int Y) {
        super(X, Y);
        name = "DolphinRiderZombie";
        Health =175;
        attack_damage=100;
        attack_speed=1;
        is_aquatic=true;
        picture="res/Zombies/dolphinezombie.jpg";
    }
    public boolean getis_jump(){
        return is_jump;
    }
    public void setIs_jump(boolean is_jump) {
        this.is_jump = is_jump;
    }
}
