public class No55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int longest = 0;
        for (int i = 0; i < n; i ++) {
            if (longest < i) return false;
            longest = Math.max(longest, nums[i] + i);
        }
        return longest >= n - 1;
    }
}
