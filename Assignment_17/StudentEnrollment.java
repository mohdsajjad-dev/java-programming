import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentEnrollment extends JFrame implements ActionListener {

    JTextField nameField, rollField, courseField;
    JButton registerButton;

    StudentEnrollment() {

        setTitle("Student Registration");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Course:"));
        courseField = new JTextField();
        add(courseField);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        add(registerButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

        String name = nameField.getText();
        String roll = rollField.getText();
        String course = courseField.getText();

        JOptionPane.showMessageDialog(
            this,
            "Student Registered Successfully!\n\n"
            + "Name: " + name
            + "\nRoll Number: " + roll
            + "\nCourse: " + course
        );
    }

    public static void main(String[] args) {
        new StudentEnrollment();
    }
}