
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGim extends JPanel implements MouseListener, MouseMotionListener {

    private int boxX, boxY;
    private int boxWidth = 50;
    private int boxHeight = 50;
    private boolean isDragging = false;
    private int dragOffsetX, dragOffsetY;

    public SimpleGim() {
        boxX = 100;
        boxY = 100;

        setPreferredSize(new Dimension(800, 600));
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(boxX, boxY, boxWidth, boxHeight);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= boxX && mouseX <= boxX + boxWidth &&
            mouseY >= boxY && mouseY <= boxY + boxHeight) {
            isDragging = true;
            dragOffsetX = mouseX - boxX;
            dragOffsetY = mouseY - boxY;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDragging = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (isDragging) {
            int mouseX = e.getX();
            int mouseY = e.getY();
            boxX = mouseX - dragOffsetX;
            boxY = mouseY - dragOffsetY;
            repaint();
        }
    }

    // Unused mouse listener methods
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

    public void Rungame(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new SimpleGim());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
