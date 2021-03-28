public class No198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[n];
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        int dp_0 = 0; // i - 2 day
        int dp_1 = 0; // i - 1 day
        int dp_2 = 0; // i day

        for (int i = 1; i <= n; i ++) {
            dp_2 = Math.max(dp_1, dp_0 + nums[i - 1]);
            dp_0 = dp_1;
            dp_1 = dp_2;
        }
        return dp_2;
    }
}
