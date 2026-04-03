import java.util.*;
class altPosNeg {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, -5, 6, -7, 8};
        int[] pos = new int[arr.length];
        int[] neg = new int[arr.length];
        int p = 0, n = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0)
                pos[p++] = arr[i];
            else
                neg[n++] = arr[i];
        }

        int i = 0, j = 0, k = 0;
        int[] result = new int[arr.length];

        while(i < p && j < n){
            result[k++] = pos[i++];
            result[k++] = neg[j++];
        }

        while(i < p)
            result[k++] = pos[i++];

        while(j < n)
            result[k++] = neg[j++];

        System.out.println(Arrays.toString(result));
    }
}
