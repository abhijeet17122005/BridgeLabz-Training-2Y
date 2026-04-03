import java.util.*;


public class SumArrRecursion {
    
public static int recursionArr(int[] arr,int n){
    if(n==0){
        return 0;
    }
    return arr[n-1] + recursionArr(arr, n-1);
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(recursionArr(arr, n));
    }
}
