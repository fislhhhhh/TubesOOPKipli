package Panel;
import javax.swing.*;

import Plant.Bullet;
import Plant.Plant;
import Rest.Inventorybag;
import Rest.Sun;
import UI.Button;
import UI.Deck;
import UI.House;
import UI.Land;
import UI.Planthighlight;
import UI.Spawn;
import UI.Water;
import Zombie.Zombie;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Iterator;
public class Screen extends JPanel implements MouseListener, MouseMotionListener {
    static final int originaltilesize=20;
    static final int scale =3;
    public static final int tilesize = originaltilesize*scale;
    final int maxrow =8;
    final int maxcol=11;
    final int screenwidth=maxcol*tilesize;
    final int screenheight=maxrow*tilesize;
    int a=0;
    Deck deck=null;
    boolean shovel=false;
    public static boolean day=true;
    public static ArrayList<Bullet> bullets= new ArrayList<>();
    public static ArrayList<Zombie> zombies= new ArrayList<>();
    public static ArrayList<Plant> plants= new ArrayList<>();
    public Screen(){
        this.setPreferredSize(new Dimension(screenwidth,screenheight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        for(int i =1;i<7;i++){
            new House(0*tilesize, i*tilesize).Draw(g2);
            new Spawn(10*tilesize, i*tilesize).Draw(g2);
        }
        new Deck(10, 0,"res\\Inventory\\Brown.png").Draw(g2);;
        for(int i=1 ;i<10;i++){
            new Land(i*tilesize, 1*tilesize).Draw(g2);
            new Land(i*tilesize, 2*tilesize).Draw(g2);
            new Water(i*tilesize, 3*tilesize).Draw(g2);
            new Water(i*tilesize, 4*tilesize).Draw(g2);
            new Land(i*tilesize, 5*tilesize).Draw(g2);
            new Land(i*tilesize, 6*tilesize).Draw(g2);
        }
        for(int i =0;i<8;i++){
            new Deck(i, 0,"res/plantstorage.png").Draw(g2);
        }
        new Button(8*Screen.tilesize,0,120,60,"res/Menu.png").Draw(g2);;
        new Deck(7, 0,"res/shovel.png").Draw(g2);
        for (int i = 0; i < zombies.size(); i++) {
            if (zombies.get(i)!=null) {
                zombies.get(i).Draw(g2);
            }
        }
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i)!=null) {
                plants.get(i).Draw(g2);
            }
        }
        for (int i = 0; i < bullets.size(); i++) {
            if (bullets.get(i)!=null) {
                bullets.get(i).Draw(g2);
            }
        }
        int si=1;
        for (Inventorybag inventorybag : Inventory.decks) {
            if(inventorybag!=null){ 
                inventorybag.setX2(si*60);
                inventorybag.setY2(0);
                inventorybag.Draw(g2);
                si++;
            }
        }
        new Deck(0,0 ,"res\\UI\\Sunui.png").Draw(g2);
        Font font=new Font("Verdana",Font.BOLD,14);
        g2.setFont(font);
        g2.setColor(Color.BLACK);
        String string=Sun.totalsun+"";
        g2.drawString(string, 15, 35);
        new Button(0,420,60,60,"res/UI/finish.png").Draw(g2);
        new Button(60,420,60,60,"res/UI/finish.png").Draw(g2);
        new Button(300,420,60,60,"res\\UI\\Moon.png").Draw(g2);
        new Button(150,420,60,60,"res\\UI\\flag.png").Draw(g2);
        new Button(450,420,60,60,"res\\UI\\flag.png").Draw(g2);
        g2.setColor(Color.RED);
        g2.fillRect(660-(3*Gamepanel.ticksystem.getTime()), 420, 700, 60);
        if(!day){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            g2.setColor(new Color(56, 17, 146));
            g2.fillRect(0, 0, 11*60, 8*60);;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }
        if(deck!=null){
            deck.Draw(g2);
        }
        g2.dispose();
    }
    public void screenrefresh(){
        repaint();
    }
    boolean dragging=false;
    Inventorybag Moveplant;
    int dragOffsetX, dragOffsetY;
    Plant planted;
    Plant toRemove=null;
    @Override

    public void mousePressed(MouseEvent e) {
        int mouseX=e.getX();
        int mouseY=e.getY();
        int x=0;
        int y=0;
        int width = 0;
        int height = 0;
        Iterator<Inventorybag> deckInterator = Inventory.decks.iterator();
        while (deckInterator.hasNext()) {
            Inventorybag inventorybag = deckInterator.next();
            if(inventorybag!=null){
                x=inventorybag.getX2();
                y=inventorybag.getY2();
                width=Screen.tilesize;
                height=Screen.tilesize;
            if (mouseX >= x && mouseX <= (x+width) &&
                mouseY >= y && mouseY <= (y + height)) {
                    if(!inventorybag.getOn_Cooldown()){
                        System.out.println("pick");
                        dragging=true;
                        dragOffsetX = mouseX - inventorybag.getX2();
                        dragOffsetY = mouseY - inventorybag.getY2();
                        inventorybag.picked=false;
                        Moveplant=inventorybag;
                    }
                }
            }
        }

        if (mouseX >= 7*Screen.tilesize && mouseX <= (8*Screen.tilesize) &&
        mouseY >= 0 && mouseY <= Screen.tilesize) {
            System.out.println("test");
            shovel=true;
            dragging=true;
            dragOffsetX = mouseX - (7*Screen.tilesize);
            dragOffsetY = mouseY - (Screen.tilesize);
        }  
        if (mouseX >= 8*Screen.tilesize && mouseX <= (10*Screen.tilesize) &&
        mouseY >= 0 && mouseY <= Screen.tilesize) {
            Gamepanel.mainMenu();
        } 
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        boolean lily=false;
        boolean noLily=false;
        if(Moveplant!=null){
            if(planted!=null){
                if(Moveplant!=null){
                    Iterator<Plant> plantIterator = Screen.plants.iterator();
                    while (plantIterator.hasNext()) {
                        Plant plant = plantIterator.next();
                        if((plant.getName()!="Lilypad")&&!(planted.getY()>2*tilesize&&planted.getY()<5*tilesize)){
                            if(plant.getX()==planted.getX()&&plant.getY()==planted.getY()){
                                Moveplant.picked=true;
                                dragging=false;
                                Moveplant=null;
                                deck=null;
                            }
                        }else if((planted.getY()>2*tilesize&&planted.getY()<5*tilesize)&&(!(plant.getX()==planted.getX()&&plant.getY()==planted.getY()))&&(planted.getName()!="Lilypad")&&(!lily)){
                            System.out.println(planted.getY()/60+"333");
                            noLily=true;
                        }
                        if(plant.getName()=="Lilypad"&&(plant.getX()==planted.getX()&&plant.getY()==planted.getY())){//buat hilangin lilypad
                            lily=true;
                            toRemove=plant;
                        }
                    }
                    System.out.println(noLily+""+lily);
                    if(noLily&&!lily){
                        Moveplant.picked=true;
                        dragging=false;
                        Moveplant=null;
                        deck=null;
                        System.out.println("testjjj");
                    }
                    if((planted.getName()!="Lilypad")&&(planted.getY()>2*tilesize&&planted.getY()<5*tilesize)&&plants.isEmpty()){
                        Moveplant.picked=true;
                        dragging=false;
                        Moveplant=null;
                        deck=null;
                    }
                    if(toRemove!=null){
                        plants.remove(toRemove);
                        toRemove=null;
                    }
                    if(Moveplant!=null){
                        if(Moveplant.plant.getCost()<=Sun.totalsun){
                            if(Moveplant!=null){
                                Moveplant.picked=true;
                                dragging=false;
                                Moveplant.setOn_Cooldown(true);
                                System.out.println(Moveplant.plant.getCost());
                                Sun.sunpakai(Moveplant.plant.getCost());
                                Moveplant=null;
                                planted.spawn_Plant(lily);
                                lily=false;
                                deck=null;
                            }
    
                        }else{
                            Moveplant.picked=true;
                            dragging=false;
                            Moveplant=null;
                            deck=null;
                        }

                    }else{
                        dragging=false;
                        deck=null;
                    }
                }
            }else{
                Moveplant.setX(Moveplant.getX2());
                Moveplant.setY(Moveplant.getY2());
                deck=null; 
                Moveplant.picked=true;
                Moveplant=null;
                dragging=false;
            }
        }else{
            Iterator<Plant> plantIterator = Screen.plants.iterator();
            while (plantIterator.hasNext()) {
                Plant plant = plantIterator.next();
                if(deck!=null){
                    if(plant.getX()==deck.getX()&&plant.getY()==deck.getY()){
                        plantIterator.remove();
                    }

                }
            } 
            deck=null; 
            shovel=false;
            dragging=false;
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragging) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            float xf=0;
            float yf=0;
            if(shovel){
                xf=(mouseX)/tilesize;
                yf=(mouseY)/tilesize;
            }else{
                Moveplant.setX(mouseX-dragOffsetX);
                Moveplant.setY(mouseY-dragOffsetY);
                xf=(Moveplant.getX()+30)/tilesize;
                yf=(Moveplant.getY()+30)/tilesize;
            }
            int xi=Math.round(xf);
            int yi=Math.round(yf);
            boolean lily=true;
            if(xi>0 && xi<10&&yi>2&&yi<5){
                lily=false;
                for (int i = 0; i < Screen.plants.size(); i++) {
                    if(Screen.plants.get(i)!=null){
                        if(Screen.plants.get(i).getName()=="Lilypad"){
                            if(Screen.plants.get(i).getX()/60==xi&&Screen.plants.get(i).getY()/60==yi){
                                lily=true;
                                break;
                            }
                        }
                    }
                }
            }
            if(shovel){
                deck=new Deck(xi, yi, "res/shovel1.png");
            }else{
                if(xi>0 && xi<10&&lily){
                    if(yi>0&&yi<7){
                        Plant plant=Moveplant.plant;
                        deck=new Planthighlight(xi, yi, plant.getPicture());
                        plant.setX(xi*tilesize);
                        plant.setY(yi*tilesize);
                        planted=plant;
                    }else{
                        deck=null;
                        planted=null;
                    }
                }else{
                    deck=null;
                    planted=null;
                }
                if(Moveplant.plant.getName()=="Lilypad"){
                    if(xi>0 && xi<10){
                        if(yi>2&&yi<5){
                            Plant plant=Moveplant.plant;
                            deck=new Planthighlight(xi, yi, plant.getPicture());
                            plant.setX(xi*tilesize);
                            plant.setY(yi*tilesize);
                            planted=plant;
                        }else{
                            deck=null;
                            planted=null;
                        }
                    }else{
                        deck=null;
                        planted=null;
                    }
                }
            }
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    
}
