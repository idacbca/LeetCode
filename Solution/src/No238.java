public class No238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = L[i] * R[i];
        }
        return ret;
    }

    /* Space O(1) */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] ret = new int[n];
        L[0] = 1;
        int R = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            ret[i] = L[i] * R;
            R = R * nums[i];
        }
        return ret;
    }
}
