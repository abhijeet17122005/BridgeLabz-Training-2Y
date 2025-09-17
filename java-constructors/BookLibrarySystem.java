public class BookLibrarySystem {
    static class Book {
        public String ISBN;
        
        protected String title;
        
        private String author;
        
        public Book(String ISBN, String title, String author) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
        }
        
        public String getAuthor() {
            return author;
        }
        
        public void setAuthor(String author) {
            this.author = author;
            System.out.println("Author updated to: " + author);
        }
        
        public void displayBookInfo() {
            System.out.println("ISBN: " + ISBN + " (public access)");
            System.out.println("Title: " + title + " (protected access)");
            System.out.println("Author: " + author + " (private - accessed internally)");
        }
    }
    
    static class EBook extends Book {
        private String downloadLink;
        private double fileSize;
        
        public EBook(String ISBN, String title, String author, String downloadLink, double fileSize) {
            super(ISBN, title, author);
            this.downloadLink = downloadLink;
            this.fileSize = fileSize;
        }
        
        public void displayEBookDetails() {
            System.out.println("=== E-Book Details ===");
            System.out.println("ISBN: " + ISBN + " (public - inherited and accessible)");
            System.out.println("Title: " + title + " (protected - accessible in subclass)");
            System.out.println("Author: " + getAuthor() + " (private - accessed via public method)");
            System.out.println("Download Link: " + downloadLink);
            System.out.println("File Size: " + fileSize + " MB");
        }
        
        public void updateDownloadInfo(String newLink, double newSize) {
            this.downloadLink = newLink;
            this.fileSize = newSize;
            System.out.println("Download information updated successfully.");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Book Library System ===\n");
        
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        
        System.out.println("Regular Book:");
        book1.displayBookInfo();
        System.out.println("Accessing public ISBN directly: " + book1.ISBN);
        
        System.out.println("\nUpdating author:");
        book1.setAuthor("Joshua Bloch (3rd Edition)");
        
        System.out.println("\n" + "=".repeat(50));
        
        EBook ebook1 = new EBook(
            "978-0135166307", 
            "Clean Code", 
            "Robert C. Martin",
            "https://library.example.com/cleancode.pdf",
            15.2
        );
        
        ebook1.displayEBookDetails();
        
        System.out.println("\nUpdating e-book information:");
        ebook1.setAuthor("Robert C. Martin (Updated)");
        ebook1.updateDownloadInfo("https://library.example.com/cleancode_v2.pdf", 16.8);
        ebook1.displayEBookDetails();
        
        System.out.println("\nDemonstrating direct access to public and protected members:");
        System.out.println("E-book ISBN (public): " + ebook1.ISBN);
    }
}