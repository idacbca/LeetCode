public class No213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robBetween(nums, 0, n - 2), robBetween(nums, 1, n - 1));
    }

    private int robBetween(int[] nums, int start, int end) {
        int dp_0 = 0, dp_1 = 0, dp_2 = 0;
        for (int i = start; i <= end; i ++) {
            dp_2 = Math.max(dp_1, dp_0 + nums[i]);
            dp_0 = dp_1;
            dp_1 = dp_2;
        }
        return dp_2;
    }
}
