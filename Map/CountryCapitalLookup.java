import java.util.*;

public class CountryCapitalLookup {
    public static void main(String[] args) {
        Map<String, String> capitals = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        // 1. Add at least 8 pairs
        capitals.put("India", "New Delhi");
        capitals.put("Japan", "Tokyo");
        capitals.put("Australia", "Canberra");
        capitals.put("Canada", "Ottawa");
        capitals.put("Brazil", "Brasília");
        capitals.put("France", "Paris");
        capitals.put("Germany", "Berlin");
        capitals.put("Egypt", "Cairo");

        // 2. Lookup sample countries
        lookup(capitals, "India");
        lookup(capitals, "Spain");

        // 3. Print all countries alphabetically
        System.out.println("\nAll countries and capitals (alphabetical):");
        // Because we used TreeMap with CASE_INSENSITIVE_ORDER, iteration is alphabetical ignoring case
        for (Map.Entry<String, String> e : capitals.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    static void lookup(Map<String, String> capitals, String country) {
        String cap = capitals.get(country);
        if (cap == null) System.out.println(country + " -> Unknown country");
        else System.out.println(country + " -> " + cap);
    }
}
