package Save;
import com.google.gson.Gson;

import Panel.Gamepanel;
import Panel.Inventory;
import Panel.Screen;
import Plant.Bullet;
import Plant.Cherrybomb;
import Plant.Doompea;
import Plant.Jalapeno;
import Plant.Lilypad;
import Plant.Littlepea;
import Plant.Peashooter;
import Plant.Plant;
import Plant.Slowbullet;
import Plant.Snowpea;
import Plant.Squash;
import Plant.Sunflower;
import Plant.Wallnut;
import Rest.Inventorybag;
import Rest.Sun;
import Zombie.AssassinZombie;
import Zombie.BucketheadZombie;
import Zombie.ConeheadZombie;
import Zombie.DiggerZombie;
import Zombie.DolphinRiderZombie;
import Zombie.DuckyTubeZombie;
import Zombie.PoleVaultingZombie;
import Zombie.RaZombie;
import Zombie.ScreenDoorZombie;
import Zombie.Zombie;

import java.io.FileReader;
import java.io.IOException;

public class Loadgame {
    public static void loading(){
                Gson gson = new Gson();
                int a=0;
                int b=0;
                int c=0;
                int d=0;
                int e=0;
                int f=0;
                int g=0;
                try (FileReader reader = new FileReader("Save/SaveFIle.json")) {
                    Savefile savefile = gson.fromJson(reader, Savefile.class);
                    System.out.println("Data has been loaded from gameData.json");
                    Sun.sun.setSun(savefile.s_sun);
                    Gamepanel.ticksystem.setTime(savefile.s_ticktime);
                    Gamepanel.ticksystem.setSpawntime(savefile.s_tickspawn);
                    for (int i = 0; i < savefile.jumlahdeck; i++) {
                        Plant plant=null;
                        switch (savefile.dStrings.get(i)) {
                            case "Cherrybomb":
                                plant=new Cherrybomb(i, i);
                                break;
                            case "Doompea":
                                plant=new Doompea(i, i);
                                break;
                            case "Wallnut":
                                plant=new Wallnut(i, i);
                                break;
                            case "Sunflower":
                                plant= new Sunflower(i, i);
                                break;
                            case "Squash":
                                plant= new Squash(i, i);
                                break;
                            case "Snowpea":
                                plant= new Snowpea(i, i);
                                break;
                            case "Peashooter":
                                plant= new Peashooter(i, i);
                                break;
                            case "Littlepea":
                                plant= new Littlepea(i, i);
                                break;
                            case "Lilypad":
                                plant= new Lilypad(i, i);
                                break;
                            case "Jalapeno":
                                plant= new Jalapeno(i, i);
                                break;

                        }
                        Inventorybag inventorybag=new Inventorybag(0, 0, plant);
                        inventorybag.setTimer(savefile.dtimer.get(i));
                        inventorybag.setOn_Cooldown(savefile.dcooldown.get(i));
                        inventorybag.setPicked(true);
                        Inventory.decks.add(inventorybag);
                    }
                    for (int i = 0; i < savefile.pname.size(); i++) {
                        Plant plant=null;
                            switch (savefile.pname.get(i)) {
                                case "Cherrybomb":
                                    plant=new Cherrybomb(savefile.px.get(i), savefile.py.get(i));
                                    break;
                                case "Littlepea":
                                Littlepea lplant=new Littlepea(savefile.px.get(i), savefile.py.get(i));
                                lplant.setAttack_damage(savefile.lpdamage.get(a));
                                lplant.setMembersar(savefile.lpdamage.get(b));
                                lplant.setFirstshoot(savefile.pfp.get(c));
                                a++;
                                b++;
                                c++; 
                                plant=lplant;
                                    break;
                                case "Peashooter":
                                Peashooter peashooter=new Peashooter(savefile.px.get(i), savefile.py.get(i));
                                peashooter.setFirstshoot(savefile.pfp.get(c));
                                c++;
                                plant=peashooter;
                                    break;
                                case "Snowpea":
                                Snowpea snowpea = new Snowpea(savefile.px.get(i), savefile.py.get(i));
                                snowpea.setFirstshoot(savefile.pfp.get(c));
                                c++;
                                plant=snowpea;
                                    break;
                                case "Doompea":
                                    plant=new Doompea(savefile.px.get(i), savefile.py.get(i));
                                    break;
                                case "Wallnut":
                                    plant=new Wallnut(savefile.px.get(i), savefile.py.get(i));
                                    break;
                                case "Sunflower":
                                    plant= new Sunflower(savefile.px.get(i), savefile.py.get(i));
                                    break;
                                case "Squash":
                                    plant= new Squash(savefile.px.get(i), savefile.py.get(i));
                                    break;

                                case "Lilypad":
                                    plant= new Lilypad(savefile.px.get(i), savefile.py.get(i));
                                    break;
                                case "Jalapeno":
                                    plant= new Jalapeno(savefile.px.get(i), savefile.py.get(i));
                                    break;
                            
                        }
                        plant.setHealth(savefile.phealth.get(i));
                        plant.setTime(savefile.ptimer.get(i));
                        Screen.plants.add(plant);
                    }
                    for (int i = 0; i < savefile.bname.size(); i++) {
                        Bullet bullet = null;
                        switch (savefile.bname.get(i)) {
                            case "Bullet":
                                bullet=new Bullet(savefile.bx.get(i),savefile.by.get(i),savefile.bdamage.get(i));
                                break;
                            case "SlowBullet":
                                bullet=new Slowbullet(savefile.bx.get(i),savefile.by.get(i),savefile.bdamage.get(i));
                                break;
                        }
                        Screen.bullets.add(bullet);
                    }
                    for (int i = 0; i < savefile.zname.size(); i++) {
                        Zombie zombie=new Zombie(i, i);
                            switch (savefile.zname.get(i)) {
                                case "BucketheadZombie":
                                    zombie=new BucketheadZombie(savefile.zx.get(i), savefile.zy.get(i));
                                    break;
                                case "RaZombie":
                                RaZombie raZombie=new RaZombie(savefile.zx.get(i), savefile.zy.get(i));
                                raZombie.setContain_sun(savefile.rzsun.get(d));
                                raZombie.setTime(savefile.rztime.get(e));
                                d++;
                                e++;
                                zombie=raZombie;
                                    break;
                                case "AssassinZombie":
                                AssassinZombie assassinZombie= new AssassinZombie(savefile.zx.get(i), savefile.zy.get(i));
                                assassinZombie.setTimerY(savefile.aztime.get(f));
                                f++;
                                zombie=assassinZombie;
                                    break;
                                case "DolphinRiderZombie":
                                DolphinRiderZombie dolphinRiderZombie = new DolphinRiderZombie(savefile.zx.get(i), savefile.zy.get(i));
                                dolphinRiderZombie.setIs_jump(savefile.zjump.get(g));
                                g++;
                                zombie= dolphinRiderZombie;
                                    break;
                                case "PoleVaultingZombie":
                                PoleVaultingZombie poleVaultingZombie = new PoleVaultingZombie(savefile.zx.get(i), savefile.zy.get(i));
                                poleVaultingZombie.setIs_jump(savefile.zjump.get(g));
                                g++;
                                zombie=poleVaultingZombie;
                                    break;
                                case "ConeheadZombie":
                                    zombie=new ConeheadZombie(savefile.zx.get(i), savefile.zy.get(i));
                                    break;
                                case "DiggerZombie":
                                    zombie=new DiggerZombie(savefile.zx.get(i), savefile.zy.get(i));
                                    break;
                                case "DuckyTubeZombie":
                                    zombie=new DuckyTubeZombie(savefile.zx.get(i), savefile.zy.get(i));
                                    break;
                                case "ScreenDoorZombie":
                                    zombie=new ScreenDoorZombie(savefile.zx.get(i), savefile.zy.get(i));
                                    break;
                                case "Zombie":
                                    zombie=new Zombie(savefile.zx.get(i), savefile.zy.get(i));
                                    break;
                        
    
                        }
                        zombie.setHealth(savefile.zhealth.get(i));
                        zombie.setTimer(savefile.ztimer.get(i));
                        zombie.setMoving(savefile.zmoving.get(i));
                        zombie.setIs_slowed(savefile.zslowed.get(i));
                        zombie.setSlowtime(savefile.zslowtime.get(i));
                        Screen.zombies.add(zombie);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
}

