import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mainmenu extends JPanel implements MouseListener{
    Button button;
    private BufferedImage Png;
    protected String picture="res/MainMenu.png";
    Mainmenu(){
        this.setPreferredSize(new Dimension(Screen.tilesize*11,Screen.tilesize*8));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        addMouseListener(this);

    }
    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,0,0,11*Screen.tilesize,8*Screen.tilesize,null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Draw((Graphics2D) g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX>265&&mouseX<355&&mouseY>240&&mouseY<280){
            System.out.println("ada");
            Gamepanel.inventoryScene();
            
        }
        if(mouseX>265&&mouseX<355&&mouseY>300&&mouseY<340){
            System.out.println("help");
            
        }
        if(mouseX>265&&mouseX<355&&mouseY>360&&mouseY<400){
            System.out.println("load");
            Gamepanel.loadGame();
        }
        if(mouseX>260&&mouseX<380&&mouseY>415&&mouseY<455){
            System.out.println("almanac");
            Gamepanel.almanaChoose();
        }
        if(mouseX>553&&mouseX<643&&mouseY>430&&mouseY<485){
            System.exit(0);
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

}