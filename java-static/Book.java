public class Book {
    private static String libraryName = "City Central Library";

    private final String isbn;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author, String isbn) {
        // use this to initialize
        this.title = title;
        this.author = author;
        this.isbn = isbn; // final
        this.isIssued = false;
    }

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public void issueBook() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    public void displayDetails(Object obj) {
        if (obj instanceof Book) {
            System.out.println("Library: " + Book.libraryName);
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.isbn);
            System.out.println("Issued: " + this.isIssued);
        } else {
            System.out.println("Not a Book instance.");
        }
    }

    public static void main(String[] args) {
        Book.displayLibraryName();
        Book b1 = new Book("Java Fundamentals", "A. Dev", "ISBN-001");
        Book b2 = new Book("Data Structures", "B. Ops", "ISBN-002");

        b1.issueBook();
        b1.displayDetails(b1);
        b2.displayDetails("string");
    }
}
