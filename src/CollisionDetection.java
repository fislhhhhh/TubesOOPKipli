import java.awt.*;

public class CollisionDetection {

    public static boolean isColliding(Rectangle rect1, Rectangle rect2) {
        return rect1.intersects(rect2);
    }

    public static void main(String[] args) {
        // Create two rectangles
        Rectangle rect1 = new Rectangle(100, 100, 50, 50); // x, y, width, height
        Rectangle rect2 = new Rectangle(120, 120, 50, 50); // x, y, width, height

        // Check for collision
        if (isColliding(rect1, rect2)) {
            System.out.println("Collision detected!");
        } else {
            System.out.println("No collision detected.");
        }
    }
}
