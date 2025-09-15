import java.util.Scanner;
public class MinMaxWordFinder {
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
    public static int[] findMinMax(String[][] wordData) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < wordData.length; i++) {
            int len = Integer.parseInt(wordData[i][1]);
            if (len < min) {
                min = len;
                minIndex = i;
            }
            if (len > max) {
                max = len;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] mapped = mapWordLengths(words);
        int[] minMax = findMinMax(mapped);
        System.out.println("Shortest Word: " + mapped[minMax[0]][0]);
        System.out.println("Longest Word: " + mapped[minMax[1]][0]);
    }
}