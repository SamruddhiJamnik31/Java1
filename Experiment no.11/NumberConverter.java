import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberConverter extends JFrame implements ActionListener {
    private JTextField inputField, resultField;
    private JButton binaryBtn, octalBtn, hexBtn;

    public NumberConverter() {
        setTitle("Number Converter");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10)); 

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter the number"));
        inputField = new JTextField(10);
        inputPanel.add(inputField);
        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        binaryBtn = new JButton("Binary");
        octalBtn = new JButton("Octal");
        hexBtn = new JButton("Hex");

        buttonPanel.add(binaryBtn);
        buttonPanel.add(octalBtn);
        buttonPanel.add(hexBtn);

        add(buttonPanel, BorderLayout.CENTER);

        binaryBtn.addActionListener(this);
        octalBtn.addActionListener(this);
        hexBtn.addActionListener(this);

        JPanel resultPanel = new JPanel();
        resultPanel.add(new JLabel("Result"));
        resultField = new JTextField(15);
        resultField.setEditable(false);
        resultPanel.add(resultField);

        add(resultPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int number = Integer.parseInt(inputField.getText());

            if (e.getSource() == binaryBtn) {
                resultField.setText(Integer.toBinaryString(number));
            } else if (e.getSource() == octalBtn) {
                resultField.setText(Integer.toOctalString(number));
            } else if (e.getSource() == hexBtn) {
                resultField.setText(Integer.toHexString(number).toUpperCase());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberConverter().setVisible(true));
    }
}
