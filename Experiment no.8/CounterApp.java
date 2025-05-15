import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterApp extends JFrame implements ActionListener {
    private JTextField counterField;
    private int count = 0;

    public CounterApp() {
        
        setTitle("Counter");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Counter");
        counterField = new JTextField("0", 5);
        counterField.setEditable(false);

        JButton btnUp = new JButton("Count Up");
        JButton btnDown = new JButton("Count Down");
        JButton btnReset = new JButton("Reset");

       
        btnUp.addActionListener(this);
        btnDown.addActionListener(this);
        btnReset.addActionListener(this);

        
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(counterField);
        panel.add(btnUp);
        panel.add(btnDown);
        panel.add(btnReset);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Count Up":
                count++;
                break;
            case "Count Down":
                count--;
                break;
            case "Reset":
                count = 0;
                break;
        }
        counterField.setText(Integer.toString(count));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CounterApp());
    }
}
