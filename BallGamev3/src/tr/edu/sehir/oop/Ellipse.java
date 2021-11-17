package tr.edu.sehir.oop;

import java.awt.*;

public class Ellipse extends Ball {

    float x, y;
    float speedX, speedY;
    float radius;
    private Color color;
    private static final Color DEFAULT_COLOR = Color.BLUE;

    public Ellipse(float x, float y, float radius, float speed, float angleInDegree, Color color) {
        super(x, y, radius, speed, angleInDegree, color);
        this.x = x;
        this.y = y;
        this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
        this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
        this.radius = radius;
        this.color = color;

    }

    public void moveOneStepWithCollisionDetection(ContainerBox box) {
        // Get the ball's bounds, offset by the radius of the ball
        float ellipseMinX = box.minX + radius;
        float ellipseMinY = box.minY + radius;
        float ellipseMaxX = box.maxX - radius;
        float ellipseMaxY = box.maxY - radius;

        // Calculate the ball's new position
        x += speedX;
        y += speedY;
        // Check if the ball moves over the bounds. If so, adjust the position and speed.
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

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)(x - radius), (int)(y - radius), (int)(4 * radius), (int)(2 * radius));
    }









}
