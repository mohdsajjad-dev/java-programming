import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class BookIssueTrackingGUI extends JFrame {
    private final Connection con;
    private final JTextField issueIdField = new JTextField();
    private final JTextField bookIdField = new JTextField();
    private final JTextField studentField = new JTextField();
    private final JTextField issueDateField = new JTextField();
    private final JTextField returnDateField = new JTextField();
    private final DefaultTableModel model = new DefaultTableModel(
        new String[]{"Issue ID", "Book ID", "Student Name", "Issue Date", "Return Date"}, 0) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(model);
 
    public BookIssueTrackingGUI(Connection con) {
        this.con = con;
        setTitle("Book Issue Tracking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 620);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
 
        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Book Issue Details"));
        form.add(new JLabel("Issue ID (for update/delete):"));
        form.add(issueIdField);
        form.add(new JLabel("Book ID:"));
        form.add(bookIdField);
        form.add(new JLabel("Student Name:"));
        form.add(studentField);
        form.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        form.add(issueDateField);
        form.add(new JLabel("Return Date (YYYY-MM-DD, optional):"));
        form.add(returnDateField);
 
        JButton addButton = new JButton("Add Issue");
        JButton viewButton = new JButton("View Records");
        JButton updateButton = new JButton("Update Record");
        JButton deleteButton = new JButton("Delete Record");
        JButton clearButton = new JButton("Clear");
        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(updateButton);
        buttons.add(deleteButton);
        buttons.add(clearButton);
 
        JPanel top = new JPanel(new BorderLayout(5, 5));
        top.setBorder(BorderFactory.createEmptyBorder(5, 8, 0, 8));
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
 
        addButton.addActionListener(e -> addIssue());
        viewButton.addActionListener(e -> loadIssues());
        updateButton.addActionListener(e -> updateIssue());
        deleteButton.addActionListener(e -> deleteIssue());
        clearButton.addActionListener(e -> clearFields());
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() >= 0) {
                int row = table.getSelectedRow();
                issueIdField.setText(model.getValueAt(row, 0).toString());
                bookIdField.setText(model.getValueAt(row, 1).toString());
                studentField.setText(model.getValueAt(row, 2).toString());
                issueDateField.setText(model.getValueAt(row, 3).toString());
                Object returnDate = model.getValueAt(row, 4);
                returnDateField.setText(returnDate == null ? "" : returnDate.toString());
            }
        });
        loadIssues();
    }
 
    private Date readDate(String value, boolean optional) {
        String text = value.trim();
        if (text.isEmpty() && optional) return null;
        return Date.valueOf(text);
    }
 
    private boolean fieldsAreValid() {
        if (bookIdField.getText().trim().isEmpty() || studentField.getText().trim().isEmpty()
            || issueDateField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book ID, student name, and issue date are required.");
            return false;
        }
        return true;
    }
 
    private void addIssue() {
        if (!fieldsAreValid()) return;
        String query = "INSERT INTO book_issues (book_id, student_name, issue_date, return_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, Integer.parseInt(bookIdField.getText().trim()));
            ps.setString(2, studentField.getText().trim());
            ps.setDate(3, readDate(issueDateField.getText(), false));
            Date returnDate = readDate(returnDateField.getText(), true);
            if (returnDate == null) ps.setNull(4, Types.DATE);
            else ps.setDate(4, returnDate);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book issue record added successfully.");
            loadIssues();
            clearFields();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Use dates in YYYY-MM-DD format and enter a valid Book ID.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
 
    private void loadIssues() {
        String query = "SELECT issue_id, book_id, student_name, issue_date, return_date FROM book_issues ORDER BY issue_id";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("issue_id"), rs.getInt("book_id"),
                    rs.getString("student_name"), rs.getDate("issue_date"), rs.getDate("return_date")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
 
    private void updateIssue() {
        if (!fieldsAreValid()) return;
        String query = "UPDATE book_issues SET book_id = ?, student_name = ?, issue_date = ?, return_date = ? WHERE issue_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, Integer.parseInt(bookIdField.getText().trim()));
            ps.setString(2, studentField.getText().trim());
            ps.setDate(3, readDate(issueDateField.getText(), false));
            Date returnDate = readDate(returnDateField.getText(), true);
            if (returnDate == null) ps.setNull(4, Types.DATE);
            else ps.setDate(4, returnDate);
            ps.setInt(5, Integer.parseInt(issueIdField.getText().trim()));
            int rows = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, rows > 0 ? "Issue record updated successfully." : "Issue ID not found.");
            loadIssues();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Use dates in YYYY-MM-DD format and enter valid IDs.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
 
    private void deleteIssue() {
        try {
            int issueId = Integer.parseInt(issueIdField.getText().trim());
            String query = "DELETE FROM book_issues WHERE issue_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, issueId);
                int rows = ps.executeUpdate();
                JOptionPane.showMessageDialog(this, rows > 0 ? "Issue record deleted successfully." : "Issue ID not found.");
                loadIssues();
                clearFields();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid Issue ID to delete.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
 
    private void clearFields() {
        issueIdField.setText("");
        bookIdField.setText("");
        studentField.setText("");
        issueDateField.setText("");
        returnDateField.setText("");
        table.clearSelection();
    }
 
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_management",
                "root",
                "Mohdsajjad#07"
            );
            SwingUtilities.invokeLater(() -> new BookIssueTrackingGUI(con).setVisible(true));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Connection Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
