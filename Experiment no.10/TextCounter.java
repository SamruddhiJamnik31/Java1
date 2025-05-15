import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextCounter extends JFrame implements KeyListener {

    private JTextArea textArea;
    private JLabel countLabel;

    public TextCounter() {
        setTitle("Character and Word Counter");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.addKeyListener(this);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        countLabel = new JLabel("Characters: 0 | Words: 0");
        countLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        countLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countLabel, BorderLayout.SOUTH);
    }

    private void updateCounts() {
        String text = textArea.getText();
        int charCount = text.length();
        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;

        countLabel.setText("Characters: " + charCount + " | Words: " + wordCount);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        SwingUtilities.invokeLater(this::updateCounts);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextCounter().setVisible(true));
    }
}
