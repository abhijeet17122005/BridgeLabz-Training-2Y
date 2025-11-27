import java.util.*;

public class InventoryManagement {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();

        // 1. Add new products
        stock.put("Soap", 20);
        stock.put("Shampoo", 10);
        stock.put("Toothpaste", 5);

        // 2. Customer buys some items
        buy(stock, "Shampoo", 3);
        buy(stock, "Toothpaste", 5); // goes to zero -> out of stock (we'll remove)
        buy(stock, "Soap", 25); // attempt to buy more than in stock

        // 3. New shipment arrives
        restock(stock, "Toothpaste", 20);
        restock(stock, "Soap", 10);

        // 4. Query a product
        query(stock, "Soap");
        query(stock, "Bread"); // not stocked

        // Print out-of-stock products
        System.out.println("\nOut of stock products:");
        for (Map.Entry<String, Integer> e : stock.entrySet()) {
            if (e.getValue() == 0) System.out.println(e.getKey());
        }
    }

    static void buy(Map<String, Integer> stock, String product, int qty) {
        Integer cur = stock.get(product);
        if (cur == null) {
            System.out.println("Product not stocked: " + product);
            return;
        }
        if (qty >= cur) {
            // remove or set to zero; we'll set to 0 and keep the key
            stock.put(product, 0);
            System.out.println(product + " bought. Now out of stock.");
        } else {
            stock.put(product, cur - qty);
            System.out.println(product + " bought. Remaining: " + (cur - qty));
        }
    }

    static void restock(Map<String, Integer> stock, String product, int qty) {
        stock.put(product, stock.getOrDefault(product, 0) + qty);
        System.out.println(product + " restocked. New qty: " + stock.get(product));
    }

    static void query(Map<String, Integer> stock, String product) {
        if (!stock.containsKey(product)) System.out.println(product + " is not stocked.");
        else System.out.println(product + " -> " + stock.get(product));
    }
}
