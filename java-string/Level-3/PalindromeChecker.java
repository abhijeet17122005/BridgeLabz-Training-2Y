import java.util.Scanner;
public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = getLength(text) - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeUsingArrays(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);
        int length = getLength(text);

        for (int i = 0; i < length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static char[] reverseString(String text) {
        int length = getLength(text);
        char[] reversed = new char[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = text.charAt(length - 1 - i);
        }
        return reversed;
    }

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result1 = isPalindromeIterative(input);
        boolean result2 = isPalindromeRecursive(input, 0, getLength(input) - 1);
        boolean result3 = isPalindromeUsingArrays(input);

        System.out.println("Palindrome check using iterative method: " + result1);
        System.out.println("Palindrome check using recursive method: " + result2);
        System.out.println("Palindrome check using array comparison: " + result3);
    }
}