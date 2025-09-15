import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeating(String text) {
        int[] freq = new int[256];
        int length = getLength(text);

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (freq[c] == 1) {
                return c;
            }
        }

        return '\0';
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

        char result = findFirstNonRepeating(input);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}