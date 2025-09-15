import java.util.Scanner;
public class NumberFormatDemo {
    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Input is not a valid number");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number as text: ");
        String input = sc.next();
        System.out.println("\n=== Generating Exception ===");
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }
        System.out.println("\n=== Handling Exception ===");
        handleException(input);
        sc.close();
    }
}