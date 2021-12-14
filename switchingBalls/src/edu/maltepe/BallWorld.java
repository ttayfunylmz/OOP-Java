package edu.maltepe;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    private static final int UPDATE_RATE = 35;    // Frames per second (fps)


    private ContainerBox box;  // The container rectangular box
    public static ArrayList<Ball> ballList1=new ArrayList<>();
    public static ArrayList<Ball> ballList2=new ArrayList<>();

    private DrawCanvas canvas; // Custom canvas for drawing the box/ball
    private int canvasWidth;
    private int canvasHeight;
    private int worldCheck;

    /**
     * Constructor to create the UI components and init the game objects.
     * Set the drawing canvas to fill the screen (given its width and height).
     *
     * @param width : screen width
     * @param height : screen height
     */
    public BallWorld(int width, int height,int worldCheck) {

        canvasWidth = width;
        canvasHeight = height;
        this.worldCheck = worldCheck;

        Random rand = new Random();
        int radius = 20;
        int x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
        int y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
        int speed = 5;
        int angleInDegree = rand.nextInt(360);

        Random rand1=new Random();
        int size = rand1.nextInt(50);

        if(worldCheck == 1){
            for(int i=0;i<=size;++i){
                Random rand2=new Random();
                int size2= rand2.nextInt(3);

                if(size2==2){
                    ballList1.add(new Ball(x, y, radius, speed+i, angleInDegree+(i*4), Color.blue));
                }
            }
            System.out.println("1st panel includes " + ballList1.size() + " balls.");
        }

        if(worldCheck == 2){
            for(int i=0;i<=size;++i){
                Random rand2=new Random();
                int size2=rand2.nextInt(3);

                if(size2==2){
                    ballList2.add(new Ball(x, y, radius, speed+i, angleInDegree+(i*4), Color.red));
                }
            }
            System.out.println("2nd panel includes " + ballList2.size() + " balls.");
        }




//
        // Init the Container Box to fill the screen
        box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.MAGENTA, Color.magenta);

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
        if(worldCheck == 1){
            for(int i=0;i<ballList1.size();++i){
                ballList1.get(i).moveOneStepWithCollisionDetection1(box);
            }
        }

        if(worldCheck == 2){
            for(int i=0;i<ballList2.size();++i){
                ballList2.get(i).moveOneStepWithCollisionDetection2(box);
            }
        }

    }

    /** The custom drawing panel for the bouncing ball (inner class). */
    class DrawCanvas extends JPanel {
        /** Custom drawing codes */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);    // Paint background
            // Draw the box and the ball
            box.draw(g);

            if(worldCheck == 1){
                for(int i=0;i<ballList1.size();++i){
                    ballList1.get(i).draw(g);
                }
            }

            if(worldCheck == 2){
                for(int i=0;i<ballList2.size();++i){
                    ballList2.get(i).draw(g);
                }
            }
        }

        /** Called back to get the preferred size of the component. */
        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
}

