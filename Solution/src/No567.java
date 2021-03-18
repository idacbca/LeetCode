import java.util.HashMap;
import java.util.Map;

public class No567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need, window;
        need = new HashMap<>();
        window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid ++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char c1 = s2.charAt(left);
                left ++;
                if (need.containsKey(c1)) {
                    if (need.get(c1).equals(window.get(c1))) {
                        valid --;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }

        return false;
    }
}
