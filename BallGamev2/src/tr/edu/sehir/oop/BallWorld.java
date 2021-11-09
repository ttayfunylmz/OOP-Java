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
    private static final int UPDATE_RATE = 60;    // Frames per second (fps)

    private Ball ball;
    private Square square;
    private Ellipse ellipse;
    // A single bouncing Ball's instance
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
        Random rand = new Random();

        int ballRadius = 20;
        int ellipseRadius = 25;
        int squareWidth = 50;

        int ballX = rand.nextInt(canvasWidth - ballRadius * 2 - 20) + ballRadius + 10;
        int ballY = rand.nextInt(canvasHeight - ballRadius * 2 - 20) + ballRadius + 10;

        int squareX = rand.nextInt(canvasWidth - squareWidth*2-20) + squareWidth +10;
        int squareY = rand.nextInt(canvasHeight - squareWidth*2-20) + squareWidth +10;

        int ellipseX = rand.nextInt(canvasWidth - ellipseRadius*2-20) + ellipseRadius +10;
        int ellipseY = rand.nextInt(canvasHeight - ellipseRadius*2-20) + ellipseRadius +10;;

        int speed = 7;
        int angleInDegree = rand.nextInt(360);
        ball = new Ball(ballX, ballY, ballRadius, speed, angleInDegree, Color.BLUE);
        square = new Square(squareX,squareY,squareWidth,speed,angleInDegree,Color.RED);
        ellipse = new Ellipse(ellipseX,ellipseY,ellipseRadius,speed,angleInDegree,Color.yellow);

        // Init the Container Box to fill the screen
        box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.magenta, Color.BLACK);

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
        square.moveOneStepWithCollisionDetection(box);
        ellipse.moveOneStepWithCollisionDetection(box);
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
            square.draw(g);
            ellipse.draw(g);
        }
        /** Called back to get the preferred size of the component. */
        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
}
