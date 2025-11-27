import java.util.*;

public class ECommerceOrderProcessingSystem {
    static class Order {
        final String orderId;
        final String details;
        Order(String id, String d) { orderId = id; details = d; }
        @Override public boolean equals(Object o) {
            return o instanceof Order && ((Order)o).orderId.equals(orderId);
        }
        @Override public int hashCode() { return orderId.hashCode(); }
        @Override public String toString() { return orderId + ":" + details; }
    }

    public static void main(String[] args) {
        // 1. Use List to store placed orders
        List<Order> allOrders = new ArrayList<>();
        allOrders.add(new Order("O1", "Phone"));
        allOrders.add(new Order("O2", "Book"));
        allOrders.add(new Order("O1", "Phone - duplicate"));

        System.out.println("All orders: " + allOrders);

        // 2. Remove duplicates using Set
        Set<Order> uniqueOrders = new LinkedHashSet<>(allOrders); // keep insertion order
        System.out.println("Unique orders: " + uniqueOrders);

        // 3. Use Queue to process FIFO
        Queue<Order> processingQueue = new LinkedList<>(uniqueOrders);
        Stack<Order> failedStack = new Stack<>();

        while (!processingQueue.isEmpty()) {
            Order o = processingQueue.poll();
            System.out.println("Processing " + o);
            // simulate a failure for order O2
            if ("O2".equals(o.orderId)) {
                System.out.println(" -> FAILED: pushing to retry stack");
                failedStack.push(o);
            } else {
                System.out.println(" -> SUCCESS");
            }
        }

        // 4. Re-process failed orders from stack (LIFO)
        System.out.println("Retrying failed orders:");
        while (!failedStack.isEmpty()) {
            Order retry = failedStack.pop();
            System.out.println("Retrying " + retry + " -> SUCCESS");
        }
    }
}
