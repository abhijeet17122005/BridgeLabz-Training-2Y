public class recursionArrTail {

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
