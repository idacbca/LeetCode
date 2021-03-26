public class No188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n/2) return maxProfit_infty(prices);
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i ++) {
            for (int tk = k; tk > 0; tk --) {
                if (i - 1 == -1) {
                    dp[i][tk][1] = -prices[0];
                } else {
                    dp[i][tk][0] = Math.max(dp[i-1][tk][0], dp[i-1][tk][1] + prices[i]);
                    dp[i][tk][1] = Math.max(dp[i-1][tk][1], dp[i-1][tk-1][0] - prices[i]);
                }
            }
        }
        return dp[n-1][k][0];
    }

    private int maxProfit_infty(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price);
        }
        return dp_i_0;
    }
}
