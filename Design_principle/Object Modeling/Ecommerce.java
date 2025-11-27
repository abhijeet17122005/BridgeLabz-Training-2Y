import java.util.ArrayList;

// Product class (independent object)
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void showProduct() {
        System.out.println("- " + name + " ($" + price + ")");
    }
}

// Order class (aggregates products, associated with a customer)
class Order {
    int orderId;
    Customer customer;              // Association with Customer
    ArrayList<Product> products;    // Aggregation with Products

    Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    // Add product to this order
    void addProduct(Product p) {
        products.add(p);
    }

    // Show order details
    void showOrder() {
        System.out.println("Order ID: " + orderId + " placed by " + customer.name);
        System.out.println("Products:");
        for (Product p : products) {
            p.showProduct();
        }
        System.out.println();
    }
}

// Customer class
class Customer {
    String name;
    ArrayList<Order> orders;  // A customer can place many orders

    Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    // Place an order
    Order placeOrder(int orderId) {
        Order newOrder = new Order(orderId, this);
        orders.add(newOrder);
        System.out.println(name + " placed an order (ID: " + orderId + ")");
        return newOrder;
    }

    // Show customer’s orders
    void showOrders() {
        System.out.println("Customer: " + name + " has orders:");
        for (Order o : orders) {
            System.out.println("Order ID: " + o.orderId);
        }
        System.out.println();
    }
}

// Main class to demonstrate
public class EcommerceDemo {
    public static void main(String[] args) {
        // Create products (independent)
        Product p1 = new Product("Laptop", 75000);
        Product p2 = new Product("Headphones", 3000);
        Product p3 = new Product("Smartphone", 40000);

        // Create customer
        Customer c1 = new Customer("Alice");

        // Customer places orders
        Order o1 = c1.placeOrder(101);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = c1.placeOrder(102);
        o2.addProduct(p3);

        // Show orders placed by customer
        c1.showOrders();

        // Show order details
        o1.showOrder();
        o2.showOrder();
    }
}
