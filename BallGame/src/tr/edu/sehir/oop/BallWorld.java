package tr.edu.sehir.oop;
import java.awt.*;
import java.awt.event.*;
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

    private Ball ball1,ball2,ball3;         // A single bouncing Ball's instance
    private ContainerBox box;  // The container rectangular box

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
        Random rand1 = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();
        int radius1 = 20;
        int x1 = rand1.nextInt(canvasWidth - radius1 * 2 - 20) + radius1 + 10;
        int y1 = rand1.nextInt(canvasHeight - radius1 * 2 - 20) + radius1 + 10;
        int speed1 = 5;
        int angleInDegree1 = rand1.nextInt(360);
        ball1 = new Ball(x1, y1, radius1, speed1, angleInDegree1, Color.BLUE);

        int radius2 = 20;
        int x2 = rand2.nextInt(canvasWidth - radius2 * 2 - 20) + radius2 + 10;
        int y2 = rand2.nextInt(canvasHeight - radius2 * 2 - 20) + radius2 + 10;
        int speed2 = 5;
        int angleInDegree2 = rand2.nextInt(360);
        ball2 = new Ball(x2, y2, radius2, speed2, angleInDegree2, Color.PINK);

        int radius3 = 20;
        int x3 = rand3.nextInt(canvasWidth - radius3 * 2 - 20) + radius3 + 10;
        int y3 = rand3.nextInt(canvasHeight - radius3 * 2 - 20) + radius3 + 10;
        int speed3 = 5;
        int angleInDegree3 = rand3.nextInt(360);
        ball3 = new Ball(x3, y3, radius3, speed3, angleInDegree3, Color.RED);

//
        // Init the Container Box to fill the screen
        box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.CYAN, Color.PINK);

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
        gameThread.start();  // Invoke GameThread.run()
    }


    /**
     * One game time-step.
     * Update the game objects, with proper collision detection and response.
     */
    public void gameUpdate() {
        ball1.moveOneStepWithCollisionDetection(box);
        ball2.moveOneStepWithCollisionDetection(box);
        ball3.moveOneStepWithCollisionDetection(box);

    }

    /** The custom drawing panel for the bouncing ball (inner class). */
    class DrawCanvas extends JPanel {
        /** Custom drawing codes */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);    // Paint background
            // Draw the box and the ball
            box.draw(g);
            ball1.drawCircle(g);
            ball2.drawRectangle(g);
            ball3.drawEllipse(g);

        }

        /** Called back to get the preferred size of the component. */
        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
}
