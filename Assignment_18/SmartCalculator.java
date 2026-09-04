import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmartCalculator extends JFrame implements ActionListener {

    JTextField firstNumber, secondNumber, answer;
    JButton addBtn, subtractBtn, clearBtn;

    SmartCalculator() {
        setTitle("Mini Calculator");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel(new GridLayout(5, 2, 12, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel heading = new JLabel("ADDITION & SUBTRACTION", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 18));

        add(heading, BorderLayout.NORTH);

        panel.add(new JLabel("Enter First Number:"));
        firstNumber = new JTextField();
        panel.add(firstNumber);

        panel.add(new JLabel("Enter Second Number:"));
        secondNumber = new JTextField();
        panel.add(secondNumber);

        addBtn = new JButton("  ADD  ");
        subtractBtn = new JButton("SUBTRACT");
        clearBtn = new JButton("CLEAR");

        addBtn.addActionListener(this);
        subtractBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        panel.add(addBtn);
        panel.add(subtractBtn);

        panel.add(new JLabel("Result:"));

        answer = new JTextField();
        answer.setEditable(false);
        answer.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(answer);

        panel.add(new JLabel(""));
        panel.add(clearBtn);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearBtn) {
            firstNumber.setText("");
            secondNumber.setText("");
            answer.setText("");
            return;
        }

        try {
            double num1 = Double.parseDouble(firstNumber.getText());
            double num2 = Double.parseDouble(secondNumber.getText());

            if (e.getSource() == addBtn) {
                answer.setText(String.valueOf(num1 + num2));
            }
            else if (e.getSource() == subtractBtn) {
                answer.setText(String.valueOf(num1 - num2));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numbers.",
                "Invalid Input",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new SmartCalculator();
    }
}