import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JButton equalsButton, decimalButton, clearButton;
    JPanel panel;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 450);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 25, 240, 50);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);

        addButton = createButton("+", 120, 100);
        subtractButton = createButton("-", 180, 100);
        multiplyButton = createButton("*", 120, 160);
        divideButton = createButton("/", 180, 160);
        equalsButton = createButton("=", 120, 220);
        decimalButton = createButton(".", 60, 220);
        clearButton = createButton("C", 180, 220);

        addButton.setBackground(Color.GREEN);
        subtractButton.setBackground(Color.GREEN);
        multiplyButton.setBackground(Color.GREEN);
        divideButton.setBackground(Color.GREEN);
        equalsButton.setBackground(Color.ORANGE);
        decimalButton.setBackground(Color.YELLOW);
        clearButton.setBackground(Color.YELLOW);

        panel = new JPanel();
        panel.setBounds(30, 100, 240, 200);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i), 0, 0);
            panel.add(numberButtons[i]);
        }

        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(decimalButton);
        panel.add(clearButton);

        equalsButton.setBounds(110, 310, 120, 50 );
        equalsButton.setFont(new Font("Arial", Font.BOLD, 20));

        frame.add(panel);
        frame.add(textField);
        frame.add(equalsButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subtractButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error: Division by zero");
                        return;
                    }
                    break;
                default:
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
        }
    }

    public JButton createButton(String label, int x, int y) {
        JButton button = new JButton(label);
        button.setBounds(x, y, 60, 60);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.addActionListener(this);
        return button;
    }
}

