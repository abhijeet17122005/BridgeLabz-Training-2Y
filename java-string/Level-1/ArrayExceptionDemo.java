import java.util.Scanner;
public class sArrayExceptionDemo {
    public static void generateException(String[] names) {
        System.out.println("Generating exception...");
        System.out.println("Accessing index 10: " + names[10]);
    }
    public static void handleException(String[] names) {
        System.out.println("Handling exception safely...");
        try {
            System.out.println("Accessing index 10: " + names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        handleException(names);
        scanner.close();
    }
}