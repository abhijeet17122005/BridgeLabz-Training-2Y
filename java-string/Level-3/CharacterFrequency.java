import java.util.Scanner;

public class CharacterFrequency {

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

    public static String[][] findFrequencies(String text) {
        int[] freq = new int[256];
        int length = getLength(text);

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        boolean[] added = new boolean[256];
        String[][] result = new String[length][2];
        int index = 0;

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (!added[c]) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                added[c] = true;
                index++;
            }
        }

        String[][] finalResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }

        return finalResult;
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

        String[][] frequencies = findFrequencies(input);
        displayFrequencies(frequencies);
    }
}