import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Screen extends JPanel {
    static final int originaltilesize=16;
    static final int scale =3;
    static final int tilesize = originaltilesize*scale;
    final int maxrow =8;
    final int maxcol=11;
    final int screenwidth=maxcol*tilesize;
    final int screenheight=maxrow*tilesize;
    int a=0;
    public static Bullet bullets[]= new Bullet[20];
    public static Zombie zombies[]= new Zombie[20];
    BufferedImage test;
    Bullet bullet=new Bullet(0,0);
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
        // Bullet bullet = new Bullet(0*tilesize+a*2, 1*tilesize);
        // a++;
        // bullet.Draw(g2);
        try {
            test = ImageIO.read(new File("res/Plants/images.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage image=test;
        g2.drawImage(image,1*tilesize,1*tilesize,1*tilesize,1*tilesize,null);
        for (int i = 0; i < zombies.length; i++) {
            if (zombies[i]!=null) {
                zombies[i].Draw(g2);
            }
        }
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i]!=null) {
                bullets[i].Draw(g2);
            }
        }
        g2.dispose();
    }
    public void screenrefresh(){
        repaint();
    }

}
