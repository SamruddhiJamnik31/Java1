import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopwatchApp extends JFrame implements ActionListener, Runnable {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;

    private int hours = 0, minutes = 0, seconds = 0;
    private boolean running = false;
    private Thread thread;

    public StopwatchApp() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        add(timeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == startButton) {
            if (!running) {
                running = true;
                thread = new Thread(this);
                thread.start();
            }
        } else if (src == stopButton) {
            running = false;
        } else if (src == resetButton) {
            running = false;
            hours = minutes = seconds = 0;
            timeLabel.setText("00:00:00");
        }
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }

                String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                timeLabel.setText(time);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StopwatchApp::new);
    }
}
