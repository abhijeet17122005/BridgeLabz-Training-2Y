import java.util.ArrayList;
import java.util.List;

// ---------- Class: Product ----------
class Product {
    String productName;
    double quantity; // e.g., 2 kg or 1 liter
    double pricePerUnit;

    public Product(String productName, double quantity, double pricePerUnit) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }
}

// ---------- Class: Customer ----------
class Customer {
    String name;
    List<Product> products; // Composition: Customer owns Products

    public Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

// ---------- Class: BillGenerator ----------
class BillGenerator {
    // Association: BillGenerator calculates total for Customer
    public double generateBill(Customer customer) {
        double total = 0;
        for (Product p : customer.getProducts()) {
            total += p.getTotalPrice();
        }
        return total;
    }
}

// ---------- Main Class ----------
public class GroceryStoreApp {
    public static void main(String[] args) {

        // Object Diagram snapshot
        Customer alice = new Customer("Alice"); // Customer object
        alice.buyProduct(new Product("Apples", 2, 3)); // 2 kg at $3/kg
        alice.buyProduct(new Product("Milk", 1, 2));   // 1 liter at $2/liter

        // Sequence Diagram interaction
        BillGenerator billGen = new BillGenerator(); // Actor: BillGenerator
        double totalBill = billGen.generateBill(alice); // Customer checks out

        // Output bill details
        System.out.println("Customer: " + alice.name);
        for (Product p : alice.getProducts()) {
            System.out.println(p.productName + " (" + p.quantity + " units at $" + p.pricePerUnit + " per unit) = $" + p.getTotalPrice());
        }
        System.out.println("Total Bill: $" + totalBill);
    }
}
