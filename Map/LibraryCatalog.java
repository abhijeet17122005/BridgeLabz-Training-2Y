import java.util.*;

public class LibraryCatalog {
    public static void main(String[] args) {
        Map<String, String> catalog = new TreeMap<>(); // sorted by ISBN

        // 1. Add several books
        catalog.put("978-1111111111", "Intro to Java");
        catalog.put("978-2222222222", "Data Structures");
        catalog.put("978-3333333333", "Algorithms Unlocked");

        // 2. Search by ISBN
        searchByISBN(catalog, "978-2222222222");
        searchByISBN(catalog, "978-9999999999");

        // 3. Remove a book
        catalog.remove("978-1111111111");

        // 4. Print all ISBNs + titles sorted by ISBN
        System.out.println("\nCatalog (sorted by ISBN):");
        for (Map.Entry<String, String> e : catalog.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // Extended: search by title (iterate map)
        System.out.println("\nSearch by title 'Algorithms':");
        searchByTitle(catalog, "Algorithms");
    }

    static void searchByISBN(Map<String, String> c, String isbn) {
        if (c.containsKey(isbn)) System.out.println(isbn + " -> " + c.get(isbn));
        else System.out.println("Book not found for ISBN: " + isbn);
    }

    static void searchByTitle(Map<String, String> c, String query) {
        boolean found = false;
        for (Map.Entry<String, String> e : c.entrySet()) {
            if (e.getValue().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(e.getKey() + " -> " + e.getValue());
                found = true;
            }
        }
        if (!found) System.out.println("No books found with title containing: " + query);
    }
}
