import library.Book;

public class LibraryApp {
    public static void main(String[] args) {
        Book b1 = new Book(1001, "Let Us C", "Yashavant Kanetkar", 350.0);
        b1.displayBookInfo();

        System.out.println();

        Book b2 = new Book(1002, "Introduction to Algorithms", "Thomas H. Cormen", 950.0);
        b2.displayBookInfo();
    }
}
