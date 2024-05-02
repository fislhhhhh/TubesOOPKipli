import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Iterator;
public class Screen extends JPanel implements MouseListener, MouseMotionListener {
    static final int originaltilesize=20;
    static final int scale =3;
    static final int tilesize = originaltilesize*scale;
    final int maxrow =8;
    final int maxcol=11;
    final int screenwidth=maxcol*tilesize;
    final int screenheight=maxrow*tilesize;
    int a=0;
    Deck deck=null;
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
        for(int i =0;i<8;i++){
            new House(0*tilesize, i*tilesize).Draw(g2);
            new Spawn(10*tilesize, i*tilesize).Draw(g2);
        }
        for(int i=1 ;i<10;i++){
            new Land(i*tilesize, 1*tilesize).Draw(g2);
            new Land(i*tilesize, 2*tilesize).Draw(g2);
            new Water(i*tilesize, 3*tilesize).Draw(g2);
            new Water(i*tilesize, 4*tilesize).Draw(g2);
            new Land(i*tilesize, 5*tilesize).Draw(g2);
            new Land(i*tilesize, 6*tilesize).Draw(g2);
        }
        for(int i =1;i<10;i++){
            new Deck(i, 0,"res/Deck.png").Draw(g2);
            new Deck(i, 7,"res/Deck.png").Draw(g2);
        }
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
                inventorybag.X2=si*60;
                inventorybag.Y2=0;
                inventorybag.Draw(g2);
                si++;
            }
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
                x=inventorybag.X2;
                y=inventorybag.Y2;
                width=Screen.tilesize;
                height=Screen.tilesize;
            if (mouseX >= x && mouseX <= (x+width) &&
                mouseY >= y && mouseY <= (y + height)) {
                    System.out.println("pick");
                    dragging=true;
                    dragOffsetX = mouseX - inventorybag.X2;
                    dragOffsetY = mouseY - inventorybag.Y2;
                    inventorybag.picked=false;
                    Moveplant=inventorybag;
                }
            }
        }        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(Moveplant!=null){
            for (Plant plant : plants) {
                if(plant.X==planted.X&&plant.Y==planted.Y){
                    Moveplant.picked=true;
                    dragging=false;
                    Moveplant=null;
                    deck=null;
                }
            }
            if(Moveplant!=null){
                Moveplant.picked=true;
                dragging=false;
                Moveplant=null;
                planted.spawn_Plant();
                deck=null;
            }
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragging) {
            System.out.println("drag");
            int mouseX = e.getX();
            int mouseY = e.getY();
            Moveplant.X=mouseX-dragOffsetX;
            Moveplant.Y=mouseY-dragOffsetY;
            System.out.println(Moveplant.X);
            System.out.println(Moveplant.Y);
            float xf=Moveplant.X/tilesize;
            float yf=Moveplant.Y/tilesize;
            int xi=Math.round(xf);
            int yi=Math.round(yf);
            if(xi>0&&xi<10){
                if(yi>0&&yi<7){
                    Plant plant=Moveplant.plant;
                    deck=new Deck(xi, yi, plant.getPicture());
                    plant.X=xi*tilesize;
                    plant.Y=yi*tilesize;
                    planted=plant;
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
