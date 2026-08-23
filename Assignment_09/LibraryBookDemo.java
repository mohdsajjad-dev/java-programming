
class Book {
    final String isbn; 
    String title;
    String author;
    double price;

    Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class LibraryBookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("ISBN-978-0134685991", "Effective Java", "Joshua Bloch", 799.0);
        b1.display();

        // b1.isbn = "ISBN-000-0000000000"; // uncommenting this line will give compile-time error
    }
}
