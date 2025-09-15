import java.util.Scanner;

public class FrequencyUsingUniqueChars {

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

    public static char[] getUniqueCharacters(String text) {
        int length = getLength(text);
        char[] unique = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[uniqueCount++] = current;
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    public static String[][] getFrequencies(String text) {
        int[] freq = new int[256];
        int length = getLength(text);

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        char[] uniqueChars = getUniqueCharacters(text);
        int uniqueLength = getLength(new String(uniqueChars));
        String[][] result = new String[uniqueLength][2];

        for (int i = 0; i < uniqueLength; i++) {
            char c = uniqueChars[i];
            result[i][0] = String.valueOf(c);
            result[i][1] = String.valueOf(freq[c]);
        }

        return result;
    }

    public static void displayFrequencies(String[][] freqArray) {
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        System.out.println("------------------------");
        for (int i = 0; i < freqArray.length; i++) {
            System.out.printf("%-10s %-10s%n", freqArray[i][0], freqArray[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] frequencies = getFrequencies(input);
        displayFrequencies(frequencies);
    }
}