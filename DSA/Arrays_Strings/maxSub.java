// import java.util.*;
// public class maxSub {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i = 0 ; i < n ; i++){
//             arr[i] = sc.nextInt();
//         }
//         int curSum = arr[0];
//         int maxSum = arr[0];
//         for(int i = 1 ; i < arr.length; i++){
//             if(curSum<0){
//                 curSum = arr[i];
//             }
//             else{
//                 curSum = curSum + arr[i];
//             }
//             if(curSum>maxSum){
//                 maxSum = curSum;
//             }
//         }
//         System.out.println(maxSum);
//     }
// }

// alternate


import java.util.*;
public class maxSub{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int maxSum=arr[0];
        int curSum=arr[0];
        for(int i=1;i<n;i++){
            curSum=Math.max(curSum + arr[i],arr[i]);
            maxSum=Math.max(maxSum,curSum);
        }
        System.out.println(maxSum);
    }
    
}