import java.util.*;
public class sumArr {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};
        int[] sum = new int[a.length];

        for(int i = 0; i < a.length; i++){
            sum[i] = a[i] + b[i];
        }

        System.out.println(Arrays.toString(sum));
    }
}


