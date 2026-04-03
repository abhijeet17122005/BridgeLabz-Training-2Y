import java.util.*;

class PreviousGreater {

    public static int[] previousGreater(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){

            // Remove smaller elements
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            // If stack empty → no greater element
            if(stack.isEmpty()){
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push current element
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int[] res = previousGreater(arr);

        System.out.println("Previous Greater Elements:");
        for(int x : res){
            System.out.print(x + " ");
        }

        sc.close();
    }
}