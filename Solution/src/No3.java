import java.util.HashMap;
import java.util.Map;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                left ++;
                window.put(c1, window.get(c1) - 1);
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
