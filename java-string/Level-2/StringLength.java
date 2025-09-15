import java.util.Scanner;
public class StringLength {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        int customLength = getLength(input);
        int builtInLength = input.length();
        System.out.println("Custom Length: " + customLength);
        System.out.println("Built-in Length: " + builtInLength);
    }
}