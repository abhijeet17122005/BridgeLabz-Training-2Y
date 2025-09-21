interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();
}

class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) { super(id, name, price); }
    public double calculateDiscount() { return getPrice() * 0.10; }
    public double calculateTax() { return getPrice() * 0.18; }
    public String getTaxDetails() { return "Electronics Tax: 18%"; }
}

class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) { super(id, name, price); }
    public double calculateDiscount() { return getPrice() * 0.20; }
    public double calculateTax() { return getPrice() * 0.05; }
    public String getTaxDetails() { return "Clothing Tax: 5%"; }
}

class Groceries extends Product implements Taxable {
    public Groceries(int id, String name, double price) { super(id, name, price); }
    public double calculateDiscount() { return getPrice() * 0.05; }
    public double calculateTax() { return getPrice() * 0.02; }
    public String getTaxDetails() { return "Groceries Tax: 2%"; }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics(201, "Laptop", 50000),
            new Clothing(202, "Shirt", 2000),
            new Groceries(203, "Rice", 1000)
        };

        for (Product p : products) {
            double finalPrice = p.getPrice() + ((Taxable)p).calculateTax() - p.calculateDiscount();
            System.out.println(p.getName() + " → Final Price: " + finalPrice);
        }
    }
}
