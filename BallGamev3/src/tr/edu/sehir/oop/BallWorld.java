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

    /*

    private Ball ball;
    private Square square;
    private Ellipse ellipse;

    */

    // The container rectangular box

    private static Random generator = new Random();
    private static int ballCount = generator.nextInt(50);
    private Ball balls[] = new Ball[ballCount];
    private int i;

    private ContainerBox box;
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

        /*

        Random rand = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();

        int ballRadius = 20;
        int squareWidth = 17;
        int ellipseRadius = 19;

        int ballX = rand.nextInt(canvasWidth - ballRadius * 2 - 20) + ballRadius + 10;
        int ballY = rand.nextInt(canvasHeight - ballRadius * 2 - 20) + ballRadius + 10;

        int squareX = rand2.nextInt(canvasWidth - squareWidth * 2 - 20) + squareWidth + 10;
        int squareY = rand2.nextInt(canvasHeight - squareWidth * 2 - 20) + squareWidth + 10;

        int ellipseX = rand3.nextInt(canvasWidth - ellipseRadius * 2 - 20) + ellipseRadius + 10;
        int ellipseY = rand3.nextInt(canvasHeight - ellipseRadius * 2 - 20) + ellipseRadius + 10;

        int speed1 = 5;
        int speed2 = 10;
        int speed3 = 20;

        int angleInDegree = rand.nextInt(360);

        ball = new Ball(ballX, ballY, ballRadius, speed1, angleInDegree, Color.YELLOW);
        square = new Square(squareX, squareY, squareWidth, speed2, angleInDegree, Color.cyan);
        ellipse = new Ellipse(ellipseX, ellipseY, ellipseRadius, speed3, angleInDegree, Color.RED);

         */

        for (i = 0; i < ballCount; i++) {
            Random shapeGenerator = new Random();
            Random speedGenerator = new Random();
            Random rand = new Random();

            int shape = shapeGenerator.nextInt(3); //We have only 3 shapes.
            int speed = speedGenerator.nextInt(ballCount);

            int ballRadius = 20;
            int squareWidth = 17;
            int ellipseRadius = 19;

            int ballX = rand.nextInt(canvasWidth - ballRadius * 2 - 20) + ballRadius + 10;
            int ballY = rand.nextInt(canvasHeight - ballRadius * 2 - 20) + ballRadius + 10;

            int squareX = rand.nextInt(canvasWidth - squareWidth * 2 - 20) + squareWidth + 10;
            int squareY = rand.nextInt(canvasHeight - squareWidth * 2 - 20) + squareWidth + 10;

            int ellipseX = rand.nextInt(canvasWidth - ellipseRadius * 2 - 20) + ellipseRadius + 10;
            int ellipseY = rand.nextInt(canvasHeight - ellipseRadius * 2 - 20) + ellipseRadius + 10;

            int angleInDegree = rand.nextInt(360);

            if (shape == 1) {
                Ball ball = new Ball(ballX, ballY, ballRadius, speed, angleInDegree, Color.cyan);
                balls[i] = ball;
            }else if (shape == 2) {
                Ball ball = new Square(squareX, squareY, squareWidth, speed, angleInDegree, Color.red);
                balls[i] = ball;
            }else {
                Ball ball = new Ellipse(ellipseX, ellipseY, ellipseRadius, speed, angleInDegree, Color.white);
                balls[i] = ball;
            }
        }



        // Init the Container Box to fill the screen
        box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.black, Color.WHITE);

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
        for (i = 0; i < ballCount; i++) {
            Ball ball = balls[i];
            ball.moveOneStepWithCollisionDetection(box);
        }
        /*

        ball.moveOneStepWithCollisionDetection(box);
        square.moveOneStepWithCollisionDetection(box);
        ellipse.moveOneStepWithCollisionDetection(box);

         */
    }

    /** The custom drawing panel for the bouncing ball (inner class). */
    class DrawCanvas extends JPanel {
        /** Custom drawing codes */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);    // Paint background
            // Draw the box and the ball
            box.draw(g);
            for (i = 0; i < ballCount; i++) {
                Ball ball = balls[i];
                ball.draw(g);
            }
            /*

            ball.draw(g);
            square.draw(g);
            ellipse.draw(g);

             */
        }

        /** Called back to get the preferred size of the component. */
        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
}
