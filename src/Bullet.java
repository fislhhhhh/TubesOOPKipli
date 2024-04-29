import java.awt.*;
public class Bullet extends Circle implements CustomListener{
    int time=0;
    protected Bullet(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }
    
    public void Draw(Graphics2D g2) {
        g2.setColor(Color.PINK);
        g2.fillOval(X, Y , radius * 2, radius * 2);
    }
    

    public void actionPerformed() {
        X+=2;
    }
}
