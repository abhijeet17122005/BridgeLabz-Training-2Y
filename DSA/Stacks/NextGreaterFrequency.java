import java.util.*;
class NextGreaterFrequency {
    public static int[] nextGreaterFrequency(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   freq.get(stack.peek()) <= freq.get(arr[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
 
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 3, 2, 1};

        int[] res = nextGreaterFrequency(arr);

        System.out.println(Arrays.toString(res));
    }
}