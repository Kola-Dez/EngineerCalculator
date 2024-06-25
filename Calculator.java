import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator extends JFrame {
    private final CalculatorOperations operations;

    public Calculator() {
        setTitle("EngineerCalculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 32));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setForeground(Color.BLACK);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        operations = new CalculatorOperations(display);

        ButtonPanel buttonPanel = new ButtonPanel(operations);
        add(buttonPanel, BorderLayout.CENTER);

        display.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar) || keyChar == '.') {
                    operations.processCommand(String.valueOf(keyChar));
                } else if ("+-*/".indexOf(keyChar) != -1) {
                    operations.processCommand(String.valueOf(keyChar));
                } else if (keyChar == '\n' || keyChar == '=') {
                    operations.processCommand("=");
                } else if (keyChar == '\b') {
                    operations.processCommand("C");
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    operations.processCommand("sin");
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    operations.processCommand("cos");
                } else if (e.getKeyCode() == KeyEvent.VK_T) {
                    operations.processCommand("tan");
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                    operations.processCommand("sqrt");
                } else if (e.getKeyCode() == KeyEvent.VK_P) {
                    operations.processCommand("pow");
                } else if (e.getKeyCode() == KeyEvent.VK_L) {
                    operations.processCommand("log");
                } else if (e.getKeyCode() == KeyEvent.VK_E) {
                    operations.processCommand("exp");
                }
            }
        });
        display.requestFocusInWindow();
        setLocationRelativeTo(null);
    }
}
