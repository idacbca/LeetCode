import java.util.HashMap;
import java.util.Map;

public class No76 {
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
}
