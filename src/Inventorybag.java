import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Inventorybag extends Square implements CustomListener {
    Plant plant;//3
    private BufferedImage Png;
    Boolean picked = false;//selalu true
    int X2=0;
    int Y2=0;
    int timer=0;//1
    private boolean on_cooldown=false;//2
    protected Inventorybag(int X, int Y,Plant plant) {
        super(X*Screen.tilesize, Y*Screen.tilesize);
        this.plant=plant;
        //TODO Auto-generated constructor stub
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
                Png = ImageIO.read(new File("res/Deck.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g2.drawImage(Png,X2,Y2,1*Screen.tilesize,1*Screen.tilesize,null);
        }
        
    }
    @Override
    public void actionPerformed() {
        if(on_cooldown){
            if(timer>plant.cooldown*60){
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

}

