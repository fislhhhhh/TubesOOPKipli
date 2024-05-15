import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
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
}
