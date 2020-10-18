package leetcode.array;

public class BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        BestTimeToBuyAndSellStockIV sln = new BestTimeToBuyAndSellStockIV();
        System.out.println(sln.maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (len < 2 || k <= 0)
            return 0;

        int profit = 0;
        if (k > len / 2) {
            for (int i = 1; i < len; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }

        int[][] localProfit = new int[len][k + 1];
        int[][] globalProfit = new int[len][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                localProfit[i][j] = Math.max(
                        globalProfit[i - 1][j - 1] + Math.max(diff, 0),
                        localProfit[i - 1][j] + diff);
                globalProfit[i][j] = Math.max(globalProfit[i - 1][j], localProfit[i][j]);
            }
        }
        return globalProfit[len - 1][k];
    }

}
