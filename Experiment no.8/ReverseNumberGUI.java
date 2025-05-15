import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReverseNumberGUI extends JFrame implements ActionListener {
    private JTextField inputField, resultField;
    private JButton reverseButton, clearButton;

    public ReverseNumberGUI() {
       
        setTitle("Reverse Number");
        setSize(350, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       
        JLabel inputLabel = new JLabel("Enter Number:");
        JLabel resultLabel = new JLabel("Reversed Number:");

        
        inputField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

       
        reverseButton = new JButton("Reverse");
        clearButton = new JButton("Clear");


        reverseButton.addActionListener(this);
        clearButton.addActionListener(this);

        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0; add(inputLabel, gbc);
        gbc.gridx = 1; add(inputField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(resultLabel, gbc);
        gbc.gridx = 1; add(resultField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(reverseButton, gbc);
        gbc.gridx = 1; add(clearButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reverseButton) {
            try {
                int num = Integer.parseInt(inputField.getText());
                int rev = 0;

                while (num != 0) {
                    rev = rev * 10 + num % 10;
                    num /= 10;
                }

                resultField.setText(Integer.toString(rev));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            inputField.setText("");
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReverseNumberGUI().setVisible(true));
    }
}
