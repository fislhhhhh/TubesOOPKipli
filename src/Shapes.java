import javax.swing.*;

public abstract class Shapes extends JPanel {
    protected int X, Y;
    protected int Width = 50;
    protected int Height = 50;
    protected Shapes(int X,int Y){
        this.X = X;
        this.Y = Y;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
    public int getWidth() {
        return Width;
    }
    public int getHeight() {
        return Height;
    }
    public void setX(int x) {
        X = x;
    }
    public void setY(int y) {
        Y = y;
    }
}
