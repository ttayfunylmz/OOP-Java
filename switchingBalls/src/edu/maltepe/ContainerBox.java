package edu.maltepe;
import java.awt.Color;
import java.awt.Graphics;
/**
 * A rectangular container box, containing the bouncing ball.
 *
 * @author Hock-Chuan Chua
 * @version 31 October 2010
 */
public class ContainerBox {
    int minX, maxX, minY, maxY;
    private Color colorFilled;
    private Color colorBorder;
    private static final Color DEFAULT_COLOR_FILLED = Color.BLACK;
    private static final Color DEFAULT_COLOR_BORDER = Color.YELLOW;

    /** Constructors */
    public ContainerBox(int x, int y, int width, int height, Color colorFilled, Color colorBorder) {
        minX = x;
        minY = y;
        maxX = x + width - 1;
        maxY = y + height - 1;
        this.colorFilled = colorFilled;
        this.colorBorder = colorBorder;
    }
    /** Constructor with the default color */
    public ContainerBox(int x, int y, int width, int height) {
        this(x, y, width, height, DEFAULT_COLOR_FILLED, DEFAULT_COLOR_BORDER);
    }

    /** Set or reset the boundaries of the box. */
    public void set(int x, int y, int width, int height) {
        minX = x;
        minY = y;
        maxX = x + width - 1;
        maxY = y + height - 1;
    }

    /** Draw itself using the given graphic context. */
    public void draw(Graphics g) {
        g.setColor(colorFilled);
        g.fillRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
        g.setColor(colorBorder);
        g.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
    }
}
