import javax.swing.JTextField;

public class CalculatorOperations {
    private final JTextField display;
    private double currentResult;
    private String currentOperator;
    private boolean isOperatorPressed;

    public CalculatorOperations(JTextField display) {
        this.display = display;
        this.currentResult = 0;
        this.currentOperator = "";
        this.isOperatorPressed = false;
    }

    public void processCommand(String command) {
        if ("0123456789.".contains(command)) {
            if (isOperatorPressed) {
                display.setText(command);
                isOperatorPressed = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if ("+-*/".contains(command)) {
            performOperation();
            currentOperator = command;
            isOperatorPressed = true;
        } else if ("=".equals(command)) {
            performOperation();
            currentOperator = "";
        } else if ("C".equals(command)) {
            display.setText("");
            currentResult = 0;
            currentOperator = "";
        } else {
            performAdvancedOperation(command);
        }
    }

    private void performOperation() {
        double displayValue = Double.parseDouble(display.getText());
        switch (currentOperator) {
            case "+" -> currentResult += displayValue;
            case "-" -> currentResult -= displayValue;
            case "*" -> currentResult *= displayValue;
            case "/" -> currentResult /= displayValue;
            default -> currentResult = displayValue;
        }
        display.setText(String.valueOf(currentResult));
    }

    private void performAdvancedOperation(String operation) {
        double displayValue = Double.parseDouble(display.getText());
        switch (operation) {
            case "sin" -> displayValue = Math.sin(Math.toRadians(displayValue));
            case "cos" -> displayValue = Math.cos(Math.toRadians(displayValue));
            case "tan" -> displayValue = Math.tan(Math.toRadians(displayValue));
            case "sqrt" -> displayValue = Math.sqrt(displayValue);
            case "pow" -> displayValue = Math.pow(currentResult, displayValue);
            case "log" -> displayValue = Math.log(displayValue);
            case "exp" -> displayValue = Math.exp(displayValue);
        }
        display.setText(String.valueOf(displayValue));
    }
}
