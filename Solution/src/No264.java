import java.util.HashSet;
import java.util.PriorityQueue;

public class No264 {
    /* Time: O(nlogn), Space: O(n) */
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        heap.add(1L);
        seen.add(1L);
        long cur = 1L;
        for (int i = 0; i < n; i ++) {
            cur = heap.poll();
            for (int factor : factors) {
                long nex = cur * factor;
                if (seen.add(nex)) {
                    heap.offer(nex);
                }
            }
        }
        return (int) cur;
    }

    /* Dynamic programming Time: O(n), Space: O(n) */
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p1 = 1, p2 = 1, p3 = 1;
        for (int i = 2; i <= n; i ++) {
            int num1 = dp[p1] * 2, num2 = dp[p2] * 3, num3 = dp[p3] * 5;
            dp[i] = Math.min(Math.min(num1, num2), num3);
            if (dp[i] == num1) {
                p1 ++;
            }
            if (dp[i] == num2) {
                p2 ++;
            }
            if (dp[i] == num3) {
                p3 ++;
            }
        }
        return dp[n];
    }
}
