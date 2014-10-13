/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movingballsfx;

import javafx.scene.paint.Color;

/**
 *
 * @author Peter Boots
 */
public class BallRunnable implements Runnable {

    private Ball ball;
    private RW readWrite;

    public BallRunnable(Ball ball, RW rw) {
        this.ball = ball;
        readWrite = rw;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (ball.getColor() == Color.RED) {

                    if (ball.isEnteringCs()) {
                        readWrite.enterReader();
                    } else if (ball.isLeavingCs()) {
                        readWrite.exitReader();
                    }

                } else if (ball.getColor() == Color.BLUE) {
                    if (ball.isEnteringCs()) {
                        readWrite.enterWriter();
                    } else if (ball.isLeavingCs()) {
                        readWrite.exitWriter();
                    }
                }
                ball.move();

                Thread.sleep(ball.getSpeed());

            } catch (InterruptedException ex) {
                if (ball.getColor() == Color.RED) {
                    readWrite.interruptedReader(ball);
                } else if (ball.getColor() == Color.BLUE) {
                    readWrite.interruptedWriter(ball);
                }
                Thread.currentThread().interrupt();
            }
        }
    }
}
