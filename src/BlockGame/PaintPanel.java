package BlockGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PaintPanel extends JPanel implements ActionListener {
    Timer timer;
    final int DELAY = 10;
    final int RECTANGLE_WIDTH = 100;
    final int HEIGHT = 700;
    final int WIDTH = 700;

    int ballX = WIDTH / 2 - 20;
    int ballY = HEIGHT / 2 - 20;

    boolean ballMove = false;

    int directionX;
    int directionY = -5;
    Platform player1;

    public PaintPanel() {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        player1 = new Platform("Player1", WIDTH / 2 - Platform.RECTANGLE_WIDTH, 40);
        timer = new Timer(DELAY, this);
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(player1.getX(), player1.getY(), player1.getRECTANGLE_WIDTH(), player1.getRECTANGLE_HEIGHT());

        /*g.setColor(Color.RED);
        g.fillRect(x,y,RECTANGLE_WIDTH,RECTANGLE_HEIGHT);*/

        g.setColor(Color.blue);
        g.fillOval(ballX, ballY, 20, 20);
    }

    public void moveBall() {

        if (ballMove) {
            ballY += directionY;
            ballX += directionX;
        }

    }

    public void ballCollidePlatform() {
        //adjusting platform ranges for edge collision
        int platformRange=16;
        if (ballY == player1.getY() + player1.getRECTANGLE_HEIGHT()) {

            if (player1.getX() + Platform.RECTANGLE_WIDTH + platformRange >= ballX && ballX >= player1.getX() - platformRange) {
                directionX = (ballX - player1.getX() - Platform.RECTANGLE_WIDTH / 2) / 5; //dividing to 5 to get -10 to 10 range
                directionY *= -1;
            }



        }


    }
    public void ballCollideWall(){
        //adjusting ball ranges for wall collision
        int ballRange=10;
        if (ballY == HEIGHT - ballRange || ballY==0)
            directionY *= -1;
        if (ballX <= ballRange || ballX >= WIDTH-ballRange) {
            directionX *= -1;
        }
    }

    public void checkHit() {
        player1.setHitTheWallX(player1.getX() == WIDTH - Platform.RECTANGLE_WIDTH);
        player1.setHitTheWallY(player1.getX() == 0);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Platform.movePlayer(player1);
        moveBall();
        ballCollideWall();
        checkHit();
        ballCollidePlatform();
        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {

                case KeyEvent.VK_LEFT:
                    player1.setPlayerDirection("L");
                    break;
                case KeyEvent.VK_RIGHT:
                    player1.setPlayerDirection("R");
                    break;
                case KeyEvent.VK_SPACE:
                    ballMove = true;
                    break;

            }

        }

        public void keyReleased(KeyEvent e) {
            player1.setPlayerDirection(" ");

        }
    }
}
