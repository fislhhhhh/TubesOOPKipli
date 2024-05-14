import java.awt.*;
public class Button extends Square {
    int width=Screen.tilesize*2;
    int height =Screen.tilesize;
    Color color;
    protected Button(int X, int Y ,Color color) {
        super(X, Y);
        this.color =color;
        //TODO Auto-generated constructor stub
    }
    public void Draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(X, Y, width, height);
    }
}
