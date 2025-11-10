import java.util.*;
import java.util.stream.Collectors;

public class NameUppercase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aryan", "Megha", "Ravi", "Tina");

        // Using map() with method reference
        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());

        System.out.println("Uppercase Names:");
        upperNames.forEach(System.out::println);
    }
}
