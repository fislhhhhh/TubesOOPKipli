import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Screen extends JPanel {
    static final int originaltilesize=20;
    static final int scale =3;
    static final int tilesize = originaltilesize*scale;
    final int maxrow =8;
    final int maxcol=11;
    final int screenwidth=maxcol*tilesize;
    final int screenheight=maxrow*tilesize;
    int a=0;
    public static ArrayList<Bullet> bullets= new ArrayList<>();
    public static ArrayList<Zombie> zombies= new ArrayList<>();
    public static ArrayList<Plant> plants= new ArrayList<>();
    public Screen(){
        this.setPreferredSize(new Dimension(screenwidth,screenheight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

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
            new Deck(i*tilesize, 0*tilesize).Draw(g2);
            new Deck(i*tilesize, 7*tilesize).Draw(g2);
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
        g2.dispose();
    }
    public void screenrefresh(){
        repaint();
    }

}
