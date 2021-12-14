package edu.maltepe;

import javax.swing.JFrame;
/**
 * Main Program for running the bouncing ball as a standalone application.
 *
 * @author Hock-Chuan Chua
 * @version October 2010
 * modified by e gul
 */
public class Main {

    public static void main(String[] args) {
        // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
        //javax.swing.SwingUtilities.invokeLater(new Runnable() {
        //   public void run() {
        JFrame frame = new JFrame("World 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new BallWorld(640, 480,1)); // BallWorld is a JPanel
        frame.pack();            // Preferred size of BallWorld
        frame.setVisible(true);  // Show it
        frame.setLocation(100,150);
        //}
        //});

        JFrame frame2 = new JFrame("World 2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setContentPane(new BallWorld(640, 480,2));
        frame2.pack();
        frame2.setVisible(true);
        frame2.setLocation(740,150);

    }
}
