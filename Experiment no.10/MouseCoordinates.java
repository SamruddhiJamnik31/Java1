import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseCoordinates extends JFrame implements MouseMotionListener {
    JLabel label;

    public MouseCoordinates() {
        setTitle("Mouse Coordinates");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        label = new JLabel("Move your mouse inside the window...");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(label);

        addMouseMotionListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        label.setText("Mouse at: X = " + e.getX() + ", Y = " + e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseCoordinates().setVisible(true));
    }
}
