import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChanger extends JFrame implements ItemListener {

    private JComboBox<String> colorComboBox;

    public ColorChanger() {
        setTitle("Background Color Changer");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] colors = {"White", "Red", "Green", "Blue", "Yellow", "Orange", "Pink", "Gray"};
        colorComboBox = new JComboBox<>(colors);
        colorComboBox.addItemListener(this);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Color:"));
        topPanel.add(colorComboBox);

        add(topPanel, BorderLayout.NORTH);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedColor = (String) colorComboBox.getSelectedItem();
            Color color;

            switch (selectedColor) {
                case "Red":
                    color = Color.RED; break;
                case "Green":
                    color = Color.GREEN; break;
                case "Blue":
                    color = Color.BLUE; break;
                case "Yellow":
                    color = Color.YELLOW; break;
                case "Orange":
                    color = Color.ORANGE; break;
                case "Pink":
                    color = Color.PINK; break;
                case "Gray":
                    color = Color.GRAY; break;
                default:
                    color = Color.WHITE;
            }

            getContentPane().setBackground(color);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorChanger frame = new ColorChanger();
            frame.setVisible(true);
        });
    }
}
