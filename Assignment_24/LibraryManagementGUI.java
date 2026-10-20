import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class LibraryManagementGUI extends JFrame {
    private final Connection con;
    private final JTextField idField = new JTextField();
    private final JTextField titleField = new JTextField();
    private final JTextField authorField = new JTextField();
    private final JTextField categoryField = new JTextField();
    private final JTextField quantityField = new JTextField();
    private final DefaultTableModel model = new DefaultTableModel(
        new String[]{"Book ID", "Title", "Author", "Category", "Quantity"}, 0) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(model);
 
    public LibraryManagementGUI(Connection con) {
        this.con = con;
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
 
        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Book Details"));
        form.add(new JLabel("Book ID:"));
        form.add(idField);
        form.add(new JLabel("Title:"));
        form.add(titleField);
        form.add(new JLabel("Author:"));
        form.add(authorField);
        form.add(new JLabel("Category:"));
        form.add(categoryField);
        form.add(new JLabel("Quantity:"));
        form.add(quantityField);
 
        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        JButton updateButton = new JButton("Update Book");
        JButton deleteButton = new JButton("Delete Book");
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
 
        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> loadBooks());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        clearButton.addActionListener(e -> clearFields());
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() >= 0) {
                int row = table.getSelectedRow();
                idField.setText(model.getValueAt(row, 0).toString());
                titleField.setText(model.getValueAt(row, 1).toString());
                authorField.setText(model.getValueAt(row, 2).toString());
                categoryField.setText(model.getValueAt(row, 3).toString());
                quantityField.setText(model.getValueAt(row, 4).toString());
            }
        });
        loadBooks();
    }
 
    private boolean fieldsAreValid() {
        if (idField.getText().trim().isEmpty() || titleField.getText().trim().isEmpty()
            || authorField.getText().trim().isEmpty() || categoryField.getText().trim().isEmpty()
            || quantityField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all book details.");
            return false;
        }
        return true;
    }
 
    private void addBook() {
        if (!fieldsAreValid()) return;
        String query = "INSERT INTO books (book_id, title, author, category, quantity) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, Integer.parseInt(idField.getText().trim()));
            ps.setString(2, titleField.getText().trim());
            ps.setString(3, authorField.getText().trim());
            ps.setString(4, categoryField.getText().trim());
            ps.setInt(5, Integer.parseInt(quantityField.getText().trim()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book added successfully.");
            loadBooks();
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Book ID and quantity must be integers.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
 
    private void loadBooks() {
        String query = "SELECT book_id, title, author, category, quantity FROM books ORDER BY book_id";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("book_id"), rs.getString("title"),
                    rs.getString("author"), rs.getString("category"), rs.getInt("quantity")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
 
    private void updateBook() {
        if (!fieldsAreValid()) return;
        String query = "UPDATE books SET title = ?, author = ?, category = ?, quantity = ? WHERE book_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, titleField.getText().trim());
            ps.setString(2, authorField.getText().trim());
            ps.setString(3, categoryField.getText().trim());
            ps.setInt(4, Integer.parseInt(quantityField.getText().trim()));
            ps.setInt(5, Integer.parseInt(idField.getText().trim()));
            int rows = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, rows > 0 ? "Book updated successfully." : "Book ID not found.");
            loadBooks();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Book ID and quantity must be integers.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
 
    private void deleteBook() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String query = "DELETE FROM books WHERE book_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                JOptionPane.showMessageDialog(this, rows > 0 ? "Book deleted successfully." : "Book ID not found.");
                loadBooks();
                clearFields();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid Book ID to delete.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
 
    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        categoryField.setText("");
        quantityField.setText("");
        table.clearSelection();
    }
 
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_management",
                "root",
                "Mohdsajjad#07"
            );
            SwingUtilities.invokeLater(() -> new LibraryManagementGUI(con).setVisible(true));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Connection Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
