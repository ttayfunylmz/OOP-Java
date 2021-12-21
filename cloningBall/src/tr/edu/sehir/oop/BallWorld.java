package tr.edu.sehir.oop;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ColorModel;
import java.util.Random;
import javax.swing.*;
/**
 * The control logic and main display panel for game.
 *
 * @author Hock-Chuan Chua
 * @version October 2010
 * modified by e gul
 */
public class BallWorld extends JPanel {
    private static final int UPDATE_RATE = 30;    // Frames per second (fps)

    private Ball ball;         // A single bouncing Ball's instance
    private ContainerBox box;  // The container rectangular box
    private Ball cloneBall;

    private DrawCanvas canvas; // Custom canvas for drawing the box/ball
    private int canvasWidth;
    private int canvasHeight;

    /**
     * Constructor to create the UI components and init the game objects.
     * Set the drawing canvas to fill the screen (given its width and height).
     *
     * @param width : screen width
     * @param height : screen height
     */
    public BallWorld(int width, int height) {

        canvasWidth = width;
        canvasHeight = height;

        // Init the ball at a random location (inside the box) and moveAngle
        Random rand = new Random();
        int radius = 20;
        int x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
        int y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
        int speed = 5;
        int angleInDegree = rand.nextInt(360);
        ball = new Ball(x, y, radius, speed, angleInDegree, Color.BLUE);

        try {
            cloneBall = (Ball) ball.clone();
            cloneBall.setColor(Color.gray);
            cloneBall.setSpeedX(ball.getSpeedX() +10);
            cloneBall.setSpeedY(ball.getSpeedY() +10);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


//
        // Init the Container Box to fill the screen
        box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.MAGENTA, Color.WHITE);

        // Init the custom drawing panel for drawing the game
        canvas = new DrawCanvas();
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);

        // Handling window resize.
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component)e.getSource();
                Dimension dim = c.getSize();
                canvasWidth = dim.width;
                canvasHeight = dim.height;
                // Adjust the bounds of the container to fill the window
                box.set(0, 0, canvasWidth, canvasHeight);
            }
        });

        // Start the ball bouncing
        gameStart();
    }

    /*
    public void gameStart(){
        gameThread gmthr = new gameThread(this,UPDATE_RATE);
        gmthr.start();

    }
    */

    // Start the ball bouncing.
    public void gameStart() {
        // Run the game logic in its own thread.
        Thread gameThread = new Thread() {
            public void run() {
                while (true) {
                    // Execute one time-step for the game
                    gameUpdate();
                    // Refresh the display
                    repaint();
                    // Delay and give other thread a chance
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException ex) {}
                }
            }
        };
        gameThread.start();  // Invoke GaemThread.run()
    }


    /**
     * One game time-step.
     * Update the game objects, with proper collision detection and response.
     */
    public void gameUpdate() {
        ball.moveOneStepWithCollisionDetection(box);
        cloneBall.moveOneStepWithCollisionDetection(box);
    }

    /** The custom drawing panel for the bouncing ball (inner class). */
    class DrawCanvas extends JPanel {
        /** Custom drawing codes */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);    // Paint background
            // Draw the box and the ball
            box.draw(g);
            ball.draw(g);
            cloneBall.draw(g);
        }

        /** Called back to get the preferred size of the component. */
        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
}
