import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double num1 = 0;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "%", "√", "x²",
            "x³"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            if (cmd.matches("[0-9\\.]")) {
                display.setText(display.getText() + cmd);
            } else if (cmd.matches("[+\\-*/%]")) {
                num1 = Double.parseDouble(display.getText());
                operator = cmd;
                display.setText("");
            } else if (cmd.equals("=")) {
                double num2 = Double.parseDouble(display.getText());
                double result = 0;
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num2 != 0 ? num1 / num2 : 0; break;
                    case "%": result = num1 % num2; break;
                }
                display.setText(String.valueOf(result));
            } else if (cmd.equals("C")) {
                display.setText("");
                num1 = 0;
                operator = "";
            } else if (cmd.equals("√")) {
                double value = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sqrt(value)));
            } else if (cmd.equals("x²")) {
                double value = Double.parseDouble(display.getText());
                display.setText(String.valueOf(value * value));
            } else if (cmd.equals("x³")) {
                double value = Double.parseDouble(display.getText());
                display.setText(String.valueOf(value * value * value));
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}
