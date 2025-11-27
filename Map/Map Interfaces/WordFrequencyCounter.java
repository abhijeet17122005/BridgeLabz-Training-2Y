import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java WordFrequencyCounter <path-to-text-file>");
            return;
        }

        Path path = Paths.get(args[0]);
        Map<String, Integer> freq = new HashMap<>();

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                // remove punctuation and convert to lower case
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.isEmpty()) continue;
                    freq.put(w, freq.getOrDefault(w, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // print result
        System.out.println(freq);
    }
}
