
import java.util.*;

public class UsernameSearchComparison {

    public static boolean linearSearch(String[] arr, String key){
        for(String s : arr){
            if(s.equals(key))
                return true;
        }
        return false;
    }

    public static boolean binarySearch(String[] arr, String key){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int cmp = arr[mid].compareTo(key);

            if(cmp == 0) return true;
            else if(cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static boolean hashSearch(HashSet<String> set, String key){
        return set.contains(key);
    }

    public static void main(String[] args){
        String[] users = {"alice","bob","charlie","david","emma"};
        Arrays.sort(users);

        HashSet<String> set = new HashSet<>(Arrays.asList(users));

        System.out.println("Linear Search: " + linearSearch(users,"charlie"));
        System.out.println("Binary Search: " + binarySearch(users,"charlie"));
        System.out.println("Hash Search: " + hashSearch(set,"charlie"));
    }
}