import java.util.HashMap;
import java.util.Map;

public class No87 {
    int[][][] memo;
    String S1, S2;
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        memo = new int[n][n][n + 1];
        S1 = s1;
        S2 = s2;
        return dp(0, 0, n);
    }

    private boolean dp(int i1, int i2, int length) {
        if (memo[i1][i2][length] != 0) {
            return memo[i1][i2][length] == 1;
        }

        if (S1.substring(i1, i1 + length).equals(S2.substring(i2, i2 + length))) {
            memo[i1][i2][length] = 1;
            return true;
        }

        if (!isSimilar(i1, i2, length)) {
            memo[i1][i2][length] = -1;
            return false;
        }

        for (int i = 1; i < length; i++) {
            if (dp(i1, i2, i) && dp(i1 + i, i2 + i, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
            if (dp(i1, i2 + length - i, i) && dp(i1 + i, i2, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
        }
        memo[i1][i2][length] = -1;
        return false;
    }

    private boolean isSimilar(int i1, int i2, int length) {
        Map<Character, Integer> dict = new HashMap<>();

        for (int i = i1; i < i1 + length; i++) {
            char c = S1.charAt(i);
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        for (int i = i2; i < i2 + length; i++) {
            char c = S2.charAt(i);
            dict.put(c, dict.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : dict.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
