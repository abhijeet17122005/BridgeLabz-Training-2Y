/**
 * Real-World Q4. Bank Transaction Limits
 * Scenario: Your banking app receives daily withdrawal limits as Double objects
 *           (e.g., from a database). Some old accounts still store them as
 *           primitive double values. The limit can be null for some accounts.
 * Task: Write a method that returns the remaining limit.
 *       Handle the case when the limit is null by returning 0.0.
 */

public class RW4_BankTransactionLimits {

    /**
     * Returns the remaining limit after a withdrawal.
     * If the stored limit is null, returns 0.0 (no withdrawal allowed).
     */
    public static double getRemainingLimit(Double dailyLimit, double amountWithdrawn) {
        if (dailyLimit == null) {
            System.out.println("  Limit is null -> defaulting to 0.0");
            return 0.0;
        }
        // auto-unboxing: Double -> double
        double remaining = dailyLimit - amountWithdrawn;
        return remaining < 0 ? 0.0 : remaining;
    }

    public static void main(String[] args) {
        // Normal account with a Double limit
        Double limit1 = 10000.0;
        double withdrawn1 = 3500.0;
        System.out.println("Account 1 remaining limit: " + getRemainingLimit(limit1, withdrawn1));

        // Old account — null limit
        Double limit2 = null;
        double withdrawn2 = 2000.0;
        System.out.println("Account 2 remaining limit: " + getRemainingLimit(limit2, withdrawn2));

        // Withdrawal exceeds limit
        Double limit3 = 5000.0;
        double withdrawn3 = 7000.0;
        System.out.println("Account 3 remaining limit: " + getRemainingLimit(limit3, withdrawn3));
    }
}

/*
 Expected Output:
 Account 1 remaining limit: 6500.0
   Limit is null -> defaulting to 0.0
 Account 2 remaining limit: 0.0
 Account 3 remaining limit: 0.0
*/
