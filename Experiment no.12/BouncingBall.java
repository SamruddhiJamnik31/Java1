import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall extends JFrame {
    public BouncingBall() {
        setTitle("Bouncing Blue Ball");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        BallPanel ballPanel = new BallPanel();
        add(ballPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BouncingBall::new);
    }
}

class BallPanel extends JPanel implements Runnable {
    private int x = 100, y = 100;      
    private int dx = 2, dy = 2;        
    private final int radius = 30;  
    private boolean running = false;

    public BallPanel() {
        setBackground(Color.WHITE);


        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (!running) {
                    running = true;
                    Thread thread = new Thread(BallPanel.this);
                    thread.start();
                }
            }
        });
    }

    public void run() {
        while (running) {
            x += dx;
            y += dy;

         
            if (x <= 0 || x >= getWidth() - radius) {
                dx = -dx;
            }

            
            if (y <= 0 || y >= getHeight() - radius) {
                dy = -dy;
            }

            repaint();

            try {
                Thread.sleep(10); 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, radius, radius);
    }
}
