import java.util.Scanner;
public class UppercaseComparison {
    public static String convertToUppercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
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
        String builtInUpper = input.toUpperCase();
        String manualUpper = convertToUppercase(input);
        boolean isEqual = compareStrings(builtInUpper, manualUpper);
        System.out.println("Built-in toUpperCase(): " + builtInUpper);
        System.out.println("Manual conversion:     " + manualUpper);
        System.out.println("Are both equal? " + isEqual);
        scanner.close();
    }
}