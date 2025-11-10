import java.util.*;

class Product {
    String name;
    double price;
    double rating;

    Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price + " | Rating: " + rating;
    }
}

public class ECommerceSort {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Shoes", 1200, 4.5));
        products.add(new Product("Bag", 800, 4.8));
        products.add(new Product("Watch", 2500, 4.2));

        // Sort by price using lambda
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);

        // Sort by rating using lambda
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);
    }
}
