import javax.swing.*;
import java.awt.*;

public class LanguageSelector extends JFrame {

    public LanguageSelector() {
        setTitle("Language Selector");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        JCheckBox javaCheck = new JCheckBox("Java");
        JCheckBox pythonCheck = new JCheckBox("Python");
        JCheckBox cppCheck = new JCheckBox("C++");

        add(javaCheck);
        add(pythonCheck);
        add(cppCheck);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LanguageSelector frame = new LanguageSelector();
            frame.setVisible(true);
        });
    }
}
