import java.awt.*;

import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory extends JPanel implements MouseListener{
    Button button;
    ArrayList<Plant>Iplant = new ArrayList<>();
    ArrayList<Inventorybag> bag=new ArrayList<>();
    static ArrayList<Inventorybag> decks=new ArrayList<>();
    boolean deckarea=false;
    Plant plantdata=null;
    Inventory(){
        this.setPreferredSize(new Dimension(Screen.tilesize*11,Screen.tilesize*8));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        addMouseListener(this);
        filledInventory();
    }
    public void filledInventory(){
        Iplant.clear();
        bag.clear();
        decks.clear();
        Squash squash=new Squash(2, 2);
        Iplant.add(squash);
        Snowpea snowpea=new Snowpea(1, 2);
        Iplant.add(snowpea);
        Lilypad lilypad=new Lilypad(1, 1);
        Iplant.add(lilypad);
        Peashooter peashooter=new Peashooter(1, 1);
        Iplant.add(peashooter);
        Sunflower sunflower=new Sunflower(1, 1);
        Iplant.add(sunflower);
        Wallnut wallnut=new Wallnut(1,1);
        Iplant.add(wallnut);
        Jalapeno jalapeno = new Jalapeno(1, 1);
        Iplant.add(jalapeno);
        Cherrybomb cherrybomb = new Cherrybomb(1, 1);
        Iplant.add(cherrybomb);
        Doompea doompea = new Doompea(1, 1);
        Iplant.add(doompea);
        Littlepea littlepea=new Littlepea(1, 1);
        Iplant.add(littlepea);
        int X=1;
        int Y=1; 
        for (Plant plan : Iplant) {
            if(X<6){ 
                Inventorybag inventorybag= new Inventorybag(X, Y, plan);
                bag.add(inventorybag);
                X++;
            }else{
                X=1;
                Y++;
                Inventorybag inventorybag= new Inventorybag(X, Y, plan);
                bag.add(inventorybag);
                X++;
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        for (int i = 0; i < 6; i++) {
            new Deck((i+1), 0,"res\\plantstorage.png").Draw(g2);
        }
        for(int j =1;j<8;j++){
            for(int i =0;i<7;i++){
                new Deck(i, j,"res\\Inventory\\Brown.png").Draw(g2);;
            }
        }
        int si=1;
        new Button(60,60,300,120,"res\\Inventory\\2by5.png").Draw(g2);
        for (Inventorybag inventorybag : decks) {
            if(inventorybag!=null){
                inventorybag.X2=si*60;
                inventorybag.Y2=0;
                inventorybag.Draw(g2);
                si++;
            }
        }
        for (Inventorybag inventorybag : bag) {
            if(inventorybag!=null){
                inventorybag.Draw(g2);
            }
        }
        new Button(0, 0, 60, 60, "res\\Inventory\\Back.png").Draw(g2);
        new Button(60,180,300,120,"res\\Inventory\\2by5.png").Draw(g2);
        new Button(60,300,300,180,"res\\Inventory\\3by5.png").Draw(g2);
        new Button(420,0,240,480,"res\\Inventory\\Sidewalk.png").Draw(g2);
        button=new Button(7*Screen.tilesize,0*Screen.tilesize,120,60,"res\\Inventory\\survive.png");
        button.Draw(g2);
        if(plantdata!=null){
            String string;
            Font font=new Font("Verdana",Font.BOLD,14);
            g2.setFont(font);
            g2.setColor(Color.BLACK);
            string="Name:"+plantdata.getName();
            g2.drawString(string, 85, 215);
            string="Cost:"+plantdata.getCost();
            g2.drawString(string, 85, 230);
            string="Health:"+plantdata.getHealth();
            g2.drawString(string, 85, 245);
            string="Cooldown:"+plantdata.getCooldown();
            g2.drawString(string, 85, 260);
        }
        g2.dispose();
    }
    public void setPlantdata(Plant plantdata) {
        this.plantdata = plantdata;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX=e.getX();
        int mouseY=e.getY();
        int x=button.getX();
        int y=button.getY();
        int width = button.width;
        int height = button.height;
        if(mouseX >= 60 && mouseX <= (7*60) &&
        mouseY >= 0 && mouseY <= (60)){
            deckarea=true;
        }else {
            deckarea=false;
        }
        if(deckarea){
            Iterator<Inventorybag> deckInterator = decks.iterator();
            while (deckInterator.hasNext()) {
                Inventorybag inventorybag = deckInterator.next();
                if(inventorybag!=null){
                    x=inventorybag.X2;
                    y=inventorybag.Y2;
                    width=Screen.tilesize;
                    height=Screen.tilesize;
                if (mouseX >= x && mouseX <= (x+width) &&
                    mouseY >= y && mouseY <= (y + height)) {
                        if(inventorybag.picked){
                            inventorybag.picked=false;
                            bag.add(inventorybag);
                            plantdata=inventorybag.getPlant();
                            deckInterator.remove();
                        }
                    }
                }
            } 

        }else{
            if (mouseX >= x && mouseX <= (x+width) &&
            mouseY >= y && mouseY <= (y + height)&&decks.size()==6) {
                Gamepanel.Startgame();
            }
            if(mouseX>=0&&mouseX<=60&&mouseY>=0&&mouseY<=60){
                Gamepanel.mainMenubalik();
            }
            Iterator<Inventorybag> bagInterator = bag.iterator();
            while (bagInterator.hasNext()) {
                Inventorybag inventorybag = bagInterator.next();
                if(inventorybag!=null){
                    x=inventorybag.getX();
                    y=inventorybag.getY();
                    width=Screen.tilesize;
                    height=Screen.tilesize;
                if (mouseX >= x && mouseX <= (x+width) &&
                    mouseY >= y && mouseY <= (y + height)) {
                        if(!inventorybag.picked&&decks.size()<6){
                            inventorybag.picked=true;
                            decks.add(inventorybag);
                            plantdata=inventorybag.getPlant();
                            bagInterator.remove();
                        }
                    }
                }
            } 

        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    public void screenrefresh(){
        repaint();
        
    }

}
