import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridSwapGame extends JFrame implements ActionListener {
    private JButton[] buttons = new JButton[6];
    private JButton firstSelected = null;

    public GridSwapGame() {
        setTitle("Grid Layout Swap Game");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 3, 5, 5));

        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (firstSelected == null) {
            firstSelected = clicked;
            firstSelected.setBackground(Color.YELLOW); 
        } else {
            
            String temp = firstSelected.getText();
            firstSelected.setText(clicked.getText());
            clicked.setText(temp);

            
            firstSelected.setBackground(null);
            firstSelected = null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridSwapGame().setVisible(true));
    }
}
