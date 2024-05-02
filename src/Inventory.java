import java.awt.*;

import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory extends JPanel implements MouseListener{
    Button button;
    static ArrayList<Plant>Iplant = new ArrayList<>();
    ArrayList<Inventorybag> bag=new ArrayList<>();
    static ArrayList<Inventorybag> decks=new ArrayList<>();
    boolean deckarea=false;
    Inventory(){
        this.setPreferredSize(new Dimension(Screen.tilesize*11,Screen.tilesize*8));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        addMouseListener(this);
        Squash squash=new Squash(2, 2);
        Iplant.add(squash);
        Snowpea snowpea=new Snowpea(1, 2);
        Iplant.add(snowpea);
        int X=1;
        int Y=1; 
        for (Plant plan : Iplant) {
            if(X<6){ 
                Inventorybag inventorybag= new Inventorybag(X, Y, plan);
                bag.add(inventorybag);
                X++;
            }else{
                X=0;
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
        button=new Button(7*60, 0*60);
        for (int i = 0; i < 6; i++) {
            new Deck((i+1), 0,"res/Deck.png").Draw(g2);
        }
        for(int j =1;j<7;j++){
            for(int i =1;i<6;i++){
                new Deck(i, j,"res/Deck.png").Draw(g2);;
            }
        }
        int si=1;
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
        button.Draw(g2);
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
        if(mouseX >= 60 && mouseX <= (6*60) &&
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
                            deckInterator.remove();
                        }
                    }
                }
            } 

        }else{
            if (mouseX >= x && mouseX <= (x+width) &&
            mouseY >= y && mouseY <= (y + height)) {
                Gamepanel.Startgame();
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
