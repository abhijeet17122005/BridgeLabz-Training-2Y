/**
 * Real-World Q1. Shopping Cart Price Calculation
 * Scenario: You're building a shopping cart for an e-commerce app.
 *           Prices are stored as Strings (e.g., "250", "499", "99").
 * Task: Convert string prices to numeric values using wrapper classes
 *       and calculate the total price.
 * Requirements:
 *  - Use Integer.parseInt()
 *  - Handle invalid prices (e.g., "abc") using try-catch.
 */

public class RW1_ShoppingCartPriceCalculation {

    public static int parsePrice(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            System.out.println("Invalid price skipped: \"" + price + "\"");
            return 0;
        }
    }

    public static void main(String[] args) {
        String[] prices = {"250", "499", "99", "abc", "150"};

        int total = 0;
        System.out.println("Processing cart items:");
        for (String price : prices) {
            int value = parsePrice(price);
            total += value;
            if (value > 0) {
                System.out.println("  Item price: " + value);
            }
        }

        System.out.println("\nTotal Cart Price: Rs." + total);
    }
}

/*
 Expected Output:
 Processing cart items:
   Item price: 250
   Item price: 499
   Item price: 99
 Invalid price skipped: "abc"
   Item price: 150

 Total Cart Price: Rs.998
*/
