import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageComboBoxViewer extends JFrame implements ItemListener {
    JComboBox<String> imageComboBox;
    JLabel imageLabel;

    String[] imageNames = {"dog.png", "cat.png", "bird.png"};
    ImageIcon[] icons;

    public ImageComboBoxViewer() {
        setTitle("Image ComboBox Viewer");
        setSize(400, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        icons = new ImageIcon[imageNames.length];
        for (int i = 0; i < imageNames.length; i++) {
            icons[i] = new ImageIcon("images/" + imageNames[i]);
        }

        imageComboBox = new JComboBox<>(imageNames);
        imageComboBox.addItemListener(this);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setIcon(icons[0]); 

        add(imageComboBox, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int index = imageComboBox.getSelectedIndex();
            imageLabel.setIcon(icons[index]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ImageComboBoxViewer().setVisible(true);
        });
    }
}
