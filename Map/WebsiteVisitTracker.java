import java.util.*;
import java.util.stream.*;

public class WebsiteVisitTracker {
    public static void main(String[] args) {
        Map<String, Integer> visits = new HashMap<>();
        String[] pages = {"home","about","products","home","products","contact","home","products","blog","home"};

        for (String p : pages) {
            visits.put(p, visits.getOrDefault(p, 0) + 1);
        }

        // Sort pages by descending visit count
        List<Map.Entry<String, Integer>> sorted = visits.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toList());

        System.out.println("Pages by visits (descending):");
        for (Map.Entry<String, Integer> e : sorted) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // Page with most visits
        Map.Entry<String, Integer> top = sorted.get(0);
        System.out.println("\nTop page: " + top.getKey() + " with " + top.getValue() + " visits.");
    }
}
