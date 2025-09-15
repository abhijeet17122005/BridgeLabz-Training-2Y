import java.util.Scanner;
public class SimpleSubstringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        String manualSub = "";
        for (int i = start; i < end; i++) {
            manualSub += text.charAt(i);
        }
        String builtInSub = text.substring(start, end);
        System.out.println("\nManual substring: " + manualSub);
        System.out.println("Built-in substring: " + builtInSub);
        System.out.println("Are they equal? " + manualSub.equals(builtInSub));
        sc.close();
    }
}