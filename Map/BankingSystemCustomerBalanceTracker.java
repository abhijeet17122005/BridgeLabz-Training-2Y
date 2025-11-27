import java.util.*;
import java.util.stream.*;

public class BankingSystemCustomerBalanceTracker {
    public static void main(String[] args) {
        Map<String, Double> accounts = new HashMap<>();
        accounts.put("ACC1001", 15000.0);
        accounts.put("ACC1002", 50000.0);
        accounts.put("ACC1003", 25000.0);
        accounts.put("ACC1004", 75000.0);
        accounts.put("ACC1005", 12000.0);

        // 1. Add new account
        accounts.put("ACC1006", 30000.0);

        // 2. Deposit and withdrawal
        deposit(accounts, "ACC1001", 5000.0);
        withdraw(accounts, "ACC1005", 15000.0); // exceeds balance

        // 3. Print all customers sorted by descending balance
        System.out.println("Customers sorted by descending balance:");
        List<Map.Entry<String, Double>> sorted = accounts.entrySet()
            .stream()
            .sorted((a,b) -> Double.compare(b.getValue(), a.getValue()))
            .collect(Collectors.toList());
        for (Map.Entry<String, Double> e : sorted) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // 4. Top 3 customers
        System.out.println("\nTop 3 customers:");
        for (int i = 0; i < Math.min(3, sorted.size()); i++) {
            System.out.println(sorted.get(i).getKey() + " -> " + sorted.get(i).getValue());
        }
    }

    static void deposit(Map<String, Double> acc, String id, double amt) {
        acc.put(id, acc.getOrDefault(id, 0.0) + amt);
        System.out.println("Deposited " + amt + " to " + id + ". New balance: " + acc.get(id));
    }

    static void withdraw(Map<String, Double> acc, String id, double amt) {
        if (!acc.containsKey(id)) {
            System.out.println("Account not found: " + id);
            return;
        }
        double bal = acc.get(id);
        if (amt > bal) {
            System.out.println("Insufficient funds for " + id + ". Withdrawal declined.");
        } else {
            acc.put(id, bal - amt);
            System.out.println("Withdrew " + amt + " from " + id + ". New balance: " + acc.get(id));
        }
    }
}
