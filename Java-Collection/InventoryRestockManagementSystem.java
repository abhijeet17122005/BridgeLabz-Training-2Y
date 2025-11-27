import java.util.*;

public class InventoryRestockManagementSystem {
    static class Product {
        final String name;
        double price;
        int stock;
        Product(String n, double p, int s){ name=n; price=p; stock=s; }
        @Override public String toString(){ return name + "(stock=" + stock + ")"; }
    }

    public static void main(String[] args) {
        Set<String> productNames = new HashSet<>();
        List<Product> products = new ArrayList<>();
        Queue<Product> restockQueue = new LinkedList<>();
        Stack<Product> restockedStack = new Stack<>();

        // add products (avoid duplicates)
        addProduct("Milk", 2.0, 5, productNames, products);
        addProduct("Bread", 1.5, 2, productNames, products);
        addProduct("Milk", 2.0, 5, productNames, products); // ignored

        // identify low-stock (threshold 3)
        for (Product p : products) {
            if (p.stock < 3) restockQueue.add(p);
        }

        // process restock queue
        while (!restockQueue.isEmpty()) {
            Product p = restockQueue.poll();
            System.out.println("Restocking " + p.name);
            p.stock += 10; // restock
            restockedStack.push(p);
        }

        // undo last restock
        if (!restockedStack.isEmpty()) {
            Product undone = restockedStack.pop();
            System.out.println("Undo restock for " + undone.name);
            undone.stock -= 10;
        }

        System.out.println("Products final: " + products);
    }

    static void addProduct(String name, double price, int stock, Set<String> names, List<Product> list) {
        if (names.add(name)) {
            list.add(new Product(name, price, stock));
        } else {
            System.out.println("Product " + name + " already exists. Skipping.");
        }
    }
}
