import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * InsurancePolicyManagementSystem
 *
 * Demonstrates:
 * - HashSet for fast lookups
 * - LinkedHashSet for insertion-order preservation
 * - TreeSet for sorting by expiry date
 * - retrieval methods (all, expiring soon, by coverage)
 * - duplicate detection by policy number
 * - simple performance comparison (add/remove/contains)
 */
public class InsurancePolicyManagementSystem {

    // Simple Policy class - equality & hashing based on policyNumber
    public static class Policy {
        private final String policyNumber; // unique identifier
        private final String policyholderName;
        private final LocalDate expiryDate;
        private final String coverageType; // e.g., Health, Auto, Home
        private final double premiumAmount;

        public Policy(String policyNumber, String policyholderName,
                      LocalDate expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() { return policyNumber; }
        public String getPolicyholderName() { return policyholderName; }
        public LocalDate getExpiryDate() { return expiryDate; }
        public String getCoverageType() { return coverageType; }
        public double getPremiumAmount() { return premiumAmount; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Policy)) return false;
            Policy p = (Policy) o;
            return Objects.equals(policyNumber, p.policyNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber);
        }

        @Override
        public String toString() {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return String.format("%s | %s | %s | %s | %.2f",
                    policyNumber, policyholderName, expiryDate.format(f), coverageType, premiumAmount);
        }
    }

    // Manager that holds 3 different sets for the different use-cases
    public static class PolicyManager {
        // HashSet for quick lookups (no ordering)
        private final Set<Policy> hashSet = new HashSet<>();

        // LinkedHashSet to preserve insertion order
        private final Set<Policy> linkedHashSet = new LinkedHashSet<>();

        // TreeSet to keep policies sorted by expiry date (earliest first).
        // TreeSet comparator compares expiryDate then policyNumber (to avoid treating distinct policies as equal when expiry the same).
        private final Set<Policy> treeSet = new TreeSet<>(Comparator
                .comparing(Policy::getExpiryDate)
                .thenComparing(Policy::getPolicyNumber));

        // Add policy to all sets. Because equals/hashCode are based on policyNumber, duplicates by policyNumber
        // will be ignored when adding to sets.
        public void addPolicy(Policy p) {
            hashSet.add(p);
            linkedHashSet.add(p);
            treeSet.add(p);
        }

        public void removePolicy(Policy p) {
            hashSet.remove(p);
            linkedHashSet.remove(p);
            treeSet.remove(p);
        }

        // Get all unique policies (from HashSet)
        public Set<Policy> getAllUniquePolicies() {
            return new HashSet<>(hashSet);
        }

        // Policies expiring within 'days' from today (inclusive)
        public List<Policy> getPoliciesExpiringWithinDays(int days) {
            LocalDate today = LocalDate.now();
            LocalDate cutoff = today.plusDays(days);
            List<Policy> result = new ArrayList<>();
            // iterate treeSet is efficient if many old->new sorted by expiry; but any set works
            for (Policy p : treeSet) {
                if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(cutoff)) {
                    result.add(p);
                } else if (p.getExpiryDate().isAfter(cutoff)) {
                    // because treeSet is sorted by expiry date, once we pass cutoff we can stop iterating
                    break;
                }
            }
            return result;
        }

        // Policies with a specific coverage type (case-insensitive)
        public List<Policy> getPoliciesByCoverageType(String coverageType) {
            List<Policy> result = new ArrayList<>();
            for (Policy p : hashSet) {
                if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                    result.add(p);
                }
            }
            return result;
        }

        // Detect duplicate policies by policy number from a provided collection of policies.
        // Returns a set of policy numbers that appear more than once.
        public static Set<String> findDuplicatePolicyNumbers(Collection<Policy> policies) {
            Map<String, Integer> count = new HashMap<>();
            for (Policy p : policies) {
                count.put(p.getPolicyNumber(), count.getOrDefault(p.getPolicyNumber(), 0) + 1);
            }
            Set<String> duplicates = new HashSet<>();
            for (Map.Entry<String, Integer> e : count.entrySet()) {
                if (e.getValue() > 1) duplicates.add(e.getKey());
            }
            return duplicates;
        }

        // Simple performance comparison: add / contains / remove for each set type.
        // This runs timing tests on many random generated policies and prints elapsed ms.
        public static void performanceComparison(int n) {
            System.out.println("\n=== Performance comparison with " + n + " policies ===");
            // create n unique random policies
            List<Policy> policies = new ArrayList<>(n);
            LocalDate base = LocalDate.now().minusDays(365);
            Random r = new Random(12345);

            for (int i = 0; i < n; i++) {
                String id = "P" + (100000 + i); // unique ids
                LocalDate expiry = base.plusDays(r.nextInt(1000)); // random future/past within ~3 years
                policies.add(new Policy(id, "Holder" + i, expiry, i % 3 == 0 ? "Health" : (i % 3 == 1 ? "Auto" : "Home"), 1000 + r.nextDouble() * 2000));
            }

            // Prepare containers
            Set<Policy> hs = new HashSet<>();
            Set<Policy> lhs = new LinkedHashSet<>();
            Set<Policy> ts = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate).thenComparing(Policy::getPolicyNumber));

            // Measure add
            long t0 = System.nanoTime();
            for (Policy p : policies) hs.add(p);
            long t1 = System.nanoTime();
            for (Policy p : policies) lhs.add(p);
            long t2 = System.nanoTime();
            for (Policy p : policies) ts.add(p);
            long t3 = System.nanoTime();

            System.out.println("Add time (ms): HashSet=" + (t1 - t0) / 1_000_000.0
                    + " LinkedHashSet=" + (t2 - t1) / 1_000_000.0
                    + " TreeSet=" + (t3 - t2) / 1_000_000.0);

            // Measure contains (search)
            long tc0 = System.nanoTime();
            for (Policy p : policies) hs.contains(p);
            long tc1 = System.nanoTime();
            for (Policy p : policies) lhs.contains(p);
            long tc2 = System.nanoTime();
            for (Policy p : policies) ts.contains(p);
            long tc3 = System.nanoTime();

            System.out.println("Contains time (ms): HashSet=" + (tc1 - tc0) / 1_000_000.0
                    + " LinkedHashSet=" + (tc2 - tc1) / 1_000_000.0
                    + " TreeSet=" + (tc3 - tc2) / 1_000_000.0);

            // Measure remove
            long tr0 = System.nanoTime();
            for (Policy p : policies) hs.remove(p);
            long tr1 = System.nanoTime();
            for (Policy p : policies) lhs.remove(p);
            long tr2 = System.nanoTime();
            for (Policy p : policies) ts.remove(p);
            long tr3 = System.nanoTime();

            System.out.println("Remove time (ms): HashSet=" + (tr1 - tr0) / 1_000_000.0
                    + " LinkedHashSet=" + (tr2 - tr1) / 1_000_000.0
                    + " TreeSet=" + (tr3 - tr2) / 1_000_000.0);

            System.out.println("Note: Times vary by machine and data; TreeSet is slower due to sorting (log n ops).");
        }
    }

    // Demo usage
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Sample policies (some purposely duplicate policy numbers to demonstrate duplicate detection)
        List<Policy> sample = Arrays.asList(
                new Policy("POL1001", "John Doe", LocalDate.now().plusDays(10), "Auto", 1200.00),
                new Policy("POL1002", "Alice Smith", LocalDate.now().plusDays(40), "Health", 900.50),
                new Policy("POL1003", "Bob Lee", LocalDate.now().plusDays(5), "Home", 450.75),
                new Policy("POL1004", "Sana Khan", LocalDate.now().plusDays(29), "Auto", 1300.00),
                new Policy("POL1005", "Ravi Patel", LocalDate.now().plusDays(60), "Health", 1100.25),
                // duplicates:
                new Policy("POL1003", "Bob Lee Duplicate", LocalDate.now().plusDays(5), "Home", 450.75),
                new Policy("POL1001", "John Doe Duplicate", LocalDate.now().plusDays(10), "Auto", 1200.00)
        );

        // Add to manager (adds into all three internal sets)
        for (Policy p : sample) manager.addPolicy(p);

        System.out.println("All unique policies (from HashSet):");
        manager.getAllUniquePolicies().forEach(System.out::println);

        System.out.println("\nPolicies expiring within 30 days:");
        List<Policy> soon = manager.getPoliciesExpiringWithinDays(30);
        if (soon.isEmpty()) {
            System.out.println("None.");
        } else {
            soon.forEach(System.out::println);
        }

        System.out.println("\nPolicies with coverage type 'Auto':");
        manager.getPoliciesByCoverageType("Auto").forEach(System.out::println);

        // Detect duplicate policy numbers among the sample list (the raw input list may contain duplicates)
        Set<String> duplicates = PolicyManager.findDuplicatePolicyNumbers(sample);
        System.out.println("\nDuplicate policy numbers in the provided list: " + duplicates);

        // Demonstrate TreeSet ordering (sorted by expiry date)
        System.out.println("\nPolicies sorted by expiry date (TreeSet):");
        for (Policy p : manager.treeSet) {
            System.out.println(p);
        }

        // Simple performance comparison (tweak n if you want faster/slower test)
        PolicyManager.performanceComparison(10000); // 10k entries test
    }
}
