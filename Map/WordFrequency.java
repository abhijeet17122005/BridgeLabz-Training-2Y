import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String sentence = "Java is fun, and Java is powerful!";
        // Normalize: lower case, remove punctuation (simple)
        String cleaned = sentence.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            if (w.isEmpty()) continue;
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
