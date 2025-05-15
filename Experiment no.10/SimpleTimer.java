import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleTimer extends JFrame implements ActionListener {

    private JLabel timeLabel;
    private JButton startButton, stopButton;
    private Timer timer;
    private int seconds = 0;

    public SimpleTimer() {
        setTitle("Simple Timer");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null); 

        timeLabel = new JLabel("Time: 0 sec");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        add(timeLabel);
        add(startButton);
        add(stopButton);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timeLabel.setText("Time: " + seconds + " sec");
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
        } else if (e.getSource() == stopButton) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleTimer timerApp = new SimpleTimer();
            timerApp.setVisible(true);
        });
    }
}
