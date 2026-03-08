package easy;

import java.util.Scanner;

/**
 * 买卖股票的最佳时机
 */
public class maxProfit {
    private static int maxProfit(int[] prices) {
        int res = 0, minPrice = prices[0];
        for (int p : prices) {
            res = Math.max(res, p - minPrice);
            minPrice = Math.min(p, minPrice);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] prices = new int[split.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(split[i]);
        }
        System.out.println(maxProfit(prices));
    }
}
