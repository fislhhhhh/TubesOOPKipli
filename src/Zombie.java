import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Zombie extends Square implements CustomListener {
    protected String name = "Zombie";
    protected int Health =125;
    protected int attack_damage=100;
    protected int attack_speed=1;
    protected boolean is_aquatic=false;
    protected boolean moving=true;
    protected boolean plant_in_range=false;
    protected int timer=0;
    protected boolean dead=false;
    protected Plant target=null;
    protected String picture="res\\Zombies\\Zombie.png";
    protected Boolean is_slowed=false;
    protected int slowtime=0;
    public void Attack(Plant plant){
        plant.damage(attack_damage);
    }
    public void Start_moving(){
        moving=true;
    }
    public void Stop_moving(){
        moving=false;
    }

    public void Plant_In_Range(){
        Start_moving();
        for (Plant plant : Screen.plants) {
            if(plant!=null){
                if(check_Range(plant)){
                    Stop_moving();
                target=plant;
                timer=90;
                }
            }
        }
    }

    public boolean check_Range(Shapes shape){
        if(shape!=null){
            if(Y==shape.Y){
                if(X-1*Screen.tilesize<shape.getX()&&X+30>shape.getX()){
                    return true;
                }else
                {
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    public void damage(int amount){
        Health=Health-amount;
        System.out.println(Health);
        if(Health<=0){
            dead=true;
        }
    }

    protected Zombie(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }

    public void Draw(Graphics2D g2) {
        Image Png=null;
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
    }

    @Override
    public void actionPerformed() {
        if(moving){
            if(is_slowed&&slowtime<180){
                if (timer >= 15){
                    X-=1;
                    timer = 0;
                    Plant_In_Range();
                }
            }
            else{
            if(timer>=10){
                X-=1;
                timer=0;
                Plant_In_Range();
            }
            }
        }else{
            if(timer>=90&&is_slowed&&slowtime<180){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }else if(timer>=60){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }
        }
        timer++;
        slowtime++;
        if(X<= 30){
            System.out.println("lose");
            Gamepanel.losescene();
        }
    }
    public boolean getDead(){
        return dead;
    }
    public void setdead(boolean dead){
        this.dead=dead;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return Health;
    }
    public int getTimer() {
        return timer;
    }
    public boolean getMoving(){
        return moving;
    }
    public boolean getSlowed(){
        return is_slowed;
    }
    public int getSlowtime() {
        return slowtime;
    }
    public void setHealth(int health) {
        Health = health;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    public void setIs_slowed(Boolean is_slowed) {
        this.is_slowed = is_slowed;
    }
    public void setSlowtime(int slowtime) {
        this.slowtime = slowtime;
    }
     
}