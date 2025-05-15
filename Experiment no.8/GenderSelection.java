import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GenderSelection extends JFrame implements ActionListener {
    private JRadioButton maleButton, femaleButton, otherButton;
    private JButton submitButton;
    private JLabel resultLabel;

    public GenderSelection() {
       
        setTitle("Gender Selection");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");

       
        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);
        group.add(otherButton);

       
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        
        resultLabel = new JLabel("Select your gender and click Submit");

       
        setLayout(new FlowLayout());
        add(maleButton);
        add(femaleButton);
        add(otherButton);
        add(submitButton);
        add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gender = "";
        if (maleButton.isSelected()) {
            gender = "Male";
        } else if (femaleButton.isSelected()) {
            gender = "Female";
        } else if (otherButton.isSelected()) {
            gender = "Other";
        } else {
            gender = "No selection";
        }

        resultLabel.setText("You selected: " + gender);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GenderSelection().setVisible(true));
    }
}
