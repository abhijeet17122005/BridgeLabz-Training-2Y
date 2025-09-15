import java.util.Scanner;
public class CharacterClassifier {
    public static String classifyChar(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }
    public static String[][] classifyString(String str) {
        int len = str.length();
        String[][] result = new String[len][2];
        for (int i = 0; i < len; i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = classifyChar(str.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = classifyString(input);
        System.out.println("Char\tType");
        for (String[] pair : result) {
            System.out.println(pair[0] + "\t" + pair[1]);
        }
    }
}