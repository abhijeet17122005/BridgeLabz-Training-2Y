public class LibraryManagement {
    static class Book {
        private String title;
        private String author;
        private double price;
        private boolean availability;
        
        public Book() {
            this.title = "Unknown";
            this.author = "Unknown";
            this.price = 0.0;
            this.availability = true;
        }
        
        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.availability = true;
        }
        
        public Book(String title, String author, double price, boolean availability) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.availability = availability;
        }
        
        public boolean borrowBook() {
            if (availability) {
                availability = false;
                System.out.println("Book '" + title + "' has been borrowed successfully.");
                return true;
            } else {
                System.out.println("Sorry, book '" + title + "' is not available.");
                return false;
            }
        }
        
        public void returnBook() {
            availability = true;
            System.out.println("Book '" + title + "' has been returned.");
        }
        
        public void displayBookInfo() {
            System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price + 
                             ", Available: " + (availability ? "Yes" : "No"));
        }
    }
    
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", 12.99);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 14.50);
        
        System.out.println("Initial Status:");
        book1.displayBookInfo();
        book2.displayBookInfo();
        
        System.out.println("\nBorrowing books:");
        book1.borrowBook();
        book1.borrowBook();
        
        System.out.println("\nReturning book:");
        book1.returnBook();
        
        System.out.println("\nFinal Status:");
        book1.displayBookInfo();
        book2.displayBookInfo();
    }
}