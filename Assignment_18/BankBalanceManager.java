import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceManager extends JFrame implements ActionListener {

    JTextField balanceField, amountField, updatedField;
    JButton depositBtn, withdrawBtn, resetBtn;

    BankBalanceManager() {

        setTitle("Bank Balance Manager");
        setSize(500, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("BANK BALANCE MANAGER", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 10));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 12, 18));
        formPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 40, 15, 40)
        );

        formPanel.add(new JLabel("Initial Balance:"));
        balanceField = new JTextField();
        formPanel.add(balanceField);

        formPanel.add(new JLabel("Transaction Amount:"));
        amountField = new JTextField();
        formPanel.add(amountField);

        formPanel.add(new JLabel("Updated Balance:"));
        updatedField = new JTextField();
        updatedField.setEditable(false);
        updatedField.setFont(new Font("Arial", Font.BOLD, 15));
        formPanel.add(updatedField);

        depositBtn = new JButton("DEPOSIT");
        withdrawBtn = new JButton("WITHDRAW");
        resetBtn = new JButton("RESET");

        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        JPanel buttonPanel = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 15, 10)
        );

        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);
        buttonPanel.add(resetBtn);

        add(title, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetBtn) {
            balanceField.setText("");
            amountField.setText("");
            updatedField.setText("");
            return;
        }

        try {

            double balance =
                Double.parseDouble(balanceField.getText());

            double amount =
                Double.parseDouble(amountField.getText());

            if (balance < 0 || amount <= 0) {
                throw new IllegalArgumentException(
                    "Enter a valid positive amount."
                );
            }

            if (e.getSource() == depositBtn) {

                balance += amount;

                updatedField.setText(
                    String.format("Rs. %.2f", balance)
                );

                JOptionPane.showMessageDialog(
                    this,
                    "Amount deposited successfully!"
                );
            }

            else if (e.getSource() == withdrawBtn) {

                if (amount > balance) {
                    throw new IllegalArgumentException(
                        "Insufficient balance."
                    );
                }

                balance -= amount;

                updatedField.setText(
                    String.format("Rs. %.2f", balance)
                );

                JOptionPane.showMessageDialog(
                    this,
                    "Amount withdrawn successfully!"
                );
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter numeric values.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Transaction Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new BankBalanceManager();
    }
}