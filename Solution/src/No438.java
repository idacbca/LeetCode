import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new LinkedList<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid ++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char c1 = s.charAt(left);
                left ++;
                if (need.containsKey(c1)) {
                    if (need.get(c1).equals(window.get(c1))) {
                        valid --;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return res;
    }
}
