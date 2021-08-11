import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (freq[j] != 0) {
                    sb.append((char) ('a' + j));
                    sb.append(freq[j]);
                }
            }
            String key = sb.toString();
            List<String> temp = anagrams.getOrDefault(key, new LinkedList<>());
            temp.add(str);
            anagrams.put(key, temp);
        }
        return new LinkedList<>(anagrams.values());
    }
}
