public class Product {
    private static double discount = 5.0; // percent shared across all products

    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        // this to initialize
        this.productID = productID; // final
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) discount = newDiscount;
    }

    public double getPriceAfterDiscount() {
        return price * (1 - discount / 100.0);
    }

    public void displayDetails(Object obj) {
        if (obj instanceof Product) {
            System.out.println("Discount(%) : " + Product.discount);
            System.out.println("Product ID: " + this.productID);
            System.out.println("Name: " + this.productName);
            System.out.println("Price: " + this.price);
            System.out.println("Price after discount: " + getPriceAfterDiscount());
            System.out.println("Quantity: " + this.quantity);
        } else {
            System.out.println("Not a Product instance.");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("P001", "Wireless Mouse", 799.0, 10);
        Product p2 = new Product("P002", "Keyboard", 999.0, 5);

        p1.displayDetails(p1);
        Product.updateDiscount(10.0);
        p2.displayDetails(p2);
    }
}
