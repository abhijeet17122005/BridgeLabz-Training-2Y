public class ProductInventory {
    static class Product {
        private String productName;
        private double price;
        
        private static int totalProducts = 0;
        
        public Product(String productName, double price) {
            this.productName = productName;
            this.price = price;
            totalProducts++;
        }
        
        public void displayProductDetails() {
            System.out.println("Product Name: " + productName + ", Price: $" + price);
        }
        
        public static void displayTotalProducts() {
            System.out.println("Total products created: " + totalProducts);
        }
        
        public String getProductName() {
            return productName;
        }
        
        public double getPrice() {
            return price;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Product Inventory Management ===\n");
        
        Product.displayTotalProducts();
        
        Product laptop = new Product("Dell Laptop", 899.99);
        Product mouse = new Product("Wireless Mouse", 25.50);
        Product keyboard = new Product("Mechanical Keyboard", 75.00);
        
        System.out.println("\nProduct Details:");
        laptop.displayProductDetails();
        mouse.displayProductDetails();
        keyboard.displayProductDetails();
        
        System.out.println();
        Product.displayTotalProducts();
        
        Product monitor = new Product("4K Monitor", 299.99);
        Product webcam = new Product("HD Webcam", 49.99);
        
        System.out.println("\nAfter adding more products:");
        monitor.displayProductDetails();
        webcam.displayProductDetails();
        
        System.out.println();
        Product.displayTotalProducts();
    }
}