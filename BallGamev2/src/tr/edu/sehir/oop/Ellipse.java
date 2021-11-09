package tr.edu.sehir.oop;

import java.awt.*;

public class Ellipse extends Ball {
    float x, y;
    float speedX, speedY;
    float radius;
    private Color color;
    private static final Color DEFAULT_COLOR = Color.RED;

    public Ellipse(float x, float y, float radius, float speed, float angleInDegree, Color color) {
        this.x = x;
        this.y = y;
        this.speedX = (float) (speed * Math.cos(Math.toRadians(angleInDegree)));
        this.speedY = (float) (-speed * (float) Math.sin(Math.toRadians(angleInDegree)));
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void moveOneStepWithCollisionDetection(ContainerBox box) {
        float ellipseMinX = box.minX + radius;
        float ellipseMinY = box.minY + radius;
        float ellipseMaxX = box.maxX - (2 * radius);
        float ellipseMaxY = box.maxY - (radius/3);

        x += speedX;
        y += speedY;

        if (x < ellipseMinX) {
            speedX = -speedX; // Reflect along normal
            x = ellipseMinX;     // Re-position the ball at the edge
        } else if (x > ellipseMaxX) {
            speedX = -speedX;
            x = ellipseMaxX;
        }
        // May cross both x and y bounds
        if (y < ellipseMinY) {
            speedY = -speedY;
            y = ellipseMinY;
        } else if (y > ellipseMaxY) {
            speedY = -speedY;
            y = ellipseMaxY;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - radius), (int) (y - radius), (int) (3* radius), (int) (1.5*radius));
    }
}
