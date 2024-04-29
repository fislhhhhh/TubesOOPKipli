import java.awt.*;

public class Land extends Square {

    protected Land(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }
    public void Draw(Graphics2D g2) {
        g2.setColor(Color.GREEN);
        g2.fillRect(X, Y, Screen.tilesize, Screen.tilesize);
    }
    
}
