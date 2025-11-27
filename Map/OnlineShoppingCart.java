import java.util.*;

public class OnlineShoppingCart {
    public static void main(String[] args) {
        // LinkedHashMap preserves insertion order
        Map<String, Double> cart = new LinkedHashMap<>();
        Map<String, Integer> qty = new LinkedHashMap<>(); // track quantities

        // 1. Add products in the order they are added to cart
        addItem(cart, qty, "Laptop", 35000.0, 1);
        addItem(cart, qty, "Mouse", 500.0, 2);
        addItem(cart, qty, "Headphones", 1200.0, 1);

        // 2. Display products in order of addition
        System.out.println("Cart items (in insertion order):");
        for (String p : cart.keySet()) {
            System.out.println(p + " x" + qty.get(p) + " -> ₹" + cart.get(p));
        }

        // 3. Calculate total bill
        double total = 0;
        for (String p : cart.keySet()) total += cart.get(p) * qty.get(p);
        System.out.println("\nTotal: ₹" + total);

        // 4. Apply 10% discount if total > 5000
        if (total > 5000) {
            total = total * 0.9;
            System.out.println("Discount applied. New total: ₹" + total);
        }

        // 5. Remove item if quantity becomes zero (simulate removing Mouse)
        removeItem(cart, qty, "Mouse");
        System.out.println("\nAfter removing Mouse:");
        for (String p : cart.keySet()) System.out.println(p + " x" + qty.get(p));
    }

    static void addItem(Map<String, Double> cart, Map<String, Integer> qty, String name, double price, int q) {
        cart.putIfAbsent(name, price);
        qty.put(name, qty.getOrDefault(name, 0) + q);
    }

    static void removeItem(Map<String, Double> cart, Map<String, Integer> qty, String name) {
        qty.remove(name);
        cart.remove(name);
    }
}
