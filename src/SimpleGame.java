
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGame extends JPanel implements ActionListener {

    private Timer timer;
    private int playerX, playerY;
    private int playerWidth = 20;
    private int playerHeight = 20;

    public SimpleGame() {
        timer = new Timer(10, this);
        timer.start();

        playerX = 100;
        playerY = 100;

        setPreferredSize(new Dimension(400, 400));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    playerX -= 5;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    playerX += 5;
                } else if (keyCode == KeyEvent.VK_UP) {
                    playerY -= 5;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    playerY += 5;
                    repaint();
                }
                
            }
        });
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(playerX, playerY, playerWidth, playerHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public void Rungame(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new SimpleGame());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}