import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {
    private final CalculatorOperations operations;

    public ButtonPanel(CalculatorOperations operations) {
        this.operations = operations;
        setLayout(new GridLayout(6, 4, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "+",
                "sin", "cos", "tan", "sqrt", "C",
                "pow", "log", "exp", "="
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(45, 45, 45));
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.addActionListener(this);
            add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        operations.processCommand(command);
    }
}
