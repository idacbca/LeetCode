import java.util.Arrays;

public class No1143 {
    int[][] memo;

    /* Recursive dp both O(mn) */
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    private int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dp(text1, i + 1, text2, j + 1);
        } else {
            memo[i][j] = Math.max(
                dp(text1, i + 1, text2, j),
                dp(text1, i, text2, j + 1)
            );
        }
        return memo[i][j];
    }

    /* Iterate both O(mn) */
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                }
            }
        }
        return memo[m][n];
    }

    /* State compression, space O(n) */
    public int longestCommonSubsequence3(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] memo = new int[n + 1];

        for (int i = 1; i <= m; i ++) {
            int pre = 0;
            for (int j = 1; j <= n; j ++) {
                int temp = memo[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //memo[i][j] = 1 + memo[i - 1][j - 1];
                    memo[j] = 1 + pre;
                } else {
                    //memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                    memo[j] = Math.max(memo[j - 1], memo[j]);
                }
                pre = temp;
            }
        }
        return memo[n];
    }
}
