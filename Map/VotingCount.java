import java.util.*;

public class VotingCount {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();

        // Simulate 10 votes among 3+ candidates
        String[] votesCast = {
            "Alice","Bob","Alice","Charlie","Bob",
            "Alice","Charlie","Bob","Bob","Alice"
        };

        for (String v : votesCast) {
            votes.put(v, votes.getOrDefault(v, 0) + 1);
        }

        // Print totals
        System.out.println("Vote counts:");
        for (Map.Entry<String, Integer> e : votes.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        // Find winner
        String winner = null;
        int max = -1;
        for (Map.Entry<String, Integer> e : votes.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                winner = e.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " with " + max + " votes.");
    }
}
