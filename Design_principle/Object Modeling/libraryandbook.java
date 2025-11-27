import java.util.ArrayList;

// Book class (independent object)
class Book {
    String title;
    String author;

    // Constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Display book details
    void showBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Library class (aggregates books)
class Library {
    String name;
    ArrayList<Book> books;  // Aggregation: Library HAS-A list of Books

    // Constructor
    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add book to library
    void addBook(Book book) {
        books.add(book);
    }

    // Display library details
    void showLibrary() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.showBook();
        }
        System.out.println();
    }
}

// Main class to demonstrate aggregation
public class AggregationDemo {
    public static void main(String[] args) {
        // Create books (independent of library)
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Clean Code", "Robert C. Martin");

        // Create libraries
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("University Library");

        // Add books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); // Same book in another library
        lib2.addBook(b3);

        // Show library details
        lib1.showLibrary();
        lib2.showLibrary();
    }
}
