import java.util.*;
class Solution {
    public int[] NextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of nums1: ");
        int n = sc.nextInt();
        int[] nums1 = new int[n];
        System.out.println("Enter elements of nums1:");
        for(int i = 0; i < n; i++){
            nums1[i] = sc.nextInt();
        }
        System.out.print("Enter size of nums2: ");
        int m = sc.nextInt();
        int[] nums2 = new int[m];
        System.out.println("Enter elements of nums2:");
        for(int i = 0; i < m; i++){
            nums2[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] result = obj.NextGreaterElement(nums1, nums2);
        System.out.println("Next Greater Elements:");
        for(int x : result){
            System.out.print(x + " ");
        }
        sc.close();
    }
}