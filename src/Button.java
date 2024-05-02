import java.awt.*;
public class Button extends Square {
    int width=Screen.tilesize*2;
    int height =Screen.tilesize;
    protected Button(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }
    public void Draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(X, Y, width, height);
    }
}
