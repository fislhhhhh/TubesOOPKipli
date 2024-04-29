import javax.swing.*;
import java.awt.*;

public class MultipleBoxes extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Define the coordinates and size for the first box
        int x1 = 50;
        int y1 = 50;
        int width1 = 100;
        int height1 = 100;

        // Draw the first box
        g2d.setColor(Color.RED);
        g2d.fillRect(x1, y1, width1, height1);

        // Define the coordinates and size for the second box
        int x2 = 200;
        int y2 = 100;
        int width2 = 150;
        int height2 = 80;

        // Draw the second box
        g2d.setColor(Color.BLUE);
        g2d.fillRect(x2, y2, width2, height2);

        // You can define more boxes and draw them similarly
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Multiple Boxes Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MultipleBoxes());
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
