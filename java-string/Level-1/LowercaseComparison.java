import java.util.Scanner;
public class LowercaseComparison {
    public static String convertToLowercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your text: ");
        String input = scanner.nextLine();
        String builtInLower = input.toLowerCase();
        String manualLower = convertToLowercase(input);
        boolean isEqual = compareStrings(builtInLower, manualLower);
        System.out.println("Built-in toLowerCase(): " + builtInLower);
        System.out.println("Manual conversion:     " + manualLower);
        System.out.println("Are both equal? " + isEqual);
        scanner.close();
    }
}