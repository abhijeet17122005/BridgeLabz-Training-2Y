import java.util.*;
public class MaxToys {

    public static int maxToys(int[] prices, int budget) {
        Arrays.sort(prices);

        int count = 0;
        int sum = 0;

        for (int price : prices) {
            if (sum + price > budget)
                break;

            sum += price;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] prices = {1, 12, 5, 111, 200, 1000, 10};
        int budget = 50;

        System.out.println(maxToys(prices, budget));
    }
}
