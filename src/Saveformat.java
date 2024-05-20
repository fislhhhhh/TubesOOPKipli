import java.util.ArrayList;

public class Saveformat {
    private ArrayList<Plant> s_plant;
    private ArrayList<Zombie> s_zombie;
    private ArrayList<Bullet> s_bullet;
    private ArrayList<Inventorybag> s_decks=new ArrayList<>();
    static Saveformat instance;
    
    public int s_sun;
    public int s_ticktime;
    public int s_tickspawn;

    public ArrayList<String>dStrings=new ArrayList<>();
    public ArrayList<Integer>dtimer=new ArrayList<>();
    public ArrayList<Boolean>dcooldown=new ArrayList<>();
    public int jumlahdeck =6;

    public ArrayList<String>bname=new ArrayList<>();
    public ArrayList<Integer>bx=new ArrayList<>();
    public ArrayList<Integer>by=new ArrayList<>();
    public ArrayList<Integer>bdamage=new ArrayList<>();

    public ArrayList<String>pname=new ArrayList<>();
    public ArrayList<Integer>px=new ArrayList<>();
    public ArrayList<Integer>py=new ArrayList<>();
    public ArrayList<Integer>phealth=new ArrayList<>();
    public ArrayList<Integer>ptimer=new ArrayList<>();

    public ArrayList<Boolean>pfp=new ArrayList<>();
    public ArrayList<Integer>lptimer=new ArrayList<>();
    public ArrayList<Integer>lpdamage=new ArrayList<>();
    
    public ArrayList<String>zname=new ArrayList<>();
    public ArrayList<Integer>zx=new ArrayList<>();
    public ArrayList<Integer>zy=new ArrayList<>();
    public ArrayList<Integer>zhealth=new ArrayList<>();
    public ArrayList<Integer>ztimer=new ArrayList<>();
    public ArrayList<Boolean>zmoving=new ArrayList<>();
    public ArrayList<Boolean>zslowed=new ArrayList<>();
    public ArrayList<Integer>zslowtime=new ArrayList<>();

    public ArrayList<Integer>rzsun=new ArrayList<>();
    public ArrayList<Integer>rztime=new ArrayList<>();

    public ArrayList<Integer>aztime=new ArrayList<>();
    public ArrayList<Boolean>zjump=new ArrayList<>();    

    public void setSave(int s_sun,ArrayList<Plant> s_plant, ArrayList<Zombie> s_zombie,ArrayList<Bullet> s_bullet,int s_ticktime,ArrayList<Inventorybag> s_decks,int s_tickspawn){
        this.s_sun=s_sun;
        this.s_plant=s_plant;
        this.s_zombie=s_zombie;
        this.s_ticktime=s_ticktime;
        this.s_decks=s_decks;
        this.s_bullet=s_bullet;
        this.s_tickspawn=s_tickspawn;
        formatData();
    }
    public void formatData(){
        for (Inventorybag inventorybag : s_decks) {
            dStrings.add(inventorybag.getPlaString());
            dtimer.add(inventorybag.gettimer());
            dcooldown.add(inventorybag.getOn_Cooldown());
        }
        for(Bullet bullet : s_bullet){
            bname.add(bullet.getName());
            bx.add(bullet.getX());
            by.add(bullet.getY());
            bdamage.add(bullet.getDamage());
        }
        for(Plant plant : s_plant){
            if(plant instanceof Littlepea){
                Littlepea littlepea=(Littlepea)plant;
                lptimer.add(littlepea.getMembersar());
                lpdamage.add(littlepea.getAttack_damage());
                pfp.add(littlepea.getFirstshoot());
            }else if(plant instanceof Peashooter){
                Peashooter peashooter=(Peashooter)plant;
                pfp.add(peashooter.getFirstshoot());
                plant=peashooter;
            }else if(plant instanceof Snowpea){
                Snowpea snowpea=(Snowpea)plant;
                pfp.add(snowpea.getFirstshoot());
                plant=snowpea;
            }
            pname.add(plant.getName());
            px.add(plant.getX());
            py.add(plant.getY());
            phealth.add(plant.getHealth());
            ptimer.add(plant.getTime());
        }
        for(Zombie zombie:s_zombie){
            if(zombie instanceof RaZombie){
                RaZombie raZombie=(RaZombie)zombie;
                rzsun.add(raZombie.getContain_sun());
                rztime.add(raZombie.getTime());
            }else if (zombie instanceof AssassinZombie) {
                AssassinZombie assassinZombie=(AssassinZombie)zombie;
                aztime.add(assassinZombie.getTimerY());
            }else if(zombie instanceof DolphinRiderZombie){
                DolphinRiderZombie dolphinRiderZombie =(DolphinRiderZombie)zombie;
                zjump.add(dolphinRiderZombie.getis_jump());

            }else if(zombie instanceof PoleVaultingZombie){
                PoleVaultingZombie poleVaultingZombie =(PoleVaultingZombie)zombie;
                zjump.add(poleVaultingZombie.getis_jump());
            }
            zname.add(zombie.getName());
            zx.add(zombie.getX());
            zy.add(zombie.getY());
            zhealth.add(zombie.getHealth());
            ztimer.add(zombie.getTimer());
            zmoving.add(zombie.getMoving());
            zslowed.add(zombie.getSlowed());
            zslowtime.add(zombie.slowtime);
        }

    }
}
