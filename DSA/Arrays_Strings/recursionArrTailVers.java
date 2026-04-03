public class recursionArrTailVers {

    public static int recursionArrTail(int[] arr, int n, int sum) {
        if (n == 0) {
            return sum;
        }
        return recursionArrTail(arr, n - 1, sum + arr[n - 1]);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        System.out.println(recursionArrTail(arr, n, 0));
    }
}


// dry-run example:
// arr = [1, 2, 3, 4, 5]   
// n = 5, sum = 0
// recursionArrTail(arr, 4, 0 + 5) -> recursionArrTail(arr, 4, 5)
// n = 4, sum = 5  
// recursionArrTail(arr, 3, 5 + 4) -> recursionArrTail(arr, 3, 9)
// n = 3, sum = 9
// recursionArrTail(arr, 2, 9 + 3) -> recursionArrTail(arr, 2, 12)
// n = 2, sum = 12
// recursionArrTail(arr, 1, 12 + 2) -> recursionArrTail(arr, 1, 14)
// n = 1, sum = 14
// recursionArrTail(arr, 0, 14 + 1) -> recursionArrTail(arr, 0, 15)
// n = 0, sum = 15
