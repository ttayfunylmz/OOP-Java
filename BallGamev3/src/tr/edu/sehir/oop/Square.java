package tr.edu.sehir.oop;

import java.awt.*;

public class Square extends Ball {

    float x, y;
    float speedX, speedY;
    float width;
    private Color color;
    private static final Color DEFAULT_COLOR = Color.BLUE;

    public Square(float x, float y, float width, float speed, float angleInDegree, Color color) {
        super(x, y, width, speed, angleInDegree, color);
        this.x = x;
        this.y = y;
        this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
        this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
        this.width = width;
        this.color = color;
    }

    public void moveOneStepWithCollisionDetection(ContainerBox box) {
        // Get the ball's bounds, offset by the radius of the ball
        float squareMinX = box.minX + width;
        float squareMinY = box.minY + width;
        float squareMaxX = box.maxX - width;
        float squareMaxY = box.maxY - width;

        // Calculate the ball's new position
        x += speedX;
        y += speedY;
        // Check if the ball moves over the bounds. If so, adjust the position and speed.
        if (x < squareMinX) {
            speedX = -speedX; // Reflect along normal
            x = squareMinX;     // Re-position the ball at the edge
        } else if (x > squareMaxX) {
            speedX = -speedX;
            x = squareMaxX;
        }
        // May cross both x and y bounds
        if (y < squareMinY) {
            speedY = -speedY;
            y = squareMinY;
        } else if (y > squareMaxY) {
            speedY = -speedY;
            y = squareMaxY;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
    }

}
