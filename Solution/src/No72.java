import java.util.Arrays;

public class No72 {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i - 1, s2, j - 1);
            return memo[i][j];
        } else {
            memo[i][j] = min(
                    dp(s1, i, s2, j - 1) + 1,
                    dp(s1, i - 1, s2, j) + 1,
                    dp(s1, i - 1, s2, j - 1) + 1
            );
            return memo[i][j];
        }
    }

    /* Iterate */
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i ++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j ++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i][j - 1] + 1,
                            dp[i - 1][j] + 1,
                            dp[i - 1][j - 1] + 1
                    );
                }
            }
        }

        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
