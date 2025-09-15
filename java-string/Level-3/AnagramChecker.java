import java.util.Scanner;
public class AnagramChecker {

    public static boolean isAnagram(String text1, String text2) {
        if (getLength(text1) != getLength(text2)) return false;

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < getLength(text1); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) return false;
        }

        return true;
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
        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();
        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();

        boolean result = isAnagram(text1, text2);
        System.out.println("Are the two texts anagrams? " + result);
    }
}