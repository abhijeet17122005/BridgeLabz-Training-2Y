
import java.util.*;

public class PrerequisiteChecker {

    public static boolean nestedLoopCheck(int[] completed, int[] prerequisites){
        for(int i=0;i<prerequisites.length;i++){
            boolean found = false;
            for(int j=0;j<completed.length;j++){
                if(prerequisites[i] == completed[j]){
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }
        return true;
    }

    public static boolean hashSetCheck(int[] completed, int[] prerequisites){
        HashSet<Integer> set = new HashSet<>();
        for(int c : completed) set.add(c);

        for(int p : prerequisites){
            if(!set.contains(p))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] completed = {101,102,103,104,105};
        int[] prereq = {101,104};

        System.out.println("Nested Loop Check: " + nestedLoopCheck(completed, prereq));
        System.out.println("HashSet Check: " + hashSetCheck(completed, prereq));
    }
}
