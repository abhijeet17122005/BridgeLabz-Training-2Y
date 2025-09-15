import java.util.Scanner;
public class CharArrayCompare {
    public static char[] getCharsManually(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        char[] manualChars = getCharsManually(input);
        char[] builtInChars = input.toCharArray();
        boolean areEqual = compareCharArrays(manualChars, builtInChars);
        System.out.println("\nManual character array:");
        for (char c : manualChars) {
            System.out.print(c + " ");
        }
        System.out.println("\nBuilt-in toCharArray():");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }
        System.out.println("\n\nAre both arrays equal? " + areEqual);
        sc.close();
    }
}