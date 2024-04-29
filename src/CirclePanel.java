import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Get the width and height of the panel
        int width = getWidth();
        int height = getHeight();
        
        // Calculate the center coordinates of the panel
        int centerX = width / 2;
        int centerY = height / 2;
        
        // Calculate the radius of the circle
        int radius = Math.min(width, height) / 4; // Adjust this value as needed
        
        // Set the color of the circle
        g.setColor(Color.RED); // Change the color as desired
        
        // Draw the circle (filled)
        g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        
        // Alternatively, you can draw the circle (outline)
        // g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CirclePanel circlePanel = new CirclePanel();
        frame.add(circlePanel);
        
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
