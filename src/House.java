import java.awt.*;
public class House extends Square {

    protected House(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }
    public void Draw(Graphics2D g2) {
        g2.setColor(Color.GRAY);
        g2.fillRect(X, Y, Screen.tilesize, Screen.tilesize);
    }
}
