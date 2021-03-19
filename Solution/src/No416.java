import java.util.Arrays;

public class No416 {

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        int n = nums.length, sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i ++) {
            Arrays.fill(dp[i], false);
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= sum; j ++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    /* State Compression */
    public boolean canPartition1(int[] nums) {
        if (nums.length == 1) return false;
        int n = nums.length, sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = sum; j >= 0; j--) {
                if (j >= num)
                    dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }
}
