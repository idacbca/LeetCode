import java.util.Arrays;
import java.util.Comparator;

public class No354 {
    class SortEnvelope implements Comparator<int[]> {
        public int compare(int[] e1, int[] e2) {
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new SortEnvelope());
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 1;
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
