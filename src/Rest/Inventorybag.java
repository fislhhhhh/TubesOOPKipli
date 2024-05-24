package Rest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panel.Screen;
import Plant.Plant;
import Update.CustomListener;

public class Inventorybag extends Square implements CustomListener {
    public Plant plant;
    private BufferedImage Png;
    public Boolean picked = false;
    int X2=0;
    int Y2=0;
    int timer=0;
    private boolean on_cooldown=false;
    public Inventorybag(int X, int Y,Plant plant) {
        super(X*Screen.tilesize, Y*Screen.tilesize);
        this.plant=plant;
    }
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(plant.getPicture()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!on_cooldown){
            if(picked){
                g2.drawImage(Png,X2,Y2,1*Screen.tilesize,1*Screen.tilesize,null);
            }else{
                g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
            }
        }else{
            try {
                Png = ImageIO.read(new File("res\\plantstorage.png"));//gambar cooldown
            } catch (IOException e) {
                e.printStackTrace();
            }
            g2.drawImage(Png,X2,Y2,1*Screen.tilesize,1*Screen.tilesize,null);
        }
        
    }
    @Override
    public void actionPerformed() {
        if(on_cooldown){
            if(timer>plant.getCooldown()*60){
                on_cooldown=false;
                timer=0;
            }else{
                timer++;
            }
        }
    }
    public void setOn_Cooldown(boolean on_cooldown){
        this.on_cooldown=on_cooldown; 
    }
    public boolean getOn_Cooldown(){
        return on_cooldown;
    }
    public int gettimer() {
        return timer;
    }
    public String getPlaString(){
        return plant.getName();
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }
    public void setPicked(Boolean picked) {
        this.picked = picked;
    }
    public Plant getPlant() {
        return plant;
    }
    public int getX2() {
        return X2;
    }
    public void setX2(int x2) {
        X2 = x2;
    }
    public int getY2() {
        return Y2;
    }
    public void setY2(int y2) {
        Y2 = y2;
    }
}

