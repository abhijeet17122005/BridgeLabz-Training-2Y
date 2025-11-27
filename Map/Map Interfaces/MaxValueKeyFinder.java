import java.util.*;

public class MaxValueKeyFinder {
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) return null;

        String maxKey = null;
        int maxVal = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            int v = e.getValue();
            if (maxKey == null || v > maxVal) {
                maxVal = v;
                maxKey = e.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        m.put("A", 10);
        m.put("B", 20);
        m.put("C", 15);

        String result = findKeyWithMaxValue(m);
        System.out.println(result); // prints: B
    }
}
