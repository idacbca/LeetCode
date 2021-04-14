import java.util.HashMap;
import java.util.Map;

public class No887 {
    /* Naive approach, times out (O(kn^2)) */
    Map<Integer, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (k == 1) return n;
        if (n == 0) return 0;
        int key = n * 100 + k;
        if (memo.containsKey(key)) return memo.get(key);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i ++) {
            res = Math.min(res, Math.max(dp(k - 1, i - 1), dp(k, n - i)) + 1);
        }
        memo.put(key, res);
        return res;
    }

    /* Binary search O(k * n * log n), time: O(kn) */
    public int superEggDrop2(int k, int n) {
        return dp2(k, n);
    }

    private int dp2(int k, int n) {
        if (k == 1) return n;
        if (n == 0) return 0;
        int key = n * 100 + k;
        if (memo.containsKey(key)) return memo.get(key);

        int res = Integer.MAX_VALUE;
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int broken = dp2(k - 1, mid - 1) + 1;
            int notBroken = dp2(k, n - mid) + 1;
            if (broken < notBroken) {
                res = Math.min(res, notBroken);
                lo = mid + 1;
            } else {
                res = Math.min(res, broken);
                hi = mid - 1;
            }
        }
        memo.put(key, res);
        return res;
    }

    /* Another way O(kn) */
    public int superEggDrop3(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        int m = 0;
        // has k eggs, can drop m times at most,
        // dp[k][m] is the most floors that can be tested
        while (dp[k][m] < n) {
            m ++;
            for (int i = 1; i <= k; i ++) {
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }
        return m;
    }
}
