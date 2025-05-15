import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StationeryPurchaseSystem extends JFrame implements ActionListener {
    JCheckBox cbNotebook, cbPen, cbPencil;
    JButton orderButton;

    public StationeryPurchaseSystem() {
        setTitle("Stationary Purchase System");
        setSize(300, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cbNotebook = new JCheckBox("Notebook @ 50");
        cbPen = new JCheckBox("Pen @ 30");
        cbPencil = new JCheckBox("Pencil @ 10");

        orderButton = new JButton("Order");
        orderButton.addActionListener(this);

        add(cbNotebook);
        add(cbPen);
        add(cbPencil);
        add(orderButton);
    }

    public void actionPerformed(ActionEvent e) {
        double total = 0.0;
        StringBuilder message = new StringBuilder();

        try {
            if (cbNotebook.isSelected()) {
                String qty = JOptionPane.showInputDialog(this, "Enter Quantity for Notebook");
                int q = Integer.parseInt(qty);
                double cost = q * 50;
                total += cost;
                message.append("Notebook Quantity: ").append(q).append("  Total:").append(cost).append("\n");
            }

            if (cbPen.isSelected()) {
                String qty = JOptionPane.showInputDialog(this, "Enter Quantity for Pen");
                int q = Integer.parseInt(qty);
                double cost = q * 30;
                total += cost;
                message.append("Pen Quantity: ").append(q).append("  Total:").append(cost).append("\n");
            }

            if (cbPencil.isSelected()) {
                String qty = JOptionPane.showInputDialog(this, "Enter Quantity for Pencil");
                int q = Integer.parseInt(qty);
                double cost = q * 10;
                total += cost;
                message.append("Pencil Quantity: ").append(q).append("  Total:").append(cost).append("\n");
            }

            message.append("----------------------\nTotal: ").append(total);
            JOptionPane.showMessageDialog(this, message.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Successfully Ordered.", "Alert", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StationeryPurchaseSystem().setVisible(true));
    }
}
