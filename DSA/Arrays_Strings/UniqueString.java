// Take a string from the user and check if all the values are unique.
import java.util.*;
public class UniqueString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        boolean isUnique = true;

        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                isUnique = false;
                break;
            } else {
                map.put(ch, 1);
            }
        }

        if (isUnique) {
            System.out.println("All characters are unique.");
        } else {
            System.out.println("Duplicate characters found.");
        }
    }
}
