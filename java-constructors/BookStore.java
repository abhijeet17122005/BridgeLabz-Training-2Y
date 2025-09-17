public class BookStore {
    static class Book {
        private String title;
        private String author;
        private double price;
        
        public Book() {
            this.title = "Unknown";
            this.author = "Unknown";
            this.price = 0.0;
        }
        
        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }
        
        public void displayBookInfo() {
            System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price);
        }
    }
    
    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book customBook = new Book("The Alchemist", "Paulo Coelho", 15.99);
        
        System.out.println("Default Book:");
        defaultBook.displayBookInfo();
        
        System.out.println("\nCustom Book:");
        customBook.displayBookInfo();
    }
}