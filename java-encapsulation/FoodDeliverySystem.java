interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public String getItemDetails() {
        return itemName + " x" + quantity + " @ " + price;
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) { super(name, price, qty); }
    public double calculateTotalPrice() { return getPrice() * getQuantity(); }
    public double applyDiscount() { return calculateTotalPrice() * 0.05; }
    public String getDiscountDetails() { return "Veg Discount 5%"; }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }
    public double calculateTotalPrice() { return (getPrice() * getQuantity()) + 50; }
    public double applyDiscount() { return calculateTotalPrice() * 0.10; }
    public String getDiscountDetails() { return "Non-Veg Discount 10%"; }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer", 200, 2),
            new NonVegItem("Chicken", 300, 1)
        };

        for (FoodItem item : order) {
            double total = item.calculateTotalPrice();
            double discount = ((Discountable)item).applyDiscount();
            System.out.println(item.getItemDetails() + " → Final Price: " + (total - discount));
        }
    }
}
