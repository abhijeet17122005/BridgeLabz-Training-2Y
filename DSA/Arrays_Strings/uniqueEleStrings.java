// approach: The code defines a Java program that checks if all characters in a given string are unique. It uses a HashMap to track the characters that have been seen so far. If a character is found that already exists in the map, it sets a flag to false and breaks out of the loop. Finally, it prints whether all characters in the string are unique or not.


import java.util.*;

class uniqueEleStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        boolean unique = true;

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                unique = false;
                break;
            }
            map.put(c, 1);
        }

        System.out.println(unique);
    }
}

