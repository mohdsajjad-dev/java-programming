import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffRegistration extends JFrame implements ActionListener {

    JTextField idInput, nameInput, deptInput, salaryInput;
    JButton submitButton;

    StaffRegistration() {

        setTitle("Employee Registration");
        setSize(450, 350);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Employee ID:"));
        idInput = new JTextField();
        add(idInput);

        add(new JLabel("Employee Name:"));
        nameInput = new JTextField();
        add(nameInput);

        add(new JLabel("Department:"));
        deptInput = new JTextField();
        add(deptInput);

        add(new JLabel("Salary:"));
        salaryInput = new JTextField();
        add(salaryInput);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

        String employeeId = idInput.getText();
        String employeeName = nameInput.getText();
        String department = deptInput.getText();
        String salary = salaryInput.getText();

        JOptionPane.showMessageDialog(
            this,
            "Employee Details\n\n"
            + "Employee ID: " + employeeId
            + "\nName: " + employeeName
            + "\nDepartment: " + department
            + "\nSalary: Rs. " + salary
        );
    }

    public static void main(String[] args) {
        new StaffRegistration();
    }
}