import java.util.Scanner;

public class WordLengthMapper {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }
    public static String[] splitWords(String str) {
        return str.split(" ");
    }
    public static String[][] mapWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] mapped = mapWordLengths(words);
        System.out.println("Word\tLength");
        for (String[] pair : mapped) {
            System.out.println(pair[0] + "\t" + Integer.parseInt(pair[1]));
        }
    }
}