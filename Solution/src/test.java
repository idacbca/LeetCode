import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
    public void test1() {
        String s = "aa";
        String t = "aa";
        String res = minWindow(s, t);
        Assert.assertEquals("aa", res);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        int start = 0, end = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            while (valid == need.size()) {
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                char c1 = s.charAt(left);
                left ++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid --;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

    @Test
    public void test2() {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        Assert.assertEquals(10, LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
    }

    static int LCSubStr(char[] X, char[] Y, int m, int n) {
        int[] LCStuff = new int[n + 1];

        int result = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = n; j >= 0; j--) {
                if (i == 0 || j == 0)
                    LCStuff[j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    LCStuff[j] = LCStuff[j - 1] + 1;
                    result = Integer.max(result, LCStuff[j]);
                } else
                    LCStuff[j] = 0;
            }
        }
        return result;
    }
}
